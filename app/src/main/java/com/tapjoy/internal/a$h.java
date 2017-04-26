package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.a$g;

final class a$h extends a$g {
   public final Notification a(a$d var1) {
      Notification var2 = var1.r;
      var2.setLatestEventInfo(var1.a, var1.b, var1.c, var1.d);
      Context var3 = var1.a;
      CharSequence var4 = var1.b;
      CharSequence var5 = var1.c;
      PendingIntent var6 = var1.d;
      PendingIntent var7 = var1.e;
      var2.setLatestEventInfo(var3, var4, var5, var6);
      var2.fullScreenIntent = var7;
      if(var1.j > 0) {
         var2.flags |= 128;
      }

      return var2;
   }
}
