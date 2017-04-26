package com.mopub.mobileads.dfp.adapters;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener;
import com.mopub.mobileads.dfp.adapters.MoPubAdapter;

class MoPubAdapter$mMediationInterstitialListener implements MoPubInterstitial$InterstitialAdListener {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$mopub$mobileads$MoPubErrorCode;
   private com.google.a.a.f mMediationInterstitialListener;
   // $FF: synthetic field
   final MoPubAdapter this$0;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$mopub$mobileads$MoPubErrorCode() {
      int[] var0 = $SWITCH_TABLE$com$mopub$mobileads$MoPubErrorCode;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[MoPubErrorCode.values().length];

         try {
            var0[MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR.ordinal()] = 6;
         } catch (NoSuchFieldError var14) {
            ;
         }

         try {
            var0[MoPubErrorCode.ADAPTER_NOT_FOUND.ordinal()] = 5;
         } catch (NoSuchFieldError var13) {
            ;
         }

         try {
            var0[MoPubErrorCode.CANCELLED.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
            ;
         }

         try {
            var0[MoPubErrorCode.INTERNAL_ERROR.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
            ;
         }

         try {
            var0[MoPubErrorCode.MRAID_LOAD_ERROR.ordinal()] = 10;
         } catch (NoSuchFieldError var10) {
            ;
         }

         try {
            var0[MoPubErrorCode.NETWORK_INVALID_STATE.ordinal()] = 9;
         } catch (NoSuchFieldError var9) {
            ;
         }

         try {
            var0[MoPubErrorCode.NETWORK_NO_FILL.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
            ;
         }

         try {
            var0[MoPubErrorCode.NETWORK_TIMEOUT.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
            ;
         }

         try {
            var0[MoPubErrorCode.NO_FILL.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
            ;
         }

         try {
            var0[MoPubErrorCode.SERVER_ERROR.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
            ;
         }

         try {
            var0[MoPubErrorCode.UNSPECIFIED.ordinal()] = 13;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[MoPubErrorCode.VIDEO_CACHE_ERROR.ordinal()] = 11;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[MoPubErrorCode.VIDEO_DOWNLOAD_ERROR.ordinal()] = 12;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$mopub$mobileads$MoPubErrorCode = var0;
         return var0;
      }
   }

   public MoPubAdapter$mMediationInterstitialListener(MoPubAdapter var1, com.google.a.a.f var2) {
      this.this$0 = var1;
      this.mMediationInterstitialListener = var2;
   }

   public void onInterstitialClicked(MoPubInterstitial var1) {
   }

   public void onInterstitialDismissed(MoPubInterstitial var1) {
      com.google.a.a.f var3 = this.mMediationInterstitialListener;
      MoPubAdapter var2 = this.this$0;
      var3.g();
   }

   public void onInterstitialFailed(MoPubInterstitial var1, MoPubErrorCode var2) {
      com.google.a.a.f var3;
      MoPubAdapter var4;
      switch($SWITCH_TABLE$com$mopub$mobileads$MoPubErrorCode()[var2.ordinal()]) {
      case 1:
         var3 = this.mMediationInterstitialListener;
         var4 = this.this$0;
         var3.b(com.google.a.b.b);
         return;
      case 2:
         var3 = this.mMediationInterstitialListener;
         var4 = this.this$0;
         var3.b(com.google.a.b.a);
         return;
      case 7:
         var3 = this.mMediationInterstitialListener;
         var4 = this.this$0;
         var3.b(com.google.a.b.c);
         return;
      default:
         var3 = this.mMediationInterstitialListener;
         var4 = this.this$0;
         var3.b(com.google.a.b.d);
      }
   }

   public void onInterstitialLoaded(MoPubInterstitial var1) {
      com.google.a.a.f var3 = this.mMediationInterstitialListener;
      MoPubAdapter var2 = this.this$0;
      var3.e();
   }

   public void onInterstitialShown(MoPubInterstitial var1) {
      com.google.a.a.f var3 = this.mMediationInterstitialListener;
      MoPubAdapter var2 = this.this$0;
      var3.f();
   }
}
