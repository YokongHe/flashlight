package com.inmobi.commons.analytics.bootstrapper;

import com.inmobi.commons.analytics.bootstrapper.AnalyticsEndPointsConfig;
import com.inmobi.commons.analytics.bootstrapper.AutomaticCaptureConfig;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.uid.UID;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

public class AnalyticsConfigParams {
   private static final Long a = null;
   private UIDMapConfigParams b = new UIDMapConfigParams();
   private AnalyticsEndPointsConfig c = new AnalyticsEndPointsConfig();
   private ThinICEConfig d = new ThinICEConfig();
   private Long e;
   private int f;
   private int g;
   private int h;
   private int i;
   private int j;
   private int k;
   private int l;
   private int m;
   private AutomaticCaptureConfig n;
   private int o;

   public AnalyticsConfigParams() {
      this.e = a;
      this.f = 5;
      this.g = 1000;
      this.h = 100;
      this.i = 30;
      this.j = 20;
      this.k = 50;
      this.l = 100;
      this.m = 5;
      this.n = new AutomaticCaptureConfig();
      this.o = 100;
   }

   public AutomaticCaptureConfig getAutomaticCapture() {
      return this.n;
   }

   public Map getDeviceIdMaskMap() {
      return this.b.getMap();
   }

   public AnalyticsEndPointsConfig getEndPoints() {
      return this.c;
   }

   public int getExtraParamsLimit() {
      return this.l;
   }

   public int getGetParamsLimit() {
      return this.h;
   }

   public Long getLTVId() {
      this.e = Long.valueOf(FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "impref", "ltvid"));
      return 0L == this.e.longValue()?null:this.e;
   }

   public int getMaxAppIdLength() {
      return this.o;
   }

   public int getMaxDbEvents() {
      return this.g;
   }

   public int getMaxKeyLength() {
      return this.j;
   }

   public int getMaxRetryBeforeCacheDiscard() {
      return this.m;
   }

   public int getMaxValLength() {
      return this.k;
   }

   public int getMinEventsToCompress() {
      return this.f;
   }

   public int getPingInterval() {
      return this.i * 1000;
   }

   public ThinICEConfig getThinIceConfig() {
      return this.d;
   }

   public void setFromMap(Map var1) {
      this.h = InternalSDKUtil.getIntFromMap(var1, "elim", 1, 2147483647L);
      this.g = InternalSDKUtil.getIntFromMap(var1, "mdb", 1, 2147483647L);
      this.j = InternalSDKUtil.getIntFromMap(var1, "mkey", 1, 2147483647L);
      this.k = InternalSDKUtil.getIntFromMap(var1, "mval", 1, 2147483647L);
      this.i = InternalSDKUtil.getIntFromMap(var1, "pint", 1, 2147483647L);
      this.l = InternalSDKUtil.getIntFromMap(var1, "plim", 1, 2147483647L);
      this.e = Long.valueOf(InternalSDKUtil.getLongFromMap(var1, "ltvid", Long.MIN_VALUE, Long.MAX_VALUE));
      UID.getInstance().setLtvId("" + this.e);
      FileOperations.setPreferences(InternalSDKUtil.getContext(), "impref", "ltvid", this.e.longValue());
      this.f = InternalSDKUtil.getIntFromMap(var1, "mec", 1, 2147483647L);
      this.m = InternalSDKUtil.getIntFromMap(var1, "mr", 0, 2147483647L);
      this.o = InternalSDKUtil.getIntFromMap(var1, "aidl", 1, 2147483647L);
      this.b.setMap(InternalSDKUtil.getObjectFromMap(var1, "ids"));
      this.c.setFromMap((Map)var1.get("endpoints"));
      this.d.setFromMap((Map)var1.get("tic"));
      this.n.setFromMap((Map)var1.get("at"));
   }
}
