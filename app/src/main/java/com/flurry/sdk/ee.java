package com.flurry.sdk;

import com.flurry.sdk.ef;
import com.flurry.sdk.eo;
import com.flurry.sdk.fg;
import java.util.Comparator;

public class ee implements Comparator {
   private static final String a = ee.class.getSimpleName();

   private int a(Runnable var1) {
      int var2 = Integer.MAX_VALUE;
      if(var1 != null) {
         if(!(var1 instanceof ef)) {
            if(var1 instanceof fg) {
               return ((fg)var1).i();
            }

            eo.a(6, a, "Unknown runnable class: " + var1.getClass().getName());
            return Integer.MAX_VALUE;
         }

         fg var3 = (fg)((ef)var1).a();
         if(var3 != null) {
            var2 = var3.i();
         } else {
            var2 = Integer.MAX_VALUE;
         }
      }

      return var2;
   }

   public int a(Runnable var1, Runnable var2) {
      int var3 = this.a(var1);
      int var4 = this.a(var2);
      return var3 < var4?-1:(var3 > var4?1:0);
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.a((Runnable)var1, (Runnable)var2);
   }
}
