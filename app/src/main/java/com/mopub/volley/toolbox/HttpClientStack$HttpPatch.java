package com.mopub.volley.toolbox;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class HttpClientStack$HttpPatch extends HttpEntityEnclosingRequestBase {
   public static final String METHOD_NAME = "PATCH";

   public HttpClientStack$HttpPatch() {
   }

   public HttpClientStack$HttpPatch(String var1) {
      this.setURI(URI.create(var1));
   }

   public HttpClientStack$HttpPatch(URI var1) {
      this.setURI(var1);
   }

   public final String getMethod() {
      return "PATCH";
   }
}
