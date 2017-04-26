package com.flurry.sdk;

import com.flurry.sdk.ga;
import com.flurry.sdk.gc;
import java.io.OutputStream;

public class gh extends gc {
   private OutputStream a;
   private final byte[] b = new byte[12];

   gh(OutputStream var1) {
      this.a(var1);
   }

   gh a(OutputStream var1) {
      if(var1 == null) {
         throw new NullPointerException("OutputStream cannot be null!");
      } else {
         this.a = var1;
         return this;
      }
   }

   public void a(double var1) {
      byte[] var4 = new byte[8];
      int var3 = ga.a(var1, var4, 0);
      this.a.write(var4, 0, var3);
   }

   public void a(float var1) {
      int var2 = ga.a(var1, this.b, 0);
      this.a.write(this.b, 0, var2);
   }

   public void a(boolean var1) {
      OutputStream var3 = this.a;
      byte var2;
      if(var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      var3.write(var2);
   }

   public void b(long var1) {
      long var4 = var1 << 1 ^ var1 >> 63;
      int var3;
      if((-2147483648L & var4) != 0L) {
         var3 = ga.a(var1, this.b, 0);
         this.a.write(this.b, 0, var3);
      } else {
         for(var3 = (int)var4; (var3 & -128) != 0; var3 >>>= 7) {
            this.a.write((byte)((var3 | 128) & 255));
         }

         this.a.write((byte)var3);
      }
   }

   public void b(byte[] var1, int var2, int var3) {
      this.a.write(var1, var2, var3);
   }

   public void c(int var1) {
      int var2 = var1 << 1 ^ var1 >> 31;
      if((var2 & -128) == 0) {
         this.a.write(var2);
      } else if((var2 & -16384) == 0) {
         this.a.write(var2 | 128);
         this.a.write(var2 >>> 7);
      } else {
         var1 = ga.a(var1, this.b, 0);
         this.a.write(this.b, 0, var1);
      }
   }

   public void flush() {
      this.a.flush();
   }

   protected void g() {
      this.a.write(0);
   }
}
