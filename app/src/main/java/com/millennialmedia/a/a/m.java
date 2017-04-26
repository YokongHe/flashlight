package com.millennialmedia.a.a;

import java.util.Set;

public final class m extends j {
   private final b.j a = new b.j();

   public final void a(String var1, j var2) {
      Object var3 = var2;
      if(var2 == null) {
         var3 = l.a;
      }

      this.a.put(var1, var3);
   }

   public final boolean equals(Object var1) {
      return var1 == this || var1 instanceof m && ((m)var1).a.equals(this.a);
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final Set n() {
      return this.a.entrySet();
   }
}
