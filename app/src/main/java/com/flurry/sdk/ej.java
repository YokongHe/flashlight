package com.flurry.sdk;

import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class ej implements X509TrustManager {
   private X509TrustManager a = null;

   public ej(KeyStore var1) {
      TrustManagerFactory var2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var2.init(var1);
      TrustManager[] var3 = var2.getTrustManagers();
      if(var3.length == 0) {
         throw new NoSuchAlgorithmException("no trust manager found");
      } else {
         this.a = (X509TrustManager)var3[0];
      }
   }

   public void checkClientTrusted(X509Certificate[] var1, String var2) {
      this.a.checkClientTrusted(var1, var2);
   }

   public void checkServerTrusted(X509Certificate[] var1, String var2) {
      if(var1 != null && var1.length == 1) {
         var1[0].checkValidity();
      } else {
         this.a.checkServerTrusted(var1, var2);
      }
   }

   public X509Certificate[] getAcceptedIssuers() {
      return this.a.getAcceptedIssuers();
   }
}
