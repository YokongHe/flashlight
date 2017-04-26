package com.ihandysoft.ad.a;

import android.app.Activity;
import android.widget.FrameLayout.LayoutParams;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdTargetingOptions;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class d extends com.ihandysoft.ad.a.a implements AdListener {
   private static boolean n = true;

   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("applicationID").equals(var1.get("applicationID")):false;
   }

   public void onAdCollapsed(Ad var1) {
      this.x();
   }

   public void onAdDismissed(Ad var1) {
      this.x();
   }

   public void onAdExpanded(Ad var1) {
      this.v();
      this.w();
   }

   public void onAdFailedToLoad(Ad var1, AdError var2) {
      this.a(new Exception(var2.getMessage()));
   }

   public void onAdLoaded(Ad var1, AdProperties var2) {
      this.u();
   }

   public final void p() {
      if(n) {
         n = false;

         try {
            AdRegistration.setAppKey((String)this.d.get("applicationID"));
         } catch (final Exception var2) {
            n = true;
            (new Timer()).schedule(new TimerTask() {
               public final void run() {
                  d.this.a(var2);
               }
            }, 100L);
            return;
         }
      }

      AdLayout var1 = new AdLayout((Activity)this.a());
      this.b = var1;
      var1.setListener(this);
      var1.setLayoutParams(new LayoutParams(-1, -2));
      var1.loadAd(new AdTargetingOptions());
   }

   public final void t() {
      if(this.b != null) {
         ((AdLayout)this.b).setListener((AdListener)null);
         ((AdLayout)this.b).destroy();
      }

      super.t();
   }
}
