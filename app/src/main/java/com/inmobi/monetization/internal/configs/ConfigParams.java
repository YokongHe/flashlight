package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UIDMapConfigParams;
import com.inmobi.monetization.internal.configs.IMAIConfigParams;
import com.inmobi.monetization.internal.configs.NativeConfigParams;
import com.inmobi.monetization.internal.configs.PlayableAdsConfigParams;
import java.util.Map;

public class ConfigParams {
   int a = 20;
   int b = 60;
   int c = 60;
   int d = 60;
   IMAIConfigParams e = new IMAIConfigParams();
   MetricConfigParams f = new MetricConfigParams();
   NativeConfigParams g = new NativeConfigParams();
   PlayableAdsConfigParams h = new PlayableAdsConfigParams();
   private UIDMapConfigParams i = new UIDMapConfigParams();

   public int getDefaultRefreshRate() {
      return this.b;
   }

   public Map getDeviceIdMaskMap() {
      return this.i.getMap();
   }

   public int getFetchTimeOut() {
      return this.c * 1000;
   }

   public IMAIConfigParams getImai() {
      return this.e;
   }

   public MetricConfigParams getMetric() {
      return this.f;
   }

   public int getMinimumRefreshRate() {
      return this.a;
   }

   public NativeConfigParams getNativeSdkConfigParams() {
      return this.g;
   }

   public PlayableAdsConfigParams getPlayableConfigParams() {
      return this.h;
   }

   public int getRenderTimeOut() {
      return this.d * 1000;
   }

   public void setFromMap(Map var1) {
      this.a = InternalSDKUtil.getIntFromMap(var1, "mrr", 1, 2147483647L);
      this.b = InternalSDKUtil.getIntFromMap(var1, "drr", -1, 2147483647L);
      this.c = InternalSDKUtil.getIntFromMap(var1, "fto", 1, 2147483647L);
      this.d = InternalSDKUtil.getIntFromMap(var1, "rto", 1, 2147483647L);
      this.e.setFromMap((Map)var1.get("imai"));
      this.f.setFromMap((Map)var1.get("metric"));
      this.i.setMap(InternalSDKUtil.getObjectFromMap(var1, "ids"));
      this.g.setFromMap((Map)var1.get("native"));
      this.h.setFromMap((Map)var1.get("playable"));
   }
}
