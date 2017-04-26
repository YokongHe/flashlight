package com.ihs.app.alerts.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import com.ihs.app.alerts.impl.AlertActivity;
import com.ihs.app.framework.HSApplication;

public final class h {
   public static void a(Bundle var0) {
      int var1;
      try {
         var1 = Integer.valueOf(var0.getString("AlertType")).intValue();
      } catch (Exception var10) {
         return;
      }

      String var2;
      if(var1 == 0) {
         var2 = var0.getString("Body");
         if(var2 == null) {
            var2 = "";
         }

         NotificationManager var4 = (NotificationManager)HSApplication.a().getSystemService("notification");
         Notification var5 = new Notification(var0.getInt("Icon"), var2, System.currentTimeMillis());
         var5.flags |= 16;
         String var3 = var0.getString("Sound");
         if(var3 != null) {
            if("default".equalsIgnoreCase(var3)) {
               var5.defaults |= 1;
            } else {
               try {
                  var5.sound = Uri.parse(var3);
               } catch (Exception var8) {
                  var8.printStackTrace();
               }
            }
         }

         if("true".equalsIgnoreCase(var0.getString("Vibrate"))) {
            var5.defaults |= 2;
         }

         Intent var14 = new Intent(HSApplication.a(), AlertActivity.class);
         var14.setFlags(335544320);
         var14.putExtra("AlertName", "PushAlert");
         var14.putExtra("AlertType", 2);
         var14.putExtra("bundle", var0);
         PendingIntent var6 = PendingIntent.getActivity(HSApplication.a(), 0, var14, 0);
         ApplicationInfo var7 = HSApplication.a().getApplicationInfo();
         var3 = var0.getString("Title");
         String var11 = var3;
         if(TextUtils.isEmpty(var3)) {
            var11 = "";
         }

         var5.icon = var7.icon;
         var5.flags = 16;
         var5.tickerText = var2;
         var5.setLatestEventInfo(HSApplication.a(), var11, var2, var6);
         var4.notify(0, var5);
      } else if(var1 == 1 || var1 == 2) {
         var2 = var0.getString("Sound");
         if(var2 != null && "default".equalsIgnoreCase(var2)) {
            MediaPlayer var13 = new MediaPlayer();
            Uri var16 = RingtoneManager.getActualDefaultRingtoneUri(HSApplication.a(), 2);

            try {
               var13.setDataSource(HSApplication.a(), var16);
               if(((AudioManager)HSApplication.a().getSystemService("audio")).getStreamVolume(2) != 0) {
                  var13.setAudioStreamType(2);
                  var13.setLooping(false);
                  var13.prepare();
                  var13.start();
               }
            } catch (Exception var9) {
               var9.printStackTrace();
            }
         }

         if("true".equalsIgnoreCase(var0.getString("Vibrate"))) {
            ((Vibrator)HSApplication.a().getSystemService("vibrator")).vibrate(1000L);
         }

         Activity var15 = com.ihs.app.framework.a.b.a().d();
         if(var15 == null) {
            Intent var17 = new Intent(HSApplication.a(), AlertActivity.class);
            var17.setFlags(268435456);
            var17.putExtra("AlertName", "PushAlert");
            var17.putExtra("AlertType", var1);
            var17.putExtra("bundle", var0);
            HSApplication.a().startActivity(var17);
            return;
         } else {
            AlertDialog var12 = (new com.ihs.app.alerts.impl.a(var15, false)).a("PushAlert", var1, var0);
            ((com.ihs.app.framework.activity.a)var15).a(var12);
            return;
         }
      }

   }
}
