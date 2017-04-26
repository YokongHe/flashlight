package com.inmobi.commons.internal;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.Log$INTERNAL_LOG_LEVEL;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

public class CommonsConfig {
   private static Log$INTERNAL_LOG_LEVEL a;
   private static Log$INTERNAL_LOG_LEVEL b;
   private MetricConfigParams c = new MetricConfigParams();

   static {
      Log$INTERNAL_LOG_LEVEL var0 = Log$INTERNAL_LOG_LEVEL.NONE;
      a = var0;
      b = var0;
   }

   protected static int getLogLevelConfig() {
      return b.getValue();
   }

   public MetricConfigParams getApiStatsConfig() {
      return this.c;
   }

   public final void setFromMap(Map var1) {
      var1 = InternalSDKUtil.populateToNewMap((Map)var1.get("AND"), (Map)var1.get("common"), true);
      UIDMapConfigParams var2 = new UIDMapConfigParams();
      var2.setMap(InternalSDKUtil.getObjectFromMap(var1, "ids"));
      UID.getInstance().setCommonsDeviceIdMaskMap(var2.getMap());
      b = Log.getLogLevelValue((long)InternalSDKUtil.getIntFromMap(var1, "ll", 0, 2L));
      this.c.setFromMap((Map)var1.get("api"));
   }
}
