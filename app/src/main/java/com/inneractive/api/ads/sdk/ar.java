package com.inneractive.api.ads.sdk;

import android.text.TextUtils;
import android.util.Xml;
import com.inneractive.api.ads.sdk.IAvastMediaFile;
import com.inneractive.api.ads.sdk.IAvastMediaFile$Delivery;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.io.StringReader;
import java.security.InvalidParameterException;
import org.xmlpull.v1.XmlPullParser;

final class ar {
   private volatile boolean a;
   private String b;
   private com.inneractive.api.ads.sdk.ai c;

   ar(String var1, com.inneractive.api.ads.sdk.ai var2) {
      this.c = var2;
      if(var2 == null) {
         throw new InvalidParameterException("invalid response data. can\'t be null");
      } else {
         try {
            this.a(var1);
         } catch (Exception var3) {
            InneractiveAdView$Log.c("Error parsing VAST XML: " + var3.getMessage());
            throw var3;
         }

         InneractiveAdView$Log.a("parser: Parsing finished. parser is ready");
      }
   }

   private void a(String var1) {
      InneractiveAdView$Log.a("Start reading VAST");
      if(TextUtils.isEmpty(var1)) {
         throw new InvalidParameterException("vast data is empty");
      } else {
         XmlPullParser var2 = Xml.newPullParser();
         var2.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
         var2.setInput(new StringReader(var1));
         var2.nextTag();
         var2.require(2, (String)null, "VAST");

         while(var2.next() != 3) {
            if(var2.getEventType() == 2 && var2.getName().equals("Ad")) {
               this.a(var2);
            }
         }

      }
   }

   private void a(XmlPullParser var1) {
      InneractiveAdView$Log.a("Start reading Ad");
      var1.require(2, (String)null, "Ad");

      while(true) {
         do {
            if(var1.next() == 3) {
               return;
            }
         } while(var1.getEventType() != 2);

         String var2 = var1.getName();
         if(var2.equals("InLine")) {
            InneractiveAdView$Log.a("VAST file contains inline ad information.");
            InneractiveAdView$Log.a("Start reading inline");
            var1.require(2, (String)null, "InLine");

            while(var1.next() != 3) {
               if(var1.getEventType() == 2) {
                  String var3 = var1.getName();
                  if(var3 == null) {
                     h(var1);
                  }

                  if(var3.equals("Impression")) {
                     var1.require(2, (String)null, "Impression");
                     var3 = i(var1);
                     this.c.a("impression", var3);
                     var1.require(3, (String)null, "Impression");
                     InneractiveAdView$Log.a("Adding impression event from inline: " + var3);
                  } else if(var3.equals("AdTitle")) {
                     var1.require(2, (String)null, "AdTitle");
                     var3 = i(var1);
                     com.inneractive.api.ads.sdk.ai var4 = this.c;
                     InneractiveAdView$Log.a("Adding title from inline: " + var3);
                     var1.require(3, (String)null, "AdTitle");
                  } else if(var3.equals("Creatives")) {
                     this.e(var1);
                  } else {
                     h(var1);
                  }
               }
            }
         }

         if(var2.equals("Wrapper")) {
            InneractiveAdView$Log.a("VAST file contains wrapped ad information.");
            this.a = true;
            this.g(var1);
         }
      }
   }

   private void a(XmlPullParser var1, com.inneractive.api.ads.sdk.ap var2) {
      InneractiveAdView$Log.a("Start reading events");
      var1.require(2, (String)null, "TrackingEvents");

      while(true) {
         while(true) {
            do {
               if(var1.next() == 3) {
                  return;
               }
            } while(var1.getEventType() != 2);

            String var3 = var1.getName();
            if(var3 != null && var3.equals("Tracking")) {
               var3 = var1.getAttributeValue((String)null, "event");
               var1.require(2, (String)null, "Tracking");
               String var4 = i(var1);
               var2.a(var3, var4);
               InneractiveAdView$Log.a("Added VAST tracking \"" + var3 + "\": " + var4);
               var1.require(3, (String)null, "Tracking");
            } else {
               h(var1);
            }
         }
      }
   }

