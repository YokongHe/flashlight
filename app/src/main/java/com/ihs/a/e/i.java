package com.ihs.a.e;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;

public final class i {
   private static InputStream a(byte[] param0) {
      // $FF: Couldn't be decompiled
   }

   public static Map a(File var0) {
      if(var0 != null && var0.exists()) {
         FileInputStream var1;
         try {
            var1 = new FileInputStream(var0);
         } catch (FileNotFoundException var2) {
            var2.printStackTrace();
            return null;
         }

         return a(var1, a(var0.getName()));
      } else {
         return null;
      }
   }

   public static Map a(InputStream var0, boolean var1) {
      InputStream var2 = var0;
      if(var1) {
         try {
            var2 = a(a(var0));
         } catch (UnsupportedEncodingException var4) {
            var4.printStackTrace();
            return null;
         }
      }

      if(var2 == null) {
         return null;
      } else {
         Map var5;
         try {
            var5 = (Map)b(var2);
         } catch (Exception var3) {
            var3.printStackTrace();
            var5 = null;
         }

         return var5;
      }
   }

   public static boolean a(String var0) {
      return !TextUtils.isEmpty(var0) && !var0.endsWith(".plist");
   }

   private static byte[] a(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   private static Object b(InputStream var0) {
      try {
         SAXParser var1 = SAXParserFactory.newInstance().newSAXParser();
         com.ihs.a.e.k var2 = new com.ihs.a.e.k();
         var1.parse(new InputSource(new BufferedReader(new InputStreamReader(var0), 8192)), var2);
         Object var4 = var2.a;
         return var4;
      } catch (Exception var3) {
         throw var3;
      }
   }
}
