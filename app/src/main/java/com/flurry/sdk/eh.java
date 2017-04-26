package com.flurry.sdk;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class eh implements HostnameVerifier {
   public boolean verify(String var1, SSLSession var2) {
      return true;
   }
}
