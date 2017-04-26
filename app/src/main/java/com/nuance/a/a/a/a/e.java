package com.nuance.a.a.a.a;

import android.media.AudioRecord;
import android.media.AudioRecord.OnRecordPositionUpdateListener;

final class e implements .ah, OnRecordPositionUpdateListener {
   private .ae a;
   private AudioRecord b;
   private boolean c;
   private .O d;
   private .R e;
   private .Z f;
   private .S g;
   private .T h;
   private .aa i;
   private .U j;
   private boolean k;
   private boolean l;
   private int m;
   // $FF: synthetic field
   private com.nuance.a.a.a.a.a n;

   private e(com.nuance.a.a.a.a.a var1) {
      this.n = var1;
      super();
      this.a = .bh.a(this.getClass());
      this.d = null;
      this.e = null;
      this.f = null;
      this.g = null;
      this.h = null;
      this.i = null;
      this.j = null;
      this.k = false;
      this.l = false;
      this.m = 0;
   }

   // $FF: synthetic method
   e(com.nuance.a.a.a.a.a var1, byte var2) {
      this(var1);
   }

   private static float a(short[] var0) {
      long var6 = 0L;

      for(int var5 = 0; var5 < var0.length; ++var5) {
         long var8 = (long)var0[var5];
         var6 += var8 * var8 >> 9;
      }

      double var1 = (double)var6 / 1.073741824E9D;
      if(var1 < 1.0E-9D) {
         var1 = -90.0D;
      } else {
         double var3 = Math.log10(var1) * 10.0D;
         var1 = var3;
         if(var3 > 0.0D) {
            var1 = 0.0D;
         }
      }

      return (float)var1;
   }

   private void a(com.nuance.a.a.a.a.b var1) {
      if(this.a.e()) {
         this.a.e(var1.getMessage());
      }

      if(this.c) {
         this.b.stop();
         Object var5 = com.nuance.a.a.a.a.a.h();
         synchronized(var5) {
            this.c = false;
            this.b.release();
            this.b = null;
         }

         this.j.d();
         if(com.nuance.a.a.a.a.a.i(this.n) == com.nuance.a.a.a.a.c.a) {
            var5 = com.nuance.a.a.a.a.a.b;
            synchronized(var5) {
               com.nuance.a.a.a.a.a.d();
            }
         }

         if(com.nuance.a.a.a.a.a.a(this.n) != null) {
            com.nuance.a.a.a.a.a.a(this.n).e();
            com.nuance.a.a.a.a.a.b(this.n);
         }

         if(this.i != null) {
            this.i.a(.P.b);
            return;
         }
      }

   }

   // $FF: synthetic method
   static void a(com.nuance.a.a.a.a.e var0, com.nuance.a.a.a.a.b var1) {
      var0.a(var1);
   }

   public final void a(.S var1) {
      this.g = var1;
      .af var4 = com.nuance.a.a.a.a.a.p(this.n);
      Integer var2 = com.nuance.a.a.a.a.a.i();
      Object var3 = com.nuance.a.a.a.a.a.p(this.n).b();
      com.nuance.a.a.a.a.a.p(this.n).a();
      var4.a(new Object[]{var2}, this, var3);
   }

   public final void a(.T var1) {
      this.h = var1;
      .af var4 = com.nuance.a.a.a.a.a.p(this.n);
      Integer var2 = com.nuance.a.a.a.a.a.j();
      Object var3 = com.nuance.a.a.a.a.a.p(this.n).b();
      com.nuance.a.a.a.a.a.p(this.n).a();
      var4.a(new Object[]{var2}, this, var3);
   }

   public final void a(.aa param1, .R param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(Object param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(boolean param1, .O param2, .aa param3, .U param4, .Z param5, .R param6, .S param7, .T param8) {
      // $FF: Couldn't be decompiled
   }

   public final void onMarkerReached(AudioRecord var1) {
   }

   public final void onPeriodicNotification(AudioRecord param1) {
      // $FF: Couldn't be decompiled
   }
}
