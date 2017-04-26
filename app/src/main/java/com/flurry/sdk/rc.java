package com.flurry.sdk;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class rc extends LinkedHashMap {
   protected final int a;

   public rc(int var1, int var2) {
      super(var1, 0.8F, true);
      this.a = var2;
   }

   protected boolean removeEldestEntry(Entry var1) {
      return this.size() > this.a;
   }
}
