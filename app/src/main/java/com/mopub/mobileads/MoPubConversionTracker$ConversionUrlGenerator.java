package com.mopub.mobileads;

import com.mopub.common.BaseUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.mobileads.MoPubConversionTracker;

class MoPubConversionTracker$ConversionUrlGenerator extends BaseUrlGenerator {
   // $FF: synthetic field
   final MoPubConversionTracker this$0;

   private MoPubConversionTracker$ConversionUrlGenerator(MoPubConversionTracker var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   MoPubConversionTracker$ConversionUrlGenerator(MoPubConversionTracker var1, MoPubConversionTracker$ConversionUrlGenerator var2) {
      this(var1);
   }

   private void setPackageId(String var1) {
      this.addParam("id", var1);
   }

   public String generateUrlString(String var1) {
      this.initUrlString(var1, "/m/open");
      this.setApiVersion("6");
      this.addParam("id", MoPubConversionTracker.access$0(this.this$0));
      this.setAppVersion(ClientMetadata.getInstance(MoPubConversionTracker.access$1(this.this$0)).getAppVersion());
      this.appendAdvertisingInfoTemplates();
      return this.getFinalUrlString();
   }
}
