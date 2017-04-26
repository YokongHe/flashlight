package com.tapjoy.internal;

import java.lang.ref.ReferenceQueue;

public final class cd extends ReferenceQueue {
   public final com.tapjoy.internal.cc a() {
      return (com.tapjoy.internal.cc)super.poll();
   }

   public final com.tapjoy.internal.cc a(Object var1, Object var2) {
      return new com.tapjoy.internal.cc(var1, var2, this);
   }
}
