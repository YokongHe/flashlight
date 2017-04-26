package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.lz;
import java.util.EnumMap;

public class lr extends lz {
   protected final Class a;
   protected final jg b;
   protected final jg c;

   public lr(Class var1, jg var2, jg var3) {
      super(EnumMap.class);
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private EnumMap d() {
      return new EnumMap(this.a);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.a(var1, var2);
   }

   public EnumMap b(hj var1, iz var2) {
      if(var1.e() != hm.b) {
         throw var2.b(EnumMap.class);
      } else {
         Object var3;
         EnumMap var4;
         Enum var5;
         for(var4 = this.d(); var1.b() != hm.c; var4.put(var5, var3)) {
            var5 = (Enum)this.b.a(var1, var2);
            if(var5 == null) {
               throw var2.b(this.a, "value not one of declared Enum instance names");
            }

            if(var1.b() == hm.m) {
               var3 = null;
            } else {
               var3 = this.c.a(var1, var2);
            }
         }

         return var4;
      }
   }
}
