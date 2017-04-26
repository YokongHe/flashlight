package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fu;
import com.flurry.sdk.gs;
import java.lang.reflect.Type;

public class gt extends fu {
   public gt() {
      this((fn)null, (fn)null, gs.b());
   }

   public gt(fn var1) {
      this(var1, var1, gs.b());
   }

   public gt(fn var1, fn var2, gs var3) {
      super(var1, var2, var3);
   }

   public gt(Class var1) {
      this(gs.b().a((Type)var1));
   }

   protected Object a(String var1, fn var2) {
      Class var3 = this.b().b(var2);
      return var3 == null?super.a(var1, var2):Enum.valueOf(var3, var1);
   }

   public gs b() {
      return (gs)this.a();
   }
}
