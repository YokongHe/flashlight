package com.adsdk.sdk.video;

import android.content.res.Resources.NotFoundException;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.VAST;
import com.adsdk.sdk.video.VAST$Ad;
import com.adsdk.sdk.video.VAST$Ad$Creative;
import com.adsdk.sdk.video.VAST$Ad$Creative$Linear$ClickTracking;
import com.adsdk.sdk.video.VAST$Ad$Creative$Linear$MediaFile;
import com.adsdk.sdk.video.VAST$Ad$Creative$NonLinearAds;
import com.adsdk.sdk.video.VAST$Ad$Creative$NonLinearAds$NonLinear;
import com.adsdk.sdk.video.VAST$Ad$Creative$Tracking;
import com.adsdk.sdk.video.VAST$Ad$Impression;
import com.adsdk.sdk.video.VideoData;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.core.Persister;

public class VASTParser {
   private static final Pattern DURATION_PATTERN = Pattern.compile("^([0-5]?\\d):([0-5]?\\d):([0-5]?\\d)(?:\\.(\\d?\\d?\\d))?$");
   private static final Pattern PERCENT_PATTERN = Pattern.compile("^(\\d?\\d?)%$");

   public static VAST createVastFromStream(InputStream var0) {
      Persister var1 = new Persister();

      try {
         VAST var4 = (VAST)var1.read(VAST.class, var0);
         return var4;
      } catch (NotFoundException var2) {
         var2.printStackTrace();
         return null;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public static VAST createVastFromString(String var0) {
      Persister var1 = new Persister();

      try {
         VAST var4 = (VAST)var1.read(VAST.class, var0);
         return var4;
      } catch (NotFoundException var2) {
         var2.printStackTrace();
         return null;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public static VideoData fillVideoDataFromVast(VAST var0) {
      Object var6 = null;
      if(var0 != null) {
         VideoData var7 = new VideoData();
         Iterator var8 = var0.ads.iterator();
         VAST$Ad$Creative$Linear$MediaFile var2 = null;
         VAST$Ad var1 = null;
         VAST$Ad$Creative var9 = null;

         VAST$Ad$Creative var19;
         VAST$Ad var21;
         VAST$Ad$Creative$Linear$MediaFile var23;
         label126:
         while(true) {
            VAST$Ad var3;
            do {
               if(!var8.hasNext()) {
                  var19 = var9;
                  var21 = var1;
                  var23 = var2;
                  break label126;
               }

               var3 = (VAST$Ad)var8.next();
            } while(var3.inLine == null);

            Iterator var5 = var3.inLine.creatives.iterator();

            VAST$Ad$Creative var4;
            VAST$Ad$Creative$Linear$MediaFile var10;
            VAST$Ad$Creative var11;
            VAST$Ad var13;
            while(true) {
               if(!var5.hasNext()) {
                  VAST$Ad$Creative$Linear$MediaFile var17 = var2;
                  var13 = var1;
                  var11 = var9;
                  var10 = var17;
                  break;
               }

               var4 = (VAST$Ad$Creative)var5.next();
               if(var4.linear != null && var4.linear.mediaFiles != null && !var4.linear.mediaFiles.isEmpty()) {
                  var10 = (VAST$Ad$Creative$Linear$MediaFile)var4.linear.mediaFiles.get(0);
                  var11 = var4;
                  var13 = var3;
                  break;
               }
            }

            var23 = var10;
            var21 = var13;
            var19 = var11;
            if(var11 != null) {
               break;
            }

            var3 = var13;
            var4 = var11;
            var2 = var10;
            var1 = var3;
            var9 = var4;
         }

         if(var23 != null) {
            var7.setSequence(var19.sequence);
            var7.orientation = 4;
            if(var23.delivery != null && var23.delivery.contains("streaming")) {
               var7.delivery = 1;
            } else {
               var7.delivery = 0;
            }

            var7.display = 0;
            var7.type = var23.type;
            if(var23.bitrate != null) {
               var7.bitrate = Integer.parseInt(var23.bitrate);
            }

            var7.width = var23.width;
            var7.height = var23.height;
            var7.videoUrl = var23.url;
            if(var19.linear.duration != null) {
               var7.duration = getDurationFromString(var19.linear.duration);
            }

            var7.showSkipButton = true;
            if(var19.linear.skipoffset != null) {
               var7.showSkipButtonAfter = getSkipoffsetFromString(var19.linear.skipoffset, var7.duration);
            }

            getTrackingEvents(var7, var19.linear.trackingEvents);
            Iterator var12 = var21.inLine.impressions.iterator();

            while(var12.hasNext()) {
               VAST$Ad$Impression var14 = (VAST$Ad$Impression)var12.next();
               var7.impressionEvents.add(var14.url);
            }

            if(var19.linear.videoClicks != null && var19.linear.videoClicks.clickThrough != null) {
               if(var19.linear.videoClicks.clickTracking != null) {
                  var7.videoClickTracking = new ArrayList();
                  var12 = var19.linear.videoClicks.clickTracking.iterator();

                  while(var12.hasNext()) {
                     VAST$Ad$Creative$Linear$ClickTracking var16 = (VAST$Ad$Creative$Linear$ClickTracking)var12.next();
                     var7.videoClickTracking.add(var16.url);
                  }
               }

               var7.videoClickThrough = var19.linear.videoClicks.clickThrough;
            }

            Iterator var18 = var21.inLine.creatives.iterator();

            VAST$Ad$Creative$NonLinearAds var15;
            VAST$Ad$Creative$NonLinearAds$NonLinear var20;
            while(true) {
               if(!var18.hasNext()) {
                  var20 = null;
                  var15 = (VAST$Ad$Creative$NonLinearAds)var6;
                  break;
               }

               var9 = (VAST$Ad$Creative)var18.next();
               if(var9.nonLinearAds != null && var9.nonLinearAds.nonLinears != null && !var9.nonLinearAds.nonLinears.isEmpty()) {
                  var20 = (VAST$Ad$Creative$NonLinearAds$NonLinear)var9.nonLinearAds.nonLinears.get(0);
                  var15 = var9.nonLinearAds;
                  break;
               }
            }

            if(var20 != null) {
               var7.overlayClickThrough = var20.nonLinearClickThrough;
               var7.overlayClickTracking = var20.nonLinearClickTracking.trim();
               var7.overlayHeight = var20.height;
               var7.overlayWidth = var20.width;
               var7.showHtmlOverlayAfter = 0;
               var7.showHtmlOverlay = true;
               if(var20.staticResource != null) {
                  var7.htmlOverlayType = 1;
                  if(var20.staticResource.type.contains("image")) {
                     String var22 = MessageFormat.format("<body style=\'\"\'margin: 0px; padding: 0px; text-align:center;\'\"\'><img src=\'\"\'{0}\'\"\' width=\'\"\'{1}\'dp\"\' height=\'\"\'{2}\'dp\"\'/></body>", new Object[]{var20.staticResource.url.trim(), Integer.valueOf(var20.width), Integer.valueOf(var20.height)});
                     var7.htmlOverlayMarkup = "<style>* { -webkit-tap-highlight-color: rgba(0,0,0,0);} img {width:100%;height:100%} body {margin: 0; padding: 0}</style>" + var22;
                  } else if(var20.staticResource.type.contains("x-javascript")) {
                     var7.htmlOverlayMarkup = "<script src=\"" + var20.staticResource.url.trim() + "\"></script>";
                  }
               } else if(var20.iframeResource != null) {
                  var7.htmlOverlayType = 0;
                  var7.htmlOverlayUrl = var20.iframeResource;
               } else if(var20.htmlResource != null) {
                  var7.htmlOverlayType = 1;
                  var7.htmlOverlayMarkup = var20.htmlResource;
               }

               getTrackingEvents(var7, var15.trackingEvents);
            }

            return var7;
         }
      }

      return null;
   }

   public static int getDurationFromString(String var0) {
      Matcher var4 = DURATION_PATTERN.matcher(var0);
      if(var4.find() && var4.groupCount() == 4) {
         int var1;
         int var2;
         int var3;
         try {
            var1 = Integer.parseInt(var4.group(1));
            var2 = Integer.parseInt(var4.group(2));
            var3 = Integer.parseInt(var4.group(3));
         } catch (NumberFormatException var5) {
            Log.e("Failed to parse duration: " + var0);
            return 0;
         }

         return var3 + var2 * 60 + var1 * 3600;
      } else {
         Log.e("Failed to parse duration: " + var0);
         return 0;
      }
   }

   private static int getSkipoffsetFromString(String var0, int var1) {
      byte var3 = 0;
      int var2 = var3;
      if(var0 != null) {
         Matcher var6 = DURATION_PATTERN.matcher(var0);
         Matcher var7 = PERCENT_PATTERN.matcher(var0);
         if(var6.find() && var6.groupCount() == 4) {
            int var10;
            try {
               var1 = Integer.parseInt(var6.group(1));
               var2 = Integer.parseInt(var6.group(2));
               var10 = Integer.parseInt(var6.group(3));
            } catch (NumberFormatException var9) {
               Log.e("Failed to parse skipoffset: " + var0);
               return 0;
            }

            var2 = var10 + var2 * 60 + var1 * 3600;
         } else {
            var2 = var3;
            if(var7.find()) {
               var2 = var3;
               if(var7.groupCount() == 1) {
                  long var4;
                  try {
                     var4 = (long)Integer.parseInt(var7.group(1)) * (long)var1 / 100L;
                  } catch (NumberFormatException var8) {
                     Log.e("Failed to parse skipoffset: " + var0);
                     return 0;
                  }

                  return (int)var4;
               }
            }
         }
      }

      return var2;
   }

   public static void getTrackingEvents(VideoData var0, List var1) {
      Iterator var4 = var1.iterator();

      while(true) {
         while(true) {
            while(var4.hasNext()) {
               VAST$Ad$Creative$Tracking var5 = (VAST$Ad$Creative$Tracking)var4.next();
               String var6 = var5.event;
               if(!var6.equals("start") && !var6.equals("creativeView")) {
                  if(var6.equals("complete")) {
                     var0.completeEvents.add(var5.url);
                  } else if(var6.equals("mute")) {
                     var0.muteEvents.add(var5.url);
                  } else if(var6.equals("unmute")) {
                     var0.unmuteEvents.add(var5.url);
                  } else if(var6.equals("pause")) {
                     var0.pauseEvents.add(var5.url);
                  } else if(var6.equals("resume")) {
                     var0.resumeEvents.add(var5.url);
                  } else if(!var6.equals("skip") && !var6.equals("close")) {
                     int var2;
                     Vector var3;
                     Vector var7;
                     if(var6.equals("firstQuartile")) {
                        var2 = var0.duration / 4;
                        var3 = (Vector)var0.timeTrackingEvents.get(Integer.valueOf(var2));
                        var7 = var3;
                        if(var3 == null) {
                           var7 = new Vector();
                           var0.timeTrackingEvents.put(Integer.valueOf(var2), var7);
                        }

                        var7.add(var5.url);
                     } else if(var6.equals("midpoint")) {
                        var2 = var0.duration / 2;
                        var3 = (Vector)var0.timeTrackingEvents.get(Integer.valueOf(var2));
                        var7 = var3;
                        if(var3 == null) {
                           var7 = new Vector();
                           var0.timeTrackingEvents.put(Integer.valueOf(var2), var7);
                        }

                        var7.add(var5.url);
                     } else if(var6.equals("thirdQuartile")) {
                        var2 = var0.duration * 3 / 4;
                        var3 = (Vector)var0.timeTrackingEvents.get(Integer.valueOf(var2));
                        var7 = var3;
                        if(var3 == null) {
                           var7 = new Vector();
                           var0.timeTrackingEvents.put(Integer.valueOf(var2), var7);
                        }

                        var7.add(var5.url);
                     }
                  } else {
                     var0.skipEvents.add(var5.url);
                  }
               } else {
                  var0.startEvents.add(var5.url);
               }
            }

            return;
         }
      }
   }
}
