package com.millennialmedia.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h extends com.millennialmedia.a.a.j implements Iterable {
   private final List a = new ArrayList();

   public final Number a() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).a();
      } else {
         throw new IllegalStateException();
      }
   }

   public final void a(com.millennialmedia.a.a.j var1) {
      Object var2 = var1;
      if(var1 == null) {
         var2 = com.millennialmedia.a.a.l.a;
      }

      this.a.add(var2);
   }

   public final String b() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).b();
      } else {
         throw new IllegalStateException();
      }
   }

   public final double c() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).c();
      } else {
         throw new IllegalStateException();
      }
   }

   public final long d() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).d();
      } else {
         throw new IllegalStateException();
      }
   }

   public final int e() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).e();
      } else {
         throw new IllegalStateException();
      }
   }

   public final boolean equals(Object var1) {
      return var1 == this || var1 instanceof h && ((h)var1).a.equals(this.a);
   }

   public final boolean f() {
      if(this.a.size() == 1) {
         return ((com.millennialmedia.a.a.j)this.a.get(0)).f();
      } else {
         throw new IllegalStateException();
      }
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final Iterator iterator() {
      return this.a.iterator();
   }
}
