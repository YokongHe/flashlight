package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.bx$a;
import com.flurry.sdk.eo;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;

public final class bx extends AdNetworkView {
   private static final String a = com.flurry.sdk.bx.class.getSimpleName();
   private final String b;
   private final String c;
   private MMAdView d;
   private RequestListener e;

   public bx(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.b = var5.getString("com.flurry.millennial.MYAPID");
      this.c = var5.getString("com.flurry.millennial.MYAPIDRECTANGLE");
      this.setFocusable(true);
   }

   // $FF: synthetic method
   static String a() {
      return a;
   }

   final RequestListener getAdListener() {
      return this.e;
   }

   final MMAdView getAdView() {
      return this.d;
   }

   public final void initLayout() {
      eo.a(3, a, "Millennial initLayout");
      int var2 = this.getAdCreative().getWidth();
      int var3 = this.getAdCreative().getHeight();
      int var1 = com.flurry.sdk.by.a(new Point(var2, var3));
      if(-1 == var1) {
         eo.a(3, a, "Could not find Millennial AdSize that matches size " + var2 + "x" + var3);
         eo.a(3, a, "Could not load Millennial Ad");
      } else {
         Point var4 = com.flurry.sdk.by.a(var1);
         if(var4 == null) {
            eo.a(3, a, "Could not find Millennial AdSize that matches size " + var2 + "x" + var3);
            eo.a(3, a, "Could not load Millennial Ad");
         } else {
            var2 = var4.x;
            var3 = var4.y;
            eo.a(3, a, "Determined Millennial AdSize as " + var2 + "x" + var3);
            this.d = new MMAdView((Activity)this.getContext());
            this.setId(MMSDK.getDefaultAdId());
            this.d.setApid(this.b);
            if(2 == var1) {
               this.d.setApid(this.c);
            }

            this.d.setWidth(var2);
            this.d.setHeight(var3);
            this.setHorizontalScrollBarEnabled(false);
            this.setVerticalScrollBarEnabled(false);
            this.setGravity(17);
            this.e = new bx$a(this, null);
            this.d.setListener(this.e);
            this.addView(this.d);
            this.d.getAd();
         }
      }
   }

   public final void onDestroy() {
      eo.a(3, a, "Millennial onDestroy");
      if(this.d != null) {
         this.d = null;
      }

      super.onDestroy();
   }
}
