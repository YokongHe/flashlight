package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdRequest$Builder;
import com.flurry.android.impl.ads.avro.protocol.v10.AdViewContainer;
import com.flurry.android.impl.ads.avro.protocol.v10.Location;
import com.flurry.android.impl.ads.avro.protocol.v10.TargetingOverride;
import com.flurry.android.impl.ads.avro.protocol.v10.TestAds;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;
import java.util.Map;

public class AdRequest extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"AdRequest\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"apiKey\",\"type\":\"string\"},{\"name\":\"agentVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"adSpaceName\",\"type\":\"string\"},{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adReportedIds\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdReportedId\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}}},{\"name\":\"location\",\"type\":{\"type\":\"record\",\"name\":\"Location\",\"fields\":[{\"name\":\"lat\",\"type\":\"float\",\"default\":0.0},{\"name\":\"lon\",\"type\":\"float\",\"default\":0.0}]},\"default\":\"null\"},{\"name\":\"testDevice\",\"type\":\"boolean\",\"default\":false},{\"name\":\"bindings\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"adViewContainer\",\"type\":{\"type\":\"record\",\"name\":\"AdViewContainer\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]},\"default\":\"null\"},{\"name\":\"locale\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"timezone\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"osVersion\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"devicePlatform\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"testAds\",\"type\":{\"type\":\"record\",\"name\":\"TestAds\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]},\"default\":\"null\"},{\"name\":\"keywords\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"refresh\",\"type\":\"boolean\",\"default\":false},{\"name\":\"canDoSKAppStore\",\"type\":\"boolean\",\"default\":false},{\"name\":\"networkStatus\",\"type\":\"int\",\"default\":1},{\"name\":\"frequencyCapInfos\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}}},{\"name\":\"adTrackingEnabled\",\"type\":\"boolean\"},{\"name\":\"preferredLanguage\",\"type\":\"string\"},{\"name\":\"bcat\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"userAgent\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"targetingOverride\",\"type\":{\"type\":\"record\",\"name\":\"TargetingOverride\",\"fields\":[{\"name\":\"ageRange\",\"type\":\"int\",\"default\":-2},{\"name\":\"gender\",\"type\":\"int\",\"default\":-2},{\"name\":\"personas\",\"type\":{\"type\":\"array\",\"items\":\"int\"},\"default\":[]}]},\"default\":[]},{\"name\":\"sendConfiguration\",\"type\":\"boolean\",\"default\":false},{\"name\":\"origins\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]}]}");
   @Deprecated
   public boolean A;
   @Deprecated
   public Map B;
   @Deprecated
   public CharSequence a;
   @Deprecated
   public CharSequence b;
   @Deprecated
   public CharSequence c;
   @Deprecated
   public long d;
   @Deprecated
   public List e;
   @Deprecated
   public Location f;
   @Deprecated
   public boolean g;
   @Deprecated
   public List h;
   @Deprecated
   public AdViewContainer i;
   @Deprecated
   public CharSequence j;
   @Deprecated
   public CharSequence k;
   @Deprecated
   public CharSequence l;
   @Deprecated
   public CharSequence m;
   @Deprecated
   public TestAds n;
   @Deprecated
   public Map o;
   @Deprecated
   public boolean p;
   @Deprecated
   public boolean q;
   @Deprecated
   public int r;
   @Deprecated
   public List s;
   @Deprecated
   public boolean t;
   @Deprecated
   public CharSequence u;
   @Deprecated
   public List v;
   @Deprecated
   public CharSequence w;
   @Deprecated
   public TargetingOverride x;
   @Deprecated
   public boolean y;
   @Deprecated
   public List z;

   public static AdRequest$Builder b() {
      return new AdRequest$Builder(null);
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
         return this.f;
      case 6:
         return Boolean.valueOf(this.g);
      case 7:
         return this.h;
      case 8:
         return this.i;
      case 9:
         return this.j;
      case 10:
         return this.k;
      case 11:
         return this.l;
      case 12:
         return this.m;
      case 13:
         return this.n;
      case 14:
         return this.o;
      case 15:
         return Boolean.valueOf(this.p);
      case 16:
         return Boolean.valueOf(this.q);
      case 17:
         return Integer.valueOf(this.r);
      case 18:
         return this.s;
      case 19:
         return Boolean.valueOf(this.t);
      case 20:
         return this.u;
      case 21:
         return this.v;
      case 22:
         return this.w;
      case 23:
         return this.x;
      case 24:
         return Boolean.valueOf(this.y);
      case 25:
         return this.z;
      case 26:
         return Boolean.valueOf(this.A);
      case 27:
         return this.B;
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
         this.b = (CharSequence)var2;
         return;
      case 2:
         this.c = (CharSequence)var2;
         return;
      case 3:
         this.d = ((Long)var2).longValue();
         return;
      case 4:
         this.e = (List)var2;
         return;
      case 5:
         this.f = (Location)var2;
         return;
      case 6:
         this.g = ((Boolean)var2).booleanValue();
         return;
      case 7:
         this.h = (List)var2;
         return;
      case 8:
         this.i = (AdViewContainer)var2;
         return;
      case 9:
         this.j = (CharSequence)var2;
         return;
      case 10:
         this.k = (CharSequence)var2;
         return;
      case 11:
         this.l = (CharSequence)var2;
         return;
      case 12:
         this.m = (CharSequence)var2;
         return;
      case 13:
         this.n = (TestAds)var2;
         return;
      case 14:
         this.o = (Map)var2;
         return;
      case 15:
         this.p = ((Boolean)var2).booleanValue();
         return;
      case 16:
         this.q = ((Boolean)var2).booleanValue();
         return;
      case 17:
         this.r = ((Integer)var2).intValue();
         return;
      case 18:
         this.s = (List)var2;
         return;
      case 19:
         this.t = ((Boolean)var2).booleanValue();
         return;
      case 20:
         this.u = (CharSequence)var2;
         return;
      case 21:
         this.v = (List)var2;
         return;
      case 22:
         this.w = (CharSequence)var2;
         return;
      case 23:
         this.x = (TargetingOverride)var2;
         return;
      case 24:
         this.y = ((Boolean)var2).booleanValue();
         return;
      case 25:
         this.z = (List)var2;
         return;
      case 26:
         this.A = ((Boolean)var2).booleanValue();
         return;
      case 27:
         this.B = (Map)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(TestAds var1) {
      this.n = var1;
   }

   public void a(Boolean var1) {
      this.p = var1.booleanValue();
   }

   public void a(CharSequence var1) {
      this.c = var1;
   }

   public void a(Map var1) {
      this.o = var1;
   }

   public void b(Map var1) {
      this.B = var1;
   }
}
