package org.nexage.sourcekit.vast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import org.nexage.sourcekit.util.DefaultMediaPicker;
import org.nexage.sourcekit.util.NetworkTools;
import org.nexage.sourcekit.util.VASTLog;
import org.nexage.sourcekit.vast.VASTPlayer$VASTPlayerListener;
import org.nexage.sourcekit.vast.activity.VASTActivity;
import org.nexage.sourcekit.vast.model.VASTModel;
import org.nexage.sourcekit.vast.processor.VASTProcessor;

public class VASTPlayer {
   public static final int ERROR_EXCEEDED_WRAPPER_LIMIT = 6;
   public static final int ERROR_NONE = 0;
   public static final int ERROR_NO_NETWORK = 1;
   public static final int ERROR_POST_VALIDATION = 5;
   public static final int ERROR_SCHEMA_VALIDATION = 4;
   public static final int ERROR_VIDEO_PLAYBACK = 7;
   public static final int ERROR_XML_OPEN_OR_READ = 2;
   public static final int ERROR_XML_PARSE = 3;
   private static final String TAG = "VASTPlayer";
   public static final String VERSION = "1.3";
   public static VASTPlayer$VASTPlayerListener listener;
   private Context context;
   private VASTModel vastModel;

   public VASTPlayer(Context var1, VASTPlayer$VASTPlayerListener var2) {
      this.context = var1;
      listener = var2;
   }

   private void sendError(final int var1) {
      VASTLog.d("VASTPlayer", "sendError");
      if(listener != null) {
         ((Activity)this.context).runOnUiThread(new Runnable() {
            public void run() {
               VASTPlayer.listener.vastError(var1);
            }
         });
      }

   }

   private void sendReady() {
      VASTLog.d("VASTPlayer", "sendReady");
      if(listener != null) {
         ((Activity)this.context).runOnUiThread(new Runnable() {
            public void run() {
               VASTPlayer.listener.vastReady();
            }
         });
      }

   }

   public void loadVideoWithData(final String var1) {
      VASTLog.v("VASTPlayer", "loadVideoWithData\n" + var1);
      this.vastModel = null;
      if(NetworkTools.connectedToInternet(this.context)) {
         (new Thread(new Runnable() {
            public void run() {
               VASTProcessor var2 = new VASTProcessor(new DefaultMediaPicker(VASTPlayer.this.context));
               int var1x = var2.process(var1);
               if(var1x == 0) {
                  VASTPlayer.this.vastModel = var2.getModel();
                  VASTPlayer.this.sendReady();
               } else {
                  VASTPlayer.this.sendError(var1x);
               }
            }
         })).start();
      } else {
         this.sendError(1);
      }
   }

   public void loadVideoWithUrl(final String var1) {
      VASTLog.d("VASTPlayer", "loadVideoWithUrl " + var1);
      this.vastModel = null;
      if(NetworkTools.connectedToInternet(this.context)) {
         (new Thread(new Runnable() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         })).start();
      } else {
         this.sendError(1);
      }
   }

   public void play() {
      VASTLog.d("VASTPlayer", "play");
      if(this.vastModel != null) {
         if(NetworkTools.connectedToInternet(this.context)) {
            Intent var1 = new Intent(this.context, VASTActivity.class);
            var1.putExtra("com.nexage.android.vast.player.vastModel", this.vastModel);
            this.context.startActivity(var1);
         } else {
            this.sendError(1);
         }
      } else {
         VASTLog.w("VASTPlayer", "vastModel is null; nothing to play");
      }
   }
}
