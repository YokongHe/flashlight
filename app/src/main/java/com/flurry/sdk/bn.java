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

public class bn extends com.flurry.sdk.bg {
   protected com.flurry.sdk.aj a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bo(var1, var2, var3, var4, var5):null;
   }

   protected com.flurry.sdk.i a(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdCreative var4, Bundle var5) {
      return var1 != null && var2 != null && var3 != null && var4 != null && var5 != null?new com.flurry.sdk.bm(var1, var2, var3, var4, var5):null;
   }

   protected String f() {
      return "Facebook Audience Network";
   }

   protected List g() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("AudienceNetwork", "3.14.+", "com.facebook.ads.InterstitialAd"));
      return var1;
   }

   @TargetApi(13)
   protected List j() {
      ArrayList var1 = new ArrayList();
      ActivityInfo var2 = new ActivityInfo();
      var2.name = "com.facebook.ads.InterstitialAdActivity";
      var2.configChanges = 4016;
      var1.add(var2);
      return var1;
   }

   protected List k() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bc("AudienceNetwork", "3.14.+", "com.facebook.ads.Ad"));
      return var1;
   }

   protected List n() {
      ArrayList var1 = new ArrayList();
      var1.add("com.flurry.fan.MY_APP_ID");
      return var1;
   }

   protected List o() {
      ArrayList var1 = new ArrayList();
      var1.add("android.permission.INTERNET");
      var1.add("android.permission.ACCESS_NETWORK_STATE");
      return var1;
   }
}
