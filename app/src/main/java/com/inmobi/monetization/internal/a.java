package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.ErrorCode;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;

class a {
   private static com.inmobi.monetization.internal.a c = null;
   private ServiceProvider a = ServiceProvider.getInstance();
   private INetworkListener b;

   public static com.inmobi.monetization.internal.a a() {
      if(c == null) {
         c = new com.inmobi.monetization.internal.a();
      }

      return c;
   }

   public void a(String var1, com.inmobi.monetization.internal.c var2, INetworkListener var3) {
      this.b = var3;
      if(InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
         Log.internal("[InMobi]-[Monetization]", "Fetching  Ads");
         this.a.executeTask(var2, var3);
      } else if(this.b != null) {
         Response var4 = new Response(ErrorCode.NETWORK_ERROR);
         this.b.onRequestFailed(var2, var4);
         return;
      }

   }
}
