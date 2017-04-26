package com.google.android.gms.internal;

public abstract class bB {
   private final Runnable a = new Runnable() {
      public final void run() {
         bB.this.b = Thread.currentThread();
         bB.this.a();
      }
   };
   private volatile Thread b;

   public abstract void a();

   public final void e() {
      com.google.android.gms.internal.bC.a(this.a);
   }

   public final void f() {
      this.g_();
      if(this.b != null) {
         this.b.interrupt();
      }

   }

   public abstract void g_();
}
