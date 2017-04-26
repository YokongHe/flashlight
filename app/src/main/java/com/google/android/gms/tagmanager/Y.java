package com.google.android.gms.tagmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.io.File;

final class Y extends SQLiteOpenHelper {
   // $FF: synthetic field
   final com.google.android.gms.tagmanager.X a;

   Y(com.google.android.gms.tagmanager.X var1, Context var2, String var3) {
      super(var2, var3, (CursorFactory)null, 1);
      this.a = var1;
   }

   private static boolean a(String param0, SQLiteDatabase param1) {
      // $FF: Couldn't be decompiled
   }

   public final SQLiteDatabase getWritableDatabase() {
      SQLiteDatabase var1 = null;

      SQLiteDatabase var2;
      label17: {
         try {
            var2 = super.getWritableDatabase();
         } catch (SQLiteException var3) {
            com.google.android.gms.tagmanager.X.b(this.a).getDatabasePath("google_tagmanager.db").delete();
            break label17;
         }

         var1 = var2;
      }

      var2 = var1;
      if(var1 == null) {
         var2 = super.getWritableDatabase();
      }

      return var2;
   }

   public final void onCreate(SQLiteDatabase var1) {
      String var2 = var1.getPath();
      if(com.google.android.gms.tagmanager.l.a() >= 9) {
         File var3 = new File(var2);
         var3.setReadable(false, false);
         var3.setWritable(false, false);
         var3.setReadable(true, true);
         var3.setWritable(true, true);
      }
   }

   public final void onOpen(SQLiteDatabase param1) {
      // $FF: Couldn't be decompiled
   }

   public final void onUpgrade(SQLiteDatabase var1, int var2, int var3) {
   }
}
