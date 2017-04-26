package com.inmobi.monetization.internal;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Request$Format;
import com.inmobi.commons.network.Request$Method;
import com.inmobi.commons.network.Response;
import com.inmobi.commons.network.ServiceProvider;
import com.inmobi.commons.network.abstraction.INetworkListener;
import com.inmobi.monetization.internal.LtvpRuleProcessor$ActionsRule;
import com.inmobi.monetization.internal.objects.LtvpRuleCache;

public class LtvpRuleProcessor implements INetworkListener {
   private ServiceProvider a = ServiceProvider.getInstance();

   public static LtvpRuleProcessor getInstance() {
      return new LtvpRuleProcessor();
   }

   public void dispatchLtvpRule() {
      Log.internal("[InMobi]-[Monetization]", "Fetching LTVP Rule");
      Request var1 = new Request(AnalyticsInitializer.getConfigParams().getEndPoints().getRulesUrl(), Request$Format.KEY_VAL, Request$Method.GET);
      var1.fillAppInfo();
      var1.fillDeviceInfo();
      this.a.executeTask(var1, this);
   }

   public LtvpRuleProcessor$ActionsRule getLtvpRuleConfig(long var1) {
      LtvpRuleProcessor$ActionsRule.MEDIATION.getValue();
      LtvpRuleCache var4 = LtvpRuleCache.getInstance(InternalSDKUtil.getContext());
      if(var4.getHardExpiryForLtvpRule() > System.currentTimeMillis() && var4.getHardExpiryForLtvpRule() != 0L) {
         int var3;
         if(var4.getSoftExpiryForLtvpRule() <= System.currentTimeMillis()) {
            Log.internal("[InMobi]-[Monetization]", "Soft Expiry. Default mediation. Fetching Rule");
            this.dispatchLtvpRule();
            var3 = var4.getLtvpRule(var1);
         } else {
            Log.internal("[InMobi]-[Monetization]", "Valid rule");
            var3 = var4.getLtvpRule(var1);
         }

         return LtvpRuleProcessor$ActionsRule.a(var3);
      } else {
         Log.internal("[InMobi]-[Monetization]", "Hard Expiry or 1st rule fetch. Default mediation. Fetching Rule");
         this.dispatchLtvpRule();
         var4.clearLtvpRuleCache();
         return LtvpRuleProcessor$ActionsRule.MEDIATION;
      }
   }

   public void onRequestFailed(Request var1, Response var2) {
      try {
         Log.internal("[InMobi]-[Monetization]", "Ltvp Rule error" + var2.getError().toString());
      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Ltvp Rule exception", var3);
      }
   }

   public void onRequestSucceded(Request param1, Response param2) {
      // $FF: Couldn't be decompiled
   }
}
