package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.a$f;

final class a$i implements a$f {
   public final Notification a(a$d var1) {
      Context var10 = var1.a;
      Notification var4 = var1.r;
      CharSequence var6 = var1.b;
      CharSequence var7 = var1.c;
      CharSequence var8 = var1.h;
      RemoteViews var11 = var1.f;
      int var2 = var1.i;
      PendingIntent var9 = var1.d;
      PendingIntent var5 = var1.e;
      Bitmap var12 = var1.g;
      Builder var14 = (new Builder(var10)).setWhen(var4.when).setSmallIcon(var4.icon, var4.iconLevel).setContent(var4.contentView).setTicker(var4.tickerText, var11).setSound(var4.sound, var4.audioStreamType).setVibrate(var4.vibrate).setLights(var4.ledARGB, var4.ledOnMS, var4.ledOffMS);
      boolean var3;
      if((var4.flags & 2) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      var14 = var14.setOngoing(var3);
      if((var4.flags & 8) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      var14 = var14.setOnlyAlertOnce(var3);
      if((var4.flags & 16) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      Builder var13 = var14.setAutoCancel(var3).setDefaults(var4.defaults).setContentTitle(var6).setContentText(var7).setContentInfo(var8).setContentIntent(var9).setDeleteIntent(var4.deleteIntent);
      if((var4.flags & 128) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var13.setFullScreenIntent(var5, var3).setLargeIcon(var12).setNumber(var2).getNotification();
   }
}
