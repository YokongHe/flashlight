package com.nexage.android.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.inmobi.monetization.IMBanner;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import java.util.Map;

public final class e extends com.nexage.android.e.b {
   private static boolean e = false;
   IMBannerListener d = new IMBannerListener() {
      public final void onBannerInteraction(IMBanner var1, Map var2) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onBannerInteraction");
         e.this.f(e.this);
      }

      public final void onBannerRequestFailed(IMBanner var1, IMErrorCode var2) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onBannerRequestFailed");
         e.this.b(e.this);
      }

      public final void onBannerRequestSucceeded(IMBanner var1) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onBannerRequestSucceeded");
         e.this.a(e.this);
      }

      public final void onDismissBannerScreen(IMBanner var1) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onDismissBannerScreen");
         e.this.d(e.this);
      }

      public final void onLeaveApplication(IMBanner var1) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onLeaveApplication");
         e.this.e(e.this);
      }

      public final void onShowBannerScreen(IMBanner var1) {
         com.nexage.android.a.p.b("InMobiProvider", "proxy --> onShowBannerScreen");
         e.this.c(e.this);
      }
   };
   private IMBanner f;

   public e(Activity var1, Handler var2) {
      super(var1, var2);
      com.nexage.android.a.p.b("InMobiProvider", "entering constructor");
      this.c = true;
   }

   protected final View a(int param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   protected final void b() {
      try {
         this.f.loadBanner();
      } catch (Exception var2) {
         com.nexage.android.a.p.a("InMobiProvider", "loadAdView:", var2);
      }
   }

   protected final void c() {
      try {
         this.f.setIMBannerListener((IMBannerListener)null);
      } catch (Exception var2) {
         com.nexage.android.a.p.a("InMobiProvider", "loadAd:", var2);
      }
   }
}
