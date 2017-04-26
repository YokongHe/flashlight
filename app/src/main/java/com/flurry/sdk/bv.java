package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.bv$a;
import com.flurry.sdk.eo;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMInterstitial;
import java.lang.reflect.Method;

public class bv extends com.flurry.sdk.ba {
   private static final String b = com.flurry.sdk.bv.class.getSimpleName();
   private static final Method c = g();
   private final String d;
   private IMInterstitial e;
   private bv$a f;

   public bv(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.d = var5.getString("com.flurry.inmobi.MY_APP_ID");
      InMobi.initialize((Activity)this.b(), this.d);
   }

   private void a(IMInterstitial var1, bv$a var2) {
      if(var1 != null) {
         try {
            if(c != null) {
               c.invoke(var1, new Object[]{var2});
               return;
            }
         } catch (Exception var3) {
            eo.a(3, b, "InMobi set listener failed.");
            return;
         }
      }

   }

   // $FF: synthetic method
   static String f() {
      return b;
   }

   private static Method g() {
      Method[] var2 = IMInterstitial.class.getMethods();
      int var1 = var2.length;

      for(int var0 = 0; var0 < var1; ++var0) {
         Method var3 = var2[var0];
         String var4 = var3.getName();
         if(var4.equals("setIMInterstitialListener") || var4.equals("setImInterstitialListener")) {
            return var3;
         }
      }

      return null;
   }

   public void a() {
      this.e = new IMInterstitial((Activity)this.b(), this.d);
      this.f = new bv$a(this, null);
      this.a(this.e, this.f);
      this.e.loadInterstitial();
   }
}
