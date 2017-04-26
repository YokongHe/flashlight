package com.google.android.gms.internal;

public final class cR implements com.google.android.gms.internal.cQ {
   private static com.google.android.gms.internal.cR a;

   public static com.google.android.gms.internal.cQ b() {
      synchronized(com.google.android.gms.internal.cR.class){}

      com.google.android.gms.internal.cR var0;
      try {
         if(a == null) {
            a = new com.google.android.gms.internal.cR();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public final long a() {
      return System.currentTimeMillis();
   }
}
