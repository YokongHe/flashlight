package com.inmobi.commons.analytics.iat.impl.config;

import com.inmobi.commons.analytics.iat.impl.config.AdTrackerGoalRetryParams;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.metric.MetricConfigParams;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

public class AdTrackerConfigParams {
   private static final String a = "Starting.*: Intent.*(?:http://market.android.com/details|market://details|play.google.com).*(?:id=" + InternalSDKUtil.getContext().getPackageName() + ").*referrer=([^&\\s]+)";
   private int b = 60;
   private int c = 300;
   private String d;
   private AdTrackerGoalRetryParams e;
   private MetricConfigParams f;
   private UIDMapConfigParams g;

   public AdTrackerConfigParams() {
      this.d = a;
      this.e = new AdTrackerGoalRetryParams();
      this.f = new MetricConfigParams();
      this.g = new UIDMapConfigParams();
   }

   public int getConnectionTimeout() {
      return this.b * 1000;
   }

   public Map getDeviceIdMaskMap() {
      return this.g.getMap();
   }

   public String getLogcatPattern() {
      return this.d;
   }

   public MetricConfigParams getMetric() {
      return this.f;
   }

   public int getReferrerWaitTime() {
      return 300000;
   }

   public int getReferrerWaitTimeRetryCount() {
      return 3;
   }

   public int getReferrerWaitTimeRetryInterval() {
      return 5000;
   }

   public AdTrackerGoalRetryParams getRetryParams() {
      return this.e;
   }

   public int getWebviewTimeout() {
      return this.c * 1000;
   }

   public void setFromMap(Map var1) {
      this.b = InternalSDKUtil.getIntFromMap(var1, "cto", 1, 2147483647L);
      this.c = InternalSDKUtil.getIntFromMap(var1, "wto", 1, 2147483647L);
      this.d = InternalSDKUtil.getStringFromMap(var1, "rlp").replace("$PKG", InternalSDKUtil.getContext().getPackageName());
      this.e.setFromMap((Map)var1.get("rp"));
      this.f.setFromMap((Map)var1.get("metric"));
      this.g.setMap(InternalSDKUtil.getObjectFromMap(var1, "ids"));
   }
}
