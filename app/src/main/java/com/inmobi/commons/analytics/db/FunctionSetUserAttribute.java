package com.inmobi.commons.analytics.db;

import android.content.Context;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsFunctions;
import com.inmobi.commons.analytics.util.SessionInfo;

public class FunctionSetUserAttribute extends AnalyticsFunctions {
   private Context a;
   private String b;
   private String c;

   public FunctionSetUserAttribute(Context var1, String var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private AnalyticsEvent a() {
      if(SessionInfo.getSessionId(this.a) != null && this.b != null && this.c != null && !"".equals(this.b.trim()) && !"".equals(this.c.trim())) {
         AnalyticsEvent var1 = new AnalyticsEvent("ae");
         var1.setUserAttribute(this.b, this.c);
         var1.setEventSessionId(SessionInfo.getSessionId(this.a));
         var1.setEventSessionTimeStamp(SessionInfo.getSessionTime(this.a));
         var1.setEventTimeStamp(System.currentTimeMillis() / 1000L);
         this.insertInDatabase(var1);
         return var1;
      } else {
         this.printWarning("Please call startSession before calling track User Attribute");
         return null;
      }
   }

   public AnalyticsEvent processFunction() {
      return this.a();
   }
}
