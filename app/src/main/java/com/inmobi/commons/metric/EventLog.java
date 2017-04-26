package com.inmobi.commons.metric;

import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventType;
import org.json.JSONObject;

public class EventLog {
   private EventType a;
   private JSONObject b;

   public EventLog(EventType var1, JSONObject var2) {
      this.a = var1;
      this.b = var2;
   }

   public String toString() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("t", this.a.getValue());
         var1.put("v", this.b);
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "Unable to log json.", var3);
      }

      return var1.toString();
   }
}
