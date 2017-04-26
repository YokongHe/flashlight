package com.tapjoy.internal;

import com.tapjoy.internal.he;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class ha implements Iterable {
   private final List a = new LinkedList();
   private final Map b = new HashMap();

   public final he a(String var1) {
      if(var1 == null) {
         return null;
      } else {
         var1 = var1.toLowerCase(Locale.US);
         List var2 = (List)this.b.get(var1);
         return var2 != null && !var2.isEmpty()?(he)var2.get(0):null;
      }
   }

   public final void a(he var1) {
      if(var1 != null) {
         String var4 = var1.a.toLowerCase(Locale.US);
         List var3 = (List)this.b.get(var4);
         Object var2 = var3;
         if(var3 == null) {
            var2 = new LinkedList();
            this.b.put(var4, var2);
         }

         ((List)var2).add(var1);
         this.a.add(var1);
      }
   }

   public final Iterator iterator() {
      return Collections.unmodifiableList(this.a).iterator();
   }

   public final String toString() {
      return this.a.toString();
   }
}
