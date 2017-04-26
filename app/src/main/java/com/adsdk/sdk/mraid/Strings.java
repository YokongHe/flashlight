package com.adsdk.sdk.mraid;

import java.io.InputStream;

public class Strings {
   public static String fromStream(InputStream var0) {
      StringBuffer var2 = new StringBuffer();
      byte[] var3 = new byte[4096];

      for(int var1 = 0; var1 != -1; var1 = var0.read(var3)) {
         var2.append(new String(var3, 0, var1));
      }

      var0.close();
      return var2.toString();
   }

   public static boolean isEmpty(String var0) {
      return var0 != null && var0.length() == 0;
   }
}
