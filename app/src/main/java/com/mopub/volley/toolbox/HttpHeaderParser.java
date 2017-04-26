package com.mopub.volley.toolbox;

import com.mopub.volley.Cache$Entry;
import com.mopub.volley.NetworkResponse;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser {
   public static Cache$Entry parseCacheHeaders(NetworkResponse var0) {
      boolean var1 = false;
      long var8 = 0L;
      long var10 = System.currentTimeMillis();
      Map var12 = var0.headers;
      String var13 = (String)var12.get("Date");
      long var4;
      if(var13 != null) {
         var4 = parseDateAsEpoch(var13);
      } else {
         var4 = 0L;
      }

      var13 = (String)var12.get("Cache-Control");
      long var2;
      long var6;
      if(var13 == null) {
         var2 = 0L;
      } else {
         String[] var17 = var13.split(",");
         int var16 = 0;
         var2 = 0L;

         while(true) {
            if(var16 >= var17.length) {
               var1 = true;
               break;
            }

            String var14 = var17[var16].trim();
            if(var14.equals("no-cache") || var14.equals("no-store")) {
               return null;
            }

            if(var14.startsWith("max-age=")) {
               label57: {
                  try {
                     var6 = Long.parseLong(var14.substring(8));
                  } catch (Exception var15) {
                     break label57;
                  }

                  var2 = var6;
               }
            } else if(var14.equals("must-revalidate") || var14.equals("proxy-revalidate")) {
               var2 = 0L;
            }

            ++var16;
         }
      }

      var13 = (String)var12.get("Expires");
      if(var13 != null) {
         var6 = parseDateAsEpoch(var13);
      } else {
         var6 = 0L;
      }

      var13 = (String)var12.get("ETag");
      if(var1) {
         var2 = 1000L * var2 + var10;
      } else {
         var2 = var8;
         if(var4 > 0L) {
            var2 = var8;
            if(var6 >= var4) {
               var2 = var6 - var4 + var10;
            }
         }
      }

      Cache$Entry var18 = new Cache$Entry();
      var18.data = var0.data;
      var18.etag = var13;
      var18.softTtl = var2;
      var18.ttl = var18.softTtl;
      var18.serverDate = var4;
      var18.responseHeaders = var12;
      return var18;
   }

   public static String parseCharset(Map var0) {
      String var3 = (String)var0.get("Content-Type");
      if(var3 != null) {
         String[] var4 = var3.split(";");

         for(int var1 = 1; var1 < var4.length; ++var1) {
            String[] var2 = var4[var1].trim().split("=");
            if(var2.length == 2 && var2[0].equals("charset")) {
               return var2[1];
            }
         }
      }

      return "ISO-8859-1";
   }

   public static long parseDateAsEpoch(String var0) {
      try {
         long var1 = DateUtils.parseDate(var0).getTime();
         return var1;
      } catch (DateParseException var3) {
         return 0L;
      }
   }
}
