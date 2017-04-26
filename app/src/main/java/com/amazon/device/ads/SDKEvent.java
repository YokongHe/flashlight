package com.amazon.device.ads;

import com.amazon.device.ads.SDKEvent$SDKEventType;
import java.util.HashMap;
import java.util.Set;

class SDKEvent {
   public static final String BRIDGE_NAME = "bridgeName";
   private final SDKEvent$SDKEventType eventType;
   private final HashMap parameters = new HashMap();

   public SDKEvent(SDKEvent$SDKEventType var1) {
      this.eventType = var1;
   }

   public SDKEvent$SDKEventType getEventType() {
      return this.eventType;
   }

   public String getParameter(String var1) {
      return (String)this.parameters.get(var1);
   }

   public Set getParameterNames() {
      return this.parameters.keySet();
   }

   public SDKEvent setParameter(String var1, String var2) {
      this.parameters.put(var1, var2);
      return this;
   }
}
