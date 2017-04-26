package com.mopub.common;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.webkit.WebView;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ResponseHeader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClient {
   private static final int CONNECTION_TIMEOUT = 10000;
   private static final String DEFAULT_USER_AGENT = System.getProperty("http.agent");
   private static final int SOCKET_TIMEOUT = 10000;
   private static String sWebViewUserAgent;

   static URI encodeUrl(String var0) {
      try {
         URL var1 = new URL(var0);
         URI var3 = new URI(var1.getProtocol(), var1.getUserInfo(), var1.getHost(), var1.getPort(), var1.getPath(), var1.getQuery(), var1.getRef());
         return var3;
      } catch (Exception var2) {
         MoPubLog.w("Failed to encode url: " + var0);
         throw var2;
      }
   }

   public static AndroidHttpClient getHttpClient() {
      AndroidHttpClient var0 = AndroidHttpClient.newInstance(getWebViewUserAgent(DEFAULT_USER_AGENT));
      HttpParams var1 = var0.getParams();
      HttpConnectionParams.setConnectionTimeout(var1, 10000);
      HttpConnectionParams.setSoTimeout(var1, 10000);
      HttpClientParams.setRedirecting(var1, true);
      return var0;
   }

   public static String getWebViewUserAgent() {
      synchronized(HttpClient.class){}

      String var0;
      try {
         var0 = getWebViewUserAgent((String)null);
      } finally {
         ;
      }

      return var0;
   }

   public static String getWebViewUserAgent(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static HttpGet initializeHttpGet(String var0) {
      return initializeHttpGet(var0, (Context)null);
   }

   public static HttpGet initializeHttpGet(String var0, Context var1) {
      Preconditions.checkNotNull(var0);

      label23: {
         String var2;
         try {
            var2 = urlEncode(var0);
         } catch (Exception var3) {
            break label23;
         }

         var0 = var2;
      }

      HttpGet var4 = new HttpGet(var0);
      if(getWebViewUserAgent() == null && var1 != null) {
         setWebViewUserAgent((new WebView(var1)).getSettings().getUserAgentString());
      }

      String var5 = getWebViewUserAgent();
      if(var5 != null) {
         var4.addHeader(ResponseHeader.USER_AGENT.getKey(), var5);
      }

      return var4;
   }

   static boolean isUrlImproperlyEncoded(String var0) {
      try {
         URLDecoder.decode(var0, "UTF-8");
         return false;
      } catch (UnsupportedEncodingException var2) {
         MoPubLog.w("Url is improperly encoded: " + var0);
         return true;
      }
   }

   static boolean isUrlUnencoded(String var0) {
      try {
         new URI(var0);
         return false;
      } catch (URISyntaxException var1) {
         return true;
      }
   }

   public static void setWebViewUserAgent(String var0) {
      synchronized(HttpClient.class){}

      try {
         sWebViewUserAgent = var0;
      } finally {
         ;
      }

   }

   public static String urlEncode(String var0) {
      Preconditions.checkNotNull(var0);
      if(isUrlImproperlyEncoded(var0)) {
         throw new UnsupportedEncodingException("URL is improperly encoded: " + var0);
      } else {
         URI var1;
         if(isUrlUnencoded(var0)) {
            var1 = encodeUrl(var0);
         } else {
            var1 = new URI(var0);
         }

         return var1.toURL().toString();
      }
   }
}
