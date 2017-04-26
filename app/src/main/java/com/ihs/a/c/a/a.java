package com.ihs.a.c.a;

import android.os.Handler;
import android.text.TextUtils;

final class a {
   protected com.ihs.a.c.b.e a;
   private com.ihs.a.c.b.c b;
   private com.ihs.a.c.a.f c;
   private boolean d = false;
   private boolean e = false;
   private com.ihs.a.c.a.b f;

   public a() {
      this.a = com.ihs.a.c.b.e.a;
      this.c = new com.ihs.a.c.a.f(this);
   }

   // $FF: synthetic method
   static com.ihs.a.c.b.c a(com.ihs.a.c.a.a var0, com.ihs.a.c.b.c var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean a(com.ihs.a.c.a.a var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static com.ihs.a.c.b.c b(com.ihs.a.c.a.a var0) {
      return var0.b;
   }

   public final com.ihs.a.c.a.a a(com.ihs.a.c.b.e var1) {
      this.a = var1;
      return this;
   }

   public final com.ihs.a.c.a.a a(com.ihs.a.c.b.g var1) {
      com.ihs.a.c.a.f var2 = this.c;
      if(var1 == null) {
         return this;
      } else {
         var2.e = var1;
         return this;
      }
   }

   public final com.ihs.a.c.a.a a(byte[] var1) {
      this.c.a(var1);
      return this;
   }

   public final com.ihs.a.c.a.f a() {
      return this.c;
   }

   public final boolean a(String var1, com.ihs.a.c.a.c var2) {
      Handler var3 = new Handler();
      if(!this.e && !this.d && !TextUtils.isEmpty(var1) && var2 != null && var3 != null) {
         this.e = true;
         this.f = new com.ihs.a.c.a.b(this, var1, this.c, var2, var3);
         this.f.start();
         return true;
      } else {
         return false;
      }
   }

   public final void b() {
      this.d = true;
   }
}
