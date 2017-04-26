package com.amazon.device.ads;

import com.amazon.device.ads.Log;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebRequestStatus;
import com.amazon.device.ads.WebRequest$WebResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map.Entry;

class HttpURLConnectionWebRequest extends WebRequest {
   private static final String LOG_TAG = HttpURLConnectionWebRequest.class.getSimpleName();
   private HttpURLConnection connection;

   private void writePostBody(HttpURLConnection param1) {
      // $FF: Couldn't be decompiled
   }

   protected void closeConnection() {
      if(this.connection != null) {
         this.connection.disconnect();
         this.connection = null;
      }

   }

   protected WebRequest$WebResponse doHttpNetworkCall(URL var1) {
      if(this.connection != null) {
         this.closeConnection();
      }

      try {
         this.connection = this.openConnection(var1);
      } catch (IOException var4) {
         Log.e(this.getLogTag(), "Problem while opening the URL connection: %s", new Object[]{var4.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "Problem while opening the URL connection", var4);
      }

      this.setupRequestProperties(this.connection);

      try {
         this.connection.connect();
      } catch (SocketTimeoutException var2) {
         Log.e(this.getLogTag(), "Socket timed out while connecting to URL: %s", new Object[]{var2.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_TIMEOUT, "Socket timed out while connecting to URL", var2);
      } catch (IOException var3) {
         Log.e(this.getLogTag(), "Problem while connecting to URL: %s", new Object[]{var3.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "Problem while connecting to URL", var3);
      }

      return this.prepareResponse(this.connection);
   }

   protected String getSubLogTag() {
      return LOG_TAG;
   }

   protected HttpURLConnection openConnection(URL var1) {
      return (HttpURLConnection)var1.openConnection();
   }

   protected WebRequest$WebResponse prepareResponse(HttpURLConnection var1) {
      WebRequest$WebResponse var2 = new WebRequest$WebResponse(this);

      try {
         var2.setHttpStatusCode(var1.getResponseCode());
         var2.setHttpStatus(var1.getResponseMessage());
      } catch (SocketTimeoutException var4) {
         Log.e(this.getLogTag(), "Socket Timeout while getting the response status code: %s", new Object[]{var4.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_TIMEOUT, "Socket Timeout while getting the response status code", var4);
      } catch (IOException var5) {
         Log.e(this.getLogTag(), "IOException while getting the response status code: %s", new Object[]{var5.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException while getting the response status code", var5);
      } catch (IndexOutOfBoundsException var6) {
         Log.e(this.getLogTag(), "IndexOutOfBoundsException while getting the response status code: %s", new Object[]{var6.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.MALFORMED_URL, "IndexOutOfBoundsException while getting the response status code", var6);
      }

      if(var2.getHttpStatusCode() == 200) {
         try {
            var2.setInputStream(var1.getInputStream());
         } catch (IOException var3) {
            Log.e(this.getLogTag(), "IOException while reading the input stream from response: %s", new Object[]{var3.getMessage()});
            throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.NETWORK_FAILURE, "IOException while reading the input stream from response", var3);
         }
      }

      return var2;
   }

   protected void setupRequestProperties(HttpURLConnection var1) {
      try {
         var1.setRequestMethod(this.getHttpMethod().name());
      } catch (ProtocolException var4) {
         Log.e(this.getLogTag(), "Invalid client protocol: %s", new Object[]{var4.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.INVALID_CLIENT_PROTOCOL, "Invalid client protocol", var4);
      }

      Iterator var2 = this.headers.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if(var3.getValue() != null && !((String)var3.getValue()).equals("")) {
            var1.setRequestProperty((String)var3.getKey(), (String)var3.getValue());
         }
      }

      var1.setConnectTimeout(this.getTimeout());
      var1.setReadTimeout(this.getTimeout());
      this.logUrl(var1.getURL().toString());
      switch(null.$SwitchMap$com$amazon$device$ads$WebRequest$HttpMethod[this.getHttpMethod().ordinal()]) {
      case 1:
         var1.setDoOutput(false);
         return;
      case 2:
         var1.setDoOutput(true);
         this.writePostBody(var1);
         return;
      default:
      }
   }
}
