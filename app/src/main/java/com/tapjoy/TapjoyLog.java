package com.tapjoy;

import android.util.Log;
import com.tapjoy.internal.fv;
import java.util.ArrayList;

public class TapjoyLog {
   private static boolean a = false;
   private static boolean b = false;
   private static ArrayList c;

   public static void clearLogHistory() {
      if(c != null) {
         c.clear();
      }

   }

   public static void d(String var0, String var1) {
      if(a) {
         Log.d(var0, var1);
      }

      if(b) {
         c.add(var1);
      }

   }

   public static void e(String var0, String var1) {
      if(a) {
         Log.e(var0, var1);
      }

      if(b) {
         c.add(var1);
      }

   }

   public static ArrayList getLogHistory() {
      return c;
   }

   public static void i(String var0, String var1) {
      if(a) {
         if(var1.length() > 4096) {
            for(int var2 = 0; var2 <= var1.length() / 4096; ++var2) {
               int var4 = (var2 + 1) * 4096;
               int var3 = var4;
               if(var4 > var1.length()) {
                  var3 = var1.length();
               }

               Log.i(var0, var1.substring(var2 * 4096, var3));
            }
         } else {
            Log.i(var0, var1);
         }
      }

      if(b) {
         c.add(var1);
      }

   }

   public static boolean isLoggingEnabled() {
      return a;
   }

   public static void saveLogHistory(boolean var0) {
      b = var0;
      if(var0) {
         c = new ArrayList(1024);
      } else {
         c = null;
      }
   }

   public static void setDebugEnabled(boolean var0) {
      Log.i("TapjoyLog", "enableLogging: " + var0);
      a = var0;
      fv.a().a(var0);
   }

   public static void v(String var0, String var1) {
      if(a) {
         Log.v(var0, var1);
      }

      if(b) {
         c.add(var1);
      }

   }

   public static void w(String var0, String var1) {
      if(a) {
         Log.w(var0, var1);
      }

      if(b) {
         c.add(var1);
      }

   }
}
