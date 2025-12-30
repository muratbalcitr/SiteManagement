package com.balancetech.sitemanagement.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.balancetech.sitemanagement.data.dao.ApartmentDao;
import com.balancetech.sitemanagement.data.dao.ApartmentDao_Impl;
import com.balancetech.sitemanagement.data.dao.BlockDao;
import com.balancetech.sitemanagement.data.dao.BlockDao_Impl;
import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao;
import com.balancetech.sitemanagement.data.dao.ExtraPaymentDao_Impl;
import com.balancetech.sitemanagement.data.dao.FeeDao;
import com.balancetech.sitemanagement.data.dao.FeeDao_Impl;
import com.balancetech.sitemanagement.data.dao.NotificationDao;
import com.balancetech.sitemanagement.data.dao.NotificationDao_Impl;
import com.balancetech.sitemanagement.data.dao.PaymentDao;
import com.balancetech.sitemanagement.data.dao.PaymentDao_Impl;
import com.balancetech.sitemanagement.data.dao.UnitDao;
import com.balancetech.sitemanagement.data.dao.UnitDao_Impl;
import com.balancetech.sitemanagement.data.dao.UserDao;
import com.balancetech.sitemanagement.data.dao.UserDao_Impl;
import com.balancetech.sitemanagement.data.dao.WaterBillDao;
import com.balancetech.sitemanagement.data.dao.WaterBillDao_Impl;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao;
import com.balancetech.sitemanagement.data.dao.WaterMeterDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile ApartmentDao _apartmentDao;

  private volatile BlockDao _blockDao;

  private volatile UnitDao _unitDao;

  private volatile FeeDao _feeDao;

  private volatile PaymentDao _paymentDao;

  private volatile WaterMeterDao _waterMeterDao;

  private volatile WaterBillDao _waterBillDao;

  private volatile ExtraPaymentDao _extraPaymentDao;

  private volatile NotificationDao _notificationDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `name` TEXT NOT NULL, `phone` TEXT, `role` TEXT NOT NULL, `apartmentId` TEXT, `unitId` TEXT, `createdAt` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `apartments` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `blockCount` INTEGER NOT NULL, `totalUnits` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `blocks` (`id` TEXT NOT NULL, `apartmentId` TEXT NOT NULL, `name` TEXT NOT NULL, `floorCount` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `units` (`id` TEXT NOT NULL, `apartmentId` TEXT NOT NULL, `blockId` TEXT, `unitNumber` TEXT NOT NULL, `floor` INTEGER NOT NULL, `area` REAL NOT NULL, `landShare` REAL NOT NULL, `ownerType` TEXT NOT NULL, `ownerName` TEXT, `ownerPhone` TEXT, `createdAt` INTEGER NOT NULL, `isActive` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `fees` (`id` TEXT NOT NULL, `apartmentId` TEXT NOT NULL, `unitId` TEXT NOT NULL, `month` INTEGER NOT NULL, `year` INTEGER NOT NULL, `amount` REAL NOT NULL, `paidAmount` REAL NOT NULL, `status` TEXT NOT NULL, `dueDate` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `extra_payments` (`id` TEXT NOT NULL, `apartmentId` TEXT NOT NULL, `unitId` TEXT, `title` TEXT NOT NULL, `description` TEXT, `amount` REAL NOT NULL, `type` TEXT NOT NULL, `installmentCount` INTEGER NOT NULL, `currentInstallment` INTEGER NOT NULL, `paidAmount` REAL NOT NULL, `status` TEXT NOT NULL, `dueDate` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `water_meters` (`id` TEXT NOT NULL, `unitId` TEXT NOT NULL, `meterNumber` TEXT NOT NULL, `previousReading` REAL NOT NULL, `currentReading` REAL NOT NULL, `unitPrice` REAL NOT NULL, `lastReadingDate` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `water_bills` (`id` TEXT NOT NULL, `unitId` TEXT NOT NULL, `waterMeterId` TEXT NOT NULL, `month` INTEGER NOT NULL, `year` INTEGER NOT NULL, `previousReading` REAL NOT NULL, `currentReading` REAL NOT NULL, `consumption` REAL NOT NULL, `unitPrice` REAL NOT NULL, `amount` REAL NOT NULL, `sharedAmount` REAL NOT NULL, `totalAmount` REAL NOT NULL, `paidAmount` REAL NOT NULL, `status` TEXT NOT NULL, `dueDate` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `payments` (`id` TEXT NOT NULL, `unitId` TEXT NOT NULL, `feeId` TEXT, `extraPaymentId` TEXT, `waterBillId` TEXT, `amount` REAL NOT NULL, `paymentDate` INTEGER NOT NULL, `paymentMethod` TEXT NOT NULL, `description` TEXT, `createdBy` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `notifications` (`id` TEXT NOT NULL, `userId` TEXT NOT NULL, `title` TEXT NOT NULL, `message` TEXT NOT NULL, `type` TEXT NOT NULL, `isRead` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c2cc36b5c77a348f1c9e3ce288ac1bfe')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `apartments`");
        db.execSQL("DROP TABLE IF EXISTS `blocks`");
        db.execSQL("DROP TABLE IF EXISTS `units`");
        db.execSQL("DROP TABLE IF EXISTS `fees`");
        db.execSQL("DROP TABLE IF EXISTS `extra_payments`");
        db.execSQL("DROP TABLE IF EXISTS `water_meters`");
        db.execSQL("DROP TABLE IF EXISTS `water_bills`");
        db.execSQL("DROP TABLE IF EXISTS `payments`");
        db.execSQL("DROP TABLE IF EXISTS `notifications`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(10);
        _columnsUsers.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("apartmentId", new TableInfo.Column("apartmentId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("unitId", new TableInfo.Column("unitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.balancetech.sitemanagement.data.entity.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsApartments = new HashMap<String, TableInfo.Column>(7);
        _columnsApartments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("blockCount", new TableInfo.Column("blockCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("totalUnits", new TableInfo.Column("totalUnits", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsApartments.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysApartments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesApartments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoApartments = new TableInfo("apartments", _columnsApartments, _foreignKeysApartments, _indicesApartments);
        final TableInfo _existingApartments = TableInfo.read(db, "apartments");
        if (!_infoApartments.equals(_existingApartments)) {
          return new RoomOpenHelper.ValidationResult(false, "apartments(com.balancetech.sitemanagement.data.entity.Apartment).\n"
                  + " Expected:\n" + _infoApartments + "\n"
                  + " Found:\n" + _existingApartments);
        }
        final HashMap<String, TableInfo.Column> _columnsBlocks = new HashMap<String, TableInfo.Column>(5);
        _columnsBlocks.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBlocks.put("apartmentId", new TableInfo.Column("apartmentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBlocks.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBlocks.put("floorCount", new TableInfo.Column("floorCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBlocks.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBlocks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBlocks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBlocks = new TableInfo("blocks", _columnsBlocks, _foreignKeysBlocks, _indicesBlocks);
        final TableInfo _existingBlocks = TableInfo.read(db, "blocks");
        if (!_infoBlocks.equals(_existingBlocks)) {
          return new RoomOpenHelper.ValidationResult(false, "blocks(com.balancetech.sitemanagement.data.entity.Block).\n"
                  + " Expected:\n" + _infoBlocks + "\n"
                  + " Found:\n" + _existingBlocks);
        }
        final HashMap<String, TableInfo.Column> _columnsUnits = new HashMap<String, TableInfo.Column>(12);
        _columnsUnits.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("apartmentId", new TableInfo.Column("apartmentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("blockId", new TableInfo.Column("blockId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("unitNumber", new TableInfo.Column("unitNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("floor", new TableInfo.Column("floor", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("area", new TableInfo.Column("area", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("landShare", new TableInfo.Column("landShare", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("ownerType", new TableInfo.Column("ownerType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("ownerName", new TableInfo.Column("ownerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("ownerPhone", new TableInfo.Column("ownerPhone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUnits.put("isActive", new TableInfo.Column("isActive", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUnits = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUnits = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUnits = new TableInfo("units", _columnsUnits, _foreignKeysUnits, _indicesUnits);
        final TableInfo _existingUnits = TableInfo.read(db, "units");
        if (!_infoUnits.equals(_existingUnits)) {
          return new RoomOpenHelper.ValidationResult(false, "units(com.balancetech.sitemanagement.data.entity.Unit).\n"
                  + " Expected:\n" + _infoUnits + "\n"
                  + " Found:\n" + _existingUnits);
        }
        final HashMap<String, TableInfo.Column> _columnsFees = new HashMap<String, TableInfo.Column>(11);
        _columnsFees.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("apartmentId", new TableInfo.Column("apartmentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("month", new TableInfo.Column("month", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("year", new TableInfo.Column("year", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("paidAmount", new TableInfo.Column("paidAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFees.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFees = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFees = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFees = new TableInfo("fees", _columnsFees, _foreignKeysFees, _indicesFees);
        final TableInfo _existingFees = TableInfo.read(db, "fees");
        if (!_infoFees.equals(_existingFees)) {
          return new RoomOpenHelper.ValidationResult(false, "fees(com.balancetech.sitemanagement.data.entity.Fee).\n"
                  + " Expected:\n" + _infoFees + "\n"
                  + " Found:\n" + _existingFees);
        }
        final HashMap<String, TableInfo.Column> _columnsExtraPayments = new HashMap<String, TableInfo.Column>(14);
        _columnsExtraPayments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("apartmentId", new TableInfo.Column("apartmentId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("unitId", new TableInfo.Column("unitId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("installmentCount", new TableInfo.Column("installmentCount", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("currentInstallment", new TableInfo.Column("currentInstallment", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("paidAmount", new TableInfo.Column("paidAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsExtraPayments.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysExtraPayments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesExtraPayments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoExtraPayments = new TableInfo("extra_payments", _columnsExtraPayments, _foreignKeysExtraPayments, _indicesExtraPayments);
        final TableInfo _existingExtraPayments = TableInfo.read(db, "extra_payments");
        if (!_infoExtraPayments.equals(_existingExtraPayments)) {
          return new RoomOpenHelper.ValidationResult(false, "extra_payments(com.balancetech.sitemanagement.data.entity.ExtraPayment).\n"
                  + " Expected:\n" + _infoExtraPayments + "\n"
                  + " Found:\n" + _existingExtraPayments);
        }
        final HashMap<String, TableInfo.Column> _columnsWaterMeters = new HashMap<String, TableInfo.Column>(8);
        _columnsWaterMeters.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("meterNumber", new TableInfo.Column("meterNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("previousReading", new TableInfo.Column("previousReading", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("currentReading", new TableInfo.Column("currentReading", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("lastReadingDate", new TableInfo.Column("lastReadingDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterMeters.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWaterMeters = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWaterMeters = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWaterMeters = new TableInfo("water_meters", _columnsWaterMeters, _foreignKeysWaterMeters, _indicesWaterMeters);
        final TableInfo _existingWaterMeters = TableInfo.read(db, "water_meters");
        if (!_infoWaterMeters.equals(_existingWaterMeters)) {
          return new RoomOpenHelper.ValidationResult(false, "water_meters(com.balancetech.sitemanagement.data.entity.WaterMeter).\n"
                  + " Expected:\n" + _infoWaterMeters + "\n"
                  + " Found:\n" + _existingWaterMeters);
        }
        final HashMap<String, TableInfo.Column> _columnsWaterBills = new HashMap<String, TableInfo.Column>(16);
        _columnsWaterBills.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("waterMeterId", new TableInfo.Column("waterMeterId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("month", new TableInfo.Column("month", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("year", new TableInfo.Column("year", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("previousReading", new TableInfo.Column("previousReading", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("currentReading", new TableInfo.Column("currentReading", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("consumption", new TableInfo.Column("consumption", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("unitPrice", new TableInfo.Column("unitPrice", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("sharedAmount", new TableInfo.Column("sharedAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("totalAmount", new TableInfo.Column("totalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("paidAmount", new TableInfo.Column("paidAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterBills.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWaterBills = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWaterBills = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWaterBills = new TableInfo("water_bills", _columnsWaterBills, _foreignKeysWaterBills, _indicesWaterBills);
        final TableInfo _existingWaterBills = TableInfo.read(db, "water_bills");
        if (!_infoWaterBills.equals(_existingWaterBills)) {
          return new RoomOpenHelper.ValidationResult(false, "water_bills(com.balancetech.sitemanagement.data.entity.WaterBill).\n"
                  + " Expected:\n" + _infoWaterBills + "\n"
                  + " Found:\n" + _existingWaterBills);
        }
        final HashMap<String, TableInfo.Column> _columnsPayments = new HashMap<String, TableInfo.Column>(11);
        _columnsPayments.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("unitId", new TableInfo.Column("unitId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("feeId", new TableInfo.Column("feeId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("extraPaymentId", new TableInfo.Column("extraPaymentId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("waterBillId", new TableInfo.Column("waterBillId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("amount", new TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("paymentDate", new TableInfo.Column("paymentDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("paymentMethod", new TableInfo.Column("paymentMethod", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("createdBy", new TableInfo.Column("createdBy", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPayments.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPayments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPayments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPayments = new TableInfo("payments", _columnsPayments, _foreignKeysPayments, _indicesPayments);
        final TableInfo _existingPayments = TableInfo.read(db, "payments");
        if (!_infoPayments.equals(_existingPayments)) {
          return new RoomOpenHelper.ValidationResult(false, "payments(com.balancetech.sitemanagement.data.entity.Payment).\n"
                  + " Expected:\n" + _infoPayments + "\n"
                  + " Found:\n" + _existingPayments);
        }
        final HashMap<String, TableInfo.Column> _columnsNotifications = new HashMap<String, TableInfo.Column>(7);
        _columnsNotifications.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotifications.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotifications = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotifications = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotifications = new TableInfo("notifications", _columnsNotifications, _foreignKeysNotifications, _indicesNotifications);
        final TableInfo _existingNotifications = TableInfo.read(db, "notifications");
        if (!_infoNotifications.equals(_existingNotifications)) {
          return new RoomOpenHelper.ValidationResult(false, "notifications(com.balancetech.sitemanagement.data.entity.Notification).\n"
                  + " Expected:\n" + _infoNotifications + "\n"
                  + " Found:\n" + _existingNotifications);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c2cc36b5c77a348f1c9e3ce288ac1bfe", "51cb3276853575863c77339f33c4b63b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","apartments","blocks","units","fees","extra_payments","water_meters","water_bills","payments","notifications");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `apartments`");
      _db.execSQL("DELETE FROM `blocks`");
      _db.execSQL("DELETE FROM `units`");
      _db.execSQL("DELETE FROM `fees`");
      _db.execSQL("DELETE FROM `extra_payments`");
      _db.execSQL("DELETE FROM `water_meters`");
      _db.execSQL("DELETE FROM `water_bills`");
      _db.execSQL("DELETE FROM `payments`");
      _db.execSQL("DELETE FROM `notifications`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ApartmentDao.class, ApartmentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BlockDao.class, BlockDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UnitDao.class, UnitDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FeeDao.class, FeeDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PaymentDao.class, PaymentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WaterMeterDao.class, WaterMeterDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WaterBillDao.class, WaterBillDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ExtraPaymentDao.class, ExtraPaymentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(NotificationDao.class, NotificationDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public ApartmentDao apartmentDao() {
    if (_apartmentDao != null) {
      return _apartmentDao;
    } else {
      synchronized(this) {
        if(_apartmentDao == null) {
          _apartmentDao = new ApartmentDao_Impl(this);
        }
        return _apartmentDao;
      }
    }
  }

  @Override
  public BlockDao blockDao() {
    if (_blockDao != null) {
      return _blockDao;
    } else {
      synchronized(this) {
        if(_blockDao == null) {
          _blockDao = new BlockDao_Impl(this);
        }
        return _blockDao;
      }
    }
  }

  @Override
  public UnitDao unitDao() {
    if (_unitDao != null) {
      return _unitDao;
    } else {
      synchronized(this) {
        if(_unitDao == null) {
          _unitDao = new UnitDao_Impl(this);
        }
        return _unitDao;
      }
    }
  }

  @Override
  public FeeDao feeDao() {
    if (_feeDao != null) {
      return _feeDao;
    } else {
      synchronized(this) {
        if(_feeDao == null) {
          _feeDao = new FeeDao_Impl(this);
        }
        return _feeDao;
      }
    }
  }

  @Override
  public PaymentDao paymentDao() {
    if (_paymentDao != null) {
      return _paymentDao;
    } else {
      synchronized(this) {
        if(_paymentDao == null) {
          _paymentDao = new PaymentDao_Impl(this);
        }
        return _paymentDao;
      }
    }
  }

  @Override
  public WaterMeterDao waterMeterDao() {
    if (_waterMeterDao != null) {
      return _waterMeterDao;
    } else {
      synchronized(this) {
        if(_waterMeterDao == null) {
          _waterMeterDao = new WaterMeterDao_Impl(this);
        }
        return _waterMeterDao;
      }
    }
  }

  @Override
  public WaterBillDao waterBillDao() {
    if (_waterBillDao != null) {
      return _waterBillDao;
    } else {
      synchronized(this) {
        if(_waterBillDao == null) {
          _waterBillDao = new WaterBillDao_Impl(this);
        }
        return _waterBillDao;
      }
    }
  }

  @Override
  public ExtraPaymentDao extraPaymentDao() {
    if (_extraPaymentDao != null) {
      return _extraPaymentDao;
    } else {
      synchronized(this) {
        if(_extraPaymentDao == null) {
          _extraPaymentDao = new ExtraPaymentDao_Impl(this);
        }
        return _extraPaymentDao;
      }
    }
  }

  @Override
  public NotificationDao notificationDao() {
    if (_notificationDao != null) {
      return _notificationDao;
    } else {
      synchronized(this) {
        if(_notificationDao == null) {
          _notificationDao = new NotificationDao_Impl(this);
        }
        return _notificationDao;
      }
    }
  }
}
