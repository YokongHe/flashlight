package com.adsdk.sdk;

import com.adsdk.sdk.Ad;
import com.adsdk.sdk.data.ClickType;
import com.adsdk.sdk.video.VideoData;
import java.util.List;

public class AdResponse implements Ad {
   public static final String OTHER = "other";
   public static final String WEB = "web";
   private static final long serialVersionUID = 3271938798582141269L;
   private int bannerHeight;
   private int bannerWidth;
   private ClickType clickType;
   private String clickUrl;
   private List customEvents;
   private boolean horizontalOrientationRequested;
   private String imageUrl;
   private int refresh;
   private boolean scale;
   private int skipOverlay = 0;
   private boolean skipPreflight;
   private String text;
   private long timestamp;
   private int type;
   private String urlType;
   private VideoData videoData;

   public int getBannerHeight() {
      return this.bannerHeight;
   }

   public int getBannerWidth() {
      return this.bannerWidth;
   }

   public ClickType getClickType() {
      return this.clickType;
   }

   public String getClickUrl() {
      return this.clickUrl;
   }

   public List getCustomEvents() {
      return this.customEvents;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public int getRefresh() {
      return this.refresh;
   }

   public int getSkipOverlay() {
      return this.skipOverlay;
   }

   public String getText() {
      return this.text;
   }

   public long getTimestamp() {
      return this.timestamp;
   }

   public int getType() {
      return this.type;
   }

   public String getUrlType() {
      return this.urlType;
   }

   public VideoData getVideoData() {
      return this.videoData;
   }

   public boolean isHorizontalOrientationRequested() {
      return this.horizontalOrientationRequested;
   }

   public boolean isScale() {
      return this.scale;
   }

   public boolean isSkipPreflight() {
      return this.skipPreflight;
   }

   public void setBannerHeight(int var1) {
      this.bannerHeight = var1;
   }

   public void setBannerWidth(int var1) {
      this.bannerWidth = var1;
   }

   public void setClickType(ClickType var1) {
      this.clickType = var1;
   }

   public void setClickUrl(String var1) {
      this.clickUrl = var1;
   }

   public void setCustomEvents(List var1) {
      this.customEvents = var1;
   }

   public void setHorizontalOrientationRequested(boolean var1) {
      this.horizontalOrientationRequested = var1;
   }

   public void setImageUrl(String var1) {
      this.imageUrl = var1;
   }

   public void setRefresh(int var1) {
      this.refresh = var1;
   }

   public void setScale(boolean var1) {
      this.scale = var1;
   }

   public void setSkipOverlay(int var1) {
      this.skipOverlay = var1;
   }

   public void setSkipPreflight(boolean var1) {
      this.skipPreflight = var1;
   }

   public void setText(String var1) {
      this.text = var1;
   }

   public void setTimestamp(long var1) {
      this.timestamp = var1;
   }

   public void setType(int var1) {
      this.type = var1;
   }

   public void setUrlType(String var1) {
      this.urlType = var1;
   }

   public void setVideoData(VideoData var1) {
      this.videoData = var1;
   }

   public String toString() {
      return "Response [refresh=" + this.refresh + ", type=" + this.type + ", bannerWidth=" + this.bannerWidth + ", bannerHeight=" + this.bannerHeight + ", text=" + this.text + ", imageUrl=" + this.imageUrl + ", clickType=" + this.clickType + ", clickUrl=" + this.clickUrl + ", urlType=" + this.urlType + ", scale=" + this.scale + ", skipPreflight=" + this.skipPreflight + "]";
   }
}
