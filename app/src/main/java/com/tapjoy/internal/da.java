package com.tapjoy.internal;

import java.util.HashSet;
import java.util.Iterator;

public final class da {
   public static HashSet a(Iterator var0) {
      HashSet var1 = new HashSet();

      while(var0.hasNext()) {
         var1.add(var0.next());
      }

      return var1;
   }
}
