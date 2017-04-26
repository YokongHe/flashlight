package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.hp;
import com.flurry.sdk.iq;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jw;
import com.flurry.sdk.kb;
import com.flurry.sdk.mw;
import com.flurry.sdk.pt;
import com.flurry.sdk.rb;

@kb
public class pi extends pt {
   protected final rb a;

   public pi(rb var1) {
      super(Enum.class, false);
      this.a = var1;
   }

   public static pi a(Class var0, ju var1, mw var2) {
      iq var4 = var1.a();
      rb var3;
      if(var1.a(ju$a.t)) {
         var3 = rb.c(var0, var4);
      } else {
         var3 = rb.b(var0, var4);
      }

      return new pi(var3);
   }

   public final void a(Enum var1, hf var2, jw var3) {
      if(var3.a(ju$a.u)) {
         var2.b(var1.ordinal());
      } else {
         var2.b((hp)this.a.a(var1));
      }
   }

   public rb d() {
      return this.a;
   }
}
