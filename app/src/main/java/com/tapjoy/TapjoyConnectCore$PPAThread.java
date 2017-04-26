package com.tapjoy;

import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyHttpURLResponse;
import java.util.Map;

public class TapjoyConnectCore$PPAThread implements Runnable {
   // $FF: synthetic field
   final TapjoyConnectCore a;
   private Map b;

   public TapjoyConnectCore$PPAThread(TapjoyConnectCore var1, Map var2) {
      this.a = var1;
      this.b = var2;
   }

   public void run() {
      TapjoyHttpURLResponse var1 = TapjoyConnectCore.d().getResponseFromURL(TapjoyConnectCore.getHostURL() + "api/connect/v3.json?", (Map)null, (Map)null, (Map)this.b);
      if(var1.response != null) {
         TapjoyConnectCore var2 = this.a;
         TapjoyConnectCore.c(var1.response);
      }

   }
}