   private static int b(String var0) {
      String[] var4 = var0.split(":");
      if(var4 != null && var4.length <= 3) {
         int var1;
         if(var4.length == 1) {
            try {
               var1 = Integer.parseInt(var0);
               return var1;
            } catch (NumberFormatException var5) {
               return 0;
            }
         } else {
            int var2;
            if(var4.length == 2) {
               try {
                  var1 = Integer.parseInt(var4[1]);
                  var2 = Integer.parseInt(var4[0]);
               } catch (NumberFormatException var6) {
                  return 0;
               }

               return var2 * 60 + var1;
            } else {
               int var3;
               try {
                  var1 = Integer.parseInt(var4[2]);
                  var2 = Integer.parseInt(var4[1]);
                  var3 = Integer.parseInt(var4[0]);
               } catch (NumberFormatException var7) {
                  return 0;
               }

               return var3 * 3600 + var1 + var2 * 60;
            }
         }
      } else {
         return 0;
      }
   }

   private void b(XmlPullParser var1) {
      InneractiveAdView$Log.a("Start reading media files");
      var1.require(2, (String)null, "MediaFiles");

      while(true) {
         while(true) {
            do {
               if(var1.next() == 3) {
                  return;
               }
            } while(var1.getEventType() != 2);

            String var6 = var1.getName();
            if(var6 != null && var6.equals("MediaFile")) {
               var1.require(2, (String)null, "MediaFile");
               InneractiveAdView$Log.a("Start reading media file");
               IAvastMediaFile$Delivery var10 = IAvastMediaFile$Delivery.a;

               label46: {
                  IAvastMediaFile$Delivery var7;
                  try {
                     var7 = IAvastMediaFile$Delivery.valueOf(var1.getAttributeValue((String)null, "delivery"));
                  } catch (IllegalArgumentException var9) {
                     InneractiveAdView$Log.e("Could not parse MediaFile delivery attribute: " + var1.getAttributeValue((String)null, "delivery") + " assuming progressive");
                     break label46;
                  }

                  var10 = var7;
               }

               String var11 = var1.getAttributeValue((String)null, "type");
               InneractiveAdView$Log.a("Media File type: " + var11);
               int var3 = Integer.valueOf(var1.getAttributeValue((String)null, "width")).intValue();
               InneractiveAdView$Log.a("Media File width: " + var3);
               int var4 = Integer.valueOf(var1.getAttributeValue((String)null, "height")).intValue();
               InneractiveAdView$Log.a("Media File height: " + var4);
               String var8 = var1.getAttributeValue((String)null, "scalable");
               boolean var5;
               if(var8 != null) {
                  var5 = Boolean.valueOf(var8).booleanValue();
                  InneractiveAdView$Log.a("Media File scalable: " + var5);
               }

               var8 = var1.getAttributeValue((String)null, "maintainAspectRatio");
               if(var8 != null) {
                  var5 = Boolean.valueOf(var8).booleanValue();
                  InneractiveAdView$Log.a("Media File maintainAspectRatio: " + var5);
               }

               var8 = var1.getAttributeValue((String)null, "bitrate");
               int var2;
               if(var8 != null) {
                  var2 = Integer.valueOf(var8).intValue();
                  InneractiveAdView$Log.a("Media File Bitrate: " + var2);
               } else {
                  InneractiveAdView$Log.a("Media File Bitrate not defined!");
                  var2 = 0;
               }

               var8 = i(var1);
               InneractiveAdView$Log.a("Media File uri: " + var8);
               IAvastMediaFile var12 = new IAvastMediaFile(var8, var11, var10, var3, var4);
               var12.a(var2);
               this.c.a(var12);
               var1.require(3, (String)null, "MediaFile");
            } else {
               h(var1);
            }
         }
      }
   }

