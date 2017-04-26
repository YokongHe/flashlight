package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.OldTapjoyVideoData;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyVideoView;

public class TapjoyVideo {
   private static TapjoyVideo a = null;
   private static TJVideoListener b;
   private Context c;
   private OldTapjoyVideoData d;

   public TapjoyVideo(Context var1) {
      this.c = var1;
      a = this;
   }

   public static TapjoyVideo getInstance() {
      return a;
   }

   public static void videoComplete() {
      if(b != null) {
         b.onVideoComplete();
      }

   }

   public static void videoError(int var0) {
      if(b != null) {
         b.onVideoError(var0);
      }

   }

   public static void videoStart() {
      if(b != null) {
         b.onVideoStart();
      }

   }

   public void setVideoListener(TJVideoListener var1) {
      b = var1;
   }

   public boolean startVideo(String var1, String var2, String var3, String var4, String var5, String var6) {
      TapjoyLog.i("TapjoyVideo", "Starting video activity with video: " + var1);
      if(var1 != null && var4 != null && var5 != null && var1.length() != 0 && var4.length() != 0 && var5.length() != 0) {
         if(var6 != null && var6.length() > 0) {
            this.d = new OldTapjoyVideoData();
            this.d.setOfferID(var1);
            this.d.setCurrencyName(var2);
            this.d.setCurrencyAmount(var3);
            this.d.setClickURL(var4);
            this.d.setWebviewURL(var5);
            this.d.setVideoURL(var6);
            this.d.setCurrencyName(var2);
            this.d.setCurrencyAmount(var3);
            this.d.setClickURL(var4);
            this.d.setWebviewURL(var5);
            this.d.setVideoURL(var6);
            TapjoyLog.i("TapjoyVideo", "videoToPlay: " + this.d.getOfferId());
            TapjoyLog.i("TapjoyVideo", "amount: " + this.d.getCurrencyAmount());
            TapjoyLog.i("TapjoyVideo", "currency: " + this.d.getCurrencyName());
            TapjoyLog.i("TapjoyVideo", "clickURL: " + this.d.getClickURL());
            TapjoyLog.i("TapjoyVideo", "webviewURL: " + this.d.getWebviewURL());
            TapjoyLog.i("TapjoyVideo", "videoURL: " + this.d.getVideoURL());
            Intent var7 = new Intent(this.c, TapjoyVideoView.class);
            var7.setFlags(268435456);
            var7.putExtra("VIDEO_DATA", this.d);
            this.c.startActivity(var7);
            return true;
         } else {
            TapjoyLog.e("TapjoyVideo", "no video data and no video url - aborting playback...");
            return false;
         }
      } else {
         TapjoyLog.i("TapjoyVideo", "aborting video playback... invalid or missing parameter");
         return false;
      }
   }
}
