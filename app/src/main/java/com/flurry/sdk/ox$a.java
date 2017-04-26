package com.flurry.sdk;

import com.flurry.sdk.sh;

public final class ox$a {
   protected int a;
   protected Class b;
   protected sh c;
   protected boolean d;

   public ox$a(sh var1, boolean var2) {
      this.c = var1;
      this.b = null;
      this.d = var2;
      this.a = a(var1, var2);
   }

   public ox$a(Class var1, boolean var2) {
      this.b = var1;
      this.c = null;
      this.d = var2;
      this.a = a(var1, var2);
   }

   private static final int a(sh var0, boolean var1) {
      int var3 = var0.hashCode() - 1;
      int var2 = var3;
      if(var1) {
         var2 = var3 - 1;
      }

      return var2;
   }

   private static final int a(Class var0, boolean var1) {
      int var3 = var0.getName().hashCode();
      int var2 = var3;
      if(var1) {
         var2 = var3 + 1;
      }

      return var2;
   }

   public final void a(sh var1) {
      this.c = var1;
      this.b = null;
      this.d = true;
      this.a = a(var1, true);
   }

   public final void a(Class var1) {
      this.c = null;
      this.b = var1;
      this.d = true;
      this.a = a(var1, true);
   }

   public final void b(sh var1) {
      this.c = var1;
      this.b = null;
      this.d = false;
      this.a = a(var1, false);
   }

   public final void b(Class var1) {
      this.c = null;
      this.b = var1;
      this.d = false;
      this.a = a(var1, false);
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         ox$a var2 = (ox$a)var1;
         if(var2.d != this.d) {
            return false;
         }

         if(this.b == null) {
            return this.c.equals(var2.c);
         }

         if(var2.b != this.b) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.a;
   }

   public final String toString() {
      return this.b != null?"{class: " + this.b.getName() + ", typed? " + this.d + "}":"{type: " + this.c + ", typed? " + this.d + "}";
   }
}
