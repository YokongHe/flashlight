package com.flurry.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.text.TextUtils;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public final class fe {
   private static final String a = fe.class.getSimpleName();

   public static long a(InputStream var0, OutputStream var1) {
      byte[] var5 = new byte[1024];
      long var3 = 0L;

      while(true) {
         int var2 = var0.read(var5);
         if(var2 < 0) {
            return var3;
         }

         var1.write(var5, 0, var2);
         var3 += (long)var2;
      }
   }

   public static String a(String var0) {
      return a(var0, 255);
   }

   public static String a(String var0, int var1) {
      String var2;
      if(var0 == null) {
         var2 = "";
      } else {
         var2 = var0;
         if(var0.length() > var1) {
            return var0.substring(0, var1);
         }
      }

      return var2;
   }

   public static String a(byte[] var0) {
      StringBuilder var5 = new StringBuilder(var0.length * 2);
      char[] var6 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      int var2 = var0.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         byte var3 = var0[var1];
         byte var4 = (byte)(var3 & 15);
         var5.append(var6[(byte)((var3 & 240) >> 4)]);
         var5.append(var6[var4]);
      }

      return var5.toString();
   }

   public static void a(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (Throwable var1) {
            return;
         }
      }

   }

   public static boolean a(long var0) {
      boolean var2 = false;
      if(var0 == 0L || System.currentTimeMillis() <= var0) {
         var2 = true;
      }

      return var2;
   }

   public static boolean a(Intent var0) {
      return do.a().c().queryIntentActivities(var0, 65536).size() > 0;
   }

   public static String b(String var0) {
      try {
         String var1 = URLEncoder.encode(var0, "UTF-8");
         return var1;
      } catch (UnsupportedEncodingException var2) {
         eo.a(5, a, "Cannot encode \'" + var0 + "\'");
         return "";
      }
   }

   public static boolean b(Intent var0) {
      boolean var1 = false;
      if(var0 != null) {
         ComponentName var2 = var0.resolveActivity(do.a().c());
         var1 = do.a().b().getPackageName().equals(var2.getPackageName());
      }

      return var1;
   }

   public static String c(String var0) {
      try {
         String var1 = URLDecoder.decode(var0, "UTF-8");
         return var1;
      } catch (UnsupportedEncodingException var2) {
         eo.a(5, a, "Cannot decode \'" + var0 + "\'");
         return "";
      }
   }

   public static byte[] d(String var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance("SHA-1");
         var1.update(var0.getBytes(), 0, var0.length());
         byte[] var3 = var1.digest();
         return var3;
      } catch (NoSuchAlgorithmException var2) {
         eo.a(6, a, "Unsupported SHA1: " + var2.getMessage());
         return null;
      }
   }

   public static String e(String var0) {
      return var0.replace("\'", "\\\'").replace("\\n", "").replace("\\r", "").replace("\\t", "");
   }

   public static Map f(String var0) {
      HashMap var3 = new HashMap();
      if(!TextUtils.isEmpty(var0)) {
         String[] var5 = var0.split("&");
         int var2 = var5.length;

         for(int var1 = 0; var1 < var2; ++var1) {
            String[] var4 = var5[var1].split("=");
            if(!var4[0].equals("event")) {
               var3.put(c(var4[0]), c(var4[1]));
            }
         }
      }

      return var3;
   }

   public static long g(String var0) {
      long var5;
      if(var0 == null) {
         var5 = 0L;
      } else {
         int var2 = var0.length();
         long var3 = 1125899906842597L;
         int var1 = 0;

         while(true) {
            var5 = var3;
            if(var1 >= var2) {
               break;
            }

            var5 = (long)var0.charAt(var1);
            ++var1;
            var3 = var5 + var3 * 31L;
         }
      }

      return var5;
   }
}
