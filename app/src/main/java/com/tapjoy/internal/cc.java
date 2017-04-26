package com.tapjoy.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class cc extends WeakReference {
   private final Object a;

   public cc(Object var1, Object var2, ReferenceQueue var3) {
      super(var2, var3);
      this.a = var1;
   }

   public final Object a() {
      return this.a;
   }
}
