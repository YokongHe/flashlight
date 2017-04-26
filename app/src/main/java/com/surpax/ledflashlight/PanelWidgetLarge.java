package com.surpax.ledflashlight;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.surpax.ledflashlight.StartLightReceiverLarge;
import java.util.ArrayList;
import java.util.List;

public class PanelWidgetLarge extends AppWidgetProvider {
   private static void a(Context var0, AppWidgetManager var1, int var2) {
      Intent var3 = new Intent(var0, StartLightReceiverLarge.class);
      PendingIntent var5 = PendingIntent.getBroadcast(var0.getApplicationContext(), 0, var3, 134217728);
      RemoteViews var4 = new RemoteViews(var0.getPackageName(), 2130903046);
      var4.setOnClickPendingIntent(2131492902, var5);
      var1.updateAppWidget(var2, var4);
   }

   @SuppressLint({"NewApi"})
   public void onAppWidgetOptionsChanged(Context var1, AppWidgetManager var2, int var3, Bundle var4) {
      a(var1, var2, var3);
      super.onAppWidgetOptionsChanged(var1, var2, var3, var4);
   }

   public void onDeleted(Context var1, int[] var2) {
      com.surpax.ledflashlight.c.c(var1, "HomeScreen_Large");
      ArrayList var5 = new ArrayList(com.surpax.ledflashlight.c.a(var1, "PanelWidgetLargeIdList"));
      int var4 = var2.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var5.remove(String.valueOf(var2[var3]));
      }

      com.surpax.ledflashlight.c.a(var1, "PanelWidgetLargeIdList", (List)var5);
      super.onDeleted(var1, var2);
   }

   public void onReceive(Context param1, Intent param2) {
      // $FF: Couldn't be decompiled
   }

   public void onUpdate(Context var1, AppWidgetManager var2, int[] var3) {
      byte var5 = 0;
      int var6 = var3.length;

      int var4;
      for(var4 = 0; var4 < var6; ++var4) {
         a(var1, var2, var3[var4]);
      }

      List var7 = com.surpax.ledflashlight.c.a(var1, "PanelWidgetLargeIdList");
      ArrayList var8 = new ArrayList(var7);
      var6 = var3.length;

      for(var4 = var5; var4 < var6; ++var4) {
         int var9 = var3[var4];
         if(!var7.contains(String.valueOf(var9))) {
            var8.add(String.valueOf(var9));
            com.surpax.ledflashlight.c.b(var1, "HomeScreen_Large");
         }
      }

      if(var8.size() != var7.size()) {
         com.surpax.ledflashlight.c.a(var1, "PanelWidgetLargeIdList", (List)var8);
      }

      super.onUpdate(var1, var2, var3);
   }
}
