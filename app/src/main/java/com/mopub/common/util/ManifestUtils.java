package com.mopub.common.util;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions$NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.common.util.ManifestUtils$ActivityConfigChanges;
import com.mopub.common.util.ManifestUtils$FlagCheckUtil;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManifestUtils {
   private static final List REQUIRED_NATIVE_SDK_ACTIVITIES;
   private static final List REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
   private static ManifestUtils$FlagCheckUtil sFlagCheckUtil = new ManifestUtils$FlagCheckUtil();

   static {
      ArrayList var0 = new ArrayList(4);
      REQUIRED_WEB_VIEW_SDK_ACTIVITIES = var0;
      var0.add(MoPubActivity.class);
      REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MraidActivity.class);
      REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MraidVideoPlayerActivity.class);
      REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(MoPubBrowser.class);
      var0 = new ArrayList(1);
      REQUIRED_NATIVE_SDK_ACTIVITIES = var0;
      var0.add(MoPubBrowser.class);
   }

   public static void checkNativeActivitiesDeclared(Context var0) {
      if(Preconditions$NoThrow.checkNotNull(var0, "context is not allowed to be null")) {
         displayWarningForMissingActivities(var0, REQUIRED_NATIVE_SDK_ACTIVITIES);
         displayWarningForMisconfiguredActivities(var0, REQUIRED_NATIVE_SDK_ACTIVITIES);
      }
   }

   public static void checkWebViewActivitiesDeclared(Context var0) {
      if(Preconditions$NoThrow.checkNotNull(var0, "context is not allowed to be null")) {
         displayWarningForMissingActivities(var0, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
         displayWarningForMisconfiguredActivities(var0, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
      }
   }

   @VisibleForTesting
   static void displayWarningForMisconfiguredActivities(Context var0, List var1) {
      var1 = getMisconfiguredActivities(var0, filterDeclaredActivities(var0, var1, true));
      if(!var1.isEmpty()) {
         logWarningToast(var0);
         logMisconfiguredActivities(var0, var1);
      }
   }

   @VisibleForTesting
   static void displayWarningForMissingActivities(Context var0, List var1) {
      var1 = filterDeclaredActivities(var0, var1, false);
      if(!var1.isEmpty()) {
         logWarningToast(var0);
         logMissingActivities(var1);
      }
   }

   private static List filterDeclaredActivities(Context var0, List var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      Iterator var5 = var1.iterator();

      while(var5.hasNext()) {
         Class var4 = (Class)var5.next();
         if(Intents.deviceCanHandleIntent(var0, new Intent(var0, var4)) == var2) {
            var3.add(var4);
         }
      }

      return var3;
   }

   private static ManifestUtils$ActivityConfigChanges getActivityConfigChanges(Context var0, Class var1) {
      ActivityInfo var2 = var0.getPackageManager().getActivityInfo(new ComponentName(var0, var1.getName()), 0);
      ManifestUtils$ActivityConfigChanges var3 = new ManifestUtils$ActivityConfigChanges((ManifestUtils$ActivityConfigChanges)null);
      var3.hasKeyboardHidden = sFlagCheckUtil.hasFlag(var1, var2.configChanges, 32);
      var3.hasOrientation = sFlagCheckUtil.hasFlag(var1, var2.configChanges, 128);
      var3.hasScreenSize = true;
      if(VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB_MR2) && var0.getApplicationInfo().targetSdkVersion >= VersionCode.HONEYCOMB_MR2.getApiLevel()) {
         var3.hasScreenSize = sFlagCheckUtil.hasFlag(var1, var2.configChanges, 1024);
      }

      return var3;
   }

   @TargetApi(13)
   private static List getMisconfiguredActivities(Context var0, List var1) {
      ArrayList var2 = new ArrayList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         Class var3 = (Class)var6.next();

         ManifestUtils$ActivityConfigChanges var4;
         try {
            var4 = getActivityConfigChanges(var0, var3);
         } catch (NameNotFoundException var5) {
            continue;
         }

         if(!var4.hasKeyboardHidden || !var4.hasOrientation || !var4.hasScreenSize) {
            var2.add(var3);
         }
      }

      return var2;
   }

   @Deprecated
   @VisibleForTesting
   static List getRequiredNativeSdkActivities() {
      return REQUIRED_NATIVE_SDK_ACTIVITIES;
   }

   @Deprecated
   @VisibleForTesting
   static List getRequiredWebViewSdkActivities() {
      return REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
   }

   public static boolean isDebuggable(Context var0) {
      return Utils.bitMaskContainsFlag(var0.getApplicationInfo().flags, 2);
   }

   private static void logMisconfiguredActivities(Context var0, List var1) {
      StringBuilder var2 = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         Class var3 = (Class)var6.next();

         ManifestUtils$ActivityConfigChanges var4;
         try {
            var4 = getActivityConfigChanges(var0, var3);
         } catch (NameNotFoundException var5) {
            continue;
         }

         if(!var4.hasKeyboardHidden) {
            var2.append("\n\tThe android:configChanges param for activity " + var3.getName() + " must include keyboardHidden.");
         }

         if(!var4.hasOrientation) {
            var2.append("\n\tThe android:configChanges param for activity " + var3.getName() + " must include orientation.");
         }

         if(!var4.hasScreenSize) {
            var2.append("\n\tThe android:configChanges param for activity " + var3.getName() + " must include screenSize.");
         }
      }

      var2.append("\n\nPlease update your manifest to include them.");
      MoPubLog.w(var2.toString());
   }

   private static void logMissingActivities(List var0) {
      StringBuilder var1 = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
      Iterator var3 = var0.iterator();

      while(var3.hasNext()) {
         Class var2 = (Class)var3.next();
         var1.append("\n\t").append(var2.getName());
      }

      var1.append("\n\nPlease update your manifest to include them.");
      MoPubLog.w(var1.toString());
   }

   private static void logWarningToast(Context var0) {
      if(isDebuggable(var0)) {
         Toast var1 = Toast.makeText(var0, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
         var1.setGravity(7, 0, 0);
         var1.show();
      }

   }

   @Deprecated
   @VisibleForTesting
   static void setFlagCheckUtil(ManifestUtils$FlagCheckUtil var0) {
      sFlagCheckUtil = var0;
   }
}
