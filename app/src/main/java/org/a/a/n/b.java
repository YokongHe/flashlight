package org.a.a.n;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

public abstract class b {
   private static final CharsetDecoder a;
   private static final org.a.a.e.b.a.a.a.a.a.a b;

   static {
      a = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT);
      b = new org.a.a.e.b.a.a.a.a.a.b("-_.!~*\'()@:$&,;=[]/", false);
   }

   public static String a(String var0) {
      return b.a(var0);
   }

   public static String a(ByteBuffer var0) {
      return a.decode(var0).toString();
   }

   public static String b(String var0) {
      try {
         var0 = URLDecoder.decode(var0, "UTF-8");
         return var0;
      } catch (UnsupportedEncodingException var1) {
         throw new org.a.a.c.c(var1);
      }
   }
}
