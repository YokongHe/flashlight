package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

final class aA {
   private final Runnable a;
   private volatile boolean b = false;

   public aA(final com.google.android.gms.internal.az var1) {
      this.a = new Runnable() {
         private final WeakReference c = new WeakReference(var1);

         public final void run() {
            com.google.android.gms.internal.az var1x = (com.google.android.gms.internal.az)this.c.get();
            if(!aA.this.b && var1x != null) {
               var1x.e();
               aA.this.b();
            }

         }
      };
   }

   public final void a() {
      this.b = true;
      com.google.android.gms.internal.bI.a.removeCallbacks(this.a);
   }

   public final void b() {
      com.google.android.gms.internal.bI.a.postDelayed(this.a, 250L);
   }
}
