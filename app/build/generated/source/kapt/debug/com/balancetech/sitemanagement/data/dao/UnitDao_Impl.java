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
import com.balancetech.sitemanagement.data.entity.Unit;
import com.balancetech.sitemanagement.data.model.OwnerType;
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
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UnitDao_Impl implements UnitDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Unit> __insertionAdapterOfUnit;

  private final EntityDeletionOrUpdateAdapter<Unit> __deletionAdapterOfUnit;

  private final EntityDeletionOrUpdateAdapter<Unit> __updateAdapterOfUnit;

  public UnitDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUnit = new EntityInsertionAdapter<Unit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `units` (`id`,`apartmentId`,`blockId`,`unitNumber`,`floor`,`area`,`landShare`,`ownerType`,`ownerName`,`ownerPhone`,`createdAt`,`isActive`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Unit entity) {
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
        if (entity.getBlockId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBlockId());
        }
        if (entity.getUnitNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUnitNumber());
        }
        statement.bindLong(5, entity.getFloor());
        statement.bindDouble(6, entity.getArea());
        statement.bindDouble(7, entity.getLandShare());
        statement.bindString(8, __OwnerType_enumToString(entity.getOwnerType()));
        if (entity.getOwnerName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOwnerName());
        }
        if (entity.getOwnerPhone() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getOwnerPhone());
        }
        statement.bindLong(11, entity.getCreatedAt());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(12, _tmp);
      }
    };
    this.__deletionAdapterOfUnit = new EntityDeletionOrUpdateAdapter<Unit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `units` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Unit entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfUnit = new EntityDeletionOrUpdateAdapter<Unit>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `units` SET `id` = ?,`apartmentId` = ?,`blockId` = ?,`unitNumber` = ?,`floor` = ?,`area` = ?,`landShare` = ?,`ownerType` = ?,`ownerName` = ?,`ownerPhone` = ?,`createdAt` = ?,`isActive` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Unit entity) {
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
        if (entity.getBlockId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getBlockId());
        }
        if (entity.getUnitNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getUnitNumber());
        }
        statement.bindLong(5, entity.getFloor());
        statement.bindDouble(6, entity.getArea());
        statement.bindDouble(7, entity.getLandShare());
        statement.bindString(8, __OwnerType_enumToString(entity.getOwnerType()));
        if (entity.getOwnerName() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getOwnerName());
        }
        if (entity.getOwnerPhone() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getOwnerPhone());
        }
        statement.bindLong(11, entity.getCreatedAt());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(12, _tmp);
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertUnit(final Unit unit, final Continuation<? super kotlin.Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<kotlin.Unit>() {
      @Override
      @NonNull
      public kotlin.Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUnit.insert(unit);
          __db.setTransactionSuccessful();
          return kotlin.Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUnit(final Unit unit, final Continuation<? super kotlin.Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<kotlin.Unit>() {
      @Override
      @NonNull
      public kotlin.Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUnit.handle(unit);
          __db.setTransactionSuccessful();
          return kotlin.Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUnit(final Unit unit, final Continuation<? super kotlin.Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<kotlin.Unit>() {
      @Override
      @NonNull
      public kotlin.Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUnit.handle(unit);
          __db.setTransactionSuccessful();
          return kotlin.Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getUnitById(final String id, final Continuation<? super Unit> $completion) {
    final String _sql = "SELECT * FROM units WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (id == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, id);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Unit>() {
      @Override
      @Nullable
      public Unit call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfBlockId = CursorUtil.getColumnIndexOrThrow(_cursor, "blockId");
          final int _cursorIndexOfUnitNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "unitNumber");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfLandShare = CursorUtil.getColumnIndexOrThrow(_cursor, "landShare");
          final int _cursorIndexOfOwnerType = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerType");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final int _cursorIndexOfOwnerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerPhone");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final Unit _result;
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
            final String _tmpBlockId;
            if (_cursor.isNull(_cursorIndexOfBlockId)) {
              _tmpBlockId = null;
            } else {
              _tmpBlockId = _cursor.getString(_cursorIndexOfBlockId);
            }
            final String _tmpUnitNumber;
            if (_cursor.isNull(_cursorIndexOfUnitNumber)) {
              _tmpUnitNumber = null;
            } else {
              _tmpUnitNumber = _cursor.getString(_cursorIndexOfUnitNumber);
            }
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final double _tmpArea;
            _tmpArea = _cursor.getDouble(_cursorIndexOfArea);
            final double _tmpLandShare;
            _tmpLandShare = _cursor.getDouble(_cursorIndexOfLandShare);
            final OwnerType _tmpOwnerType;
            _tmpOwnerType = __OwnerType_stringToEnum(_cursor.getString(_cursorIndexOfOwnerType));
            final String _tmpOwnerName;
            if (_cursor.isNull(_cursorIndexOfOwnerName)) {
              _tmpOwnerName = null;
            } else {
              _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            }
            final String _tmpOwnerPhone;
            if (_cursor.isNull(_cursorIndexOfOwnerPhone)) {
              _tmpOwnerPhone = null;
            } else {
              _tmpOwnerPhone = _cursor.getString(_cursorIndexOfOwnerPhone);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _result = new Unit(_tmpId,_tmpApartmentId,_tmpBlockId,_tmpUnitNumber,_tmpFloor,_tmpArea,_tmpLandShare,_tmpOwnerType,_tmpOwnerName,_tmpOwnerPhone,_tmpCreatedAt,_tmpIsActive);
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
  public Flow<List<Unit>> getUnitsByApartment(final String apartmentId) {
    final String _sql = "SELECT * FROM units WHERE apartmentId = ? AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (apartmentId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, apartmentId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"units"}, new Callable<List<Unit>>() {
      @Override
      @NonNull
      public List<Unit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfBlockId = CursorUtil.getColumnIndexOrThrow(_cursor, "blockId");
          final int _cursorIndexOfUnitNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "unitNumber");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfLandShare = CursorUtil.getColumnIndexOrThrow(_cursor, "landShare");
          final int _cursorIndexOfOwnerType = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerType");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final int _cursorIndexOfOwnerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerPhone");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Unit> _result = new ArrayList<Unit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Unit _item;
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
            final String _tmpBlockId;
            if (_cursor.isNull(_cursorIndexOfBlockId)) {
              _tmpBlockId = null;
            } else {
              _tmpBlockId = _cursor.getString(_cursorIndexOfBlockId);
            }
            final String _tmpUnitNumber;
            if (_cursor.isNull(_cursorIndexOfUnitNumber)) {
              _tmpUnitNumber = null;
            } else {
              _tmpUnitNumber = _cursor.getString(_cursorIndexOfUnitNumber);
            }
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final double _tmpArea;
            _tmpArea = _cursor.getDouble(_cursorIndexOfArea);
            final double _tmpLandShare;
            _tmpLandShare = _cursor.getDouble(_cursorIndexOfLandShare);
            final OwnerType _tmpOwnerType;
            _tmpOwnerType = __OwnerType_stringToEnum(_cursor.getString(_cursorIndexOfOwnerType));
            final String _tmpOwnerName;
            if (_cursor.isNull(_cursorIndexOfOwnerName)) {
              _tmpOwnerName = null;
            } else {
              _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            }
            final String _tmpOwnerPhone;
            if (_cursor.isNull(_cursorIndexOfOwnerPhone)) {
              _tmpOwnerPhone = null;
            } else {
              _tmpOwnerPhone = _cursor.getString(_cursorIndexOfOwnerPhone);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new Unit(_tmpId,_tmpApartmentId,_tmpBlockId,_tmpUnitNumber,_tmpFloor,_tmpArea,_tmpLandShare,_tmpOwnerType,_tmpOwnerName,_tmpOwnerPhone,_tmpCreatedAt,_tmpIsActive);
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
  public Flow<List<Unit>> getUnitsByBlock(final String blockId) {
    final String _sql = "SELECT * FROM units WHERE blockId = ? AND isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (blockId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, blockId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"units"}, new Callable<List<Unit>>() {
      @Override
      @NonNull
      public List<Unit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfApartmentId = CursorUtil.getColumnIndexOrThrow(_cursor, "apartmentId");
          final int _cursorIndexOfBlockId = CursorUtil.getColumnIndexOrThrow(_cursor, "blockId");
          final int _cursorIndexOfUnitNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "unitNumber");
          final int _cursorIndexOfFloor = CursorUtil.getColumnIndexOrThrow(_cursor, "floor");
          final int _cursorIndexOfArea = CursorUtil.getColumnIndexOrThrow(_cursor, "area");
          final int _cursorIndexOfLandShare = CursorUtil.getColumnIndexOrThrow(_cursor, "landShare");
          final int _cursorIndexOfOwnerType = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerType");
          final int _cursorIndexOfOwnerName = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerName");
          final int _cursorIndexOfOwnerPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "ownerPhone");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Unit> _result = new ArrayList<Unit>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Unit _item;
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
            final String _tmpBlockId;
            if (_cursor.isNull(_cursorIndexOfBlockId)) {
              _tmpBlockId = null;
            } else {
              _tmpBlockId = _cursor.getString(_cursorIndexOfBlockId);
            }
            final String _tmpUnitNumber;
            if (_cursor.isNull(_cursorIndexOfUnitNumber)) {
              _tmpUnitNumber = null;
            } else {
              _tmpUnitNumber = _cursor.getString(_cursorIndexOfUnitNumber);
            }
            final int _tmpFloor;
            _tmpFloor = _cursor.getInt(_cursorIndexOfFloor);
            final double _tmpArea;
            _tmpArea = _cursor.getDouble(_cursorIndexOfArea);
            final double _tmpLandShare;
            _tmpLandShare = _cursor.getDouble(_cursorIndexOfLandShare);
            final OwnerType _tmpOwnerType;
            _tmpOwnerType = __OwnerType_stringToEnum(_cursor.getString(_cursorIndexOfOwnerType));
            final String _tmpOwnerName;
            if (_cursor.isNull(_cursorIndexOfOwnerName)) {
              _tmpOwnerName = null;
            } else {
              _tmpOwnerName = _cursor.getString(_cursorIndexOfOwnerName);
            }
            final String _tmpOwnerPhone;
            if (_cursor.isNull(_cursorIndexOfOwnerPhone)) {
              _tmpOwnerPhone = null;
            } else {
              _tmpOwnerPhone = _cursor.getString(_cursorIndexOfOwnerPhone);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new Unit(_tmpId,_tmpApartmentId,_tmpBlockId,_tmpUnitNumber,_tmpFloor,_tmpArea,_tmpLandShare,_tmpOwnerType,_tmpOwnerName,_tmpOwnerPhone,_tmpCreatedAt,_tmpIsActive);
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

  private String __OwnerType_enumToString(@NonNull final OwnerType _value) {
    switch (_value) {
      case OWNER: return "OWNER";
      case TENANT: return "TENANT";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private OwnerType __OwnerType_stringToEnum(@NonNull final String _value) {
    switch (_value) {
      case "OWNER": return OwnerType.OWNER;
      case "TENANT": return OwnerType.TENANT;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
