package com.tapjoy.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class cn {
   public static byte[] a(byte[] var0) {
      MessageDigest var1;
      try {
         var1 = MessageDigest.getInstance("SHA-1");
      } catch (NoSuchAlgorithmException var2) {
         throw new RuntimeException(var2);
      }

      return var1.digest(var0);
   }
}
