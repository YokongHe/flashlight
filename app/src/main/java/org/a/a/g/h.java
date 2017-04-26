package org.a.a.g;

import java.util.Iterator;
import java.util.List;

public final class h extends org.a.a.g.b {
   private final List d;

   public h(org.a.a.g.i var1, boolean var2, List var3, org.a.a.c.a var4, org.a.a.c.a var5, Boolean var6) {
      super(var1, var4, (org.a.a.c.a)null, var6);
      if(var3 == null) {
         throw new NullPointerException("value in a Node is required.");
      } else {
         this.d = var3;
         this.b = var2;
      }
   }

   public final org.a.a.g.e a() {
      return org.a.a.g.e.b;
   }

   public final void a(Class var1) {
      Iterator var2 = this.d.iterator();

      while(var2.hasNext()) {
         ((org.a.a.g.d)var2.next()).b(var1);
      }

   }

   public final List b() {
      return this.d;
   }

   public final String toString() {
      return "<" + this.getClass().getName() + " (tag=" + this.d() + ", value=" + this.d + ")>";
   }
}
