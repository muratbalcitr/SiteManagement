const functions = require("firebase-functions");
const admin = require("firebase-admin");

admin.initializeApp();

const db = admin.firestore();

/**
 * HTTP Cloud Function - Create Fee
 * Creates a new fee for a unit
 */
exports.createFee = functions.https.onCall(async (data, context) => {
  // Check if user is authenticated
  if (!context.auth) {
    throw new functions.https.HttpsError(
        "unauthenticated",
        "User must be authenticated",
    );
  }

  try {
    const {apartmentId, unitId, month, year, amount, dueDate} = data;

    // Validate input
    if (!apartmentId || !unitId || !month || !year || !amount || !dueDate) {
      throw new functions.https.HttpsError(
          "invalid-argument",
          "Missing required fields",
      );
    }

    // Get unit to extract unit number for document ID
    const unitDoc = await db.collection("units").doc(unitId).get();
    let unitNumber = unitId; // Fallback to unitId if unit not found
    if (unitDoc.exists) {
      const unit = unitDoc.data();
      unitNumber = (unit.unitNumber || unitId).toLowerCase();
    }

    // Generate fee ID: unitNumber-month-year (e.g., "a1-1-2024")
    const feeId = `${unitNumber}-${month}-${year}`;
    
    const fee = {
      id: feeId,
      apartmentId,
      unitId,
      month,
      year,
      amount,
      paidAmount: 0,
      status: "UNPAID",
      dueDate,
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
      updatedAt: admin.firestore.FieldValue.serverTimestamp(),
    };

    await db.collection("fees").doc(feeId).set(fee);

    // Create notification for the unit owner
    await createNotificationForFee(feeId, unitId, amount, dueDate);

    return {success: true, feeId, fee};
  } catch (error) {
    console.error("Error creating fee:", error);
    throw new functions.https.HttpsError(
        "internal",
        "Failed to create fee",
        error.message,
    );
  }
});

/**
 * HTTP Cloud Function - Create Fees for All Units
 * Creates fees for all units in an apartment
 */
exports.createFeesForAllUnits = functions.https.onCall(
    async (data, context) => {
      if (!context.auth) {
        throw new functions.https.HttpsError(
            "unauthenticated",
            "User must be authenticated",
        );
      }

      try {
        const {apartmentId, month, year, baseAmount, dueDate} = data;

        if (!apartmentId || !month || !year || !baseAmount || !dueDate) {
          throw new functions.https.HttpsError(
              "invalid-argument",
              "Missing required fields",
          );
        }

        // Get all active units for the apartment
        const unitsSnapshot = await db
            .collection("units")
            .where("apartmentId", "==", apartmentId)
            .where("isActive", "==", true)
            .get();

        if (unitsSnapshot.empty) {
          return {success: true, feesCreated: 0, message: "No units found"};
        }

        const batch = db.batch();
        const fees = [];

        unitsSnapshot.forEach((doc) => {
          const unit = doc.data();
          const feeAmount = baseAmount * (unit.landShare / 100.0);
          
          // Generate fee ID: unitNumber-month-year (e.g., "a1-1-2024")
          const unitNumber = (unit.unitNumber || unit.id).toLowerCase();
          const feeId = `${unitNumber}-${month}-${year}`;

          const fee = {
            id: feeId,
            apartmentId,
            unitId: unit.id,
            month,
            year,
            amount: feeAmount,
            paidAmount: 0,
            status: "UNPAID",
            dueDate,
            createdAt: admin.firestore.FieldValue.serverTimestamp(),
            updatedAt: admin.firestore.FieldValue.serverTimestamp(),
          };

          fees.push(fee);
          batch.set(db.collection("fees").doc(feeId), fee);
        });

        await batch.commit();

        // Create notifications for all units
        for (const fee of fees) {
          await createNotificationForFee(
              fee.id,
              fee.unitId,
              fee.amount,
              fee.dueDate,
          );
        }

        return {
          success: true,
          feesCreated: fees.length,
          fees,
        };
      } catch (error) {
        console.error("Error creating fees for all units:", error);
        throw new functions.https.HttpsError(
            "internal",
            "Failed to create fees",
            error.message,
        );
      }
    },
);

