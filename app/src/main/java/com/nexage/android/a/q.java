package com.nexage.android.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.nexage.android.NexageAdView;

public final class q extends FrameLayout implements com.nexage.android.a.l {
   private View a;

   public q(Context var1) {
      super(var1);
   }

   public final View a() {
      if(this.a != null) {
         this.removeView(this.a);
      }

      View var1 = this.a;
      this.a = null;
      return var1;
   }

   public final void a(View var1) {
      if(this.a != var1) {
         if(this.a != null) {
            this.removeView(this.a);
         }

         this.a = var1;
         this.addView(var1);
         ((NexageAdView)this.getParent()).d();
      }
   }

   public final void a(String var1) {
   }

   public final boolean b() {
      return false;
   }

   public final void setVisibility(int var1) {
      super.setVisibility(var1);
      if(this.a != null) {
         if(var1 != 4) {
            this.a.setVisibility(var1);
            return;
         }

         this.a.setVisibility(8);
      }

   }
}
