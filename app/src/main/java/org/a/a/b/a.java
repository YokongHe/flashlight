package org.a.a.b;

public abstract class a implements org.a.a.b.d {
   public final void a(org.a.a.g.d var1, Object var2) {
      if(var1.h()) {
         throw new IllegalStateException("Not Implemented in " + this.getClass().getName());
      } else {
         throw new org.a.a.c.c("Unexpected recursive structure for Node: " + var1);
      }
   }
}
