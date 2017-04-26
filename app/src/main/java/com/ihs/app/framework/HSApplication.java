package com.ihs.app.framework;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.UUID;

public class HSApplication extends Application {
   protected static String a = "config-d.ya";
   protected static String b = "config-r.ya";
   private static Context c;
   private static String d = null;
   private static com.ihs.app.framework.a e;
   private static com.ihs.app.framework.a f;
   private static com.ihs.app.framework.a g;

   public static Context a() {
      return c;
   }

   public static com.ihs.app.framework.a b() {
      return e;
   }

   public static com.ihs.app.framework.a c() {
      return f;
   }

   private static String d() {
      return com.ihs.a.e.f.a()?a:b;
   }

   public void onCreate() {
      super.onCreate();
      Context var1 = this.getApplicationContext();
      c = var1;
      com.ihs.a.e.f.a(var1);
      com.ihs.app.framework.a.a.a.a();
      String var3 = com.ihs.a.e.j.a(c).a("hs.app.application.installation_uuid", "");
      d = var3;
      if(TextUtils.isEmpty(var3)) {
         d = UUID.randomUUID().toString();
         com.ihs.a.e.j.a(c).b("hs.app.application.installation_uuid", d);
      }

      com.ihs.a.e.j var4 = com.ihs.a.e.j.a(c);
      g = com.ihs.app.framework.a.a(var4.a((String)"hs.app.application.first_launch_info", (String)null));
      f = com.ihs.app.framework.a.a(var4.a((String)"hs.app.application.last_launch_info", (String)null));
      if(g == null && f != null) {
         g = f;
         var4.b("hs.app.application.first_launch_info", g.toString());
      } else if(g != null && f == null) {
         f = g;
         var4.b("hs.app.application.last_launch_info", f.toString());
      }

      com.ihs.app.framework.a var2 = new com.ihs.app.framework.a();
      e = var2;
      var2.b = com.ihs.app.b.c.e();
      e.c = com.ihs.app.b.c.f();
      e.d = VERSION.RELEASE;
      if(g == null && f == null) {
         e.a = 1;
         var4.b("hs.app.application.last_launch_info", e.toString());
         g = e;
         var4.b("hs.app.application.first_launch_info", g.toString());
         f = e;
      } else if(g != null && f != null) {
         e.a = f.a + 1;
         var4.b("hs.app.application.last_launch_info", e.toString());
      }

      com.ihs.app.framework.a.a.a.b();
      if(d() != null) {
         com.ihs.a.b.b.a(c, d(), com.ihs.app.b.c.d());
      }

      com.ihs.app.push.impl.a.b();
      com.ihs.app.alerts.impl.b.b();
   }

   public void onTerminate() {
      super.onTerminate();
   }
}
