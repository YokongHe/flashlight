package com.ihs.a.d;

import java.util.ArrayList;
import java.util.List;

final class c {
   // $FF: synthetic field
   final com.ihs.a.d.b a;
   private final List b;

   private c(com.ihs.a.d.b var1) {
      this.a = var1;
      this.b = new ArrayList();
   }

   // $FF: synthetic method
   c(com.ihs.a.d.b var1, byte var2) {
      this(var1);
   }

   final void a(com.ihs.a.d.d param1) {
      // $FF: Couldn't be decompiled
   }

   final void a(String var1, com.ihs.a.e.e var2) {
      com.ihs.a.d.d[] var5;
      synchronized(this) {
         var5 = new com.ihs.a.d.d[this.b.size()];
         this.b.toArray(var5);
      }

      int var4 = var5.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var5[var3].a(var1, var2);
      }

   }

   final boolean a() {
      return this.b.isEmpty();
   }

   final boolean b(com.ihs.a.d.d var1) {
      synchronized(this) {
         boolean var2 = this.b.remove(var1);
         return var2;
      }
   }
}
