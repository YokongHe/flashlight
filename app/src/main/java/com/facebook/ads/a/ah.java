package com.facebook.ads.a;

import android.os.Build.VERSION;
import android.view.View;
import com.facebook.ads.a.ah$a;

public class ah {
   private int a = 200;
   private int b = 500;
   private int c = 4000;
   private final ah$a d;
   private final ah$a e;
   private boolean f;

   public ah(View var1, View var2) {
      this.d = new ah$a(this, var1);
      this.e = (new ah$a(this, var2)).a(true);
      this.f = "4.1.2".equals(VERSION.RELEASE);
   }

   // $FF: synthetic method
   static int a(com.facebook.ads.a.ah var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static int b(com.facebook.ads.a.ah var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static int c(com.facebook.ads.a.ah var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static boolean d(com.facebook.ads.a.ah var0) {
      return var0.f;
   }

   public com.facebook.ads.a.ah a() {
      this.d.a();
      this.e.a();
      return this;
   }

   public com.facebook.ads.a.ah a(int var1) {
      this.a = var1 * 2;
      return this;
   }
}
