package com.flurry.sdk;

import com.flurry.sdk.fb;
import com.flurry.sdk.fb$a;

public class fa {
   private static long a = 1000L;
   private static fa b = null;
   private final fb c = new fb();

   public fa() {
      this.c.a(a);
      this.c.a(true);
   }

   public static fa a() {
      synchronized(fa.class){}

      fa var0;
      try {
         if(b == null) {
            b = new fa();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   public void a(fb$a var1) {
      synchronized(this){}

      try {
         this.c.a(var1);
         if(!this.c.c() && this.c.d() > 0) {
            this.c.a();
         }
      } finally {
         ;
      }

   }

   public boolean b(fb$a var1) {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.c.b(var1);
         if(this.c.d() == 0) {
            this.c.b();
         }
      } finally {
         ;
      }

      return var2;
   }
}
