package com.nexage.android.c;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

final class g {
   static com.nexage.android.c.g a = null;
   private final Context b;
   private final SQLiteDatabase c;
   private final SQLiteDatabase d;
   private final SQLiteStatement e;
   private final SQLiteStatement f;
   private final SQLiteStatement g;
   private final SQLiteStatement h;
   private final SQLiteStatement i;
   private final SQLiteStatement j;
   private final SQLiteStatement k;
   private final SQLiteStatement l;
   private final SQLiteStatement m;

   private g(Context var1) {
      this.b = var1;
      com.nexage.android.c.h var2 = new com.nexage.android.c.h(this.b);
      this.d = var2.getWritableDatabase();
      this.c = var2.getReadableDatabase();
      this.e = this.d.compileStatement("insert into reqTable(pos,svcTimestamp,svcRespTime,st,buyer,pru,json,a) values(?,?,?,?,?,?,?,?)");
      this.f = this.d.compileStatement("insert into clickTable(pos,posSeq,ts,tagId,a) values(?,?,?,?,?)");
      this.g = this.d.compileStatement("insert into diplayTable(pos,posSeq,ts,tagId,buyer,pru,a) values(?,?,?,?,?,?,?)");
      this.h = this.d.compileStatement("delete from reqTable WHERE flushTs is not null");
      this.i = this.d.compileStatement("delete from clickTable WHERE flushTs is not null");
      this.j = this.d.compileStatement("delete from diplayTable WHERE flushTs is not null");
      this.k = this.d.compileStatement("update reqTable set flushTs=? WHERE flushTs is null");
      this.l = this.d.compileStatement("update clickTable set flushTs=? WHERE flushTs is null");
      this.m = this.d.compileStatement("update diplayTable set flushTs=? WHERE flushTs is null");
   }

   public static void a() {
      synchronized(com.nexage.android.c.g.class){}

      try {
         long var3 = System.currentTimeMillis();
         SQLiteStatement var7 = a.k;
         long var5 = System.currentTimeMillis();
         var7.bindLong(1, var5);
         var7.execute();
         var7 = a.l;
         var7.bindLong(1, var5);
         var7.execute();
         var7 = a.m;
         var7.bindLong(1, var5);
         var7.execute();
         com.nexage.android.a.p.c("ReportPersist", "total update time: " + (System.currentTimeMillis() - var3));
         var3 = System.currentTimeMillis();
         int var0 = a.e();
         int var1 = a.f();
         int var2 = a.g();
         com.nexage.android.a.p.c("ReportPersist", "read back total: " + var0 + " requests, " + var1 + " clicks, " + var2 + " displays, total time: " + (System.currentTimeMillis() - var3));
      } finally {
         ;
      }

   }

   static void a(Context var0) {
      synchronized(com.nexage.android.c.g.class){}

      try {
         if(a == null) {
            a = new com.nexage.android.c.g(var0);
         }
      } finally {
         ;
      }

   }

   public static void a(com.nexage.android.c.e param0) {
      // $FF: Couldn't be decompiled
   }

   public static void a(com.nexage.android.c.e param0, com.nexage.android.c.a param1) {
      // $FF: Couldn't be decompiled
   }

   public static void a(com.nexage.android.c.e param0, com.nexage.android.c.b param1) {
      // $FF: Couldn't be decompiled
   }

   static void b() {
      // $FF: Couldn't be decompiled
   }

