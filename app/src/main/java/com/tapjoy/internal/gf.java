package com.tapjoy.internal;

import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gw;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.util.LinkedList;

public final class gf implements Flushable {
   private final File a;
   private final Object b;
   private com.tapjoy.internal.bc c;

   public gf(File var1) {
      this.a = var1;
      this.b = this;

      try {
         this.c = com.tapjoy.internal.az.a(new com.tapjoy.internal.i(var1, new gw(gk$c.b)));
      } catch (Exception var2) {
         this.c();
      }
   }

   private void c() {
      this.a.delete();
      if(this.c instanceof Closeable) {
         try {
            ((Closeable)this.c).close();
         } catch (Exception var2) {
            ;
         }
      }

      this.c = new com.tapjoy.internal.ba(new LinkedList());
   }

   public final int a() {
      Object var2 = this.b;
      synchronized(var2) {
         int var1;
         try {
            var1 = this.c.size();
         } catch (Exception var4) {
            this.c();
            return 0;
         }

         return var1;
      }
   }

   public final void a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(gk$c param1) {
      // $FF: Couldn't be decompiled
   }

   public final gk$c b(int var1) {
      Object var2 = this.b;
      synchronized(var2) {
         gk$c var3;
         try {
            var3 = (gk$c)this.c.a(var1);
         } catch (Exception var4) {
            this.c();
            return null;
         }

         return var3;
      }
   }

   public final boolean b() {
      Object var2 = this.b;
      synchronized(var2) {
         boolean var1;
         try {
            var1 = this.c.isEmpty();
         } catch (Exception var4) {
            this.c();
            return true;
         }

         return var1;
      }
   }

   public final void flush() {
      // $FF: Couldn't be decompiled
   }
}
