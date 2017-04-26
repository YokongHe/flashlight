package com.nexage.android.e;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public abstract class b {
   protected Context a;
   protected Handler b;
   protected boolean c;

   protected b(Context var1, Handler var2) {
      this.a = var1;
      this.b = var2;
   }

   private void a(int var1, com.nexage.android.e.b var2) {
      if(this.b != null) {
         Message var3 = this.b.obtainMessage(var1, var2);
         this.b.sendMessage(var3);
      }

   }

   protected abstract View a(int var1, int var2, String var3);

   protected final void a(com.nexage.android.e.b var1) {
      this.a(123451, var1);
   }

   protected final boolean a() {
      return this.c;
   }

   protected abstract void b();

   protected final void b(com.nexage.android.e.b var1) {
      this.a(123452, var1);
   }

   protected void c() {
      this.b = null;
   }

   protected final void c(com.nexage.android.e.b var1) {
      this.a(123453, var1);
   }

   protected final void d(com.nexage.android.e.b var1) {
      this.a(123454, var1);
   }

   protected final void e(com.nexage.android.e.b var1) {
      this.a(123455, var1);
   }

   protected final void f(com.nexage.android.e.b var1) {
      this.a(123456, var1);
   }
}
