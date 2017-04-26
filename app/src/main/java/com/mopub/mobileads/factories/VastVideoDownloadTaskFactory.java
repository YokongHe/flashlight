package com.mopub.mobileads.factories;

import com.mopub.mobileads.VastVideoDownloadTask;
import com.mopub.mobileads.VastVideoDownloadTask$VastVideoDownloadTaskListener;

public class VastVideoDownloadTaskFactory {
   private static VastVideoDownloadTaskFactory instance = new VastVideoDownloadTaskFactory();

   public static VastVideoDownloadTask create(VastVideoDownloadTask$VastVideoDownloadTaskListener var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(VastVideoDownloadTaskFactory var0) {
      instance = var0;
   }

   protected VastVideoDownloadTask internalCreate(VastVideoDownloadTask$VastVideoDownloadTaskListener var1) {
      return new VastVideoDownloadTask(var1);
   }
}
