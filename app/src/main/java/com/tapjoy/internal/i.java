package com.tapjoy.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tapjoy.internal.dd;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public final class i extends com.tapjoy.internal.ay implements com.tapjoy.internal.bc, Closeable {
   private SQLiteDatabase a;
   private final com.tapjoy.internal.bj b;
   private int c;

   public i(File var1, com.tapjoy.internal.bj var2) {
      this.a = SQLiteDatabase.openOrCreateDatabase(var1, (CursorFactory)null);
      this.b = var2;
      if(this.a.getVersion() != 1) {
         this.a.beginTransaction();

         try {
            this.a.execSQL("CREATE TABLE IF NOT EXISTS List(value BLOB)");
            this.a.setVersion(1);
            this.a.setTransactionSuccessful();
         } finally {
            this.a.endTransaction();
         }
      }

      this.c = this.a();
   }

   private int a() {
      // $FF: Couldn't be decompiled
   }

   private static Cursor a(Cursor var0) {
      if(var0 != null) {
         var0.close();
      }

      return null;
   }

   public final Object a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void b(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void clear() {
      this.a.delete("List", "1", (String[])null);
      this.c = 0;
   }

   public final void close() {
      if(this.a != null) {
         this.a.close();
         this.a = null;
      }

   }

   protected final void finalize() {
      this.close();
      super.finalize();
   }

   public final boolean offer(Object var1) {
      com.tapjoy.internal.cu.a(var1);
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();

      byte[] var7;
      try {
         this.b.a(var2, var1);
         var7 = var2.toByteArray();
      } catch (IOException var5) {
         throw new IllegalArgumentException(var5);
      } finally {
         dd.a(var2);
      }

      ContentValues var8 = new ContentValues();
      var8.put("value", var7);
      if(this.a.insert("List", (String)null, var8) == -1L) {
         return false;
      } else {
         ++this.c;
         return true;
      }
   }

   public final Object peek() {
      return this.c > 0?this.a(0):null;
   }

   public final Object poll() {
      if(this.c > 0) {
         Object var1 = this.peek();
         this.b(1);
         return var1;
      } else {
         return null;
      }
   }

   public final int size() {
      return this.c;
   }
}
