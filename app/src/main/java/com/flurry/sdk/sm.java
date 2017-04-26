package com.flurry.sdk;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class sm extends LinkedHashMap {
   public static final sm a = new sm();

   private sm() {
      super(192, 0.8F, true);
   }

   public final String a(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected final boolean removeEldestEntry(Entry var1) {
      return this.size() > 192;
   }
}
