package com.inmobi.commons.analytics.db;

public enum AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES {
   FAILED(1),
   PURCHASED(0),
   REFUNDED(2);

   private final int a;

   private AnalyticsEvent$TRANSACTION_STATUS_GOOGLE_API_VALUES(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
