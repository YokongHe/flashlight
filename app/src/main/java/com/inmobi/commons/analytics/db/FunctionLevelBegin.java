package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsFunctions;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import java.util.Map;

public class FunctionLevelBegin extends AnalyticsFunctions {
   private Context a;
   private Map b;
   private int c;
   private String d;

   public FunctionLevelBegin(Context var1, int var2, String var3, Map var4) {
      this.a = var1;
      this.b = var4;
      this.c = var2;
      this.d = var3;
   }

   private AnalyticsEvent a() {
      if(SessionInfo.getSessionId(this.a) != null) {
         AnalyticsEvent var1 = new AnalyticsEvent("lb");
         var1.setEventLevelId(Integer.toString(this.c));
         var1.setEventLevelName(this.d);
         if(this.b != null) {
            var1.setEventAttributeMap(AnalyticsUtils.convertToJSON(this.b));
         }

         var1.setEventSessionId(SessionInfo.getSessionId(this.a));
         var1.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
         var1.setEventTimeStamp(System.currentTimeMillis() / 1000L);
         this.insertInDatabase(var1);
         return var1;
      } else {
         return null;
      }
   }

   protected Map getLbMap() {
      return this.b;
   }

   protected int getLevelId() {
      return this.c;
   }

   protected String getLevelName() {
      return this.d;
   }

   public AnalyticsEvent processFunction() {
      return this.a();
   }
}
