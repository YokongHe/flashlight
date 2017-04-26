package com.ihs.app.alerts.impl;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ihs.app.framework.HSApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public final class b {
   public static String a;
   private static com.ihs.app.alerts.impl.b d = new com.ihs.app.alerts.impl.b();
   public com.ihs.app.alerts.c b;
   public final com.ihs.a.d.b c = new com.ihs.a.d.b();
   private com.ihs.a.c.a.h e;
   private com.ihs.app.alerts.impl.c f;
   private final ArrayList g = new ArrayList();
   private boolean h = false;
   private boolean i = false;

   private b() {
      com.ihs.a.d.a.a("hs.app.session.SESSION_START", new com.ihs.a.d.d() {
         private void a(int var1) {
            if(b.this.b != null) {
               List var2 = b.this.b.a();
               if(var2 != null && !var2.isEmpty()) {
                  Iterator var4 = var2.iterator();

                  while(var4.hasNext()) {
                     com.ihs.app.alerts.b var3 = (com.ihs.app.alerts.b)var4.next();
                     b.this.g.add(new com.ihs.app.alerts.impl.d(var3));
                  }
               }
            }

         }

         public final void a(String var1, com.ihs.a.e.e var2) {
            com.ihs.app.alerts.impl.b.b(b.this);
            b.this.f = null;
            com.ihs.app.alerts.impl.b.a(b.this, false);
            b.this.g.clear();
            b.this.g.add(new com.ihs.app.alerts.impl.f());
            b.this.g.add(new com.ihs.app.alerts.impl.e());
            b.this.g.add(new com.ihs.app.alerts.impl.j());
            b.this.g.add(new com.ihs.app.alerts.impl.g());
            this.a(1);
            com.ihs.app.alerts.impl.i var4 = new com.ihs.app.alerts.impl.i();
            var4.a(b.this.h);
            b.this.g.add(var4);
            this.a(2);
            final String var3 = HSApplication.a().getFilesDir() + "/" + com.ihs.app.alerts.impl.b.a;
            String var5 = com.ihs.a.b.b.b(new String[]{"libFramework", "Alerts", "RemoteUrl"});
            var1 = var5;
            if(TextUtils.isEmpty(var5)) {
               var1 = "http://";
            }

            (new StringBuilder("begin download alert file - ")).append(var1).toString();
            b.this.e = new com.ihs.a.c.a.h(var1, var3, new com.ihs.a.c.a.l() {
               private void c() {
                  // $FF: Couldn't be decompiled
               }

               public final void a() {
                  this.c();
               }

               public final void b() {
                  this.c();
               }
            });
            b.this.e.d();
         }
      });
      com.ihs.app.framework.a.e.a().addObserver(new Observer() {
         public final void update(Observable var1, Object var2) {
            com.ihs.app.alerts.impl.b.b(b.this);
            if((((com.ihs.app.framework.a2.f)var2).a() == 1 || ((com.ihs.app.framework.a2.f)var2).a() == 2) && b.this.f != null && b.this.f.b) {
               b.this.a(b.this.f);
            }

         }
      });
   }

   public static com.ihs.app.alerts.impl.b a() {
      return d;
   }

   static String a(Map var0, String var1) {
      if(var0.containsKey(var1)) {
         Object var2 = var0.get(var1);
         if(var2 instanceof String) {
            return (String)var2;
         } else if(var2 instanceof Map) {
            var0 = (Map)var2;
            var1 = Locale.getDefault().getLanguage();
            return var0.containsKey(var1)?(String)var0.get(var1):(String)var0.get("en");
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private void a(com.ihs.app.alerts.impl.c var1) {
      if(this.f != null && this.f == var1) {
         (new StringBuilder("showAlert: ")).append(this.f.a).append(" ").append(var1.toString()).toString();
         var1.b();
         this.f = null;
         this.i = true;
      }

   }

   // $FF: synthetic method
   static boolean a(com.ihs.app.alerts.impl.b var0, boolean var1) {
      var0.i = false;
      return false;
   }

   public static void b() {
      a = com.ihs.a.b.b.a("alerts.conf", new String[]{"libFramework", "Alerts", "LocalFile"});
      if(com.ihs.app.b.c.d()) {
         (new File(HSApplication.a().getFilesDir() + "/" + a)).delete();
      }

   }

   // $FF: synthetic method
   static void b(com.ihs.app.alerts.impl.b var0) {
      if(var0.e != null) {
         var0.e.e();
         var0.e = null;
      }

   }

   static SharedPreferences d() {
      return HSApplication.a().getSharedPreferences("HSAlerts", 0);
   }

   final com.ihs.app.alerts.impl.c a(String var1) {
      Iterator var3 = this.g.iterator();
      int var2 = 0;

      while(true) {
         if(!var3.hasNext()) {
            var2 = -1;
            break;
         }

         if(TextUtils.equals(var1, ((com.ihs.app.alerts.impl.c)var3.next()).a)) {
            break;
         }

         ++var2;
      }

      return var2 < 0?null:(com.ihs.app.alerts.impl.c)this.g.get(var2);
   }

   public final void c() {
      this.h = false;
      com.ihs.app.alerts.impl.c var1 = this.a("RateAlert");
      if(var1 != null) {
         var1.a(false);
         this.a(var1);
      }

   }
}
