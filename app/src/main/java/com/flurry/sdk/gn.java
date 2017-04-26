package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.gn$a;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$g;
import com.flurry.sdk.gq$i;
import com.flurry.sdk.gq$j;

public class gn {
   protected final gn$a a;
   protected gq[] b;
   protected int c;

   public gn(gq var1, gn$a var2) {
      this.a = var2;
      this.b = new gq[5];
      this.b[0] = var1;
      this.c = 1;
   }

   private void f() {
      gq[] var1 = new gq[this.b.length + Math.max(this.b.length, 1024)];
      System.arraycopy(this.b, 0, var1, 0, this.b.length);
      this.b = var1;
   }

   public final gq a(gq var1) {
      while(true) {
         gq[] var3 = this.b;
         int var2 = this.c - 1;
         this.c = var2;
         gq var5 = var3[var2];
         if(var5 == var1) {
            return var5;
         }

         gq$i var4 = var5.a;
         if(var4 == gq$i.f) {
            var5 = this.a.a(var1, var5);
            if(var5 != null) {
               return var5;
            }
         } else {
            if(var4 == gq$i.a) {
               throw new fl("Attempt to process a " + var1 + " when a " + var5 + " was expected.");
            }

            if(var4 == gq$i.d && var1 == ((gq$j)var5).z) {
               return var1;
            }

            this.b(var5);
         }
      }
   }

   public final void a() {
      while(true) {
         if(this.c > 1) {
            gq var1 = this.b[this.c - 1];
            if(var1.a == gq$i.f) {
               --this.c;
               this.a.a((gq)null, var1);
               continue;
            }

            if(var1.a != gq$i.a) {
               --this.c;
               this.b(var1);
               continue;
            }
         }

         return;
      }
   }

   public final void b() {
      while(true) {
         if(this.c > 0) {
            gq var1 = this.b[this.c - 1];
            if(var1.a == gq$i.f && ((gq$g)var1).A) {
               --this.c;
               this.a.a((gq)null, var1);
               continue;
            }
         }

         return;
      }
   }

   public final void b(gq var1) {
      gq[] var3 = var1.b;

      while(this.c + var3.length > this.b.length) {
         this.f();
      }

      System.arraycopy(var3, 0, this.b, this.c, var3.length);
      int var2 = this.c;
      this.c = var3.length + var2;
   }

   public gq c() {
      gq[] var2 = this.b;
      int var1 = this.c - 1;
      this.c = var1;
      return var2[var1];
   }

   public void c(gq var1) {
      if(this.c == this.b.length) {
         this.f();
      }

      gq[] var3 = this.b;
      int var2 = this.c;
      this.c = var2 + 1;
      var3[var2] = var1;
   }

   public gq d() {
      return this.b[this.c - 1];
   }

   public void e() {
      this.c = 1;
   }
}
