package com.nexage.android.f;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdView;
import java.util.GregorianCalendar;

public final class b extends com.nexage.android.e.b {
   private AdView d;

   public b(Context var1, Handler var2) {
      super(var1, var2);
      com.nexage.android.a.p.b("GoogleProvider", "entering constructor");
      this.c = true;
   }

   // $FF: synthetic method
   static AdView a(com.nexage.android.f.b var0, AdView var1) {
      var0.d = null;
      return null;
   }

   protected final View a(int var1, int var2, String var3) {
      this.d = new AdView(this.a);
      this.d.a(var3);
      this.d.a(com.google.android.gms.ads.d.a);
      this.d.a(new com.google.android.gms.ads.a() {
         public final void onAdClosed() {
            com.nexage.android.a.p.b("GoogleProvider", "onAdClosed");
            b.this.d(b.this);
         }

         public final void onAdFailedToLoad(int var1) {
            com.nexage.android.a.p.b("GoogleProvider", "onAdFailedToLoad " + var1);
            com.nexage.android.f.b.a(b.this, (AdView)null);
            b.this.b(b.this);
         }

         public final void onAdLeftApplication() {
            com.nexage.android.a.p.b("GoogleProvider", "onAdLeftApplication");
            b.this.e(b.this);
         }

         public final void onAdLoaded() {
            com.nexage.android.a.p.b("GoogleProvider", "onAdLoaded");
            b.this.a(b.this);
         }

         public final void onAdOpened() {
            com.nexage.android.a.p.b("GoogleProvider", "onAdOpened");
            b.this.c(b.this);
         }
      });
      return this.d;
   }

   protected final void b() {
      int var1 = 0;
      if(this.d != null) {
         com.google.android.gms.ads.c var3 = new com.google.android.gms.ads.c();
         GregorianCalendar var4 = com.nexage.android.b.h();
         if(var4 != null) {
            var3.a(var4.getTime());
         }

         com.nexage.android.d var6 = com.nexage.android.b.o();
         if(var6 != null) {
            switch(null.a[var6.ordinal()]) {
            case 1:
               var3.a(1);
               break;
            case 2:
               var3.a(2);
               break;
            case 3:
               var3.a(0);
            }
         }

         com.nexage.android.a var7 = com.nexage.android.b.x();
         if(var7 != null) {
            var3.a(var7.a());
         }

         String var8 = com.nexage.android.b.r();
         if(!TextUtils.isEmpty(var8)) {
            String[] var9 = var8.split(",");

            for(int var2 = var9.length; var1 < var2; ++var1) {
               var3.a(var9[var1]);
            }
         }

         var3.a(com.nexage.android.b.a());
         com.google.android.gms.ads.b var5 = var3.a();
         this.d.a(var5);
      }
   }

   protected final void c() {
      com.nexage.android.a.p.b("GoogleProvider", "cancel");
      if(this.d != null) {
         this.d.a((com.google.android.gms.ads.a)null);
      }

   }
}
