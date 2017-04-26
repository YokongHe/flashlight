package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.graphics.Bitmap;
import com.tapjoy.internal.a$a;
import com.tapjoy.internal.a$b;
import com.tapjoy.internal.a$c;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.a$e;
import com.tapjoy.internal.a$f;
import java.util.Iterator;

final class a$k implements a$f {
   public final Notification a(a$d var1) {
      com.tapjoy.internal.b var5 = new com.tapjoy.internal.b(var1.a, var1.r, var1.b, var1.c, var1.h, var1.f, var1.i, var1.d, var1.e, var1.g, var1.n, var1.o, var1.p, var1.k, var1.j, var1.m);
      Iterator var6 = var1.q.iterator();

      CharSequence var7;
      while(var6.hasNext()) {
         a$a var8 = (a$a)var6.next();
         int var2 = var8.a;
         var7 = var8.b;
         PendingIntent var17 = var8.c;
         var5.a.addAction(var2, var7, var17);
      }

      if(var1.l != null) {
         boolean var3;
         CharSequence var10;
         if(var1.l instanceof a$c) {
            a$c var15 = (a$c)var1.l;
            CharSequence var12 = var15.e;
            var3 = var15.g;
            var10 = var15.f;
            var7 = var15.a;
            BigTextStyle var13 = (new BigTextStyle(var5.a)).setBigContentTitle(var12).bigText(var7);
            if(var3) {
               var13.setSummaryText(var10);
            }
         } else if(var1.l instanceof a$e) {
            a$e var11 = (a$e)var1.l;
            var5.a(var11.e, var11.g, var11.f, var11.a);
         } else if(var1.l instanceof a$b) {
            a$b var16 = (a$b)var1.l;
            CharSequence var19 = var16.e;
            var3 = var16.g;
            var10 = var16.f;
            Bitmap var9 = var16.a;
            Bitmap var14 = var16.b;
            boolean var4 = var16.c;
            BigPictureStyle var18 = (new BigPictureStyle(var5.a)).setBigContentTitle(var19).bigPicture(var9);
            if(var4) {
               var18.bigLargeIcon(var14);
            }

            if(var3) {
               var18.setSummaryText(var10);
            }
         }
      }

      return var5.a.build();
   }
}
