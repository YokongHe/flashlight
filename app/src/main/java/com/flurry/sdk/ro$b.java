package com.flurry.sdk;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ro$b implements Iterator {
   static final ro$b a = new ro$b();

   public static ro$b a() {
      return a;
   }

   public String b() {
      throw new NoSuchElementException();
   }

   public boolean hasNext() {
      return false;
   }

   // $FF: synthetic method
   public Object next() {
      return this.b();
   }

   public void remove() {
      throw new IllegalStateException();
   }
}
