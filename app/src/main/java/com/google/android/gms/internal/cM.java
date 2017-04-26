package com.google.android.gms.internal;

import android.os.Looper;

public final class cM {
   public static Object a(Object var0) {
      if(var0 == null) {
         throw new NullPointerException("null reference");
      } else {
         return var0;
      }
   }

   public static Object a(Object var0, Object var1) {
      if(var0 == null) {
         throw new NullPointerException(String.valueOf(var1));
      } else {
         return var0;
      }
   }

   public static void a(String var0) {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException(var0);
      }
   }

   public static void a(boolean var0) {
      if(!var0) {
         throw new IllegalStateException();
      }
   }

   public static void a(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalStateException(String.valueOf(var1));
      }
   }

   public static void b(boolean var0, Object var1) {
      if(!var0) {
         throw new IllegalArgumentException(String.valueOf(var1));
      }
   }
}
