package com.tapjoy.internal;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import android.util.Log;
import com.tapjoy.internal.et;
import com.tapjoy.internal.fc$c;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpParams;

class ff {
   private static final String f = ff.class.toString();
   private final AndroidHttpClient a;
   private final ArrayList b = new ArrayList();
   private HttpResponse c;
   private HttpRequestBase d;
   private fc$c e;

   ff(AndroidHttpClient var1) {
      this.a = var1;
      this.e = fc$c.a;
      this.d = null;
   }

   public static void a(final Context var0, HttpClient var1, final int var2) {
      if(VERSION.SDK_INT >= 14) {
         SSLSocketFactory var4 = SSLCertificateSocketFactory.getHttpSocketFactory(var2, new SSLSessionCache(var0));
         var1.getConnectionManager().getSchemeRegistry().register(new Scheme("https", var4, 443));
      } else {
         LayeredSocketFactory var3 = new LayeredSocketFactory() {
            final SSLSocketFactory a = SSLCertificateSocketFactory.getHttpSocketFactory(var2, new SSLSessionCache(var0));

            public final Socket connectSocket(Socket var1, String var2x, int var3, InetAddress var4, int var5, HttpParams var6) {
               return this.a.connectSocket(var1, var2x, var3, var4, var5, var6);
            }

            public final Socket createSocket() {
               return this.a.createSocket();
            }

            public final Socket createSocket(Socket var1, String var2x, int var3, boolean var4) {
               try {
                  Field var5 = InetAddress.class.getDeclaredField("hostName");
                  var5.setAccessible(true);
                  var5.set(var1.getInetAddress(), var2x);
               } catch (Exception var6) {
                  ;
               }

               return this.a.createSocket(var1, var2x, var3, var4);
            }

            public final boolean isSecure(Socket var1) {
               return this.a.isSecure(var1);
            }
         };
         var1.getConnectionManager().getSchemeRegistry().register(new Scheme("https", var3, 443));
      }
   }

   private void a(HttpRequestBase var1) {
      synchronized(this) {
         this.d = var1;
      }

      Iterator var6 = this.b.iterator();

      while(var6.hasNext()) {
         BasicHeader var2 = (BasicHeader)var6.next();
         this.d.addHeader(var2);
      }

      HttpClientParams.setRedirecting(this.d.getParams(), true);
      et var7 = new et();
      if(var7.a() != null && !var7.a().isEmpty()) {
         HttpHost var8 = new HttpHost(var7.a(), var7.b());
         this.a.getParams().setParameter("http.route.default-proxy", var8);
      } else {
         this.a.getParams().setParameter("http.route.default-proxy", (Object)null);
      }

      try {
         this.c = this.a.execute(this.d);
         this.e = fc$c.b;
      } catch (IOException var4) {
         if(var4.getCause() instanceof CertificateException) {
            this.e = fc$c.g;
         } else if(var4 instanceof SSLPeerUnverifiedException) {
            this.e = fc$c.g;
         } else if(var4 instanceof UnknownHostException) {
            this.e = fc$c.d;
         } else if(var4 instanceof SocketTimeoutException) {
            this.e = fc$c.e;
         } else if(this.e == fc$c.a) {
            this.e = fc$c.c;
         } else {
            String var9 = f;
         }

         Log.e(f, "Failed to retrieve URI", var4);
      } catch (RuntimeException var5) {
         Log.e(f, "Caught runtime exception:", var5);
         this.e = fc$c.c;
      }
   }

   final long a(String var1) {
      this.a((HttpRequestBase)(new HttpGet(var1)));
      return this.c != null && this.e == fc$c.b?(long)this.c.getStatusLine().getStatusCode():-1L;
   }

   final long a(String var1, HttpEntity var2) {
      HttpPost var3 = new HttpPost(var1);
      var3.setEntity(var2);
      this.a((HttpRequestBase)var3);
      return this.c != null && this.e == fc$c.b?(long)this.c.getStatusLine().getStatusCode():-1L;
   }

   public final String a() {
      return this.d != null?this.d.getURI().getScheme() + "://" + this.d.getURI().getHost() + this.d.getURI().getPath():"";
   }

   final void a(Map var1) {
      if(var1 != null) {
         Iterator var2 = var1.keySet().iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            String var4 = (String)var1.get(var3);
            this.b.add(new BasicHeader(var3, var4));
         }
      }

   }

   public final String b() {
      return this.d != null?this.d.getURI().getHost():"";
   }

   public final void c() {
      String var1 = f;
      synchronized(this) {
         if(this.d != null) {
            this.d.abort();
         }
      }

      this.e = fc$c.h;
   }

   public final HttpResponse d() {
      return this.c;
   }

   public final void e() {
      if(this.c != null) {
         HttpEntity var1 = this.c.getEntity();
         if(var1 != null) {
            try {
               var1.consumeContent();
               return;
            } catch (IOException var2) {
               String var3 = f;
               return;
            }
         }
      }

   }

   public final fc$c f() {
      return this.e;
   }
}
