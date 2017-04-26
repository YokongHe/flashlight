package com.mopub.common.util;

import java.io.InputStream;

public class Strings {
   public static String fromStream(InputStream var0) {
      StringBuilder var2 = new StringBuilder();
      byte[] var3 = new byte[4096];

      for(int var1 = 0; var1 != -1; var1 = var0.read(var3)) {
         var2.append(new String(var3, 0, var1));
      }

      var0.close();
      return var2.toString();
   }
}
