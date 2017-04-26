package com.tapjoy.internal;

public enum ApiKeyDecoded$KeyUsage {
   RPC_ANALYTICS((byte)49),
   SDK_ANDROID((byte)2);

   public byte id;

   private ApiKeyDecoded$KeyUsage(byte var3) {
      this.id = var3;
   }

   public static ApiKeyDecoded$KeyUsage valueOf(byte var0) {
      ApiKeyDecoded$KeyUsage[] var3 = values();
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         ApiKeyDecoded$KeyUsage var4 = var3[var1];
         if(var4.id == var0) {
            return var4;
         }
      }

      return null;
   }
}