   private void c(XmlPullParser var1) {
      InneractiveAdView$Log.a("Start reading video clicks");
      var1.require(2, (String)null, "VideoClicks");

      while(true) {
         while(true) {
            do {
               if(var1.next() == 3) {
                  return;
               }
            } while(var1.getEventType() != 2);

            String var2 = var1.getName();
            if(var2 != null && var2.equals("ClickThrough")) {
               var1.require(2, (String)null, "ClickThrough");
               var2 = i(var1);
               this.c.c(var2);
               InneractiveAdView$Log.a("Video clickthrough url: " + var2);
               var1.require(3, (String)null, "ClickThrough");
            } else if(var2 != null && var2.equals("ClickTracking")) {
               var1.require(2, (String)null, "ClickTracking");
               var2 = i(var1);
               this.c.a("click", var2);
               InneractiveAdView$Log.a("Video clicktracking url: " + var2);
               var1.require(3, (String)null, "ClickTracking");
            } else {
               h(var1);
            }
         }
      }
   }

   private void d(XmlPullParser var1) {
      InneractiveAdView$Log.a("Start reading linear");
      var1.require(2, (String)null, "Linear");

      while(true) {
         while(true) {
            String var2;
            do {
               if(var1.next() == 3) {
                  return;
               }

               var2 = var1.getName();
            } while(var1.getEventType() != 2);

            if(var2 != null && var2.equals("Duration")) {
               var1.require(2, (String)null, "Duration");
               var2 = i(var1);
               if(!TextUtils.isEmpty(var2)) {
                  com.inneractive.api.ads.sdk.ai var3 = this.c;
                  b(var2);
               }

               var1.require(3, (String)null, "Duration");
               InneractiveAdView$Log.a("Video duration: " + var2);
            } else if(var2 != null && var2.equals("TrackingEvents")) {
               this.a(var1, this.c);
            } else if(var2 != null && var2.equals("MediaFiles")) {
               this.b(var1);
            } else if(var2 != null && var2.equals("VideoClicks")) {
               this.c(var1);
            } else if(var2 != null && var2.equals("AdTitle")) {
               i(var1);
               com.inneractive.api.ads.sdk.ai var4 = this.c;
            } else {
               h(var1);
            }
         }
      }
   }

   private void e(XmlPullParser var1) {
      InneractiveAdView$Log.a("Start reading creatives");
      var1.require(2, (String)null, "Creatives");

      while(true) {
         label40:
         while(true) {
            do {
               if(var1.next() == 3) {
                  return;
               }
            } while(var1.getEventType() != 2);

            String var3 = var1.getName();
            if(var3 != null && var3.equals("Creative")) {
               InneractiveAdView$Log.a("Start reading creative");
               var1.require(2, (String)null, "Creative");

               while(true) {
                  while(true) {
                     do {
                        if(var1.next() == 3) {
                           continue label40;
                        }
                     } while(var1.getEventType() != 2);

                     var3 = var1.getName();
                     if(var3 == null) {
                        h(var1);
                     } else if(!var3.equals("Linear")) {
                        if(var3.equals("CompanionAds")) {
                           InneractiveAdView$Log.a("Found Companion ads");
                           this.f(var1);
                        } else {
                           h(var1);
                        }
                     } else {
                        var3 = var1.getAttributeValue((String)null, "skipoffset");
                        if(var3 != null && var3.indexOf(":") < 0) {
                           int var2 = Integer.parseInt(var3.substring(0, var3.length() - 1));
                           com.inneractive.api.ads.sdk.ai var4 = this.c;
                           InneractiveAdView$Log.a("Linear skipoffset is " + var2 + " [%]");
                        } else if(var3 != null && var3.indexOf(":") >= 0) {
                           InneractiveAdView$Log.e("Absolute time value ignored for skipOffset in VAST xml. Only percentage values will pe parsed.");
                        }

                        this.d(var1);
                     }
                  }
               }
            } else {
               h(var1);
            }
         }
      }
   }

