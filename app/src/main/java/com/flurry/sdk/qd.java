package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.px;
import java.util.Collection;

@kb
public class qd extends px implements jt {
   protected jk a;

   public qd(is var1) {
      super(Collection.class, var1);
   }

   private final void b(Collection param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }

   private void c(Collection param1, hf param2, jw param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(jw var1) {
      jk var2 = var1.a(String.class, this.b);
      if(!this.a(var2)) {
         this.a = var2;
      }

   }

   public void a(Collection var1, hf var2, jw var3) {
      var2.b();
      if(this.a == null) {
         this.b(var1, var2, var3);
      } else {
         this.c(var1, var2, var3);
      }

      var2.c();
   }

   public void a(Collection var1, hf var2, jw var3, jz var4) {
      var4.c(var1, var2);
      if(this.a == null) {
         this.b(var1, var2, var3);
      } else {
         this.c(var1, var2, var3);
      }

      var4.f(var1, var2);
   }
}
