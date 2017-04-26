package com.smaato.soma.internal.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRedirect {
   public static String getUrl(String var0) {
      HttpURLConnection var4 = (HttpURLConnection)(new URL(var0)).openConnection();
      var4.setReadTimeout(5000);
      var4.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
      var4.addRequestProperty("User-Agent", "Mozilla");
      var4.addRequestProperty("Referer", "google.com");
      boolean var2 = false;
      int var3 = var4.getResponseCode();
      boolean var1 = var2;
      if(var3 != 200) {
         label18: {
            if(var3 != 302 && var3 != 301) {
               var1 = var2;
               if(var3 != 303) {
                  break label18;
               }
            }

            var1 = true;
         }
      }

      System.out.println("Response Code ... " + var3);
      if(var1) {
         var0 = var4.getHeaderField("Location");
         String var6 = var4.getHeaderField("Set-Cookie");
         HttpURLConnection var5 = (HttpURLConnection)(new URL(var0)).openConnection();
         var5.setRequestProperty("Cookie", var6);
         var5.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
         var5.addRequestProperty("User-Agent", "Mozilla");
         var5.addRequestProperty("Referer", "google.com");
      }

      return var0;
   }
}
