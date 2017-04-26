package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsFunctions;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionStartSession extends AnalyticsFunctions {
   private Context a;
   private String b;
   private Map c;

   public FunctionStartSession(Context var1, String var2, Map var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private AnalyticsEvent a() {
      if(SessionInfo.getSessionId(this.a) == null) {
         SessionInfo.storeAppId(this.a, this.b);
         SessionInfo.storeSessionId(this.a);
         SessionInfo.storeFirstTime(this.a);
         AnalyticsEvent var1 = new AnalyticsEvent("ss");
         if(this.c != null) {
            var1.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.c));
         }

         var1.setEventSessionId(SessionInfo.getSessionId(this.a));
         var1.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
         var1.setEventTimeStamp(SessionInfo.getSessionTime(this.a));
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
