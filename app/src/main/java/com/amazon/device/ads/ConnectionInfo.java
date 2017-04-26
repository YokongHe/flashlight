package com.amazon.device.ads;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;

class ConnectionInfo {
   private static final String LOG_TAG = ConnectionInfo.class.getSimpleName();
   private static final String WIFI_NAME = "Wifi";
   private String connectionType;
   private ConnectivityManager connectivityManager;

   public ConnectionInfo() {
      this.initialize((ConnectivityManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("connectivity"));
   }

   ConnectionInfo(ConnectivityManager var1) {
      this.initialize(var1);
   }

   private void generateConnectionType() {
      Object var2 = null;
      NetworkInfo var1 = (NetworkInfo)var2;

      try {
         if(this.connectivityManager != null) {
            var1 = this.connectivityManager.getActiveNetworkInfo();
         }
      } catch (SecurityException var3) {
         Log.d(LOG_TAG, "Unable to get active network information: %s", new Object[]{var3});
         var1 = (NetworkInfo)var2;
      }

      if(var1 != null) {
         if(var1.getType() == 1) {
            this.connectionType = "Wifi";
         } else {
            this.connectionType = Integer.toString(var1.getSubtype());
         }
      } else {
         this.connectionType = Integer.toString(0);
      }
   }

   private void initialize(ConnectivityManager var1) {
      this.connectivityManager = var1;
      this.refresh();
   }

   public String getConnectionType() {
      return this.connectionType;
   }

   public boolean isWiFi() {
      return "Wifi".equals(this.getConnectionType());
   }

   public void refresh() {
      this.generateConnectionType();
   }
}
