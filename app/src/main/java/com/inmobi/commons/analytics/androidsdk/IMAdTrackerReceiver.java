package com.inmobi.commons.analytics.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.net.URLEncoder;

public class IMAdTrackerReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      if(var1 == null) {
         Log.debug("[InMobi]-4.5.2", "Application Context NULL");
         Log.debug("[InMobi]-4.5.2", "context cannot be null");
      } else {
         if(var2.getAction().equals("com.android.vending.INSTALL_REFERRER")) {
            try {
               Log.debug("[InMobi]-[AdTracker]-4.5.2", "Received INSTALL REFERRER");
               String var14 = var2.getExtras().getString("referrer");
               Log.debug("[InMobi]-[AdTracker]-4.5.2", "Referrer String: " + var14);
               FileOperations.setPreferences(var1.getApplicationContext(), "IMAdTrackerStatusUpload", "rfs", 1);
               var14 = URLEncoder.encode(var14, "utf-8");
               AdTrackerUtils.setInternalReferrer(var1.getApplicationContext(), var14);
               return;
            } catch (Exception var12) {
               Log.internal("[InMobi]-[AdTracker]-4.5.2", "Error install receiver", var12);
               return;
            }
         }

         if(var2.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") && InternalSDKUtil.checkNetworkAvailibility(var1)) {
            try {
               Log.internal("[InMobi]-[AdTracker]-4.5.2", "Received CONNECTIVITY BROADCAST");
               AdTrackerNetworkInterface.init();
               AdTrackerNetworkInterface.reportToServer(FileOperations.getPreferences(var1.getApplicationContext(), "IMAdTrackerStatusUpload", "mk-siteid"));
               return;
            } catch (Exception var13) {
               Log.internal("[InMobi]-[AdTracker]-4.5.2", "Connectivity receiver exception", var13);
               return;
            }
         }

         if(var2.getAction().equals("com.inmobi.share.id")) {
            String var10 = var2.getExtras().getString("AID");
            String var7 = FileOperations.getPreferences(var1, "impref", "IMID");
            String var11 = var2.getExtras().getString("IMID");
            String var8 = FileOperations.getPreferences(var1, "impref", "AIDL");
            String var9 = var2.getExtras().getString("AIDL");
            long var3 = FileOperations.getLongPreferences(var1, "impref", "timestamp");
            long var5 = var2.getExtras().getLong("timestamp");
            if(var8 != null && var10 != null) {
               if(!var8.contains(var10)) {
                  if(var5 < var3) {
                     FileOperations.setPreferences(var1, "impref", "IMID", var11);
                  }

                  var2 = new Intent();
                  var2.setAction("com.inmobi.share.id");
                  var2.putExtra("IMID", var7);
                  var2.putExtra("AIDL", var8);
                  var2.putExtra("timestamp", var3);
                  var2.putExtra("AID", DeviceInfo.getAid());
                  var1.sendBroadcast(var2);
               }

               FileOperations.setPreferences(var1, "impref", "AIDL", InternalSDKUtil.union(var9, var8));
               return;
            }
         }
      }

   }
}
