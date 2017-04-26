package com.flurry.sdk;

import com.flurry.sdk.di;

public class dh {
   private static final String b = dh.class.getSimpleName();
   byte[] a;

   public dh(di param1) {
      // $FF: Couldn't be decompiled
   }

   public dh(byte[] var1) {
      this.a = var1;
   }

   double a(double var1) {
      return (double)Math.round(var1 * 1000.0D) / 1000.0D;
   }

   public byte[] a() {
      return this.a;
   }
}
