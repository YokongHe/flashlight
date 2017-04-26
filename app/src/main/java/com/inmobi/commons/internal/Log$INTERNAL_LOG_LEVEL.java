package com.inmobi.commons.internal;

public enum Log$INTERNAL_LOG_LEVEL {
   DEBUG(1),
   INTERNAL(3),
   NONE(0),
   NOT_SET(-1),
   VERBOSE(2);

   private final int a;

   private Log$INTERNAL_LOG_LEVEL(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
