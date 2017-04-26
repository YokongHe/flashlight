package com.flurry.sdk;

import com.flurry.sdk.dt;
import com.flurry.sdk.fb$a;
import com.flurry.sdk.ff;
import java.util.List;

public class fb {
   private static final String a = fb.class.getSimpleName();
   private final dt b = new dt();
   private long c = 1000L;
   private boolean d = true;
   private boolean e = false;
   private ff f = new ff() {
      public void a() {
         // $FF: Couldn't be decompiled
      }
   };

   // $FF: synthetic method
   static List a(fb var0) {
      return var0.f();
   }

   // $FF: synthetic method
   static boolean b(fb var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static boolean c(fb var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static ff d(fb var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static long e(fb var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static String e() {
      return a;
   }

   private List f() {
      synchronized(this){}

      List var1;
      try {
         var1 = this.b.a();
      } finally {
         ;
      }

      return var1;
   }

   public void a() {
      // $FF: Couldn't be decompiled
   }

   public void a(long var1) {
      this.c = var1;
   }

   public void a(fb$a var1) {
      synchronized(this){}

      try {
         this.b.a(var1);
      } finally {
         ;
      }

   }

   public void a(boolean var1) {
      this.d = var1;
   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   public boolean b(fb$a var1) {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.b.b(var1);
      } finally {
         ;
      }

      return var2;
   }

   public boolean c() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.e;
      } finally {
         ;
      }

      return var1;
   }

   public int d() {
      synchronized(this){}

      int var1;
      try {
         var1 = this.b.b();
      } finally {
         ;
      }

      return var1;
   }
}
