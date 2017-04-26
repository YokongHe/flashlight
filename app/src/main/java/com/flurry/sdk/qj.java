package com.flurry.sdk;

public final class qj implements Comparable {
   private String a;
   private Class b;
   private int c;

   public qj() {
      this.b = null;
      this.a = null;
      this.c = 0;
   }

   public qj(Class var1) {
      this.b = var1;
      this.a = var1.getName();
      this.c = this.a.hashCode();
   }

   public final int a(qj var1) {
      return this.a.compareTo(var1.a);
   }

   public final void a(Class var1) {
      this.b = var1;
      this.a = var1.getName();
      this.c = this.a.hashCode();
   }

   // $FF: synthetic method
   public final int compareTo(Object var1) {
      return this.a((qj)var1);
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         if(((qj)var1).b != this.b) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return this.c;
   }

   public final String toString() {
      return this.a;
   }
}
