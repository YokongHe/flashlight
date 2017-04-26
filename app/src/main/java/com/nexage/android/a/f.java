package com.nexage.android.a;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
   public static Boolean a = null;
   private static Pattern b = null;
   private static CookieSyncManager c = null;

   public static StringBuilder a() {
      // $FF: Couldn't be decompiled
   }

   private static void a(StringBuilder var0, String var1, String var2) {
      if(var2 != null && var2.length() > 0) {
         try {
            var0.append("&").append(var1).append("=").append(URLEncoder.encode(var2, "UTF-8"));
         } catch (UnsupportedEncodingException var3) {
            com.nexage.android.a.p.e("HttpUtils", "UTF-8 encoding exception: " + var3);
            return;
         }
      }

   }

   public static void a(HttpURLConnection var0) {
      CookieManager var1 = CookieManager.getInstance();
      var1.removeExpiredCookie();
      String var2 = var1.getCookie(com.nexage.android.b.d());
      if(var2 != null && var2.length() > 0) {
         var0.setRequestProperty("Cookie", var2);
      }

   }

   public static void a(HttpURLConnection var0, String var1) {
      List var2 = null;

      Map var4;
      try {
         var4 = var0.getHeaderFields();
      } catch (Exception var3) {
         var4 = null;
      }

      if(var4 != null) {
         var2 = (List)var4.get("set-cookie");
      }

      if(var2 != null && var2.size() != 0) {
         CookieManager var5 = CookieManager.getInstance();
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            var5.setCookie(com.nexage.android.b.d(), var7);
         }

         c.sync();
      } else {
         com.nexage.android.a.p.a(var1, "Did not receive any COOKIE from the Server");
      }
   }

   public static void b() {
      if(c == null) {
         CookieSyncManager var0 = CookieSyncManager.getInstance();
         c = var0;
         var0.sync();
         CookieManager.getInstance().setAcceptCookie(true);
      }
   }

   private static Pattern c() {
      synchronized(com.nexage.android.a.f.class){}

      Pattern var0;
      try {
         if(b == null) {
            b = Pattern.compile("^\\w+$");
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }
}
