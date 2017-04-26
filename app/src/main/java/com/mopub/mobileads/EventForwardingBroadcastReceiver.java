package com.mopub.mobileads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.MoPubErrorCode;

public class EventForwardingBroadcastReceiver extends BroadcastReceiver {
   public static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
   public static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
   public static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
   public static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
   private static IntentFilter sIntentFilter;
   private final long mBroadcastIdentifier;
   private Context mContext;
   private final CustomEventInterstitial$CustomEventInterstitialListener mCustomEventInterstitialListener;

   public EventForwardingBroadcastReceiver(CustomEventInterstitial$CustomEventInterstitialListener var1, long var2) {
      this.mCustomEventInterstitialListener = var1;
      this.mBroadcastIdentifier = var2;
      sIntentFilter = getHtmlInterstitialIntentFilter();
   }

   static void broadcastAction(Context var0, long var1, String var3) {
      Intent var4 = new Intent(var3);
      var4.putExtra("broadcastIdentifier", var1);
      LocalBroadcastManager.getInstance(var0.getApplicationContext()).sendBroadcast(var4);
   }

   public static IntentFilter getHtmlInterstitialIntentFilter() {
      if(sIntentFilter == null) {
         IntentFilter var0 = new IntentFilter();
         sIntentFilter = var0;
         var0.addAction("com.mopub.action.interstitial.fail");
         sIntentFilter.addAction("com.mopub.action.interstitial.show");
         sIntentFilter.addAction("com.mopub.action.interstitial.dismiss");
         sIntentFilter.addAction("com.mopub.action.interstitial.click");
      }

      return sIntentFilter;
   }

   public void onReceive(Context var1, Intent var2) {
      if(this.mCustomEventInterstitialListener != null) {
         long var3 = var2.getLongExtra("broadcastIdentifier", -1L);
         if(this.mBroadcastIdentifier == var3) {
            String var5 = var2.getAction();
            if("com.mopub.action.interstitial.fail".equals(var5)) {
               this.mCustomEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
               return;
            }

            if("com.mopub.action.interstitial.show".equals(var5)) {
               this.mCustomEventInterstitialListener.onInterstitialShown();
               return;
            }

            if("com.mopub.action.interstitial.dismiss".equals(var5)) {
               this.mCustomEventInterstitialListener.onInterstitialDismissed();
               this.unregister();
               return;
            }

            if("com.mopub.action.interstitial.click".equals(var5)) {
               this.mCustomEventInterstitialListener.onInterstitialClicked();
               return;
            }
         }
      }

   }

   public void register(Context var1) {
      this.mContext = var1;
      LocalBroadcastManager.getInstance(this.mContext).registerReceiver(this, sIntentFilter);
   }

   public void unregister() {
      if(this.mContext != null) {
         LocalBroadcastManager.getInstance(this.mContext).unregisterReceiver(this);
         this.mContext = null;
      }

   }
}
