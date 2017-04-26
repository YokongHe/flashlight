package com.tapjoy.internal;

import com.tapjoy.internal.fs;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$i;
import java.io.File;

public final class ft implements Runnable {
   final gf a;
   com.tapjoy.internal.cj b;
   private final Object c;
   private final Thread d;
   private boolean e;

   public ft(File var1) {
      this.a = new gf(var1);
      this.c = this.a;
      this.a.a();
      this.d = new Thread(this, "5Rocks");
      this.d.start();
   }

   private void a(boolean var1) {
      Object var2 = this.c;
      synchronized(var2) {
         this.e = var1;
         this.c.notify();
      }
   }

   public final void a() {
      if(this.b != null && !this.a.b()) {
         this.a(true);
      }

   }

   public final void a(com.tapjoy.internal.cj var1) {
      this.b = var1;
      this.a();
   }

   public final void a(gk$c var1) {
      try {
         this.a.a(var1);
      } catch (Exception var2) {
         return;
      }

      if(this.b != null) {
         if(!fs.a && var1.f() == gk$i.c) {
            this.a(false);
         } else {
            this.a(true);
         }
      } else {
         this.a.flush();
      }
   }

   public final void run() {
      // $FF: Couldn't be decompiled
   }
}
