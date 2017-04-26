package com.mopub.common.util;

import java.io.File;

public class Files {
   public static File createDirectory(String var0) {
      if(var0 != null) {
         File var1 = new File(var0);
         if(var1.exists() && var1.isDirectory() || var1.mkdirs() && var1.isDirectory()) {
            return var1;
         }
      }

      return null;
   }

   public static int intLength(File var0) {
      if(var0 == null) {
         return 0;
      } else {
         long var1 = var0.length();
         return var1 < 2147483647L?(int)var1:Integer.MAX_VALUE;
      }
   }
}
