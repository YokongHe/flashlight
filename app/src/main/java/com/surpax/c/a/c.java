package com.surpax.c.a;

import android.os.Build.VERSION;
import com.surpax.ledflashlight.FlashlightActivity;

public final class c {
   private com.surpax.c.a.a a = null;
   private boolean b = false;
   private boolean c = false;
   private com.ihs.b.a.d d;

   public final void a() {
      this.b = false;
      int var1 = VERSION.SDK_INT;
      this.c = false;
      com.surpax.a.a.D = false;
      if(var1 >= 7) {
         this.d = com.ihs.b.a.d.a();
         this.d.a(FlashlightActivity.a().f);
         if(this.d.b()) {
            com.surpax.a.a.s = true;
            this.b = false;
            com.surpax.a.a.B = false;
            return;
         }

         if(com.ihs.b.a.b.c == this.d.c()) {
            com.surpax.a.a.r = true;
         }
      }

      com.surpax.a.a.B = true;
      com.surpax.a.a.C = true;
      this.b = true;
      this.a = new com.surpax.c.a.b();
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
               this.d.f();
               this.d = null;
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
            } else if(!this.d.g()) {
               this.d.d();
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
               this.d.e();
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
               this.d.e();
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      } finally {
         ;
      }

   }
}
