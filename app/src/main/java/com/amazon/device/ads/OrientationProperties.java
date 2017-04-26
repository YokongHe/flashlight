package com.amazon.device.ads;

import com.amazon.device.ads.ForceOrientation;
import java.util.Locale;

class OrientationProperties {
   private static final String FORMAT = "{\"allowOrientationChange\":%s,\"forceOrientation\":\"%s\"}";
   private Boolean allowOrientationChange = Boolean.valueOf(true);
   private ForceOrientation forceOrientation;

   OrientationProperties() {
      this.forceOrientation = ForceOrientation.NONE;
   }

   public ForceOrientation getForceOrientation() {
      return this.forceOrientation;
   }

   public Boolean isAllowOrientationChange() {
      return this.allowOrientationChange;
   }

   public void setAllowOrientationChange(Boolean var1) {
      this.allowOrientationChange = var1;
   }

   public void setForceOrientation(ForceOrientation var1) {
      this.forceOrientation = var1;
   }

   public String toString() {
      return String.format(Locale.US, "{\"allowOrientationChange\":%s,\"forceOrientation\":\"%s\"}", new Object[]{this.allowOrientationChange.toString(), this.forceOrientation.toString()});
   }
}
