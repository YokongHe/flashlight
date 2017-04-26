package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.mw;
import com.flurry.sdk.of;
import com.flurry.sdk.oi;
import com.flurry.sdk.oj;
import java.util.List;

public class ok {
   private static final oi[] f = new oi[0];
   protected final mw a;
   protected List b;
   protected oi[] c;
   protected of d;
   protected Object e;

   public ok(mw var1) {
      this.a = var1;
   }

   public List a() {
      return this.b;
   }

   public void a(of var1) {
      this.d = var1;
   }

   public void a(Object var1) {
      this.e = var1;
   }

   public void a(List var1) {
      this.b = var1;
   }

   public void a(oi[] var1) {
      this.c = var1;
   }

   public jk b() {
      oi[] var1;
      if(this.b != null && !this.b.isEmpty()) {
         var1 = (oi[])this.b.toArray(new oi[this.b.size()]);
      } else {
         if(this.d == null) {
            return null;
         }

         var1 = f;
      }

      return new oj(this.a.a(), var1, this.c, this.d, this.e);
   }

   public oj c() {
      return oj.a(this.a.b());
   }
}
