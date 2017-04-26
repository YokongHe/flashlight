package android.support.v4.text;

import android.os.Build.VERSION;
import android.support.v4.text.ICUCompat$ICUCompatImpl;
import android.support.v4.text.ICUCompat$ICUCompatImplBase;
import android.support.v4.text.ICUCompat$ICUCompatImplIcs;

public class ICUCompat {
   private static final ICUCompat$ICUCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 14) {
         IMPL = new ICUCompat$ICUCompatImplIcs();
      } else {
         IMPL = new ICUCompat$ICUCompatImplBase();
      }
   }

   public static String addLikelySubtags(String var0) {
      return IMPL.addLikelySubtags(var0);
   }

   public static String getScript(String var0) {
      return IMPL.getScript(var0);
   }
}
