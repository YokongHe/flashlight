package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;

@TargetApi(11)
class AndroidTargetUtils$HoneycombTargetUtils {
   public static final void disableHardwareAcceleration(View var0) {
      var0.setLayerType(1, (Paint)null);
   }

   protected static void enableHardwareAcceleration(Window var0) {
      var0.setFlags(16777216, 16777216);
   }

   protected static final void executeAsyncTaskWithThreadPooling(AsyncTask var0, Object... var1) {
      var0.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, var1);
   }

   protected static void hideActionBar(Activity var0) {
      ActionBar var1 = var0.getActionBar();
      if(var1 != null) {
         var1.hide();
      }

   }

   public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException var0) {
      return var0 instanceof SQLiteDatabaseLockedException;
   }

   protected static void removeJavascriptInterface(WebView var0, String var1) {
      var0.removeJavascriptInterface(var1);
   }
}
