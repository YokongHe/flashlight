package com.inmobi.commons.thirdparty;

import com.inmobi.commons.thirdparty.Base64$b;
import com.inmobi.commons.thirdparty.Base64$c;
import java.io.UnsupportedEncodingException;

public class Base64 {
   public static final int CRLF = 4;
   public static final int DEFAULT = 0;
   public static final int NO_CLOSE = 16;
   public static final int NO_PADDING = 1;
   public static final int NO_WRAP = 2;
   public static final int URL_SAFE = 8;
   // $FF: synthetic field
   static final boolean a;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   public static byte[] decode(String var0, int var1) {
      return decode(var0.getBytes(), var1);
   }

   public static byte[] decode(byte[] var0, int var1) {
      return decode(var0, 0, var0.length, var1);
   }

   public static byte[] decode(byte[] var0, int var1, int var2, int var3) {
      Base64$b var4 = new Base64$b(var3, new byte[var2 * 3 / 4]);
      if(!var4.a(var0, var1, var2, true)) {
         throw new IllegalArgumentException("bad base-64");
      } else if(var4.b == var4.a.length) {
         return var4.a;
      } else {
         var0 = new byte[var4.b];
         System.arraycopy(var4.a, 0, var0, 0, var4.b);
         return var0;
      }
   }

   public static byte[] encode(byte[] var0, int var1) {
      return encode(var0, 0, var0.length, var1);
   }

   public static byte[] encode(byte[] var0, int var1, int var2, int var3) {
      Base64$c var6 = new Base64$c(var3, (byte[])null);
      int var4 = var2 / 3 * 4;
      if(var6.d) {
         var3 = var4;
         if(var2 % 3 > 0) {
            var3 = var4 + 4;
         }
      } else {
         var3 = var4;
         switch(var2 % 3) {
         case 0:
            break;
         case 1:
            var3 = var4 + 2;
            break;
         case 2:
            var3 = var4 + 3;
            break;
         default:
            var3 = var4;
         }
      }

      var4 = var3;
      if(var6.e) {
         var4 = var3;
         if(var2 > 0) {
            int var5 = (var2 - 1) / 57;
            byte var7;
            if(var6.f) {
               var7 = 2;
            } else {
               var7 = 1;
            }

            var4 = var3 + var7 * (var5 + 1);
         }
      }

      var6.a = new byte[var4];
      var6.a(var0, var1, var2, true);
      if(!a && var6.b != var4) {
         throw new AssertionError();
      } else {
         return var6.a;
      }
   }

   public static String encodeToString(byte[] var0, int var1) {
      try {
         String var3 = new String(encode(var0, var1), "US-ASCII");
         return var3;
      } catch (UnsupportedEncodingException var2) {
         throw new AssertionError(var2);
      }
   }

   public static String encodeToString(byte[] var0, int var1, int var2, int var3) {
      try {
         String var5 = new String(encode(var0, var1, var2, var3), "US-ASCII");
         return var5;
      } catch (UnsupportedEncodingException var4) {
         throw new AssertionError(var4);
      }
   }
}
