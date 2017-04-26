package com.nuance.a.a.a.a;

import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class r extends .ai {
   protected final String a() {
      return UUID.randomUUID().toString();
   }

   protected final byte[] a(byte[] var1, byte[] var2) {
      if(var1 != null && var2 != null) {
         try {
            SecretKeySpec var5 = new SecretKeySpec(var1, "HmacSHA1");
            Mac var3 = Mac.getInstance("HmacSHA1");
            var3.init(var5);
            var1 = var3.doFinal(var2);
            return var1;
         } catch (Exception var4) {
            return new byte[0];
         }
      } else {
         return new byte[0];
      }
   }
}
