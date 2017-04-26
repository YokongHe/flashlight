package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fv;
import com.flurry.sdk.gi;
import com.flurry.sdk.gs;
import java.lang.reflect.Type;

public class gu extends fv {
   public gu() {
      super(gs.b());
   }

   public gu(Class var1) {
      super(gs.b().a((Type)var1), gs.b());
   }

   protected void c(fn var1, Object var2, gi var3) {
      if(!(var2 instanceof Enum)) {
         super.c(var1, var2, var3);
      } else {
         var3.a(((Enum)var2).ordinal());
      }
   }
}
