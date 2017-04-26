package com.google.android.gms.tagmanager;

import android.util.Log;

final class aa implements com.google.android.gms.tagmanager.o {
   private int a = 5;

   public final void a(String var1) {
      if(this.a <= 6) {
         Log.e("GoogleTagManager", var1);
      }

   }

   public final void a(String var1, Throwable var2) {
      if(this.a <= 6) {
         Log.e("GoogleTagManager", var1, var2);
      }

   }

   public final void b(String var1) {
      if(this.a <= 5) {
         Log.w("GoogleTagManager", var1);
      }

   }

   public final void c(String var1) {
      if(this.a <= 4) {
         Log.i("GoogleTagManager", var1);
      }

   }

   public final void d(String var1) {
      if(this.a <= 2) {
         Log.v("GoogleTagManager", var1);
      }

   }
}
