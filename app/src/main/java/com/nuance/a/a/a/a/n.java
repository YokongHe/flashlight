package com.nuance.a.a.a.a;

import android.util.Log;

public final class n extends .ae {
   private String a;

   public n(Class var1) {
      this.a = var1.getSimpleName();
   }

   public final void a(Object var1) {
      Log.v("NMSP_", "[" + this.a + "] " + var1.toString());
   }

   public final void a(Object var1, Throwable var2) {
      var2.printStackTrace();
      Log.e("NMSP", "[" + this.a + "] " + var1.toString(), var2);
   }

   public final boolean a() {
      return Log.isLoggable("NMSP_", 2);
   }

   public final void b(Object var1) {
      Log.d("NMSP_", "[" + this.a + "] " + var1.toString());
   }

   public final boolean b() {
      return Log.isLoggable("NMSP_", 3);
   }

   public final void c(Object var1) {
      Log.i("NMSP", "[" + this.a + "] " + var1.toString());
   }

   public final boolean c() {
      return Log.isLoggable("NMSP", 4);
   }

   public final void d(Object var1) {
      Log.w("NMSP", "[" + this.a + "] " + var1.toString());
   }

   public final boolean d() {
      return Log.isLoggable("NMSP", 5);
   }

   public final void e(Object var1) {
      Log.e("NMSP", "[" + this.a + "] " + var1.toString());
   }

   public final boolean e() {
      return Log.isLoggable("NMSP", 6);
   }

   public final void f() {
   }

   public final void g() {
   }
}
