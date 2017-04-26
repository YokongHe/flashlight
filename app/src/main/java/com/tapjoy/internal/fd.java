package com.tapjoy.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TimingLogger;
import android.view.WindowManager;
import com.tapjoy.internal.ec;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.eh;
import com.tapjoy.internal.ej;
import com.tapjoy.internal.el;
import com.tapjoy.internal.el$a;
import com.tapjoy.internal.em;
import com.tapjoy.internal.ex;
import com.tapjoy.internal.ey;
import com.tapjoy.internal.ez;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(9)
class fd {
   public static String a = "2.5-16";
   private static final String t = fd.class.getSimpleName();
   private volatile AtomicBoolean A = null;
   private volatile em B;
   private ed C;
   private String D;
   private String E;
   String b = null;
   String c = null;
   String d = null;
   String e = null;
   int f = 0;
   int g = 0;
   int h = 0;
   int i = 0;
   String j = null;
   String k = null;
   String l = null;
   String m = null;
   int n = 0;
   String o = null;
   String p = null;
   Location q = null;
   ArrayList r = null;
   ey s = null;
   private String u = null;
   private String v = null;
   private String w = null;
   private Context x = null;
   private String y = null;
   private TimingLogger z = null;

   fd() {
      this.B = em.b;
      this.C = new ed();
      this.D = null;
      this.E = null;
   }

   final void a() {
      this.e = null;
      this.f = 0;
      this.g = 0;
      this.m = null;
      this.q = null;
      this.s = null;
   }

   final void a(Context var1) {
      this.x = var1;
   }

   final void a(Location var1) {
      this.q = var1;
   }

   final void a(ed var1) {
      this.C = var1;
   }

   final void a(em var1) {
      this.B = var1;
   }

   final void a(ey var1) {
      this.s = var1;
   }

   final void a(String var1) {
      this.b = var1;
   }

   final void a(AtomicBoolean var1) {
      this.A = var1;
   }

   final boolean a(String var1, String var2) {
      String var3;
      label22: {
         if(var2 != null) {
            var3 = var2;
            if(!var2.isEmpty()) {
               break label22;
            }
         }

         var3 = "TrustDefenderMobileSDK";
      }

      this.k = "http://" + var3;
      if(var1 != null && var1.length() > 0) {
         this.j = var1;
         if(var1.compareToIgnoreCase(this.k) == 0) {
            this.j = var1 + "mobile";
         }
      } else {
         this.j = "http://" + var3 + "/mobile";
      }

      return true;
   }

   final String b() {
      return this.b;
   }

   final boolean b(String var1) {
      String var2 = var1;
      if(var1 == null) {
         var2 = "h.online-metrix.net";
      }

      try {
         new URL("https://" + var2);
      } catch (MalformedURLException var3) {
         Log.e(t, "Invalid hostname " + var2, var3);
         return false;
      }

      this.p = var2;
      return true;
   }

   final em c() {
      String var1 = t;
      (new StringBuilder("getStatus returns: ")).append(this.B.toString());
      return this.B;
   }

   final boolean c(String var1) {
      if(var1 != null && var1.length() == 8) {
         this.o = var1;
         return true;
      } else {
         Log.e(t, "Invalid org_id");
         return false;
      }
   }

   final ey d() {
      return this.s;
   }

   final String e() {
      return this.p;
   }

   final String f() {
      return this.o;
   }

   final boolean g() {
      this.n = 3097;
      return true;
   }

   final String h() {
      return "https://" + this.p + "/fp/mobile/conf";
   }

   final ej i() {
      ej var1 = new ej();
      var1.a("org_id", this.o);
      var1.a("session_id", this.b);
      var1.a("os", "android");
      var1.a("osVersion", VERSION.RELEASE);
      if(this.y != null && !this.y.isEmpty()) {
         var1.a("api_key", this.y);
      }

      return var1;
   }

