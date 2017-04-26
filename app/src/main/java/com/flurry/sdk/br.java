package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.br$a;
import com.flurry.sdk.eo;

public final class br extends com.flurry.sdk.ba {
   private static final String b = com.flurry.sdk.br.class.getSimpleName();
   private final String c;
   private final String d;
   private final boolean e;
   private final com.google.android.gms.ads.e f;
   private final com.google.android.gms.ads.a g;

   public br(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      super(var1, var2, var3, var4);
      this.c = var5.getString("com.flurry.gms.ads.MY_AD_UNIT_ID");
      this.d = var5.getString("com.flurry.gms.ads.MYTEST_AD_DEVICE_ID");
      this.e = var5.getBoolean("com.flurry.gms.ads.test");
      this.g = new br$a(this, null);
      this.f = new com.google.android.gms.ads.e(this.b());
      this.f.a(this.c);
      this.f.a(this.g);
   }

   // $FF: synthetic method
   static com.google.android.gms.ads.e a(com.flurry.sdk.br var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static String f() {
      return b;
   }

   public final void a() {
      com.google.android.gms.ads.c var1 = new com.google.android.gms.ads.c();
      if(this.e) {
         eo.a(3, b, "GMS AdView set to Test Mode.");
         var1.b(com.google.android.gms.ads.b.a);
         if(!TextUtils.isEmpty(this.d)) {
            var1.b(this.d);
         }
      }

      this.f.a(var1.a());
   }
}
