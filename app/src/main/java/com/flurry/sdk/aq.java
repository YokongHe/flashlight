package com.flurry.sdk;

import java.io.DataInput;
import java.io.DataOutput;

public class aq {
   String a;
   com.flurry.sdk.ay b;
   long c;
   long d;
   com.flurry.sdk.ar e;
   long f;
   long g;

   public aq(DataInput var1) {
      this.a = var1.readUTF();
      this.b = com.flurry.sdk.ay.a(var1.readInt());
      this.c = var1.readLong();
      this.d = var1.readLong();
      this.e = com.flurry.sdk.ar.a(var1.readInt());
      this.f = var1.readLong();
      this.g = var1.readLong();
   }

   public aq(String var1, com.flurry.sdk.ay var2, long var3) {
      this.a = var1;
      this.b = var2;
      this.c = System.currentTimeMillis();
      this.d = System.currentTimeMillis();
      this.e = com.flurry.sdk.ar.a;
      this.f = var3;
      this.g = -1L;
   }

   public String a() {
      return this.a;
   }

   public void a(long var1) {
      synchronized(this){}

      try {
         this.g = var1;
      } finally {
         ;
      }

   }

   public void a(com.flurry.sdk.ar var1) {
      synchronized(this){}

      try {
         this.e = var1;
      } finally {
         ;
      }

   }

   public void a(DataOutput var1) {
      var1.writeUTF(this.a);
      var1.writeInt(this.b.a());
      var1.writeLong(this.c);
      var1.writeLong(this.d);
      var1.writeInt(this.e.a());
      var1.writeLong(this.f);
      var1.writeLong(this.g);
   }

   public com.flurry.sdk.ar b() {
      synchronized(this){}

      com.flurry.sdk.ar var1;
      try {
         var1 = this.e;
      } finally {
         ;
      }

      return var1;
   }

   public long c() {
      return this.f;
   }

   public boolean d() {
      return this.f > 0L && System.currentTimeMillis() > this.f;
   }

   public void e() {
      synchronized(this){}

      try {
         this.d = System.currentTimeMillis();
      } finally {
         ;
      }

   }

   public long f() {
      return this.c;
   }

   public String toString() {
      return "url: " + this.a + ", type:" + this.b + ", creation:" + this.c + ", accessed:" + this.d + ", status: " + this.e + ", expiration: " + this.f + ", size: " + this.g;
   }
}
