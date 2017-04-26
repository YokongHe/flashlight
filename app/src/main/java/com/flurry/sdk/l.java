package com.flurry.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.l$a;

public final class l extends RelativeLayout {
   private static final String a = com.flurry.sdk.l.class.getSimpleName();
   private final FlurryAdModule b;
   private final String c;
   private final ViewGroup d;
   private long e;
   private final Runnable f = new l$a(this, null);

   public l(FlurryAdModule var1, Context var2, String var3, ViewGroup var4) {
      super(var2);
      this.b = var1;
      this.c = var3;
      this.d = var4;
   }

   // $FF: synthetic method
   static void a(com.flurry.sdk.l var0) {
      var0.g();
   }

   private boolean e() {
      if(FlurryAdModule.i()) {
         eo.a(3, a, "Device is locked: banner will NOT rotate for adSpace: " + this.getAdSpace());
      } else {
         if(this.b.g()) {
            eo.a(3, a, "Ad fullscreen panel is opened: banner will NOT rotate for adSpace: " + this.getAdSpace());
            return false;
         }

         com.flurry.sdk.i var1 = this.getCurrentBannerView();
         if(var1 != null && var1.g()) {
            return true;
         }
      }

      return false;
   }

   private void f() {
      eo.a(3, a, "Rotating banner for adSpace: " + this.getAdSpace());
      this.b.d().a(this.getContext(), this.c, this.d, FlurryAdSize.BANNER_BOTTOM, true);
   }

   private void g() {
      synchronized(this){}

      try {
         if(this.e()) {
            this.f();
         }

         do.a().b(this.f, this.getRotationRateInMilliseconds());
      } finally {
         ;
      }

   }

   private com.flurry.sdk.i getCurrentBannerView() {
      if(this.getChildCount() <= 0) {
         return null;
      } else {
         View var1 = this.getChildAt(0);

         try {
            com.flurry.sdk.i var3 = (com.flurry.sdk.i)var1;
            return var3;
         } catch (ClassCastException var2) {
            return null;
         }
      }
   }

   public final void a() {
      synchronized(this){}

      try {
         this.c();
         this.e = 0L;
      } finally {
         ;
      }

   }

   public final void a(long var1) {
      synchronized(this){}

      try {
         if(this.e != var1) {
            this.c();
            this.e = var1;
            this.b();
         }
      } finally {
         ;
      }

   }

   public final void b() {
      synchronized(this){}

      try {
         if(this.getRotationRateInMilliseconds() != 0L) {
            this.c();
            eo.a(3, a, "schedule banner rotation for adSpace = " + this.getAdSpace() + " with fixed rate in milliseconds = " + this.getRotationRateInMilliseconds());
            do.a().b(this.f, this.getRotationRateInMilliseconds());
         }
      } finally {
         ;
      }

   }

   public final void c() {
      synchronized(this){}

      try {
         do.a().d(this.f);
      } finally {
         ;
      }

   }

   public final void d() {
      this.a();
      com.flurry.sdk.i var1 = this.getCurrentBannerView();
      if(var1 != null) {
         var1.onDestroy();
      }

   }

   public final String getAdSpace() {
      return this.c;
   }

   public final long getRotationRateInMilliseconds() {
      return this.e;
   }

   public final ViewGroup getViewGroup() {
      return this.d;
   }
}
