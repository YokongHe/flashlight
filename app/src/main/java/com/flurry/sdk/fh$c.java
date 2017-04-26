package com.flurry.sdk;

import com.flurry.sdk.fh;
import com.flurry.sdk.fj;
import java.io.Closeable;
import java.io.InputStream;

public final class fh$c implements Closeable {
   // $FF: synthetic field
   final fh a;
   private final String b;
   private final long c;
   private final InputStream[] d;
   private final long[] e;

   private fh$c(fh var1, String var2, long var3, InputStream[] var5, long[] var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var5;
      this.e = var6;
   }

   // $FF: synthetic method
   fh$c(fh var1, String var2, long var3, InputStream[] var5, long[] var6, Object var7) {
      this(var1, var2, var3, var5, var6);
   }

   public final InputStream a(int var1) {
      return this.d[var1];
   }

   public final void close() {
      InputStream[] var3 = this.d;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         fj.a((Closeable)var3[var1]);
      }

   }
}
