package com.inneractive.api.ads.sdk;

import java.io.Closeable;
import java.io.InputStream;

final class s$c implements Closeable {
   private final InputStream[] a;

   private s$c(com.inneractive.api.ads.sdk.s var1, String var2, long var3, InputStream[] var5, long[] var6) {
      this.a = var5;
   }

   // $FF: synthetic method
   s$c(com.inneractive.api.ads.sdk.s var1, String var2, long var3, InputStream[] var5, long[] var6, byte var7) {
      this(var1, var2, var3, var5, var6);
   }

   public final void close() {
      InputStream[] var3 = this.a;
      int var2 = var3.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         com.inneractive.api.ads.sdk.u.a((Closeable)var3[var1]);
      }

   }
}
