package org.nexage.sourcekit.mraid;

import android.content.Context;
import android.util.Log;
import org.nexage.sourcekit.mraid.MRAIDInterstitialListener;
import org.nexage.sourcekit.mraid.MRAIDNativeFeatureListener;
import org.nexage.sourcekit.mraid.MRAIDView;
import org.nexage.sourcekit.mraid.MRAIDViewListener;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

public class MRAIDInterstitial implements MRAIDViewListener {
   private static final String TAG = "MRAIDInterstitial";
   private boolean isReady;
   private MRAIDInterstitialListener listener;
   private MRAIDView mraidView;

   public MRAIDInterstitial(Context var1, String var2, String var3, String[] var4, MRAIDInterstitialListener var5, MRAIDNativeFeatureListener var6) {
      this.listener = var5;
      this.mraidView = new MRAIDView(var1, var2, var3, var4, this, var6, true);
   }

   public void mraidViewClose(MRAIDView var1) {
      Log.d("MRAIDInterstitial-MRAIDViewListener", "mraidViewClose");
      this.isReady = false;
      if(this.listener != null) {
         this.listener.mraidInterstitialHide(this);
      }

   }

   public void mraidViewExpand(MRAIDView var1) {
      Log.d("MRAIDInterstitial-MRAIDViewListener", "mraidViewExpand");
      if(this.listener != null) {
         this.listener.mraidInterstitialShow(this);
      }

   }

   public void mraidViewLoaded(MRAIDView var1) {
      Log.d("MRAIDInterstitial-MRAIDViewListener", "mraidViewLoaded");
      this.isReady = true;
      if(this.listener != null) {
         this.listener.mraidInterstitialLoaded(this);
      }

   }

   public boolean mraidViewResize(MRAIDView var1, int var2, int var3, int var4, int var5) {
      return true;
   }

   public void show() {
      if(!this.isReady) {
         MRAIDLog.w("MRAIDInterstitial", "interstitial is not ready to show");
      } else {
         this.mraidView.showAsInterstitial();
      }
   }
}
