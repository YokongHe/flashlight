package com.tapjoy.internal;

import com.tapjoy.internal.gz;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hc;
import com.tapjoy.internal.hd;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hh;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

public final class hb {
   private static final ByteArrayBuffer a;
   private static final ByteArrayBuffer b;
   private static final ByteArrayBuffer c;
   private final String d;
   private final Charset e;
   private final String f;
   private final List g;
   private final hc h;

   static {
      a = a(hd.a, ": ");
      b = a(hd.a, "\r\n");
      c = a(hd.a, "--");
   }

   public hb(String var1, String var2, hc var3) {
      if(var1 == null) {
         throw new IllegalArgumentException("Multipart subtype may not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Multipart boundary may not be null");
      } else {
         this.d = var1;
         this.e = hd.a;
         this.f = var2;
         this.g = new ArrayList();
         this.h = var3;
      }
   }

   private static ByteArrayBuffer a(Charset var0, String var1) {
      ByteBuffer var2 = var0.encode(CharBuffer.wrap(var1));
      ByteArrayBuffer var3 = new ByteArrayBuffer(var2.remaining());
      var3.append(var2.array(), var2.position(), var2.remaining());
      return var3;
   }

   private void a(hc var1, OutputStream var2, boolean var3) {
      ByteArrayBuffer var4 = a(this.e, this.f);

      for(Iterator var5 = this.g.iterator(); var5.hasNext(); a(b, var2)) {
         gz var6;
         var6 = (gz)var5.next();
         a(c, var2);
         a(var4, var2);
         a(b, var2);
         ha var7 = var6.a;
         label23:
         switch(null.a[var1.ordinal()]) {
         case 1:
            Iterator var11 = var7.iterator();

            while(true) {
               if(!var11.hasNext()) {
                  break label23;
               }

               he var12 = (he)var11.next();
               a(var12.a, var2);
               a(a, var2);
               a(var12.b, var2);
               a(b, var2);
            }
         case 2:
            he var9 = var6.a.a("Content-Disposition");
            Charset var8 = this.e;
            a(var9.a, var8, var2);
            a(a, var2);
            a(var9.b, var8, var2);
            a(b, var2);
            hh var10 = var6.b;
         }

         a(b, var2);
         if(var3) {
            var6.b.a(var2);
         }
      }

      a(c, var2);
      a(var4, var2);
      a(c, var2);
      a(b, var2);
   }

   private static void a(String var0, OutputStream var1) {
      a(a(hd.a, var0), var1);
   }

   private static void a(String var0, Charset var1, OutputStream var2) {
      a(a(var1, var0), var2);
   }

   private static void a(ByteArrayBuffer var0, OutputStream var1) {
      var1.write(var0.buffer(), 0, var0.length());
   }

   public final List a() {
      return this.g;
   }

   public final void a(gz var1) {
      if(var1 != null) {
         this.g.add(var1);
      }
   }

   public final void a(OutputStream var1) {
      this.a(this.h, var1, true);
   }

   public final long b() {
      Iterator var6 = this.g.iterator();

      long var2;
      long var4;
      for(var2 = 0L; var6.hasNext(); var2 += var4) {
         var4 = ((gz)var6.next()).b.d();
         if(var4 < 0L) {
            return -1L;
         }
      }

      ByteArrayOutputStream var8 = new ByteArrayOutputStream();

      int var1;
      try {
         this.a(this.h, var8, false);
         var1 = var8.toByteArray().length;
      } catch (IOException var7) {
         return -1L;
      }

      return (long)var1 + var2;
   }
}
