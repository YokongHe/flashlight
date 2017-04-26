package com.tapjoy.internal;

import com.tapjoy.internal.dc;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public abstract class bt$a {
   private static bt$a a;

   public static bt$a a() {
      bt$a var1 = a;
      bt$a var0 = var1;
      if(var1 == null) {
         var0 = com.tapjoy.internal.bu.a;
         a = var0;
      }

      return var0;
   }

   public final com.tapjoy.internal.bt a(InputStream var1) {
      return this.a((Reader)(new InputStreamReader(var1, com.tapjoy.internal.cs.c)));
   }

   public com.tapjoy.internal.bt a(Reader var1) {
      return this.a(dc.a(var1));
   }

   public com.tapjoy.internal.bt a(String var1) {
      return this.a((InputStream)(new ByteArrayInputStream(var1.getBytes(com.tapjoy.internal.cs.c.name()))));
   }
}
