package com.inmobi.commons.analytics.db;

public enum AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE {
   FAILED(2),
   INVALID(-1),
   PURCHASED(1),
   REFUNDED(4),
   RESTORED(3);

   private final int a;

   private AnalyticsEvent$TRANSACTION_STATUS_SERVER_CODE(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
