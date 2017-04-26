package com.amazon.device.ads;

import com.amazon.device.ads.AdProperties;
import java.util.Iterator;
import java.util.Set;

class AdData implements Iterable {
   public static final int CAN_EXPAND1 = 1003;
   public static final int CAN_EXPAND2 = 1004;
   public static final int CAN_PLAY_AUDIO1 = 1001;
   public static final int CAN_PLAY_AUDIO2 = 1002;
   public static final int CAN_PLAY_VIDEO = 1014;
   public static final int HTML = 1007;
   public static final int INTERSTITIAL = 1008;
   public static final int MRAID1 = 1016;
   public static final int MRAID2 = 1017;
   public static final int REQUIRES_TRANSPARENCY = 1031;
   public static final int VIDEO_INTERSTITIAL = 1030;
   private int adHeight;
   private int adWidth;
   private String creative;
   private Set creativeTypes;
   private long expirationTimeMs = -1L;
   private boolean fetched;
   private String impPixelUrl;
   private String instrPixelUrl;
   private AdProperties properties;

   protected String getCreative() {
      return this.creative;
   }

   protected Set getCreativeTypes() {
      return this.creativeTypes;
   }

   public int getHeight() {
      return this.adHeight;
   }

   protected String getImpressionPixelUrl() {
      return this.impPixelUrl;
   }

   protected String getInstrumentationPixelUrl() {
      return this.instrPixelUrl;
   }

   public boolean getIsFetched() {
      return this.fetched;
   }

   protected AdProperties getProperties() {
      return this.properties;
   }

   public int getWidth() {
      return this.adWidth;
   }

   public boolean isExpired() {
      return this.expirationTimeMs >= 0L && System.currentTimeMillis() > this.expirationTimeMs;
   }

   public Iterator iterator() {
      return this.creativeTypes.iterator();
   }

   protected void setCreative(String var1) {
      this.creative = var1;
   }

   protected void setCreativeTypes(Set var1) {
      this.creativeTypes = var1;
   }

   protected void setExpirationTimeMillis(long var1) {
      this.expirationTimeMs = var1;
   }

   public void setFetched(boolean var1) {
      this.fetched = var1;
   }

   protected void setHeight(int var1) {
      this.adHeight = var1;
   }

   protected void setImpressionPixelUrl(String var1) {
      this.impPixelUrl = var1;
   }

   protected void setInstrumentationPixelUrl(String var1) {
      this.instrPixelUrl = var1;
   }

   protected void setProperties(AdProperties var1) {
      this.properties = var1;
   }

   protected void setWidth(int var1) {
      this.adWidth = var1;
   }
}
