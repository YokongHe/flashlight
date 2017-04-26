package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsFunctions;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionEndSession extends AnalyticsFunctions {
   private Context a;
   private Map b;

   public FunctionEndSession(Context var1, Map var2) {
      this.a = var1;
      this.b = var2;
   }

   private AnalyticsEvent a() {
      if(SessionInfo.getSessionId(this.a) != null) {
         AnalyticsEvent var1 = new AnalyticsEvent("es");
         var1.setEventSessionId(SessionInfo.getSessionId(this.a));
         var1.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
         var1.setEventTimeStamp(System.currentTimeMillis() / 1000L);
         SessionInfo.removeSessionId(this.a);
         if(this.b != null) {
            var1.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.b));
         }

         this.insertInDatabase(var1);
         return var1;
      } else {
         return null;
      }
   }

   public AnalyticsEvent processFunction() {
      return this.a();
   }
}
