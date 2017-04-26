package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest$Builder;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;

public class SdkLogRequest extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"SdkLogRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"sdkAdLogs\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdLog\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}}},{\"name\":\"agentTimestamp\",\"type\":\"long\"},{\"name\":\"agentVersion\",\"type\":\"string\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false}]}");
   @Deprecated
   public CharSequence a;
   @Deprecated
   public List b;
   @Deprecated
   public List c;
   @Deprecated
   public long d;
   @Deprecated
   public CharSequence e;
   @Deprecated
   public boolean f;

   public static SdkLogRequest$Builder b() {
      return new SdkLogRequest$Builder(null);
   }

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return this.a;
      case 1:
         return this.b;
      case 2:
         return this.c;
      case 3:
         return Long.valueOf(this.d);
      case 4:
         return this.e;
      case 5:
         return Boolean.valueOf(this.f);
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = (CharSequence)var2;
         return;
      case 1:
         this.b = (List)var2;
         return;
      case 2:
         this.c = (List)var2;
         return;
      case 3:
         this.d = ((Long)var2).longValue();
         return;
      case 4:
         this.e = (CharSequence)var2;
         return;
      case 5:
         this.f = ((Boolean)var2).booleanValue();
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
