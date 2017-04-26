package com.inneractive.api.ads.sdk;

import android.util.Xml;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;

final class aj {
   private boolean a = false;
   private String b;

   aj(String var1) {
      try {
         this.a(var1);
      } catch (Exception var2) {
         InneractiveAdView$Log.c("Error parsing Ad XML: " + var2.getMessage());
         throw var2;
      }

      this.a = true;
      InneractiveAdView$Log.a("parser: Parsing finished. parser is ready");
   }

   private void a(String var1) {
      InneractiveAdView$Log.a("Start reading Response");
      XmlPullParser var2 = Xml.newPullParser();
      var2.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
      var2.setInput(new StringReader(var1));
      var2.nextTag();
      var2.require(2, (String)null, "tns:Response");

      while(var2.next() != 3) {
         if(var2.getEventType() == 2) {
            if(var2.getName().equals("tns:Ad")) {
               var2.require(2, (String)null, "tns:Ad");
               InneractiveAdView$Log.a("Start reading Ad");
               var1 = "";
               if(var2.next() == 4) {
                  var1 = var2.getText();
                  var2.nextTag();
               } else {
                  InneractiveAdView$Log.e("No text: " + var2.getName());
               }

               var1 = var1.trim();
               InneractiveAdView$Log.d("Ad content: " + var1);
               this.b = var1;
            } else {
               a(var2);
            }
         }
      }

   }

   private static void a(XmlPullParser var0) {
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

   final boolean a() {
      return this.a;
   }

   final String b() {
      return this.b;
   }
}
