package com.tapjoy.mraid.util;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Encryptor {
   private static byte[] a(byte[] var0) {
      KeyGenerator var1 = KeyGenerator.getInstance("AES");
      SecureRandom var2 = SecureRandom.getInstance("SHA1PRNG");
      var2.setSeed(var0);
      var1.init(256, var2);
      return var1.generateKey().getEncoded();
   }

   public static String decrypt(String var0, String var1) {
      byte[] var2 = a(var0.getBytes());
      byte[] var3 = toByte(var1);
      SecretKeySpec var4 = new SecretKeySpec(var2, "AES");
      Cipher var5 = Cipher.getInstance("AES");
      var5.init(2, var4);
      return new String(var5.doFinal(var3));
   }

   public static String encrypt(String var0, String var1) {
      byte[] var2 = a(var0.getBytes());
      byte[] var3 = var1.getBytes();
      SecretKeySpec var4 = new SecretKeySpec(var2, "AES");
      Cipher var5 = Cipher.getInstance("AES");
      var5.init(1, var4);
      return toHex(var5.doFinal(var3));
   }

   public static String fromHex(String var0) {
      return new String(toByte(var0));
   }

   public static byte[] toByte(String var0) {
      int var2 = var0.length() / 2;
      byte[] var3 = new byte[var2];

      for(int var1 = 0; var1 < var2; ++var1) {
         var3[var1] = Integer.valueOf(var0.substring(var1 * 2, var1 * 2 + 2), 16).byteValue();
      }

      return var3;
   }

   public static String toHex(String var0) {
      return toHex(var0.getBytes());
   }

   public static String toHex(byte[] var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuffer var3 = new StringBuffer(var0.length * 2);

         for(int var1 = 0; var1 < var0.length; ++var1) {
            byte var2 = var0[var1];
            var3.append("0123456789ABCDEF".charAt(var2 >> 4 & 15)).append("0123456789ABCDEF".charAt(var2 & 15));
         }

         return var3.toString();
      }
   }
}
