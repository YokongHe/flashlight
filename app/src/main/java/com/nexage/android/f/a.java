package com.nexage.android.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;

public final class a extends com.nexage.android.e.b {
   AdListener d = new AdListener() {
      public final void onAdClicked(Ad var1) {
         com.nexage.android.a.p.b("FacebookProvider", "proxy --> onBannerInteraction");
         a.this.f(a.this);
      }

      public final void onAdLoaded(Ad var1) {
         com.nexage.android.a.p.b("FacebookProvider", "proxy --> onShowBannerScreen");
         a.this.a(a.this);
      }

      public final void onError(Ad var1, AdError var2) {
         com.nexage.android.a.p.b("FacebookProvider", "proxy --> onBannerRequestFailed :" + var2.getErrorCode() + ":" + var2.getErrorMessage());
         a.this.b(a.this);
      }
   };
   private AdView e;

   public a(Activity var1, Handler var2) {
      super(var1, var2);
      com.nexage.android.a.p.b("FacebookProvider", "entering constructor");
      this.c = true;
   }

   protected final View a(int param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   protected final void b() {
      try {
         this.e.loadAd();
      } catch (Exception var2) {
         com.nexage.android.a.p.a("FacebookProvider", "loadAdView:", var2);
      }
   }

   protected final void c() {
      try {
         if(this.e != null) {
            this.e.destroy();
         }

      } catch (Exception var2) {
         com.nexage.android.a.p.a("FacebookProvider", "cancel:", var2);
      }
   }
}
