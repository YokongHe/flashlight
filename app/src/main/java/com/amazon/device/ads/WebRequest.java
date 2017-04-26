package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest$HttpMethod;
import com.amazon.device.ads.WebRequest$QueryStringParameters;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebRequestFactory;
import com.amazon.device.ads.WebRequest$WebRequestStatus;
import com.amazon.device.ads.WebRequest$WebResponse;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class WebRequest {
   private static final String CHARSET_KEY = "charset";
   public static final String CHARSET_UTF_16 = "UTF-16";
   public static final String CHARSET_UTF_8 = "UTF-8";
   public static final String CONTENT_TYPE_CSS = "text/css";
   public static final String CONTENT_TYPE_HTML = "text/html";
   public static final String CONTENT_TYPE_JAVASCRIPT = "application/javascript";
   public static final String CONTENT_TYPE_JSON = "application/json";
   public static final String CONTENT_TYPE_PLAIN_TEXT = "text/plain";
   public static final int DEFAULT_PORT = -1;
   public static final int DEFAULT_TIMEOUT = 20000;
   private static final String HEADER_ACCEPT_KEY = "Accept";
   private static final String HEADER_CONTENT_TYPE = "Content-Type";
   private static final String LOG_TAG = WebRequest.class.getSimpleName();
   private static WebRequest$WebRequestFactory webRequestFactory = new WebRequest$WebRequestFactory();
   String acceptContentType = null;
   String charset = null;
   String contentType = null;
   private boolean disconnectEnabled;
   protected final HashMap headers;
   private WebRequest$HttpMethod httpMethod;
   boolean logRequestBodyEnabled;
   boolean logResponseEnabled;
   private String logTag;
   protected boolean logUrlEnabled;
   private MetricsCollector metricsCollector;
   private String nonSecureHost = null;
   private String path = null;
   private int port = -1;
   protected HashMap postParameters;
   protected WebRequest$QueryStringParameters queryStringParameters;
   String requestBody = null;
   protected boolean secure;
   private String secureHost = null;
   protected Metrics$MetricType serviceCallLatencyMetric;
   private int timeout;
   private String urlString = null;

   WebRequest() {
      this.httpMethod = WebRequest$HttpMethod.GET;
      this.timeout = 20000;
      this.logRequestBodyEnabled = false;
      this.logResponseEnabled = false;
      this.logUrlEnabled = false;
      this.secure = false;
      this.logTag = LOG_TAG;
      this.queryStringParameters = new WebRequest$QueryStringParameters();
      this.headers = new HashMap();
      this.postParameters = new HashMap();
      this.secure = DebugProperties.getDebugPropertyAsBoolean("debug.tlsEnabled", Settings.getInstance().getBoolean("tlsEnabled", false));
      this.disconnectEnabled = true;
   }

   // $FF: synthetic method
   static boolean access$000(WebRequest var0) {
      return var0.disconnectEnabled;
   }

   public static final WebRequest createJSONGetWebRequest() {
      WebRequest var0 = createNewWebRequest();
      var0.setHttpMethod(WebRequest$HttpMethod.GET);
      var0.putHeader("Accept", "application/json");
      return var0;
   }

   public static final WebRequest createJSONPostWebRequest() {
      WebRequest var0 = createNewWebRequest();
      var0.convertToJSONPostRequest();
      return var0;
   }

   public static final WebRequest createNewWebRequest() {
      return webRequestFactory.createWebRequest();
   }

   public static final void executeWebRequestInThread(final String var0, final boolean var1) {
      ThreadUtils.executeRunnable(new Runnable() {
         public final void run() {
            WebRequest var1x = WebRequest.createNewWebRequest();
            var1x.enableLog(true);
            var1x.setUrlString(var0);
            var1x.setDisconnectEnabled(var1);

            try {
               var1x.makeCall();
            } catch (WebRequest$WebRequestException var2) {
               ;
            }
         }
      });
   }

   protected void appendQuery(StringBuilder var1) {
      this.queryStringParameters.append(var1);
   }

   protected abstract void closeConnection();

   public void convertToJSONPostRequest() {
      this.setHttpMethod(WebRequest$HttpMethod.POST);
      this.putHeader("Accept", "application/json");
      this.putHeader("Content-Type", "application/json; charset=UTF-8");
   }

   protected URI createURI(String var1) {
      return this.createURI(this.createURL(var1));
   }

   protected URI createURI(URL var1) {
      return var1.toURI();
   }

   protected URL createURL(String var1) {
      return new URL(var1);
   }

   protected URI createUri() {
      return (new URL(this.getUrlString())).toURI();
   }

   protected abstract WebRequest$WebResponse doHttpNetworkCall(URL var1);

   public void enableLog(boolean var1) {
      this.enableLogUrl(var1);
      this.enableLogRequestBody(var1);
      this.enableLogResponse(var1);
   }

   public void enableLogRequestBody(boolean var1) {
      this.logRequestBodyEnabled = var1;
   }

   public void enableLogResponse(boolean var1) {
      this.logResponseEnabled = var1;
   }

   public void enableLogUrl(boolean var1) {
      this.logUrlEnabled = var1;
   }

   public String getAcceptContentType() {
      return this.acceptContentType;
   }

   public String getCharset() {
      return this.charset;
   }

   public String getContentType() {
      return this.contentType;
   }

   public boolean getDisconnectEnabled() {
      return this.disconnectEnabled;
   }

   public String getHeader(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else {
         return (String)this.headers.get(var1);
      }
   }

   public String getHost() {
      return this.secure?this.secureHost:this.nonSecureHost;
   }

   public WebRequest$HttpMethod getHttpMethod() {
      return this.httpMethod;
   }

   protected String getLogTag() {
      return this.logTag;
   }

   public String getPath() {
      return this.path;
   }

   public int getPort() {
      return this.port;
   }

   public String getPostParameter(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else {
         return (String)this.postParameters.get(var1);
      }
   }

   public String getQueryParameter(String var1) {
      return this.queryStringParameters.get(var1);
   }

   public String getRequestBody() {
      if(this.getRequestBodyString() != null) {
         return this.getRequestBodyString();
      } else if(this.postParameters.isEmpty()) {
         return null;
      } else {
         StringBuilder var1 = new StringBuilder();
         Iterator var2 = this.postParameters.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.append((String)var3.getKey()).append('=').append((String)var3.getValue()).append(";\n");
         }

         return var1.toString();
      }
   }

   public String getRequestBodyString() {
      return this.requestBody;
   }

   protected String getScheme() {
      return this.getUseSecure()?"https":"http";
   }

   protected abstract String getSubLogTag();

   public int getTimeout() {
      return this.timeout;
   }

   protected String getUrl() {
      if(this.urlString != null) {
         return this.urlString;
      } else {
         StringBuilder var1 = new StringBuilder(this.getScheme());
         var1.append("://");
         var1.append(this.getHost());
         if(this.getPort() != -1) {
            var1.append(":");
            var1.append(this.getPort());
         }

         var1.append(this.getPath());
         this.appendQuery(var1);
         return var1.toString();
      }
   }

   public String getUrlString() {
      return this.urlString;
   }

   public boolean getUseSecure() {
      return this.secure;
   }

   protected void logUrl(String var1) {
      if(this.logUrlEnabled) {
         Log.d(this.getLogTag(), "%s %s", new Object[]{this.getHttpMethod(), var1});
      }

   }

   public WebRequest$WebResponse makeCall() {
      if(ThreadUtils.isOnMainThread()) {
         Log.e(this.logTag, "The network request should not be performed on the main thread.");
      }

      this.setContentTypeHeaders();
      String var1 = this.getUrl();

      URL var2;
      try {
         var2 = this.createURL(var1);
      } catch (MalformedURLException var8) {
         Log.e(this.logTag, "Problem with URI syntax: %s", new Object[]{var8.getMessage()});
         throw new WebRequest$WebRequestException(this, WebRequest$WebRequestStatus.MALFORMED_URL, "Could not construct URL from String " + var1, var8);
      }

      this.writeMetricStart(this.serviceCallLatencyMetric);

      WebRequest$WebResponse var9;
      try {
         var9 = this.doHttpNetworkCall(var2);
      } catch (WebRequest$WebRequestException var6) {
         throw var6;
      } finally {
         this.writeMetricStop(this.serviceCallLatencyMetric);
      }

      if(this.logResponseEnabled) {
         Log.d(LOG_TAG, "Response: %s %s", new Object[]{Integer.valueOf(var9.getHttpStatusCode()), var9.getHttpStatus()});
      }

      return var9;
   }

   public void putHeader(String var1, String var2) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else {
         this.headers.put(var1, var2);
      }
   }

   public void putPostParameter(String var1, String var2) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The name must not be null or empty string.");
      } else if(var2 == null) {
         this.postParameters.remove(var1);
      } else {
         this.postParameters.put(var1, var2);
      }
   }

   public String putUnencodedQueryParameter(String var1, String var2) {
      return this.queryStringParameters.putUnencoded(var1, var2);
   }

   public void putUrlEncodedQueryParameter(String var1, String var2) {
      this.queryStringParameters.putUrlEncoded(var1, var2);
   }

   public void setAcceptContentType(String var1) {
      this.acceptContentType = this.contentType;
   }

   public void setAdditionalQueryParamsString(String var1) {
      this.queryStringParameters.setRawAppendage(var1);
   }

   public void setCharset(String var1) {
      this.charset = var1;
   }

   public void setContentType(String var1) {
      this.contentType = var1;
   }

   protected void setContentTypeHeaders() {
      if(this.acceptContentType != null) {
         this.putHeader("Accept", this.contentType);
      }

      if(this.contentType != null) {
         String var2 = this.contentType;
         String var1 = var2;
         if(this.charset != null) {
            var1 = var2 + "; charset=" + this.charset;
         }

         this.putHeader("Content-Type", var1);
      }

   }

   public void setDisconnectEnabled(boolean var1) {
      this.disconnectEnabled = var1;
   }

   public void setExternalLogTag(String var1) {
      if(var1 == null) {
         this.logTag = LOG_TAG + " " + this.getSubLogTag();
      } else {
         this.logTag = var1 + " " + LOG_TAG + " " + this.getSubLogTag();
      }
   }

   public void setHost(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The host must not be null.");
      } else {
         this.secureHost = var1;
         this.nonSecureHost = var1;
      }
   }

   public void setHttpMethod(WebRequest$HttpMethod var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("The httpMethod must not be null.");
      } else {
         this.httpMethod = var1;
      }
   }

   public void setMetricsCollector(MetricsCollector var1) {
      this.metricsCollector = var1;
   }

   public void setNonSecureHost(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The host must not be null.");
      } else {
         this.nonSecureHost = var1;
      }
   }

   public void setPath(String var1) {
      this.path = var1;
   }

   public void setPort(int var1) {
      this.port = var1;
   }

   public void setQueryStringParameters(WebRequest$QueryStringParameters var1) {
      this.queryStringParameters = var1;
   }

   public void setRequestBodyString(String var1) {
      this.requestBody = var1;
   }

   public void setSecureHost(String var1) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("The host must not be null.");
      } else {
         this.secureHost = var1;
      }
   }

   public void setServiceCallLatencyMetric(Metrics$MetricType var1) {
      this.serviceCallLatencyMetric = var1;
   }

   public void setTimeout(int var1) {
      this.timeout = var1;
   }

   public void setUrlString(String var1) {
      String var2 = var1;
      if(var1 != null) {
         var2 = var1;
         if(this.secure) {
            var2 = var1;
            if(var1.startsWith("http:")) {
               var2 = var1.replaceFirst("http", "https");
            }
         }
      }

      this.urlString = var2;
   }

   public void setUseSecure(boolean var1) {
      this.secure = var1;
   }

   public String toString() {
      return this.getUrl();
   }

   protected void writeMetricStart(Metrics$MetricType var1) {
      if(var1 != null && this.metricsCollector != null) {
         this.metricsCollector.startMetric(var1);
      }

   }

   protected void writeMetricStop(Metrics$MetricType var1) {
      if(var1 != null && this.metricsCollector != null) {
         this.metricsCollector.stopMetric(var1);
      }

   }
}
