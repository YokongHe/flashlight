package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jj;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.sh;

public abstract class qq extends sh implements jj {
   volatile String c;

   protected qq(Class var1, int var2, Object var3, Object var4) {
      super(var1, var2);
      this.f = var3;
      this.g = var4;
   }

   protected abstract String a();

   public void a(hf var1, jw var2) {
      var1.b(this.m());
   }

   public void a(hf var1, jw var2, jz var3) {
      var3.a(this, var1);
      this.a(var1, var2);
      var3.d(this, var1);
   }

   public String m() {
      String var2 = this.c;
      String var1 = var2;
      if(var2 == null) {
         var1 = this.a();
      }

      return var1;
   }

   public Object n() {
      return this.f;
   }

   public Object o() {
      return this.g;
   }
}
