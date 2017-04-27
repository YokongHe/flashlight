package com.surpax.ledflashlight;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;

import java.util.ArrayList;
import java.util.List;

public class PanelWidget extends AppWidgetProvider {
   private void a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   private static void a(Context var0, AppWidgetManager var1, int var2) {
      Intent var3 = new Intent(var0, StartLightReceiver.class);
      PendingIntent var5 = PendingIntent.getBroadcast(var0.getApplicationContext(), 0, var3, PendingIntent.FLAG_UPDATE_CURRENT);
      RemoteViews var4 = new RemoteViews(var0.getPackageName(), 2130903045);
      var4.setOnClickPendingIntent(2131492902, var5);
      var4.setOnClickPendingIntent(2131492901, var5);
      var1.updateAppWidget(var2, var4);
   }

   @SuppressLint({"NewApi"})
   public void onAppWidgetOptionsChanged(Context var1, AppWidgetManager var2, int var3, Bundle var4) {
      a(var1, var2, var3);
      super.onAppWidgetOptionsChanged(var1, var2, var3, var4);
   }

   public void onDeleted(Context var1, int[] var2) {
      c.c(var1, "HomeScreen_Small");
      ArrayList var5 = new ArrayList(c.a(var1, "PanelWidgetSmallIdList"));
      int var4 = var2.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var5.remove(String.valueOf(var2[var3]));
      }

      c.a(var1, "PanelWidgetSmallIdList", (List)var5);
      super.onDeleted(var1, var2);
   }

   public void onReceive(Context var1, Intent var2) {
      (new StringBuilder("widget receive action = ")).append(var2.getAction()).toString();
      super.onReceive(var1, var2);
      String var3 = var2.getAction();
      if(!TextUtils.isEmpty(var3) && !var3.equalsIgnoreCase("android.appwidget.action.APPWIDGET_DELETED") && !var3.equalsIgnoreCase("android.appwidget.action.APPWIDGET_DISABLED")) {
         this.a(var1);
      }
   }

   public void onUpdate(Context var1, AppWidgetManager var2, int[] var3) {
      byte var5 = 0;
      int var6 = var3.length;

      int var4;
      for(var4 = 0; var4 < var6; ++var4) {
         a(var1, var2, var3[var4]);
      }

      List var7 = c.a(var1, "PanelWidgetSmallIdList");
      ArrayList var8 = new ArrayList(var7);
      var6 = var3.length;

      for(var4 = var5; var4 < var6; ++var4) {
         int var9 = var3[var4];
         if(!var7.contains(String.valueOf(var9))) {
            var8.add(String.valueOf(var9));
            c.b(var1, "HomeScreen_Small");
         }
      }

      if(var8.size() != var7.size()) {
         c.a(var1, "PanelWidgetSmallIdList", (List)var8);
      }

      super.onUpdate(var1, var2, var3);
   }
}