   private int e() {
      Cursor var7 = this.c.query("reqTable", new String[]{"seq", "pos", "svcTimestamp", "svcRespTime", "buyer", "pru", "flushTs", "json", "a"}, "flushTs is not null", (String[])null, (String)null, (String)null, (String)null);
      int var1 = 0;
      int var2 = 0;
      if(var7.moveToFirst()) {
         do {
            var7.getInt(0);
            String var12 = var7.getString(1);
            long var3 = var7.getLong(2);
            var1 = var7.getInt(3);
            String var8 = var7.getString(4);
            String var9 = var7.getString(5);
            long var5 = var7.getLong(6);
            String var10 = var7.getString(7);
            String var11 = var7.getString(8);
            if(var5 <= 0L) {
               com.nexage.android.a.p.e("ReportPersist", "flushTs <= 0");
               var1 = var2;
            } else {
               com.nexage.android.c.e var13 = com.nexage.android.c.i.a.a(var12);
               var13.d = var3;
               var13.e = var1;
               var13.i = var8;
               var13.h = var9;
               var13.q = true;
               var13.j = var10;
               var13.k = var11;
               var1 = var2 + 1;
            }

            var2 = var1;
         } while(var7.moveToNext());
      }

      if(!var7.isClosed()) {
         var7.close();
      }

      if(var1 > 0) {
         com.nexage.android.a.p.c("ReportPersist", "read back " + var1 + " request records");
      }

      return var1;
   }

   private int f() {
      Cursor var8 = this.c.query("clickTable", new String[]{"seq", "pos", "posSeq", "ts", "tagId", "flushTs", "a"}, "flushTs is not null", (String[])null, (String)null, (String)null, (String)null);
      int var1 = 0;
      int var2 = 0;
      if(var8.moveToFirst()) {
         do {
            var8.getInt(0);
            String var9 = var8.getString(1);
            int var3 = var8.getInt(2);
            long var4 = var8.getLong(3);
            String var10 = var8.getString(4);
            long var6 = var8.getLong(5);
            String var11 = var8.getString(6);
            var1 = var2;
            if(var6 > 0L) {
               com.nexage.android.c.a var13 = new com.nexage.android.c.a(var9, var10, var11);
               var13.a = var4;
               var13.b = (long)var3;
               synchronized(com.nexage.android.c.i.class) {
                  com.nexage.android.c.i.a.b.add(var13);
               }

               var1 = var2 + 1;
            }

            var2 = var1;
         } while(var8.moveToNext());

         com.nexage.android.a.p.b("read total " + var1 + " click records");
      }

      if(!var8.isClosed()) {
         var8.close();
      }

      if(var1 > 0) {
         com.nexage.android.a.p.c("ReportPersist", "read back " + var1 + " click records");
      }

      return var1;
   }

   private int g() {
      Cursor var8 = this.c.query("diplayTable", new String[]{"seq", "pos", "posSeq", "ts", "tagId", "buyer", "pru", "flushTs", "a"}, "flushTs is not null", (String[])null, (String)null, (String)null, (String)null);
      int var1 = 0;
      int var2 = 0;
      if(var8.moveToFirst()) {
         do {
            var8.getInt(0);
            String var11 = var8.getString(1);
            int var3 = var8.getInt(2);
            long var4 = var8.getLong(3);
            String var12 = var8.getString(4);
            String var9 = var8.getString(5);
            String var10 = var8.getString(6);
            long var6 = var8.getLong(7);
            String var13 = var8.getString(8);
            var1 = var2;
            if(var6 > 0L) {
               com.nexage.android.c.b var15 = new com.nexage.android.c.b(var11, var12, var13);
               var15.e = var9;
               var15.f = var10;
               var15.a = var4;
               var15.b = (long)var3;
               synchronized(com.nexage.android.c.i.class) {
                  com.nexage.android.c.i.a.c.add(var15);
               }

               var1 = var2 + 1;
            }

            var2 = var1;
         } while(var8.moveToNext());
      }

      if(!var8.isClosed()) {
         var8.close();
      }

      if(var1 > 0) {
         com.nexage.android.a.p.c("ReportPersist", "read back " + var1 + " display records");
      }

      return var1;
   }

   public final int c() {
      int var1 = (int)DatabaseUtils.queryNumEntries(this.c, "reqTable");
      com.nexage.android.a.p.c("ReportPersist", "request count:" + var1);
      return var1;
   }

   public final int d() {
      int var1 = (int)DatabaseUtils.queryNumEntries(this.c, "clickTable");
      com.nexage.android.a.p.c("ReportPersist", "click count:" + var1);
      return var1;
   }
}
