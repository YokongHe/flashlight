package com.smaato.soma;

import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.FullScreenBanner;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.FullScreenBannerFailedToReceiveAd;

class FullScreenBanner$AdListenerImpl implements AdListenerInterface {
   // $FF: synthetic field
   final FullScreenBanner this$0;

   private FullScreenBanner$AdListenerImpl(FullScreenBanner var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   FullScreenBanner$AdListenerImpl(FullScreenBanner var1, FullScreenBanner$AdListenerImpl var2) {
      this(var1);
   }

   public final void onReceiveAd(AdDownloaderInterface var1, ReceivedBannerInterface var2) {
      try {
         Debugger.methodStart(new Object() {
         });
         if(var2.getStatus() == BannerStatus.ERROR) {
            FullScreenBanner.access$0(this.this$0, var2.getStatus());
            FullScreenBanner.access$1(this.this$0, (ReceivedBannerInterface)null);
         } else {
            FullScreenBanner.access$0(this.this$0, var2.getStatus());
            FullScreenBanner.access$1(this.this$0, var2);
         }
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new FullScreenBannerFailedToReceiveAd(var4);
      }
   }
}
