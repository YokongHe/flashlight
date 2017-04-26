package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;
import java.util.Map;

public abstract class ResponseBodyInterstitial extends CustomEventInterstitial {
   protected AdReport mAdReport;
   protected long mBroadcastIdentifier;
   private EventForwardingBroadcastReceiver mBroadcastReceiver;
   protected Context mContext;

   private boolean extrasAreValid(Map var1) {
      return var1.containsKey("Html-Response-Body");
   }

   protected abstract void extractExtras(Map var1);

   public void loadInterstitial(Context param1, CustomEventInterstitial$CustomEventInterstitialListener param2, Map param3, Map param4) {
      // $FF: Couldn't be decompiled
   }

   public void onInvalidate() {
      if(this.mBroadcastReceiver != null) {
         this.mBroadcastReceiver.unregister();
      }

   }

   protected abstract void preRenderHtml(CustomEventInterstitial$CustomEventInterstitialListener var1);

   public abstract void showInterstitial();
}
