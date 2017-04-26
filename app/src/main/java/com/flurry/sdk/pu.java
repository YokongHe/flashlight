package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.ji;
import com.flurry.sdk.jj;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.oq;

@kb
public class pu extends oq {
   public static final pu a = new pu();

   protected pu() {
      super(ji.class);
   }

   public void a(ji var1, hf var2, jw var3) {
      var1.a(var2, var3);
   }

   public final void a(ji var1, hf var2, jw var3, jz var4) {
      if(var1 instanceof jj) {
         ((jj)var1).a(var2, var3, var4);
      } else {
         this.a(var1, var2, var3);
      }
   }
}
