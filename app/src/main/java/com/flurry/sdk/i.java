package com.flurry.sdk;

import android.content.Context;
import android.widget.RelativeLayout;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import java.util.Map;

public abstract class i extends RelativeLayout {
   private static final String a = com.flurry.sdk.i.class.getSimpleName();
   private FlurryAdModule b;
   private com.flurry.sdk.e c;
   private AdUnit d;
   private int e;

   protected i(Context var1) {
      super(var1);
   }

   public i(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3) {
      super(var1);
      this.b = var2;
      this.c = var3;
   }

   boolean g() {
      return !((AdFrame)this.d.d().get(this.e)).e().e().toString().equals("takeover");
   }

   public int getAdFrameIndex() {
      return this.e;
   }

   public com.flurry.sdk.e getAdLog() {
      return this.c;
   }

   public AdUnit getAdUnit() {
      return this.d;
   }

   public FlurryAdModule getPlatformModule() {
      return this.b;
   }

   public abstract void initLayout();

   public void onDestroy() {
   }

   public void onEvent(String var1, Map var2) {
      eo.a(3, a, "AppSpotBannerView.onEvent " + var1);
      if(this.d != null) {
         this.b.a((com.flurry.sdk.q)(new com.flurry.sdk.q(var1, var2, this.getContext(), this.d, this.c, this.e)), (com.flurry.sdk.ad)this.b.a(), 0);
      } else {
         eo.a(3, a, "fAdUnit == null");
      }
   }

   public void setAdFrameIndex(int var1) {
      this.e = var1;
   }

   public void setAdLog(com.flurry.sdk.e var1) {
      this.c = var1;
   }

   public void setAdUnit(AdUnit var1) {
      this.d = var1;
   }

   public void setPlatformModule(FlurryAdModule var1) {
      this.b = var1;
   }
}
