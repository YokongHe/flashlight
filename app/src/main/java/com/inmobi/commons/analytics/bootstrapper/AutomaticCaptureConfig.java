package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class AutomaticCaptureConfig {
   private boolean a = true;
   private boolean b = false;
   private boolean c = false;

   public boolean isAutoLocationCaptureEnabled() {
      return this.c;
   }

   public boolean isAutoPurchaseCaptureEnabled() {
      return this.b;
   }

   public boolean isAutoSessionCaptureEnabled() {
      return this.a;
   }

   public void setFromMap(Map var1) {
      this.a = InternalSDKUtil.getBooleanFromMap(var1, "session");
      this.b = InternalSDKUtil.getBooleanFromMap(var1, "purchase");
      this.c = InternalSDKUtil.getBooleanFromMap(var1, "location");
   }
}
