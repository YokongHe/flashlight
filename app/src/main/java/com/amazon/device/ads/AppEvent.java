package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class AppEvent {
   private final String eventName;
   private final HashMap properties;
   private final long timestamp;

   protected AppEvent(String var1) {
      this(var1, -1L);
   }

   public AppEvent(String var1, long var2) {
      this.eventName = var1;
      this.timestamp = var2;
      this.properties = new HashMap();
   }

   public static AppEvent createAppEventWithTimestamp(AppEvent var0, long var1) {
      return new AppEvent(var0.eventName, var1);
   }

   public String getEventName() {
      return this.eventName;
   }

   public String getProperty(String var1) {
      return (String)this.properties.get(var1);
   }

   public Set getPropertyEntries() {
      return this.properties.entrySet();
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public AppEvent setProperty(String var1, String var2) {
      this.properties.put(var1, var2);
      return this;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(65);
      var1.append("Application Event {Name: ");
      var1.append(this.eventName);
      var1.append(", Timestamp: ");
      var1.append(this.timestamp);
      Iterator var2 = this.properties.keySet().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.append(", ");
         var1.append(var3);
         var1.append(": ");
         var1.append((String)this.properties.get(var3));
      }

      var1.append("}");
      return var1.toString();
   }
}
