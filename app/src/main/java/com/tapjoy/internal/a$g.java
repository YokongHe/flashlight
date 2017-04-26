package com.tapjoy.internal;

import android.app.Notification;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.a$f;

class a$g implements a$f {
   public Notification a(a$d var1) {
      Notification var2 = var1.r;
      var2.setLatestEventInfo(var1.a, var1.b, var1.c, var1.d);
      if(var1.j > 0) {
         var2.flags |= 128;
      }

      return var2;
   }
}
