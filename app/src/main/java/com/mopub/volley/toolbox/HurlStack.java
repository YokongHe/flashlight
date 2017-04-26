package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpStack;
import com.mopub.volley.toolbox.HurlStack$UrlRewriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public class HurlStack implements HttpStack {
   private static final String HEADER_CONTENT_TYPE = "Content-Type";
   private final SSLSocketFactory mSslSocketFactory;
   private final HurlStack$UrlRewriter mUrlRewriter;

   public HurlStack() {
      this((HurlStack$UrlRewriter)null);
   }

   public HurlStack(HurlStack$UrlRewriter var1) {
      this(var1, (SSLSocketFactory)null);
   }

   public HurlStack(HurlStack$UrlRewriter var1, SSLSocketFactory var2) {
      this.mUrlRewriter = var1;
      this.mSslSocketFactory = var2;
   }

   private static void addBodyIfExists(HttpURLConnection var0, Request var1) {
      byte[] var2 = var1.getBody();
      if(var2 != null) {
         var0.setDoOutput(true);
         var0.addRequestProperty("Content-Type", var1.getBodyContentType());
         DataOutputStream var3 = new DataOutputStream(var0.getOutputStream());
         var3.write(var2);
         var3.close();
      }

   }

   private static HttpEntity entityFromConnection(HttpURLConnection var0) {
      BasicHttpEntity var2 = new BasicHttpEntity();

      InputStream var1;
      try {
         var1 = var0.getInputStream();
      } catch (IOException var3) {
         var1 = var0.getErrorStream();
      }

      var2.setContent(var1);
      var2.setContentLength((long)var0.getContentLength());
      var2.setContentEncoding(var0.getContentEncoding());
      var2.setContentType(var0.getContentType());
      return var2;
   }

   private HttpURLConnection openConnection(URL var1, Request var2) {
      HttpURLConnection var4 = this.createConnection(var1);
      int var3 = var2.getTimeoutMs();
      var4.setConnectTimeout(var3);
      var4.setReadTimeout(var3);
      var4.setUseCaches(false);
      var4.setDoInput(true);
      if("https".equals(var1.getProtocol()) && this.mSslSocketFactory != null) {
         ((HttpsURLConnection)var4).setSSLSocketFactory(this.mSslSocketFactory);
      }

      return var4;
   }

   static void setConnectionParametersForRequest(HttpURLConnection var0, Request var1) {
      switch(var1.getMethod()) {
      case -1:
         byte[] var2 = var1.getPostBody();
         if(var2 != null) {
            var0.setDoOutput(true);
            var0.setRequestMethod("POST");
            var0.addRequestProperty("Content-Type", var1.getPostBodyContentType());
            DataOutputStream var3 = new DataOutputStream(var0.getOutputStream());
            var3.write(var2);
            var3.close();
         }

         return;
      case 0:
         var0.setRequestMethod("GET");
         return;
      case 1:
         var0.setRequestMethod("POST");
         addBodyIfExists(var0, var1);
         return;
      case 2:
         var0.setRequestMethod("PUT");
         addBodyIfExists(var0, var1);
         return;
      case 3:
         var0.setRequestMethod("DELETE");
         return;
      case 4:
         var0.setRequestMethod("HEAD");
         return;
      case 5:
         var0.setRequestMethod("OPTIONS");
         return;
      case 6:
         var0.setRequestMethod("TRACE");
         return;
      case 7:
         var0.setRequestMethod("PATCH");
         addBodyIfExists(var0, var1);
         return;
      default:
         throw new IllegalStateException("Unknown method type.");
      }
   }

   protected HttpURLConnection createConnection(URL var1) {
      return (HttpURLConnection)var1.openConnection();
   }

   public HttpResponse performRequest(Request var1, Map var2) {
      String var3 = var1.getUrl();
      HashMap var5 = new HashMap();
      var5.putAll(var1.getHeaders());
      var5.putAll(var2);
      String var4;
      String var8;
      if(this.mUrlRewriter != null) {
         var4 = this.mUrlRewriter.rewriteUrl(var3);
         var8 = var4;
         if(var4 == null) {
            throw new IOException("URL blocked by rewriter: " + var3);
         }
      } else {
         var8 = var3;
      }

      HttpURLConnection var9 = this.openConnection(new URL(var8), var1);
      Iterator var10 = var5.keySet().iterator();

      while(var10.hasNext()) {
         var4 = (String)var10.next();
         var9.addRequestProperty(var4, (String)var5.get(var4));
      }

      setConnectionParametersForRequest(var9, var1);
      ProtocolVersion var6 = new ProtocolVersion("HTTP", 1, 1);
      if(var9.getResponseCode() == -1) {
         throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      } else {
         BasicHttpResponse var7 = new BasicHttpResponse(new BasicStatusLine(var6, var9.getResponseCode(), var9.getResponseMessage()));
         var7.setEntity(entityFromConnection(var9));
         Iterator var11 = var9.getHeaderFields().entrySet().iterator();

         while(var11.hasNext()) {
            Entry var12 = (Entry)var11.next();
            if(var12.getKey() != null) {
               var7.addHeader(new BasicHeader((String)var12.getKey(), (String)((List)var12.getValue()).get(0)));
            }
         }

         return var7;
      }
   }
}
