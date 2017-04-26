package com.adsdk.sdk.mraid;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpClientFactory {
   public static final int SOCKET_SIZE = 8192;
   private static HttpClientFactory instance = new HttpClientFactory();

   public static DefaultHttpClient create() {
      return instance.internalCreate(0);
   }

   public static DefaultHttpClient create(int var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(HttpClientFactory var0) {
      instance = var0;
   }

   protected DefaultHttpClient internalCreate(int var1) {
      BasicHttpParams var2 = new BasicHttpParams();
      if(var1 > 0) {
         HttpConnectionParams.setConnectionTimeout(var2, var1);
         HttpConnectionParams.setSoTimeout(var2, var1);
      }

      HttpConnectionParams.setSocketBufferSize(var2, 8192);
      return new DefaultHttpClient(var2);
   }
}
