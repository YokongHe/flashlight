package com.flurry.sdk;

import android.content.Context;
import android.content.Intent;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;

public final class ab extends com.flurry.sdk.aj {
   public ab(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      super(var1, var2, var3, var4);
   }

   public final void a() {
      Intent var1 = new Intent(do.a().b(), FlurryFullscreenTakeoverActivity.class);
      if(!this.c().a().a(this.b(), var1, this.e().b().toString())) {
         eo.b(a, "Unable to launch FlurryFullscreenTakeoverActivity. Fix by declaring this Activity in your AndroidManifest.xml");
      }

   }
}
