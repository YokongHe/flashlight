package com.nuance.a.a.a.a;

import android.os.Looper;
import java.util.Hashtable;

public class o implements .af {
   private static final .ae a = .bh.a(com.nuance.a.a.a.a.o.class);
   private final com.nuance.a.a.a.a.i b = new com.nuance.a.a.a.a.i();
   private final Thread c = new Thread(new Runnable() {
      // $FF: synthetic field
      private com.nuance.a.a.a.a.o a = o.this;

      public final void run() {
         Looper.prepare();
         this.a.b.a();
         Looper.loop();
      }
   });
   private final Hashtable d = new Hashtable();

   public o() {
      this.c.start();
   }

   // $FF: synthetic method
   static Hashtable a(com.nuance.a.a.a.a.o var0) {
      return var0.d;
   }

   public final void a(.aq var1, long var2) {
      com.nuance.a.a.a.a.q var4 = new com.nuance.a.a.a.a.q(this, var1);
      if(a.b()) {
         a.b((Object)("TIMER _handler.postDelayed(" + var4 + ")"));
      }

      this.b.postDelayed(var4, var2);
   }

   public final void a(Object var1, .ah var2, Object var3) {
      final com.nuance.a.a.a.a.p var4 = new com.nuance.a.a.a.a.p(var1, var2);
      var4.a = (Thread)var3;
      this.b.post(new Runnable() {
         // $FF: synthetic field
         private com.nuance.a.a.a.a.p a = var4;

         public final void run() {
            if(com.nuance.a.a.a.a.o.a.a()) {
               com.nuance.a.a.a.a.o.a.a((Object)"Executing Message");
            }

            this.a.b.a(this.a.c, this.a.a);
            if(com.nuance.a.a.a.a.o.a.a()) {
               com.nuance.a.a.a.a.o.a.a((Object)"Done Executing Message");
            }

         }
      });
   }

   public final boolean a(.aq var1) {
      com.nuance.a.a.a.a.q var2 = (com.nuance.a.a.a.a.q)this.d.remove(var1);
      if(a.b()) {
         a.b((Object)("TIMER cancelTask() _pendingTimerTasks.size():" + this.d.size()));
      }

      if(var2 != null) {
         if(a.b()) {
            a.b((Object)("TIMER _handler.removeCallbacks(" + var2 + ")"));
         }

         this.b.removeCallbacks(var2);
      }

      return var2 != null;
   }

   public final Object[] a() {
      return new Object[]{Thread.currentThread()};
   }

   public final Object b() {
      return Thread.currentThread();
   }

   public final void c() {
      this.b.post(new Runnable() {
         public final void run() {
            Looper.myLooper().quit();
         }
      });
   }
}
