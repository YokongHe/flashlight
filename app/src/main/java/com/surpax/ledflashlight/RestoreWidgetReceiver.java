package com.surpax.ledflashlight;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import com.surpax.ledflashlight.PanelWidget;
import com.surpax.ledflashlight.PanelWidgetLarge;

public class RestoreWidgetReceiver extends BroadcastReceiver {
   private RemoteViews a;
   private int[] b;
   private AppWidgetManager c;

   public void onReceive(Context var1, Intent var2) {
      Log.d("testwidgets", "restorewidgetreceiver is invoked");
      this.a = new RemoteViews(var1.getPackageName(), 2130903045);
      this.c = AppWidgetManager.getInstance(var1.getApplicationContext());
      this.b = new int[]{2130837694, 2130837695, 2130837696, 2130837697, 2130837698, 2130837699};

      int var3;
      for(var3 = this.b.length - 1; var3 >= 0; --var3) {
         this.a.setImageViewResource(2131492902, this.b[var3]);
         this.c.updateAppWidget(new ComponentName(var1.getApplicationContext(), PanelWidget.class), this.a);
      }

      this.a = new RemoteViews(var1.getPackageName(), 2130903046);
      this.b = new int[]{2130837686, 2130837687, 2130837688, 2130837689};

      for(var3 = this.b.length - 1; var3 >= 0; --var3) {
         this.a.setImageViewResource(2131492902, this.b[var3]);
         this.c.updateAppWidget(new ComponentName(var1.getApplicationContext(), PanelWidgetLarge.class), this.a);
      }

   }
}
