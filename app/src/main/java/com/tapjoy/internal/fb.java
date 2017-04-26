package com.tapjoy.internal;

import android.location.Location;
import android.location.LocationManager;
import com.tapjoy.internal.fa;

class fb {
   private static final String a = fb.class.getName();
   private Location b;
   private LocationManager c;
   private fa d;
   private boolean e = false;

   public final void a() {
      boolean var1;
      if(this.c != null && this.d != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var1) {
         this.c.removeUpdates(this.d);
      }

   }

   public final Location b() {
      Location var2 = this.b;
      Location var1 = var2;
      if(var2 == null) {
         var1 = var2;
         if(this.d != null) {
            var1 = this.d.a();
         }
      }

      return var1;
   }
}
