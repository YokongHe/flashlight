package com.smaato.soma.MediationAdapter;

import android.app.Activity;
import android.view.ViewGroup;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AdSettings;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.ErrorCode;
import com.smaato.soma.ReceivedBannerInterface;

public class AdMobMediationAdapter {
   public void destroy() {
   }

   public void requestBannerAd(final com.google.a.a.b.a var1, Activity var2, String var3, String var4, com.google.a.d var5, com.google.a.a.a var6, Object var7) {
      final BannerView var10 = new BannerView(var2);
      int var8 = var5.b();
      int var9 = var5.a();
      String[] var11 = var4.split("&");
      var3 = var11[0].split("=")[1];
      var4 = var11[1].split("=")[1];
      AdSettings var12 = var10.getAdSettings();
      var12.setAdspaceId(Integer.parseInt(var4));
      var12.setPublisherId(Integer.parseInt(var3));
      var12.setBannerHeight(var8);
      var12.setBannerWidth(var9);
      var10.setAdSettings(var12);
      var10.addAdListener(new AdListenerInterface() {
         public void onReceiveAd(AdDownloaderInterface var1x, ReceivedBannerInterface var2) {
            com.google.a.a.b.a var3;
            if(var2.getErrorCode() == ErrorCode.NO_ERROR) {
               if(var10.getParent() != null) {
                  ((ViewGroup)var10.getParent()).removeView(var10);
               }

               var3 = var1;
               var3 = var1;
               BannerView var4 = var10;
            } else {
               var3 = var1;
            }
         }
      });
      var10.setBannerStateListener(new BannerStateListener() {
         public void onWillCloseLandingPage(BaseView var1x) {
            com.google.a.a.b.a var2 = var1;
         }

         public void onWillOpenLandingPage(BaseView var1x) {
            com.google.a.a.b.a var2 = var1;
            var2 = var1;
         }
      });
      var10.asyncLoadNewBanner();
   }
}
