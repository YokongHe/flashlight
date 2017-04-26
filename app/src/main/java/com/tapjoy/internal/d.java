package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;

public final class d {
   private static Application a;
   private static int b;
   private static final com.tapjoy.internal.ce c = new com.tapjoy.internal.ce();
   private static final com.tapjoy.internal.bd d = new com.tapjoy.internal.bd();
   private static final com.tapjoy.internal.ce e = new com.tapjoy.internal.ce();

   public static Activity a() {
      Activity var1 = (Activity)e.a();
      Activity var0 = var1;
      if(var1 == null) {
         var0 = (Activity)c.a();
         if(var0 == null) {
            return (Activity)com.tapjoy.internal.cy.a(d.iterator());
         }
      }

      return var0;
   }

   public static void a(Activity var0) {
      ++b;
      c.a(var0);
      d.add(var0);
   }

   public static void a(Application var0) {
      synchronized(com.tapjoy.internal.d.class){}

      try {
         if(a != var0) {
            a = var0;
         }
      } finally {
         ;
      }

   }

   public static void b(Activity var0) {
      --b;
      c.a = null;
      d.remove(var0);
      if(b < 0) {
         b = 0;
      }

   }

   public static boolean b() {
      return b > 0;
   }
}
