package com.mopub.mobileads.util.vast;

import com.mopub.mobileads.util.vast.VastCompanionAd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VastVideoConfiguration implements Serializable {
   private static final long serialVersionUID = 0L;
   private String mClickThroughUrl;
   private ArrayList mClickTrackers = new ArrayList();
   private ArrayList mCompleteTrackers = new ArrayList();
   private String mDiskMediaFileUrl;
   private ArrayList mFirstQuartileTrackers = new ArrayList();
   private ArrayList mImpressionTrackers = new ArrayList();
   private ArrayList mMidpointTrackers = new ArrayList();
   private String mNetworkMediaFileUrl;
   private ArrayList mStartTrackers = new ArrayList();
   private ArrayList mThirdQuartileTrackers = new ArrayList();
   private VastCompanionAd mVastCompanionAd;

   public void addClickTrackers(List var1) {
      this.mClickTrackers.addAll(var1);
   }

   public void addCompleteTrackers(List var1) {
      this.mCompleteTrackers.addAll(var1);
   }

   public void addFirstQuartileTrackers(List var1) {
      this.mFirstQuartileTrackers.addAll(var1);
   }

   public void addImpressionTrackers(List var1) {
      this.mImpressionTrackers.addAll(var1);
   }

   public void addMidpointTrackers(List var1) {
      this.mMidpointTrackers.addAll(var1);
   }

   public void addStartTrackers(List var1) {
      this.mStartTrackers.addAll(var1);
   }

   public void addThirdQuartileTrackers(List var1) {
      this.mThirdQuartileTrackers.addAll(var1);
   }

   public String getClickThroughUrl() {
      return this.mClickThroughUrl;
   }

   public List getClickTrackers() {
      return this.mClickTrackers;
   }

   public List getCompleteTrackers() {
      return this.mCompleteTrackers;
   }

   public String getDiskMediaFileUrl() {
      return this.mDiskMediaFileUrl;
   }

   public List getFirstQuartileTrackers() {
      return this.mFirstQuartileTrackers;
   }

   public List getImpressionTrackers() {
      return this.mImpressionTrackers;
   }

   public List getMidpointTrackers() {
      return this.mMidpointTrackers;
   }

   public String getNetworkMediaFileUrl() {
      return this.mNetworkMediaFileUrl;
   }

   public List getStartTrackers() {
      return this.mStartTrackers;
   }

   public List getThirdQuartileTrackers() {
      return this.mThirdQuartileTrackers;
   }

   public VastCompanionAd getVastCompanionAd() {
      return this.mVastCompanionAd;
   }

   public void setClickThroughUrl(String var1) {
      this.mClickThroughUrl = var1;
   }

   public void setDiskMediaFileUrl(String var1) {
      this.mDiskMediaFileUrl = var1;
   }

   public void setNetworkMediaFileUrl(String var1) {
      this.mNetworkMediaFileUrl = var1;
   }

   public void setVastCompanionAd(VastCompanionAd var1) {
      this.mVastCompanionAd = var1;
   }
}
