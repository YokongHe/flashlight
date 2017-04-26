package com.mopub.nativeads;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.MoPubNativeAdPositioning$Builder;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubServerPositioning;

public final class MoPubNativeAdPositioning {
   public static MoPubNativeAdPositioning$MoPubClientPositioning clientPositioning() {
      return new MoPubNativeAdPositioning$MoPubClientPositioning();
   }

   static MoPubNativeAdPositioning$MoPubClientPositioning clone(MoPubNativeAdPositioning$MoPubClientPositioning var0) {
      Preconditions.checkNotNull(var0);
      MoPubNativeAdPositioning$MoPubClientPositioning var1 = new MoPubNativeAdPositioning$MoPubClientPositioning();
      MoPubNativeAdPositioning$MoPubClientPositioning.access$0(var1).addAll(MoPubNativeAdPositioning$MoPubClientPositioning.access$0(var0));
      MoPubNativeAdPositioning$MoPubClientPositioning.access$2(var1, MoPubNativeAdPositioning$MoPubClientPositioning.access$1(var0));
      return var1;
   }

   @Deprecated
   public static MoPubNativeAdPositioning$Builder newBuilder() {
      return new MoPubNativeAdPositioning$Builder();
   }

   public static MoPubNativeAdPositioning$MoPubServerPositioning serverPositioning() {
      return new MoPubNativeAdPositioning$MoPubServerPositioning();
   }
}
