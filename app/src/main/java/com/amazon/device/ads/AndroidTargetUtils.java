package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.ImageButton;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils$EclairTargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$FroyoTargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$GingerbreadTargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$HoneycombTargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$JellyBeanMR1TargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$JellyBeanTargetUtils;
import com.amazon.device.ads.AndroidTargetUtils$KitKatTargetUtils;
import com.amazon.device.ads.StringUtils;

class AndroidTargetUtils {
   private static boolean isWebViewCheckedAndOk = false;

   public static final void disableHardwareAcceleration(View var0) {
      AndroidTargetUtils$HoneycombTargetUtils.disableHardwareAcceleration(var0);
   }

   public static void editorApply(Editor var0) {
      AndroidTargetUtils$GingerbreadTargetUtils.editorApply(var0);
   }

   public static void enableHardwareAcceleration(Window var0) {
      if(isAtLeastAndroidAPI(11)) {
         AndroidTargetUtils$HoneycombTargetUtils.enableHardwareAcceleration(var0);
      }

   }

   public static void enableWebViewDebugging(boolean var0) {
      if(isAtLeastAndroidAPI(19)) {
         AndroidTargetUtils$KitKatTargetUtils.enableWebViewDebugging(var0);
      }

   }

   public static void executeAsyncTask(AsyncTask var0, Object... var1) {
      if(isAtLeastAndroidAPI(11)) {
         AndroidTargetUtils$HoneycombTargetUtils.executeAsyncTaskWithThreadPooling(var0, var1);
      } else {
         var0.execute(var1);
      }
   }

   public static BitmapDrawable getNewBitmapDrawable(Resources var0, String var1) {
      return isAtLeastAndroidAPI(5)?AndroidTargetUtils$EclairTargetUtils.getNewBitmapDrawable(var0, var1):new BitmapDrawable(var1);
   }

   public static int getOrientation(Display var0) {
      return isAtLeastAndroidAPI(8)?AndroidTargetUtils$FroyoTargetUtils.getRotation(var0):var0.getOrientation();
   }

   public static String getPackageCodePath(Context var0) {
      return AndroidTargetUtils$FroyoTargetUtils.getPackageCodePath(var0);
   }

   public static void hideActionAndStatusBars(Activity var0) {
      if(isAtLeastAndroidAPI(11)) {
         AndroidTargetUtils$HoneycombTargetUtils.hideActionBar(var0);
      }

      if(isAtLeastAndroidAPI(16)) {
         AndroidTargetUtils$JellyBeanTargetUtils.hideStatusBar(var0);
      }

   }

   public static boolean isAndroidAPI(int var0) {
      return VERSION.SDK_INT == var0;
   }

   public static boolean isAtLeastAndroidAPI(int var0) {
      return VERSION.SDK_INT >= var0;
   }

   public static boolean isAtLeastAndroidAPI(AndroidBuildInfo var0, int var1) {
      return var0.getSDKInt() >= var1;
   }

   public static boolean isAtOrBelowAndroidAPI(int var0) {
      return VERSION.SDK_INT <= var0;
   }

   public static boolean isBetweenAndroidAPIs(int var0, int var1) {
      return isAtLeastAndroidAPI(var0) && isAtOrBelowAndroidAPI(var1);
   }

   protected static boolean isDatabaseLocked(SQLiteException var0) {
      return isAtLeastAndroidAPI(11)?isInstanceOfSQLiteDatabaseLockedException(var0):StringUtils.doesExceptionContainLockedDatabaseMessage(var0);
   }

   public static boolean isInstanceOfSQLiteDatabaseLockedException(SQLiteException var0) {
      return AndroidTargetUtils$HoneycombTargetUtils.isInstanceOfSQLiteDatabaseLockedException(var0);
   }

   public static boolean isWebViewOk(Context var0) {
      if(isAtOrBelowAndroidAPI(8) && !isWebViewCheckedAndOk) {
         if(WebViewDatabase.getInstance(var0) == null) {
            return false;
         }

         SQLiteDatabase var6;
         try {
            var6 = var0.openOrCreateDatabase("webviewCache.db", 0, (CursorFactory)null);
         } catch (SQLiteException var4) {
            boolean var1 = isDatabaseLocked(var4);
            return var1;
         } finally {
            ;
         }

         if(var6 != null) {
            var6.close();
         }

         isWebViewCheckedAndOk = true;
      }

      return true;
   }

   public static void removeJavascriptInterface(WebView var0, String var1) {
      AndroidTargetUtils$HoneycombTargetUtils.removeJavascriptInterface(var0, var1);
   }

   public static void setBackgroundDrawable(View var0, Drawable var1) {
      if(isAtLeastAndroidAPI(16)) {
         AndroidTargetUtils$JellyBeanTargetUtils.setBackgroundForLinerLayout(var0, var1);
      } else {
         var0.setBackgroundDrawable(var1);
      }
   }

   public static void setImageButtonAlpha(ImageButton var0, int var1) {
      if(isAtLeastAndroidAPI(16)) {
         AndroidTargetUtils$JellyBeanTargetUtils.setImageButtonAlpha(var0, var1);
      } else {
         var0.setAlpha(var1);
      }
   }

   public static void webSettingsSetMediaPlaybackRequiresUserGesture(WebSettings var0, boolean var1) {
      if(isAtLeastAndroidAPI(17)) {
         AndroidTargetUtils$JellyBeanMR1TargetUtils.setMediaPlaybackRequiresUserGesture(var0, var1);
      }

   }
}
