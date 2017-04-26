package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.internal.fj;
import com.tapjoy.internal.fm;
import com.tapjoy.internal.fp;

public class fw implements fm {
   private static final fw a = new fw((byte)0) {
      public final void a(String var1) {
      }

      public final void a(String var1, fj var2) {
      }

      public final void b(String var1) {
      }

      public final void b(String var1, fj var2) {
      }

      public final void c(String var1) {
      }

      public final void d(String var1) {
      }
   };
   private final fm b;
   private final com.tapjoy.internal.bf c;

   private fw() {
      this.b = null;
      this.c = null;
   }

   // $FF: synthetic method
   fw(byte var1) {
      this();
   }

   private fw(fm var1) {
      this.b = var1;
      Looper var2 = Looper.myLooper();
      Handler var3;
      if(var2 != null) {
         com.tapjoy.internal.cu.a(var2);
         if(var2 == Looper.getMainLooper()) {
            var3 = com.tapjoy.internal.x.a();
         } else {
            var3 = new Handler(var2);
         }
      } else {
         var3 = null;
      }

      if(var3 != null) {
         this.c = com.tapjoy.internal.x.a(var3);
         var3.getLooper();
      } else if(Thread.currentThread() == fp.b()) {
         this.c = fp.a;
      } else {
         this.c = com.tapjoy.internal.x.a(com.tapjoy.internal.x.a());
      }
   }

   static fw a(fm var0) {
      boolean var1;
      if(!(var0 instanceof fw)) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(!var1) {
         throw new IllegalArgumentException();
      } else {
         return var0 != null?new fw(var0):a;
      }
   }

   public void a(final String var1) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.a(var1);
         }
      });
   }

   public void a(final String var1, final fj var2) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.a(var1, var2);
         }
      });
   }

   public void b(final String var1) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.b(var1);
         }
      });
   }

   public void b(final String var1, final fj var2) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.b(var1, var2);
         }
      });
   }

   public void c(final String var1) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.c(var1);
         }
      });
   }

   public void d(final String var1) {
      this.c.a(new Runnable() {
         public final void run() {
            fw.this.b.d(var1);
         }
      });
   }
}
