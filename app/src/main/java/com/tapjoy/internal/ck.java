package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import com.tapjoy.internal.bh$a;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hf;
import com.tapjoy.internal.hj;
import java.io.Closeable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

public final class ck implements com.tapjoy.internal.cj, Closeable, Cloneable {
   public final String a;
   public final String b;
   public final int c;
   private int d = 443;
   private boolean e;
   private String f = "/";
   private List g;
   private HttpClient h;

   public ck(String var1, String var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.g = Collections.synchronizedList(new LinkedList());
      this.h = AndroidHttpClient.newInstance(var1);
      if(this.g == null) {
         this.g = new LinkedList();
      }

      this.g.add(new BasicHeader("Accept-Encoding", "gzip"));
   }

   private HttpUriRequest b(com.tapjoy.internal.cg var1) {
      boolean var2;
      if(this.e) {
         var2 = true;
      } else {
         var2 = false;
      }

      String var3;
      if(var2) {
         var3 = "https";
      } else {
         var3 = "http";
      }

      int var13;
      if(var2) {
         var13 = this.d;
      } else {
         var13 = this.c;
      }

      String var5 = var1.c();
      String var4 = var5;
      if(this.f.length() > 0) {
         var4 = var5;
         if(!var5.startsWith("/")) {
            var4 = this.f + var5;
         }
      }

      com.tapjoy.internal.h var6 = new com.tapjoy.internal.h();
      bh$a var15 = (bh$a)var1.b();
      Object var14;
      switch(null.a[var15.ordinal()]) {
      case 1:
      case 2:
         URI var21 = URIUtils.createURI(var3, this.b, var13, var4, URLEncodedUtils.format(var6, "UTF-8"), (String)null);
         if(var15 == bh$a.a) {
            var14 = new HttpGet(var21);
         } else {
            var14 = new HttpDelete(var21);
         }
         break;
      case 3:
      case 4:
         URI var16 = URIUtils.createURI(var3, this.b, var13, var4, (String)null, (String)null);
         String var7 = var1.d();
         if(var7 != null) {
            if(!"application/json".equals(var7)) {
               throw new IllegalArgumentException("Unknown content type: " + var7);
            }

            var3 = com.tapjoy.internal.bn.a((Object)var1.e());

            try {
               var14 = new StringEntity(var3, "UTF-8");
               ((StringEntity)var14).setContentType(var7 + "; charset=UTF-8");
            } catch (UnsupportedEncodingException var9) {
               throw com.tapjoy.internal.cw.a(var9);
            }
         } else {
            List var22 = Collections.emptyList();
            if(var22.size() <= 0) {
               try {
                  var14 = new UrlEncodedFormEntity(var6, "UTF-8");
               } catch (UnsupportedEncodingException var10) {
                  throw com.tapjoy.internal.cw.a(var10);
               }
            } else {
               var14 = new hf(hc.a, (byte)0);
               Iterator var19 = var6.iterator();

               while(var19.hasNext()) {
                  NameValuePair var8 = (NameValuePair)var19.next();

                  try {
                     ((hf)var14).a(var8.getName(), new hj(var8.getValue(), "text/plain", com.tapjoy.internal.aq.c));
                  } catch (UnsupportedEncodingException var11) {
                     throw com.tapjoy.internal.cw.a(var11);
                  }
               }

               var19 = var22.iterator();

               while(var19.hasNext()) {
                  ((hf)var14).a((gz)var19.next());
               }
            }
         }

         if(var15 == bh$a.b) {
            HttpPost var17 = new HttpPost(var16);
            var17.setEntity((HttpEntity)var14);
            var14 = var17;
         } else {
            HttpPut var18 = new HttpPut(var16);
            var18.setEntity((HttpEntity)var14);
            var14 = var18;
         }
         break;
      default:
         throw new IllegalArgumentException("Unknown method: " + var15);
      }

      Iterator var20 = this.g.iterator();

      while(var20.hasNext()) {
         ((HttpUriRequest)var14).addHeader((Header)var20.next());
      }

      Iterator var12 = var1.a().iterator();

      while(var12.hasNext()) {
         ((HttpUriRequest)var14).addHeader((Header)var12.next());
      }

      return (HttpUriRequest)var14;
   }

   public final Object a(com.tapjoy.internal.cg param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(int var1) {
      this.d = var1;
      this.e = true;
   }

   public final void a(String var1) {
      this.f = var1;
   }

   // $FF: synthetic method
   public final Object clone() {
      com.tapjoy.internal.ck var1 = new com.tapjoy.internal.ck(this.a, this.b, this.c);
      var1.d = this.d;
      var1.e = this.e;
      var1.f = this.f;
      var1.g.clear();
      var1.g.addAll(this.g);
      return var1;
   }

   public final void close() {
      if(this.h instanceof AndroidHttpClient) {
         ((AndroidHttpClient)this.h).close();
         this.h = null;
      }

   }

   protected final void finalize() {
      this.close();
      super.finalize();
   }
}
