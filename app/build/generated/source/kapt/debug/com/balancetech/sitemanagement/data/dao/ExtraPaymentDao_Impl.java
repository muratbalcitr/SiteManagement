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
import com.balancetech.sitemanagement.data.entity.ExtraPayment;
import com.balancetech.sitemanagement.data.model.ExtraPaymentType;
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
public final class ExtraPaymentDao_Impl implements ExtraPaymentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ExtraPayment> __insertionAdapterOfExtraPayment;

  private final EntityDeletionOrUpdateAdapter<ExtraPayment> __deletionAdapterOfExtraPayment;

  private final EntityDeletionOrUpdateAdapter<ExtraPayment> __updateAdapterOfExtraPayment;

  public ExtraPaymentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfExtraPayment = new EntityInsertionAdapter<ExtraPayment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `extra_payments` (`id`,`apartmentId`,`unitId`,`title`,`description`,`amount`,`type`,`installmentCount`,`currentInstallment`,`paidAmount`,`status`,`dueDate`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExtraPayment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getApartmentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getApartmentId());
        }
        if (entity.getUnitId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUnitId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        statement.bindDouble(6, entity.getAmount());
        statement.bindString(7, __ExtraPaymentType_enumToString(entity.getType()));
        statement.bindLong(8, entity.getInstallmentCount());
        statement.bindLong(9, entity.getCurrentInstallment());
        statement.bindDouble(10, entity.getPaidAmount());
        statement.bindString(11, __PaymentStatus_enumToString(entity.getStatus()));
        statement.bindLong(12, entity.getDueDate());
        statement.bindLong(13, entity.getCreatedAt());
        statement.bindLong(14, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfExtraPayment = new EntityDeletionOrUpdateAdapter<ExtraPayment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `extra_payments` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExtraPayment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfExtraPayment = new EntityDeletionOrUpdateAdapter<ExtraPayment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `extra_payments` SET `id` = ?,`apartmentId` = ?,`unitId` = ?,`title` = ?,`description` = ?,`amount` = ?,`type` = ?,`installmentCount` = ?,`currentInstallment` = ?,`paidAmount` = ?,`status` = ?,`dueDate` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ExtraPayment entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getApartmentId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getApartmentId());
        }
        if (entity.getUnitId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUnitId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDescription());
        }
        statement.bindDouble(6, entity.getAmount());
        statement.bindString(7, __ExtraPaymentType_enumToString(entity.getType()));
        statement.bindLong(8, entity.getInstallmentCount());
        statement.bindLong(9, entity.getCurrentInstallment());
        statement.bindDouble(10, entity.getPaidAmount());
        statement.bindString(11, __PaymentStatus_enumToString(entity.getStatus()));
        statement.bindLong(12, entity.getDueDate());
        statement.bindLong(13, entity.getCreatedAt());
        statement.bindLong(14, entity.getUpdatedAt());
        if (entity.getId() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertExtraPayment(final ExtraPayment extraPayment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfExtraPayment.insert(extraPayment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteExtraPayment(final ExtraPayment extraPayment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfExtraPayment.handle(extraPayment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateExtraPayment(final ExtraPayment extraPayment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfExtraPayment.handle(extraPayment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getExtraPaymentById(final String id,
      final Continuation<? super ExtraPayment> $completion) {
    final String _sql = "SELECT * FROM extra_payments WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ExtraPayment>() {
      @Override
      @Nullable
      public ExtraPayment call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfInstallmentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "installmentCount");
          final int _cursorIndexOfCurrentInstallment = CursorUtil.getColumnIndexOrThrow(_cursor, "currentInstallment");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final ExtraPayment _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpApartmentId;
            if (_cursor.isNull(_cursorIndexOfApartmentId)) {
              _tmpApartmentId = null;
            } else {
              _tmpApartmentId = _cursor.getString(_cursorIndexOfApartmentId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final ExtraPaymentType _tmpType;
            _tmpType = __ExtraPaymentType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final int _tmpInstallmentCount;
            _tmpInstallmentCount = _cursor.getInt(_cursorIndexOfInstallmentCount);
            final int _tmpCurrentInstallment;
            _tmpCurrentInstallment = _cursor.getInt(_cursorIndexOfCurrentInstallment);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new ExtraPayment(_tmpId,_tmpApartmentId,_tmpUnitId,_tmpTitle,_tmpDescription,_tmpAmount,_tmpType,_tmpInstallmentCount,_tmpCurrentInstallment,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<ExtraPayment>> getExtraPaymentsByUnit(final String unitId) {
    final String _sql = "SELECT * FROM extra_payments WHERE unitId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"extra_payments"}, new Callable<List<ExtraPayment>>() {
      @Override
      @NonNull
      public List<ExtraPayment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfInstallmentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "installmentCount");
          final int _cursorIndexOfCurrentInstallment = CursorUtil.getColumnIndexOrThrow(_cursor, "currentInstallment");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<ExtraPayment> _result = new ArrayList<ExtraPayment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExtraPayment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpApartmentId;
            if (_cursor.isNull(_cursorIndexOfApartmentId)) {
              _tmpApartmentId = null;
            } else {
              _tmpApartmentId = _cursor.getString(_cursorIndexOfApartmentId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final ExtraPaymentType _tmpType;
            _tmpType = __ExtraPaymentType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final int _tmpInstallmentCount;
            _tmpInstallmentCount = _cursor.getInt(_cursorIndexOfInstallmentCount);
            final int _tmpCurrentInstallment;
            _tmpCurrentInstallment = _cursor.getInt(_cursorIndexOfCurrentInstallment);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new ExtraPayment(_tmpId,_tmpApartmentId,_tmpUnitId,_tmpTitle,_tmpDescription,_tmpAmount,_tmpType,_tmpInstallmentCount,_tmpCurrentInstallment,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<ExtraPayment>> getBuildingWideExtraPayments(final String apartmentId) {
    final String _sql = "SELECT * FROM extra_payments WHERE apartmentId = ? AND unitId IS NULL ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (apartmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, apartmentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"extra_payments"}, new Callable<List<ExtraPayment>>() {
      @Override
      @NonNull
      public List<ExtraPayment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfInstallmentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "installmentCount");
          final int _cursorIndexOfCurrentInstallment = CursorUtil.getColumnIndexOrThrow(_cursor, "currentInstallment");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<ExtraPayment> _result = new ArrayList<ExtraPayment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExtraPayment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpApartmentId;
            if (_cursor.isNull(_cursorIndexOfApartmentId)) {
              _tmpApartmentId = null;
            } else {
              _tmpApartmentId = _cursor.getString(_cursorIndexOfApartmentId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final ExtraPaymentType _tmpType;
            _tmpType = __ExtraPaymentType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final int _tmpInstallmentCount;
            _tmpInstallmentCount = _cursor.getInt(_cursorIndexOfInstallmentCount);
            final int _tmpCurrentInstallment;
            _tmpCurrentInstallment = _cursor.getInt(_cursorIndexOfCurrentInstallment);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new ExtraPayment(_tmpId,_tmpApartmentId,_tmpUnitId,_tmpTitle,_tmpDescription,_tmpAmount,_tmpType,_tmpInstallmentCount,_tmpCurrentInstallment,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<ExtraPayment>> getAllExtraPayments(final String apartmentId) {
    final String _sql = "SELECT * FROM extra_payments WHERE apartmentId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (apartmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, apartmentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"extra_payments"}, new Callable<List<ExtraPayment>>() {
      @Override
      @NonNull
      public List<ExtraPayment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfInstallmentCount = CursorUtil.getColumnIndexOrThrow(_cursor, "installmentCount");
          final int _cursorIndexOfCurrentInstallment = CursorUtil.getColumnIndexOrThrow(_cursor, "currentInstallment");
          final int _cursorIndexOfPaidAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "paidAmount");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<ExtraPayment> _result = new ArrayList<ExtraPayment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ExtraPayment _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpApartmentId;
            if (_cursor.isNull(_cursorIndexOfApartmentId)) {
              _tmpApartmentId = null;
            } else {
              _tmpApartmentId = _cursor.getString(_cursorIndexOfApartmentId);
            }
            final String _tmpUnitId;
            if (_cursor.isNull(_cursorIndexOfUnitId)) {
              _tmpUnitId = null;
            } else {
              _tmpUnitId = _cursor.getString(_cursorIndexOfUnitId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final double _tmpAmount;
            _tmpAmount = _cursor.getDouble(_cursorIndexOfAmount);
            final ExtraPaymentType _tmpType;
            _tmpType = __ExtraPaymentType_stringToEnum(_cursor.getString(_cursorIndexOfType));
            final int _tmpInstallmentCount;
            _tmpInstallmentCount = _cursor.getInt(_cursorIndexOfInstallmentCount);
            final int _tmpCurrentInstallment;
            _tmpCurrentInstallment = _cursor.getInt(_cursorIndexOfCurrentInstallment);
            final double _tmpPaidAmount;
            _tmpPaidAmount = _cursor.getDouble(_cursorIndexOfPaidAmount);
            final PaymentStatus _tmpStatus;
            _tmpStatus = __PaymentStatus_stringToEnum(_cursor.getString(_cursorIndexOfStatus));
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new ExtraPayment(_tmpId,_tmpApartmentId,_tmpUnitId,_tmpTitle,_tmpDescription,_tmpAmount,_tmpType,_tmpInstallmentCount,_tmpCurrentInstallment,_tmpPaidAmount,_tmpStatus,_tmpDueDate,_tmpCreatedAt,_tmpUpdatedAt);
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

  private String __ExtraPaymentType_enumToString(@NonNull final ExtraPaymentType _value) {
    switch (_value) {
      case MAINTENANCE: return "MAINTENANCE";
      case REPAIR: return "REPAIR";
      case OTHER: return "OTHER";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private String __PaymentStatus_enumToString(@NonNull final PaymentStatus _value) {
    switch (_value) {
      case PAID: return "PAID";
      case PARTIALLY_PAID: return "PARTIALLY_PAID";
      case UNPAID: return "UNPAID";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private ExtraPaymentType __ExtraPaymentType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "MAINTENANCE": return ExtraPaymentType.MAINTENANCE;
      case "REPAIR": return ExtraPaymentType.REPAIR;
      case "OTHER": return ExtraPaymentType.OTHER;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
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
