package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.bz$a;
import com.flurry.sdk.eo;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.RequestListener;

public final class bz extends com.flurry.sdk.ba {
   private static final String b = com.flurry.sdk.bz.class.getSimpleName();
   private boolean c;
   private final String d;
   private MMInterstitial e;
   private RequestListener f;

   public bz(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.d = var5.getString("com.flurry.millennial.MYAPIDINTERSTITIAL");
   }

   // $FF: synthetic method
   static boolean a(com.flurry.sdk.bz var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static MMInterstitial b(com.flurry.sdk.bz var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static String f() {
      return b;
   }

   public final void a() {
      this.e = new MMInterstitial((Activity)this.b());
      this.e.setApid(this.d);
      this.f = new bz$a(this, null);
      this.e.setListener(this.f);
      this.e.fetch();
      this.c = this.e.display();
      if(this.c) {
         eo.a(3, b, "Millennial MMAdView Interstitial ad displayed immediately:" + System.currentTimeMillis() + " " + this.c);
      } else {
         eo.a(3, b, "Millennial MMAdView Interstitial ad did not display immediately:" + System.currentTimeMillis() + " " + this.c);
      }
   }
}
