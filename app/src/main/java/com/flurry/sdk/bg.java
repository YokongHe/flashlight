package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.dx;
import java.util.Collections;
import java.util.List;

public abstract class bg implements com.flurry.sdk.ak, com.flurry.sdk.k {
   protected abstract com.flurry.sdk.aj a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5);

   protected com.flurry.sdk.bf a() {
      return this.c();
   }

   protected abstract com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5);

   public com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      if(var1 != null && var2 != null && var3 != null && var4 != null && this.b(var1, this.e())) {
         Bundle var5 = this.c(var1, var2, var3, var4);
         if(var5 != null) {
            AdCreative var6 = com.flurry.sdk.cc.a(var4);
            if(var6 != null) {
               return this.a(var1, var2, var3, var6, var5);
            }
         }
      }

      return null;
   }

   protected boolean a(Context var1, com.flurry.sdk.bj var2) {
      if(var1 != null && var2 != null) {
         com.flurry.sdk.bf var3 = this.a();
         if(var3 != null) {
            return var3.a(var1, var2);
         }
      }

      return false;
   }

   public com.flurry.sdk.aj a_(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      if(var1 != null && var2 != null && var3 != null && var4 != null && this.a(var1, this.d())) {
         Bundle var5 = this.b(var1, var2, var3, var4);
         if(var5 != null) {
            return this.a(var1, var2, var3, var4, var5);
         }
      }

      return null;
   }

   protected Bundle b(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      return this.d(var1, var2, var3, var4);
   }

   protected com.flurry.sdk.bf b() {
      return this.c();
   }

   protected boolean b(Context var1, com.flurry.sdk.bj var2) {
      if(var1 != null && var2 != null) {
         com.flurry.sdk.bf var3 = this.b();
         if(var3 != null) {
            return var3.a(var1, var2);
         }
      }

      return false;
   }

   protected Bundle c(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      return this.d(var1, var2, var3, var4);
   }

   protected com.flurry.sdk.bf c() {
      return new com.flurry.sdk.be();
   }

   protected Bundle d(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      return dx.d(var1);
   }

   protected com.flurry.sdk.bj d() {
      return new com.flurry.sdk.bj(this.f(), this.g(), this.h(), this.i(), this.j());
   }

   protected com.flurry.sdk.bj e() {
      return new com.flurry.sdk.bj(this.f(), this.k(), this.l(), this.m(), Collections.emptyList());
   }

   protected abstract String f();

   protected abstract List g();

   protected List h() {
      return this.n();
   }

   protected List i() {
      return this.o();
   }

   protected abstract List j();

   protected abstract List k();

   protected List l() {
      return this.n();
   }

   protected List m() {
      return this.o();
   }

   protected abstract List n();

   protected abstract List o();
}
