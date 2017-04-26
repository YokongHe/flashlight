package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.LinearLayout.LayoutParams;
import com.flurry.android.AdCreative;
import com.flurry.android.AdNetworkView;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.bt$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.fc;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;

public final class bt extends AdNetworkView {
   private static final String a = com.flurry.sdk.bt.class.getSimpleName();
   private final String b;
   private IMBanner c;
   private IMBannerListener d;

   bt(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.b = var5.getString("com.flurry.inmobi.MY_APP_ID");
      InMobi.initialize((Activity)this.getContext(), this.b);
      this.setFocusable(true);
   }

   // $FF: synthetic method
   static String a() {
      return a;
   }

   final IMBannerListener getAdListener() {
      return this.d;
   }

   final IMBanner getAdView() {
      return this.c;
   }

   public final void initLayout() {
      eo.a(3, a, "InMobi initLayout");
      int var4 = this.getAdCreative().getWidth();
      int var5 = this.getAdCreative().getHeight();
      int var6 = fc.h();
      int var3 = fc.g();
      int var2 = var3;
      if(var4 > 0) {
         if(var4 > var3) {
            var2 = var3;
         } else {
            var2 = var4;
         }
      }

      var3 = var6;
      if(var5 > 0) {
         if(var5 > var6) {
            var3 = var6;
         } else {
            var3 = var5;
         }
      }

      var6 = com.flurry.sdk.bu.a(new Point(var2, var3));
      if(-1 != var6) {
         this.c = new IMBanner((Activity)this.getContext(), this.b, var6);
         var3 = 320;
         var2 = 50;
         Point var7 = com.flurry.sdk.bu.a(var6);
         if(var7 != null) {
            var3 = var7.x;
            var2 = var7.y;
         }

         eo.a(3, a, "Determined InMobi AdSize as " + var3 + "x" + var2);
         float var1 = fc.c().density;
         var3 = (int)((float)var3 * var1 + 0.5F);
         var2 = (int)((float)var2 * var1 + 0.5F);
         this.c.setLayoutParams(new LayoutParams(var3, var2));
         this.d = new bt$a(this, null);
         this.c.setIMBannerListener(this.d);
         this.setGravity(17);
         this.addView(this.c);
         this.c.setRefreshInterval(-1);
         this.c.loadBanner();
      } else {
         eo.a(3, a, "Could not find InMobi AdSize that matches size " + var4 + "x" + var5);
         eo.a(3, a, "Could not load InMobi Ad");
      }
   }

   public final void onDestroy() {
      eo.a(3, a, "InMobi onDestroy");
      if(this.c != null) {
         this.c.destroy();
         this.c = null;
      }

      super.onDestroy();
   }
}
