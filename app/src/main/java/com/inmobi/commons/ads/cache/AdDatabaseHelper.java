package com.inmobi.commons.ads.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.inmobi.commons.internal.Log;

public class AdDatabaseHelper extends SQLiteOpenHelper {
   public static final String COLUMN_ADTYPE = "adtype";
   public static final String COLUMN_AD_CONTENT = "content";
   public static final String COLUMN_AD_ID = "adid";
   public static final String COLUMN_APPID = "appid";
   public static final String COLUMN_TIMESTAMP = "timestamp";
   public static final String DATABASE_NAME = "adcache.db";
   public static final String TABLE_AD = "ad";

   public AdDatabaseHelper(Context var1) {
      super(var1, "adcache.db", (CursorFactory)null, 1);
   }

   public void onCreate(SQLiteDatabase var1) {
      Log.internal("[InMobi]-4.5.2", "CREATE TABLE IF NOT EXISTS ad (adid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp INTEGER NOT NULL, appid VARCHAR NOT NULL, content VARCHAR NOT NULL, adtype VARCHAR NOT NULL);");
      var1.execSQL("CREATE TABLE IF NOT EXISTS ad (adid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp INTEGER NOT NULL, appid VARCHAR NOT NULL, content VARCHAR NOT NULL, adtype VARCHAR NOT NULL);");
   }

   public void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      Log.internal("[InMobi]-4.5.2", "Upgrading database from version " + var2 + " to " + var3 + ", which will destroy all old data");
      var1.execSQL("DROP TABLE IF EXISTS ad;");
      this.onCreate(var1);
   }
}
