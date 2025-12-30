/**
 * Firestore Database Seed Script
 *
 * Bu script Firestore database'ini initial data ile doldurur.
 *
 * Kullanım:
 * node seed.js
 *
 * Veya Firebase Functions olarak:
 * firebase functions:shell
 * seedDatabase()
 */

const admin = require("firebase-admin");

// Firebase Admin SDK'yı initialize et (eğer henüz initialize edilmediyse)
let db;
if (admin.apps.length === 0) {
  admin.initializeApp();
  db = admin.firestore();
} else {
  // Zaten initialize edilmişse (Firebase Functions içindeyse)
  db = admin.firestore();
}

/**
 * Seed database with initial data
 */
async function seedDatabase() {
  try {
    console.log("🌱 Starting database seed...");

    // 1. Create sample apartment
    const apartmentId = "apt-001";
    const apartment = {
      id: apartmentId,
      name: "Küçükyalı Site",
      address: "Küçükyalı, İstanbul",
      blockCount: 2,
      totalUnits: 20,
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
      isActive: true,
    };
    await db.collection("apartments").doc(apartmentId).set(apartment);
    console.log("✅ Apartment created:", apartmentId);

    // 2. Create sample blocks
    const blocks = [
      {
        id: "block-001",
        apartmentId: apartmentId,
        name: "A Blok",
        floorCount: 5,
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
      },
      {
        id: "block-002",
        apartmentId: apartmentId,
        name: "B Blok",
        floorCount: 5,
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
      },
    ];

    for (const block of blocks) {
      await db.collection("blocks").doc(block.id).set(block);
      console.log("✅ Block created:", block.id);
    }

    // 3. Create sample units
    const units = [];
    for (let i = 1; i <= 10; i++) {
      units.push({
        id: `unit-${String(i).padStart(3, "0")}`,
        apartmentId: apartmentId,
        blockId: i <= 5 ? "block-001" : "block-002",
        unitNumber: `${i}`,
        floor: Math.floor((i - 1) / 2) + 1,
        area: 100 + (i * 5), // 100-145 m²
        landShare: 5.0 + (i * 0.1), // 5.0-5.9%
        ownerType: "OWNER", // OWNER, TENANT
        ownerName: `Daire ${i} Sahibi`,
        ownerPhone: `+905551234${String(i).padStart(2, "0")}`,
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
        isActive: true,
      });
    }

    for (const unit of units) {
      await db.collection("units").doc(unit.id).set(unit);
      console.log("✅ Unit created:", unit.id);
    }

    // 4. Create admin user
    const adminUser = {
      id: "user-admin-001",
      email: "admin@kucukyali.com",
      password: "admin123", // Production'da hash'lenmeli
      name: "Site Yöneticisi",
      phone: "+905551234567",
      role: "ADMIN", // ADMIN, RESIDENT, AUDITOR
      apartmentId: apartmentId,
      unitId: null,
      createdAt: admin.firestore.FieldValue.serverTimestamp(),
      isActive: true,
    };
    await db.collection("users").doc(adminUser.id).set(adminUser);
    console.log("✅ Admin user created:", adminUser.email);

    // 5. Create sample resident users
    for (let i = 0; i < 5; i++) {
      const resident = {
        id: `user-resident-${String(i + 1).padStart(3, "0")}`,
        email: `resident${i + 1}@kucukyali.com`,
        password: "resident123", // Production'da hash'lenmeli
        name: units[i].ownerName,
        phone: units[i].ownerPhone,
        role: "RESIDENT",
        apartmentId: apartmentId,
        unitId: units[i].id,
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
        isActive: true,
      };
      await db.collection("users").doc(resident.id).set(resident);
      console.log("✅ Resident user created:", resident.email);
    }

    // 6. Create sample water meters
    for (let i = 0; i < 10; i++) {
      const waterMeter = {
        id: `water-meter-${String(i + 1).padStart(3, "0")}`,
        unitId: units[i].id,
        meterNumber: `WM${String(i + 1).padStart(4, "0")}`,
        previousReading: 100 + (i * 10),
        currentReading: 100 + (i * 10),
        unitPrice: 5.0, // 5.00 ₺/m³
        lastReadingDate: admin.firestore.FieldValue.serverTimestamp(),
        createdAt: admin.firestore.FieldValue.serverTimestamp(),
      };
      await db.collection("water_meters").doc(waterMeter.id).set(waterMeter);
      console.log("✅ Water meter created:", waterMeter.meterNumber);
    }

    console.log("\n🎉 Database seed completed successfully!");
    console.log("\n📊 Summary:");
    console.log(`   - 1 Apartment`);
    console.log(`   - ${blocks.length} Blocks`);
    console.log(`   - ${units.length} Units`);
    console.log(`   - 6 Users (1 Admin, 5 Residents)`);
    console.log(`   - ${units.length} Water Meters`);

    return {success: true};
  } catch (error) {
    console.error("❌ Error seeding database:", error);
    throw error;
  }
}

// Script olarak çalıştırılıyorsa
if (require.main === module) {
  seedDatabase()
      .then(() => {
        console.log("\n✅ Seed completed!");
        process.exit(0);
      })
      .catch((error) => {
        console.error("\n❌ Seed failed:", error);
        process.exit(1);
      });
}

// Export for use in Firebase Functions
module.exports = {seedDatabase};

