package com.millennialmedia.android;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.OverlaySettings;
import com.millennialmedia.android.Utils$IntentUtils;
import com.millennialmedia.android.Utils$ThreadUtils;
import com.millennialmedia.android.VideoAd;
import java.lang.ref.WeakReference;

final class HttpRedirection {
   private static final String HEADER_LOCATION = "Location";
   private static final String HTTPS = "https";
   private static final String LOG_URL_FORMAT = "Redirecting to: %s";
   private static final String METHOD_GET = "GET";
   private static final String TAG = "HttpRedirection";

   static final String navigateRedirects(String param0) {
      // $FF: Couldn't be decompiled
   }

   static void startActivityFromUri(HttpRedirection$RedirectionListenerImpl var0) {
      if(var0 != null && var0.url != null && var0.weakContext != null) {
         Utils$ThreadUtils.execute(new Runnable() {
            // $FF: synthetic field
            final WeakReference val$listenerReference;

            {
               this.val$listenerReference = var1;
            }

            private void handleDestinationUri(HttpRedirection$RedirectionListenerImpl var1) {
               OverlaySettings var3 = null;
               Context var4 = (Context)var1.weakContext.get();
               if(var4 != null) {
                  String var5 = var1.destinationUri.getScheme();
                  Intent var2 = var3;
                  if(var5 != null) {
                     if(!var5.equalsIgnoreCase("mmvideo")) {
                        var2 = Utils$IntentUtils.getIntentForUri(var1);
                     } else {
                        var2 = var3;
                        if(!var1.isHandlingMMVideo(var1.destinationUri)) {
                           VideoAd.playAd(var4, var1.destinationUri.getHost(), var1);
                           var2 = var3;
                        }
                     }
                  }

                  if(var2 != null) {
                     var3 = var1.getOverlaySettings();
                     if(var2 != null && var3 != null) {
                        if(var1.orientation != null) {
                           var3.orientation = var1.orientation;
                        }

                        var2.putExtra("settings", var3);
                     }

                     String var7 = var2.getStringExtra("class");
                     if(var7 == null || !var7.equals(AdViewOverlayActivity.class.getCanonicalName())) {
                        try {
                           if(var1.isActivityStartable(var1.destinationUri)) {
                              Utils$IntentUtils.startActivity(var4, var2);
                              var1.startingActivity(var1.destinationUri);
                           }
                        } catch (ActivityNotFoundException var6) {
                           MMLog.e("HttpRedirection", String.format("No activity found for %s", new Object[]{var1.destinationUri}), var6);
                           return;
                        }
                     }
                  }
               }

            }

            public final void run() {
               HttpRedirection$RedirectionListenerImpl var1 = (HttpRedirection$RedirectionListenerImpl)this.val$listenerReference.get();
               if(var1 != null) {
                  String var2 = HttpRedirection.navigateRedirects(var1.url);
                  if(var2 != null) {
                     var1.destinationUri = Uri.parse(var2);
                     if(var1.destinationUri == null) {
                        MMLog.e("HttpRedirection", String.format("Could not start activity for %s", new Object[]{var2}));
                        return;
                     }

                     this.handleDestinationUri(var1);
                  }
               }

            }
         });
      }
   }
}
