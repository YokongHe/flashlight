package com.mopub.mobileads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;

public class BaseVideoPlayerActivity extends Activity {
   static final String VIDEO_CLASS_EXTRAS_KEY = "video_view_class_name";
   public static final String VIDEO_URL = "video_url";

   static Intent createIntentMraid(Context var0, String var1) {
      Intent var2 = new Intent(var0, MraidVideoPlayerActivity.class);
      var2.setFlags(268435456);
      var2.putExtra("video_view_class_name", "mraid");
      var2.putExtra("video_url", var1);
      return var2;
   }

   static Intent createIntentVast(Context var0, VastVideoConfiguration var1, long var2) {
      Intent var4 = new Intent(var0, MraidVideoPlayerActivity.class);
      var4.setFlags(268435456);
      var4.putExtra("video_view_class_name", "vast");
      var4.putExtra("vast_video_configuration", var1);
      var4.putExtra("broadcastIdentifier", var2);
      return var4;
   }

   public static void startMraid(Context var0, String var1) {
      Intent var3 = createIntentMraid(var0, var1);

      try {
         var0.startActivity(var3);
      } catch (ActivityNotFoundException var2) {
         MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
      }
   }

   static void startVast(Context var0, VastVideoConfiguration var1, long var2) {
      Intent var5 = createIntentVast(var0, var1, var2);

      try {
         var0.startActivity(var5);
      } catch (ActivityNotFoundException var4) {
         MoPubLog.d("Activity MraidVideoPlayerActivity not found. Did you declare it in your AndroidManifest.xml?");
      }
   }
}
