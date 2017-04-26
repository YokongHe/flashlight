package com.mopub.network;

import com.mopub.common.util.ResponseHeader;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public class HeaderUtils {
   public static boolean extractBooleanHeader(Map var0, ResponseHeader var1, boolean var2) {
      return formatBooleanHeader(extractHeader(var0, var1), var2);
   }

   public static boolean extractBooleanHeader(HttpResponse var0, ResponseHeader var1, boolean var2) {
      return formatBooleanHeader(extractHeader(var0, var1), var2);
   }

   public static String extractHeader(Map var0, ResponseHeader var1) {
      return (String)var0.get(var1.getKey());
   }

   public static String extractHeader(HttpResponse var0, ResponseHeader var1) {
      Header var2 = var0.getFirstHeader(var1.getKey());
      return var2 != null?var2.getValue():null;
   }

   public static int extractIntHeader(HttpResponse var0, ResponseHeader var1, int var2) {
      Integer var3 = extractIntegerHeader(var0, var1);
      return var3 == null?var2:var3.intValue();
   }

   public static Integer extractIntegerHeader(Map var0, ResponseHeader var1) {
      return formatIntHeader(extractHeader(var0, var1));
   }

   public static Integer extractIntegerHeader(HttpResponse var0, ResponseHeader var1) {
      return formatIntHeader(extractHeader(var0, var1));
   }

   private static boolean formatBooleanHeader(String var0, boolean var1) {
      return var0 == null?var1:var0.equals("1");
   }

   private static Integer formatIntHeader(String var0) {
      NumberFormat var2 = NumberFormat.getInstance(Locale.US);
      var2.setParseIntegerOnly(true);

      int var1;
      try {
         var1 = var2.parse(var0.trim()).intValue();
      } catch (Exception var3) {
         return null;
      }

      return Integer.valueOf(var1);
   }
}
