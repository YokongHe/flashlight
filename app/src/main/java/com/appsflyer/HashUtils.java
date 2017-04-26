package com.appsflyer;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.Map;

public class HashUtils {
   private static String byteToHex(byte[] var0) {
      Formatter var3 = new Formatter();
      int var2 = var0.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.format("%02x", new Object[]{Byte.valueOf(var0[var1])});
      }

      String var4 = var3.toString();
      var3.close();
      return var4;
   }

   public String getHashCode(Map var1) {
      String var2 = (String)var1.get("appsflyerKey");
      String var3 = (String)var1.get("af_timestamp");
      String var7 = (String)var1.get("uid");

      try {
         MessageDigest var4 = MessageDigest.getInstance("SHA-1");
         var4.reset();
         var4.update((var2.substring(0, 7) + var7.substring(0, 7) + var3.substring(var3.length() - 7)).getBytes("UTF-8"));
         var7 = byteToHex(var4.digest());
         return var7;
      } catch (NoSuchAlgorithmException var5) {
         var5.printStackTrace();
         return null;
      } catch (UnsupportedEncodingException var6) {
         var6.printStackTrace();
         return null;
      }
   }

   public native String getNativeCode(String var1, String var2, String var3);
}
