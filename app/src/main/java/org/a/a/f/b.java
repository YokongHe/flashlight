package org.a.a.f;

import java.lang.reflect.Field;

public final class b extends org.a.a.f.c {
   private final Field a;

   public b(Field var1) {
      super(var1.getName(), var1.getType(), var1.getGenericType());
      this.a = var1;
      var1.setAccessible(true);
   }

   public final void a(Object var1, Object var2) {
      this.a.set(var1, var2);
   }
}
