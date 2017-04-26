package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.internal.ApiKeyDecoded$KeyUsage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;

public class ApiKeyDecoded {
   private final String a;
   private final String b;
   private final String c;
   private final ApiKeyDecoded$KeyUsage d;

   public ApiKeyDecoded(String var1) {
      if(var1.length() != 60) {
         throw new IllegalArgumentException("The given API key was malformed.");
      } else if(var1.charAt(22) != 69) {
         throw new IllegalArgumentException("The given API key was invalid.");
      } else {
         byte[] var3;
         try {
            var3 = Base64.decode(var1, 8);
            if(var3.length != 45) {
               throw new IllegalArgumentException("The given API key was malformed.");
            }
         } catch (IllegalArgumentException var6) {
            throw new IllegalArgumentException("The given API key was malformed.", var6);
         }

         ByteBuffer var4 = ByteBuffer.wrap(var3);
         var4.order(ByteOrder.BIG_ENDIAN);
         int var2 = var4.getInt(41);
         CRC32 var5 = new CRC32();
         var5.update(var3, 0, 41);
         if(var2 != (int)var5.getValue()) {
            throw new IllegalArgumentException("The given API key was invalid.");
         } else {
            this.a = var1;
            this.b = (new UUID(var4.getLong(0), var4.getLong(8))).toString();
            this.c = var1.substring(24, 44);
            this.d = ApiKeyDecoded$KeyUsage.valueOf(var4.get(17));
         }
      }
   }

   public static String get5RocksAppId(String var0) {
      if(var0.regionMatches(13, "-8000-8000-", 0, 11)) {
         return var0.substring(0, 8) + var0.substring(24, 30) + var0.substring(9, 13) + var0.substring(30);
      } else {
         throw new IllegalArgumentException("The given UUID did not come from 5Rocks.");
      }
   }

   public boolean equals(Object var1) {
      return var1 instanceof ApiKeyDecoded?this.a.equals(((ApiKeyDecoded)var1).a):false;
   }

   public String getAppId() {
      return this.b;
   }

   public ApiKeyDecoded$KeyUsage getKeyUsage() {
      return this.d;
   }

   public String getSecretKey() {
      return this.c;
   }

   public String toString() {
      return this.a;
   }
}
