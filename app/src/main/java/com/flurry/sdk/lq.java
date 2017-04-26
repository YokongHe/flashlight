package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.kc;
import com.flurry.sdk.lq$a;
import com.flurry.sdk.mc;
import com.flurry.sdk.mr;
import com.flurry.sdk.qy;
import com.flurry.sdk.ra;

@kc
public class lq extends mc {
   protected final ra a;

   public lq(ra var1) {
      super(Enum.class);
      this.a = var1;
   }

   public static jg a(iy var0, Class var1, mr var2) {
      if(var2.b(0) != String.class) {
         throw new IllegalArgumentException("Parameter #0 type for factory method (" + var2 + ") not suitable, must be java.lang.String");
      } else {
         if(var0.a(iy$a.f)) {
            qy.a(var2.i());
         }

         return new lq$a(var1, var2);
      }
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Enum b(hj var1, iz var2) {
      hm var4 = var1.e();
      Enum var6;
      Enum var7;
      if(var4 != hm.h && var4 != hm.f) {
         if(var4 != hm.i) {
            throw var2.b(this.a.a());
         }

         if(var2.a(iy$a.m)) {
            throw var2.b("Not allowed to deserialize Enum value out of JSON number (disable DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS to allow)");
         }

         int var3 = var1.t();
         var7 = this.a.a(var3);
         var6 = var7;
         if(var7 == null) {
            throw var2.c(this.a.a(), "index value outside legal index range [0.." + this.a.b() + "]");
         }
      } else {
         String var5 = var1.k();
         var7 = this.a.a(var5);
         var6 = var7;
         if(var7 == null) {
            throw var2.b(this.a.a(), "value not one of declared Enum instance names");
         }
      }

      return var6;
   }
}
