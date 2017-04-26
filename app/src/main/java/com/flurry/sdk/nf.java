package com.flurry.sdk;

public final class nf {
   protected final Class a;
   protected final int b;
   protected String c;

   public nf(Class var1, String var2) {
      this.a = var1;
      this.b = var1.getName().hashCode();
      this.a(var2);
   }

   public final Class a() {
      return this.a;
   }

   public final void a(String var1) {
      String var2;
      label11: {
         if(var1 != null) {
            var2 = var1;
            if(var1.length() != 0) {
               break label11;
            }
         }

         var2 = null;
      }

      this.c = var2;
   }

   public final String b() {
      return this.c;
   }

   public final boolean c() {
      return this.c != null;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         if(this.a != ((nf)var1).a) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.b;
   }

   public final String toString() {
      StringBuilder var2 = (new StringBuilder("[NamedType, class ")).append(this.a.getName()).append(", name: ");
      String var1;
      if(this.c == null) {
         var1 = "null";
      } else {
         var1 = "\'" + this.c + "\'";
      }

      return var2.append(var1).append("]").toString();
   }
}
