package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.ga;
import com.flurry.sdk.gc;
import com.flurry.sdk.gd$a;
import com.flurry.sdk.gd$b;
import java.io.IOException;
import java.io.OutputStream;

public class gd extends gc {
   private byte[] a;
   private int b;
   private gd$a c;
   private int d;

   gd(OutputStream var1, int var2) {
      this.a(var1, var2);
   }

   private void d(int var1) {
      if(this.a.length - this.b < var1) {
         this.h();
      }

   }

   private void e(int var1) {
      if(this.b == this.a.length) {
         this.h();
      }

      byte[] var3 = this.a;
      int var2 = this.b;
      this.b = var2 + 1;
      var3[var2] = (byte)(var1 & 255);
   }

   private void h() {
      if(this.b > 0) {
         this.c.a(this.a, 0, this.b);
         this.b = 0;
      }

   }

   gd a(OutputStream var1, int var2) {
      if(var1 == null) {
         throw new NullPointerException("OutputStream cannot be null!");
      } else {
         if(this.c != null && this.b > 0) {
            try {
               this.h();
            } catch (IOException var3) {
               throw new fk("Failure flushing old output", var3);
            }
         }

         this.c = new gd$b(var1, null);
         this.b = 0;
         if(this.a == null || this.a.length != var2) {
            this.a = new byte[var2];
         }

         this.d = this.a.length >>> 1;
         if(this.d > 512) {
            this.d = 512;
         }

         return this;
      }
   }

   public void a(double var1) {
      this.d(8);
      this.b += ga.a(var1, this.a, this.b);
   }

   public void a(float var1) {
      this.d(4);
      this.b += ga.a(var1, this.a, this.b);
   }

   public void a(boolean var1) {
      if(this.a.length == this.b) {
         this.h();
      }

      this.b += ga.a(var1, this.a, this.b);
   }

   public void b(long var1) {
      this.d(10);
      this.b += ga.a(var1, this.a, this.b);
   }

   public void b(byte[] var1, int var2, int var3) {
      if(var3 > this.d) {
         this.h();
         this.c.a(var1, var2, var3);
      } else {
         this.d(var3);
         System.arraycopy(var1, var2, this.a, this.b, var3);
         this.b += var3;
      }
   }

   public void c(int var1) {
      this.d(5);
      this.b += ga.a(var1, this.a, this.b);
   }

   public void flush() {
      this.h();
      this.c.a();
   }

   protected void g() {
      this.e(0);
   }
}
