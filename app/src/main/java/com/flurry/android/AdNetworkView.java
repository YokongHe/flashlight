package com.flurry.android;

import android.content.Context;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.util.Map;

public abstract class AdNetworkView extends com.flurry.sdk.i {
   private final AdCreative a;

   public AdNetworkView(Context var1, AdCreative var2) {
      super(var1, (FlurryAdModule)null, (com.flurry.sdk.e)null);
      this.a = var2;
   }

   public AdNetworkView(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4) {
      super(var1, var2, var3);
      this.a = var4;
   }

   public AdCreative getAdCreative() {
      return this.a;
   }

   public void onAdClicked(Map var1) {
      super.onEvent("clicked", var1);
   }

   public void onAdClosed(Map var1) {
      super.onEvent("adClosed", var1);
   }

   public void onAdFilled(Map var1) {
      super.onEvent("filled", var1);
   }

   public void onAdPrepared(Map var1) {
      super.onEvent("prepared", var1);
   }

   public void onAdShown(Map var1) {
      super.onEvent("rendered", var1);
   }

   public void onAdUnFilled(Map var1) {
      super.onEvent("unfilled", var1);
   }

   public void onRenderFailed(Map var1) {
      super.onEvent("renderFailed", var1);
   }
}
