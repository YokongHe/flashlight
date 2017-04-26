package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.ResponseHeader;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class HttpResponses {
   public static boolean extractBooleanHeader(HttpResponse var0, ResponseHeader var1, boolean var2) {
      String var3 = extractHeader(var0, var1);
      return var3 == null?var2:var3.equals("1");
   }

   public static String extractHeader(HttpResponse var0, ResponseHeader var1) {
      Header var2 = var0.getFirstHeader(var1.getKey());
      return var2 != null?var2.getValue():null;
   }

   public static int extractIntHeader(HttpResponse var0, ResponseHeader var1, int var2) {
      Integer var3 = extractIntegerHeader(var0, var1);
      return var3 == null?var2:var3.intValue();
   }

   public static Integer extractIntegerHeader(HttpResponse var0, ResponseHeader var1) {
      NumberFormat var3 = NumberFormat.getInstance(Locale.US);
      var3.setParseIntegerOnly(true);
      String var5 = extractHeader(var0, var1);

      int var2;
      try {
         var2 = var3.parse(var5.trim()).intValue();
      } catch (Exception var4) {
         return null;
      }

      return Integer.valueOf(var2);
   }
}
