package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

public final class az extends com.tapjoy.internal.ay implements com.tapjoy.internal.bc, Closeable, Flushable {
   private final com.tapjoy.internal.bc a;
   private final LinkedList b;
   private final LinkedList c;
   private int d;
   private boolean e;

   private az(com.tapjoy.internal.bc var1) {
      this.a = var1;
      this.b = new LinkedList();
      this.c = new LinkedList();
      this.d = var1.size();
      boolean var2;
      if(this.d == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.e = var2;
   }

   public static com.tapjoy.internal.az a(com.tapjoy.internal.bc var0) {
      return new com.tapjoy.internal.az(var0);
   }

   public final Object a(int var1) {
      if(var1 >= 0 && var1 < this.d) {
         int var2 = this.b.size();
         Object var4;
         if(var1 < var2) {
            var4 = this.b.get(var1);
         } else {
            if(this.e) {
               return this.c.get(var1 - var2);
            }

            if(var1 >= this.a.size()) {
               return this.c.get(var1 - this.a.size());
            }

            Object var3;
            for(var3 = null; var2 <= var1; ++var2) {
               var3 = this.a.a(var2);
               this.b.add(var3);
            }

            var4 = var3;
            if(var1 + 1 + this.c.size() == this.d) {
               this.e = true;
               return var3;
            }
         }

         return var4;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public final void b(int var1) {
      if(var1 > 0 && var1 <= this.d) {
         if(var1 <= this.b.size()) {
            com.tapjoy.internal.bb.a(this.b, var1);
            this.a.b(var1);
         } else {
            this.b.clear();
            int var2 = this.c.size() + var1 - this.d;
            if(var2 < 0) {
               this.a.b(var1);
            } else {
               this.a.clear();
               this.e = true;
               if(var2 > 0) {
                  com.tapjoy.internal.bb.a(this.c, var2);
               }
            }
         }

         this.d -= var1;
      } else {
         throw new IndexOutOfBoundsException();
      }
   }

   public final void close() {
      try {
         this.flush();
      } finally {
         if(this.a instanceof Closeable) {
            ((Closeable)this.a).close();
         }

      }

   }

   protected final void finalize() {
      this.close();
      super.finalize();
   }

   public final void flush() {
      if(!this.c.isEmpty()) {
         this.a.addAll(this.c);
         if(this.e) {
            this.b.addAll(this.c);
         }

         this.c.clear();
      }

   }

   public final boolean offer(Object var1) {
      this.c.add(var1);
      ++this.d;
      return true;
   }

   public final Object peek() {
      Object var1;
      if(this.d <= 0) {
         var1 = null;
      } else {
         if(!this.b.isEmpty()) {
            return this.b.element();
         }

         if(this.e) {
            return this.c.element();
         }

         Object var2 = this.a.peek();
         this.b.add(var2);
         var1 = var2;
         if(this.d == this.b.size() + this.c.size()) {
            this.e = true;
            return var2;
         }
      }

      return var1;
   }

   public final Object poll() {
      if(this.d <= 0) {
         return null;
      } else {
         Object var1;
         if(!this.b.isEmpty()) {
            var1 = this.b.remove();
            this.a.b(1);
         } else if(this.e) {
            var1 = this.c.remove();
         } else {
            Object var2 = this.a.remove();
            var1 = var2;
            if(this.d == this.c.size() + 1) {
               this.e = true;
               var1 = var2;
            }
         }

         --this.d;
         return var1;
      }
   }

   public final int size() {
      return this.d;
   }
}
