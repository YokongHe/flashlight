package com.tapjoy;

import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class HmacSignature {
   private String a;
   private String b;

   public HmacSignature(String var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   private static String a(Map var0) {
      TreeSet var2 = new TreeSet(var0.keySet());
      StringBuilder var1 = new StringBuilder();
      Iterator var5 = var2.iterator();

      while(var5.hasNext()) {
         String var3 = (String)var5.next();
         String var4 = (String)var0.get(var3);
         var1.append(var3 + "=" + var4 + "&");
      }

      var1.deleteCharAt(var1.lastIndexOf("&"));
      Log.v("HmacSignature", "Unhashed String: " + var1.toString());
      return var1.toString();
   }

   public boolean matches(String var1, Map var2, String var3) {
      return this.sign(var1, var2).equals(var3);
   }

   public String sign(String param1, Map param2) {
      // $FF: Couldn't be decompiled
   }
}
