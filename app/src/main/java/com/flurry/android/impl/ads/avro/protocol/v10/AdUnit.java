package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;
import java.util.Map;

public class AdUnit extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"AdUnit\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adSpace\",\"type\":\"string\"},{\"name\":\"expiration\",\"type\":\"long\"},{\"name\":\"adFrames\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"AdFrame\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}}},{\"name\":\"combinable\",\"type\":\"int\",\"default\":0},{\"name\":\"groupId\",\"type\":\"string\"},{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"newCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCap\",\"type\":\"int\",\"default\":-1},{\"name\":\"previousCapType\",\"type\":\"int\",\"default\":0},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"price\",\"type\":\"long\",\"default\":0},{\"name\":\"adomain\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"closableTime\",\"type\":\"long\",\"default\":0},{\"name\":\"rewardable\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRenderTimeoutMillis\",\"type\":\"long\",\"default\":10000},{\"name\":\"preCacheAdSkippableTimeLimitMillis\",\"type\":\"int\",\"default\":20000},{\"name\":\"videoAutoPlay\",\"type\":\"boolean\",\"default\":false},{\"name\":\"supportMRAID\",\"type\":\"boolean\",\"default\":false},{\"name\":\"preRender\",\"type\":\"boolean\",\"default\":true},{\"name\":\"renderTime\",\"type\":\"boolean\",\"default\":false},{\"name\":\"clientSideRtbPayload\",\"type\":{\"type\":\"map\",\"values\":\"string\"},\"default\":[]},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}");
   @Deprecated
   public CharSequence a;
   @Deprecated
   public long b;
   @Deprecated
   public List c;
   @Deprecated
   public int d;
   @Deprecated
   public CharSequence e;
   @Deprecated
   public CharSequence f;
   @Deprecated
   public long g;
   @Deprecated
   public int h;
   @Deprecated
   public int i;
   @Deprecated
   public int j;
   @Deprecated
   public long k;
   @Deprecated
   public long l;
   @Deprecated
   public CharSequence m;
   @Deprecated
   public long n;
   @Deprecated
   public boolean o;
   @Deprecated
   public long p;
   @Deprecated
   public int q;
   @Deprecated
   public boolean r;
   @Deprecated
   public boolean s;
   @Deprecated
   public boolean t;
   @Deprecated
   public boolean u;
   @Deprecated
   public Map v;
   @Deprecated
   public ScreenOrientationType w;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return this.a;
      case 1:
         return Long.valueOf(this.b);
      case 2:
         return this.c;
      case 3:
         return Integer.valueOf(this.d);
      case 4:
         return this.e;
      case 5:
         return this.f;
      case 6:
         return Long.valueOf(this.g);
      case 7:
         return Integer.valueOf(this.h);
      case 8:
         return Integer.valueOf(this.i);
      case 9:
         return Integer.valueOf(this.j);
      case 10:
         return Long.valueOf(this.k);
      case 11:
         return Long.valueOf(this.l);
      case 12:
         return this.m;
      case 13:
         return Long.valueOf(this.n);
      case 14:
         return Boolean.valueOf(this.o);
      case 15:
         return Long.valueOf(this.p);
      case 16:
         return Integer.valueOf(this.q);
      case 17:
         return Boolean.valueOf(this.r);
      case 18:
         return Boolean.valueOf(this.s);
      case 19:
         return Boolean.valueOf(this.t);
      case 20:
         return Boolean.valueOf(this.u);
      case 21:
         return this.v;
      case 22:
         return this.w;
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
         this.b = ((Long)var2).longValue();
         return;
      case 2:
         this.c = (List)var2;
         return;
      case 3:
         this.d = ((Integer)var2).intValue();
         return;
      case 4:
         this.e = (CharSequence)var2;
         return;
      case 5:
         this.f = (CharSequence)var2;
         return;
      case 6:
         this.g = ((Long)var2).longValue();
         return;
      case 7:
         this.h = ((Integer)var2).intValue();
         return;
      case 8:
         this.i = ((Integer)var2).intValue();
         return;
      case 9:
         this.j = ((Integer)var2).intValue();
         return;
      case 10:
         this.k = ((Long)var2).longValue();
         return;
      case 11:
         this.l = ((Long)var2).longValue();
         return;
      case 12:
         this.m = (CharSequence)var2;
         return;
      case 13:
         this.n = ((Long)var2).longValue();
         return;
      case 14:
         this.o = ((Boolean)var2).booleanValue();
         return;
      case 15:
         this.p = ((Long)var2).longValue();
         return;
      case 16:
         this.q = ((Integer)var2).intValue();
         return;
      case 17:
         this.r = ((Boolean)var2).booleanValue();
         return;
      case 18:
         this.s = ((Boolean)var2).booleanValue();
         return;
      case 19:
         this.t = ((Boolean)var2).booleanValue();
         return;
      case 20:
         this.u = ((Boolean)var2).booleanValue();
         return;
      case 21:
         this.v = (Map)var2;
         return;
      case 22:
         this.w = (ScreenOrientationType)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(Boolean var1) {
      this.u = var1.booleanValue();
   }

   public void a(CharSequence var1) {
      this.e = var1;
   }

   public void a(List var1) {
      this.c = var1;
   }

   public void a(Map var1) {
      this.v = var1;
   }

   public CharSequence b() {
      return this.a;
   }

   public void b(CharSequence var1) {
      this.f = var1;
   }

   public Long c() {
      return Long.valueOf(this.b);
   }

   public List d() {
      return this.c;
   }

   public Integer e() {
      return Integer.valueOf(this.d);
   }

   public CharSequence f() {
      return this.e;
   }

   public CharSequence g() {
      return this.f;
   }

   public Long h() {
      return Long.valueOf(this.g);
   }

   public Integer i() {
      return Integer.valueOf(this.h);
   }

   public Integer j() {
      return Integer.valueOf(this.i);
   }

   public Integer k() {
      return Integer.valueOf(this.j);
   }

   public Long l() {
      return Long.valueOf(this.k);
   }

   public Long m() {
      return Long.valueOf(this.n);
   }

   public Boolean n() {
      return Boolean.valueOf(this.o);
   }

   public Long o() {
      return Long.valueOf(this.p);
   }

   public Integer p() {
      return Integer.valueOf(this.q);
   }

   public Boolean q() {
      return Boolean.valueOf(this.r);
   }

   public Boolean r() {
      return Boolean.valueOf(this.s);
   }

   public Boolean s() {
      return Boolean.valueOf(this.u);
   }

   public Map t() {
      return this.v;
   }

   public ScreenOrientationType u() {
      return this.w;
   }
}