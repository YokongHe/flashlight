package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.metric.EventType;

public enum NetworkEventType implements EventType {
   CONNECT_ERROR(2),
   FETCH_COMPLETE(0),
   RENDER_COMPLETE(1),
   RENDER_TIMEOUT(4),
   RESPONSE_ERROR(3);

   private int a;

   private NetworkEventType(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