   private void f(XmlPullParser var1) {
      var1.require(2, (String)null, "CompanionAds");

      while(true) {
         label41:
         while(true) {
            do {
               if(var1.next() == 3) {
                  return;
               }
            } while(var1.getEventType() != 2);

            String var2 = var1.getName();
            if(var2 != null && var2.equals("Companion")) {
               var1.require(2, (String)null, "Companion");
               com.inneractive.api.ads.sdk.ao var4 = new com.inneractive.api.ads.sdk.ao();
               var4.b(Integer.valueOf(var1.getAttributeValue((String)null, "width")).intValue());
               var4.c(Integer.valueOf(var1.getAttributeValue((String)null, "height")).intValue());

               while(true) {
                  while(true) {
                     do {
                        if(var1.next() == 3) {
                           if(!TextUtils.isEmpty(var4.e())) {
                              this.c.a(var4);
                              InneractiveAdView$Log.a("Found companion with width = " + var4.a() + " height = " + var4.b());
                              InneractiveAdView$Log.a("Found companion type = " + var4.c());
                              InneractiveAdView$Log.a("companion creative type = " + var4.d());
                              InneractiveAdView$Log.a("Found companion url = " + var4.e());
                              InneractiveAdView$Log.a("Found click through url = " + var4.f());
                           }
                           continue label41;
                        }
                     } while(var1.getEventType() != 2);

                     String var3 = var1.getName();
                     if(var3 == null) {
                        h(var1);
                     }

                     if(!var3.equals("IFrameResource") && !var3.equals("HTMLResource") && !var3.equals("StaticResource")) {
                        if(var3.equals("CompanionClickThrough")) {
                           var4.d(i(var1));
                        } else if(var3.equals("TrackingEvents")) {
                           this.a(var1, var4);
                        } else {
                           h(var1);
                        }
                     } else {
                        var4.a(var3);
                        var4.b(var1.getAttributeValue((String)null, "creativeType"));
                        var4.c(i(var1));
                     }
                  }
               }
            } else {
               h(var1);
            }
         }
      }
   }

   private void g(XmlPullParser var1) {
      var1.require(2, (String)null, "Wrapper");

      while(var1.next() != 3) {
         if(var1.getEventType() == 2) {
            String var2 = var1.getName();
            if(var2 == null) {
               h(var1);
            }

            if(var2.equals("Impression")) {
               var1.require(2, (String)null, "Impression");
               var2 = i(var1);
               this.c.a("impression", var2);
               InneractiveAdView$Log.a("Adding impression tracking url from wrapper: " + var2);
               var1.require(3, (String)null, "Impression");
            } else if(var2.equals("Creatives")) {
               this.e(var1);
            } else if(var2.equals("VASTAdTagURI")) {
               var1.require(2, (String)null, "VASTAdTagURI");
               var2 = i(var1);
               var1.require(3, (String)null, "VASTAdTagURI");
               InneractiveAdView$Log.a("Found wrapper url: " + var2);
               this.b = var2;
            } else if(var2.equals("Error")) {
               var1.require(2, (String)null, "Error");
               var2 = i(var1);
               this.c.a("error", var2);
               InneractiveAdView$Log.a("Adding error tracking url from wrapper: " + var2);
               var1.require(3, (String)null, "Error");
            } else {
               h(var1);
            }
         }
      }

   }

   private static void h(XmlPullParser var0) {
      if(var0.getEventType() != 2) {
         throw new IllegalStateException();
      } else {
         int var1 = 1;

         while(var1 != 0) {
            switch(var0.next()) {
            case 2:
               ++var1;
               break;
            case 3:
               --var1;
            }
         }

      }
   }

   private static String i(XmlPullParser var0) {
      String var1 = "";
      String var2;
      if(var0.next() == 4) {
         var1 = var0.getText();
         var0.nextTag();
         var2 = var1;
      } else {
         InneractiveAdView$Log.e("No text: " + var0.getName());
         var2 = var1;
      }

      return var2.trim();
   }

   final boolean a() {
      return this.a;
   }

   final String b() {
      return this.b;
   }
}
