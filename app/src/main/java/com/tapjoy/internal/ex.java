package com.tapjoy.internal;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

class ex {
   private static final String a;
   private static final char[] b;
   private static final MessageDigest c;
   private static final MessageDigest d;

   static {
      String var0;
      Object var1;
      MessageDigest var4;
      label26: {
         var1 = null;
         a = ex.class.getSimpleName();
         b = "0123456789abcdef".toCharArray();
         if(!com.a.a.a.a.a()) {
            var0 = a;

            try {
               var4 = MessageDigest.getInstance("SHA1");
               break label26;
            } catch (NoSuchAlgorithmException var3) {
               var0 = a;
            }
         }

         var4 = null;
      }

      d = var4;
      var4 = (MessageDigest)var1;
      if(!com.a.a.a.a.a()) {
         var0 = a;

         try {
            var4 = MessageDigest.getInstance("MD5");
         } catch (NoSuchAlgorithmException var2) {
            var0 = a;
            var4 = (MessageDigest)var1;
         }
      }

      c = var4;
   }

   static String a() {
      String var0 = a;
      return com.a.a.a.a.a()?com.a.a.a.a.b():UUID.randomUUID().toString().toLowerCase(Locale.US).replaceAll("-", "");
   }

   static String a(String var0) {
      if(com.a.a.a.a.a()) {
         return com.a.a.a.a.d(var0);
      } else {
         try {
            var0 = URLEncoder.encode(var0, "UTF-8");
            return var0;
         } catch (UnsupportedEncodingException var1) {
            Log.e(a, "Failed url encoding", var1);
            return null;
         }
      }
   }

   static String a(String var0, String var1) {
      if(com.a.a.a.a.a()) {
         return com.a.a.a.a.a(var0, var1);
      } else {
         String var8 = var0.length() + "&";
         byte[] var9 = new byte[var0.length() + var8.length()];
         int var6 = var1.length();
         int var4 = 0;
         int var2 = 0;

         int var3;
         int var5;
         byte var7;
         for(var3 = 0; var4 < var8.length(); ++var2) {
            var7 = (byte)var8.charAt(var4);
            var5 = var3 + 1;
            var9[var2] = (byte)((byte)var1.charAt(var3) & 10 ^ var7);
            if(var5 >= var6) {
               var3 = 0;
            } else {
               var3 = var5;
            }

            ++var4;
         }

         var4 = 0;
         var5 = var3;

         for(var3 = var2; var4 < var0.length(); var5 = var2) {
            var7 = (byte)var0.charAt(var4);
            var2 = var5 + 1;
            var9[var3] = (byte)((byte)var1.charAt(var5) & 10 ^ var7);
            if(var2 >= var6) {
               var2 = 0;
            }

            ++var4;
            ++var3;
         }

         return a(var9);
      }
   }

   static String a(List var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var4 = var0.iterator();

      while(var4.hasNext()) {
         String var3 = (String)var4.next();
         if(!var3.isEmpty()) {
            if(var2.length() > 0) {
               var2.append(var1);
            }

            var2.append(var3);
         }
      }

      return var2.toString();
   }

   private static String a(byte[] var0) {
      char[] var3 = new char[var0.length * 2];

      for(int var1 = 0; var1 < var0.length; ++var1) {
         int var2 = var0[var1] & 255;
         var3[var1 * 2] = b[var2 >>> 4];
         var3[var1 * 2 + 1] = b[var2 & 15];
      }

      return new String(var3);
   }

   static String b(String var0) {
      if(var0 != null && !var0.isEmpty()) {
         if(com.a.a.a.a.a()) {
            return com.a.a.a.a.b(var0);
         } else if(c != null) {
            MessageDigest var1 = c;
            synchronized(var1) {
               c.update(var0.getBytes());
               byte[] var3 = c.digest();
               c.reset();
               var0 = a(var3);
               return var0;
            }
         } else {
            return "";
         }
      } else {
         return "";
      }
   }

   static List b(String var0, String var1) {
      ArrayList var3 = new ArrayList();

      while(true) {
         int var2 = var0.indexOf(var1);
         if(var2 == -1) {
            if(!var0.isEmpty()) {
               var3.add(var0);
            }

            return var3;
         }

         if(var2 > 1) {
            var3.add(var0.substring(0, var2));
         }

         var0 = var0.substring(var2 + var1.length());
      }
   }

   static String c(String var0) {
      if(var0 != null && !var0.isEmpty()) {
         if(com.a.a.a.a.a()) {
            return com.a.a.a.a.c(var0);
         } else if(d != null) {
            MessageDigest var1 = d;
            synchronized(var1) {
               d.update(var0.getBytes());
               byte[] var3 = d.digest();
               d.reset();
               var0 = a(var3);
               return var0;
            }
         } else {
            return "";
         }
      } else {
         return "";
      }
   }

   static Map d(String var0) {
      LinkedHashMap var2 = new LinkedHashMap();
      Iterator var5 = b(var0, "&").iterator();

      while(var5.hasNext()) {
         String var3 = (String)var5.next();
         int var1 = var3.indexOf("=");

         try {
            var2.put(URLDecoder.decode(var3.substring(0, var1), "UTF-8"), URLDecoder.decode(var3.substring(var1 + 1), "UTF-8"));
         } catch (UnsupportedEncodingException var4) {
            var3 = a;
         }
      }

      return var2;
   }
}
