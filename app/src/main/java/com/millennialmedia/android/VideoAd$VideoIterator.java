package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.AdCache$Iterator;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.VideoAd;
import java.lang.ref.WeakReference;

class VideoAd$VideoIterator extends AdCache$Iterator {
   private WeakReference contextRef;
   boolean hasSharedVideoFile = false;
   private WeakReference videoAdRef;

   public VideoAd$VideoIterator(Context var1, VideoAd var2) {
      this.videoAdRef = new WeakReference(var2);
      this.contextRef = new WeakReference(var1);
   }

   boolean callback(CachedAd var1) {
      if(var1 != null && var1 instanceof VideoAd) {
         VideoAd var2 = (VideoAd)var1;
         VideoAd var3 = (VideoAd)this.videoAdRef.get();
         if(var3 != null && VideoAd.access$000(var2).equals(VideoAd.access$000(var3))) {
            this.hasSharedVideoFile = true;
         }
      }

      return super.callback(var1);
   }

   void deleteVideoFile(Context var1) {
      VideoAd var2 = (VideoAd)this.videoAdRef.get();
      if(var2 != null && AdCache.deleteFile(var1, VideoAd.access$000(var2) + "video.dat")) {
         MMLog.v("VideoAd", String.format("VideoAd video file %s was deleted.", new Object[]{VideoAd.access$000(var2)}));
      }

   }

   void done() {
      if(!this.hasSharedVideoFile) {
         Context var1 = (Context)this.contextRef.get();
         if(var1 != null) {
            this.deleteVideoFile(var1);
         }
      }

      super.done();
   }
}
