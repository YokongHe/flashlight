package com.surpax.ledflashlight;

import android.app.Activity;
import com.ihs.app.framework.HSApplication;
import com.surpax.ledflashlight.FlashlightActivity;
import java.util.HashMap;
import java.util.Map;

public class MyApplication extends HSApplication {
   com.ihs.app.a.c c = new com.ihs.app.a.c() {
      public final Map a() {
         HashMap var2 = new HashMap();
         String var1;
         if(com.surpax.a.a.H == 0) {
            var1 = "AppIcon";
         } else if(1 == com.surpax.a.a.H) {
            var1 = "HomeScreen_Small";
         } else if(3 == com.surpax.a.a.H) {
            var1 = "HomeScreen_Large";
         } else {
            var1 = "LockWidget";
         }

         var2.put("From", var1);
         return var2;
      }

      public final Map b() {
         return new HashMap();
      }
   };
   private com.ihs.a.d.d d = new com.ihs.a.d.d() {
      public final void a(String var1, com.ihs.a.e.e var2) {
         if("hs.app.session.SESSION_START".equals(var1)) {
            com.surpax.b.a.b = false;
            if(FlashlightActivity.a().k()) {
               com.ihs.app.alerts.impl.b.a().c();
            }
         }

         if("hs.app.session.SESSION_END".equals(var1)) {
            com.surpax.a.a.K = false;
            com.surpax.a.a.J = false;
         }

      }
   };
   private com.ihs.a.d.d e = new com.ihs.a.d.d() {
      public final void a(String var1, com.ihs.a.e.e var2) {
         Activity var3 = com.ihs.app.framework.a.b.a().d();
         if(var3 != null) {
            Map var4 = com.ihs.a.b.b.d();
            com.surpax.b.a.a().a(var4);
            FlashlightActivity.a().m();
            var3.runOnUiThread(new Runnable() {
               public final void run() {
                  FlashlightActivity.a().c();
               }
            });
         }
      }
   };

   public void onCreate() {
      super.onCreate();
      com.ihs.app.a.b.a(this.c);
      com.ihs.a.d.a.a("hs.app.session.SESSION_START", this.d);
      com.ihs.a.d.a.a("hs.app.session.SESSION_END", this.d);
      com.ihs.a.d.a.a("hs.commons.config.CONFIG_CHANGED", this.e);
   }

   public void onTerminate() {
      com.ihs.a.d.a.a(this.d);
      com.ihs.a.d.a.a(this.e);
      super.onTerminate();
   }
}
