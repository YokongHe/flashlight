package com.ihs.app.framework.a2.a1;

import android.content.Context;
import com.ihs.app.framework.HSApplication;

public final class b {
   static void a() {
      Context var7 = HSApplication.a();
      com.ihs.a.e.j var8 = com.ihs.a.e.j.a(var7);
      long var1 = com.ihs.a.e.j.a(var7, "iHSRateAlertFirstLaunchDate").a("iHSRateAlertFirstLaunchDate", -1L);
      long var3 = com.ihs.a.e.j.a(var7, "iHandySoftVersionControlLastExitDate").a("iHandySoftVersionControlLastExitDate", -1L);
      long var5 = com.ihs.a.e.j.a(var7, "iHSRateAlertAccumulatedUseTime").a("iHSRateAlertAccumulatedUseTime", -1L);
      int var0 = com.ihs.a.e.j.a(var7, "iHSRateAlertUseCount").a("iHSRateAlertUseCount", -1);
      if(var1 != -1L && var3 != -1L && var5 != -1L && var0 != -1) {
         var8.b("hs.app.session.first_session_start_time", var1);
         var8.b("hs.app.session.last_session_end_time", var3);
         var8.b("hs.app.session.total_usage_seconds", (float)(var5 / 1000L));
         var8.b("hs.app.session.total_session_count", var0);
      }

      com.ihs.a.e.j.b(var7, "iHSRateAlertFirstLaunchDate");
      com.ihs.a.e.j.b(var7, "iHandySoftVersionControlLastExitDate");
      com.ihs.a.e.j.b(var7, "iHSRateAlertAccumulatedUseTime");
      com.ihs.a.e.j.b(var7, "iHSRateAlertUseCount");
      Context var11 = HSApplication.a();
      com.ihs.a.e.j var10 = com.ihs.a.e.j.a(var11);
      var8 = com.ihs.a.e.j.a(var11, HSApplication.a().getPackageName());
      String var9 = var8.a("hs.app.push.device_token", "");
      var10.b("hs.app.push.device_token", var9);
      var8.b(var9, "");
   }
}
