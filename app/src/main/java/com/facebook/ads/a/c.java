package com.facebook.ads.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class c {
   private static List a = new ArrayList();

   public static String a() {
      List var0 = a;
      ArrayList var1;
      synchronized(var0) {
         if(a.isEmpty()) {
            return "";
         }

         var1 = new ArrayList(a);
         a.clear();
      }

      JSONArray var3 = new JSONArray();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         var3.put(((com.facebook.ads.a.b)var4.next()).a());
      }

      return var3.toString();
   }

   public static void a(com.facebook.ads.a.b var0) {
      List var1 = a;
      synchronized(var1) {
         a.add(var0);
      }
   }
}
