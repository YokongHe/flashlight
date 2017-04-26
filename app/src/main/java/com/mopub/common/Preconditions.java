package com.mopub.common;

import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import java.util.IllegalFormatException;

public final class Preconditions {
   public static final String EMPTY_ARGUMENTS = "";

   // $FF: synthetic method
   static boolean access$0(boolean var0, boolean var1, String var2, Object[] var3) {
      return checkArgumentInternal(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static boolean access$1(boolean var0, boolean var1, String var2, Object[] var3) {
      return checkStateInternal(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static boolean access$2(Object var0, boolean var1, String var2, Object[] var3) {
      return checkNotNullInternal(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static boolean access$3(boolean var0, String var1, Object[] var2) {
      return checkUiThreadInternal(var0, var1, var2);
   }

   public static void checkArgument(boolean var0) {
      checkArgumentInternal(var0, true, "Illegal argument.", new Object[]{""});
   }

   public static void checkArgument(boolean var0, String var1) {
      checkArgumentInternal(var0, true, var1, new Object[]{""});
   }

   public static void checkArgument(boolean var0, String var1, Object... var2) {
      checkArgumentInternal(var0, true, var1, var2);
   }

   private static boolean checkArgumentInternal(boolean var0, boolean var1, String var2, Object... var3) {
      if(var0) {
         return true;
      } else {
         var2 = format(var2, var3);
         if(var1) {
            throw new IllegalArgumentException(var2);
         } else {
            MoPubLog.e(var2);
            return false;
         }
      }
   }

   public static void checkNotNull(Object var0) {
      checkNotNullInternal(var0, true, "Object can not be null.", new Object[]{""});
   }

   public static void checkNotNull(Object var0, String var1) {
      checkNotNullInternal(var0, true, var1, new Object[]{""});
   }

   public static void checkNotNull(Object var0, String var1, Object... var2) {
      checkNotNullInternal(var0, true, var1, var2);
   }

   private static boolean checkNotNullInternal(Object var0, boolean var1, String var2, Object... var3) {
      if(var0 != null) {
         return true;
      } else {
         String var4 = format(var2, var3);
         if(var1) {
            throw new NullPointerException(var4);
         } else {
            MoPubLog.e(var4);
            return false;
         }
      }
   }

   public static void checkState(boolean var0) {
      checkStateInternal(var0, true, "Illegal state.", new Object[]{""});
   }

   public static void checkState(boolean var0, String var1) {
      checkStateInternal(var0, true, var1, new Object[]{""});
   }

   public static void checkState(boolean var0, String var1, Object... var2) {
      checkStateInternal(var0, true, var1, var2);
   }

   private static boolean checkStateInternal(boolean var0, boolean var1, String var2, Object... var3) {
      if(var0) {
         return true;
      } else {
         var2 = format(var2, var3);
         if(var1) {
            throw new IllegalStateException(var2);
         } else {
            MoPubLog.e(var2);
            return false;
         }
      }
   }

   public static void checkUiThread() {
      checkUiThreadInternal(true, "This method must be called from the UI thread.", new Object[]{""});
   }

   public static void checkUiThread(String var0) {
      checkUiThreadInternal(true, var0, new Object[]{""});
   }

   public static void checkUiThread(String var0, Object... var1) {
      checkUiThreadInternal(true, var0, var1);
   }

   private static boolean checkUiThreadInternal(boolean var0, String var1, Object... var2) {
      if(Looper.getMainLooper().equals(Looper.myLooper())) {
         return true;
      } else {
         var1 = format(var1, var2);
         if(var0) {
            throw new IllegalStateException(var1);
         } else {
            MoPubLog.e(var1);
            return false;
         }
      }
   }

   private static String format(String var0, Object... var1) {
      var0 = String.valueOf(var0);

      try {
         String var3 = String.format(var0, var1);
         return var3;
      } catch (IllegalFormatException var2) {
         MoPubLog.e("MoPub preconditions had a format exception: " + var2.getMessage());
         return var0;
      }
   }
}
