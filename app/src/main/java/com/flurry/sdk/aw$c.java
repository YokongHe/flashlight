package com.flurry.sdk;

import com.flurry.sdk.aw$a;
import com.flurry.sdk.fh$a;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class aw$c implements Closeable {
   // $FF: synthetic field
   final com.flurry.sdk.aw a;
   private final fh$a b;
   private final OutputStream c;
   private final GZIPOutputStream d;
   private final aw$a e;
   private boolean f;

   private aw$c(com.flurry.sdk.aw var1, fh$a var2, boolean var3) {
      this.a = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("Editor cannot be null");
      } else {
         this.b = var2;
         this.c = this.b.a(0);
         if(this.b == null) {
            throw new IOException("Editor outputstream is null");
         } else if(var3) {
            this.d = new GZIPOutputStream(this.c);
            if(this.d == null) {
               throw new IOException("Gzip outputstream is null");
            } else {
               this.e = new aw$a(this.d, null);
            }
         } else {
            this.d = null;
            this.e = new aw$a(this.c, null);
         }
      }
   }

   // $FF: synthetic method
   aw$c(com.flurry.sdk.aw var1, fh$a var2, boolean var3, Object var4) {
      this(var1, var2, var3);
   }

   public OutputStream a() {
      return this.e;
   }

   public void close() {
      // $FF: Couldn't be decompiled
   }

   protected void finalize() {
      super.finalize();
      this.close();
   }
}
