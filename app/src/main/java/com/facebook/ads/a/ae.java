package com.facebook.ads.a;

import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

class ae extends SSLSocketFactory {
   SSLContext a = SSLContext.getInstance("TLS");

   public ae(KeyStore var1) {
      super(var1);
      X509TrustManager var2 = new X509TrustManager() {
         public void checkClientTrusted(X509Certificate[] var1, String var2) {
         }

         public void checkServerTrusted(X509Certificate[] var1, String var2) {
         }

         public X509Certificate[] getAcceptedIssuers() {
            return null;
         }
      };
      this.a.init((KeyManager[])null, new TrustManager[]{var2}, (SecureRandom)null);
   }

   public Socket createSocket() {
      return this.a.getSocketFactory().createSocket();
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) {
      return this.a.getSocketFactory().createSocket(var1, var2, var3, var4);
   }
}
