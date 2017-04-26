package org.nexage.sourcekit.mraid.internal;

public enum MRAIDLog$LOG_LEVEL {
   debug(2),
   error(5),
   info(3),
   none(6),
   verbose(1),
   warning(4);

   private int value;

   private MRAIDLog$LOG_LEVEL(int var3) {
      this.value = var3;
   }

   public final int getValue() {
      return this.value;
   }
}
