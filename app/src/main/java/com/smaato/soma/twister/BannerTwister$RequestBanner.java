package com.smaato.soma.twister;

import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ErrorCode;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.twister.BannerTwister;
import java.util.Iterator;

class BannerTwister$RequestBanner implements Runnable {
   // $FF: synthetic field
   final BannerTwister this$0;

   private BannerTwister$RequestBanner(BannerTwister var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   BannerTwister$RequestBanner(BannerTwister var1, BannerTwister$RequestBanner var2) {
      this(var1);
   }

   public void run() {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1 = BannerTwister.access$0(BannerTwister$RequestBanner.this.this$0).iterator();

            while(var1.hasNext()) {
               BannerView var2 = (BannerView)var1.next();
               var2.addAdListener(new AdListenerInterface() {
                  public void onReceiveAd(AdDownloaderInterface var1, final ReceivedBannerInterface var2) {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(var2.getErrorCode() == ErrorCode.NO_ERROR) {
                              BannerTwister$RequestBanner.this.this$0.bannerIsLoaded();
                           } else {
                              BannerTwister$RequestBanner.this.this$0.bannerIsNotLoaded();
                           }

                           return null;
                        }
                     }).execute();
                  }
               });
               var2.setBannerStateListener(new BannerStateListener() {
                  public void onWillCloseLandingPage(BaseView var1) {
                     BannerTwister$RequestBanner.this.this$0.startFlipping();
                  }

                  public void onWillOpenLandingPage(BaseView var1) {
                     BannerTwister$RequestBanner.this.this$0.stopFlipping();
                  }
               });
               var2.asyncLoadNewBanner();
            }

            return null;
         }
      }).execute();
   }
}
