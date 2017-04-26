package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class fn$j extends ArrayList {
   private boolean a = false;

   public fn$j() {
   }

   public fn$j(int var1) {
      super(var1);
   }

   public fn$j(List var1) {
      super(var1);
   }

   private void b() {
      if(this.a) {
         throw new IllegalStateException();
      }
   }

   public List a() {
      this.a = true;
      return this;
   }

   public boolean add(Object var1) {
      this.b();
      return super.add(var1);
   }

   public boolean addAll(int var1, Collection var2) {
      this.b();
      return super.addAll(var1, var2);
   }

   public boolean addAll(Collection var1) {
      this.b();
      return super.addAll(var1);
   }

   public void clear() {
      this.b();
      super.clear();
   }

   public Object remove(int var1) {
      this.b();
      return super.remove(var1);
   }

   public boolean remove(Object var1) {
      this.b();
      return super.remove(var1);
   }

   public boolean removeAll(Collection var1) {
      this.b();
      return super.removeAll(var1);
   }

   public boolean retainAll(Collection var1) {
      this.b();
      return super.retainAll(var1);
   }
}
