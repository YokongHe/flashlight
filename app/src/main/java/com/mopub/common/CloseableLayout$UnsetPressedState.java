package com.mopub.common;

import com.mopub.common.CloseableLayout;

final class CloseableLayout$UnsetPressedState implements Runnable {
   // $FF: synthetic field
   final CloseableLayout this$0;

   private CloseableLayout$UnsetPressedState(CloseableLayout var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   CloseableLayout$UnsetPressedState(CloseableLayout var1, CloseableLayout$UnsetPressedState var2) {
      this(var1);
   }

   public final void run() {
      CloseableLayout.access$0(this.this$0, false);
   }
}
