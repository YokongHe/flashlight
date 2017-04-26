package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.AdCache$AdCacheTaskListener;
import com.millennialmedia.android.AdCache$Iterator;
import com.millennialmedia.android.CachedAd;
import com.millennialmedia.android.MMActivity;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMWebView;
import com.millennialmedia.android.VideoAd;
import com.millennialmedia.android.VideoPlayerActivity;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;

class BridgeMMCachedVideo extends MMJSObject implements AdCache$AdCacheTaskListener {
   private static final String AVAILABLE_CACHED_VIDEOS = "availableCachedVideos";
   private static final String CACHE_VIDEO = "cacheVideo";
   private static final String END_VIDEO = "endVideo";
   private static final String PAUSE_VIDEO = "pauseVideo";
   private static final String PLAY_CACHED_VIDEO = "playCachedVideo";
   private static final String PLAY_VIDEO = "playVideo";
   private static final String RESTART_VIDEO = "restartVideo";
   private static final String TAG = "BridgeMMCachedVideo";
   private static final String VIDEO_ID_EXISTS = "videoIdExists";
   private boolean success;

   private VideoPlayerActivity getVPA() {
      if(this.mmWebViewRef != null && this.mmWebViewRef.get() != null && ((MMWebView)this.mmWebViewRef.get()).getActivity() instanceof MMActivity) {
         MMWebView var1 = (MMWebView)this.mmWebViewRef.get();
         if(var1 != null) {
            Activity var2 = var1.getActivity();
            if(var2 != null && var2 instanceof MMActivity) {
               MMActivity var3 = (MMActivity)var2;
               if(var3.getWrappedActivity() != null && var3.getWrappedActivity() instanceof VideoPlayerActivity) {
                  return (VideoPlayerActivity)var3.getWrappedActivity();
               }
            }
         }
      }

      return null;
   }

   public MMJSResponse availableCachedVideos(Map var1) {
      final Context var2 = (Context)this.contextRef.get();
      if(var2 != null) {
         final JSONArray var3 = new JSONArray();
         AdCache.iterateCachedAds(var2, 2, new AdCache$Iterator() {
            boolean callback(CachedAd var1) {
               if(var1 instanceof VideoAd && var1.isOnDisk(var2) && !var1.isExpired()) {
                  var3.put(var1.getId());
               }

               return true;
            }
         });
         MMJSResponse var4 = new MMJSResponse();
         var4.result = 1;
         var4.response = var3;
         return var4;
      } else {
         return null;
      }
   }

   public MMJSResponse cacheVideo(Map param1) {
      // $FF: Couldn't be decompiled
   }

   public void downloadCompleted(CachedAd param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void downloadStart(CachedAd var1) {
   }

   public MMJSResponse endVideo(Map var1) {
      final VideoPlayerActivity var2 = this.getVPA();
      return var2 != null?this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            var2.endVideo();
            return MMJSResponse.responseWithSuccess();
         }
      }):null;
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("availableCachedVideos".equals(var1)) {
         var3 = this.availableCachedVideos(var2);
      } else {
         if("cacheVideo".equals(var1)) {
            return this.cacheVideo(var2);
         }

         if("endVideo".equals(var1)) {
            return this.endVideo(var2);
         }

         if("pauseVideo".equals(var1)) {
            return this.pauseVideo(var2);
         }

         if("playCachedVideo".equals(var1)) {
            return this.playCachedVideo(var2);
         }

         if("playVideo".equals(var1)) {
            return this.playVideo(var2);
         }

         if("restartVideo".equals(var1)) {
            return this.restartVideo(var2);
         }

         if("videoIdExists".equals(var1)) {
            return this.videoIdExists(var2);
         }
      }

      return var3;
   }

   public MMJSResponse pauseVideo(Map var1) {
      final VideoPlayerActivity var2 = this.getVPA();
      return var2 != null?this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            var2.pauseVideoByUser();
            return MMJSResponse.responseWithSuccess();
         }
      }):null;
   }

   public MMJSResponse playCachedVideo(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("videoId");
      if(var3 != null && var2 != null) {
         VideoAd var4 = (VideoAd)AdCache.load(var2, var3);
         if(var4 != null && var4.canShow(var2, (MMAdImpl)null, false)) {
            var4.show(var2, this.getAdImplId((String)var1.get("PROPERTY_EXPANDING")));
            return MMJSResponse.responseWithSuccess(String.format("Playing Video(%s)", new Object[]{var3}));
         }
      }

      return null;
   }

   public MMJSResponse playVideo(Map var1) {
      final VideoPlayerActivity var2 = this.getVPA();
      return var2 != null?this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            var2.resumeVideo();
            return MMJSResponse.responseWithSuccess();
         }
      }):null;
   }

   public MMJSResponse restartVideo(Map var1) {
      final VideoPlayerActivity var2 = this.getVPA();
      return var2 != null?this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            var2.restartVideo();
            return MMJSResponse.responseWithSuccess();
         }
      }):null;
   }

   @Deprecated
   public MMJSResponse videoIdExists(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var4 = (String)var1.get("videoId");
      if(var4 != null && var2 != null) {
         VideoAd var3 = (VideoAd)AdCache.load(var2, var4);
         if(var3 != null && var3.isOnDisk(var2) && !var3.isExpired()) {
            return MMJSResponse.responseWithSuccess(var4);
         }
      }

      return null;
   }
}
