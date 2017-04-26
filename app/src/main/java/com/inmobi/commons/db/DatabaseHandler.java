package com.inmobi.commons.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;

public abstract class DatabaseHandler extends SQLiteOpenHelper {
   public static final String DATABASE_NAME = "im.db";
   private static String c = "CREATE TABLE IF NOT EXISTS ";
   private static String d = "DROP TABLE IF EXISTS ";
   private static String e = " PRIMARY KEY ";
   private static String f = " AUTOINCREMENT ";
   private static String g = " NOT NULL ";
   private static String h = "SELECT * FROM ";
   private static String i = " WHERE ";
   private static String j = " ORDER BY ";
   private static String k = "; ";
   private static String l = " Limit ?";
   private ArrayList a;
   private SQLiteDatabase b;

   protected DatabaseHandler(Context var1, ArrayList var2) {
      super(var1, "im.db", (CursorFactory)null, 1);
      this.a = var2;
   }

   private void a(SQLiteDatabase param1) {
      // $FF: Couldn't be decompiled
   }

   public void close() {
      try {
         this.b.close();
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Failed to close  db", var2);
      }
   }

   public int delete(String var1, String var2, String[] var3) {
      synchronized(this){}
      boolean var7 = false;

      int var4;
      try {
         var7 = true;
         var4 = this.b.delete(var1, var2, var3);
         var7 = false;
         return var4;
      } catch (Exception var8) {
         Log.internal("[InMobi]-4.5.2", "Failed to insert to db", var8);
         var7 = false;
      } finally {
         if(var7) {
            ;
         }
      }

      var4 = -1;
      return var4;
   }

   public Cursor executeQuery(String var1, String[] var2) {
      synchronized(this){}
      boolean var5 = false;

      Cursor var8;
      try {
         var5 = true;
         var8 = this.b.rawQuery(var1, var2);
         var5 = false;
         return var8;
      } catch (Exception var6) {
         Log.internal("[InMobi]-4.5.2", "Failed to execute db query", var6);
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      var8 = null;
      return var8;
   }

   public Cursor getAll(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public Cursor getNRows(String param1, String param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public int getNoOfRows(String param1, String param2, String[] param3) {
      // $FF: Couldn't be decompiled
   }

   public Cursor getRow(String param1, String param2, String[] param3) {
      // $FF: Couldn't be decompiled
   }

   protected int getTableSize(String var1) {
      synchronized(this){}
      boolean var5 = false;

      int var2;
      try {
         var5 = true;
         Cursor var8 = this.b.rawQuery(h + var1 + k, (String[])null);
         var2 = var8.getCount();
         var8.close();
         var5 = false;
         return var2;
      } catch (Exception var6) {
         Log.internal("[InMobi]-4.5.2", "Failed to table size ", var6);
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      var2 = 0;
      return var2;
   }

   public long insert(String var1, ContentValues var2) {
      synchronized(this){}
      boolean var7 = false;

      long var3;
      try {
         var7 = true;
         var3 = this.b.insert(var1, (String)null, var2);
         var7 = false;
         return var3;
      } catch (Exception var8) {
         Log.internal("[InMobi]-4.5.2", "Failed to insert to db", var8);
         var7 = false;
      } finally {
         if(var7) {
            ;
         }
      }

      var3 = -1L;
      return var3;
   }

   public void onCreate(SQLiteDatabase var1) {
      try {
         this.a(var1);
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Exception Creating table", var2);
      }
   }

   public void onUpgrade(SQLiteDatabase param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void open() {
      try {
         this.b = this.getWritableDatabase();
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Failed to open  db", var2);
      }
   }

   public long update(String var1, ContentValues var2, String var3, String[] var4) {
      synchronized(this){}
      boolean var10 = false;

      int var5;
      long var6;
      label53: {
         try {
            var10 = true;
            var5 = this.b.update(var1, var2, var3, var4);
            var10 = false;
            break label53;
         } catch (Exception var11) {
            Log.internal("[InMobi]-4.5.2", "Failed to insert to db", var11);
            var10 = false;
         } finally {
            if(var10) {
               ;
            }
         }

         var6 = -1L;
         return var6;
      }

      var6 = (long)var5;
      return var6;
   }
}
