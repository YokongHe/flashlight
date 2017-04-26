package com.tapjoy.internal;

import java.util.AbstractQueue;
import java.util.Iterator;

public abstract class ay extends AbstractQueue implements com.tapjoy.internal.bc {
   public Iterator iterator() {
      return new Iterator() {
         private int b = 0;

         public final boolean hasNext() {
            return this.b < ay.this.size();
         }

         public final Object next() {
            com.tapjoy.internal.ay var2 = ay.this;
            int var1 = this.b;
            this.b = var1 + 1;
            return var2.a(var1);
         }

         public final void remove() {
            if(this.b == 1) {
               ay.this.b(1);
               this.b = 0;
            } else {
               throw new UnsupportedOperationException("For the first element only");
            }
         }
      };
   }
}
