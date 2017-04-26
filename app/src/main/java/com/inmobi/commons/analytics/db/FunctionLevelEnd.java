package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.FunctionLevelBegin;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper$IMSectionStatus;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionLevelEnd extends FunctionLevelBegin {
   private AnalyticsEventsWrapper$IMSectionStatus a;
   private Context b;

   public FunctionLevelEnd(Context var1, int var2, String var3, AnalyticsEventsWrapper$IMSectionStatus var4, Map var5) {
      super(var1, var2, var3, var5);
      this.b = var1;
      this.a = var4;
   }

   private AnalyticsEvent a() {
      if(SessionInfo.getSessionId(this.b) != null) {
         AnalyticsEvent var1 = new AnalyticsEvent("le");
         var1.setEventLevelId(Integer.toString(this.getLevelId()));
         var1.setEventLevelName(this.getLevelName());
         if(this.getLbMap() != null) {
            var1.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.getLbMap()));
         }

         var1.setEventLevelStatus("1");
         var1.setEventSessionId(SessionInfo.getSessionId(this.b));
         var1.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.b));
         var1.setEventTimeStamp(System.currentTimeMillis() / 1000L);
         this.insertInDatabase(var1);
         return var1;
      } else {
         this.printWarning("Please call startSession before calling levelEnd");
         return null;
      }
   }

   protected AnalyticsEventsWrapper$IMSectionStatus getLevelStatus() {
      return this.a;
   }

   public AnalyticsEvent processFunction() {
      return this.a();
   }
}
