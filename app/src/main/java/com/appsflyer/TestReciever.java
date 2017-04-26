package com.appsflyer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestReciever extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      Log.i("AppsFlyer_1.5.2", "test dummy receiver - in onReceive");

      try {
         Thread.sleep(2000L);
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      }
   }
}
