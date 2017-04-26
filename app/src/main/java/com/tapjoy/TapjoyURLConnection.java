package com.tapjoy;

import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class TapjoyURLConnection {
   public static final int TYPE_GET = 0;
   public static final int TYPE_POST = 1;

   public String getContentLength(String var1) {
      try {
         var1 = var1.replaceAll(" ", "%20");
         TapjoyLog.i("TapjoyURLConnection", "requestURL: " + var1);
         HttpURLConnection var3 = (HttpURLConnection)(new URL(var1)).openConnection();
         var3.setConnectTimeout(15000);
         var3.setReadTimeout(30000);
         var1 = var3.getHeaderField("content-length");
      } catch (Exception var2) {
         TapjoyLog.e("TapjoyURLConnection", "Exception: " + var2.toString());
         var1 = null;
      }

      TapjoyLog.i("TapjoyURLConnection", "content-length: " + var1);
      return var1;
   }

   public TapjoyHttpURLResponse getRedirectFromURL(String var1) {
      return this.getResponseFromURL(var1, "", 0, true, (Map)null, (String)null, (String)null);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1) {
      return this.getResponseFromURL(var1, (String)"", 0);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, String var2) {
      return this.getResponseFromURL(var1, (String)var2, 0);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, String var2, int var3) {
      return this.getResponseFromURL(var1, var2, var3, false, (Map)null, (String)null, (String)null);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String param1, String param2, int param3, boolean param4, Map param5, String param6, String param7) {
      // $FF: Couldn't be decompiled
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, Map var2) {
      return this.getResponseFromURL(var1, (String)TapjoyUtil.convertURLParams(var2, false), 0);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, Map var2, int var3) {
      return this.getResponseFromURL(var1, TapjoyUtil.convertURLParams(var2, false), var3);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, Map var2, Map var3, String var4) {
      String var5;
      if(var2 != null) {
         var5 = TapjoyUtil.convertURLParams(var2, false);
      } else {
         var5 = "";
      }

      return this.getResponseFromURL(var1, var5, 1, false, var3, "application/json;charset=utf-8", var4);
   }

   public TapjoyHttpURLResponse getResponseFromURL(String var1, Map var2, Map var3, Map var4) {
      String var5;
      if(var2 != null) {
         var5 = TapjoyUtil.convertURLParams(var2, false);
      } else {
         var5 = "";
      }

      return this.getResponseFromURL(var1, var5, 1, false, var3, "application/x-www-form-urlencoded", TapjoyUtil.convertURLParams(var4, false));
   }
}
