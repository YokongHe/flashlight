package com.flurry.sdk;

import com.flurry.sdk.hb;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jy;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;

@kb
public class mf extends mc {
   public mf() {
      super(String.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2, jy var3) {
      return this.b(var1, var2, var3);
   }

   public String b(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.h) {
         return var1.k();
      } else if(var3 == hm.g) {
         Object var4 = var1.z();
         return var4 == null?null:(var4 instanceof byte[]?hb.a().a((byte[])var4, false):var4.toString());
      } else if(var3.d()) {
         return var1.k();
      } else {
         throw var2.a(this.q, var3);
      }
   }

   public String b(hj var1, iz var2, jy var3) {
      return this.b(var1, var2);
   }
}
