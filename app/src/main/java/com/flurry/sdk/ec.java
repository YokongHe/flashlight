package com.flurry.sdk;

import com.flurry.sdk.ec$a;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class ec {
   private static ec a;
   private final UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
   private final Map c = new WeakHashMap();

   private ec() {
      Thread.setDefaultUncaughtExceptionHandler(new ec$a(this, null));
   }

   public static ec a() {
      synchronized(ec.class){}

      ec var0;
      try {
         if(a == null) {
            a = new ec();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   // $FF: synthetic method
   static void a(ec var0, Thread var1, Throwable var2) {
      var0.a(var1, var2);
   }

   private void a(Thread var1, Throwable var2) {
      Iterator var3 = this.b().iterator();

      while(var3.hasNext()) {
         UncaughtExceptionHandler var4 = (UncaughtExceptionHandler)var3.next();

         try {
            var4.uncaughtException(var1, var2);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   private Set b() {
      Map var1 = this.c;
      synchronized(var1) {
         Set var2 = this.c.keySet();
         return var2;
      }
   }

   // $FF: synthetic method
   static void b(ec var0, Thread var1, Throwable var2) {
      var0.b(var1, var2);
   }

   private void b(Thread var1, Throwable var2) {
      if(this.b != null) {
         this.b.uncaughtException(var1, var2);
      }

   }

   public final void a(UncaughtExceptionHandler var1) {
      Map var2 = this.c;
      synchronized(var2) {
         this.c.put(var1, (Object)null);
      }
   }
}
