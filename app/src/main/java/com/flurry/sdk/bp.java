package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.bp$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.fc;
import com.google.android.gms.ads.AdView;

public final class bp extends AdNetworkView {
   private static final String a = com.flurry.sdk.bp.class.getSimpleName();
   private final String b;
   private final String c;
   private final boolean d;
   private AdView e;
   private com.google.android.gms.ads.a f;

   public bp(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.b = var5.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
      this.c = var5.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
      this.d = var5.getBoolean("com.flurry.gms.ads.test");
      this.setFocusable(true);
   }

   private com.google.android.gms.ads.d a(int var1, int var2) {
      if(var1 >= 728 && var2 >= 90) {
         return com.google.android.gms.ads.d.d;
      } else if(var1 >= 468 && var2 >= 60) {
         return com.google.android.gms.ads.d.b;
      } else if(var1 >= 320 && var2 >= 50) {
         return com.google.android.gms.ads.d.a;
      } else if(var1 >= 300 && var2 >= 250) {
         return com.google.android.gms.ads.d.e;
      } else {
         eo.a(3, a, "Could not find GMS AdSize that matches size");
         return null;
      }
   }

   private com.google.android.gms.ads.d a(Context var1, int var2, int var3) {
      int var4;
      int var5;
      label19: {
         var5 = fc.h();
         int var6 = fc.g();
         if(var2 > 0) {
            var4 = var2;
            if(var2 <= var6) {
               break label19;
            }
         }

         var4 = var6;
      }

      if(var3 > 0) {
         var2 = var3;
         if(var3 <= var5) {
            return this.a(var4, var2);
         }
      }

      var2 = var5;
      return this.a(var4, var2);
   }

   // $FF: synthetic method
   static String a() {
      return a;
   }

   final com.google.android.gms.ads.a getAdListener() {
      return this.f;
   }

   final AdView getAdView() {
      return this.e;
   }

   public final void initLayout() {
      eo.a(4, a, "GMS AdView initLayout.");
      Context var3 = this.getContext();
      int var1 = this.getAdCreative().getWidth();
      int var2 = this.getAdCreative().getHeight();
      com.google.android.gms.ads.d var4 = this.a(var3, var1, var2);
      if(var4 == null) {
         eo.a(6, a, "Could not find GMS AdSize that matches {width = " + var1 + ", height " + var2 + "}");
      } else {
         eo.a(3, a, "Determined GMS AdSize as " + var4 + " that best matches {width = " + var1 + ", height = " + var2 + "}");
         this.f = new bp$a(this, null);
         this.e = new AdView(var3);
         this.e.a(var4);
         this.e.a(this.b);
         this.e.a(this.f);
         this.setGravity(17);
         this.addView(this.e, new LayoutParams(var4.b(var3), var4.a(var3)));
         com.google.android.gms.ads.c var5 = new com.google.android.gms.ads.c();
         if(this.d) {
            eo.a(3, a, "GMS AdView set to Test Mode.");
            var5.b(com.google.android.gms.ads.b.a);
            if(!TextUtils.isEmpty(this.c)) {
               var5.b(this.c);
            }
         }

         this.e.a(var5.a());
      }
   }

   public final void onDestroy() {
      eo.a(4, a, "GMS AdView onDestroy.");
      if(this.e != null) {
         this.e.a();
         this.e = null;
      }

      super.onDestroy();
   }
}
