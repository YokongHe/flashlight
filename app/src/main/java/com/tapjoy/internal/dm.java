package com.tapjoy.internal;

import com.tapjoy.internal.dm$a;
import java.nio.ByteBuffer;

public final class dm {
   public static final byte[] a;
   public static final ByteBuffer b;

   static {
      byte[] var0 = new byte[0];
      a = var0;
      b = ByteBuffer.wrap(var0);
   }

   public static int a(long var0) {
      return (int)(var0 >>> 32 ^ var0);
   }

   public static int a(dm$a var0) {
      return var0.a();
   }

   public static int a(boolean var0) {
      return var0?1231:1237;
   }
}
