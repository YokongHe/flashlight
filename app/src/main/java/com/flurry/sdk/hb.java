package com.flurry.sdk;

import com.flurry.sdk.ha;

public final class hb {
   public static final ha a = new ha("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
   public static final ha b;
   public static final ha c;
   public static final ha d;

   static {
      b = new ha(a, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
      c = new ha(a, "PEM", true, '=', 64);
      StringBuffer var0 = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
      var0.setCharAt(var0.indexOf("+"), '-');
      var0.setCharAt(var0.indexOf("/"), '_');
      d = new ha("MODIFIED-FOR-URL", var0.toString(), false, '\u0000', Integer.MAX_VALUE);
   }

   public static ha a() {
      return b;
   }
}
