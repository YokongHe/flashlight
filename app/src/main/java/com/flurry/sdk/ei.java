package com.flurry.sdk;

import com.flurry.sdk.ej;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class ei implements LayeredSocketFactory, SocketFactory {
   private SSLContext a = null;

   private static SSLContext a() {
      try {
         SSLContext var0 = SSLContext.getInstance("TLS");
         var0.init((KeyManager[])null, new TrustManager[]{new ej((KeyStore)null)}, (SecureRandom)null);
         return var0;
      } catch (Exception var1) {
         throw new IOException(var1.getMessage());
      }
   }

   private SSLContext b() {
      if(this.a == null) {
         this.a = a();
      }

      return this.a;
   }

   public Socket connectSocket(Socket var1, String var2, int var3, InetAddress var4, int var5, HttpParams var6) {
      int var7 = HttpConnectionParams.getConnectionTimeout(var6);
      int var8 = HttpConnectionParams.getSoTimeout(var6);
      InetSocketAddress var10 = new InetSocketAddress(var2, var3);
      if(var1 == null) {
         var1 = this.createSocket();
      }

      SSLSocket var9 = (SSLSocket)var1;
      if(var4 != null || var5 > 0) {
         var3 = var5;
         if(var5 < 0) {
            var3 = 0;
         }

         var9.bind(new InetSocketAddress(var4, var3));
      }

      var9.connect(var10, var7);
      var9.setSoTimeout(var8);
      return var9;
   }

   public Socket createSocket() {
      return this.b().getSocketFactory().createSocket();
   }

   public Socket createSocket(Socket var1, String var2, int var3, boolean var4) {
      return this.b().getSocketFactory().createSocket(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      return var1 != null && var1.getClass().equals(ei.class);
   }

   public int hashCode() {
      return ei.class.hashCode();
   }

   public boolean isSecure(Socket var1) {
      return true;
   }
}
