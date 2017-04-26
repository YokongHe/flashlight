package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.of;
import com.flurry.sdk.oi;
import com.flurry.sdk.pa;
import com.flurry.sdk.pc;
import com.flurry.sdk.sh;

public class oj extends pc {
   public oj(sh var1, oi[] var2, oi[] var3, of var4, Object var5) {
      super(var1, var2, var3, var4, var5);
   }

   public oj(Class var1, oi[] var2, oi[] var3, of var4, Object var5) {
      super(var1, var2, var3, var4, var5);
   }

   public static oj a(Class var0) {
      return new oj(var0, a, (oi[])null, (of)null, (Object)null);
   }

   public jk a() {
      return new pa(this);
   }

   public final void a(Object var1, hf var2, jw var3) {
      var2.d();
      if(this.e != null) {
         this.c(var1, var2, var3);
      } else {
         this.b(var1, var2, var3);
      }

      var2.e();
   }

   public String toString() {
      return "BeanSerializer for " + this.c().getName();
   }
}
