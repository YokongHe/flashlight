package com.millennialmedia.a.a.b;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class o implements Iterator {
   com.millennialmedia.a.a.b.p b;
   com.millennialmedia.a.a.b.p c;
   int d;
   // $FF: synthetic field
   final j e;

   private o(j var1) {
      this.e = var1;
      this.b = this.e.c.d;
      this.c = null;
      this.d = this.e.e;
   }

   // $FF: synthetic method
   o(j var1, byte var2) {
      this(var1);
   }

   final com.millennialmedia.a.a.b.p a() {
      com.millennialmedia.a.a.b.p var1 = this.b;
      if(var1 == this.e.c) {
         throw new NoSuchElementException();
      } else if(this.e.e != this.d) {
         throw new ConcurrentModificationException();
      } else {
         this.b = var1.d;
         this.c = var1;
         return var1;
      }
   }

   public final boolean hasNext() {
      return this.b != this.e.c;
   }

   public final void remove() {
      if(this.c == null) {
         throw new IllegalStateException();
      } else {
         this.e.a(this.c, true);
         this.c = null;
         this.d = this.e.e;
      }
   }
}
