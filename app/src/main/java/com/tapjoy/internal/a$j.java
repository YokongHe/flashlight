package com.tapjoy.internal;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Notification.Builder;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.a$f;

final class a$j implements a$f {
   public final Notification a(a$d var1) {
      Context var14 = var1.a;
      Notification var7 = var1.r;
      CharSequence var10 = var1.b;
      CharSequence var11 = var1.c;
      CharSequence var12 = var1.h;
      RemoteViews var15 = var1.f;
      int var2 = var1.i;
      PendingIntent var13 = var1.d;
      PendingIntent var8 = var1.e;
      Bitmap var9 = var1.g;
      int var3 = var1.n;
      int var4 = var1.o;
      boolean var6 = var1.p;
      Builder var16 = (new Builder(var14)).setWhen(var7.when).setSmallIcon(var7.icon, var7.iconLevel).setContent(var7.contentView).setTicker(var7.tickerText, var15).setSound(var7.sound, var7.audioStreamType).setVibrate(var7.vibrate).setLights(var7.ledARGB, var7.ledOnMS, var7.ledOffMS);
      boolean var5;
      if((var7.flags & 2) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var16 = var16.setOngoing(var5);
      if((var7.flags & 8) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var16 = var16.setOnlyAlertOnce(var5);
      if((var7.flags & 16) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      var16 = var16.setAutoCancel(var5).setDefaults(var7.defaults).setContentTitle(var10).setContentText(var11).setContentInfo(var12).setContentIntent(var13).setDeleteIntent(var7.deleteIntent);
      if((var7.flags & 128) != 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var16.setFullScreenIntent(var8, var5).setLargeIcon(var9).setNumber(var2).setProgress(var3, var4, var6).getNotification();
   }
}
