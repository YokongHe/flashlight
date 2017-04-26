package com.ihs.a.c.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

final class b implements com.ihs.a.c.b.k {
   private static DefaultHttpClient b;
   private HttpRequestBase a;
   private HttpResponse c;
   private String d;
   private Map e;
   private InputStream f;
   private OutputStream g;
   private HttpParams h;
   private int i = -1;
   private boolean j = false;

   public final int a(String var1, int var2) {
      try {
         int var3 = Integer.parseInt(this.b(var1));
         return var3;
      } catch (NumberFormatException var4) {
         return var2;
      }
   }

   public final String a(String var1) {
      try {
         var1 = b.getParams().getParameter(var1).toString();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public final Map a() {
      // $FF: Couldn't be decompiled
   }

   public final void a(int var1) {
      HttpConnectionParams.setConnectionTimeout(this.h, var1);
   }

   public final void a(String var1, com.ihs.a.c.b.g var2) {
      switch(null.a[var2.ordinal()]) {
      case 1:
         this.a = new HttpPost(var1);
         break;
      case 2:
         this.a = new HttpHead(var1);
         break;
      case 3:
         this.a = new HttpPut(var1);
         break;
      case 4:
         this.a = new HttpDelete(var1);
         break;
      default:
         this.a = new HttpGet(var1);
      }

      this.h = new BasicHttpParams();
      HttpConnectionParams.setConnectionTimeout(this.h, '\uea60');
      HttpConnectionParams.setSoTimeout(this.h, '\uea60');
      HttpClientParams.setRedirecting(this.h, true);
      if(b == null) {
         try {
            this.h.setBooleanParameter("http.protocol.expect-continue", false);
            SchemeRegistry var4 = new SchemeRegistry();
            var4.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            var4.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            b = new DefaultHttpClient(new ThreadSafeClientConnManager(this.h, var4), this.h);
         } catch (Exception var3) {
            b = new DefaultHttpClient();
            return;
         }
      }

   }

   public final void a(String var1, com.ihs.a.c.b.g var2, String var3, int var4) {
      this.a(var1, var2);
   }

   public final void a(String var1, String var2) {
      this.h.setParameter(var1, var2);
   }

   public final void a(boolean var1) {
      this.j = var1;
   }

   public final int b() {
      if(this.i == -1) {
         this.a.setParams(this.h);
         if(this.g != null) {
            ByteArrayEntity var1 = new ByteArrayEntity(((ByteArrayOutputStream)this.g).toByteArray());
            (new StringBuilder("byteArrayEntity:")).append(var1.isRepeatable()).toString();
            ((HttpPost)this.a).setEntity(var1);
         }

         try {
            this.c = b.execute(this.a);
         } catch (IOException var2) {
            var2.printStackTrace();
         }

         if(this.c != null) {
            if(!this.j) {
               this.c.addHeader("Cache-Control", "no-cache");
            }

            this.d = this.c.getStatusLine().getReasonPhrase();
            this.f = this.c.getEntity().getContent();
            this.i = this.c.getStatusLine().getStatusCode();
         }
      }

      return this.i;
   }

   public final String b(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void b(int var1) {
      HttpConnectionParams.setSoTimeout(this.h, var1);
   }

   public final void b(boolean var1) {
      if(this.g == null) {
         this.g = new ByteArrayOutputStream();
      }

   }

   public final String c() {
      if(this.d != null) {
         return this.d;
      } else {
         this.b();
         return this.d;
      }
   }

   public final void c(boolean var1) {
      HttpClientParams.setRedirecting(this.h, var1);
   }

   public final InputStream d() {
      if(this.f != null) {
         return this.f;
      } else {
         this.b();
         return this.f;
      }
   }

   public final InputStream e() {
      try {
         InputStream var1 = this.d();
         return var1;
      } catch (Exception var2) {
         return null;
      }
   }

   public final OutputStream f() {
      return this.g;
   }

   public final void g() {
      if(this.a != null) {
         this.a.abort();
      }

      try {
         if(this.f != null) {
            this.f.close();
            this.f = null;
         }
      } catch (IOException var3) {
         var3.printStackTrace();
      }

      try {
         if(this.g != null) {
            this.g.close();
            this.g = null;
         }

      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }
}
