package com.adsdk.sdk.mraid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.adsdk.sdk.mraid.MraidVideoPlayerActivity;
import com.adsdk.sdk.mraid.Utils;
import com.adsdk.sdk.mraid.VersionCode;

public class Mraids {
   public static final String ANDROID_CALENDAR_CONTENT_TYPE = "vnd.android.cursor.item/event";

   public static boolean isCalendarAvailable(Context var0) {
      Intent var1 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
      return VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH) && Utils.deviceCanHandleIntent(var0, var1);
   }

   public static boolean isInlineVideoAvailable(Context var0) {
      return Utils.deviceCanHandleIntent(var0, new Intent(var0, MraidVideoPlayerActivity.class));
   }

   public static boolean isSmsAvailable(Context var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse("sms:"));
      return Utils.deviceCanHandleIntent(var0, var1);
   }

   public static boolean isStorePictureSupported(Context var0) {
      return "mounted".equals(Environment.getExternalStorageState()) && var0.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
   }

   public static boolean isTelAvailable(Context var0) {
      Intent var1 = new Intent("android.intent.action.DIAL");
      var1.setData(Uri.parse("tel:"));
      return Utils.deviceCanHandleIntent(var0, var1);
   }
}
