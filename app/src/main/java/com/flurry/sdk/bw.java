package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.flurry.android.AdCreative;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.util.ArrayList;
import java.util.List;

public final class bw extends com.flurry.sdk.bg {
   protected final com.flurry.sdk.aj a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bz(var1, var2, var3, var4, var5):null;
   }

   protected final com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bx(var1, var2, var3, var4, var5):null;
   }

   protected final String f() {
      return "Millennial Media";
   }

   protected final List g() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("MMAdView", "5.1.0", "com.millennialmedia.android.MMInterstitial"));
      return var1;
   }

   protected final List h() {
      ArrayList var1 = new ArrayList();
      var1.add("com.flurry.millennial.MYAPIDINTERSTITIAL");
      return var1;
   }

   @TargetApi(13)
   protected final List j() {
      ArrayList var1 = new ArrayList();
      ActivityInfo var2 = new ActivityInfo();
      var2.name = "com.millennialmedia.android.MMActivity";
      var2.configChanges = 3248;
      var1.add(var2);
      return var1;
   }

   protected final List k() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("MMAdView", "5.1.0", "com.millennialmedia.android.MMAdView"));
      return var1;
   }

   protected final List l() {
      ArrayList var1 = new ArrayList();
      var1.add("com.flurry.millennial.MYAPID");
      var1.add("com.flurry.millennial.MYAPIDRECTANGLE");
      return var1;
   }

   protected final List n() {
      return new ArrayList();
   }

   protected final List o() {
      ArrayList var1 = new ArrayList();
      var1.add("android.permission.INTERNET");
      var1.add("android.permission.WRITE_EXTERNAL_STORAGE");
      var1.add("android.permission.ACCESS_NETWORK_STATE");
      return var1;
   }
}
