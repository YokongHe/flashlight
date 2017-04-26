package com.inmobi.commons.analytics.net;

import android.util.Log;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AnalyticsCommon {
   private static void a(HttpURLConnection var0) {
      var0.setDoOutput(true);
      var0.setDoInput(true);
      var0.setConnectTimeout('\uea60');
      var0.setReadTimeout('\uea60');
      var0.setRequestMethod("POST");
      var0.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      var0.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
   }

   public static String getURLEncoded(String var0) {
      try {
         var0 = URLEncoder.encode(var0, "UTF-8");
         return var0;
      } catch (Exception var1) {
         return "";
      }
   }

   public void closeResource(Closeable var1) {
      if(var1 != null) {
         try {
            var1.close();
         } catch (IOException var3) {
            Log.d("[InMobi]-[Analytics]-4.5.2", "Exception closing resource: " + var1, var3);
            return;
         }
      }

   }

   public void postData(HttpURLConnection var1, String var2) {
      var1.setRequestProperty("Content-Length", Integer.toString(var2.length()));
      boolean var8 = false;

      BufferedWriter var3;
      try {
         var8 = true;
         var3 = new BufferedWriter(new OutputStreamWriter(var1.getOutputStream()));
         var8 = false;
      } finally {
         if(var8) {
            var2 = null;
            this.closeResource(var2);
         }
      }

      try {
         var3.write(var2);
      } finally {
         ;
      }

      this.closeResource(var3);
   }

   public HttpURLConnection setupConnection(String var1) {
      HttpURLConnection var2 = (HttpURLConnection)(new URL(var1)).openConnection();
      a(var2);
      return var2;
   }
}
