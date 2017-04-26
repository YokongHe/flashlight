package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.ge;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$a$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$l$a;
import com.tapjoy.internal.gk$n;
import com.tapjoy.internal.gk$p;
import com.tapjoy.internal.gk$u;
import com.tapjoy.internal.gk$x;
import com.tapjoy.internal.gk$x$a;
import com.tapjoy.internal.y$a;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public final class fy {
   public static final String a = UUID.randomUUID().toString();
   private static fy b;
   private final gk$l$a c;
   private final gk$a$a d;
   private final gk$x$a e;
   private final Context f;
   private final ge g;

   private fy(Context var1, ge var2) {
      Object var12 = null;
      super();
      gh.a();
      this.c = gk$l.M();
      this.d = gk$a.o();
      this.e = gk$x.aa();
      this.c.k("11.0.3/Android").e("Android").f(VERSION.RELEASE).c(Build.MANUFACTURER).d(Build.MODEL).g(Locale.getDefault().toString()).h(TimeZone.getDefault().getID());
      Context var13 = var1.getApplicationContext();
      this.f = var13;
      String var20 = Secure.getString(var13.getContentResolver(), "android_id");
      if(!"9774d56d682e549c".equals(var20)) {
         var20 = com.tapjoy.internal.cv.b(var20);
      } else {
         var20 = null;
      }

      String var11 = var20;
      if(var20 == null) {
         File var21 = com.tapjoy.internal.w.a(var13);
         File var27 = new File(fv.b(var13), "deviceid");
         if(var21 != null) {
            var21 = new File(var21, ".io.5rocks");
         } else {
            var21 = null;
         }

         var11 = com.tapjoy.internal.ab.a(var27, var21);
      }

      this.c.b(var11);
      var20 = com.tapjoy.internal.ac.a(var13);
      if(var20 != null) {
         this.c.a(var20.replace(":", "").toLowerCase(Locale.US));
      }

      PackageManager var29 = var13.getPackageManager();
      TelephonyManager var23 = (TelephonyManager)var13.getSystemService("phone");
      if(var23 != null) {
         String var14 = var23.getSimCountryIso();
         if(!com.tapjoy.internal.cv.c(var14)) {
            this.c.l(var14.toUpperCase(Locale.US));
         }

         var14 = var23.getNetworkCountryIso();
         if(!com.tapjoy.internal.cv.c(var14)) {
            this.c.m(var14.toUpperCase(Locale.US));
         }

         if(var29.checkPermission("android.permission.READ_PHONE_STATE", var13.getPackageName()) == 0) {
            try {
               var20 = var23.getDeviceId();
               if(!com.tapjoy.internal.cv.c(var20)) {
                  this.c.n(var20);
               }
            } catch (SecurityException var18) {
               ;
            } catch (RuntimeException var19) {
               ;
            }
         }
      }

      String var31 = var13.getPackageName();
      this.c.i(var31);
      gk$l$a var32 = this.c;
      Signature[] var15 = com.tapjoy.internal.af.e(var29, var31);
      var20 = (String)var12;
      if(var15 != null) {
         var20 = (String)var12;
         if(var15.length > 0) {
            var20 = Base64.encodeToString(com.tapjoy.internal.cn.a(var15[0].toByteArray()), 2);
         }
      }

      var32.j(com.tapjoy.internal.cv.a(var20));
      this.d.a(com.tapjoy.internal.af.a(var29, var31));
      this.d.a(com.tapjoy.internal.af.b(var29, var31));
      var20 = var29.getInstallerPackageName(var31);
      if(!com.tapjoy.internal.cv.c(var20)) {
         this.d.c(var20);
      }

      var20 = a(var29, var31);
      if(!com.tapjoy.internal.cv.c(var20)) {
         this.d.d(var20);
      }

      this.a();
      this.g = var2;
      var20 = this.g.c.a();
      if(var20 != null && var20.length() > 0) {
         this.c.k(var20 + " 11.0.3/Android");
      }

      var20 = this.g.b();
      if(var20 != null) {
         this.e.a(var20);
      }

      gk$x$a var25 = this.e;
      var2 = this.g;
      long var8 = var2.b.getLong("it", 0L);
      long var6 = var8;
      if(var8 == 0L) {
         Context var30 = var2.a;
         var8 = com.tapjoy.internal.af.c(var30.getPackageManager(), var30.getPackageName());
         var6 = var8;
         if(var8 == 0L) {
            var8 = fv.c(var2.a).lastModified();
            var6 = var8;
            if(var8 == 0L) {
               var30 = var2.a;
               var8 = (new File(com.tapjoy.internal.af.d(var30.getPackageManager(), var30.getPackageName()))).lastModified();
               var6 = var8;
               if(var8 == 0L) {
                  var6 = System.currentTimeMillis();
               }
            }
         }

         var2.b.edit().putLong("it", var6).commit();
      }

      var25.a(var6);
      int var5 = this.g.f.b();
      this.e.a(a(7, var5));
      this.e.b(a(30, var5));
      var5 = this.g.h.b();
      if(var5 > 0) {
         this.e.e(var5);
      }

      var6 = this.g.i.a();
      if(var6 > 0L) {
         this.e.b(var6);
      }

      var6 = this.g.j.a();
      if(var6 > 0L) {
         this.e.c(var6);
      }

      var6 = this.g.k.a();
      if(var6 > 0L) {
         this.e.d(var6);
      }

      var20 = this.g.l.a();
      if(var20 != null) {
         this.e.b(var20);
      }

      var5 = this.g.m.b();
      if(var5 > 0) {
         this.e.f(var5);
      }

      double var3 = this.g.n.a();
      if(var3 != 0.0D) {
         this.e.a(var3);
      }

      var6 = this.g.o.a();
      if(var6 > 0L) {
         this.e.e(var6);
      }

      var3 = this.g.p.a();
      if(var3 != 0.0D) {
         this.e.b(var3);
      }

      var20 = this.g.g.a();
      if(var20 != null) {
         try {
            gk$u var26 = gk$u.a(Base64.decode(var20, 2));
            this.e.h();
            this.e.a((Iterable)var26.e());
         } catch (IllegalArgumentException var16) {
            this.g.g.c();
         } catch (IOException var17) {
            this.g.g.c();
         }
      }

      var20 = this.g.q.a();
      if(var20 != null) {
         this.d.b(var20);
      } else {
         this.d.h();
      }

      var20 = this.g.r.a();
      if(var20 != null) {
         this.e.d(var20);
      } else {
         this.e.o();
      }

      var5 = this.g.s.a().intValue();
      if(var5 != -1) {
         this.e.g(var5);
      } else {
         this.e.r();
      }

      var5 = this.g.t.a().intValue();
      if(var5 != -1) {
         this.e.h(var5);
      } else {
         this.e.u();
      }

      var20 = this.g.u.a();
      if(var20 != null) {
         this.e.e(var20);
      } else {
         this.e.x();
      }

      var20 = this.g.v.a();
      if(var20 != null) {
         this.e.f(var20);
      } else {
         this.e.A();
      }

      var20 = this.g.w.a();
      if(var20 != null) {
         this.e.g(var20);
      } else {
         this.e.D();
      }

      var20 = this.g.x.a();
      if(var20 != null) {
         this.e.h(var20);
      } else {
         this.e.G();
      }

      var20 = this.g.y.a();
      if(var20 != null) {
         this.e.i(var20);
      } else {
         this.e.J();
      }

      var20 = this.g.z.a();
      boolean var10 = this.g.A.a().booleanValue();
      if(var20 != null) {
         this.e.c(var20);
         this.e.a(var10);
      } else {
         this.e.k();
         this.e.l();
      }

      Runnable var28 = new Runnable() {
         public final void run() {
            // $FF: Couldn't be decompiled
         }
      };
      Looper var22 = Looper.myLooper();
      boolean var24;
      if(var22 != null && var22 == Looper.getMainLooper()) {
         var24 = true;
      } else {
         var24 = false;
      }

      if(var24) {
         (new y$a(var28)).execute(new Void[0]);
      } else {
         var28.run();
      }
   }

   private static int a(int var0, int var1) {
      return Integer.bitCount((1 << var0) - 1 & var1);
   }

   // $FF: synthetic method
   static Context a(fy var0) {
      return var0.f;
   }

   public static fy a(Context var0) {
      synchronized(fy.class){}

      fy var3;
      try {
         if(b == null) {
            b = new fy(var0, ge.a(var0));
         }

         var3 = b;
      } finally {
         ;
      }

      return var3;
   }

   private static String a(PackageManager param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static gk$x$a b(fy var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static ge c(fy var0) {
      return var0.g;
   }

   private void f() {
      String var1 = Base64.encodeToString(gk$u.f().a(this.e.f()).e().a(), 2);
      this.g.g.a(var1);
   }

   final void a() {
      // $FF: Couldn't be decompiled
   }

   public final void a(long var1) {
      synchronized(this) {
         var1 += this.g.i.a();
         this.g.i.a(var1);
         this.e.b(var1);
      }
   }

   public final void a(long var1, double var3) {
      synchronized(this) {
         Editor var5 = this.g.a();
         this.g.o.a(var5, var1);
         this.g.p.a(var5, var3);
         var5.commit();
         this.e.e(var1);
         this.e.b(var3);
      }
   }

   public final void a(long var1, long var3) {
      synchronized(this) {
         Editor var5 = this.g.a();
         this.g.j.a(var5, var1);
         this.g.k.a(var5, var3);
         var5.commit();
         this.e.c(var1);
         this.e.d(var3);
      }
   }

   final void a(String var1) {
      synchronized(this) {
         this.g.d.a(var1);
         this.e.a(var1);
      }
   }

   public final void a(String param1, double param2) {
      // $FF: Couldn't be decompiled
   }

   public final boolean a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final boolean a(int param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   final boolean a(String param1, long param2, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   public final gk$n b() {
      // $FF: Couldn't be decompiled
   }

   public final boolean b(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final boolean b(String param1) {
      // $FF: Couldn't be decompiled
   }

   final String c() {
      synchronized(this) {
         String var1 = this.g.d.a();
         return var1;
      }
   }

   public final boolean c(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final gk$p d() {
      // $FF: Couldn't be decompiled
   }

   public final boolean d(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void e() {
      synchronized(this) {
         int var1 = this.g.h.b() + 1;
         this.g.h.a(var1);
         this.e.e(var1);
      }
   }
}
