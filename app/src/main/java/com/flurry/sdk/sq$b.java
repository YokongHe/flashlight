package com.flurry.sdk;

import com.flurry.sdk.hm;

public final class sq$b {
   private static final hm[] d = new hm[16];
   protected sq$b a;
   protected long b;
   protected final Object[] c = new Object[16];

   static {
      hm[] var0 = hm.values();
      System.arraycopy(var0, 1, d, 1, Math.min(15, var0.length - 1));
   }

   public final hm a(int var1) {
      long var4 = this.b;
      long var2 = var4;
      if(var1 > 0) {
         var2 = var4 >> (var1 << 2);
      }

      var1 = (int)var2;
      return d[var1 & 15];
   }

   public final sq$b a() {
      return this.a;
   }

   public final sq$b a(int var1, hm var2) {
      if(var1 < 16) {
         this.b(var1, var2);
         return null;
      } else {
         this.a = new sq$b();
         this.a.b(0, var2);
         return this.a;
      }
   }

   public final sq$b a(int var1, hm var2, Object var3) {
      if(var1 < 16) {
         this.b(var1, var2, var3);
         return null;
      } else {
         this.a = new sq$b();
         this.a.b(0, var2, var3);
         return this.a;
      }
   }

   public final Object b(int var1) {
      return this.c[var1];
   }

   public final void b(int var1, hm var2) {
      long var5 = (long)var2.ordinal();
      long var3 = var5;
      if(var1 > 0) {
         var3 = var5 << (var1 << 2);
      }

      this.b |= var3;
   }

   public final void b(int var1, hm var2, Object var3) {
      this.c[var1] = var3;
      long var6 = (long)var2.ordinal();
      long var4 = var6;
      if(var1 > 0) {
         var4 = var6 << (var1 << 2);
      }

      this.b |= var4;
   }
}