/**
 * HTTP Cloud Function - Record Payment
 * Records a payment for a fee, water bill, or extra payment
 */
exports.recordPayment = functions.https.onCall(async (data, context) => {
  if (!context.auth) {
    throw new functions.https.HttpsError(
        "unauthenticated",
        "User must be authenticated",
    );
  }

  try {
    const {
      unitId,
      amount,
      paymentMethod,
      description,
      feeId,
      extraPaymentId,
      waterBillId,
      paymentId,
    } = data;

    if (!unitId || !amount || !paymentMethod) {
      throw new functions.https.HttpsError(
          "invalid-argument",
          "Missing required fields",
      );
    }

    // Use provided paymentId (based on unit and block) or generate one
    // paymentId must be in format: unit-block-{blockId}-{unitNumber}
    let finalPaymentId = paymentId;
    
    // Validate paymentId format: should be unit-block-{blockId}-{unitNumber}
    // If paymentId is not provided or not in correct format, generate a new one
    if (!finalPaymentId || finalPaymentId.trim() === "" || 
        !finalPaymentId.startsWith("unit-block-")) {
      // Get unit to create paymentId based on unit and block
      const unitDoc = await db.collection("units").doc(unitId).get();
      if (!unitDoc.exists) {
        throw new functions.https.HttpsError(
            "not-found",
            `Unit with id ${unitId} not found`,
        );
      }
      const unit = unitDoc.data();
      const unitNumber = unit?.unitNumber || unitId;
      const blockId = unit?.blockId || "unknown";
      
      finalPaymentId = `unit-block-${blockId}-${unitNumber}`;
      
      if (paymentId && paymentId.trim() !== "") {
        console.warn(`Invalid paymentId format: ${paymentId}, regenerated as: ${finalPaymentId}`);
      }
    }

    const payment = {
      id: finalPaymentId,
      unitId,
      feeId: feeId || null,
      extraPaymentId: extraPaymentId || null,
      waterBillId: waterBillId || null,
      amount,
      paymentMethod,
      description: description || null,
      createdBy: context.auth.uid,
      paymentDate: admin.firestore.FieldValue.serverTimestamp(),
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
    };

    await db.collection("payments").doc(finalPaymentId).set(payment);

    // Update fee status if payment is for a fee
    if (feeId) {
      await updateFeePaymentStatus(feeId, amount);
    }

    // Update water bill status if payment is for a water bill
    if (waterBillId) {
      await updateWaterBillPaymentStatus(waterBillId, amount);
    }

    return {success: true, paymentId: finalPaymentId, payment};
  } catch (error) {
    console.error("Error recording payment:", error);
    throw new functions.https.HttpsError(
        "internal",
        "Failed to record payment",
        error.message,
    );
  }
});

/**
 * HTTP Cloud Function - Migrate Payment Document IDs
 * Migrates all payment document IDs to unit-block-{blockId}-{unitNumber} format
 * WARNING: This function should be run once and with caution
 */
