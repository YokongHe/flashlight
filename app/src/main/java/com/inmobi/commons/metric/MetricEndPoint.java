package com.inmobi.commons.metric;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MetricEndPoint {
   public static void sendData(String var0, String var1) {
      HttpURLConnection var3 = (HttpURLConnection)(new URL(var0)).openConnection();
      var3.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
      var3.setDoOutput(true);
      var3.setDoInput(false);
      OutputStreamWriter var2 = new OutputStreamWriter(var3.getOutputStream());
      var2.write(var1);
      var2.flush();
      var2.close();
      var3.getResponseCode();
   }
}
