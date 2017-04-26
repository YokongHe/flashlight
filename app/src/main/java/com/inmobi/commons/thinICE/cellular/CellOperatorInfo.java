package com.inmobi.commons.thinICE.cellular;

public final class CellOperatorInfo {
   public static final int MCC_NOT_AVAILABLE = -1;
   public static final int MNC_NOT_AVAILABLE = -1;
   public int currentMcc;
   public int currentMnc;
   public int simMcc;
   public int simMnc;

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[");
      var1.append("currentMcc=").append(this.currentMcc).append(", ");
      var1.append("currentMnc=").append(this.currentMnc).append(", ");
      var1.append("simMcc=").append(this.simMcc).append(", ");
      var1.append("simMnc=").append(this.simMnc);
      var1.append("]");
      return var1.toString();
   }
}
