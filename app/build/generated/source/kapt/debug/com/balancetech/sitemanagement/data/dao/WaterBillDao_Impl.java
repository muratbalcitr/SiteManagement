package com.balancetech.sitemanagement.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.balancetech.sitemanagement.data.entity.WaterBill;
import com.balancetech.sitemanagement.data.model.PaymentStatus;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WaterBillDao_Impl implements WaterBillDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WaterBill> __insertionAdapterOfWaterBill;

  private final EntityDeletionOrUpdateAdapter<WaterBill> __deletionAdapterOfWaterBill;

  private final EntityDeletionOrUpdateAdapter<WaterBill> __updateAdapterOfWaterBill;

  public WaterBillDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWaterBill = new EntityInsertionAdapter<WaterBill>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `water_bills` (`id`,`unitId`,`waterMeterId`,`month`,`year`,`previousReading`,`currentReading`,`consumption`,`unitPrice`,`amount`,`wastewaterAmount`,`environmentalTax`,`vat`,`sharedAmount`,`totalAmount`,`paidAmount`,`status`,`dueDate`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterBill entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getUnitId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUnitId());
        }
        if (entity.getWaterMeterId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getWaterMeterId());
        }
        statement.bindLong(4, entity.getMonth());
        statement.bindLong(5, entity.getYear());
        statement.bindDouble(6, entity.getPreviousReading());
        statement.bindDouble(7, entity.getCurrentReading());
        statement.bindDouble(8, entity.getConsumption());
        statement.bindDouble(9, entity.getUnitPrice());
        statement.bindDouble(10, entity.getAmount());
        statement.bindDouble(11, entity.getWastewaterAmount());
        statement.bindDouble(12, entity.getEnvironmentalTax());
        statement.bindDouble(13, entity.getVat());
        statement.bindDouble(14, entity.getSharedAmount());
        statement.bindDouble(15, entity.getTotalAmount());
        statement.bindDouble(16, entity.getPaidAmount());
        statement.bindString(17, __PaymentStatus_enumToString(entity.getStatus()));
        statement.bindLong(18, entity.getDueDate());
        statement.bindLong(19, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfWaterBill = new EntityDeletionOrUpdateAdapter<WaterBill>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `water_bills` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterBill entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfWaterBill = new EntityDeletionOrUpdateAdapter<WaterBill>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `water_bills` SET `id` = ?,`unitId` = ?,`waterMeterId` = ?,`month` = ?,`year` = ?,`previousReading` = ?,`currentReading` = ?,`consumption` = ?,`unitPrice` = ?,`amount` = ?,`wastewaterAmount` = ?,`environmentalTax` = ?,`vat` = ?,`sharedAmount` = ?,`totalAmount` = ?,`paidAmount` = ?,`status` = ?,`dueDate` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterBill entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getUnitId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getUnitId());
        }
        if (entity.getWaterMeterId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getWaterMeterId());
        }
        statement.bindLong(4, entity.getMonth());
        statement.bindLong(5, entity.getYear());
        statement.bindDouble(6, entity.getPreviousReading());
        statement.bindDouble(7, entity.getCurrentReading());
        statement.bindDouble(8, entity.getConsumption());
        statement.bindDouble(9, entity.getUnitPrice());
        statement.bindDouble(10, entity.getAmount());
        statement.bindDouble(11, entity.getWastewaterAmount());
        statement.bindDouble(12, entity.getEnvironmentalTax());
        statement.bindDouble(13, entity.getVat());
        statement.bindDouble(14, entity.getSharedAmount());
        statement.bindDouble(15, entity.getTotalAmount());
        statement.bindDouble(16, entity.getPaidAmount());
        statement.bindString(17, __PaymentStatus_enumToString(entity.getStatus()));
        statement.bindLong(18, entity.getDueDate());
        statement.bindLong(19, entity.getCreatedAt());
        if (entity.getId() == null) {
          statement.bindNull(20);
        } else {
          statement.bindString(20, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertWaterBill(final WaterBill waterBill, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWaterBill.insert(waterBill);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteWaterBill(final WaterBill waterBill, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWaterBill.handle(waterBill);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateWaterBill(final WaterBill waterBill, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWaterBill.handle(waterBill);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object getWaterBillById(final String id, final Continuation<? super WaterBill> arg1) {
    final String _sql = "SELECT * FROM water_bills WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WaterBill>() {
      @Override
      @Nullable
      public WaterBill call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfWaterMeterId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterMeterId");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfConsumption = CursorUtil.getColumnIndexOrThrow(_cursor, "consumption");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfWastewaterAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "wastewaterAmount");
          final int _cursorIndexOfEnvironmentalTax = CursorUtil.getColumnIndexOrThrow(_cursor, "environmentalTax");
          final int _cursorIndexOfVat = CursorUtil.getColumnIndexOrThrow(_cursor, "vat");
          final int _cursorIndexOfSharedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "sharedAmount");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final WaterBill _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpWaterMeterId;
            if (_cursor.isNull(_cursorIndexOfWaterMeterId)) {
              _tmpWaterMeterId = null;
            } else {
              _tmpWaterMeterId = _cursor.getString(_cursorIndexOfWaterMeterId);
            }
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpConsumption;
            _tmpConsumption = _cursor.getDouble(_cursorIndexOfConsumption);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final double _tmpWastewaterAmount;
            _tmpWastewaterAmount = _cursor.getDouble(_cursorIndexOfWastewaterAmount);
            final double _tmpEnvironmentalTax;
            _tmpEnvironmentalTax = _cursor.getDouble(_cursorIndexOfEnvironmentalTax);
            final double _tmpVat;
            _tmpVat = _cursor.getDouble(_cursorIndexOfVat);
            final double _tmpSharedAmount;
            _tmpSharedAmount = _cursor.getDouble(_cursorIndexOfSharedAmount);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new WaterBill(_tmpId,_tmpUnitId,_tmpWaterMeterId,_tmpMonth,_tmpYear,_tmpPreviousReading,_tmpCurrentReading,_tmpConsumption,_tmpUnitPrice,_tmpAmount,_tmpWastewaterAmount,_tmpEnvironmentalTax,_tmpVat,_tmpSharedAmount,_tmpTotalAmount,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<WaterBill>> getWaterBillsByUnit(final String unitId) {
    final String _sql = "SELECT * FROM water_bills WHERE unitId = ? ORDER BY year DESC, month DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_bills"}, new Callable<List<WaterBill>>() {
      @Override
      @NonNull
      public List<WaterBill> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfWaterMeterId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterMeterId");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfConsumption = CursorUtil.getColumnIndexOrThrow(_cursor, "consumption");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfWastewaterAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "wastewaterAmount");
          final int _cursorIndexOfEnvironmentalTax = CursorUtil.getColumnIndexOrThrow(_cursor, "environmentalTax");
          final int _cursorIndexOfVat = CursorUtil.getColumnIndexOrThrow(_cursor, "vat");
          final int _cursorIndexOfSharedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "sharedAmount");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<WaterBill> _result = new ArrayList<WaterBill>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WaterBill _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpWaterMeterId;
            if (_cursor.isNull(_cursorIndexOfWaterMeterId)) {
              _tmpWaterMeterId = null;
            } else {
              _tmpWaterMeterId = _cursor.getString(_cursorIndexOfWaterMeterId);
            }
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpConsumption;
            _tmpConsumption = _cursor.getDouble(_cursorIndexOfConsumption);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final double _tmpWastewaterAmount;
            _tmpWastewaterAmount = _cursor.getDouble(_cursorIndexOfWastewaterAmount);
            final double _tmpEnvironmentalTax;
            _tmpEnvironmentalTax = _cursor.getDouble(_cursorIndexOfEnvironmentalTax);
            final double _tmpVat;
            _tmpVat = _cursor.getDouble(_cursorIndexOfVat);
            final double _tmpSharedAmount;
            _tmpSharedAmount = _cursor.getDouble(_cursorIndexOfSharedAmount);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new WaterBill(_tmpId,_tmpUnitId,_tmpWaterMeterId,_tmpMonth,_tmpYear,_tmpPreviousReading,_tmpCurrentReading,_tmpConsumption,_tmpUnitPrice,_tmpAmount,_tmpWastewaterAmount,_tmpEnvironmentalTax,_tmpVat,_tmpSharedAmount,_tmpTotalAmount,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WaterBill>> getWaterBillsByMonth(final int month, final int year) {
    final String _sql = "SELECT * FROM water_bills WHERE month = ? AND year = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, month);
    _argIndex = 2;
    _statement.bindLong(_argIndex, year);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_bills"}, new Callable<List<WaterBill>>() {
      @Override
      @NonNull
      public List<WaterBill> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfWaterMeterId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterMeterId");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfConsumption = CursorUtil.getColumnIndexOrThrow(_cursor, "consumption");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfWastewaterAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "wastewaterAmount");
          final int _cursorIndexOfEnvironmentalTax = CursorUtil.getColumnIndexOrThrow(_cursor, "environmentalTax");
          final int _cursorIndexOfVat = CursorUtil.getColumnIndexOrThrow(_cursor, "vat");
          final int _cursorIndexOfSharedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "sharedAmount");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<WaterBill> _result = new ArrayList<WaterBill>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WaterBill _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpWaterMeterId;
            if (_cursor.isNull(_cursorIndexOfWaterMeterId)) {
              _tmpWaterMeterId = null;
            } else {
              _tmpWaterMeterId = _cursor.getString(_cursorIndexOfWaterMeterId);
            }
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpConsumption;
            _tmpConsumption = _cursor.getDouble(_cursorIndexOfConsumption);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final double _tmpWastewaterAmount;
            _tmpWastewaterAmount = _cursor.getDouble(_cursorIndexOfWastewaterAmount);
            final double _tmpEnvironmentalTax;
            _tmpEnvironmentalTax = _cursor.getDouble(_cursorIndexOfEnvironmentalTax);
            final double _tmpVat;
            _tmpVat = _cursor.getDouble(_cursorIndexOfVat);
            final double _tmpSharedAmount;
            _tmpSharedAmount = _cursor.getDouble(_cursorIndexOfSharedAmount);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new WaterBill(_tmpId,_tmpUnitId,_tmpWaterMeterId,_tmpMonth,_tmpYear,_tmpPreviousReading,_tmpCurrentReading,_tmpConsumption,_tmpUnitPrice,_tmpAmount,_tmpWastewaterAmount,_tmpEnvironmentalTax,_tmpVat,_tmpSharedAmount,_tmpTotalAmount,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<WaterBill>> getAllWaterBills() {
    final String _sql = "SELECT * FROM water_bills ORDER BY year DESC, month DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_bills"}, new Callable<List<WaterBill>>() {
      @Override
      @NonNull
      public List<WaterBill> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfWaterMeterId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterMeterId");
          final int _cursorIndexOfMonth = CursorUtil.getColumnIndexOrThrow(_cursor, "month");
          final int _cursorIndexOfYear = CursorUtil.getColumnIndexOrThrow(_cursor, "year");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfConsumption = CursorUtil.getColumnIndexOrThrow(_cursor, "consumption");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfWastewaterAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "wastewaterAmount");
          final int _cursorIndexOfEnvironmentalTax = CursorUtil.getColumnIndexOrThrow(_cursor, "environmentalTax");
          final int _cursorIndexOfVat = CursorUtil.getColumnIndexOrThrow(_cursor, "vat");
          final int _cursorIndexOfSharedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "sharedAmount");
          final int _cursorIndexOfTotalAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "totalAmount");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<WaterBill> _result = new ArrayList<WaterBill>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WaterBill _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpWaterMeterId;
            if (_cursor.isNull(_cursorIndexOfWaterMeterId)) {
              _tmpWaterMeterId = null;
            } else {
              _tmpWaterMeterId = _cursor.getString(_cursorIndexOfWaterMeterId);
            }
            final int _tmpMonth;
            _tmpMonth = _cursor.getInt(_cursorIndexOfMonth);
            final int _tmpYear;
            _tmpYear = _cursor.getInt(_cursorIndexOfYear);
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpConsumption;
            _tmpConsumption = _cursor.getDouble(_cursorIndexOfConsumption);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final double _tmpWastewaterAmount;
            _tmpWastewaterAmount = _cursor.getDouble(_cursorIndexOfWastewaterAmount);
            final double _tmpEnvironmentalTax;
            _tmpEnvironmentalTax = _cursor.getDouble(_cursorIndexOfEnvironmentalTax);
            final double _tmpVat;
            _tmpVat = _cursor.getDouble(_cursorIndexOfVat);
            final double _tmpSharedAmount;
            _tmpSharedAmount = _cursor.getDouble(_cursorIndexOfSharedAmount);
            final double _tmpTotalAmount;
            _tmpTotalAmount = _cursor.getDouble(_cursorIndexOfTotalAmount);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new WaterBill(_tmpId,_tmpUnitId,_tmpWaterMeterId,_tmpMonth,_tmpYear,_tmpPreviousReading,_tmpCurrentReading,_tmpConsumption,_tmpUnitPrice,_tmpAmount,_tmpWastewaterAmount,_tmpEnvironmentalTax,_tmpVat,_tmpSharedAmount,_tmpTotalAmount,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __PaymentStatus_enumToString(@NonNull final PaymentStatus _value) {
    switch (_value) {
      case PAID: return "PAID";
      case PARTIALLY_PAID: return "PARTIALLY_PAID";
      case UNPAID: return "UNPAID";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private PaymentStatus __PaymentStatus_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "PAID": return PaymentStatus.PAID;
      case "PARTIALLY_PAID": return PaymentStatus.PARTIALLY_PAID;
      case "UNPAID": return PaymentStatus.UNPAID;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
