package com.ihs.app.a;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class a {
   public static void a(String var0, Map var1, Map var2) {
      if(com.ihs.a.e.f.a()) {
         (new StringBuilder("logEvent: eventID = ")).append(var0).toString();
         Iterator var3 = var1.entrySet().iterator();

         Entry var4;
         while(var3.hasNext()) {
            var4 = (Entry)var3.next();
            (new StringBuilder("\t\tkey = ")).append((String)var4.getKey()).append(", value = ").append((String)var4.getValue()).toString();
         }

         if(var2 != null) {
            var3 = var2.entrySet().iterator();

            while(var3.hasNext()) {
               var4 = (Entry)var3.next();
               (new StringBuilder("\t\tkey = ")).append((String)var4.getKey()).append(", value = ").append((String)var4.getValue()).toString();
            }
         }
      }

   }
}
