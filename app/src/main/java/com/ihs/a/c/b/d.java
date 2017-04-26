package com.ihs.a.c.b;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class d extends com.ihs.a.c.b.h {
   private final Closeable a;
   private final boolean b;

   protected d(Closeable var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   protected final void b() {
      if(this.a instanceof Flushable) {
         ((Flushable)this.a).flush();
      }

      if(this.b) {
         try {
            this.a.close();
         } catch (IOException var2) {
            ;
         }
      } else {
         this.a.close();
      }
   }
}
