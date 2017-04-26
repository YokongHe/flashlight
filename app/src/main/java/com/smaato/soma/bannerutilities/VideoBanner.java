package com.smaato.soma.bannerutilities;

import com.smaato.soma.BaseView;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.bannerutilities.VideoChrome;
import com.smaato.soma.bannerutilities.VideoChrome$VideoSubView;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.VideoViewInstantiationException;

public class VideoBanner extends AbstractBannerPackage {
   protected StringBuffer createPage(ReceivedBannerInterface var1, int var2, int var3, boolean var4) {
      return new StringBuffer("");
   }

   void initVideoView(BaseView var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         VideoChrome var2 = new VideoChrome(this);
         var2.getClass();
         this.setVideoSubView(new VideoChrome$VideoSubView(var2));
         this.getVideoSubView().startVideo(var1, this.getBanner().getMediaFile(), this.getBanner().getClickUrl());
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new VideoViewInstantiationException(var4);
      }
   }
}
