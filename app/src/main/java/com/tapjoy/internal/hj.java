package com.tapjoy.internal;

import com.tapjoy.internal.hg;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public final class hj extends hg {
   private final byte[] a;
   private final Charset b;

   public hj(String var1, String var2, Charset var3) {
      super(var2);
      if(var1 == null) {
         throw new IllegalArgumentException("Text may not be null");
      } else {
         Charset var4 = var3;
         if(var3 == null) {
            var4 = Charset.forName("US-ASCII");
         }

         this.a = var1.getBytes(var4.name());
         this.b = var4;
      }
   }

   public final void a(OutputStream var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Output stream may not be null");
      } else {
         ByteArrayInputStream var3 = new ByteArrayInputStream(this.a);
         byte[] var4 = new byte[4096];

         while(true) {
            int var2 = var3.read(var4);
            if(var2 == -1) {
               var1.flush();
               return;
            }

            var1.write(var4, 0, var2);
         }
      }
   }

   public final String b() {
      return this.b.name();
   }

   public final String c() {
      return "8bit";
   }

   public final long d() {
      return (long)this.a.length;
   }
}
