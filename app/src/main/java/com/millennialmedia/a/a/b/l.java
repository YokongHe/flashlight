package com.millennialmedia.a.a.b;

final class l {
   private com.millennialmedia.a.a.b.p a;

   public final com.millennialmedia.a.a.b.p a() {
      com.millennialmedia.a.a.b.p var4 = this.a;
      if(var4 == null) {
         return null;
      } else {
         com.millennialmedia.a.a.b.p var2 = var4.a;
         var4.a = null;

         com.millennialmedia.a.a.b.p var3;
         for(com.millennialmedia.a.a.b.p var1 = var4.c; var1 != null; var1 = var3) {
            var1.a = var2;
            var3 = var1.b;
            var2 = var1;
         }

         this.a = var2;
         return var4;
      }
   }

   final void a(com.millennialmedia.a.a.b.p var1) {
      com.millennialmedia.a.a.b.p var2;
      com.millennialmedia.a.a.b.p var3;
      for(var2 = null; var1 != null; var1 = var3) {
         var1.a = var2;
         var3 = var1.b;
         var2 = var1;
      }

      this.a = var2;
   }
}
