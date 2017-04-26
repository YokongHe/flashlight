package com.nexage.android.f;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class d implements InvocationHandler {
   // $FF: synthetic field
   final com.nexage.android.f.c a;

   private d(com.nexage.android.f.c var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   d(com.nexage.android.f.c var1, byte var2) {
      this(var1);
   }

   public final Object invoke(Object var1, Method var2, Object[] var3) {
      if(com.nexage.android.f.c.a(this.a)) {
         try {
            if(var2.getName().equals("onFetchedAd")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onFetchedAd");
               com.nexage.android.f.c.a(this.a, this.a);
               return null;
            }

            if(var2.getName().equals("onFailedToFetchAd")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onFailedToFetchAd");
               com.nexage.android.f.c.b(this.a, this.a);
               return null;
            }

            if(var2.getName().equals("onAdExpansion")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onAdExpansion");
               com.nexage.android.f.c.c(this.a, this.a);
               return null;
            }

            if(var2.getName().equals("onAdCollapse")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onAdCollapse");
               com.nexage.android.f.c.d(this.a, this.a);
               return null;
            }

            if(var2.getName().equals("onAdDismissal")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onAdDismissal");
               com.nexage.android.f.c.e(this.a, this.a);
               return null;
            }

            if(var2.getName().equals("onAdClickthrough")) {
               com.nexage.android.a.p.b("GreystripeProvider", "proxy --> onAdClickthrough");
               com.nexage.android.f.c.f(this.a, this.a);
               return null;
            }
         } catch (Exception var4) {
            com.nexage.android.a.p.d("GSAdListenerHandler exception: " + var4);
            return null;
         }
      }

      return null;
   }
}
