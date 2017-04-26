package com.inmobi.commons.thinICE.icedatacollector;

import com.inmobi.commons.thinICE.cellular.CellOperatorInfo;
import com.inmobi.commons.thinICE.cellular.CellTowerInfo;
import com.inmobi.commons.thinICE.location.LocationInfo;
import com.inmobi.commons.thinICE.wifi.WifiInfo;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class Sample {
   public CellOperatorInfo cellOperator;
   public CellTowerInfo connectedCellTowerInfo;
   public WifiInfo connectedWifiAp;
   public HashMap lastKnownLocations;
   public long utc;
   public List visibleCellTowerInfo;
   public List visibleWifiAp;
   public int zoneOffset;

   Sample() {
      Calendar var2 = Calendar.getInstance();
      this.utc = var2.getTimeInMillis();
      int var1 = var2.get(15);
      this.zoneOffset = var2.get(16) + var1;
   }

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[\n");
      var1.append("-- utc: ").append(this.utc).append("\n");
      var1.append("-- zoneOffset: ").append(this.zoneOffset).append("\n");
      var1.append("-- cell operator: ").append(this.cellOperator).append("\n");
      var1.append("-- connected wifi access point: ").append(this.connectedWifiAp).append("\n");
      var1.append("-- last known locations:");
      Iterator var2;
      if(this.lastKnownLocations == null) {
         var1.append(" null\n");
      } else {
         var1.append("\n");
         var2 = this.lastKnownLocations.values().iterator();

         while(var2.hasNext()) {
            LocationInfo var3 = (LocationInfo)var2.next();
            var1.append("   + ").append(var3).append("\n");
         }
      }

      var1.append("-- visible wifi aps:");
      if(this.visibleWifiAp == null) {
         var1.append(" null\n");
      } else {
         var1.append("\n");
         var2 = this.visibleWifiAp.iterator();

         while(var2.hasNext()) {
            WifiInfo var4 = (WifiInfo)var2.next();
            var1.append("   + ").append(var4).append("\n");
         }
      }

      var1.append("-- connected serving cell tower: ").append(this.connectedCellTowerInfo).append("\n");
      var1.append("]");
      return var1.toString();
   }
}
