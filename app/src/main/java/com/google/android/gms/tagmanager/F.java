package com.google.android.gms.tagmanager;

import java.util.Collections;
import java.util.Map;

public final class F {
   private final Map a;
   private final com.google.android.gms.internal.bj b;

   public final Map a() {
      return Collections.unmodifiableMap(this.a);
   }

   public final void a(String var1, com.google.android.gms.internal.bj var2) {
      this.a.put(var1, var2);
   }

   public final com.google.android.gms.internal.bj b() {
      return this.b;
   }

   public final String toString() {
      return "Properties: " + Collections.unmodifiableMap(this.a) + " pushAfterEvaluate: " + this.b;
   }
}
