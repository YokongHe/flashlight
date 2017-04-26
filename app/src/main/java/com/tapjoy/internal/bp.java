package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;

public final class bp {
   public static final com.tapjoy.internal.bo a = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         Point var2 = new Point();
         var1.i();

         while(var1.k()) {
            String var3 = var1.m();
            if("x".equals(var3)) {
               var2.x = var1.s();
            } else if("y".equals(var3)) {
               var2.y = var1.s();
            } else {
               var1.t();
            }
         }

         var1.j();
         return var2;
      }
   };
   public static final com.tapjoy.internal.bo b = new com.tapjoy.internal.bo() {
      // $FF: synthetic method
      public final Object a(com.tapjoy.internal.bt var1) {
         Rect var2 = new Rect();
         switch(null.a[var1.l().ordinal()]) {
         case 1:
            var1.g();
            var2.left = var1.s();
            var2.top = var1.s();
            var2.right = var1.s();
            var2.bottom = var1.s();

            while(var1.k()) {
               var1.t();
            }

            var1.h();
            return var2;
         case 2:
            var1.i();

            while(var1.k()) {
               String var3 = var1.m();
               if("left".equals(var3)) {
                  var2.left = var1.s();
               } else if("top".equals(var3)) {
                  var2.top = var1.s();
               } else if("right".equals(var3)) {
                  var2.right = var1.s();
               } else if("bottom".equals(var3)) {
                  var2.bottom = var1.s();
               } else {
                  var1.t();
               }
            }

            var1.j();
            return var2;
         default:
            throw new IllegalStateException("Unexpected token: " + var1.l());
         }
      }
   };
}
