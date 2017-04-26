package com.inmobi.commons;

public enum InMobi$LOG_LEVEL {
   DEBUG(1),
   NONE(0),
   VERBOSE(2);

   private final int a;

   private InMobi$LOG_LEVEL(int var3) {
      this.a = var3;
   }

   public final int getValue() {
      return this.a;
   }
}
