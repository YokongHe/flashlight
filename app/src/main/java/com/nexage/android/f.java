package com.nexage.android;

import android.app.Activity;
import com.nexage.android.NexageAdView;

final class f extends com.nexage.android.a.m {
   // $FF: synthetic field
   final NexageAdView a;

   private f(NexageAdView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   f(NexageAdView var1, byte var2) {
      this(var1);
   }

   public final boolean a() {
      return NexageAdView.i(this.a);
   }

   public final boolean a(com.nexage.android.a.a var1) {
      NexageAdView.a(this.a, 0);
      NexageAdView var2 = this.a;
      synchronized(var2) {
         NexageAdView.a(this.a, false);
         if(NexageAdView.k(this.a) && NexageAdView.c(this.a) > 0) {
            return false;
         }

         NexageAdView.c(this.a, var1);
      }

      com.nexage.android.a.p.b("NAV", "starting DisplayAdRunnable from showAd");
      ((Activity)NexageAdView.g(this.a)).runOnUiThread(new com.nexage.android.g(this.a, var1));
      return true;
   }

   final boolean b() {
      synchronized(this){}
      boolean var5 = false;

      int var1;
      try {
         var5 = true;
         var1 = this.a.b;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public final Activity c() {
      return (Activity)NexageAdView.g(this.a);
   }

   public final void d() {
      NexageAdView var1 = this.a;
      synchronized(var1) {
         NexageAdView.a(this.a, false);
      }

      if(NexageAdView.b(this.a) > 0) {
         NexageAdView.j(this.a);
      }

      NexageAdView.c(this.a, false);
      if(NexageAdView.h(this.a) != null) {
         ((Activity)NexageAdView.g(this.a)).runOnUiThread(new Runnable() {
            public final void run() {
               if(NexageAdView.h(f.this.a) != null) {
                  com.nexage.android.j var1 = NexageAdView.h(f.this.a);
                  NexageAdView var2 = f.this.a;
                  var1.F();
               }

            }
         });
      }

      if(!NexageAdView.i(this.a)) {
         this.a.a(false);
      }

   }

   public final void e() {
      this.a.c();
   }

   public final com.nexage.android.b.a f() {
      return null;
   }

   public final boolean g() {
      return NexageAdView.a(this.a);
   }
}
