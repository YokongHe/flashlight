package com.tapjoy;

import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import java.util.TimerTask;

final class TapjoyConnectCore$a extends TimerTask {
   // $FF: synthetic field
   final TapjoyConnectCore a;

   private TapjoyConnectCore$a(TapjoyConnectCore var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   TapjoyConnectCore$a(TapjoyConnectCore var1, byte var2) {
      this(var1);
   }

   public final void run() {
      TapjoyConnectCore.c(this.a);
      TapjoyLog.i("TapjoyConnect", "elapsed_time: " + TapjoyConnectCore.d(this.a) + " (" + TapjoyConnectCore.d(this.a) / 1000L / 60L + "m " + TapjoyConnectCore.d(this.a) / 1000L % 60L + "s)");
      Editor var1 = TapjoyConnectCore.b().getSharedPreferences("tjcPrefrences", 0).edit();
      var1.putLong("tapjoy_elapsed_time", TapjoyConnectCore.d(this.a));
      var1.commit();
      if(TapjoyConnectCore.d(this.a) >= 900000L) {
         TapjoyLog.i("TapjoyConnect", "timer done...");
         if(TapjoyConnectCore.c() != null && TapjoyConnectCore.c().length() > 0) {
            TapjoyLog.i("TapjoyConnect", "Calling PPA actionComplete...");
            this.a.actionComplete(TapjoyConnectCore.c());
         }

         this.cancel();
      }

   }
}
