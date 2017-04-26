package com.flurry.sdk;

import com.flurry.sdk.gf;
import com.flurry.sdk.gn$a;
import com.flurry.sdk.gp;
import com.flurry.sdk.gp$a;
import com.flurry.sdk.gq;

public abstract class gk extends gf implements gn$a, gp$a {
   protected final gp a;

   protected gk(gq var1) {
      this.a = new gp(var1, this, this);
   }

   protected abstract void a();

   public void l() {
      this.a.c();
   }

   public void t() {
      gq var1 = this.a.d();
      if(var1 == gq.c) {
         this.b();
      }

      if(var1 == gq.d) {
         this.c();
      } else {
         if(var1 == gq.e) {
            this.d();
            return;
         }

         if(var1 == gq.f) {
            this.e();
            return;
         }

         if(var1 == gq.g) {
            this.f();
            return;
         }

         if(var1 == gq.h) {
            this.g();
            return;
         }

         if(var1 == gq.i) {
            this.i();
            return;
         }

         if(var1 == gq.j) {
            this.j();
            return;
         }

         if(var1 == gq.l) {
            this.k();
            return;
         }

         if(var1 == gq.k) {
            this.a();
            return;
         }

         if(var1 == gq.m) {
            this.s();
            return;
         }

         if(var1 == gq.n) {
            this.o();
            return;
         }

         if(var1 == gq.p) {
            this.r();
            return;
         }
      }

   }
}
