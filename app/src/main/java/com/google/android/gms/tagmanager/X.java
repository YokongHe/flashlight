package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

final class X implements com.google.android.gms.tagmanager.e {
   private static final String a = String.format("CREATE TABLE IF NOT EXISTS %s ( \'%s\' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \'%s\' STRING NOT NULL, \'%s\' BLOB NOT NULL, \'%s\' INTEGER NOT NULL);", new Object[]{"datalayer", "ID", "key", "value", "expires"});
   private final Executor b;
   private final Context c;
   private com.google.android.gms.tagmanager.Y d;
   private com.google.android.gms.internal.cQ e;
   private int f;

   public X(Context var1) {
      this(var1, com.google.android.gms.internal.cR.b(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
   }

   private X(Context var1, com.google.android.gms.internal.cQ var2, String var3, int var4, Executor var5) {
      this.c = var1;
      this.e = var2;
      this.f = 2000;
      this.b = var5;
      this.d = new com.google.android.gms.tagmanager.Y(this, this.c, var3);
   }

   private SQLiteDatabase a(String var1) {
      try {
         SQLiteDatabase var2 = this.d.getWritableDatabase();
         return var2;
      } catch (SQLiteException var3) {
         com.google.android.gms.tagmanager.n.b(var1);
         return null;
      }
   }

   private static Object a(byte[] param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static String a() {
      return a;
   }

   private List a(int param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(long var1) {
      SQLiteDatabase var4 = this.a("Error opening database for deleteOlderThan.");
      if(var4 != null) {
         try {
            int var3 = var4.delete("datalayer", "expires <= ?", new String[]{Long.toString(var1)});
            com.google.android.gms.tagmanager.n.d("Deleted " + var3 + " expired items");
         } catch (SQLiteException var5) {
            com.google.android.gms.tagmanager.n.b("Error deleting old entries.");
         }
      }
   }

   private void a(String[] var1) {
      if(var1 != null && var1.length != 0) {
         SQLiteDatabase var2 = this.a("Error opening database for deleteEntries.");
         if(var2 != null) {
            String var3 = String.format("%s in (%s)", new Object[]{"ID", TextUtils.join(",", Collections.nCopies(var1.length, "?"))});

            try {
               var2.delete("datalayer", var3, var1);
               return;
            } catch (SQLiteException var4) {
               com.google.android.gms.tagmanager.n.b("Error deleting entries " + Arrays.toString(var1));
               return;
            }
         }
      }

   }

   private static byte[] a(Object param0) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Context b(com.google.android.gms.tagmanager.X var0) {
      return var0.c;
   }

   private List b() {
      // $FF: Couldn't be decompiled
   }

   private void b(List param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   private List c() {
      SQLiteDatabase var2 = this.a("Error opening database for loadSerialized.");
      ArrayList var1 = new ArrayList();
      if(var2 == null) {
         return var1;
      } else {
         Cursor var6 = var2.query("datalayer", new String[]{"key", "value"}, (String)null, (String[])null, (String)null, (String)null, "ID", (String)null);

         while(true) {
            boolean var4 = false;

            try {
               var4 = true;
               if(!var6.moveToNext()) {
                  var4 = false;
                  break;
               }

               var1.add(new com.google.android.gms.tagmanager.Z(var6.getString(0), var6.getBlob(1)));
               var4 = false;
            } finally {
               if(var4) {
                  var6.close();
               }
            }
         }

         var6.close();
         return var1;
      }
   }

   private void c(List var1, long var2) {
      SQLiteDatabase var4 = this.a("Error opening database for writeEntryToDatabase.");
      if(var4 != null) {
         Iterator var7 = var1.iterator();

         while(var7.hasNext()) {
            com.google.android.gms.tagmanager.Z var5 = (com.google.android.gms.tagmanager.Z)var7.next();
            ContentValues var6 = new ContentValues();
            var6.put("expires", Long.valueOf(var2));
            var6.put("key", var5.a);
            var6.put("value", var5.b);
            var4.insert("datalayer", (String)null, var6);
         }
      }

   }

   private int d() {
      // $FF: Couldn't be decompiled
   }

   private void e() {
      try {
         this.d.close();
      } catch (SQLiteException var2) {
         ;
      }
   }

   public final void a(final com.google.android.gms.tagmanager.f var1) {
      this.b.execute(new Runnable() {
         public final void run() {
            var1.a(X.this.b());
         }
      });
   }

   public final void a(List var1, final long var2) {
      final ArrayList var4 = new ArrayList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         com.google.android.gms.tagmanager.c var5 = (com.google.android.gms.tagmanager.c)var6.next();
         var4.add(new com.google.android.gms.tagmanager.Z(var5.a, a(var5.b)));
      }

      this.b.execute(new Runnable() {
         public final void run() {
            X.this.b(var4, var2);
         }
      });
   }
}
