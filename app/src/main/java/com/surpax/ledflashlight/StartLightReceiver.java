package com.surpax.ledflashlight;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RemoteViews;
import com.surpax.ledflashlight.PanelWidget;

public class StartLightReceiver extends BroadcastReceiver {
   public Context a;
   private RemoteViews b;
   private AppWidgetManager c;
   private int[] d;
   private com.surpax.ledflashlight.a e = new com.surpax.ledflashlight.a(this, (byte)0);
   private Handler f = new Handler();

   public void onReceive(Context var1, Intent var2) {
      this.a = var1.getApplicationContext();
      Log.d("testwidgets", "startLight receive is invoked");
      this.b = new RemoteViews(var1.getPackageName(), 2130903045);
      this.c = AppWidgetManager.getInstance(var1);
      this.d = new int[]{2130837694, 2130837695, 2130837696, 2130837697, 2130837698, 2130837699};

      for(int var3 = 0; var3 < 6; ++var3) {
         this.b.setImageViewResource(2131492902, this.d[var3]);
         this.c.updateAppWidget(new ComponentName(var1, PanelWidget.class), this.b);
      }

      com.surpax.ledflashlight.c.d(var1, "HomeScreen_Small");
      this.f.postDelayed(this.e, 100L);
   }
}
