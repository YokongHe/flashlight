package com.millennialmedia.a.a.b;

import java.util.Map.Entry;

final class p implements Entry {
   p a;
   p b;
   p c;
   p d;
   p e;
   final Object f;
   final int g;
   Object h;
   int i;

   p() {
      this.f = null;
      this.g = -1;
      this.e = this;
      this.d = this;
   }

   p(p var1, Object var2, int var3, p var4, p var5) {
      this.a = var1;
      this.f = var2;
      this.g = var3;
      this.i = 1;
      this.d = var4;
      this.e = var5;
      var5.d = this;
      var4.e = this;
   }

   public final p a() {
      p var1 = this.b;

      p var2;
      p var3;
      for(var2 = this; var1 != null; var1 = var3) {
         var3 = var1.b;
         var2 = var1;
      }

      return var2;
   }

   public final p b() {
      p var1 = this.c;

      p var2;
      p var3;
      for(var2 = this; var1 != null; var1 = var3) {
         var3 = var1.c;
         var2 = var1;
      }

      return var2;
   }

   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(var1 instanceof Entry) {
         Entry var4 = (Entry)var1;
         if(this.f == null) {
            var2 = var3;
            if(var4.getKey() != null) {
               return var2;
            }
         } else {
            var2 = var3;
            if(!this.f.equals(var4.getKey())) {
               return var2;
            }
         }

         if(this.h == null) {
            var2 = var3;
            if(var4.getValue() != null) {
               return var2;
            }
         } else {
            var2 = var3;
            if(!this.h.equals(var4.getValue())) {
               return var2;
            }
         }

         var2 = true;
      }

      return var2;
   }

   public final Object getKey() {
      return this.f;
   }

   public final Object getValue() {
      return this.h;
   }

   public final int hashCode() {
      int var2 = 0;
      int var1;
      if(this.f == null) {
         var1 = 0;
      } else {
         var1 = this.f.hashCode();
      }

      if(this.h != null) {
         var2 = this.h.hashCode();
      }

      return var1 ^ var2;
   }

   public final Object setValue(Object var1) {
      Object var2 = this.h;
      this.h = var1;
      return var2;
   }

   public final String toString() {
      return this.f + "=" + this.h;
   }
}
