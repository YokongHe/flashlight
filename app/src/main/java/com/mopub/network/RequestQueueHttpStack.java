package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import com.mopub.volley.Request;
import com.mopub.volley.toolbox.HurlStack;
import com.mopub.volley.toolbox.HurlStack$UrlRewriter;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpResponse;

public class RequestQueueHttpStack extends HurlStack {
   private final String mUserAgent;

   public RequestQueueHttpStack(String var1) {
      this(var1, (HurlStack$UrlRewriter)null);
   }

   public RequestQueueHttpStack(String var1, HurlStack$UrlRewriter var2) {
      this(var1, var2, (SSLSocketFactory)null);
   }

   public RequestQueueHttpStack(String var1, HurlStack$UrlRewriter var2, SSLSocketFactory var3) {
      super(var2, var3);
      this.mUserAgent = var1;
   }

   public HttpResponse performRequest(Request var1, Map var2) {
      Object var3 = var2;
      if(var2 == null) {
         var3 = new TreeMap();
      }

      ((Map)var3).put(ResponseHeader.USER_AGENT.getKey(), this.mUserAgent);
      return super.performRequest(var1, (Map)var3);
   }
}
