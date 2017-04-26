package com.adsdk.sdk.nativeads;

import android.view.View;
import com.adsdk.sdk.nativeads.NativeAd$ImageAsset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NativeAd {
   public static final String ADVERTISER_TEXT_ASSET = "advertiser";
   public static final String CALL_TO_ACTION_TEXT_ASSET = "cta";
   public static final String DESCRIPTION_TEXT_ASSET = "description";
   public static final String HEADLINE_TEXT_ASSET = "headline";
   public static final String ICON_IMAGE_ASSET = "icon";
   public static final String IMPRESSION_TRACKER_TYPE = "impression";
   public static final String MAIN_IMAGE_ASSET = "main";
   public static final String RATING_TEXT_ASSET = "rating";
   private String clickUrl;
   private List customEvents;
   private Map imageAssets = new HashMap();
   private Map textAssets = new HashMap();
   private List trackers = new ArrayList();

   public void addImageAsset(String var1, NativeAd$ImageAsset var2) {
      if(var1 != null && var2 != null) {
         this.imageAssets.put(var1, var2);
      }

   }

   public void addTextAsset(String var1, String var2) {
      if(var1 != null && var2 != null) {
         this.textAssets.put(var1, var2);
      }

   }

   public String getClickUrl() {
      return this.clickUrl;
   }

   public List getCustomEvents() {
      return this.customEvents;
   }

   public NativeAd$ImageAsset getImageAsset(String var1) {
      return (NativeAd$ImageAsset)this.imageAssets.get(var1);
   }

   public String getTextAsset(String var1) {
      return (String)this.textAssets.get(var1);
   }

   public List getTrackers() {
      return this.trackers;
   }

   public void handleClick() {
   }

   public void handleImpression() {
   }

   public void prepareImpression(View var1) {
   }

   public void setClickUrl(String var1) {
      this.clickUrl = var1;
   }

   public void setCustomEvents(List var1) {
      this.customEvents = var1;
   }

   public void setTrackers(List var1) {
      this.trackers = var1;
   }

   public void unregisterListener() {
   }
}