exports.migratePaymentDocumentIds = functions.https.onCall(async (data, context) => {
  if (!context.auth) {
    throw new functions.https.HttpsError(
        "unauthenticated",
        "User must be authenticated",
    );
  }

  try {
    const {dryRun = true} = data; // Default to dry run for safety
    
    console.log(`Starting payment migration (dryRun: ${dryRun})...`);
    
    // Get all payments
    const paymentsSnapshot = await db.collection("payments").get();
    const payments = paymentsSnapshot.docs;
    
    let migratedCount = 0;
    let errorCount = 0;
    const errors = [];
    const paymentIdCounter = new Map(); // Track payment count per unit for uniqueness
    
    for (const paymentDoc of payments) {
      try {
        const payment = paymentDoc.data();
        const currentDocId = paymentDoc.id;
        const unitId = payment.unitId;
        
        // Skip if already in correct format (unit-block-{blockId}-{unitNumber})
        if (currentDocId.startsWith("unit-block-")) {
          console.log(`Skipping payment ${currentDocId} - already in correct format`);
          continue;
        }
        
        // Get unit information
        if (!unitId) {
          console.warn(`Payment ${currentDocId} has no unitId, skipping...`);
          errorCount++;
          errors.push(`Payment ${currentDocId}: No unitId`);
          continue;
        }
        
        const unitDoc = await db.collection("units").doc(unitId).get();
        if (!unitDoc.exists) {
          console.warn(`Unit ${unitId} not found for payment ${currentDocId}, skipping...`);
          errorCount++;
          errors.push(`Payment ${currentDocId}: Unit ${unitId} not found`);
          continue;
        }
        
        const unit = unitDoc.data();
        const unitNumber = unit?.unitNumber || unitId;
        const blockId = unit?.blockId || "unknown";
        
        // Create base document ID
        let baseDocId = `unit-block-${blockId}-${unitNumber}`;
        
        // Check if this ID already exists (for same unit payments)
        const existingCount = paymentIdCounter.get(baseDocId) || 0;
        paymentIdCounter.set(baseDocId, existingCount + 1);
        
        // If multiple payments for same unit, add counter to make unique
        const newDocId = existingCount > 0 
            ? `${baseDocId}-${existingCount}`
            : baseDocId;
        
        // Skip if new ID is same as current
        if (newDocId === currentDocId) {
          console.log(`Payment ${currentDocId} already has correct ID, skipping...`);
          continue;
        }
        
        console.log(`Migrating payment ${currentDocId} -> ${newDocId}`);
        
        if (!dryRun) {
          // Check if new document ID already exists in database
          const existingDoc = await db.collection("payments").doc(newDocId).get();
          if (existingDoc.exists) {
            // If exists, add timestamp to make it unique
            const timestamp = Date.now();
            const uniqueDocId = `${baseDocId}-${timestamp}`;
            console.log(`Document ID ${newDocId} exists, using ${uniqueDocId} instead`);
            
            // Create new document with updated ID
            await db.collection("payments").doc(uniqueDocId).set({
              ...payment,
              id: uniqueDocId,
            });
            
            // Delete old document
            await db.collection("payments").doc(currentDocId).delete();
          } else {
            // Create new document with updated ID
            await db.collection("payments").doc(newDocId).set({
              ...payment,
              id: newDocId,
            });
            
            // Delete old document
            await db.collection("payments").doc(currentDocId).delete();
          }
        }
        
        migratedCount++;
      } catch (error) {
        console.error(`Error migrating payment ${paymentDoc.id}:`, error);
        errorCount++;
        errors.push(`Payment ${paymentDoc.id}: ${error.message}`);
      }
    }
    
    const result = {
      success: true,
      totalPayments: payments.length,
      migratedCount,
      errorCount,
      errors: errors.slice(0, 10), // Return first 10 errors
      dryRun,
      message: dryRun
          ? `Dry run completed. ${migratedCount} payments would be migrated.`
          : `Migration completed. ${migratedCount} payments migrated.`,
    };
    
    console.log("Migration result:", result);
    return result;
  } catch (error) {
    console.error("Error migrating payment document IDs:", error);
    throw new functions.https.HttpsError(
        "internal",
        "Failed to migrate payment document IDs",
        error.message,
    );
  }
});

/**
 * HTTP Cloud Function - Record Water Meter Reading
 * Records a water meter reading and creates a bill
 */
