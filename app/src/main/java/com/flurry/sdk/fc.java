package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.flurry.sdk.do;
import java.lang.reflect.Method;

public class fc {
   public static int a(int var0) {
      DisplayMetrics var1 = c();
      return Math.round((float)var0 / var1.density);
   }

   @SuppressLint({"NewApi"})
   public static Point a() {
      Display var0 = ((WindowManager)do.a().b().getSystemService("window")).getDefaultDisplay();
      Point var1 = new Point();
      if(VERSION.SDK_INT >= 17) {
         var0.getRealSize(var1);
         return var1;
      } else if(VERSION.SDK_INT >= 14) {
         try {
            Method var2 = Display.class.getMethod("getRawHeight", new Class[0]);
            var1.x = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(var0, new Object[0])).intValue();
            var1.y = ((Integer)var2.invoke(var0, new Object[0])).intValue();
            return var1;
         } catch (Throwable var3) {
            var0.getSize(var1);
            return var1;
         }
      } else if(VERSION.SDK_INT >= 13) {
         var0.getSize(var1);
         return var1;
      } else {
         var1.x = var0.getWidth();
         var1.y = var0.getHeight();
         return var1;
      }
   }

   public static int b(int var0) {
      DisplayMetrics var2 = c();
      float var1 = (float)var0;
      return Math.round(var2.density * var1);
   }

   public static DisplayMetrics b() {
      Display var0 = ((WindowManager)do.a().b().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var1 = new DisplayMetrics();
      var0.getMetrics(var1);
      return var1;
   }

   @SuppressLint({"NewApi"})
   public static DisplayMetrics c() {
      Display var0 = ((WindowManager)do.a().b().getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var1;
      if(VERSION.SDK_INT >= 17) {
         var1 = new DisplayMetrics();
         var0.getRealMetrics(var1);
         return var1;
      } else {
         if(VERSION.SDK_INT >= 14) {
            try {
               var1 = new DisplayMetrics();
               Display.class.getMethod("getRealMetrics", new Class[0]).invoke(var0, new Object[]{var1});
               return var1;
            } catch (Exception var2) {
               ;
            }
         }

         return b();
      }
   }

   public static Pair c(int var0) {
      int var1 = g();
      int var2 = h();
      switch(var0) {
      case 2:
         return Pair.create(Integer.valueOf(var2), Integer.valueOf(var1));
      default:
         return Pair.create(Integer.valueOf(var1), Integer.valueOf(var2));
      }
   }

   public static float d() {
      return c().density;
   }

   public static int e() {
      return a().x;
   }

   public static int f() {
      return a().y;
   }

   public static int g() {
      return a(e());
   }

   public static int h() {
      return a(f());
   }

   public static int i() {
      Point var0 = a();
      return var0.x == var0.y?3:(var0.x < var0.y?1:2);
   }

   public static Pair j() {
      return Pair.create(Integer.valueOf(g()), Integer.valueOf(h()));
   }
}
