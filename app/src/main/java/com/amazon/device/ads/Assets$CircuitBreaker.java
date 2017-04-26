package com.amazon.device.ads;

import com.amazon.device.ads.Assets;

class Assets$CircuitBreaker {
   boolean broken;
   // $FF: synthetic field
   final Assets this$0;

   Assets$CircuitBreaker(Assets var1) {
      this.this$0 = var1;
      this.broken = false;
   }

   // $FF: synthetic method
   static boolean access$000(Assets$CircuitBreaker var0) {
      return var0.isBroken();
   }

   // $FF: synthetic method
   static void access$100(Assets$CircuitBreaker var0) {
      var0.broken = true;
   }

   private void breakCircuit() {
      this.broken = true;
   }

   private boolean isBroken() {
      return this.broken;
   }
}
