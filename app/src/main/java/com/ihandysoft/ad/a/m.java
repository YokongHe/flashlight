package com.ihandysoft.ad.a;

import android.app.Activity;
import com.nexage.android.NexageAdView;
import java.util.Map;

public class m extends com.ihandysoft.ad.a.a implements com.nexage.android.j {
   private static boolean n = true;

   public final void E() {
      this.x();
   }

   public final void F() {
      this.a((Exception)null);
   }

   public final void G() {
      this.v();
      this.w();
   }

   public final void H() {
      this.u();
   }

   public final boolean a(Map var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(super.a(var1)) {
         var2 = var3;
         if(this.d.get("dcn").equals(var1.get("dcn"))) {
            var2 = var3;
            if(this.d.get("mediaURL").equals(var1.get("mediaURL"))) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public final void p() {
      com.nexage.android.b.b((String)this.d.get("dcn"));
      com.nexage.android.b.c((String)this.d.get("mediaURL"));
      if(n) {
         n = false;
         com.nexage.android.b.b(true);
         com.nexage.android.b.a(this.a());
      }

      NexageAdView var1 = new NexageAdView((String)this.d.get("position"), (Activity)this.a());
      this.b = var1;
      var1.a((com.nexage.android.j)this);
      var1.a(0);
      var1.b();
   }

   public final void t() {
      if(this.b != null) {
         ((NexageAdView)this.b).a((com.nexage.android.j)null);
      }

      super.t();
   }
}
