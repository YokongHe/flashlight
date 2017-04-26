package com.millennialmedia.android;

import android.text.TextUtils;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.Utils$ThreadUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.TreeMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class HttpGetRequest {
   private static final String TAG = "HttpGetRequest";
   private HttpClient client;
   private HttpGet getRequest;

   HttpGetRequest() {
      BasicHttpParams var1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var1, 10000);
      this.client = new DefaultHttpClient(var1);
      this.getRequest = new HttpGet();
   }

   HttpGetRequest(int var1) {
      BasicHttpParams var2 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var2, 10000);
      HttpConnectionParams.setSoTimeout(var2, var1);
      this.client = new DefaultHttpClient(var2);
      this.getRequest = new HttpGet();
   }

   static String convertStreamToString(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   static void log(final String[] var0) {
      if(var0 != null && var0.length > 0) {
         Utils$ThreadUtils.execute(new Runnable() {
            public final void run() {
               String[] var3 = var0;
               int var2 = var3.length;

               for(int var1 = 0; var1 < var2; ++var1) {
                  String var4 = var3[var1];
                  MMLog.v("HttpGetRequest", String.format("Logging event to: %s", new Object[]{var4}));

                  try {
                     (new HttpGetRequest()).get(var4);
                  } catch (Exception var5) {
                     MMLog.e("HttpGetRequest", "Logging request failed.", var5);
                  }
               }

            }
         });
      }

   }

   HttpResponse get(String var1) {
      HttpResponse var2 = null;
      if(!TextUtils.isEmpty(var1)) {
         try {
            this.getRequest.setURI(new URI(var1));
            var2 = this.client.execute(this.getRequest);
         } catch (OutOfMemoryError var3) {
            MMLog.e("HttpGetRequest", "Out of memory!", var3);
            return null;
         } catch (Exception var4) {
            MMLog.e("HttpGetRequest", "Error connecting:", var4);
            return null;
         }
      }

      return var2;
   }

   void trackConversion(String param1, boolean param2, long param3, TreeMap param5) {
      // $FF: Couldn't be decompiled
   }
}
