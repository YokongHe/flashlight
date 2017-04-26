package com.amazon.device.ads;

import android.graphics.Rect;
import android.widget.FrameLayout.LayoutParams;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdError$ErrorCode;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.ExtendedAdListener;
import com.amazon.device.ads.Metrics$MetricType;

class AdLayout$AdLayoutAdControlCallback implements AdControlCallback {
   private AdProperties properties;
   // $FF: synthetic field
   final AdLayout this$0;

   AdLayout$AdLayoutAdControlCallback(AdLayout var1) {
      this.this$0 = var1;
   }

   public int adClosing() {
      return AdLayout.access$100(this.this$0).getAdState().equals(AdState.EXPANDED)?0:2;
   }

   boolean handleAdEvent(AdEvent var1) {
      switch(null.$SwitchMap$com$amazon$device$ads$AdEvent$AdEventType[var1.getAdEventType().ordinal()]) {
      case 1:
         AdLayout.access$500(this.this$0).onAdExpanded(this.this$0);
         return true;
      case 2:
         AdLayout.access$500(this.this$0).onAdCollapsed(this.this$0);
         return true;
      case 3:
         if(AdLayout.access$500(this.this$0) instanceof ExtendedAdListener) {
            Rect var2 = (Rect)var1.getParameters().getParameter("positionOnScreen");
            ((ExtendedAdListener)AdLayout.access$500(this.this$0)).onAdResized(var2);
         }

         return true;
      default:
         return false;
      }
   }

   public boolean isAdReady(boolean var1) {
      return this.this$0.prepareAd(var1);
   }

   void notifyAdShowing(AdProperties var1) {
      this.this$0.adShown();
      AdLayout.access$500(this.this$0).onAdLoaded(this.this$0, var1);
   }

   public void onAdEvent(AdEvent var1) {
      this.handleAdEvent(var1);
   }

   public void onAdFailed(AdError var1) {
      if(AdError$ErrorCode.NETWORK_TIMEOUT.equals(var1.getCode())) {
         AdLayout.access$602(this.this$0, (AdController)null);
      }

      AdLayout.access$500(this.this$0).onAdFailedToLoad(this.this$0, var1);
   }

   public void onAdLoaded(AdProperties var1) {
      this.properties = var1;
      AdLayout.access$100(this.this$0).render();
   }

   public void onAdRendered() {
      AdLayout.access$100(this.this$0).getMetricsCollector().startMetric(Metrics$MetricType.AD_SHOW_LATENCY);
      if(AdLayout.access$400(this.this$0) != null) {
         this.this$0.removeView(AdLayout.access$400(this.this$0));
         AdLayout.access$400(this.this$0).destroy();
      }

      AdLayout.access$402(this.this$0, AdLayout.access$100(this.this$0).getView());
      LayoutParams var1 = new LayoutParams(-1, -1, 17);
      this.this$0.addView(AdLayout.access$400(this.this$0), var1);
      this.notifyAdShowing(this.properties);
   }

   public void postAdRendered() {
   }
}
