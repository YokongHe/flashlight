package com.nexage.android.a;

import android.telephony.TelephonyManager;

final class n {
   String a;

   private n() {
      this.a = ((TelephonyManager)com.nexage.android.a.m.b.getSystemService("phone")).getNetworkOperator();
      com.nexage.android.a.p.a("mccmnc=" + this.a);
   }

   // $FF: synthetic method
   n(byte var1) {
      this();
   }
}
