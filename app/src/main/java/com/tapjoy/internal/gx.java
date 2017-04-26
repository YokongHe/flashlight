package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gy;

public final class gx extends com.tapjoy.internal.ao {
   private final gn a;
   private final gy b;
   private com.tapjoy.internal.ag c;

   public gx(Context var1, gn var2, gy var3) {
      super(var1);
      this.a = var2;
      this.b = var3;
      this.addView(var3, new LayoutParams(-1, -1));
      this.c = null;
   }

   protected final void onMeasure(int var1, int var2) {
      com.tapjoy.internal.ag var4 = com.tapjoy.internal.ag.a(this.getContext());
      com.tapjoy.internal.ag var3;
      if(this.a.a()) {
         if(this.a.b()) {
            if(var4.a()) {
               var3 = com.tapjoy.internal.ag.b;
            } else if(!var4.b() && com.tapjoy.internal.ag.b(this.getContext()).a()) {
               var3 = com.tapjoy.internal.ag.b;
            } else {
               var3 = com.tapjoy.internal.ag.c;
            }

            this.setRotationCount(0);
         } else {
            var3 = com.tapjoy.internal.ag.b;
            if(var4.b()) {
               if(var4.c() == 3) {
                  this.setRotationCount(1);
               } else {
                  this.setRotationCount(3);
               }
            } else {
               this.setRotationCount(0);
            }
         }
      } else {
         var3 = com.tapjoy.internal.ag.c;
         if(var4.a()) {
            if(var4.c() == 3) {
               this.setRotationCount(1);
            } else {
               this.setRotationCount(1);
            }
         } else {
            this.setRotationCount(0);
         }
      }

      if(this.c != var3) {
         this.c = var3;
         this.b.setLandscape(this.c.b());
      }

      super.onMeasure(var1, var2);
   }
}
