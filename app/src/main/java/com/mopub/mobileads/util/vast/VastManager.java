package com.mopub.mobileads.util.vast;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CacheService;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.mobileads.VastVideoDownloadTask;
import com.mopub.mobileads.VastVideoDownloadTask$VastVideoDownloadTaskListener;
import com.mopub.mobileads.util.vast.VastCompanionAd;
import com.mopub.mobileads.util.vast.VastManager$VastManagerListener;
import com.mopub.mobileads.util.vast.VastVideoConfiguration;
import com.mopub.mobileads.util.vast.VastXmlManager;
import com.mopub.mobileads.util.vast.VastXmlManager$ImageCompanionAdXmlManager;
import com.mopub.mobileads.util.vast.VastXmlManager$MediaXmlManager;
import com.mopub.mobileads.util.vast.VastXmlManagerAggregator;
import com.mopub.mobileads.util.vast.VastXmlManagerAggregator$VastXmlManagerAggregatorListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class VastManager implements VastXmlManagerAggregator$VastXmlManagerAggregatorListener {
   private static final double AREA_WEIGHT = 60.0D;
   private static final double ASPECT_RATIO_WEIGHT = 40.0D;
   private static final List COMPANION_IMAGE_MIME_TYPES = Arrays.asList(new String[]{"image/jpeg", "image/png", "image/bmp", "image/gif"});
   private static final List VIDEO_MIME_TYPES = Arrays.asList(new String[]{"video/mp4", "video/3gpp"});
   private int mScreenArea;
   private double mScreenAspectRatio;
   private VastManager$VastManagerListener mVastManagerListener;
   private VastXmlManagerAggregator mVastXmlManagerAggregator;

   public VastManager(Context var1) {
      this.initializeScreenDimensions(var1);
   }

   private double calculateFitness(int var1, int var2) {
      double var3 = (double)var1 / (double)var2 / this.mScreenAspectRatio;
      double var5 = (double)(var1 * var2) / (double)this.mScreenArea;
      return Math.abs(Math.log(var3)) * 40.0D + Math.abs(Math.log(var5)) * 60.0D;
   }

   private VastVideoConfiguration createVastVideoConfigurationFromXml(List var1) {
      VastVideoConfiguration var2 = new VastVideoConfiguration();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         VastXmlManager var5 = (VastXmlManager)var6.next();
         var2.addImpressionTrackers(var5.getImpressionTrackers());
         var2.addStartTrackers(var5.getVideoStartTrackers());
         var2.addFirstQuartileTrackers(var5.getVideoFirstQuartileTrackers());
         var2.addMidpointTrackers(var5.getVideoMidpointTrackers());
         var2.addThirdQuartileTrackers(var5.getVideoThirdQuartileTrackers());
         var2.addCompleteTrackers(var5.getVideoCompleteTrackers());
         var2.addClickTrackers(var5.getClickTrackers());
         if(var2.getClickThroughUrl() == null) {
            var2.setClickThroughUrl(var5.getClickThroughUrl());
         }

         var3.addAll(var5.getMediaXmlManagers());
         var4.addAll(var5.getCompanionAdXmlManagers());
      }

      var2.setNetworkMediaFileUrl(this.getBestMediaFileUrl(var3));
      var2.setVastCompanionAd(this.getBestCompanionAd(var4));
      return var2;
   }

   private void initializeScreenDimensions(Context var1) {
      Display var5 = ((WindowManager)var1.getSystemService("window")).getDefaultDisplay();
      int var3 = var5.getWidth();
      int var4 = var5.getHeight();
      int var2 = Math.max(var3, var4);
      var3 = Math.min(var3, var4);
      this.mScreenAspectRatio = (double)var2 / (double)var3;
      this.mScreenArea = var3 * var2;
   }

   private boolean updateDiskMediaFileUrl(VastVideoConfiguration var1) {
      String var2 = var1.getNetworkMediaFileUrl();
      if(CacheService.containsKeyDiskCache(var2)) {
         var1.setDiskMediaFileUrl(CacheService.getFilePathDiskCache(var2));
         return true;
      } else {
         return false;
      }
   }

   public void cancel() {
      if(this.mVastXmlManagerAggregator != null) {
         this.mVastXmlManagerAggregator.cancel(true);
         this.mVastXmlManagerAggregator = null;
      }

   }

   VastCompanionAd getBestCompanionAd(List var1) {
      ArrayList var7 = new ArrayList(var1);
      Iterator var8 = var7.iterator();
      double var2 = Double.POSITIVE_INFINITY;
      VastXmlManager$ImageCompanionAdXmlManager var12 = null;

      while(true) {
         while(var8.hasNext()) {
            VastXmlManager$ImageCompanionAdXmlManager var6 = (VastXmlManager$ImageCompanionAdXmlManager)var8.next();
            String var9 = var6.getType();
            String var10 = var6.getImageUrl();
            if(COMPANION_IMAGE_MIME_TYPES.contains(var9) && var10 != null) {
               Integer var13 = var6.getWidth();
               Integer var11 = var6.getHeight();
               if(var13 != null && var13.intValue() > 0 && var11 != null && var11.intValue() > 0) {
                  double var4 = this.calculateFitness(var13.intValue(), var11.intValue());
                  if(var4 < var2) {
                     var2 = var4;
                     var12 = var6;
                  }
               }
            } else {
               var8.remove();
            }
         }

         if(var12 == null && !var7.isEmpty()) {
            var12 = (VastXmlManager$ImageCompanionAdXmlManager)var7.get(0);
         }

         if(var12 != null) {
            return new VastCompanionAd(var12.getWidth(), var12.getHeight(), var12.getImageUrl(), var12.getClickThroughUrl(), new ArrayList(var12.getClickTrackers()));
         }

         return null;
      }
   }

   String getBestMediaFileUrl(List var1) {
      ArrayList var7 = new ArrayList(var1);
      Iterator var8 = var7.iterator();
      String var12 = null;
      double var2 = Double.POSITIVE_INFINITY;

      while(true) {
         String var6;
         while(var8.hasNext()) {
            VastXmlManager$MediaXmlManager var9 = (VastXmlManager$MediaXmlManager)var8.next();
            String var10 = var9.getType();
            var6 = var9.getMediaUrl();
            if(VIDEO_MIME_TYPES.contains(var10) && var6 != null) {
               Integer var11 = var9.getWidth();
               Integer var13 = var9.getHeight();
               if(var11 != null && var11.intValue() > 0 && var13 != null && var13.intValue() > 0) {
                  double var4 = this.calculateFitness(var11.intValue(), var13.intValue());
                  if(var4 < var2) {
                     var2 = var4;
                     var12 = var6;
                  }
               }
            } else {
               var8.remove();
            }
         }

         var6 = var12;
         if(var12 == null) {
            var6 = var12;
            if(!var7.isEmpty()) {
               var6 = ((VastXmlManager$MediaXmlManager)var7.get(0)).getMediaUrl();
            }
         }

         return var6;
      }
   }

   @Deprecated
   int getScreenArea() {
      return this.mScreenArea;
   }

   @Deprecated
   double getScreenAspectRatio() {
      return this.mScreenAspectRatio;
   }

   public void onAggregationComplete(List var1) {
      this.mVastXmlManagerAggregator = null;
      if(var1 == null) {
         this.mVastManagerListener.onVastVideoConfigurationPrepared((VastVideoConfiguration)null);
      } else {
         final VastVideoConfiguration var4 = this.createVastVideoConfigurationFromXml(var1);
         if(this.updateDiskMediaFileUrl(var4)) {
            this.mVastManagerListener.onVastVideoConfigurationPrepared(var4);
         } else {
            VastVideoDownloadTask var2 = new VastVideoDownloadTask(new VastVideoDownloadTask$VastVideoDownloadTaskListener() {
               public void onComplete(boolean var1) {
                  if(var1 && VastManager.this.updateDiskMediaFileUrl(var4)) {
                     VastManager.this.mVastManagerListener.onVastVideoConfigurationPrepared(var4);
                  } else {
                     VastManager.this.mVastManagerListener.onVastVideoConfigurationPrepared((VastVideoConfiguration)null);
                  }
               }
            });

            try {
               AsyncTasks.safeExecuteOnExecutor(var2, new String[]{var4.getNetworkMediaFileUrl()});
            } catch (Exception var3) {
               MoPubLog.d("Failed to download vast video", var3);
               this.mVastManagerListener.onVastVideoConfigurationPrepared((VastVideoConfiguration)null);
            }
         }
      }
   }

   public void prepareVastVideoConfiguration(String var1, VastManager$VastManagerListener var2) {
      if(this.mVastXmlManagerAggregator == null) {
         this.mVastManagerListener = var2;
         this.mVastXmlManagerAggregator = new VastXmlManagerAggregator(this);

         try {
            AsyncTasks.safeExecuteOnExecutor(this.mVastXmlManagerAggregator, new String[]{var1});
         } catch (Exception var3) {
            MoPubLog.d("Failed to aggregate vast xml", var3);
            this.mVastManagerListener.onVastVideoConfigurationPrepared((VastVideoConfiguration)null);
            return;
         }
      }

   }
}
