package com.millennialmedia.android;

import android.content.Context;
import com.millennialmedia.android.MMLog;
import java.util.Map;

class InlineVideoView$InlineParams {
   boolean autoPlay;
   int bodyHeight;
   int bodyWidth;
   String cachedVideoID;
   String cachedVideoURI;
   int currentPosition;
   boolean goingFullScreen;
   int height;
   boolean isCompleted;
   boolean isInitialPlayBack = true;
   boolean isPlayingStreaming;
   boolean isStopped;
   int originalOrientation;
   float scaleFactor;
   boolean showControls;
   String streamVideoURI;
   String touchCallBack;
   int width;
   int x;
   int y;

   InlineVideoView$InlineParams(Map var1, Context var2) {
      if(var1.get("x") != null) {
         this.x = (int)Float.parseFloat((String)var1.get("x"));
      }

      if(var1.get("y") != null) {
         this.y = (int)Float.parseFloat((String)var1.get("y"));
      }

      if(var1.get("width") != null) {
         this.width = (int)Float.parseFloat((String)var1.get("width"));
      }

      if(var1.get("height") != null) {
         this.height = (int)Float.parseFloat((String)var1.get("height"));
      }

      this.streamVideoURI = (String)var1.get("streamVideoURI");
      this.cachedVideoURI = (String)var1.get("cachedVideoURI");
      this.cachedVideoID = (String)var1.get("cachedVideoID");
      if(var1.get("autoPlay") != null) {
         this.autoPlay = Boolean.parseBoolean((String)var1.get("autoPlay"));
      }

      if(var1.get("showControls") != null) {
         this.showControls = Boolean.parseBoolean((String)var1.get("showControls"));
      }

      if(var1.get("bodyWidth") != null) {
         this.bodyWidth = (int)Float.parseFloat((String)var1.get("bodyWidth"));
      }

      if(var1.get("bodyHeight") != null) {
         this.bodyHeight = (int)Float.parseFloat((String)var1.get("bodyHeight"));
      }

      this.touchCallBack = (String)var1.get("touchCallback");
      this.scaleFactor = var2.getResources().getDisplayMetrics().density;
   }

   static InlineVideoView$InlineParams getInlineParams(String var0) {
      return (InlineVideoView$InlineParams)(new com.millennialmedia.a.a.e()).a(var0, InlineVideoView$InlineParams.class);
   }

   void inflateFromGson(String var1) {
      InlineVideoView$InlineParams var2 = (InlineVideoView$InlineParams)(new com.millennialmedia.a.a.e()).a(var1, InlineVideoView$InlineParams.class);
      this.x = var2.x;
      this.y = var2.y;
      this.bodyWidth = var2.bodyWidth;
      this.bodyHeight = var2.bodyHeight;
      this.width = var2.width;
      this.height = var2.height;
      this.currentPosition = var2.currentPosition;
      this.streamVideoURI = var2.streamVideoURI;
      this.cachedVideoURI = var2.cachedVideoURI;
      this.cachedVideoID = var2.cachedVideoID;
      this.touchCallBack = var2.touchCallBack;
      this.autoPlay = var2.autoPlay;
      this.showControls = var2.showControls;
      this.isInitialPlayBack = var2.isInitialPlayBack;
      this.scaleFactor = var2.scaleFactor;
      this.goingFullScreen = var2.goingFullScreen;
      this.originalOrientation = var2.originalOrientation;
      this.isCompleted = var2.isCompleted;
      MMLog.d("InlineVideoView", "gson*****" + var1);
      MMLog.d("InlineVideoView", "PARAMS*****" + var2);
   }

   public String toString() {
      return String.format("%s id, %d x, %d y, %d bWidth, %d bHeight, %d pos, %b autoPlay", new Object[]{this.cachedVideoID, Integer.valueOf(this.x), Integer.valueOf(this.y), Integer.valueOf(this.bodyWidth), Integer.valueOf(this.bodyHeight), Integer.valueOf(this.currentPosition), Boolean.valueOf(this.autoPlay)});
   }
}
