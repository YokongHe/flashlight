package com.nexage.android;

import com.nexage.android.NexageAdView;
import java.util.TimerTask;

final class i extends TimerTask {
   // $FF: synthetic field
   final NexageAdView a;

   private i(NexageAdView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   i(NexageAdView var1, byte var2) {
      this(var1);
   }

   public final void run() {
      com.nexage.android.a.p.b("NAV", "RefreshTask enter");
      NexageAdView var1 = this.a;
      synchronized(var1) {
         NexageAdView.a(this.a, true);
         NexageAdView.a((NexageAdView)this.a, (com.nexage.android.i)null);
      }

      com.nexage.android.a.p.b("NAV", "RefreshTask visible=" + NexageAdView.a(this.a) + ", m_PrefetchAttempt=" + NexageAdView.b(this.a) + ", refreshInterval=" + NexageAdView.c(this.a) + ", isGlobalAdServingEnabled=" + com.nexage.android.a.o.c());
      if((NexageAdView.a(this.a) || NexageAdView.b(this.a) > 0) && com.nexage.android.a.o.c()) {
         this.a.c();
      }

   }
}
