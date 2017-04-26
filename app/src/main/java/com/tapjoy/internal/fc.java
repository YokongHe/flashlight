package com.tapjoy.internal;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import android.util.TimingLogger;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.ep;
import com.tapjoy.internal.er;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fb;
import com.tapjoy.internal.fc$c;
import com.tapjoy.internal.fd;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class fc {
   private static final String w = fc.class.getSimpleName();
   private static final Executor x = Executors.newFixedThreadPool(6);
   final fd a = new fd();
   AndroidHttpClient b;
   private final ArrayList c = new ArrayList();
   private final ReadWriteLock d = new ReentrantReadWriteLock();
   private final Lock e;
   private final Lock f;
   private final ReentrantLock g;
   private er h;
   private Thread i;
   private volatile boolean j;
   private volatile AtomicBoolean k;
   private int l;
   private int m;
   private int n;
   private boolean o;
   private boolean p;
   private AtomicBoolean q;
   private CountDownLatch r;
   private final fb s;
   private final ee t;
   private Context u;
   private TimingLogger v;

   public fc() {
      this.e = this.d.readLock();
      this.f = this.d.writeLock();
      this.g = new ReentrantLock();
      this.h = null;
      this.i = null;
      this.j = false;
      this.k = new AtomicBoolean(false);
      this.l = 0;
      this.m = 10000;
      this.n = 0;
      this.o = false;
      this.p = false;
      this.q = new AtomicBoolean(false);
      this.r = new CountDownLatch(1);
      this.s = new fb();
      this.t = new ee();
      this.b = null;
      this.u = null;
      this.v = null;
   }

   // $FF: synthetic method
   static ee a(fc var0) {
      return var0.t;
   }

   private ep a(Runnable param1) {
      // $FF: Couldn't be decompiled
   }

   private fc$c a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(final Thread var1) {
      x.execute(new Runnable() {
         final Thread a = var1;

         public final void run() {
            fc.w;
            (new StringBuilder("sending interrupt to TID: ")).append(this.a.getId());
            this.a.interrupt();
         }
      });
   }

   // $FF: synthetic method
   static TimingLogger b(fc var0) {
      return var0.v;
   }

   private void b(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static Context c(fc var0) {
      return var0.u;
   }

   // $FF: synthetic method
   static int d(fc var0) {
      return var0.m;
   }

   // $FF: synthetic method
   static CountDownLatch e(fc var0) {
      return var0.r;
   }

   private void g() {
      // $FF: Couldn't be decompiled
   }

   private boolean h() {
      boolean var2;
      if(!this.q.get()) {
         var2 = true;
         return var2;
      } else {
         String var3 = w;

         boolean var1;
         InterruptedException var6;
         label32: {
            try {
               var1 = this.r.await((long)this.m, TimeUnit.MILLISECONDS);
            } catch (InterruptedException var5) {
               var6 = var5;
               var1 = false;
               break label32;
            }

            var2 = var1;
            if(var1) {
               return var2;
            }

            try {
               Log.e(w, "Timed out waiting for init to complete");
               return var1;
            } catch (InterruptedException var4) {
               var6 = var4;
            }
         }

         Log.e(w, "Waiting for init to complete interrupted", var6);
         return var1;
      }
   }

   private void i() {
      try {
         this.f.lockInterruptibly();
         this.c.clear();
      } finally {
         this.f.unlock();
      }

   }

   public final fc$c a(Context param1, String param2, String param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      this.m = 10000;
   }

   public final void a(er var1) {
      try {
         this.g.lockInterruptibly();
         this.h = var1;
      } finally {
         if(this.g.isHeldByCurrentThread()) {
            this.g.unlock();
         }

      }

   }

   final void a(fc$c var1) {
      this.a.a(var1.b());
   }

   public final String b() {
      return this.a.b();
   }

   public final fc$c c() {
      return fc$c.a(this.a.c());
   }

   public final void d() {
      String var1 = w;
      this.g();
      this.s.a();
      this.h();
      if(this.b != null) {
         if(this.b.getConnectionManager() != null) {
            x.execute(new Runnable() {
               final AndroidHttpClient a;

               {
                  this.a = var2;
               }

               public final void run() {
                  if(this.a != null) {
                     try {
                        this.a.close();
                        this.a.getConnectionManager().shutdown();
                     } catch (RuntimeException var2) {
                        Log.e(fc.w, "Swallowing", var2);
                     }
                  }
               }
            });
         }

         this.b = null;
      }

      this.t.b();
      ev.b();
      this.q.set(false);
      this.r = new CountDownLatch(1);
   }

   final void e() {
      // $FF: Couldn't be decompiled
   }
}
