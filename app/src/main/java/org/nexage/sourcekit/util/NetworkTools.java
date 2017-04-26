package org.nexage.sourcekit.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import org.nexage.sourcekit.util.HttpTools;
import org.nexage.sourcekit.util.VASTLog;

public class NetworkTools {
   private static final String TAG = HttpTools.class.getName();

   public static boolean connectedToInternet(Context var0) {
      VASTLog.d(TAG, "Testing connectivity:");
      ConnectivityManager var2 = (ConnectivityManager)var0.getSystemService("connectivity");
      NetworkInfo var1 = var2.getNetworkInfo(1);
      if(var1 != null && var1.isConnected()) {
         VASTLog.d(TAG, "Connected to Internet");
         return true;
      } else {
         var1 = var2.getNetworkInfo(0);
         if(var1 != null && var1.isConnected()) {
            VASTLog.d(TAG, "Connected to Internet");
            return true;
         } else {
            NetworkInfo var3 = var2.getActiveNetworkInfo();
            if(var3 != null && var3.isConnected()) {
               VASTLog.d(TAG, "Connected to Internet");
               return true;
            } else {
               VASTLog.d(TAG, "No Internet connection");
               return false;
            }
         }
      }
   }
}
