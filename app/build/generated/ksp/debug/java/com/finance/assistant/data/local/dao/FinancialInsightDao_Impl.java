package com.finance.assistant.data.local.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.finance.assistant.data.local.entity.FinancialInsightEntity;
import java.lang.Class;
import java.lang.Double;
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
public final class FinancialInsightDao_Impl implements FinancialInsightDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FinancialInsightEntity> __insertionAdapterOfFinancialInsightEntity;

  private final EntityDeletionOrUpdateAdapter<FinancialInsightEntity> __deletionAdapterOfFinancialInsightEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkAsRead;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public FinancialInsightDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFinancialInsightEntity = new EntityInsertionAdapter<FinancialInsightEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `financial_insights` (`id`,`type`,`title`,`description`,`severity`,`dateMillis`,`relatedAmount`,`isRead`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FinancialInsightEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindString(2, entity.getType());
        statement.bindString(3, entity.getTitle());
        statement.bindString(4, entity.getDescription());
        statement.bindString(5, entity.getSeverity());
        statement.bindLong(6, entity.getDateMillis());
        if (entity.getRelatedAmount() == null) {
          statement.bindNull(7);
        } else {
          statement.bindDouble(7, entity.getRelatedAmount());
        }
        final int _tmp = entity.isRead() ? 1 : 0;
        statement.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfFinancialInsightEntity = new EntityDeletionOrUpdateAdapter<FinancialInsightEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `financial_insights` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final FinancialInsightEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfMarkAsRead = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE financial_insights SET isRead = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM financial_insights";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final FinancialInsightEntity insight,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFinancialInsightEntity.insert(insight);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertAll(final List<FinancialInsightEntity> insights,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFinancialInsightEntity.insert(insights);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final FinancialInsightEntity insight,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfFinancialInsightEntity.handle(insight);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markAsRead(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkAsRead.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfMarkAsRead.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<FinancialInsightEntity>> getAllInsights() {
    final String _sql = "SELECT * FROM financial_insights ORDER BY dateMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"financial_insights"}, new Callable<List<FinancialInsightEntity>>() {
      @Override
      @NonNull
      public List<FinancialInsightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSeverity = CursorUtil.getColumnIndexOrThrow(_cursor, "severity");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfRelatedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedAmount");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final List<FinancialInsightEntity> _result = new ArrayList<FinancialInsightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FinancialInsightEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpSeverity;
            _tmpSeverity = _cursor.getString(_cursorIndexOfSeverity);
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final Double _tmpRelatedAmount;
            if (_cursor.isNull(_cursorIndexOfRelatedAmount)) {
              _tmpRelatedAmount = null;
            } else {
              _tmpRelatedAmount = _cursor.getDouble(_cursorIndexOfRelatedAmount);
            }
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            _item = new FinancialInsightEntity(_tmpId,_tmpType,_tmpTitle,_tmpDescription,_tmpSeverity,_tmpDateMillis,_tmpRelatedAmount,_tmpIsRead);
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
  public Flow<List<FinancialInsightEntity>> getUnreadInsights() {
    final String _sql = "SELECT * FROM financial_insights WHERE isRead = 0 ORDER BY dateMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"financial_insights"}, new Callable<List<FinancialInsightEntity>>() {
      @Override
      @NonNull
      public List<FinancialInsightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSeverity = CursorUtil.getColumnIndexOrThrow(_cursor, "severity");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfRelatedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedAmount");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final List<FinancialInsightEntity> _result = new ArrayList<FinancialInsightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FinancialInsightEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpSeverity;
            _tmpSeverity = _cursor.getString(_cursorIndexOfSeverity);
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final Double _tmpRelatedAmount;
            if (_cursor.isNull(_cursorIndexOfRelatedAmount)) {
              _tmpRelatedAmount = null;
            } else {
              _tmpRelatedAmount = _cursor.getDouble(_cursorIndexOfRelatedAmount);
            }
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            _item = new FinancialInsightEntity(_tmpId,_tmpType,_tmpTitle,_tmpDescription,_tmpSeverity,_tmpDateMillis,_tmpRelatedAmount,_tmpIsRead);
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
  public Flow<List<FinancialInsightEntity>> getInsightsBySeverity(final String severity) {
    final String _sql = "SELECT * FROM financial_insights WHERE severity = ? ORDER BY dateMillis DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, severity);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"financial_insights"}, new Callable<List<FinancialInsightEntity>>() {
      @Override
      @NonNull
      public List<FinancialInsightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfSeverity = CursorUtil.getColumnIndexOrThrow(_cursor, "severity");
          final int _cursorIndexOfDateMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "dateMillis");
          final int _cursorIndexOfRelatedAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "relatedAmount");
          final int _cursorIndexOfIsRead = CursorUtil.getColumnIndexOrThrow(_cursor, "isRead");
          final List<FinancialInsightEntity> _result = new ArrayList<FinancialInsightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final FinancialInsightEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpType;
            _tmpType = _cursor.getString(_cursorIndexOfType);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpSeverity;
            _tmpSeverity = _cursor.getString(_cursorIndexOfSeverity);
            final long _tmpDateMillis;
            _tmpDateMillis = _cursor.getLong(_cursorIndexOfDateMillis);
            final Double _tmpRelatedAmount;
            if (_cursor.isNull(_cursorIndexOfRelatedAmount)) {
              _tmpRelatedAmount = null;
            } else {
              _tmpRelatedAmount = _cursor.getDouble(_cursorIndexOfRelatedAmount);
            }
            final boolean _tmpIsRead;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRead);
            _tmpIsRead = _tmp != 0;
            _item = new FinancialInsightEntity(_tmpId,_tmpType,_tmpTitle,_tmpDescription,_tmpSeverity,_tmpDateMillis,_tmpRelatedAmount,_tmpIsRead);
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
