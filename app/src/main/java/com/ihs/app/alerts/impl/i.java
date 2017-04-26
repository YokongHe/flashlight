package com.ihs.app.alerts.impl;

import java.util.Map;
import java.util.Random;

final class i extends com.ihs.app.alerts.impl.c {
   i() {
      super("RateAlert");
   }

   static void f() {
      com.ihs.app.alerts.impl.b.d().edit().putBoolean("HSAlert_RateAlertNoPopUpForever", true).commit();
   }

   final void a(Map var1) {
      boolean var2 = true;
      super.a(var1);
      boolean var3 = com.ihs.a.e.g.a(this.d, false, new String[]{"AppStart"});
      if(!com.ihs.a.e.g.a(this.d, false, new String[]{"AppEnd"}) || var3) {
         var2 = false;
      }

      this.b = var2;
   }

   public final boolean a() {
      if(!com.ihs.app.alerts.impl.b.d().getBoolean("HSAlert_RateAlertNoPopUpForever", false)) {
         Map var5 = this.e();
         if(var5 != null) {
            int var3 = (new Random()).nextInt(100);
            int var4 = com.ihs.a.e.g.a(var5, 0, new String[]{"Probability"});
            (new StringBuilder("probability: ")).append(var4).append(" randomNumber:").append(var3).toString();
            if(var3 < var4) {
               var3 = (int)((System.currentTimeMillis() - com.ihs.app.framework.a.b.a().f()) / 1000L);
               var4 = com.ihs.a.e.g.a(var5, 0, new String[]{"MinDaysFromFirstUse"});
               (new StringBuilder("daysFromFirstUse: ")).append(var4).toString();
               if(var3 >= var4 * 86400) {
                  double var1 = (double)com.ihs.a.e.g.a(var5, 0, new String[]{"MinAccumulatedUseTime"});
                  (new StringBuilder("MinAccumulatedUseTime: ")).append(var1).toString();
                  if((double)com.ihs.app.framework.a.b.a().g() >= var1 * 60.0D) {
                     var3 = com.ihs.a.e.g.a(var5, 0, new String[]{"MinUseCount"});
                     (new StringBuilder("currentSessionId: ")).append(com.ihs.app.framework.a.b.a().h()).append(" useCount:").append(var3).toString();
                     if(com.ihs.app.framework.a.b.a().h() >= var3) {
                        return true;
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   public final void b() {
      com.ihs.app.a.b.a("HSRateAlert_Showed");
      super.b();
   }
}
