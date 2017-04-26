package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TJViewListener;
import com.tapjoy.internal.dz;
import java.util.Hashtable;
import java.util.Map;

public abstract class dy {
   private static final dy b;
   private static dy c;
   protected volatile boolean a = false;

   static {
      dz var0 = new dz();
      b = var0;
      c = var0;
   }

   public static dy a() {
      return c;
   }

   public abstract void a(float var1);

   public abstract void a(int var1);

   public abstract void a(int var1, TJAwardCurrencyListener var2);

   public abstract void a(int var1, TJSpendCurrencyListener var2);

   public abstract void a(int var1, String var2);

   public abstract void a(Activity var1);

   public abstract void a(GLSurfaceView var1);

   public abstract void a(TJEarnedCurrencyListener var1);

   public abstract void a(TJGetCurrencyBalanceListener var1);

   public abstract void a(TJOffersListener var1);

   public abstract void a(TJVideoListener var1);

   public abstract void a(TJViewListener var1);

   public abstract void a(String var1);

   public abstract void a(String var1, long var2);

   public abstract void a(String var1, String var2);

   public abstract void a(String var1, String var2, double var3, String var5);

   public abstract void a(String var1, String var2, long var3);

   public abstract void a(String var1, String var2, String var3, String var4);

   public abstract void a(String var1, String var2, String var3, String var4, long var5);

   public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6);

   public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6, String var8, long var9);

   public abstract void a(String var1, String var2, String var3, String var4, String var5, long var6, String var8, long var9, String var11, long var12);

   public abstract void a(String var1, String var2, String var3, String var4, Map var5);

   public abstract void a(String var1, boolean var2);

   public abstract void a(String var1, boolean var2, TJOffersListener var3);

   public abstract void a(boolean var1);

   public abstract boolean a(Context var1, String var2);

   public abstract boolean a(Context var1, String var2, Hashtable var3, TJConnectListener var4);

   public abstract String b();

   public abstract void b(int var1);

   public abstract void b(Activity var1);

   public abstract void b(String var1);

   public abstract void c();

   public abstract void c(String var1);

   public abstract float d();

   public abstract void d(String var1);

   public abstract void e();

   public abstract void e(String var1);

   public abstract void f();

   public abstract void f(String var1);

   public abstract boolean g();
}
