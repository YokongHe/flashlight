package com.ihs.app.framework.a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class c extends BroadcastReceiver {
   // $FF: synthetic field
   final com.ihs.app.framework.a2.b a;

   private c(com.ihs.app.framework.a2.b var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   c(com.ihs.app.framework.a2.b var1, byte var2) {
      this(var1);
   }

   public final void onReceive(Context var1, Intent var2) {
      com.ihs.app.framework.a.b.a(this.a);
   }
}
