package com.millennialmedia.a.a;

final class f extends com.millennialmedia.a.a.s {
   private com.millennialmedia.a.a.s a;

   public final Object a(d.a var1) {
      if(this.a == null) {
         throw new IllegalStateException();
      } else {
         return this.a.a(var1);
      }
   }

   public final void a(d.c var1, Object var2) {
      if(this.a == null) {
         throw new IllegalStateException();
      } else {
         this.a.a(var1, var2);
      }
   }

   public final void a(com.millennialmedia.a.a.s var1) {
      if(this.a != null) {
         throw new AssertionError();
      } else {
         this.a = var1;
      }
   }
}
