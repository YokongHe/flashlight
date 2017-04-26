package com.flurry.sdk;

import com.flurry.sdk.gn;
import com.flurry.sdk.gn$a;
import com.flurry.sdk.gp$a;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$i;

public class gp extends gn {
   // $FF: synthetic field
   static final boolean d;
   private final gp$a e;

   static {
      boolean var0;
      if(!gp.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      d = var0;
   }

   public gp(gq var1, gn$a var2, gp$a var3) {
      super(var1, var2);
      this.e = var3;
   }

   public final void a(int var1) {
      while(var1 < this.c) {
         gq var2 = this.b[this.c - 1];
         if(var2.a != gq$i.a) {
            if(var2.a != gq$i.f && var2.a != gq$i.g) {
               --this.c;
               this.b(var2);
            } else {
               this.e.l();
            }
         } else {
            this.e.t();
         }
      }

   }

   public final void d(gq var1) {
      int var2 = this.c;
      this.c(var1);
      this.a(var2);
   }

   public final void f() {
      int var1 = this.c;
      gq[] var3 = this.b;
      int var2 = this.c - 1;
      this.c = var2;
      gq var4 = var3[var2];
      if(!d && var4.a != gq$i.d) {
         throw new AssertionError();
      } else {
         this.b(var4);
         this.a(var1);
      }
   }
}
