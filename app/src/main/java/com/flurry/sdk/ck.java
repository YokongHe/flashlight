package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.sdk.ci$a;
import com.flurry.sdk.cq$a;
import com.flurry.sdk.cr$a;
import com.flurry.sdk.cs$a;
import com.flurry.sdk.ct$a;
import com.flurry.sdk.cu$a;
import com.flurry.sdk.cv$a;
import com.flurry.sdk.cw$a;
import com.flurry.sdk.ds;
import com.flurry.sdk.eo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ck {
   private static final String a = null;

   public static com.flurry.sdk.ci a(String param0) {
      // $FF: Couldn't be decompiled
   }

   private static com.flurry.sdk.ci a(XmlPullParser param0, ci$a param1, List param2) {
      // $FF: Couldn't be decompiled
   }

   private static com.flurry.sdk.cq a(XmlPullParser var0, cq$a var1) {
      var0.require(2, a, "Ad");
      var1.a(var0.getAttributeValue(a, "id"));

      try {
         var1.a(Integer.parseInt(var0.getAttributeValue(a, "sequence")));
      } catch (NumberFormatException var3) {
         eo.a(3, "VASTXmlParser", "Could not identify Ad Sequence");
      }

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            String var2 = var0.getName();
            if(var2.equals("InLine")) {
               var1.a(a(var0, new cs$a(), new cr$a(), new ArrayList(), new ArrayList()));
            } else if(var2.equals("Wrapper")) {
               var1.a(a(var0, new cs$a(), new cr$a(), new ArrayList(), new ArrayList(), new ArrayList()));
            } else {
               b(var0);
            }
         }
      }

      return var1.a();
   }

   private static com.flurry.sdk.cs a(XmlPullParser var0, cs$a var1, cr$a var2, List var3, List var4) {
      var1.a(com.flurry.sdk.cl.b);
      var0.require(2, a, "InLine");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            String var5 = var0.getName();
            if(var5.equals("Creatives")) {
               var1.d(a((XmlPullParser)var0, (List)(new ArrayList())));
            } else if(var5.equals("AdSystem")) {
               var2.a(var0.getAttributeValue(a, "version"));
               var2.b(a(var0));
               var1.a(var2.a());
            } else if(var5.equals("AdTitle")) {
               var1.a(a(var0));
            } else if(var5.equals("Impression")) {
               a(var3, a(var0));
            } else if(var5.equals("Error")) {
               a(var4, a(var0));
            } else {
               b(var0);
            }
         }
      }

      var1.b(var3);
      var1.c(var4);
      return var1.a();
   }

   private static com.flurry.sdk.cs a(XmlPullParser var0, cs$a var1, cr$a var2, List var3, List var4, List var5) {
      var1.a(com.flurry.sdk.cl.c);
      var0.require(2, a, "Wrapper");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            String var6 = var0.getName();
            if(var6.equals("Creatives")) {
               var1.d(a((XmlPullParser)var0, (List)(new ArrayList())));
            } else if(var6.equals("AdSystem")) {
               var2.a(var0.getAttributeValue(a, "version"));
               var2.b(a(var0));
               var1.a(var2.a());
            } else if(var6.equals("VASTAdTagURI")) {
               a(var3, a(var0));
            } else if(var6.equals("Impression")) {
               a(var4, a(var0));
            } else if(var6.equals("Error")) {
               a(var5, a(var0));
            } else {
               b(var0);
            }
         }
      }

      var1.a(var3);
      var1.b(var4);
      var1.c(var5);
      return var1.a();
   }

   private static com.flurry.sdk.ct a(XmlPullParser var0, ct$a var1) {
      var0.require(2, a, "Creative");
      var1.a(var0.getAttributeValue(a, "id"));
      String var2 = var0.getAttributeValue(a, "sequence");
      if(var2 != null) {
         try {
            var1.a(Math.round(Float.parseFloat(var2)));
         } catch (NumberFormatException var3) {
            eo.a(3, "VASTXmlParser", "Could not identify Creative sequence");
         }
      }

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            if(var0.getName().equals("Linear")) {
               var1.a(com.flurry.sdk.cm.b);
               var1.a(a(var0, new cu$a()));
            } else {
               b(var0);
            }
         }
      }

      return var1.a();
   }

   private static com.flurry.sdk.cu a(XmlPullParser var0, cu$a var1) {
      var0.require(2, a, "Linear");
      String var2 = var0.getAttributeValue(a, "skipoffset");
      if(var2 != null) {
         var1.b(com.flurry.sdk.cj.b(var2));
      }

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            var2 = var0.getName();
            if(var2.equals("Duration")) {
               var1.a(com.flurry.sdk.cj.b(a(var0)));
            } else if(var2.equals("TrackingEvents")) {
               var1.a(a(var0, new ds()));
            } else if(var2.equals("VideoClicks")) {
               var1.a(a((XmlPullParser)var0, (Map)(new HashMap())));
            } else if(var2.equals("MediaFiles")) {
               var1.a(com.flurry.sdk.cj.a(b(var0, new ArrayList())));
            } else {
               b(var0);
            }
         }
      }

      return var1.a();
   }

   private static com.flurry.sdk.cv a(XmlPullParser var0, cv$a var1) {
      var0.require(2, a, "MediaFile");
      var1.a(var0.getAttributeValue(a, "id"));
      var1.d(var0.getAttributeValue(a, "type"));
      var1.b(var0.getAttributeValue(a, "apiFramework"));
      var1.a(com.flurry.sdk.cn.a(var0.getAttributeValue(a, "delivery")));

      try {
         var1.b(Integer.parseInt(var0.getAttributeValue(a, "height")));
      } catch (NumberFormatException var5) {
         eo.a(3, "VASTXmlParser", "Could not identify MediaFile height");
      }

      try {
         var1.c(Integer.parseInt(var0.getAttributeValue(a, "width")));
      } catch (NumberFormatException var4) {
         eo.a(3, "VASTXmlParser", "Could not identify MediaFile width");
      }

      try {
         var1.a(Integer.parseInt(var0.getAttributeValue(a, "bitrate")));
      } catch (NumberFormatException var3) {
         eo.a(3, "VASTXmlParser", "Could not identify MediaFile bitRate");
      }

      var1.b(Boolean.parseBoolean(var0.getAttributeValue(a, "scalable")));
      var1.a(Boolean.parseBoolean(var0.getAttributeValue(a, "maintainAspectRatio")));
      var1.c(a(var0));
      return var1.a();
   }

   private static com.flurry.sdk.cw a(XmlPullParser var0, cw$a var1) {
      var0.require(2, a, "Tracking");
      var1.a(com.flurry.sdk.co.a(var0.getAttributeValue(a, "event")));
      var1.a(a(var0));
      return var1.a();
   }

   private static ds a(XmlPullParser var0, ds var1) {
      var0.require(2, a, "TrackingEvents");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            if(var0.getName().equals("Tracking")) {
               com.flurry.sdk.cw var2 = a(var0, new cw$a());
               if(!TextUtils.isEmpty(var2.b())) {
                  var1.a(var2.a(), var2.b());
               }
            } else {
               b(var0);
            }
         }
      }

      return var1;
   }

   private static String a(XmlPullParser var0) {
      String var1 = null;
      if(var0.next() == 4) {
         var1 = var0.getText().trim();
         var0.nextTag();
      }

      return var1;
   }

   private static List a(XmlPullParser var0, List var1) {
      var0.require(2, a, "Creatives");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            if(var0.getName().equals("Creative")) {
               var1.add(a(var0, new ct$a()));
            } else {
               b(var0);
            }
         }
      }

      return var1;
   }

   private static Map a(XmlPullParser var0, Map var1) {
      var0.require(2, a, "VideoClicks");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            String var2 = var0.getName();
            if(var2.equals("ClickThrough")) {
               var1.put(com.flurry.sdk.cp.b, a(var0));
            } else if(var2.equals("ClickTracking")) {
               var1.put(com.flurry.sdk.cp.c, a(var0));
            } else if(var2.equals("CustomClick")) {
               var1.put(com.flurry.sdk.cp.d, a(var0));
            } else {
               b(var0);
            }
         }
      }

      return var1;
   }

   private static void a(List var0, String var1) {
      if(var0 != null && !TextUtils.isEmpty(var1)) {
         var0.add(var1);
      }
   }

   public static boolean a(List var0) {
      if(var0 != null && !var0.isEmpty()) {
         Iterator var2 = var0.iterator();

         com.flurry.sdk.cs var1;
         do {
            if(!var2.hasNext()) {
               return true;
            }

            var1 = ((com.flurry.sdk.cq)var2.next()).c();
         } while(var1 != null && com.flurry.sdk.cl.b.equals(var1.a()));

         return false;
      } else {
         return false;
      }
   }

   private static List b(XmlPullParser var0, List var1) {
      var0.require(2, a, "MediaFiles");

      while(var0.next() != 3) {
         if(var0.getEventType() == 2) {
            if(var0.getName().equals("MediaFile")) {
               var1.add(a(var0, new cv$a()));
            } else {
               b(var0);
            }
         }
      }

      return var1;
   }

   private static void b(XmlPullParser var0) {
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
}
