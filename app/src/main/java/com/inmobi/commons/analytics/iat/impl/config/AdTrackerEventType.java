package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.metric.EventType;

public enum AdTrackerEventType implements EventType {
   GOAL_DUMPED(2),
   GOAL_FAILURE(1),
   GOAL_SUCCESS(0);

   private int a;

   private AdTrackerEventType(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
