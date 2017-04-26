package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;

public class AdFrame extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"AdFrame\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"binding\",\"type\":\"int\"},{\"name\":\"display\",\"type\":\"string\"},{\"name\":\"content\",\"type\":\"string\"},{\"name\":\"adSpaceLayout\",\"type\":{\"type\":\"record\",\"name\":\"AdSpaceLayout\",\"fields\":[{\"name\":\"adWidth\",\"type\":\"int\"},{\"name\":\"adHeight\",\"type\":\"int\"},{\"name\":\"fix\",\"type\":\"string\"},{\"name\":\"format\",\"type\":\"string\"},{\"name\":\"alignment\",\"type\":\"string\"}]}},{\"name\":\"callbacks\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Callback\",\"fields\":[{\"name\":\"event\",\"type\":\"string\"},{\"name\":\"actions\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}}},{\"name\":\"adGuid\",\"type\":\"string\"},{\"name\":\"cachingEnum\",\"type\":\"int\",\"default\":1},{\"name\":\"assetExpirationTimestampUTCMillis\",\"type\":\"long\"},{\"name\":\"cacheWhitelistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]},{\"name\":\"cacheBlacklistedAssets\",\"type\":{\"type\":\"array\",\"items\":\"string\"},\"default\":[]}]}");
   @Deprecated
   public int a;
   @Deprecated
   public CharSequence b;
   @Deprecated
   public CharSequence c;
   @Deprecated
   public AdSpaceLayout d;
   @Deprecated
   public List e;
   @Deprecated
   public CharSequence f;
   @Deprecated
   public int g;
   @Deprecated
   public long h;
   @Deprecated
   public List i;
   @Deprecated
   public List j;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return Integer.valueOf(this.a);
      case 1:
         return this.b;
      case 2:
         return this.c;
      case 3:
         return this.d;
      case 4:
         return this.e;
      case 5:
         return this.f;
      case 6:
         return Integer.valueOf(this.g);
      case 7:
         return Long.valueOf(this.h);
      case 8:
         return this.i;
      case 9:
         return this.j;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = ((Integer)var2).intValue();
         return;
      case 1:
         this.b = (CharSequence)var2;
         return;
      case 2:
         this.c = (CharSequence)var2;
         return;
      case 3:
         this.d = (AdSpaceLayout)var2;
         return;
      case 4:
         this.e = (List)var2;
         return;
      case 5:
         this.f = (CharSequence)var2;
         return;
      case 6:
         this.g = ((Integer)var2).intValue();
         return;
      case 7:
         this.h = ((Long)var2).longValue();
         return;
      case 8:
         this.i = (List)var2;
         return;
      case 9:
         this.j = (List)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public Integer b() {
      return Integer.valueOf(this.a);
   }

   public CharSequence c() {
      return this.b;
   }

   public CharSequence d() {
      return this.c;
   }

   public AdSpaceLayout e() {
      return this.d;
   }

   public List f() {
      return this.e;
   }

   public CharSequence g() {
      return this.f;
   }

   public Integer h() {
      return Integer.valueOf(this.g);
   }

   public Long i() {
      return Long.valueOf(this.h);
   }

   public List j() {
      return this.i;
   }

   public List k() {
      return this.j;
   }
}
