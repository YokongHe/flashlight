package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.MMLog;
import org.json.JSONObject;

class HandShake$AdTypeHandShake {
   boolean downloading;
   long lastVideo;
   // $FF: synthetic field
   final HandShake this$0;
   long videoInterval;

   HandShake$AdTypeHandShake(HandShake var1) {
      this.this$0 = var1;
      this.lastVideo = 0L;
      this.videoInterval = 0L;
   }

   boolean canDisplayCachedAd(long var1) {
      return System.currentTimeMillis() - var1 < HandShake.access$1100(this.this$0);
   }

   boolean canRequestVideo(Context var1) {
      long var2 = System.currentTimeMillis();
      MMLog.d("HandShake", "canRequestVideo() Current Time:" + var2 + " Last Video: " + this.lastVideo / 1000L + "  Diff: " + (var2 - this.lastVideo) / 1000L + "  Video interval: " + this.videoInterval / 1000L);
      return System.currentTimeMillis() - this.lastVideo > this.videoInterval;
   }

   void deserializeFromObj(JSONObject var1) {
      if(var1 != null) {
         this.videoInterval = var1.optLong("videointerval") * 1000L;
      }
   }

   boolean load(SharedPreferences var1, String var2) {
      boolean var3 = false;
      if(var1.contains("handshake_lastvideo_" + var2)) {
         this.lastVideo = var1.getLong("handshake_lastvideo_" + var2, this.lastVideo);
         var3 = true;
      }

      if(var1.contains("handshake_videointerval_" + var2)) {
         this.videoInterval = var1.getLong("handshake_videointerval_" + var2, this.videoInterval);
         return true;
      } else {
         return var3;
      }
   }

   void loadLastVideo(Context var1, String var2) {
      SharedPreferences var3 = var1.getSharedPreferences("MillennialMediaSettings", 0);
      if(var3 != null && var3.contains("handshake_lastvideo_" + var2)) {
         this.lastVideo = var3.getLong("handshake_lastvideo_" + var2, this.lastVideo);
      }

   }

   void save(Context var1, String var2) {
      Editor var3 = var1.getSharedPreferences("MillennialMediaSettings", 0).edit();
      this.save(var3, var2);
      var3.commit();
   }

   void save(Editor var1, String var2) {
      var1.putLong("handshake_lastvideo_" + var2, this.lastVideo);
      var1.putLong("handshake_videointerval_" + var2, this.videoInterval);
   }

   void updateLastVideoViewedTime(Context var1, String var2) {
      this.lastVideo = System.currentTimeMillis();
      this.save(var1, var2);
   }
}
