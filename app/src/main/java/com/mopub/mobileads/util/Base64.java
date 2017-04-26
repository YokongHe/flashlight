package com.mopub.mobileads.util;

import com.mopub.mobileads.util.Base64$Decoder;
import com.mopub.mobileads.util.Base64$Encoder;
import java.io.UnsupportedEncodingException;

public class Base64 {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   public static final int CRLF = 4;
   public static final int DEFAULT = 0;
   public static final int NO_CLOSE = 16;
   public static final int NO_PADDING = 1;
   public static final int NO_WRAP = 2;
   public static final int URL_SAFE = 8;

   static {
      boolean var0;
      if(!Base64.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public static byte[] decode(String var0, int var1) {
      return decode(var0.getBytes(), var1);
   }

   public static byte[] decode(byte[] var0, int var1) {
      return decode(var0, 0, var0.length, var1);
   }

   public static byte[] decode(byte[] var0, int var1, int var2, int var3) {
      Base64$Decoder var4 = new Base64$Decoder(var3, new byte[var2 * 3 / 4]);
      if(!var4.process(var0, var1, var2, true)) {
         throw new IllegalArgumentException("bad base-64");
      } else if(var4.op == var4.output.length) {
         return var4.output;
      } else {
         var0 = new byte[var4.op];
         System.arraycopy(var4.output, 0, var0, 0, var4.op);
         return var0;
      }
   }

   public static byte[] encode(byte[] var0, int var1) {
      return encode(var0, 0, var0.length, var1);
   }

   public static byte[] encode(byte[] var0, int var1, int var2, int var3) {
      Base64$Encoder var6 = new Base64$Encoder(var3, (byte[])null);
      int var4 = var2 / 3 * 4;
      if(var6.do_padding) {
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
      if(var6.do_newline) {
         var4 = var3;
         if(var2 > 0) {
            int var5 = (var2 - 1) / 57;
            byte var7;
            if(var6.do_cr) {
               var7 = 2;
            } else {
               var7 = 1;
            }

            var4 = var3 + var7 * (var5 + 1);
         }
      }

      var6.output = new byte[var4];
      var6.process(var0, var1, var2, true);
      if(!$assertionsDisabled && var6.op != var4) {
         throw new AssertionError();
      } else {
         return var6.output;
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
