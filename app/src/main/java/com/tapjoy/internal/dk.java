package com.tapjoy.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class dk {
   private static volatile boolean a = false;
   private static final dk c = new dk((byte)0);
   private final Map b;

   dk() {
      this.b = new HashMap();
   }

   private dk(byte var1) {
      this.b = Collections.emptyMap();
   }

   public static dk a() {
      return c;
   }
}
