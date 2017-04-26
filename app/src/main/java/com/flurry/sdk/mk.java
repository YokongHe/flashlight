package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hj;
import com.flurry.sdk.jh;

public class mk extends jh {
   protected final Class c;
   protected final String d;

   public mk(String var1, hg var2, Class var3, String var4) {
      super(var1, var2);
      this.c = var3;
      this.d = var4;
   }

   public static mk a(hj var0, Object var1, String var2) {
      if(var1 == null) {
         throw new IllegalArgumentException();
      } else {
         Class var3;
         if(var1 instanceof Class) {
            var3 = (Class)var1;
         } else {
            var3 = var1.getClass();
         }

         mk var4 = new mk("Unrecognized field \"" + var2 + "\" (Class " + var3.getName() + "), not marked as ignorable", var0.i(), var3, var2);
         var4.a(var1, var2);
         return var4;
      }
   }
}
