package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.lz;
import java.util.EnumSet;

public class ls extends lz {
   protected final Class a;
   protected final jg b;

   public ls(Class var1, jg var2) {
      super(EnumSet.class);
      this.a = var1;
      this.b = var2;
   }

   private EnumSet d() {
      return EnumSet.noneOf(this.a);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.b(var1, var2);
   }

   public EnumSet b(hj var1, iz var2) {
      if(!var1.j()) {
         throw var2.b(EnumSet.class);
      } else {
         EnumSet var3 = this.d();

         while(true) {
            hm var4 = var1.b();
            if(var4 == hm.e) {
               return var3;
            }

            if(var4 == hm.m) {
               throw var2.b(this.a);
            }

            var3.add((Enum)this.b.a(var1, var2));
         }
      }
   }
}
