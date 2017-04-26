package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amazon.device.ads.WebUtils;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;

class WebUtils$WebUtilsExecutor {
   String encloseHtml(String var1, boolean var2) {
      String var4 = var1;
      if(var1 != null) {
         String var3 = var1;
         if(var1.indexOf("<html>") == -1) {
            var3 = "<html>" + var1 + "</html>";
         }

         var4 = var3;
         if(var2) {
            var4 = var3;
            if(var3.indexOf("<!DOCTYPE html>") == -1) {
               var4 = "<!DOCTYPE html>" + var3;
            }
         }
      }

      return var4;
   }

   String getScheme(String var1) {
      String var2 = Uri.parse(var1).getScheme();
      var1 = var2;
      if(var2 != null) {
         var1 = var2.toLowerCase(Locale.US);
      }

      return var1;
   }

   String getURLDecodedString(String var1) {
      if(var1 == null) {
         return null;
      } else {
         try {
            String var2 = URLDecoder.decode(var1, "UTF-8");
            return var2;
         } catch (UnsupportedEncodingException var3) {
            android.util.Log.d(WebUtils.access$000(), "getURLDecodedString threw: %s", var3);
            return var1;
         }
      }
   }

   String getURLEncodedString(String var1) {
      if(var1 == null) {
         return null;
      } else {
         try {
            String var2 = URLEncoder.encode(var1, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
            return var2;
         } catch (UnsupportedEncodingException var3) {
            android.util.Log.d(WebUtils.access$000(), "getURLEncodedString threw: %s", var3);
            return var1;
         }
      }
   }

   boolean launchActivityForIntentLink(String var1, Context var2) {
      String var3;
      label33: {
         if(var1 != null) {
            var3 = var1;
            if(!var1.equals("")) {
               break label33;
            }
         }

         var3 = "about:blank";
      }

      android.util.Log.d(WebUtils.access$000(), "Launch Intent: " + var3);
      Intent var7 = new Intent();
      if(var3.startsWith("intent:")) {
         try {
            var7 = Intent.parseUri(var3, 1);
         } catch (URISyntaxException var5) {
            return false;
         }
      } else {
         var7.setData(Uri.parse(var3));
      }

      var7.setAction("android.intent.action.VIEW");
      var7.setFlags(268435456);

      try {
         var2.startActivity(var7);
         return true;
      } catch (ActivityNotFoundException var6) {
         String var8 = var7.getAction();
         var3 = WebUtils.access$000();
         StringBuilder var4 = new StringBuilder("Could not handle ");
         if(var8.startsWith("market://")) {
            var1 = "market";
         } else {
            var1 = "intent";
         }

         android.util.Log.w(var3, var4.append(var1).append(" action: ").append(var8).toString());
         return false;
      }
   }
}
