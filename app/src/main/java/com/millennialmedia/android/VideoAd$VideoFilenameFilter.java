package com.millennialmedia.android;

import com.millennialmedia.android.VideoAd;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;

class VideoAd$VideoFilenameFilter implements FilenameFilter {
   private WeakReference videoAdRef;

   public VideoAd$VideoFilenameFilter(VideoAd var1) {
      this.videoAdRef = new WeakReference(var1);
   }

   public boolean accept(File var1, String var2) {
      VideoAd var3 = (VideoAd)this.videoAdRef.get();
      if(var3 != null) {
         String var4 = var3.getId();
         return var4 == null?false:var2.startsWith(var4);
      } else {
         return false;
      }
   }
}
