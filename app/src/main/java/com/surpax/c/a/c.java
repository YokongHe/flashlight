package com.surpax.c.a;

import android.os.Build.VERSION;

public final class c {
   private com.surpax.c.a.a a = null;
   private boolean b = false;
   private boolean c = false;

   public final void a() {
      this.b = false;
      int var1 = VERSION.SDK_INT;
      this.c = false;
      com.surpax.a.a.D = false;

      com.surpax.a.a.B = true;
      com.surpax.a.a.C = true;
      this.b = true;
      this.a = new b();
      this.a.a();
   }

   public final void b() {
      synchronized(this){}

      try {
         this.c = false;

         try {
            if(this.b) {
               this.a.b();
               this.a = null;
            } else {
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } finally {
         ;
      }

   }

   public final boolean c() {
      return this.b;
   }

   public final void d() {
      synchronized(this){}

      try {
         this.c = true;

         try {
            if(this.b) {
               this.a.c();
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } finally {
         ;
      }

   }

   public final void e() {
      synchronized(this){}

      try {
         this.c = false;

         try {
            if(this.b) {
               this.a.d();
            } else {
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } finally {
         ;
      }

   }

   public final void f() {
      synchronized(this){}

      try {
         this.c = false;

         try {
            if(this.b) {
               this.a.e();
            } else {
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } finally {
         ;
      }

   }
}
