package com.amazon.device.ads;

import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.StringUtils;
import java.util.HashMap;
import java.util.Map;

public class AdTargetingOptions {
   private static final boolean DEFAULT_DISPLAY_ENABLED = true;
   private static final long DEFAULT_FLOOR_PRICE = 0L;
   private static final boolean DEFAULT_GEOTARGETING_ENABLED = false;
   private static final String LOGTAG = AdTargetingOptions.class.getSimpleName();
   private final Map advanced;
   private boolean displayEnabled;
   private boolean enableGeoTargeting;
   private long floorPrice;
   private boolean videoEnabled;
   private final boolean videoEnabledSettable;

   public AdTargetingOptions() {
      this(new AndroidBuildInfo());
   }

   AdTargetingOptions(AndroidBuildInfo var1) {
      this.floorPrice = 0L;
      this.enableGeoTargeting = false;
      this.displayEnabled = true;
      this.advanced = new HashMap();
      this.videoEnabledSettable = isVideoEnabledSettable(var1);
      this.videoEnabled = this.videoEnabledSettable;
   }

   private static boolean isVideoEnabledSettable(AndroidBuildInfo var0) {
      return AndroidTargetUtils.isAtLeastAndroidAPI(var0, 14);
   }

   public boolean containsAdvancedOption(String var1) {
      return this.advanced.containsKey(var1);
   }

   AdTargetingOptions copy() {
      AdTargetingOptions var1 = (new AdTargetingOptions()).enableGeoLocation(this.enableGeoTargeting).setFloorPrice(this.floorPrice).enableDisplayAds(this.displayEnabled);
      if(this.videoEnabledSettable) {
         var1.enableVideoAds(this.videoEnabled);
      }

      var1.advanced.putAll(this.advanced);
      return var1;
   }

   AdTargetingOptions enableDisplayAds(boolean var1) {
      this.displayEnabled = var1;
      return this;
   }

   public AdTargetingOptions enableGeoLocation(boolean var1) {
      this.enableGeoTargeting = var1;
      return this;
   }

   AdTargetingOptions enableVideoAds(boolean var1) {
      if(!this.videoEnabledSettable) {
         Log.w(LOGTAG, "Video is not allowed to be changed as this device does not support video.");
         return this;
      } else {
         this.videoEnabled = var1;
         return this;
      }
   }

   public String getAdvancedOption(String var1) {
      return (String)this.advanced.get(var1);
   }

   public int getAge() {
      Log.d(LOGTAG, "getAge API has been deprecated.");
      return Integer.MIN_VALUE;
   }

   HashMap getCopyOfAdvancedOptions() {
      return new HashMap(this.advanced);
   }

   public long getFloorPrice() {
      return this.floorPrice;
   }

   boolean hasFloorPrice() {
      return this.floorPrice > 0L;
   }

   boolean isDisplayAdsEnabled() {
      return this.displayEnabled;
   }

   public boolean isGeoLocationEnabled() {
      return this.enableGeoTargeting;
   }

   boolean isVideoAdsEnabled() {
      return this.videoEnabled;
   }

   boolean isVideoEnabledSettable() {
      return this.videoEnabledSettable;
   }

   public AdTargetingOptions setAdvancedOption(String var1, String var2) {
      if(StringUtils.isNullOrWhiteSpace(var1)) {
         throw new IllegalArgumentException("Option Key must not be null or empty string");
      } else if(var2 != null) {
         this.advanced.put(var1, var2);
         return this;
      } else {
         this.advanced.remove(var1);
         return this;
      }
   }

   public AdTargetingOptions setAge(int var1) {
      Log.d(LOGTAG, "setAge API has been deprecated.");
      return this;
   }

   public AdTargetingOptions setFloorPrice(long var1) {
      this.floorPrice = var1;
      return this;
   }
}
