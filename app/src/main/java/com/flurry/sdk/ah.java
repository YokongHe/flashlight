package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;

public abstract class ah {
   private final FlurryAdModule a;
   private final AdUnit b;
   private final com.flurry.sdk.e c;
   private final String d;

   public ah(FlurryAdModule var1, AdUnit var2, com.flurry.sdk.e var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      String var4;
      if(var2 != null) {
         var4 = var2.b().toString();
      } else {
         var4 = null;
      }

      this.d = var4;
   }

   public abstract void a(Context var1, ViewGroup var2);

   public FlurryAdModule b() {
      return this.a;
   }

   public AdUnit c() {
      return this.b;
   }

   public com.flurry.sdk.e d() {
      return this.c;
   }

   public String e() {
      return this.d;
   }
}
