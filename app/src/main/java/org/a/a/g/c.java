package org.a.a.g;

import java.util.Iterator;
import java.util.List;

public final class c extends b {
   private List d;
   private boolean e = false;

   public c(org.a.a.g.i var1, boolean var2, List var3, org.a.a.c.a var4, org.a.a.c.a var5, Boolean var6) {
      super(var1, var4, (org.a.a.c.a)null, var6);
      if(var3 == null) {
         throw new NullPointerException("value in a Node is required.");
      } else {
         this.d = var3;
         this.b = var2;
      }
   }

   public final org.a.a.g.e a() {
      return org.a.a.g.e.c;
   }

   public final void a(Class var1) {
      Iterator var2 = this.d.iterator();

      while(var2.hasNext()) {
         ((org.a.a.g.f)var2.next()).a().b(var1);
      }

   }

   public final void a(Class var1, Class var2) {
      Iterator var3 = this.d.iterator();

      while(var3.hasNext()) {
         org.a.a.g.f var4 = (org.a.a.g.f)var3.next();
         var4.b().b(var2);
         var4.a().b(var1);
      }

   }

   public final void a(List var1) {
      this.d = var1;
   }

   public final void a(boolean var1) {
      this.e = true;
   }

   public final List b() {
      return this.d;
   }

   public final boolean c() {
      return this.e;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder();

      for(Iterator var2 = this.d.iterator(); var2.hasNext(); var1.append(" }")) {
         org.a.a.g.f var3 = (org.a.a.g.f)var2.next();
         var1.append("{ key=");
         var1.append(var3.a());
         var1.append("; value=");
         if(var3.b() instanceof b) {
            var1.append(System.identityHashCode(var3.b()));
         } else {
            var1.append(var3.toString());
         }
      }

      String var4 = var1.toString();
      return "<" + this.getClass().getName() + " (tag=" + this.d() + ", values=" + var4 + ")>";
   }
}
