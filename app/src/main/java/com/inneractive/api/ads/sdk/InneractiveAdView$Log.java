package com.inneractive.api.ads.sdk;

import android.util.Log;

public class InneractiveAdView$Log {
   public static int LEVEL = 4;

   static void a(String var0) {
      try {
         if(LEVEL <= 3) {
            Log.d("Inneractive_debug", var0);
         }

      } catch (Exception var1) {
         Log.d("Inneractive_debug", "LOG CATCH! (short)");
      }
   }

   static void b(String var0) {
      try {
         if(LEVEL <= 4) {
            Log.i("Inneractive_info", var0);
         }

      } catch (Exception var1) {
         Log.d("Inneractive_info", "LOG CATCH! (short)");
      }
   }

   static void c(String var0) {
      try {
         if(LEVEL <= 6) {
            Log.e("Inneractive_error", var0);
         }

      } catch (Exception var1) {
         Log.d("Inneractive_error", "LOG CATCH! (short)");
      }
   }

   static void d(String var0) {
      try {
         if(LEVEL <= 2) {
            Log.v("Inneractive_verbose", var0);
         }

      } catch (Exception var1) {
         Log.d("Inneractive_verbose", "LOG CATCH! (short)");
      }
   }

   static void e(String var0) {
      try {
         if(LEVEL <= 5) {
            Log.w("Inneractive_warning", var0);
         }

      } catch (Exception var1) {
         Log.d("Inneractive_warning", "LOG CATCH! (short)");
      }
   }
}
