package org.a.a.f;

public abstract class d implements Comparable {
   private final String a;
   private final Class b;

   public d(String var1, Class var2) {
      this.a = var1;
      this.b = var2;
   }

   public static boolean c() {
      return true;
   }

   public abstract void a(Object var1, Object var2);

   public abstract Class[] a();

   public final Class b() {
      return this.b;
   }

   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1 instanceof d) {
         d var4 = (d)var1;
         var2 = var3;
         if(this.a.equals(var4.a)) {
            var2 = var3;
            if(this.b.equals(var4.b)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public int hashCode() {
      return this.a.hashCode() + this.b.hashCode();
   }

   public String toString() {
      return this.a + " of " + this.b;
   }
}
