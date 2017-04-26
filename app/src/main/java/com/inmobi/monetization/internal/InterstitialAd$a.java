package com.inmobi.monetization.internal;

import android.os.Handler;
import android.os.Message;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.InterstitialAd;
import com.inmobi.monetization.internal.configs.NetworkEventType;
import com.inmobi.re.container.IMWebView;
import java.lang.ref.WeakReference;

class InterstitialAd$a extends Handler {
   private final WeakReference a;

   public InterstitialAd$a(InterstitialAd var1) {
      this.a = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      InterstitialAd var6 = (InterstitialAd)this.a.get();
      if(var6 != null) {
         try {
            switch(var1.what) {
            case 301:
               InterstitialAd.b(var6).cancelLoad();
               InterstitialAd.b(var6).stopLoading();
               InterstitialAd.b(var6).deinit();
               InterstitialAd.a(var6, (IMWebView)null);
               long var2 = System.currentTimeMillis();
               long var4 = InterstitialAd.c(var6);
               var6.collectMetrics(InterstitialAd.d(var6), var2 - var4, NetworkEventType.RENDER_TIMEOUT);
               if(var6.mAdListener != null) {
                  var6.mAdListener.onAdRequestFailed(AdErrorCode.AD_RENDERING_TIMEOUT);
                  return;
               }
            }
         } catch (Exception var7) {
            Log.internal("[InMobi]-[Monetization]", "Exception handling message in Interstitial", var7);
            return;
         }
      }

   }
}
