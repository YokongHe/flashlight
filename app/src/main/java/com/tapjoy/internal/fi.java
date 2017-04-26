package com.tapjoy.internal;

public final class fi {
   public long a;
   public long b;
   public long c;

   private static long a(byte[] var0, int var1) {
      byte var2 = var0[var1];
      byte var3 = var0[var1 + 1];
      byte var4 = var0[var1 + 2];
      byte var5 = var0[var1 + 3];
      var1 = var2;
      if((var2 & 128) == 128) {
         var1 = (var2 & 127) + 128;
      }

      int var12 = var3;
      if((var3 & 128) == 128) {
         var12 = (var3 & 127) + 128;
      }

      int var13 = var4;
      if((var4 & 128) == 128) {
         var13 = (var4 & 127) + 128;
      }

      int var14 = var5;
      if((var5 & 128) == 128) {
         var14 = (var5 & 127) + 128;
      }

      long var6 = (long)var1;
      long var8 = (long)var12;
      long var10 = (long)var13;
      return (long)var14 + (var8 << 16) + (var6 << 24) + (var10 << 8);
   }

   private static long b(byte[] var0, int var1) {
      return (a(var0, var1) - 2208988800L) * 1000L + a(var0, var1 + 4) * 1000L / 4294967296L;
   }

   public final boolean a(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }
}
