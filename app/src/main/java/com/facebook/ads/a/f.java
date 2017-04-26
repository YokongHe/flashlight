package com.facebook.ads.a;

import android.content.Context;
import android.os.Handler;
import com.facebook.ads.a.f$a;

public abstract class f {
   protected final f$a a;
   protected com.facebook.ads.a.e b;
   private final long c;
   private final Handler d;
   private final Runnable e = new Runnable() {
      public void run() {
         f.this.h = false;
         f.this.d();
      }
   };
   private Context f;
   private volatile boolean g;
   private volatile boolean h;

   public f(f$a var1, long var2, Context var4) {
      this.f = var4;
      this.a = var1;
      this.c = var2;
      this.d = new Handler();
   }

   public com.facebook.ads.a.e a() {
      return this.b;
   }

   public void a(com.facebook.ads.a.e var1) {
      this.b = var1;
      this.g = false;
      this.h = false;
   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   public void c() {
      synchronized(this){}

      try {
         if(this.h) {
            this.d.removeCallbacks(this.e);
            this.h = false;
         }
      } finally {
         ;
      }

   }

   public void d() {
      // $FF: Couldn't be decompiled
   }

   protected abstract void e();
}
