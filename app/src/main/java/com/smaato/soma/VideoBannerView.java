package com.smaato.soma;

import android.content.Context;
import android.util.AttributeSet;
import com.smaato.soma.AdDimension;
import com.smaato.soma.BannerView;
import com.smaato.soma.VideoInterface;
import com.smaato.soma.VideoListener;

public class VideoBannerView extends BannerView {
   private VideoListener mVideoListener;

   public VideoBannerView(Context var1) {
      super(var1);
      this.init();
   }

   public VideoBannerView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.init();
   }

   public VideoBannerView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.init();
   }

   private void init() {
      this.getAdSettings().setAdDimension(AdDimension.NOT_SET);
   }

   public VideoListener getVideoListener() {
      return this.mVideoListener;
   }

   public void onVideoFinished(VideoInterface var1) {
   }

   public void onVideoPrepared(VideoInterface var1) {
   }

   public void setVideoListener(VideoListener var1) {
      this.mVideoListener = var1;
   }
}
