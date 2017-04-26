package com.flurry.sdk;

import java.io.DataInput;
import java.io.DataOutput;

public final class x {
   private String a;
   private long b;
   private long c;
   private int d;
   private int e;
   private int f;
   private int g;

   public x() {
   }

   public x(DataInput var1) {
      this.a = var1.readUTF();
      this.b = var1.readLong();
      this.c = var1.readLong();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readInt();
      this.g = var1.readInt();
   }

   public x(String var1, long var2, long var4, int var6, int var7, int var8) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.d = 0;
   }

   public final com.flurry.sdk.x a() {
      com.flurry.sdk.x var1 = new com.flurry.sdk.x(this.b(), this.i(), this.h(), this.e(), this.f(), this.g());
      var1.d = this.c();
      return var1;
   }

   public final void a(int var1) {
      this.d = var1;
   }

   public final void a(DataOutput var1) {
      var1.writeUTF(this.a);
      var1.writeLong(this.b);
      var1.writeLong(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeInt(this.f);
      var1.writeInt(this.g);
   }

   public final String b() {
      return this.a;
   }

   public final int c() {
      return this.d;
   }

   public final void d() {
      ++this.d;
   }

   public final int e() {
      return this.e;
   }

   public final int f() {
      return this.f;
   }

   public final int g() {
      return this.g;
   }

   public final long h() {
      return this.c;
   }

   public final long i() {
      return this.b;
   }
}
