package com.millennialmedia.android;

import com.millennialmedia.android.InlineVideoView$InlineParams;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMWebView;
import java.util.Map;
import java.util.concurrent.Callable;

class BridgeMMInlineVideo extends MMJSObject {
   private static final String ADJUST_VIDEO = "adjustVideo";
   private static final String INSERT_VIDEO = "insertVideo";
   private static final String PAUSE_VIDEO = "pauseVideo";
   private static final String PLAY_VIDEO = "playVideo";
   private static final String REMOVE_VIDEO = "removeVideo";
   private static final String RESUME_VIDEO = "resumeVideo";
   private static final String SET_STREAM_VIDEO_SOURCE = "setStreamVideoSource";
   private static final String STOP_VIDEO = "stopVideo";

   public MMJSResponse adjustVideo(final Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1x = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            return var1x != null && var1x != null && var1x.getMMLayout().adjustVideo(new InlineVideoView$InlineParams(var1, var1x.getContext()))?MMJSResponse.responseWithSuccess():MMJSResponse.responseWithError();
         }
      });
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("adjustVideo".equals(var1)) {
         var3 = this.adjustVideo(var2);
      } else {
         if("insertVideo".equals(var1)) {
            return this.insertVideo(var2);
         }

         if("pauseVideo".equals(var1)) {
            return this.pauseVideo(var2);
         }

         if("playVideo".equals(var1)) {
            return this.playVideo(var2);
         }

         if("removeVideo".equals(var1)) {
            return this.removeVideo(var2);
         }

         if("resumeVideo".equals(var1)) {
            return this.resumeVideo(var2);
         }

         if("setStreamVideoSource".equals(var1)) {
            return this.setStreamVideoSource(var2);
         }

         if("stopVideo".equals(var1)) {
            return this.stopVideo(var2);
         }
      }

      return var3;
   }

   public MMJSResponse insertVideo(final Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1x = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1x != null) {
               MMLayout var2 = var1x.getMMLayout();
               var2.initInlineVideo(new InlineVideoView$InlineParams(var1, var1x.getContext()));
               return MMJSResponse.responseWithSuccess("usingStreaming=" + var2.isVideoPlayingStreaming());
            } else {
               return MMJSResponse.responseWithError();
            }
         }
      });
   }

   public MMJSResponse pauseVideo(Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1 = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1 != null) {
               MMLayout var2 = var1.getMMLayout();
               if(var2 != null) {
                  var2.pauseVideo();
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }

   public MMJSResponse playVideo(Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1 = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1 != null) {
               MMLayout var2 = var1.getMMLayout();
               if(var2 != null) {
                  var2.playVideo();
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }

   public MMJSResponse removeVideo(Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1 = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1 != null) {
               MMLayout var2 = var1.getMMLayout();
               if(var2 != null) {
                  var2.removeVideo();
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }

   public MMJSResponse resumeVideo(Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1 = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1 != null) {
               MMLayout var2 = var1.getMMLayout();
               if(var2 != null) {
                  var2.resumeVideo();
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }

   public MMJSResponse setStreamVideoSource(final Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1x = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1x != null) {
               MMLayout var3 = var1x.getMMLayout();
               String var2 = (String)var1.get("streamVideoURI");
               if(var3 != null && var2 != null) {
                  var3.setVideoSource(var2);
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }

   public MMJSResponse stopVideo(Map var1) {
      return this.runOnUiThreadFuture(new Callable() {
         public MMJSResponse call() {
            MMWebView var1 = (MMWebView)BridgeMMInlineVideo.this.mmWebViewRef.get();
            if(var1 != null) {
               MMLayout var2 = var1.getMMLayout();
               if(var2 != null) {
                  var2.stopVideo();
                  return MMJSResponse.responseWithSuccess();
               }
            }

            return MMJSResponse.responseWithError();
         }
      });
   }
}
