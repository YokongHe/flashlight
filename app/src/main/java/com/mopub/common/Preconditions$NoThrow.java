package com.mopub.common;

import com.mopub.common.Preconditions;

public final class Preconditions$NoThrow {
   private static volatile boolean sStrictMode = false;

   public static boolean checkArgument(boolean var0) {
      return Preconditions.access$0(var0, sStrictMode, "Illegal argument", new Object[]{""});
   }

   public static boolean checkArgument(boolean var0, String var1) {
      return Preconditions.access$0(var0, sStrictMode, var1, new Object[]{""});
   }

   public static boolean checkArgument(boolean var0, String var1, Object... var2) {
      return Preconditions.access$0(var0, sStrictMode, var1, var2);
   }

   public static boolean checkNotNull(Object var0) {
      return Preconditions.access$2(var0, sStrictMode, "Object can not be null.", new Object[]{""});
   }

   public static boolean checkNotNull(Object var0, String var1) {
      return Preconditions.access$2(var0, sStrictMode, var1, new Object[]{""});
   }

   public static boolean checkNotNull(Object var0, String var1, Object... var2) {
      return Preconditions.access$2(var0, sStrictMode, var1, var2);
   }

   public static boolean checkState(boolean var0) {
      return Preconditions.access$1(var0, sStrictMode, "Illegal state.", new Object[]{""});
   }

   public static boolean checkState(boolean var0, String var1) {
      return Preconditions.access$1(var0, sStrictMode, var1, new Object[]{""});
   }

   public static boolean checkState(boolean var0, String var1, Object... var2) {
      return Preconditions.access$1(var0, sStrictMode, var1, var2);
   }

   public static boolean checkUiThread() {
      return Preconditions.access$3(sStrictMode, "This method must be called from the UI thread.", new Object[]{""});
   }

   public static boolean checkUiThread(String var0) {
      return Preconditions.access$3(sStrictMode, var0, new Object[]{""});
   }

   public static boolean checkUiThread(String var0, Object... var1) {
      return Preconditions.access$3(false, var0, var1);
   }

   public static void setStrictMode(boolean var0) {
      sStrictMode = var0;
   }
}
