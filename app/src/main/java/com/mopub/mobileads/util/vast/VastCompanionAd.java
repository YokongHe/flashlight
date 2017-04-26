package com.mopub.mobileads.util.vast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VastCompanionAd implements Serializable {
   private static final long serialVersionUID = 0L;
   private final String mClickThroughUrl;
   private final ArrayList mClickTrackers;
   private final Integer mHeight;
   private final String mImageUrl;
   private final Integer mWidth;

   public VastCompanionAd(Integer var1, Integer var2, String var3, String var4, ArrayList var5) {
      this.mWidth = var1;
      this.mHeight = var2;
      this.mImageUrl = var3;
      this.mClickThroughUrl = var4;
      this.mClickTrackers = var5;
   }

   public String getClickThroughUrl() {
      return this.mClickThroughUrl;
   }

   public List getClickTrackers() {
      return this.mClickTrackers;
   }

   public Integer getHeight() {
      return this.mHeight;
   }

   public String getImageUrl() {
      return this.mImageUrl;
   }

   public Integer getWidth() {
      return this.mWidth;
   }
}
