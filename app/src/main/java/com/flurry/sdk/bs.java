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

public final class bs extends com.flurry.sdk.bg {
   protected final com.flurry.sdk.aj a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bv(var1, var2, var3, var4, var5):null;
   }

   protected final com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bt(var1, var2, var3, var4, var5):null;
   }

   protected final String f() {
      return "InMobi";
   }

   protected final List g() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMInterstitial"));
      return var1;
   }

   @TargetApi(13)
   protected final List j() {
      ArrayList var1 = new ArrayList();
      ActivityInfo var2 = new ActivityInfo();
      var2.name = "com.inmobi.androidsdk.IMBrowserActivity";
      var2.configChanges = 3248;
      var1.add(var2);
      return var1;
   }

   protected final List k() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("InMobiAndroidSDK", "4.1.0", "com.inmobi.monetization.IMBanner"));
      return var1;
   }

   protected final List n() {
      ArrayList var1 = new ArrayList();
      var1.add("com.flurry.inmobi.MY_APP_ID");
      return var1;
   }

   protected final List o() {
      ArrayList var1 = new ArrayList();
      var1.add("android.permission.INTERNET");
      return var1;
   }
}