exports.recordWaterMeterReading = functions.https.onCall(
    async (data, context) => {
      if (!context.auth) {
        throw new functions.https.HttpsError(
            "unauthenticated",
            "User must be authenticated",
        );
      }

      try {
        const {unitId, currentReading} = data;

        if (!unitId || currentReading === undefined) {
          throw new functions.https.HttpsError(
              "invalid-argument",
              "Missing required fields",
          );
        }

        // Get water meter
        const waterMeterSnapshot = await db
            .collection("water_meters")
            .where("unitId", "==", unitId)
            .limit(1)
            .get();

        if (waterMeterSnapshot.empty) {
          throw new functions.https.HttpsError(
              "not-found",
              "Water meter not found",
          );
        }

        const waterMeterDoc = waterMeterSnapshot.docs[0];
        const waterMeter = waterMeterDoc.data();
        const previousReading = waterMeter.currentReading || 0;
        const consumption = currentReading - previousReading;

        if (consumption < 0) {
          throw new functions.https.HttpsError(
              "invalid-argument",
              "Current reading cannot be less than previous reading",
          );
        }

        const now = new Date();
        const month = now.getMonth() + 1;
        const year = now.getFullYear();

        const amount = consumption * (waterMeter.unitPrice || 0);
        const totalAmount = amount; // Can add shared amount later

        const waterBillId = db.collection("water_bills").doc().id;
        const waterBill = {
          id: waterBillId,
          unitId,
          waterMeterId: waterMeter.id,
          month,
          year,
          previousReading,
          currentReading,
          consumption,
          unitPrice: waterMeter.unitPrice || 0,
          amount,
          sharedAmount: 0,
          totalAmount,
          paidAmount: 0,
          status: "UNPAID",
          dueDate: now.getTime() + 30 * 24 * 60 * 60 * 1000, // 30 days
          createdAt: admin.firestore.FieldValue.serverTimestamp(),
        };

        // Update water meter
        await waterMeterDoc.ref.update({
          previousReading: waterMeter.currentReading,
          currentReading,
          lastReadingDate: admin.firestore.FieldValue.serverTimestamp(),
        });

        // Create water bill
        await db.collection("water_bills").doc(waterBillId).set(waterBill);

        // Create notification
        await createNotificationForWaterBill(waterBillId, unitId, totalAmount);

        return {success: true, waterBillId, waterBill};
      } catch (error) {
        console.error("Error recording water meter reading:", error);
        throw new functions.https.HttpsError(
            "internal",
            "Failed to record reading",
            error.message,
        );
      }
    },
);

/**
 * Helper function - Update fee payment status
 * @param {string} feeId - Fee ID
 * @param {number} paymentAmount - Payment amount
 */
async function updateFeePaymentStatus(feeId, paymentAmount) {
  const feeRef = db.collection("fees").doc(feeId);
  const feeDoc = await feeRef.get();

  if (!feeDoc.exists) {
    return;
  }

  const fee = feeDoc.data();
  const newPaidAmount = (fee.paidAmount || 0) + paymentAmount;
  let newStatus = "UNPAID";

  if (newPaidAmount >= fee.amount) {
    newStatus = "PAID";
  } else if (newPaidAmount > 0) {
    newStatus = "PARTIALLY_PAID";
  }

  await feeRef.update({
    paidAmount: newPaidAmount,
    status: newStatus,
    updatedAt: admin.firestore.FieldValue.serverTimestamp(),
  });
}

/**
 * Helper function - Update water bill payment status
 * @param {string} waterBillId - Water bill ID
 * @param {number} paymentAmount - Payment amount
 */
async function updateWaterBillPaymentStatus(waterBillId, paymentAmount) {
  const billRef = db.collection("water_bills").doc(waterBillId);
  const billDoc = await billRef.get();

  if (!billDoc.exists) {
    return;
  }

  const bill = billDoc.data();
  const newPaidAmount = (bill.paidAmount || 0) + paymentAmount;
  let newStatus = "UNPAID";

  if (newPaidAmount >= bill.totalAmount) {
    newStatus = "PAID";
  } else if (newPaidAmount > 0) {
    newStatus = "PARTIALLY_PAID";
  }

  await billRef.update({
    paidAmount: newPaidAmount,
    status: newStatus,
  });
}

/**
 * Helper function - Create notification for fee
 * @param {string} feeId - Fee ID
 * @param {string} unitId - Unit ID
 * @param {number} amount - Fee amount
 * @param {number} dueDate - Due date timestamp
 */
