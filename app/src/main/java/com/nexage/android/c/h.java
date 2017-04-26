package com.nexage.android.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

final class h extends SQLiteOpenHelper {
   private static final String a = "Nexage_" + com.nexage.android.b.c() + "_Cache.db";

   h(Context var1) {
      super(var1, a, (CursorFactory)null, 16);
   }

   public final void onCreate(SQLiteDatabase var1) {
      var1.execSQL("CREATE TABLE reqTable(seq INTEGER PRIMARY KEY,pos TEXT,svcTimestamp INTEGER,svcRespTime INTEGER,st INTEGER,buyer TEXT,pru TEXT,flushTs INTEGER,json TEXT,a TEXT)");
      var1.execSQL("CREATE TABLE clickTable(seq INTEGER PRIMARY KEY,pos TEXT,posSeq INTEGER,ts INTEGER,tagId TEXT,flushTs INTEGER,a TEXT)");
      var1.execSQL("CREATE TABLE diplayTable(seq INTEGER PRIMARY KEY,pos TEXT,posSeq INTEGER,ts INTEGER,tagId TEXT,buyer TEXT,pru TEXT,flushTs INTEGER,a TEXT)");
   }

   public final void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
      com.nexage.android.a.p.c("ReportPersist", "Re-created DB");
      var1.execSQL("DROP TABLE IF EXISTS reqTable");
      var1.execSQL("DROP TABLE IF EXISTS clickTable");
      var1.execSQL("DROP TABLE IF EXISTS diplayTable");
      this.onCreate(var1);
   }
}