   final void j() {
      String var3 = null;
      String var2 = t;
      if((this.n & 8) != 0) {
         el$a var5 = new el$a();
         if(el.a(var5)) {
            this.g = var5.b;
            this.f = var5.a;
         }

         if(this.z != null) {
            this.z.addSplit("get time zone");
         }
      }

      if(this.e == null || this.c == null || this.d == null) {
         boolean var1;
         if((this.n & 512) != 0 && ez.a()) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(this.e == null) {
            var2 = ez.b(this.x);
            this.e = ez.b(var2, var1);
         } else {
            var2 = null;
         }

         if(this.z != null) {
            this.z.addSplit("cookie");
         }

         if(this.d == null) {
            var3 = ez.a(this.x);
            if(this.A != null && this.A.get()) {
               throw new InterruptedException();
            }

            this.d = ez.a(var3, var1);
         }

         if(this.z != null) {
            this.z.addSplit("LSC");
         }

         if(this.u == null) {
            this.u = ez.c(this.x);
            if(this.z != null) {
               this.z.addSplit("imei");
            }
         }

         if(this.c == null) {
            String var4 = var2;
            if(var2 == null) {
               var4 = ez.b(this.x);
            }

            var2 = var3;
            if(var3 == null) {
               var2 = ez.a(this.x);
            }

            if(this.A != null && this.A.get()) {
               throw new InterruptedException();
            }

            Context var6 = this.x;
            this.c = ez.a(var4, var2, this.u, var1);
         }

         if(this.z != null) {
            this.z.addSplit("Flash");
         }
      }

      if((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
         if((this.n & 16) != 0 && (this.i == 0 || this.h == 0)) {
            eh var7 = new eh(((WindowManager)this.x.getSystemService("window")).getDefaultDisplay());
            this.h = var7.a();
            this.i = var7.b();
         }

         if(this.z != null) {
            this.z.addSplit("get screen dimensions");
         }

         if((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
            this.m = el.a();
            if(this.z != null) {
               this.z.addSplit("get device state");
            }

            if((this.A == null || !this.A.get()) && !Thread.currentThread().isInterrupted()) {
               if(this.l == null) {
                  this.l = el.a(this.x, this.x);
               }

               if(this.z != null) {
                  this.z.addSplit("get device fingerprint");
               }

               if((this.n & 2048) != 0 && this.E == null) {
                  this.E = ec.a(this.x);
                  if(this.z != null) {
                     this.z.addSplit("get self hash");
                  }
               }

               if(this.w == null || this.v == null) {
                  StringBuilder var8 = new StringBuilder();
                  this.v = el.a(var8);
                  if(this.v != null) {
                     this.w = var8.toString();
                  }

                  var2 = t;
                  (new StringBuilder("Got ")).append(this.w).append(" fonts gives: ").append(this.v);
               }

               if(this.z != null) {
                  this.z.addSplit("Get Fontlist");
               }

            } else {
               throw new InterruptedException();
            }
         } else {
            throw new InterruptedException();
         }
      } else {
         throw new InterruptedException();
      }
   }

   final Map k() {
      HashMap var1 = new HashMap();
      var1.put("User-Agent", this.D);
      return var1;
   }

   final Map l() {
      HashMap var1 = new HashMap();
      if(this.D != null && !this.D.isEmpty()) {
         String var2 = t;
         (new StringBuilder("Setting User-Agent to ")).append(this.D);
         var1.put("User-Agent", this.D);
      }

      if(this.e == null) {
         var1.put("Cookie", "thx_guid=");
      } else {
         var1.put("Cookie", "thx_guid=" + this.e);
      }

      var1.put("Referer", this.k);
      var1.put("Content-Type", "application/x-www-form-urlencoded");
      return var1;
   }

   final ej m() {
      List var4 = el.a(this.x, (List)this.s.c);
      int var3 = var4.size();
      String var6 = ex.a(var4, ";");
      if(this.z != null) {
         this.z.addSplit("Check URLs");
      }

      String var10 = "";
      String var5;
      if((this.s.a & 256) != 0) {
         var5 = el.a((List)this.s.d);
         var10 = var5;
         if(this.z != null) {
            this.z.addSplit("get URLs");
            var10 = var5;
         }
      }

      ej var7 = new ej();
      var7.a();
      var7.a("w", this.s.b);
      var7.a("c", String.valueOf(this.f));
      var7.a("z", String.valueOf(this.g));
      var7.a("f", this.h + "x" + this.i);
      var7.b("lh", this.j);
      var7.b("dr", this.k);
      if(!this.C.b.equals("0")) {
         var7.b("p", this.C.a);
         var7.b("pl", this.C.b);
         var7.b("ph", this.C.d);
      }

      var7.a("hh", ex.b(this.o + this.b));
      if(this.C.f > 0) {
         var7.a("mt", this.C.h);
         var7.a("mn", String.valueOf(this.C.f));
      }

      var7.b("mdf", this.l);
      var7.b("mds", this.m);
      var7.b("imei", this.u);
      if(this.q != null) {
         var7.a("tdlat", String.valueOf(this.q.getLatitude()));
         var7.a("tdlon", String.valueOf(this.q.getLongitude()));
         var7.a("tdlacc", String.valueOf(this.q.getAccuracy()));
      }

      if(this.r != null && this.r.size() > 0) {
         Iterator var11 = this.r.iterator();

         int var2;
         for(int var1 = 0; var11.hasNext(); var1 = var2) {
            String var8 = (String)var11.next();
            StringBuilder var9 = new StringBuilder("aca");
            var2 = var1 + 1;
            var7.b(var9.append(var1).toString(), var8);
            if(var2 >= 5) {
               break;
            }
         }
      }

      var7.a("ah", this.E);
      var7.a("la", this.s.b + this.d);
      var7.a("lq", this.D);
      var5 = Integer.toString((new Random()).nextInt(10000) + 10000);
      var7.a("nu", var5.substring(var5.length() - 4));
      var7.a("fc", this.s.b + this.c);
      var7.a("ftsn", this.w);
      var7.b("fts", this.v);
      var7.b("v", VERSION.RELEASE);
      var7.b("o", Build.BRAND);
      var7.b("mf", Build.MODEL);
      var7.b("l", Locale.getDefault().getLanguage());
      var7.a("fg", this.c);
      var7.a("ls", this.d);
      if(this.s.c.size() == 0) {
         var5 = "";
      } else {
         var5 = String.valueOf(var3);
      }

      var7.a("gr", var5);
      var7.a("grr", var6);
      var7.a("at", "agent_mobile");
      var7.a("av", a);
      var7.a("ex3", var10);
      ej var12 = new ej();
      var12.a("org_id", this.o);
      var12.a("session_id", this.b);
      if(this.z != null) {
         this.z.addSplit("params without xor");
      }

      var5 = var7.b();
      if(this.z != null) {
         this.z.addSplit("url encoding");
      }

      var12.a("ja", ex.a(var5, this.b));
      var12.a("h", "0").a("m", "2");
      if(this.z != null) {
         this.z.addSplit("Params xor\'d");
      }

      return var12;
   }
}
