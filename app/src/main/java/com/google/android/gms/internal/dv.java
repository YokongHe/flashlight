package com.google.android.gms.internal;

import com.google.android.gms.internal.dr;
import com.google.android.gms.internal.dw;
import java.lang.ref.WeakReference;

public final class dv {
   private final dw a;
   private final Runnable b;
   private com.google.android.gms.internal.ah c;
   private boolean d;
   private boolean e;
   private long f;

   public dv(dr var1) {
      this(var1, new dw(com.google.android.gms.internal.bI.a));
   }

   private dv(final dr var1, dw var2) {
      this.d = false;
      this.e = false;
      this.f = 0L;
      this.a = var2;
      this.b = new Runnable() {
         private final WeakReference c = new WeakReference(var1);

         public final void run() {
            dv.a(dv.this, false);
            dr var1x = (dr)this.c.get();
            if(var1x != null) {
               var1x.b(dv.this.c);
            }

         }
      };
   }

   // $FF: synthetic method
   static boolean a(dv var0, boolean var1) {
      var0.d = false;
      return false;
   }

   public final void a() {
      this.d = false;
      this.a.a(this.b);
   }

   public final void a(com.google.android.gms.internal.ah var1) {
      this.a(var1, 60000L);
   }

   public final void a(com.google.android.gms.internal.ah var1, long var2) {
      if(this.d) {
         com.google.android.gms.internal.bJ.e("An ad refresh is already scheduled.");
      } else {
         this.c = var1;
         this.d = true;
         this.f = var2;
         if(!this.e) {
            com.google.android.gms.internal.bJ.c("Scheduling ad refresh " + var2 + " milliseconds from now.");
            this.a.a(this.b, var2);
            return;
         }
      }

   }

   public final void b() {
      this.e = true;
      if(this.d) {
         this.a.a(this.b);
      }

   }

   public final void c() {
      this.e = false;
      if(this.d) {
         this.d = false;
         this.a(this.c, this.f);
      }

   }
}
