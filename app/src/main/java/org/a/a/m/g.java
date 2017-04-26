package org.a.a.m;

import java.util.List;

public final class g extends org.a.a.m.u {
   private final String a;
   private final List b;

   public g(String var1, List var2, org.a.a.c.a var3, org.a.a.c.a var4) {
      super(var3, var4);
      this.a = var1;
      if(var2 != null && var2.size() != 2) {
         throw new org.a.a.c.c("Two strings must be provided instead of " + String.valueOf(var2.size()));
      } else {
         this.b = var2;
      }
   }

   public final String a() {
      return this.a;
   }

   protected final String b() {
      return this.b != null?"name=" + this.a + ", value=[" + this.b.get(0) + ", " + this.b.get(1) + "]":"name=" + this.a;
   }

   public final org.a.a.m.v c() {
      return org.a.a.m.v.g;
   }

   public final List d() {
      return this.b;
   }
}
