package com.flurry.sdk;

import com.flurry.sdk.rf$a;

public abstract class rf {
   Object a;
   rf$a b;
   rf$a c;
   int d;

   public Object a() {
      this.b();
      return this.a == null?this.b(12):this.a;
   }

   public final Object a(Object var1, int var2) {
      rf$a var3 = new rf$a(var1, var2);
      if(this.b == null) {
         this.c = var3;
         this.b = var3;
      } else {
         this.c.a(var3);
         this.c = var3;
      }

      this.d += var2;
      if(var2 < 16384) {
         var2 += var2;
      } else {
         var2 += var2 >> 2;
      }

      return this.b(var2);
   }

   protected abstract Object b(int var1);

   public Object b(Object var1, int var2) {
      int var4 = var2 + this.d;
      Object var6 = this.b(var4);
      rf$a var5 = this.b;

      int var3;
      for(var3 = 0; var5 != null; var5 = var5.b()) {
         var3 = var5.a(var6, var3);
      }

      System.arraycopy(var1, 0, var6, var3, var2);
      var2 += var3;
      if(var2 != var4) {
         throw new IllegalStateException("Should have gotten " + var4 + " entries, got " + var2);
      } else {
         return var6;
      }
   }

   protected void b() {
      if(this.c != null) {
         this.a = this.c.a();
      }

      this.c = null;
      this.b = null;
      this.d = 0;
   }
}
