package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.js;
import com.flurry.sdk.mc;
import com.flurry.sdk.sh;
import java.util.concurrent.atomic.AtomicReference;

public class lj extends mc implements js {
   protected final sh a;
   protected final is b;
   protected jg c;

   public lj(sh var1, is var2) {
      super(AtomicReference.class);
      this.a = var1;
      this.b = var2;
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public void a(iy var1, jc var2) {
      this.c = var2.a(var1, this.a, this.b);
   }

   public AtomicReference b(hj var1, iz var2) {
      return new AtomicReference(this.c.a(var1, var2));
   }
}
