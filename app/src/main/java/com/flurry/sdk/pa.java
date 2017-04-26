package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.pc;

public class pa extends pc {
   public pa(pc var1) {
      super(var1);
   }

   public jk a() {
      return this;
   }

   public final void a(Object var1, hf var2, jw var3) {
      if(this.e != null) {
         this.c(var1, var2, var3);
      } else {
         this.b(var1, var2, var3);
      }
   }

   public boolean b() {
      return true;
   }

   public String toString() {
      return "UnwrappingBeanSerializer for " + this.c().getName();
   }
}
