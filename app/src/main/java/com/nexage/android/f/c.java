package com.nexage.android.f;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class c extends com.nexage.android.e.b {
   private Class d;
   private Method e;
   private Method f;
   private Class g;
   private Class h;
   private Constructor i;
   private Method j;
   private Method k;
   private Method l;
   private View m;
   private Object n;

   public c(Activity var1, Handler var2) {
      super(var1, var2);
      com.nexage.android.a.p.b("GreystripeProvider", "entering constructor");

      try {
         this.d = Class.forName("com.greystripe.sdk.GSSdkInfo");
         this.e = this.d.getDeclaredMethod("getVersion", new Class[0]);
         this.f = this.d.getDeclaredMethod("updateLocation", new Class[]{Location.class});
         this.g = Class.forName("com.greystripe.sdk.GSAdListener");
         this.h = Class.forName("com.greystripe.sdk.GSMobileBannerAdView");
         this.i = this.h.getConstructor(new Class[]{Context.class, String.class});
         this.j = this.h.getDeclaredMethod("addListener", new Class[]{this.g});
         this.k = this.h.getDeclaredMethod("refresh", new Class[0]);
         this.l = this.h.getDeclaredMethod("removeListener", new Class[]{this.g});
         String var4 = (String)this.e.invoke((Object)null, new Object[0]);
         this.c = true;
         com.nexage.android.a.p.b("GreystripeProvider", "SDK is initialized using Greystripe version " + var4);
      } catch (Exception var3) {
         com.nexage.android.a.p.e("GreystripeProvider", "Failed to initialize Greystripe SDK.");
         com.nexage.android.a.p.e("GreystripeProvider", "Make sure that the Greystripe SDK JAR is in your classpath.");
         com.nexage.android.a.p.a("GreystripeProvider", "Failed here:", var3);
      }
   }

   // $FF: synthetic method
   static void a(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static boolean a(com.nexage.android.f.c var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static void b(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.b(var1);
   }

   // $FF: synthetic method
   static void c(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.c(var1);
   }

   // $FF: synthetic method
   static void d(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.d(var1);
   }

   // $FF: synthetic method
   static void e(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.d(var1);
   }

   // $FF: synthetic method
   static void f(com.nexage.android.f.c var0, com.nexage.android.e.b var1) {
      var0.e(var1);
   }

   protected final View a(int var1, int var2, String var3) {
      com.nexage.android.a.p.b("GreystripeProvider", "createAdView");
      this.m = null;

      try {
         if(com.nexage.android.b.x() != null) {
            Location var4 = com.nexage.android.b.x().a();
            this.f.invoke((Object)null, new Object[]{var4});
         }

         this.m = (View)this.i.newInstance(new Object[]{this.a, var3});
         if(this.m != null) {
            ClassLoader var7 = this.g.getClassLoader();
            Class var9 = this.g;
            com.nexage.android.f.d var5 = new com.nexage.android.f.d(this, (byte)0);
            this.n = Proxy.newProxyInstance(var7, new Class[]{var9}, var5);
            this.j.invoke(this.m, new Object[]{this.n});
            DisplayMetrics var8 = this.a.getResources().getDisplayMetrics();
            var1 = (int)TypedValue.applyDimension(1, (float)var1, var8);
            var2 = (int)TypedValue.applyDimension(1, (float)var2, var8);
            this.m.setLayoutParams(new LayoutParams(var1, var2));
         }
      } catch (Exception var6) {
         com.nexage.android.a.p.a("GreystripeProvider", "createAdView:", var6);
         this.m = null;
      }

      return this.m;
   }

   protected final void b() {
      com.nexage.android.a.p.b("GreystripeProvider", "loadAdView");

      try {
         this.k.invoke(this.m, new Object[0]);
      } catch (Exception var2) {
         com.nexage.android.a.p.a("GreystripeProvider", "loadAdView:", var2);
      }
   }

   protected final void c() {
      try {
         if(this.m != null && this.n != null) {
            this.l.invoke(this.m, new Object[]{this.n});
         }

      } catch (Exception var2) {
         com.nexage.android.a.p.a("GreystripeProvider", "loadAdView:", var2);
      }
   }
}
