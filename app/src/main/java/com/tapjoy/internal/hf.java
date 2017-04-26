package com.tapjoy.internal;

import com.tapjoy.internal.gz;
import com.tapjoy.internal.hb;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hh;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public final class hf implements HttpEntity {
   private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
   private final hb b;
   private final Header c;
   private long d;
   private volatile boolean e;

   public hf() {
      this(hc.a);
   }

   private hf(hc var1) {
      String var3 = a();
      hc var2 = var1;
      if(var1 == null) {
         var2 = hc.a;
      }

      this.b = new hb("form-data", var3, var2);
      StringBuilder var4 = new StringBuilder();
      var4.append("multipart/form-data; boundary=");
      var4.append(var3);
      this.c = new BasicHeader("Content-Type", var4.toString());
      this.e = true;
   }

   public hf(hc var1, byte var2) {
      this(var1);
   }

   private static String a() {
      StringBuilder var2 = new StringBuilder();
      Random var3 = new Random();
      int var1 = var3.nextInt(11);

      for(int var0 = 0; var0 < var1 + 30; ++var0) {
         var2.append(a[var3.nextInt(a.length)]);
      }

      return var2.toString();
   }

   public final void a(gz var1) {
      this.b.a(var1);
      this.e = true;
   }

   public final void a(String var1, hh var2) {
      this.a(new gz(var1, var2));
   }

   public final void consumeContent() {
      if(this.isStreaming()) {
         throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
      }
   }

   public final InputStream getContent() {
      throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
   }

   public final Header getContentEncoding() {
      return null;
   }

   public final long getContentLength() {
      if(this.e) {
         this.d = this.b.b();
         this.e = false;
      }

      return this.d;
   }

   public final Header getContentType() {
      return this.c;
   }

   public final boolean isChunked() {
      return !this.isRepeatable();
   }

   public final boolean isRepeatable() {
      Iterator var1 = this.b.a().iterator();

      do {
         if(!var1.hasNext()) {
            return true;
         }
      } while(((gz)var1.next()).b.d() >= 0L);

      return false;
   }

   public final boolean isStreaming() {
      return !this.isRepeatable();
   }

   public final void writeTo(OutputStream var1) {
      this.b.a(var1);
   }
}