async function createNotificationForFee(feeId, unitId, amount, dueDate) {
  // Get unit owner
  const usersSnapshot = await db
      .collection("users")
      .where("unitId", "==", unitId)
      .where("isActive", "==", true)
      .limit(1)
      .get();

  if (usersSnapshot.empty) {
    return;
  }

  const user = usersSnapshot.docs[0].data();
  const notificationId = db.collection("notifications").doc().id;

  const notification = {
    id: notificationId,
    userId: user.id,
    title: "Yeni Aidat Oluşturuldu",
    message: `${amount} ₺ tutarında yeni bir aidat oluşturuldu.`,
    type: "fee_created",
    isRead: false,
    createdAt: admin.firestore.FieldValue.serverTimestamp(),
  };

  await db.collection("notifications").doc(notificationId).set(notification);
}

/**
 * Helper function - Create notification for water bill
 * @param {string} waterBillId - Water bill ID
 * @param {string} unitId - Unit ID
 * @param {number} totalAmount - Total amount
 */
async function createNotificationForWaterBill(
    waterBillId,
    unitId,
    totalAmount,
) {
  const usersSnapshot = await db
      .collection("users")
      .where("unitId", "==", unitId)
      .where("isActive", "==", true)
      .limit(1)
      .get();

  if (usersSnapshot.empty) {
    return;
  }

  const user = usersSnapshot.docs[0].data();
  const notificationId = db.collection("notifications").doc().id;

  const notification = {
    id: notificationId,
    userId: user.id,
    title: "Yeni Su Faturası",
    message: `${totalAmount} ₺ tutarında yeni bir su faturası oluşturuldu.`,
    type: "water_bill",
    isRead: false,
    createdAt: admin.firestore.FieldValue.serverTimestamp(),
  };

  await db.collection("notifications").doc(notificationId).set(notification);
}

/**
 * Scheduled Function - Send payment reminders
 * Runs daily at 9 AM to check for overdue payments
 */
exports.sendPaymentReminders = functions.pubsub
    .schedule("0 9 * * *")
    .timeZone("Europe/Istanbul")
    .onRun(async (context) => {
      try {
        const now = Date.now();
        const threeDaysFromNow = now + 3 * 24 * 60 * 60 * 1000;

        // Get fees that are due in 3 days and not paid
        const feesSnapshot = await db
            .collection("fees")
            .where("status", "in", ["UNPAID", "PARTIALLY_PAID"])
            .where("dueDate", "<=", threeDaysFromNow)
            .where("dueDate", ">", now)
            .get();

        const batch = db.batch();

        feesSnapshot.forEach((doc) => {
          const fee = doc.data();
          const notificationId = db.collection("notifications").doc().id;

          const notification = {
            id: notificationId,
            userId: fee.unitId, // This should be the user ID, not unit ID
            title: "Ödeme Hatırlatması",
            message: `${fee.amount} ₺ tutarında aidatınızın ödeme tarihi yaklaşıyor.`,
            type: "payment_reminder",
            isRead: false,
            createdAt: admin.firestore.FieldValue.serverTimestamp(),
          };

          batch.set(db.collection("notifications").doc(notificationId), notification);
        });

        await batch.commit();
        console.log(`Sent ${feesSnapshot.size} payment reminders`);
      } catch (error) {
        console.error("Error sending payment reminders:", error);
      }
    });

/**
 * HTTP Cloud Function - Seed Database
 * Creates initial data structure in Firestore
 * WARNING: This will create sample data. Use only for development/testing.
 */
exports.seedDatabase = functions.https.onCall(async (data, context) => {
  // Only allow authenticated admin users
  if (!context.auth) {
    throw new functions.https.HttpsError(
        "unauthenticated",
        "User must be authenticated",
    );
  }

  try {
    // Check if user is admin (you can add more sophisticated check)
    const userDoc = await db.collection("users")
        .doc(context.auth.uid)
        .get();

    // If user collection doesn't exist yet, allow first seed
    if (!userDoc.exists) {
      console.log("User collection doesn't exist, allowing seed...");
    } else if (userDoc.data().role !== "ADMIN") {
      throw new functions.https.HttpsError(
          "permission-denied",
          "Only admins can seed database",
      );
    }

    const {seedDatabase} = require("./seed");
    const result = await seedDatabase();
    return result;
  } catch (error) {
    console.error("Error seeding database:", error);
    throw new functions.https.HttpsError(
        "internal",
        "Failed to seed database",
        error.message,
    );
  }
});

