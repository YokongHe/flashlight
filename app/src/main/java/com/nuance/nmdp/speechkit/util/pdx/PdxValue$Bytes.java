package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;

public final class PdxValue$Bytes extends PdxValue {
   private final byte[] a;

   public PdxValue$Bytes(byte[] var1) {
      super(4);
      this.a = var1;
   }

   public final byte[] get() {
      return this.a;
   }

   public final String toString(String var1) {
      char[] var8 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      StringBuilder var6 = new StringBuilder();
      var6.append("0x");
      byte[] var7 = this.a;
      int var3 = var7.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         byte var5 = var7[var2];
         byte var4 = (byte)(var5 >> 4 & 15);
         var5 = (byte)(var5 & 15);
         var6.append(var8[var4]);
         var6.append(var8[var5]);
      }

      return var6.toString();
   }
}
