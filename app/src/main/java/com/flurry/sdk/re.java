package com.flurry.sdk;

import com.flurry.sdk.re$a;
import java.lang.reflect.Array;
import java.util.List;

public final class re {
   private re$a a;
   private re$a b;
   private int c;
   private Object[] d;

   protected final void a(Object var1, int var2, Object[] var3, int var4) {
      re$a var7 = this.a;

      int var5;
      for(var5 = 0; var7 != null; var7 = var7.b()) {
         Object[] var8 = var7.a();
         int var6 = var8.length;
         System.arraycopy(var8, 0, var1, var5, var6);
         var5 += var6;
      }

      System.arraycopy(var3, 0, var1, var5, var4);
      var4 += var5;
      if(var4 != var2) {
         throw new IllegalStateException("Should have gotten " + var2 + " entries, got " + var4);
      }
   }

   public final void a(Object[] var1, int var2, List var3) {
      byte var5 = 0;
      re$a var7 = this.a;

      while(true) {
         int var4 = var5;
         if(var7 == null) {
            while(var4 < var2) {
               var3.add(var1[var4]);
               ++var4;
            }

            return;
         }

         Object[] var8 = var7.a();
         int var6 = var8.length;

         for(var4 = 0; var4 < var6; ++var4) {
            var3.add(var8[var4]);
         }

         var7 = var7.b();
      }
   }

   public final Object[] a() {
      this.c();
      return this.d == null?new Object[12]:this.d;
   }

   public final Object[] a(Object[] var1) {
      re$a var3 = new re$a(var1);
      if(this.a == null) {
         this.b = var3;
         this.a = var3;
      } else {
         this.b.a(var3);
         this.b = var3;
      }

      int var2 = var1.length;
      this.c += var2;
      if(var2 < 16384) {
         var2 += var2;
      } else {
         var2 += var2 >> 2;
      }

      return new Object[var2];
   }

   public final Object[] a(Object[] var1, int var2) {
      int var3 = this.c + var2;
      Object[] var4 = new Object[var3];
      this.a(var4, var3, var1, var2);
      return var4;
   }

   public final Object[] a(Object[] var1, int var2, Class var3) {
      int var4 = var2 + this.c;
      Object[] var5 = (Object[])Array.newInstance(var3, var4);
      this.a(var5, var4, var1, var2);
      this.c();
      return var5;
   }

   public final int b() {
      return this.d == null?0:this.d.length;
   }

   protected final void c() {
      if(this.b != null) {
         this.d = this.b.a();
      }

      this.b = null;
      this.a = null;
      this.c = 0;
   }
}
