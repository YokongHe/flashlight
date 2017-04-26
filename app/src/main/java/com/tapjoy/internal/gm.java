package com.tapjoy.internal;

import android.graphics.Rect;
import com.tapjoy.internal.fj;
import com.tapjoy.internal.gi;

public final class gm {
   public static final com.tapjoy.internal.bo g = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         gi var3 = null;
         boolean var2 = false;
         String var5 = "";
         var1.i();
         String var4 = null;
         String var6 = null;
         Rect var7 = null;

         while(var1.k()) {
            String var8 = var1.m();
            if("region".equals(var8)) {
               var7 = (Rect)var1.a(com.tapjoy.internal.bp.b);
            } else if("value".equals(var8)) {
               var6 = var1.n();
            } else if("dismiss".equals(var8)) {
               var2 = var1.o();
            } else if("url".equals(var8)) {
               var5 = var1.n();
            } else if("redirect_url".equals(var8)) {
               var4 = com.tapjoy.internal.cv.b(var1.n());
            } else if(gi.a(var8)) {
               var3 = gi.a(var8, var1);
            } else {
               var1.t();
            }
         }

         var1.j();
         return new gm(var7, var6, var2, var5, var4, var3);
      }
   };
   public final Rect a;
   public final String b;
   public final boolean c;
   public final String d;
   public final String e;
   public final fj f;

   gm(Rect var1, String var2, boolean var3, String var4, String var5, fj var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }
}
