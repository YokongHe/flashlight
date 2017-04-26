package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HttpClientStack$HttpPatch;
import com.mopub.volley.toolbox.HttpStack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientStack implements HttpStack {
   private static final String HEADER_CONTENT_TYPE = "Content-Type";
   protected final HttpClient mClient;

   public HttpClientStack(HttpClient var1) {
      this.mClient = var1;
   }

   private static void addHeaders(HttpUriRequest var0, Map var1) {
      Iterator var2 = var1.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var0.setHeader(var3, (String)var1.get(var3));
      }

   }

   static HttpUriRequest createHttpRequest(Request var0, Map var1) {
      switch(var0.getMethod()) {
      case -1:
         byte[] var6 = var0.getPostBody();
         if(var6 != null) {
            HttpPost var2 = new HttpPost(var0.getUrl());
            var2.addHeader("Content-Type", var0.getPostBodyContentType());
            var2.setEntity(new ByteArrayEntity(var6));
            return var2;
         }

         return new HttpGet(var0.getUrl());
      case 0:
         return new HttpGet(var0.getUrl());
      case 1:
         HttpPost var5 = new HttpPost(var0.getUrl());
         var5.addHeader("Content-Type", var0.getBodyContentType());
         setEntityIfNonEmptyBody(var5, var0);
         return var5;
      case 2:
         HttpPut var4 = new HttpPut(var0.getUrl());
         var4.addHeader("Content-Type", var0.getBodyContentType());
         setEntityIfNonEmptyBody(var4, var0);
         return var4;
      case 3:
         return new HttpDelete(var0.getUrl());
      case 4:
         return new HttpHead(var0.getUrl());
      case 5:
         return new HttpOptions(var0.getUrl());
      case 6:
         return new HttpTrace(var0.getUrl());
      case 7:
         HttpClientStack$HttpPatch var3 = new HttpClientStack$HttpPatch(var0.getUrl());
         var3.addHeader("Content-Type", var0.getBodyContentType());
         setEntityIfNonEmptyBody(var3, var0);
         return var3;
      default:
         throw new IllegalStateException("Unknown request method.");
      }
   }

   private static List getPostParameterPairs(Map var0) {
      ArrayList var1 = new ArrayList(var0.size());
      Iterator var2 = var0.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new BasicNameValuePair(var3, (String)var0.get(var3)));
      }

      return var1;
   }

   private static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase var0, Request var1) {
      byte[] var2 = var1.getBody();
      if(var2 != null) {
         var0.setEntity(new ByteArrayEntity(var2));
      }

   }

   protected void onPrepareRequest(HttpUriRequest var1) {
   }

   public HttpResponse performRequest(Request var1, Map var2) {
      HttpUriRequest var4 = createHttpRequest(var1, var2);
      addHeaders(var4, var2);
      addHeaders(var4, var1.getHeaders());
      this.onPrepareRequest(var4);
      HttpParams var5 = var4.getParams();
      int var3 = var1.getTimeoutMs();
      HttpConnectionParams.setConnectionTimeout(var5, 5000);
      HttpConnectionParams.setSoTimeout(var5, var3);
      return this.mClient.execute(var4);
   }
}
