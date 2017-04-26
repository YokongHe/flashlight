package com.nexage.android.a;

import android.app.Activity;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;

public final class g extends com.nexage.android.a.a {
   private final boolean o = false;

   public g(com.nexage.android.a.m var1, com.nexage.android.c.e var2, boolean var3) {
      super(var1, var2);
   }

   public final int a(String var1) {
      MRAIDLog.v("MraidAd", "prepare:\n" + var1);
      if(var1 != null && var1.length() != 0) {
         this.d = var1;
         return 1;
      } else {
         return -1;
      }
   }

   public final com.nexage.android.a.b a(Activity var1) {
      if(this.j == null) {
         this.j = (new com.nexage.android.a.h(this, var1, this.o)).b();
      }

      return this.j;
   }

   public final void j() {
      MRAIDLog.d("MraidAd", "setAttributes");
      if(this.k.c.equals("ADTECH")) {
         StringBuilder var1 = new StringBuilder("<script type=\'text/javascript\'>");
         var1.append(this.d);
         var1.append("</script>");
         this.d = var1.toString();
      }

   }
}
