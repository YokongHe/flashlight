package com.smaato.soma.internal.utilities;

import com.smaato.soma.exception.UTF8EncodingFailedException;
import java.net.URLEncoder;

public class StringFormatter {
   private static final String UTF8 = "UTF-8";

   public static String stringToUTF8(String var0) {
      try {
         var0 = URLEncoder.encode(var0, "UTF-8");
         return var0;
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UTF8EncodingFailedException(var2);
      }
   }
}
