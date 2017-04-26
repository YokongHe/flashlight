package com.inmobi.commons.thinICE.wifi;

public final class WifiInfo {
   public long bssid;
   public int ip;
   public int rssi;
   public String ssid;

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[");
      var1.append("bssid=").append(this.bssid).append(", ");
      var1.append("ssid=").append(this.ssid).append(", ");
      var1.append("rssi=").append(this.rssi).append(", ");
      var1.append("ip=").append(String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(this.ip & 255), Integer.valueOf(this.ip >> 8 & 255), Integer.valueOf(this.ip >> 16 & 255), Integer.valueOf(this.ip >> 24 & 255)}));
      var1.append("]");
      return var1.toString();
   }
}
