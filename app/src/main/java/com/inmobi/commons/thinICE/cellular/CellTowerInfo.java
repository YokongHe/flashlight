package com.inmobi.commons.thinICE.cellular;

public final class CellTowerInfo {
   public String id;
   public int signalStrength;

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[");
      var1.append("id=").append(this.id).append(", ");
      var1.append("ss=").append(this.signalStrength).append(", ");
      var1.append("]");
      return var1.toString();
   }
}
