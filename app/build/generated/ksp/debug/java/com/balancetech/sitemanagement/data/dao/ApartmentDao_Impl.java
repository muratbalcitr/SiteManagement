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
import com.balancetech.sitemanagement.data.entity.Apartment;
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
public final class ApartmentDao_Impl implements ApartmentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Apartment> __insertionAdapterOfApartment;

  private final EntityDeletionOrUpdateAdapter<Apartment> __deletionAdapterOfApartment;

  private final EntityDeletionOrUpdateAdapter<Apartment> __updateAdapterOfApartment;

  public ApartmentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfApartment = new EntityInsertionAdapter<Apartment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `apartments` (`id`,`name`,`address`,`blockCount`,`totalUnits`,`createdAt`,`isActive`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Apartment entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getAddress());
        statement.bindLong(4, entity.getBlockCount());
        statement.bindLong(5, entity.getTotalUnits());
        statement.bindLong(6, entity.getCreatedAt());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(7, _tmp);
      }
    };
    this.__deletionAdapterOfApartment = new EntityDeletionOrUpdateAdapter<Apartment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `apartments` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Apartment entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__updateAdapterOfApartment = new EntityDeletionOrUpdateAdapter<Apartment>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `apartments` SET `id` = ?,`name` = ?,`address` = ?,`blockCount` = ?,`totalUnits` = ?,`createdAt` = ?,`isActive` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Apartment entity) {
        statement.bindString(1, entity.getId());
        statement.bindString(2, entity.getName());
        statement.bindString(3, entity.getAddress());
        statement.bindLong(4, entity.getBlockCount());
        statement.bindLong(5, entity.getTotalUnits());
        statement.bindLong(6, entity.getCreatedAt());
        final int _tmp = entity.isActive() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindString(8, entity.getId());
      }
    };
  }

  @Override
  public Object insertApartment(final Apartment apartment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfApartment.insert(apartment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteApartment(final Apartment apartment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfApartment.handle(apartment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateApartment(final Apartment apartment,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfApartment.handle(apartment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getApartmentById(final String id,
      final Continuation<? super Apartment> $completion) {
    final String _sql = "SELECT * FROM apartments WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Apartment>() {
      @Override
      @Nullable
      public Apartment call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfBlockCount = CursorUtil.getColumnIndexOrThrow(_cursor, "blockCount");
          final int _cursorIndexOfTotalUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "totalUnits");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final Apartment _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final int _tmpBlockCount;
            _tmpBlockCount = _cursor.getInt(_cursorIndexOfBlockCount);
            final int _tmpTotalUnits;
            _tmpTotalUnits = _cursor.getInt(_cursorIndexOfTotalUnits);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _result = new Apartment(_tmpId,_tmpName,_tmpAddress,_tmpBlockCount,_tmpTotalUnits,_tmpCreatedAt,_tmpIsActive);
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
  public Flow<List<Apartment>> getAllActiveApartments() {
    final String _sql = "SELECT * FROM apartments WHERE isActive = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"apartments"}, new Callable<List<Apartment>>() {
      @Override
      @NonNull
      public List<Apartment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfBlockCount = CursorUtil.getColumnIndexOrThrow(_cursor, "blockCount");
          final int _cursorIndexOfTotalUnits = CursorUtil.getColumnIndexOrThrow(_cursor, "totalUnits");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfIsActive = CursorUtil.getColumnIndexOrThrow(_cursor, "isActive");
          final List<Apartment> _result = new ArrayList<Apartment>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Apartment _item;
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpAddress;
            _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            final int _tmpBlockCount;
            _tmpBlockCount = _cursor.getInt(_cursorIndexOfBlockCount);
            final int _tmpTotalUnits;
            _tmpTotalUnits = _cursor.getInt(_cursorIndexOfTotalUnits);
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final boolean _tmpIsActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsActive);
            _tmpIsActive = _tmp != 0;
            _item = new Apartment(_tmpId,_tmpName,_tmpAddress,_tmpBlockCount,_tmpTotalUnits,_tmpCreatedAt,_tmpIsActive);
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
