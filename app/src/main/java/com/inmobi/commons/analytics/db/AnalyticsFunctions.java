package com.inmobi.commons.analytics.db;

import android.util.Log;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.db.AnalyticsFunctions$FunctionName;

public abstract class AnalyticsFunctions {
   private AnalyticsFunctions$FunctionName a = null;

   public AnalyticsFunctions$FunctionName getFunctionName() {
      return this.a;
   }

   protected void insertInDatabase(AnalyticsEvent var1) {
      try {
         AnalyticsDatabaseManager.getInstance().insertEvents(var1);
      } catch (Exception var2) {
         Log.w("[InMobi]-[Analytics]-4.5.2", var2);
      }
   }

   protected void printWarning(String var1) {
      Log.d("[InMobi]-[Analytics]-4.5.2", "IllegalStateException", new IllegalStateException(var1));
   }

   public abstract AnalyticsEvent processFunction();
}
