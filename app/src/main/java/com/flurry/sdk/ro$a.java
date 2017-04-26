package com.flurry.sdk;

import com.flurry.sdk.hh;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ro$a implements Iterator {
   static final ro$a a = new ro$a();

   public static ro$a a() {
      return a;
   }

   public hh b() {
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
