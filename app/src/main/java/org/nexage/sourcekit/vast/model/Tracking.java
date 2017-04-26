package org.nexage.sourcekit.vast.model;

import org.nexage.sourcekit.vast.model.TRACKING_EVENTS_TYPE;

public class Tracking {
   private TRACKING_EVENTS_TYPE event;
   private String value;

   public TRACKING_EVENTS_TYPE getEvent() {
      return this.event;
   }

   public String getValue() {
      return this.value;
   }

   public void setEvent(TRACKING_EVENTS_TYPE var1) {
      this.event = var1;
   }

   public void setValue(String var1) {
      this.value = var1;
   }

   public String toString() {
      return "Tracking [event=" + this.event + ", value=" + this.value + "]";
   }
}
