package com.tapjoy.internal;

import android.util.Log;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

class ey {
   private static final String e = ey.class.getName();
   public int a = 0;
   public String b = "";
   public final ArrayList c = new ArrayList();
   public final ArrayList d = new ArrayList();

   private boolean a(XmlPullParser var1) {
      int var2 = var1.next();

      String var4;
      for(String var3 = ""; var2 != 1; var3 = var4) {
         switch(var2) {
         case 0:
            var4 = e;
            var4 = var3;
            break;
         case 1:
         default:
            var4 = e;
            (new StringBuilder("Found unexpected event type: ")).append(var2);
            var4 = var3;
            break;
         case 2:
            var4 = var1.getName();
            break;
         case 3:
            var4 = var3;
            if(var1.getName().equals("PS")) {
               return true;
            }
            break;
         case 4:
            var4 = var3;
            if(var3 != null) {
               if(var3.equals("P")) {
                  this.c.add(var1.getText());
                  var4 = var3;
               } else {
                  var4 = e;
                  (new StringBuilder("Found tag content unexpectedly: ")).append(var3);
                  var4 = var3;
               }
            }
         }

         var2 = var1.next();
      }

      return false;
   }

   private boolean b(XmlPullParser var1) {
      int var2 = var1.next();

      String var4;
      for(String var3 = ""; var2 != 1; var3 = var4) {
         switch(var2) {
         case 0:
            var4 = e;
            var4 = var3;
            break;
         case 1:
         default:
            var4 = e;
            (new StringBuilder("Found unexpected event type: ")).append(var2);
            var4 = var3;
            break;
         case 2:
            var4 = var1.getName();
            break;
         case 3:
            var4 = var3;
            if(var1.getName().equals("EX")) {
               return true;
            }
            break;
         case 4:
            var4 = var3;
            if(var3 != null) {
               if(var3.equals("E")) {
                  label26: {
                     try {
                        this.d.add(new URI(var1.getText()));
                     } catch (URISyntaxException var5) {
                        Log.e(e, "Failed to parse E into URI", var5);
                        var4 = var3;
                        break label26;
                     }

                     var4 = var3;
                  }
               } else {
                  var4 = e;
                  (new StringBuilder("Found tag content unexpectedly: ")).append(var3);
                  var4 = var3;
               }
            }
         }

         var2 = var1.next();
      }

      return false;
   }

   public final boolean a() {
      return this.b != null && !this.b.isEmpty();
   }

   public final boolean a(InputStream param1) {
      // $FF: Couldn't be decompiled
   }
}
