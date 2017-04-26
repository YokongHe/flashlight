package com.nexage.android.a;

import android.os.Environment;
import android.util.Log;
import java.io.File;

public final class p {
   public static Boolean a = null;
   public static boolean b = true;
   public static boolean c = true;
   public static boolean d = false;
   private static ThreadLocal e = new ThreadLocal();

   public static void a() {
      try {
         (new Thread() {
            public final void run() {
               if((new File(Environment.getExternalStorageDirectory(), "NexageSDKLog")).exists()) {
                  com.nexage.android.a.p.a = Boolean.valueOf(false);
                  com.nexage.android.a.p.b = true;
               }

            }
         }).start();
      } catch (Exception var1) {
         ;
      }
   }

   public static void a(String var0) {
      if(a != null && !a.booleanValue() && b) {
         Log.v("NexageSDK", var0);
      }
   }

   public static void a(String var0, String var1) {
      if(a != null && !a.booleanValue() && b) {
         Log.v("NexageSDK", "[" + var0 + "] " + var1);
      }
   }

   public static void a(String var0, String var1, Throwable var2) {
      var0 = f(var0, var1);
      Log.e("NexageSDK", var0, var2);
      com.nexage.android.a.d.a(3, var0);
   }

   public static void b() {
      e.set((Object)null);
   }

   public static void b(String var0) {
      if(a != null && !a.booleanValue() && b) {
         Log.d("NexageSDK", f((String)null, var0));
      }
   }

   public static void b(String var0, String var1) {
      if(a != null && !a.booleanValue() && b) {
         Log.d("NexageSDK", f(var0, var1));
      }
   }

   public static void c(String var0) {
      if(a != null && !a.booleanValue()) {
         Log.i("NexageSDK", f((String)null, var0));
      }
   }

   public static void c(String var0, String var1) {
      if(a != null && !a.booleanValue()) {
         Log.i("NexageSDK", f(var0, var1));
      }
   }

   public static void d(String var0) {
      Log.w("NexageSDK", var0);
      com.nexage.android.a.d.a(2, var0);
   }

   public static void d(String var0, String var1) {
      var0 = f(var0, var1);
      Log.w("NexageSDK", var0);
      com.nexage.android.a.d.a(2, var0);
   }

   public static void e(String var0) {
      Log.e("NexageSDK", var0);
      com.nexage.android.a.d.a(3, var0);
   }

   public static void e(String var0, String var1) {
      var0 = f(var0, var1);
      Log.e("NexageSDK", var0);
      com.nexage.android.a.d.a(3, var0);
   }

   private static String f(String var0, String var1) {
      String var3 = (String)e.get();
      String var2 = var3;
      if(var3 == null) {
         var2 = "" + System.currentTimeMillis() % 10000L;
         e.set(var2);
      }

      if(var0 == null) {
         return var1;
      } else {
         StringBuilder var4 = new StringBuilder();
         if(var0 != null) {
            var4.append("[").append(var0);
            if(d) {
               var4.append(":").append(Thread.currentThread().getName());
            }

            var4.append("] ");
         }

         if(var2 != null) {
            var4.append("[").append(var2).append("] ");
         }

         var4.append(var1);
         return var4.toString();
      }
   }

   public static void f(String var0) {
      e.set(var0);
   }
}
