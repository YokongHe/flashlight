package com.smaato.soma.bannerutilities;

import android.content.Context;
import android.os.Build.VERSION;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.bannerutilities.VideoChrome$VideoChromeClient;
import com.smaato.soma.bannerutilities.VideoChrome$VideoChromeClientImpl;
import com.smaato.soma.exception.VideoChromeContextFailed;

public class VideoChrome {
   private static final String TAG = "Banner Client";
   AbstractBannerPackage mBannerPackage;

   public VideoChrome(AbstractBannerPackage var1) {
      this.mBannerPackage = var1;
   }

   // $FF: synthetic method
   static Context access$0(VideoChrome var0) {
      return var0.getContext();
   }

   private Context getContext() {
      try {
         Context var1 = this.mBannerPackage.getContext();
         return var1;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new VideoChromeContextFailed(var3);
      }
   }

   protected VideoChrome$VideoChromeClient getWebChromeClient() {
      return (VideoChrome$VideoChromeClient)(VERSION.SDK_INT >= 7?new VideoChrome$VideoChromeClientImpl(this):new VideoChrome$VideoChromeClient(this));
   }
}
