package com.flurry.sdk;

import android.location.Criteria;
import com.flurry.sdk.dq;

public class dp {
   public static final Integer a = Integer.valueOf(171);
   public static final Integer b = Integer.valueOf(4);
   public static final Integer c = Integer.valueOf(1);
   public static final Integer d = Integer.valueOf(0);
   public static final String e = null;
   public static final Boolean f = Boolean.valueOf(true);
   public static final Boolean g = Boolean.valueOf(true);
   public static final String h = null;
   public static final Boolean i = Boolean.valueOf(true);
   public static final Criteria j = null;
   public static final Long k = Long.valueOf(10000L);
   public static final Boolean l = Boolean.valueOf(true);
   public static final Long m = Long.valueOf(0L);
   public static final Byte n = Byte.valueOf((byte)-1);
   private static dq o;

   public static dq a() {
      synchronized(dp.class){}

      dq var0;
      try {
         if(o == null) {
            o = new dq();
            b();
         }

         var0 = o;
      } finally {
         ;
      }

      return var0;
   }

   private static void b() {
      if(o == null) {
         o = new dq();
      }

      o.a((String)"AgentVersion", (Object)a);
      o.a((String)"ReleaseMajorVersion", (Object)b);
      o.a((String)"ReleaseMinorVersion", (Object)c);
      o.a((String)"ReleasePatchVersion", (Object)d);
      o.a((String)"ReleaseBetaVersion", (Object)"");
      o.a((String)"VersionName", (Object)e);
      o.a((String)"CaptureUncaughtExceptions", (Object)f);
      o.a((String)"UseHttps", (Object)g);
      o.a((String)"ReportUrl", (Object)h);
      o.a((String)"ReportLocation", (Object)i);
      o.a((String)"LocationCriteria", (Object)j);
      o.a((String)"ContinueSessionMillis", (Object)k);
      o.a((String)"LogEvents", (Object)l);
      o.a((String)"Age", (Object)m);
      o.a((String)"Gender", (Object)n);
      o.a((String)"UserId", (Object)"");
   }
}
