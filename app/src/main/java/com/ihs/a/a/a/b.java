package com.ihs.a.a.a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

final class b {
   private static volatile boolean a = false;

   @SuppressLint({"InlinedApi", "TrulyRandom", "NewApi"})
   private static String a(String var0, byte[] var1) {
      try {
         Cipher var2 = Cipher.getInstance("AES/ECB/PKCS7Padding");
         var2.init(1, new SecretKeySpec(var0.getBytes("UTF-8"), "AES"));
         byte[] var4 = var2.doFinal(var1);
         if(VERSION.SDK_INT >= 8) {
            return Base64.encodeToString(var4, 0);
         } else {
            var0 = com.ihs.a.e.a.a((byte[])var4, 0);
            return var0;
         }
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   public static void a() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static boolean a(boolean var0) {
      a = false;
      return false;
   }

   private static String b(Map var0) {
      StringBuilder var2 = new StringBuilder();
      StringBuffer var3 = new StringBuffer();
      var3.append("i}96Iu[Kpri/TZp]".subSequence(12, 16));
      var3.append("i}96Iu[Kpri/TZp]".subSequence(4, 8));
      var3.append("i}96Iu[Kpri/TZp]".subSequence(0, 4));
      var3.append("i}96Iu[Kpri/TZp]".subSequence(8, 12));
      String var7 = var3.toString();
      Iterator var6 = var0.entrySet().iterator();
      boolean var1 = true;

      while(var6.hasNext()) {
         Entry var4 = (Entry)var6.next();
         if(var4.getValue() != null && ((String)var4.getValue()).length() != 0) {
            if(var1) {
               var2.append("?");
               var1 = false;
            } else {
               var2.append("&");
            }

            var2.append((String)var4.getKey());
            var2.append("=");

            try {
               var2.append(URLEncoder.encode(a(var7, ((String)var4.getValue()).getBytes()), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      (new StringBuilder("Final Query String: ")).append(var2.toString()).toString();
      return var2.toString();
   }
}
