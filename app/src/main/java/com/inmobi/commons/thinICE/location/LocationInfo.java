package com.inmobi.commons.thinICE.location;

public final class LocationInfo {
   public float accuracy;
   public double latitude;
   public double longitude;
   public String provider;
   public long time;

   public final String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.getClass().getSimpleName()).append("[");
      var1.append("time=").append(this.time).append(", ");
      var1.append("provider=").append(this.provider).append(", ");
      var1.append("latitude=").append(this.latitude).append(", ");
      var1.append("longitude=").append(this.longitude).append(", ");
      var1.append("accuracy=").append(this.accuracy);
      var1.append("]");
      return var1.toString();
   }
}
