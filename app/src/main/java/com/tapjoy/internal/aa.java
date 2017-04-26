package com.tapjoy.internal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class aa {
   private static final ThreadLocal a = new ThreadLocal() {
      // $FF: synthetic method
      protected final Object initialValue() {
         return new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
      }
   };
   private static final ThreadLocal b = new ThreadLocal() {
      // $FF: synthetic method
      protected final Object initialValue() {
         return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
      }
   };

   public static String a(Date var0) {
      return ((DateFormat)a.get()).format(var0);
   }
}
