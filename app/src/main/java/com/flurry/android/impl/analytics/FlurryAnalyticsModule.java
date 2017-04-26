package com.flurry.android.impl.analytics;

import android.content.Context;
import com.flurry.sdk.dd;
import com.flurry.sdk.dj;
import com.flurry.sdk.et;

public class FlurryAnalyticsModule implements et {
   private static FlurryAnalyticsModule a;
   private dd b;

   public static FlurryAnalyticsModule getInstance() {
      synchronized(FlurryAnalyticsModule.class){}

      FlurryAnalyticsModule var0;
      try {
         if(a == null) {
            a = new FlurryAnalyticsModule();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public dd a() {
      return this.b;
   }

   public void a(dj var1) {
   }

   public void a(dj var1, Context var2) {
      if(this.b == null) {
         this.b = new dd();
      }

   }

   public void b(dj var1, Context var2) {
   }

   public void c(dj var1, Context var2) {
   }
}
