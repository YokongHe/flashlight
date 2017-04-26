package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyVideoView;

final class TapjoyVideoView$b extends BroadcastReceiver {
   // $FF: synthetic field
   final TapjoyVideoView a;

   private TapjoyVideoView$b(TapjoyVideoView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TapjoyVideoView$b(TapjoyVideoView var1, byte var2) {
      this(var1);
   }

   public final void onReceive(Context var1, Intent var2) {
      if(var2.getBooleanExtra("noConnectivity", false)) {
         TapjoyVideoView.d(this.a).pause();
         TapjoyVideoView.a(this.a, true);
         this.a.showDialog(1);
         TapjoyLog.i("VideoView", "No network connectivity during video playback");
      }

   }
}
