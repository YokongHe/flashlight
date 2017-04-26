package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.ft;
import com.flurry.sdk.fy;

public class ft$d implements fy, Comparable {
   private final fn a;
   private final Object[] b;

   public ft$d(fn var1) {
      if(var1 != null && fn$v.a.equals(var1.a())) {
         this.a = var1;
         this.b = new Object[var1.b().size()];
      } else {
         throw new fk("Not a record schema: " + var1);
      }
   }

   public int a(ft$d var1) {
      return ft.a().a(this, (Object)var1, this.a);
   }

   public fn a() {
      return this.a;
   }

   public Object a(int var1) {
      return this.b[var1];
   }

   public void a(int var1, Object var2) {
      this.b[var1] = var2;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((ft$d)var1);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof ft$d)) {
            return false;
         }

         ft$d var2 = (ft$d)var1;
         if(!this.a.g().equals(var2.a.g())) {
            return false;
         }

         if(ft.a().a(this, var2, this.a, true) != 0) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return ft.a().b((Object)this, (fn)this.a);
   }

   public String toString() {
      return ft.a().a((Object)this);
   }
}
