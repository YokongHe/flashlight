package com.flurry.sdk;

import android.widget.Toast;
import com.flurry.sdk.de;
import com.flurry.sdk.de$a;
import com.flurry.sdk.dj;
import com.flurry.sdk.dl;
import com.flurry.sdk.do;
import com.flurry.sdk.dp;
import com.flurry.sdk.dq;
import com.flurry.sdk.dq$a;
import com.flurry.sdk.el;
import com.flurry.sdk.el$a;
import com.flurry.sdk.em;
import com.flurry.sdk.en$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.ew;
import com.flurry.sdk.ex;
import com.flurry.sdk.ff;

public class dd extends de implements dq$a {
   static String a;
   static String b = "http://data.flurry.com/aap.do";
   static String c = "https://data.flurry.com/aap.do";
   private static final String h = dd.class.getSimpleName();
   private boolean i;

   public dd() {
      this((de$a)null);
   }

   dd(de$a var1) {
      super("Analytics", dd.class.getSimpleName());
      this.g = "AnalyticsData_";
      this.g();
      this.a(var1);
   }

   private void b(String var1) {
      if(var1 != null && !var1.endsWith(".do")) {
         eo.a(5, h, "overriding analytics agent report URL without an endpoint, are you sure?");
      }

      a = var1;
   }

   private void g() {
      dq var1 = dp.a();
      this.i = ((Boolean)var1.a("UseHttps")).booleanValue();
      var1.a((String)"UseHttps", (dq$a)this);
      eo.a(4, h, "initSettings, UseHttps = " + this.i);
      String var2 = (String)var1.a("ReportUrl");
      var1.a((String)"ReportUrl", (dq$a)this);
      this.b(var2);
      eo.a(4, h, "initSettings, ReportUrl = " + var2);
   }

   String a() {
      return a != null?a:(this.i?c:b);
   }

   public void a(String var1, Object var2) {
      if(var1.equals("UseHttps")) {
         this.i = ((Boolean)var2).booleanValue();
         eo.a(4, h, "onSettingUpdate, UseHttps = " + this.i);
      } else if(var1.equals("ReportUrl")) {
         var1 = (String)var2;
         this.b(var1);
         eo.a(4, h, "onSettingUpdate, ReportUrl = " + var1);
      } else {
         eo.a(6, h, "onSettingUpdate internal error!");
      }
   }

   protected void a(String var1, String var2, final int var3) {
      this.a(new ff() {
         public void a() {
            if(var3 == 200) {
               dj var1 = dl.a().c();
               if(var1 != null) {
                  var1.b();
               }
            }

         }
      });
      super.a(var1, var2, var3);
   }

   protected void a(byte[] var1, final String var2, final String var3) {
      String var4 = this.a();
      eo.a(4, h, "FlurryDataSender: start upload data " + var1 + " with id = " + var2 + " to " + var4);
      el var5 = new el();
      var5.a((String)var4);
      var5.a((en$a)en$a.c);
      var5.a("Content-Type", "application/octet-stream");
      var5.a((ex)(new ew()));
      var5.a((Object)var1);
      var5.a(new el$a() {
         public void a(el var1, Void var2x) {
            final int var3x = var1.e();
            if(var3x > 0) {
               eo.d(dd.h, "FlurryDataSender: report " + var2 + " sent. HTTP response: " + var3x);
               if(eo.c() <= 3 && eo.d()) {
                  do.a().a(new Runnable() {
                     public void run() {
                        Toast.makeText(do.a().b(), "SD HTTP Response Code: " + var3x, 0).show();
                     }
                  });
               }

               dd.this.a(var2, var3, var3x);
               dd.this.d();
            } else {
               dd.this.b(var2, var3);
            }
         }
      });
      em.a().a(this, var5);
   }
}
