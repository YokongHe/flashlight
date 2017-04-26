package com.tapjoy.internal;

import com.tapjoy.internal.hh;

public abstract class hg implements hh {
   private final String a;
   private final String b;
   private final String c;

   public hg(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("MIME type may not be null");
      } else {
         this.a = var1;
         int var2 = var1.indexOf(47);
         if(var2 != -1) {
            this.b = var1.substring(0, var2);
            this.c = var1.substring(var2 + 1);
         } else {
            this.b = var1;
            this.c = null;
         }
      }
   }

   public final String a() {
      return this.a;
   }
}
