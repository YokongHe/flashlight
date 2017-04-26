package com.ihs.a.e;

public class a {
   // $FF: synthetic field
   static final boolean a;

   static {
      boolean var0;
      if(!com.ihs.a.e.a.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   public static String a(byte[] param0, int param1) {
      // $FF: Couldn't be decompiled
   }

   public static byte[] a(String var0, int var1) {
      byte[] var2 = var0.getBytes();
      var1 = var2.length;
      com.ihs.a.e.c var3 = new com.ihs.a.e.c(0, new byte[var1 * 3 / 4]);
      if(!var3.a(var2, 0, var1, true)) {
         throw new IllegalArgumentException("bad base-64");
      } else if(var3.b == var3.a.length) {
         return var3.a;
      } else {
         var2 = new byte[var3.b];
         System.arraycopy(var3.a, 0, var2, 0, var3.b);
         return var2;
      }
   }
}
