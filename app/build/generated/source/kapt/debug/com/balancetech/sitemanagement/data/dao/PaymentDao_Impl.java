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
import com.balancetech.sitemanagement.data.entity.Payment;
import java.lang.Class;
import java.lang.Exception;
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
public final class PaymentDao_Impl implements PaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Payment> __insertionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __deletionAdapterOfPayment;

  private final EntityDeletionOrUpdateAdapter<Payment> __updateAdapterOfPayment;

  public PaymentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPayment = new EntityInsertionAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `payments` (`id`,`unitId`,`feeId`,`extraPaymentId`,`waterBillId`,`amount`,`paymentDate`,`paymentMethod`,`description`,`createdBy`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
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
        if (entity.getFeeId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFeeId());
        }
        if (entity.getExtraPaymentId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getExtraPaymentId());
        }
        if (entity.getWaterBillId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getWaterBillId());
        }
        statement.bindDouble(6, entity.getAmount());
        statement.bindLong(7, entity.getPaymentDate());
        if (entity.getPaymentMethod() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPaymentMethod());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDescription());
        }
        if (entity.getCreatedBy() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedBy());
        }
        statement.bindLong(11, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `payments` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfPayment = new EntityDeletionOrUpdateAdapter<Payment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `payments` SET `id` = ?,`unitId` = ?,`feeId` = ?,`extraPaymentId` = ?,`waterBillId` = ?,`amount` = ?,`paymentDate` = ?,`paymentMethod` = ?,`description` = ?,`createdBy` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Payment entity) {
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
        if (entity.getFeeId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFeeId());
        }
        if (entity.getExtraPaymentId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getExtraPaymentId());
        }
        if (entity.getWaterBillId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getWaterBillId());
        }
        statement.bindDouble(6, entity.getAmount());
        statement.bindLong(7, entity.getPaymentDate());
        if (entity.getPaymentMethod() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPaymentMethod());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getDescription());
        }
        if (entity.getCreatedBy() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getCreatedBy());
        }
        statement.bindLong(11, entity.getCreatedAt());
        if (entity.getId() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertPayment(final Payment payment, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPayment.insert(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deletePayment(final Payment payment, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPayment.handle(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updatePayment(final Payment payment, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPayment.handle(payment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getPaymentById(final String id, final Continuation<? super Payment> $completion) {
    final String _sql = "SELECT * FROM payments WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Payment>() {
      @Override
      @Nullable
      public Payment call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Payment _result;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Payment>> getPaymentsByUnit(final String unitId) {
    final String _sql = "SELECT * FROM payments WHERE unitId = ? ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
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
  public Flow<List<Payment>> getPaymentsByFee(final String feeId) {
    final String _sql = "SELECT * FROM payments WHERE feeId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (feeId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, feeId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
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
  public Flow<List<Payment>> getPaymentsByExtraPayment(final String extraPaymentId) {
    final String _sql = "SELECT * FROM payments WHERE extraPaymentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (extraPaymentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, extraPaymentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
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
  public Flow<List<Payment>> getPaymentsByWaterBill(final String waterBillId) {
    final String _sql = "SELECT * FROM payments WHERE waterBillId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (waterBillId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, waterBillId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
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
  public Flow<List<Payment>> getAllPayments() {
    final String _sql = "SELECT * FROM payments ORDER BY paymentDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"payments"}, new Callable<List<Payment>>() {
      @Override
      @NonNull
      public List<Payment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfFeeId = CursorUtil.getColumnIndexOrThrow(_cursor, "feeId");
          final int _cursorIndexOfExtraPaymentId = CursorUtil.getColumnIndexOrThrow(_cursor, "extraPaymentId");
          final int _cursorIndexOfWaterBillId = CursorUtil.getColumnIndexOrThrow(_cursor, "waterBillId");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfPaymentDate = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentDate");
          final int _cursorIndexOfPaymentMethod = CursorUtil.getColumnIndexOrThrow(_cursor, "paymentMethod");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfCreatedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "createdBy");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Payment> _result = new ArrayList<Payment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Payment _item;
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
            final String _tmpFeeId;
            if (_cursor.isNull(_cursorIndexOfFeeId)) {
              _tmpFeeId = null;
            } else {
              _tmpFeeId = _cursor.getString(_cursorIndexOfFeeId);
            }
            final String _tmpExtraPaymentId;
            if (_cursor.isNull(_cursorIndexOfExtraPaymentId)) {
              _tmpExtraPaymentId = null;
            } else {
              _tmpExtraPaymentId = _cursor.getString(_cursorIndexOfExtraPaymentId);
            }
            final String _tmpWaterBillId;
            if (_cursor.isNull(_cursorIndexOfWaterBillId)) {
              _tmpWaterBillId = null;
            } else {
              _tmpWaterBillId = _cursor.getString(_cursorIndexOfWaterBillId);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final long _tmpPaymentDate;
            _tmpPaymentDate = _cursor.getLong(_cursorIndexOfPaymentDate);
            final String _tmpPaymentMethod;
            if (_cursor.isNull(_cursorIndexOfPaymentMethod)) {
              _tmpPaymentMethod = null;
            } else {
              _tmpPaymentMethod = _cursor.getString(_cursorIndexOfPaymentMethod);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpCreatedBy;
            if (_cursor.isNull(_cursorIndexOfCreatedBy)) {
              _tmpCreatedBy = null;
            } else {
              _tmpCreatedBy = _cursor.getString(_cursorIndexOfCreatedBy);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Payment(_tmpId,_tmpUnitId,_tmpFeeId,_tmpExtraPaymentId,_tmpWaterBillId,_tmpAmount,_tmpPaymentDate,_tmpPaymentMethod,_tmpDescription,_tmpCreatedBy,_tmpCreatedAt);
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
}
