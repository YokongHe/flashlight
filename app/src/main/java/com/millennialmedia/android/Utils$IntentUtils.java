package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.millennialmedia.android.AdViewOverlayActivity;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMActivity;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK$Event;
import java.io.File;

class Utils$IntentUtils {
   private static void fixDataAndTypeForVideo(Context var0, Intent var1) {
      Uri var2 = var1.getData();
      if(var2 != null) {
         String var3 = var2.getLastPathSegment();
         if(TextUtils.isEmpty(var1.getStringExtra("class")) && !TextUtils.isEmpty(var3) && (var3.endsWith(".mp4") || var3.endsWith(".3gp") || var3.endsWith(".mkv") || var3.endsWith("content.once"))) {
            var1.setDataAndType(var1.getData(), "video/*");
         }
      }

   }

   static Intent getIntentForUri(HttpRedirection$RedirectionListenerImpl var0) {
      if(var0 == null) {
         return null;
      } else {
         Uri var4 = var0.destinationUri;
         Context var5 = (Context)var0.weakContext.get();
         Intent var7;
         if(var5 != null) {
            label89: {
               if(var4 != null) {
                  String var2 = var4.getScheme();
                  if(var2 != null) {
                     Intent var8;
                     if(var2.equalsIgnoreCase("market")) {
                        MMLog.v("Utils", "Creating Android Market intent.");
                        var8 = new Intent("android.intent.action.VIEW", var4);
                        MMSDK$Event.intentStarted(var5, "market", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("rtsp")) {
                        MMLog.v("Utils", "Creating streaming video player intent.");
                        var7 = new Intent(var5, MMActivity.class);
                        var7.setData(var4);
                        var7.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("tel")) {
                        MMLog.v("Utils", "Creating telephone intent.");
                        var8 = new Intent("android.intent.action.DIAL", var4);
                        MMSDK$Event.intentStarted(var5, "tel", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     String var3;
                     if(var2.equalsIgnoreCase("sms")) {
                        MMLog.v("Utils", "Creating txt message intent.");
                        String var6 = var4.getSchemeSpecificPart();
                        var3 = "";
                        int var1 = var6.indexOf("?body=");
                        var2 = var3;
                        if(var1 != -1) {
                           var2 = var3;
                           if(var6.length() > var1) {
                              var2 = var6.substring(0, var1).replace(',', ';');
                           }
                        }

                        var8 = new Intent("android.intent.action.VIEW", Uri.parse("sms:" + var2));
                        if(var1 == -1) {
                           var8.putExtra("sms_body", var6.substring(var1 + 6));
                        }

                        MMSDK$Event.intentStarted(var5, "sms", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("mailto")) {
                        var8 = new Intent("android.intent.action.VIEW", var4);
                        MMSDK$Event.intentStarted(var5, "email", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("geo")) {
                        MMLog.v("Utils", "Creating Google Maps intent.");
                        var8 = new Intent("android.intent.action.VIEW", var4);
                        MMSDK$Event.intentStarted(var5, "geo", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("https")) {
                        MMLog.v("Utils", "Creating launch browser intent.");
                        var8 = new Intent("android.intent.action.VIEW", var4);
                        MMSDK$Event.intentStarted(var5, "browser", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var2.equalsIgnoreCase("mmbrowser")) {
                        var3 = var4.toString().substring(12);
                        var2 = var3;
                        if(var3 != null) {
                           var2 = var3;
                           if(!var3.contains("://")) {
                              var2 = var3.replaceFirst("//", "://");
                           }
                        }

                        MMLog.v("Utils", "MMBrowser - Creating launch browser intent.");
                        var8 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                        MMSDK$Event.intentStarted(var5, "browser", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(!var2.equalsIgnoreCase("http")) {
                        MMLog.v("Utils", String.format("Creating intent for unrecognized URI. %s", new Object[]{var4}));
                        var7 = new Intent("android.intent.action.VIEW", var4);
                        break label89;
                     }

                     if(var4.getLastPathSegment() != null && (var4.getLastPathSegment().endsWith(".mp4") || var4.getLastPathSegment().endsWith(".3gp"))) {
                        MMLog.v("Utils", "Creating video player intent.");
                        var8 = new Intent(var5, MMActivity.class);
                        var8.setData(var4);
                        var8.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
                        MMSDK$Event.intentStarted(var5, "streamingVideo", var0.creatorAdImplInternalId);
                        var7 = var8;
                        break label89;
                     }

                     if(var0.canOpenOverlay()) {
                        MMLog.v("Utils", "Creating launch overlay intent.");
                        var7 = new Intent(var5, MMActivity.class);
                        var7.putExtra("class", AdViewOverlayActivity.class.getCanonicalName());
                        var7.setData(var4);
                        return var7;
                     }

                     MMLog.v("Utils", "Creating launch browser intent.");
                     MMSDK$Event.intentStarted(var5, "browser", var0.creatorAdImplInternalId);
                     var7 = new Intent("android.intent.action.VIEW", var4);
                     break label89;
                  }
               }

               var7 = null;
            }

            if(var7 != null) {
               MMLog.v("Utils", String.format("%s resolved to Intent: %s", new Object[]{var4, var7}));
            } else {
               MMLog.v("Utils", String.format("%s", new Object[]{var4}));
            }
         } else {
            var7 = null;
         }

         return var7;
      }
   }

   static void startActionView(Context var0, String var1) {
      startActivity(var0, new Intent("android.intent.action.VIEW", Uri.parse(var1)));
   }

   static void startActivity(Context var0, Intent var1) {
      if(!(var0 instanceof Activity)) {
         var1.addFlags(268435456);
      }

      fixDataAndTypeForVideo(var0, var1);
      var0.startActivity(var1);
   }

   static void startAdViewOverlayActivity(Context var0) {
      Intent var1 = new Intent(var0, MMActivity.class);
      var1.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      startActivity(var0, var1);
   }

   static void startAdViewOverlayActivity(Context var0, Intent var1) {
      var1.setClass(var0, MMActivity.class);
      var1.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      startActivity(var0, var1);
   }

   static void startAdViewOverlayActivityWithData(Context var0, String var1) {
      Intent var2 = new Intent(var0, MMActivity.class);
      var2.putExtra("class", "com.millennialmedia.android.AdViewOverlayActivity");
      var2.setData(Uri.parse(var1));
      startActivity(var0, var2);
   }

   static void startCachedVideoPlayerActivity(Context var0, Intent var1) {
      var1.setClass(var0, MMActivity.class);
      var1.putExtra("class", "com.millennialmedia.android.CachedVideoPlayerActivity");
      startActivity(var0, var1);
   }

   static void startPickerActivity(Context var0, File var1, String var2) {
      Intent var3 = new Intent(var0, MMActivity.class);
      var3.setData(Uri.fromFile(var1));
      var3.putExtra("type", var2);
      var3.putExtra("class", "com.millennialmedia.android.BridgeMMMedia$PickerActivity");
      startActivity(var0, var3);
   }

   static void startVideoPlayerActivityWithData(Context var0, Uri var1) {
      Intent var2 = new Intent(var0, MMActivity.class);
      var2.setData(var1);
      var2.putExtra("class", "com.millennialmedia.android.VideoPlayerActivity");
      startActivity(var0, var2);
   }

   static void startVideoPlayerActivityWithData(Context var0, File var1) {
      startVideoPlayerActivityWithData(var0, Uri.fromFile(var1));
   }

   static void startVideoPlayerActivityWithData(Context var0, String var1) {
      startVideoPlayerActivityWithData(var0, Uri.parse(var1));
   }
}
