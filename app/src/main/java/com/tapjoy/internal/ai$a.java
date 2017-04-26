package com.tapjoy.internal;

import android.view.ViewGroup;
import java.util.Iterator;

public final class ai$a implements Iterator {
   private final ViewGroup a;
   private int b;
   private int c = 0;

   public ai$a(ViewGroup var1) {
      this.a = var1;
      this.b = var1.getChildCount();
   }

   public final boolean hasNext() {
      return this.c < this.b;
   }

   // $FF: synthetic method
   public final Object next() {
      ViewGroup var2 = this.a;
      int var1 = this.c;
      this.c = var1 + 1;
      return var2.getChildAt(var1);
   }

   public final void remove() {
      this.a.removeViewAt(this.c - 1);
   }
}
