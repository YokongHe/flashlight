package com.flurry.sdk;

import com.flurry.sdk.fe;
import com.flurry.sdk.fh$c;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class aw$b implements Closeable {
   // $FF: synthetic field
   final com.flurry.sdk.aw a;
   private final fh$c b;
   private final InputStream c;
   private final GZIPInputStream d;
   private final BufferedInputStream e;
   private boolean f;

   private aw$b(com.flurry.sdk.aw var1, fh$c var2, boolean var3) {
      this.a = var1;
      if(var2 == null) {
         throw new IllegalArgumentException("Snapshot cannot be null");
      } else {
         this.b = var2;
         this.c = this.b.a(0);
         if(this.c == null) {
            throw new IOException("Snapshot inputstream is null");
         } else if(var3) {
            this.d = new GZIPInputStream(this.c);
            if(this.d == null) {
               throw new IOException("Gzip inputstream is null");
            } else {
               this.e = new BufferedInputStream(this.d);
            }
         } else {
            this.d = null;
            this.e = new BufferedInputStream(this.c);
         }
      }
   }

   // $FF: synthetic method
   aw$b(com.flurry.sdk.aw var1, fh$c var2, boolean var3, Object var4) {
      this(var1, var2, var3);
   }

   public InputStream a() {
      return this.e;
   }

   public void close() {
      if(!this.f) {
         this.f = true;
         fe.a((Closeable)this.e);
         fe.a((Closeable)this.d);
         fe.a((Closeable)this.c);
         fe.a((Closeable)this.b);
      }
   }

   protected void finalize() {
      super.finalize();
      this.close();
   }
}
