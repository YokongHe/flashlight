package com.tapjoy;

import com.tapjoy.TapjoyVideoView;
import java.util.TimerTask;

final class TapjoyVideoView$a extends TimerTask {
   // $FF: synthetic field
   final TapjoyVideoView a;

   private TapjoyVideoView$a(TapjoyVideoView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TapjoyVideoView$a(TapjoyVideoView var1, byte var2) {
      this(var1);
   }

   public final void run() {
      this.a.c.post(this.a.d);
   }
}
