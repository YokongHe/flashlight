package com.inmobi.commons.analytics.iat.impl;

import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class AdTrackerUtils {
   public static boolean checkDownloadGoalAdded() {
      if(InternalSDKUtil.getContext() == null) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Application Context NULL cannot checkStatusUpload");
         return false;
      } else {
         return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "insertStatus");
      }
   }

   public static boolean checkDownloadGoalUploaded() {
      if(InternalSDKUtil.getContext() == null) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Application Context NULL cannot checkStatusUpload");
         return false;
      } else {
         return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus");
      }
   }

   public static String getReferrerFromLogs() {
      // $FF: Couldn't be decompiled
   }

   public static boolean isPermissionGranted(String var0) {
      int var1;
      try {
         var1 = InternalSDKUtil.getContext().checkCallingOrSelfPermission(var0);
      } catch (Exception var2) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Cant check permissions", var2);
         return false;
      }

      if(var1 == 0) {
         return true;
      } else {
         return false;
      }
   }

   public static void reportMetric(AdTrackerEventType param0, Goal param1, int param2, long param3, int param5, String param6) {
      // $FF: Couldn't be decompiled
   }

   public static boolean resetStatus() {
      if(InternalSDKUtil.getContext() == null) {
         return false;
      } else {
         FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", false);
         return true;
      }
   }

   public static boolean sendBroadcastMessage(int var0) {
      try {
         Intent var1 = new Intent();
         var1.setAction("action.inmobi.ADTRACKER");
         var1.putExtra("iatError", var0);
         InternalSDKUtil.getContext().sendBroadcast(var1);
         return true;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Cant send test broadcast", var2);
         return false;
      }
   }

   public static void setInternalReferrer(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void setReferrerFromLogs(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static boolean updateStatus() {
      if(InternalSDKUtil.getContext() == null) {
         return false;
      } else {
         FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "uploadStatus", true);
         return true;
      }
   }
}
