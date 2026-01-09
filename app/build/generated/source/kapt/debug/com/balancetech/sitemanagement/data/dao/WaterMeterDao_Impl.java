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
import com.balancetech.sitemanagement.data.entity.WaterMeter;
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
public final class WaterMeterDao_Impl implements WaterMeterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WaterMeter> __insertionAdapterOfWaterMeter;

  private final EntityDeletionOrUpdateAdapter<WaterMeter> __deletionAdapterOfWaterMeter;

  private final EntityDeletionOrUpdateAdapter<WaterMeter> __updateAdapterOfWaterMeter;

  public WaterMeterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWaterMeter = new EntityInsertionAdapter<WaterMeter>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `water_meters` (`id`,`unitId`,`meterNumber`,`previousReading`,`currentReading`,`unitPrice`,`lastReadingDate`,`createdAt`,`unitOwner`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterMeter entity) {
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
        if (entity.getMeterNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMeterNumber());
        }
        statement.bindDouble(4, entity.getPreviousReading());
        statement.bindDouble(5, entity.getCurrentReading());
        statement.bindDouble(6, entity.getUnitPrice());
        statement.bindLong(7, entity.getLastReadingDate());
        statement.bindLong(8, entity.getCreatedAt());
        if (entity.getUnitOwner() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUnitOwner());
        }
      }
    };
    this.__deletionAdapterOfWaterMeter = new EntityDeletionOrUpdateAdapter<WaterMeter>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `water_meters` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterMeter entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfWaterMeter = new EntityDeletionOrUpdateAdapter<WaterMeter>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `water_meters` SET `id` = ?,`unitId` = ?,`meterNumber` = ?,`previousReading` = ?,`currentReading` = ?,`unitPrice` = ?,`lastReadingDate` = ?,`createdAt` = ?,`unitOwner` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final WaterMeter entity) {
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
        if (entity.getMeterNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getMeterNumber());
        }
        statement.bindDouble(4, entity.getPreviousReading());
        statement.bindDouble(5, entity.getCurrentReading());
        statement.bindDouble(6, entity.getUnitPrice());
        statement.bindLong(7, entity.getLastReadingDate());
        statement.bindLong(8, entity.getCreatedAt());
        if (entity.getUnitOwner() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getUnitOwner());
        }
        if (entity.getId() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertWaterMeter(final WaterMeter waterMeter,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWaterMeter.insert(waterMeter);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWaterMeter(final WaterMeter waterMeter,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWaterMeter.handle(waterMeter);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateWaterMeter(final WaterMeter waterMeter,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWaterMeter.handle(waterMeter);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getWaterMeterById(final String id,
      final Continuation<? super WaterMeter> $completion) {
    final String _sql = "SELECT * FROM water_meters WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WaterMeter>() {
      @Override
      @Nullable
      public WaterMeter call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfMeterNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "meterNumber");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfLastReadingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReadingDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUnitOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "unitOwner");
          final WaterMeter _result;
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
            final String _tmpMeterNumber;
            if (_cursor.isNull(_cursorIndexOfMeterNumber)) {
              _tmpMeterNumber = null;
            } else {
              _tmpMeterNumber = _cursor.getString(_cursorIndexOfMeterNumber);
            }
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final long _tmpLastReadingDate;
            _tmpLastReadingDate = _cursor.getLong(_cursorIndexOfLastReadingDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpUnitOwner;
            if (_cursor.isNull(_cursorIndexOfUnitOwner)) {
              _tmpUnitOwner = null;
            } else {
              _tmpUnitOwner = _cursor.getString(_cursorIndexOfUnitOwner);
            }
            _result = new WaterMeter(_tmpId,_tmpUnitId,_tmpMeterNumber,_tmpPreviousReading,_tmpCurrentReading,_tmpUnitPrice,_tmpLastReadingDate,_tmpCreatedAt,_tmpUnitOwner);
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
  public Object getWaterMeterByUnit(final String unitId,
      final Continuation<? super WaterMeter> $completion) {
    final String _sql = "SELECT * FROM water_meters WHERE unitId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (unitId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, unitId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WaterMeter>() {
      @Override
      @Nullable
      public WaterMeter call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfMeterNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "meterNumber");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfLastReadingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReadingDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUnitOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "unitOwner");
          final WaterMeter _result;
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
            final String _tmpMeterNumber;
            if (_cursor.isNull(_cursorIndexOfMeterNumber)) {
              _tmpMeterNumber = null;
            } else {
              _tmpMeterNumber = _cursor.getString(_cursorIndexOfMeterNumber);
            }
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final long _tmpLastReadingDate;
            _tmpLastReadingDate = _cursor.getLong(_cursorIndexOfLastReadingDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpUnitOwner;
            if (_cursor.isNull(_cursorIndexOfUnitOwner)) {
              _tmpUnitOwner = null;
            } else {
              _tmpUnitOwner = _cursor.getString(_cursorIndexOfUnitOwner);
            }
            _result = new WaterMeter(_tmpId,_tmpUnitId,_tmpMeterNumber,_tmpPreviousReading,_tmpCurrentReading,_tmpUnitPrice,_tmpLastReadingDate,_tmpCreatedAt,_tmpUnitOwner);
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
  public Flow<List<WaterMeter>> getAllWaterMeters() {
    final String _sql = "SELECT * FROM water_meters";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_meters"}, new Callable<List<WaterMeter>>() {
      @Override
      @NonNull
      public List<WaterMeter> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfUnitId = CursorUtil.getColumnIndexOrThrow(_cursor, "unitId");
          final int _cursorIndexOfMeterNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "meterNumber");
          final int _cursorIndexOfPreviousReading = CursorUtil.getColumnIndexOrThrow(_cursor, "previousReading");
          final int _cursorIndexOfCurrentReading = CursorUtil.getColumnIndexOrThrow(_cursor, "currentReading");
          final int _cursorIndexOfUnitPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "unitPrice");
          final int _cursorIndexOfLastReadingDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReadingDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUnitOwner = CursorUtil.getColumnIndexOrThrow(_cursor, "unitOwner");
          final List<WaterMeter> _result = new ArrayList<WaterMeter>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WaterMeter _item;
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
            final String _tmpMeterNumber;
            if (_cursor.isNull(_cursorIndexOfMeterNumber)) {
              _tmpMeterNumber = null;
            } else {
              _tmpMeterNumber = _cursor.getString(_cursorIndexOfMeterNumber);
            }
            final double _tmpPreviousReading;
            _tmpPreviousReading = _cursor.getDouble(_cursorIndexOfPreviousReading);
            final double _tmpCurrentReading;
            _tmpCurrentReading = _cursor.getDouble(_cursorIndexOfCurrentReading);
            final double _tmpUnitPrice;
            _tmpUnitPrice = _cursor.getDouble(_cursorIndexOfUnitPrice);
            final long _tmpLastReadingDate;
            _tmpLastReadingDate = _cursor.getLong(_cursorIndexOfLastReadingDate);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final String _tmpUnitOwner;
            if (_cursor.isNull(_cursorIndexOfUnitOwner)) {
              _tmpUnitOwner = null;
            } else {
              _tmpUnitOwner = _cursor.getString(_cursorIndexOfUnitOwner);
            }
            _item = new WaterMeter(_tmpId,_tmpUnitId,_tmpMeterNumber,_tmpPreviousReading,_tmpCurrentReading,_tmpUnitPrice,_tmpLastReadingDate,_tmpCreatedAt,_tmpUnitOwner);
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
