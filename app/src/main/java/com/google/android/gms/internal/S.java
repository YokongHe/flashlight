package com.google.android.gms.internal;

public final class S extends com.google.android.gms.internal.af {
   private final Object a = new Object();
   private com.google.android.gms.internal.V b;
   private com.google.android.gms.internal.R c;

   public final void a() {
      Object var1 = this.a;
      synchronized(var1) {
         if(this.c != null) {
            this.c.j();
         }

      }
   }

   public final void a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(com.google.android.gms.internal.R var1) {
      Object var2 = this.a;
      synchronized(var2) {
         this.c = var1;
      }
   }

   public final void a(com.google.android.gms.internal.V var1) {
      Object var2 = this.a;
      synchronized(var2) {
         this.b = var1;
      }
   }

   public final void b() {
      Object var1 = this.a;
      synchronized(var1) {
         if(this.c != null) {
            this.c.k();
         }

      }
   }

   public final void c() {
      Object var1 = this.a;
      synchronized(var1) {
         if(this.c != null) {
            this.c.l();
         }

      }
   }

   public final void d() {
      Object var1 = this.a;
      synchronized(var1) {
         if(this.c != null) {
            this.c.m();
         }

      }
   }

   public final void e() {
      Object var1 = this.a;
      synchronized(var1) {
         if(this.b != null) {
            this.b.a(0);
            this.b = null;
         } else {
            if(this.c != null) {
               this.c.n();
            }

         }
      }
   }
}
