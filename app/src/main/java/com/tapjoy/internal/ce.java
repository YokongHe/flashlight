package com.tapjoy.internal;

import java.lang.ref.WeakReference;

public final class ce {
   public WeakReference a;

   public final Object a() {
      WeakReference var1 = this.a;
      return var1 != null?var1.get():null;
   }

   public final void a(Object var1) {
      this.a = new WeakReference(var1);
   }
}
