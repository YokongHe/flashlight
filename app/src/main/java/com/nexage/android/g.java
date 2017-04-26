package com.nexage.android;

import com.nexage.android.NexageAdView;

final class g implements Runnable {
   // $FF: synthetic field
   final NexageAdView a;
   private final com.nexage.android.a.a b;

   public g(NexageAdView var1, com.nexage.android.a.a var2) {
      this.a = var1;
      com.nexage.android.a.p.b("NAV", "DisplayAdRunnable created");
      this.b = var2;
   }

   public final void run() {
      com.nexage.android.a.p.b("NAV", "DisplayAdRunnable started");

      try {
         NexageAdView.b(this.a, this.b);
      } catch (Exception var2) {
         com.nexage.android.a.p.a(this.a.a, "DisplayAdRunnable:", var2);
      }
   }
}
