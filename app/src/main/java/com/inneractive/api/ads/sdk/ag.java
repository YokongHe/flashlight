package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.util.HashMap;
import java.util.Map;

class ag {
   String a;
   int b;
   int c;
   String d;
   int e;
   String f;
   private Map g;
   private String h;

   final Map a() {
      return this.g;
   }

   final void a(String var1) {
      if(!com.inneractive.api.ads.sdk.an.a(var1)) {
         if(this.g == null) {
            this.g = new HashMap();
         }

         String[] var5 = com.inneractive.api.ads.sdk.an.b(var1).split(",");
         int var3 = var5.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String var4 = var5[var2];
            this.g.put(var4.split("=")[0], var4.split("=")[1]);
         }
      } else {
         InneractiveAdView$Log.d("integrated sdk\'s siteIds list is Empty");
      }

   }

   String b() {
      return this.h;
   }

   void b(String var1) {
      this.h = var1;
   }
}
