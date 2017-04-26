package com.tapjoy.internal;

import com.tapjoy.internal.dc;
import com.tapjoy.internal.dd;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public final class bm {
   public static String a(File var0) {
      try {
         String var2 = a(var0, com.tapjoy.internal.aq.c);
         return var2;
      } catch (IOException var1) {
         return null;
      }
   }

   public static String a(File var0, Charset var1) {
      FileInputStream var4 = new FileInputStream(var0);

      String var5;
      try {
         var5 = dc.a(new InputStreamReader(var4, var1));
      } finally {
         dd.a(var4);
      }

      return var5;
   }

   public static void a(File var0, String var1) {
      FileOutputStream var4 = new FileOutputStream(var0);

      try {
         a((OutputStream)var4, (String)var1);
      } finally {
         dd.a(var4);
      }

   }

   public static void a(OutputStream var0, String var1) {
      OutputStreamWriter var2 = new OutputStreamWriter(var0, com.tapjoy.internal.aq.c);
      var2.write(var1);
      var2.flush();
   }
}
