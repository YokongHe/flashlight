package com.millennialmedia.a.a.b;

final class k {
   private com.millennialmedia.a.a.b.p a;
   private int b;
   private int c;
   private int d;

   final com.millennialmedia.a.a.b.p a() {
      com.millennialmedia.a.a.b.p var1 = this.a;
      if(var1.a != null) {
         throw new IllegalStateException();
      } else {
         return var1;
      }
   }

   final void a(int var1) {
      this.b = Integer.highestOneBit(var1) * 2 - 1 - var1;
      this.d = 0;
      this.c = 0;
      this.a = null;
   }

   final void a(com.millennialmedia.a.a.b.p var1) {
      var1.c = null;
      var1.a = null;
      var1.b = null;
      var1.i = 1;
      if(this.b > 0 && (this.d & 1) == 0) {
         ++this.d;
         --this.b;
         ++this.c;
      }

      var1.a = this.a;
      this.a = var1;
      ++this.d;
      if(this.b > 0 && (this.d & 1) == 0) {
         ++this.d;
         --this.b;
         ++this.c;
      }

      for(int var2 = 4; (this.d & var2 - 1) == var2 - 1; var2 *= 2) {
         com.millennialmedia.a.a.b.p var3;
         if(this.c == 0) {
            var1 = this.a;
            var3 = var1.a;
            com.millennialmedia.a.a.b.p var4 = var3.a;
            var3.a = var4.a;
            this.a = var3;
            var3.b = var4;
            var3.c = var1;
            var3.i = var1.i + 1;
            var4.a = var3;
            var1.a = var3;
         } else if(this.c == 1) {
            var1 = this.a;
            var3 = var1.a;
            this.a = var3;
            var3.c = var1;
            var3.i = var1.i + 1;
            var1.a = var3;
            this.c = 0;
         } else if(this.c == 2) {
            this.c = 0;
         }
      }

   }
}
