package org.a.a;

import java.util.HashMap;
import java.util.Map;

public final class f {
   private final Class a;
   private org.a.a.g.i b;
   private Map c;
   private Map d;
   private Map e;

   public f(Class var1) {
      this(var1, (org.a.a.g.i)null);
   }

   private f(Class var1, org.a.a.g.i var2) {
      this.a = var1;
      this.b = null;
      this.c = new HashMap();
      this.d = new HashMap();
      this.e = new HashMap();
   }

   public final Class a(String var1) {
      return (Class)this.c.get(var1);
   }

   public final org.a.a.g.i a() {
      return this.b;
   }

   public final Class b() {
      return this.a;
   }

   public final Class b(String var1) {
      return (Class)this.d.get(var1);
   }

   public final Class c(String var1) {
      return (Class)this.e.get(var1);
   }

   public final String toString() {
      return "TypeDescription for " + this.a + " (tag=\'" + this.b + "\')";
   }
}
