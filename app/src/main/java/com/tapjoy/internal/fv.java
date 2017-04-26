package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fp;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.ft;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.fx;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gg;
import com.tapjoy.internal.gk$c$a;
import com.tapjoy.internal.gk$i;
import com.tapjoy.internal.gk$n;
import com.tapjoy.internal.gk$p;
import com.tapjoy.internal.gs;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class fv {
   private static final fv a;
   private static fv b;
   private static Handler u;
   private static File v;
   private final gd c = new gd(this);
   private boolean d = false;
   private boolean e = false;
   private String f = null;
   private boolean g = false;
   private Context h;
   private fy i;
   private fu j;
   private gg k;
   private ft l;
   private String m;
   private boolean n;
   private String o;
   private String p;
   private String q;
   private String r;
   private String s;
   private fw t = fw.a((fm)null);

   static {
      fv var0 = new fv();
      a = var0;
      b = var0;
   }

   // $FF: synthetic method
   static Context a(fv var0) {
      return var0.h;
   }

   public static fv a() {
      return b;
   }

   public static fv a(Context var0) {
      fv var1 = b;
      var1.d(var0);
      return var1;
   }

   public static String a(Context var0, Intent var1) {
      String var2 = com.tapjoy.internal.f.a(var1);
      if(var2 != null) {
         fv var3 = b;
         var3.d(var0);
         if(com.tapjoy.internal.cv.c(var3.i.c()) || var1.getBooleanExtra("fiverocks:force", false)) {
            var3.i.a(var2);
            if(var2.length() > 0) {
               fu var4 = var3.j;
               var4.a(var4.a(gk$i.a, "referrer"));
            }
         }
      }

      return var2;
   }

   public static void a(GLSurfaceView var0) {
      if(fs.a((Object)var0, (String)"setGLSurfaceView: The given GLSurfaceView was null")) {
         fp.a(var0);
      }
   }

   public static void a(Runnable var0) {
      synchronized(fv.class){}

      try {
         if(u == null) {
            u = new Handler(Looper.getMainLooper());
         }

         u.post(var0);
      } finally {
         ;
      }

   }

   static File b(Context var0) {
      synchronized(fv.class){}

      File var3;
      try {
         if(v == null) {
            v = var0.getDir("fiverocks", 0);
         }

         var3 = v;
      } finally {
         ;
      }

      return var3;
   }

   static File c(Context var0) {
      return new File(b(var0), "install");
   }

   private void d(Context var1) {
      synchronized(this){}

      try {
         if(this.h == null) {
            var1 = var1.getApplicationContext();
            this.h = var1;
            this.i = fy.a(var1);
            File var4 = new File(b(var1), "events2");
            if(this.l == null) {
               this.l = new ft(var4);
            }

            this.j = new fu(this.i, this.l);
            this.k = new gg(this.j);
         }
      } finally {
         ;
      }

   }

   private boolean g(String var1) {
      if((this.n || this.m != null) && this.h != null) {
         return true;
      } else {
         if(fs.a) {
            fs.b(var1 + ": Should be called after initializing the SDK");
         }

         return false;
      }
   }

   private boolean h(String var1) {
      if(this.h == null) {
         if(fs.a) {
            fs.b(var1 + ": Should be called after initializing the SDK");
         }

         return false;
      } else {
         return true;
      }
   }

   private void i() {
      synchronized(this){}

      try {
         if(this.n) {
            fx.a(this.h).d(this.f);
            this.c((String)null);
         }
      } finally {
         ;
      }

   }

   private void j() {
      boolean var1 = true;
      gg var2 = this.k;
      if(var2.c != null) {
         var2.c.cancel(false);
         var2.c = null;
      }

      if(var2.b.compareAndSet(false, true)) {
         fs.a("New session started");
         fu var6 = var2.a;
         gk$p var3 = var6.a.d();
         var6.a.e();
         gk$c$a var4 = var6.a(gk$i.a, "bootup");
         var6.c = SystemClock.elapsedRealtime();
         if(var3 != null) {
            var4.a(var3);
         }

         var6.a(var4);
      } else {
         var1 = false;
      }

      if(var1) {
         gd var7 = this.c;
         synchronized(var7) {
            var7.b = null;
         }
      }

   }

   public final gs a(String var1, Context var2) {
      gd var3 = this.c;
      gk$n var4 = var3.a.b(false);
      return new gs(var3.a, var4.f(), var4.h(), var4.j(), var1, var2);
   }

   public final void a(int var1) {
      if(this.h("setUserLevel")) {
         int var2 = var1;
         if(var1 < -1) {
            var2 = -1;
         }

         this.i.a(var2);
      }
   }

   public final void a(int var1, String var2) {
      if(this.h("setUserCohortVariable")) {
         boolean var3;
         if(var1 > 0 && var1 <= 5) {
            var3 = true;
         } else {
            var3 = false;
         }

         if(fs.a && !var3) {
            fs.b("setCohortVariable: variableIndex is out of range");
         }

         if(var3) {
            var2 = fr.a(var2);
            this.i.a(var1, var2);
            return;
         }
      }

   }

   public final void a(Activity var1) {
      if(fs.a((Object)var1, (String)"onActivityStart: The given activity was null")) {
         fs.c("onActivityStart");
         com.tapjoy.internal.d.a(var1.getApplication());
         com.tapjoy.internal.d.a(var1);
         if(this.g("onActivityStart")) {
            this.j();
            return;
         }
      }

   }

   public final void a(Context param1, String param2, String param3, String param4, String param5, String param6) {
      // $FF: Couldn't be decompiled
   }

   public final void a(fm var1) {
      this.t = fw.a(var1);
   }

   public final void a(String var1) {
      this.m = var1;
   }

   public final void a(String var1, String var2) {
      if(this.g("trackPurchase")) {
         com.tapjoy.internal.g var6;
         try {
            var6 = new com.tapjoy.internal.g(var1);
         } catch (IOException var5) {
            fs.a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            return;
         }

         String var3 = fr.b(var6.a);
         String var4 = fr.b(var6.f);
         if(var3 != null && var4 != null) {
            if(var4.length() != 3) {
               fs.a("trackPurchase", "skuDetails", "invalid currency code");
            } else {
               var4 = var4.toUpperCase(Locale.US);
               var2 = fr.b(var2);
               this.j.a(var3, var4, (double)var6.g / 1000000.0D, var2);
            }
         } else {
            fs.a("trackPurchase", "skuDetails", "insufficient fields");
         }
      }
   }

   public final void a(String var1, String var2, double var3, String var5) {
      if(this.g("trackPurchase")) {
         var1 = fr.a(var1, "trackPurchase", "productId");
         if(var1 != null) {
            var2 = fr.a(var2, "trackPurchase", "currencyCode");
            if(var2 != null) {
               if(var2.length() != 3) {
                  fs.a("trackPurchase", "currencyCode", "invalid currency code");
                  return;
               }

               var2 = var2.toUpperCase(Locale.US);
               var5 = fr.b(var5);
               this.j.a(var1, var2, var3, var5);
               return;
            }
         }
      }

   }

   public final void a(String var1, String var2, String var3, String var4, long var5) {
      if(this.h("trackEvent") && fs.a((Object)var2, (String)"trackEvent: name was null")) {
         LinkedHashMap var7 = null;
         if(var5 != 0L) {
            var7 = com.tapjoy.internal.cz.b();
            var7.put("value", Long.valueOf(var5));
         }

         this.j.a(var1, var2, var3, var4, var7);
      }
   }

   public final void a(String var1, String var2, String var3, String var4, String var5, long var6, String var8, long var9, String var11, long var12) {
      if(this.h("trackEvent") && fs.a((Object)var2, (String)"trackEvent: name was null")) {
         LinkedHashMap var14 = com.tapjoy.internal.cz.b();
         if(var5 != null && var6 != 0L) {
            var14.put(var5, Long.valueOf(var6));
         }

         if(var8 != null && var9 != 0L) {
            var14.put(var8, Long.valueOf(var9));
         }

         if(var11 != null && var12 != 0L) {
            var14.put(var11, Long.valueOf(var12));
         }

         LinkedHashMap var15 = var14;
         if(var14.isEmpty()) {
            var15 = null;
         }

         this.j.a(var1, var2, var3, var4, var15);
      }
   }

   public final void a(String var1, String var2, String var3, String var4, Map var5) {
      LinkedHashMap var6;
      label40: {
         if(this.g("trackEvent") && !com.tapjoy.internal.cv.c(var2)) {
            var6 = com.tapjoy.internal.cz.b();
            if(var5 == null || var5.size() <= 0) {
               break label40;
            }

            Iterator var9 = var5.entrySet().iterator();

            while(true) {
               if(!var9.hasNext()) {
                  break label40;
               }

               Entry var7 = (Entry)var9.next();
               Object var8 = var7.getKey();
               if(var8 == null) {
                  if(fs.a) {
                     com.tapjoy.internal.ad.a("Tapjoy", "{}: {} must not be null", new Object[]{"trackEvent", "key in values map"});
                     return;
                  }
                  break;
               }

               if(var8 instanceof String) {
                  String var11 = fr.a((String)var8, "trackEvent", "key in values map");
                  if(var11 == null) {
                     break;
                  }

                  Object var10 = var7.getValue();
                  if(!(var10 instanceof Number)) {
                     fs.a("trackEvent", "value in values map", "must be a long");
                     return;
                  }

                  var6.put(var11, Long.valueOf(((Number)var10).longValue()));
               }
            }
         }

         return;
      }

      this.j.a(var1, var2, var3, var4, var6);
   }

   final void a(Map var1) {
      fu var2 = this.j;
      gk$c$a var3 = var2.a(gk$i.b, "impression");
      if(var1 != null) {
         var3.c(com.tapjoy.internal.bn.a((Object)var1));
      }

      var2.a(var3);
   }

   final void a(Map var1, long var2) {
      fu var4 = this.j;
      gk$c$a var5 = var4.a(gk$i.b, "view").d(var2);
      if(var1 != null) {
         var5.c(com.tapjoy.internal.bn.a((Object)var1));
      }

      var4.a(var5);
   }

   final void a(Map var1, String var2) {
      fu var3 = this.j;
      gk$c$a var4 = var3.a(gk$i.b, "click");
      LinkedHashMap var5 = new LinkedHashMap(var1);
      var5.put("region", var2);
      var4.c(com.tapjoy.internal.bn.a((Object)var5));
      var3.a(var4);
   }

   public final void a(boolean var1) {
      boolean var2;
      if(fs.a != var1) {
         fs.a = var1;
         if(var1) {
            fs.a("The debug mode has been enabled");
         } else {
            fs.a("The debug mode has been disabled");
         }

         var2 = true;
      } else {
         var2 = false;
      }

      if(var2 && var1 && this.n) {
         this.l.a();
      }

   }

   final boolean a(Context var1, String var2, boolean var3) {
      long var4 = System.currentTimeMillis();
      this.d(var1);
      if(this.i.a(var2, var4, var3)) {
         fu var7 = this.j;
         gk$c$a var6 = var7.a(gk$i.a, "push_show");
         var6.a(gk$p.k().c(var2));
         var7.a(var6);
         return true;
      } else {
         return false;
      }
   }

   public final gk$n b(boolean var1) {
      if(var1) {
         this.i.a();
      }

      return this.i.b();
   }

   public final void b() {
      if(!this.d) {
         this.d = true;
         boolean var1 = this.n;
      }

   }

   public final void b(int var1) {
      if(this.h("setUserFriendCount")) {
         int var2 = var1;
         if(var1 < -1) {
            var2 = -1;
         }

         this.i.b(var2);
      }
   }

   public final void b(Activity var1) {
      if(fs.a((Object)var1, (String)"onActivityStop: The given activity was null")) {
         fs.c("onActivityStop");
         com.tapjoy.internal.d.b(var1);
         if(this.g("onActivityStop") && !com.tapjoy.internal.d.b()) {
            this.k.a();
            return;
         }
      }

   }

   public final void b(String var1) {
      this.f = com.tapjoy.internal.cv.a(var1);
      this.i();
   }

   public final String c() {
      return this.o;
   }

   final void c(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final String d() {
      return this.p;
   }

   public final void d(String var1) {
      if(this.i.d(var1)) {
         fu var2 = this.j;
         gk$c$a var3 = var2.a(gk$i.a, "push_click");
         var3.a(gk$p.k().c(var1));
         var2.a(var3);
      }

   }

   public final void e(String var1) {
      if(this.h("setAppDataVersion")) {
         var1 = fr.a(var1);
         this.i.b(var1);
      }
   }

   final boolean e() {
      return this.k != null && this.k.b.get();
   }

   public final void f() {
      if(this.g("startSession")) {
         this.j();
      }
   }

   public final void f(String var1) {
      if(this.h("setUserId")) {
         var1 = fr.a(var1);
         this.i.c(var1);
      }
   }

   public final void g() {
      if(this.g("endSession")) {
         this.k.a();
      }
   }

   public final fw h() {
      return this.t;
   }
}
