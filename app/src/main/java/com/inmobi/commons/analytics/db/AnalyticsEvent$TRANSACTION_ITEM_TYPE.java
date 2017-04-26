package com.inmobi.commons.analytics.db;

public enum AnalyticsEvent$TRANSACTION_ITEM_TYPE {
   INAPP(1),
   INVALID(-1),
   SUBSCRIPTION(2);

   private final int a;

   private AnalyticsEvent$TRANSACTION_ITEM_TYPE(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
