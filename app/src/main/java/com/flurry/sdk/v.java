package com.flurry.sdk;

import com.flurry.sdk.eo;
import com.flurry.sdk.gb;
import com.flurry.sdk.gg;
import com.flurry.sdk.gt;
import com.flurry.sdk.gw;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class v {
   private static final String a = com.flurry.sdk.v.class.getSimpleName();
   private static gg b = new gg();

   public static gw a(byte[] param0, Class param1) {
      // $FF: Couldn't be decompiled
   }

   public static byte[] a(gw param0, Class param1) {
      // $FF: Couldn't be decompiled
   }

   private static gw b(byte[] var0, Class var1) {
      gb var2 = b.a((InputStream)(new ByteArrayInputStream(var0)), (gb)null);

      try {
         gw var5 = (gw)(new gt(var1)).a((Object)null, var2);
         return var5;
      } catch (ClassCastException var3) {
         eo.a(6, a, "ClassCastException in parseAvroBinary:" + var3.getMessage());
         eo.a(3, a, "ClassCastException in parseAvroBinary: bytes = " + var0 + " type = " + var1.getSimpleName());
         return null;
      } catch (IOException var4) {
         eo.a(6, a, "IOException in parseAvroBinary:" + var4.getMessage());
         eo.a(3, a, "IOException in parseAvroBinary: bytes = " + var0 + " type = " + var1.getSimpleName());
         return null;
      }
   }
}
