package com.amazon.device.ads;

import com.amazon.device.ads.Log;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebRequestStatus;
import com.amazon.device.ads.WebRequest$WebResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

class HttpClientWebRequest extends WebRequest {
   private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
   private static final String LOG_TAG = HttpClientWebRequest.class.getSimpleName();
   private HttpClient client;

   private void prepareFormRequestBody(HttpPost var1, String var2) {
      ArrayList var6 = new ArrayList();
      Iterator var3 = this.postParameters.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         var6.add(new BasicNameValuePair((String)var4.getKey(), (String)var4.getValue()));
      }

      try {
         var1.setEntity(new UrlEncodedFormEntity(var6, "UTF-8"));
      } catch (UnsupportedEncodingException var5) {
         Log.e(this.getLogTag(), "Unsupported character encoding used while creating the request: %s", new Object[]{var5.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request", var5);
      }
   }

   private void prepareRequestBody(HttpPost var1) {
      String var3 = this.charset;
      String var2 = var3;
      if(var3 == null) {
         var2 = "UTF-8";
      }

      String var4 = this.contentType;
      var3 = var4;
      if(var4 == null) {
         var3 = "text/plain";
      }

      if(this.requestBody != null) {
         this.prepareStringRequestBody(var1, var3, var2);
      } else {
         this.prepareFormRequestBody(var1, var2);
      }
   }

   private void prepareStringRequestBody(HttpPost var1, String var2, String var3) {
      try {
         StringEntity var5 = new StringEntity(this.requestBody, var3);
         var5.setContentType(var2);
         var1.setEntity(var5);
      } catch (UnsupportedEncodingException var4) {
         Log.e(this.getLogTag(), "Unsupported character encoding used while creating the request. ", new Object[]{var4.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.UNSUPPORTED_ENCODING, "Unsupported character encoding used while creating the request.", var4);
      }
   }

   protected void closeConnection() {
      if(this.client != null) {
         this.client.getConnectionManager().closeIdleConnections(0L, TimeUnit.MILLISECONDS);
         this.client.getConnectionManager().closeExpiredConnections();
         this.client = null;
      }

   }

   protected HttpParams createHttpParams() {
      BasicHttpParams var1 = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(var1, this.getTimeout());
      HttpConnectionParams.setSoTimeout(var1, this.getTimeout());
      HttpConnectionParams.setSocketBufferSize(var1, 8192);
      return var1;
   }

   protected HttpRequestBase createHttpRequest(URL var1) {
      URI var2;
      try {
         var2 = this.createURI(var1);
      } catch (URISyntaxException var5) {
         Log.e(this.getLogTag(), "Problem with URI syntax: %s", new Object[]{var5.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.MALFORMED_URL, "Problem with URI syntax", var5);
      }

      Object var6;
      switch(null.$SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[this.getHttpMethod().ordinal()]) {
      case 1:
         var6 = new HttpGet(var2);
         break;
      case 2:
         var6 = new HttpPost(var2);
         this.prepareRequestBody((HttpPost)var6);
         break;
      default:
         var6 = null;
      }

      Iterator var3 = this.headers.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if(var4.getValue() != null && !((String)var4.getValue()).equals("")) {
            ((HttpRequestBase)var6).addHeader((String)var4.getKey(), (String)var4.getValue());
         }
      }

      this.logUrl(var2.toString());
      if(this.logRequestBodyEnabled && this.getRequestBody() != null) {
         Log.d(this.getLogTag(), "Request Body: %s", new Object[]{this.getRequestBody()});
      }

      return (HttpRequestBase)var6;
   }

   protected WebRequest$WebResponse doHttpNetworkCall(URL var1) {
      HttpRequestBase var5 = this.createHttpRequest(var1);
      HttpParams var2 = this.createHttpParams();
      if(this.client != null) {
         this.closeConnection();
      }

      this.client = new DefaultHttpClient(var2);

      HttpResponse var6;
      try {
         var6 = this.client.execute(var5);
      } catch (ClientProtocolException var3) {
         Log.e(this.getLogTag(), "Invalid client protocol: %s", new Object[]{var3.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", var3);
      } catch (IOException var4) {
         Log.e(this.getLogTag(), "IOException during client execution: %s", new Object[]{var4.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException during client execution", var4);
      }

      return this.parseResponse(var6);
   }

   protected String getSubLogTag() {
      return LOG_TAG;
   }

   protected WebRequest$WebResponse parseResponse(HttpResponse var1) {
      WebRequest$WebResponse var2 = new WebRequest$WebResponse(this);
      var2.setHttpStatusCode(var1.getStatusLine().getStatusCode());
      var2.setHttpStatus(var1.getStatusLine().getReasonPhrase());
      if(var2.getHttpStatusCode() == 200) {
         HttpEntity var4 = var1.getEntity();
         if(var4 != null && var4.getContentLength() != 0L) {
            try {
               var2.setInputStream(var4.getContent());
            } catch (IOException var3) {
               Log.e(this.getLogTag(), "IOException while reading the input stream from response: %s", new Object[]{var3.getMessage()});
               throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", var3);
            }
         }
      }

      return var2;
   }
}
