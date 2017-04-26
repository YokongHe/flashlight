package com.facebook.ads.a;

import android.content.Context;
import com.facebook.ads.a.f$a;

public class ab extends com.facebook.ads.a.f {
   public ab(f$a var1, long var2, com.facebook.ads.a.aa var4, Context var5) {
      super(var1, var2, var5);
      this.a(var4);
   }

   protected void e() {
      synchronized(this){}

      try {
         ((com.facebook.ads.a.aa)this.b).a(this.a.d());
         if(this.a != null) {
            this.a.b();
         }
      } finally {
         ;
      }

   }
}
