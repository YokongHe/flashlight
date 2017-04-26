package com.amazon.device.ads;

import android.app.Activity;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControlAccessor$Coordinates;
import com.amazon.device.ads.AdControlAccessor$SizeDimensions;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.MRAIDAdSDKBridge;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;

class MRAIDAdSDKEventListener implements SDKEventListener {
   private static final String LOGTAG = MRAIDAdSDKEventListener.class.getSimpleName();
   private MRAIDAdSDKBridge mraidAdSDKBridge;

   MRAIDAdSDKEventListener(MRAIDAdSDKBridge var1) {
      this.mraidAdSDKBridge = var1;
   }

   private void handleBridgeAddedEvent(SDKEvent var1, AdControlAccessor var2) {
      String var3 = var1.getParameter("bridgeName");
      if(var3 != null && var3.equals(this.mraidAdSDKBridge.getName())) {
         switch(null.$SwitchMap$com$amazon$device$ads$AdState[var2.getAdState().ordinal()]) {
         case 1:
         case 2:
            var2.injectJavascript("mraidBridge.ready();");
            this.handleVisibleEvent(var2);
            return;
         case 3:
            var2.injectJavascript("mraidBridge.ready();");
            return;
         }
      }

   }

   private void handleClosedEvent(AdControlAccessor var1) {
      if(var1.getAdState().equals(AdState.EXPANDED)) {
         this.mraidAdSDKBridge.collapseExpandedAd(var1);
         if(((Activity)var1.getContext()).getRequestedOrientation() != var1.getOriginalOrientation()) {
            ((Activity)var1.getContext()).setRequestedOrientation(var1.getOriginalOrientation());
         }
      } else if(var1.getAdState().equals(AdState.SHOWING)) {
         if(((Activity)var1.getContext()).getRequestedOrientation() != var1.getOriginalOrientation()) {
            ((Activity)var1.getContext()).setRequestedOrientation(var1.getOriginalOrientation());
         }

         var1.injectJavascript("mraidBridge.stateChange(\'hidden\');");
         var1.injectJavascript("mraidBridge.viewableChange(\'false\');");
         return;
      }

   }

   private void handleReadyEvent(AdControlAccessor var1) {
      var1.injectJavascript("mraidBridge.ready();");
   }

   private void handleVisibleEvent(AdControlAccessor var1) {
      var1.setOriginalOrientation((Activity)var1.getContext());
      AdControlAccessor$SizeDimensions var2 = var1.getMaxSize(false);
      this.mraidAdSDKBridge.updateExpandProperties(var2.getWidth(), var2.getHeight());
      AdControlAccessor$Coordinates var3 = var1.getCurrentPosition();
      this.mraidAdSDKBridge.updateDefaultPosition(var3.getWidth(), var3.getHeight(), var3.getX(), var3.getY());
      this.mraidAdSDKBridge.orientationPropertyChange();
      var1.injectJavascript("mraidBridge.stateChange(\'default\');");
      var1.injectJavascript("mraidBridge.viewableChange(\'true\');");
   }

   public void onSDKEvent(SDKEvent var1, AdControlAccessor var2) {
      android.util.Log.d(LOGTAG, var1.getEventType().toString());
      switch(null.$SwitchMap$com$amazon$device$ads$SDKEvent$SDKEventType[var1.getEventType().ordinal()]) {
      case 1:
         var2.injectJavascript("mraidBridge.ready();");
         return;
      case 2:
         this.handleVisibleEvent(var2);
         return;
      case 3:
         this.handleClosedEvent(var2);
         return;
      case 4:
         this.mraidAdSDKBridge.reportSizeChangeEvent();
         return;
      case 5:
      case 6:
         var2.injectJavascript("mraidBridge.stateChange(\'hidden\');");
         var2.injectJavascript("mraidBridge.viewableChange(\'false\');");
         return;
      case 7:
         this.handleBridgeAddedEvent(var1, var2);
         return;
      default:
      }
   }
}
