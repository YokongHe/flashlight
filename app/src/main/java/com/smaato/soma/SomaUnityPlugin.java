package com.smaato.soma;

import android.app.Activity;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.AdDimension;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AdType;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.BannerAnimator;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.internal.requests.settings.UserSettings$Gender;
import com.smaato.soma.interstitial.Interstitial;
import com.smaato.soma.interstitial.InterstitialAdListener;
import com.unity3d.player.UnityPlayer;

public class SomaUnityPlugin implements AdListenerInterface, BannerStateListener {
   private static SomaUnityPlugin instance;
   private static BannerView mBannerView;

   public SomaUnityPlugin() {
      BannerAnimator.getInstance().setUnity(true);
   }

   private Activity getActivity() {
      return UnityPlayer.currentActivity;
   }

   public static SomaUnityPlugin getInstance() {
      if(instance == null) {
         instance = new SomaUnityPlugin();
      }

      return instance;
   }

   private int toDP(int var1) {
      return (int)TypedValue.applyDimension(1, (float)var1, this.getActivity().getResources().getDisplayMetrics());
   }

   public final void asyncLoadNewBanner() {
      mBannerView.asyncLoadNewBanner();
   }

   public final void hideView() {
      if(mBannerView != null) {
         mBannerView.setVisibility(4);
      }
   }

   public void initBannerView(final int var1, final int var2, final int var3, final int var4) {
      this.getActivity().runOnUiThread(new Runnable() {
         public void run() {
            if(SomaUnityPlugin.mBannerView == null) {
               Debugger.setDebugMode(3);
               SomaUnityPlugin.mBannerView = new BannerView(SomaUnityPlugin.this.getActivity());
               SomaUnityPlugin.mBannerView.getAdSettings().setPublisherId(var1);
               SomaUnityPlugin.mBannerView.getAdSettings().setAdspaceId(var2);
               SomaUnityPlugin.mBannerView.addAdListener(SomaUnityPlugin.this);
               SomaUnityPlugin.mBannerView.setBannerStateListener(SomaUnityPlugin.this);
               LayoutParams var1x;
               switch(var3) {
               case 0:
                  var1x = new LayoutParams(SomaUnityPlugin.this.toDP(320), SomaUnityPlugin.this.toDP(50));
                  SomaUnityPlugin.mBannerView.getAdSettings().setAdDimension(AdDimension.DEFAULT);
                  break;
               case 1:
                  var1x = new LayoutParams(SomaUnityPlugin.this.toDP(300), SomaUnityPlugin.this.toDP(250));
                  SomaUnityPlugin.mBannerView.getAdSettings().setAdDimension(AdDimension.MEDIUMRECTANGLE);
                  break;
               case 2:
                  var1x = new LayoutParams(SomaUnityPlugin.this.toDP(728), SomaUnityPlugin.this.toDP(90));
                  SomaUnityPlugin.mBannerView.getAdSettings().setAdDimension(AdDimension.LEADERBOARD);
                  break;
               case 3:
                  var1x = new LayoutParams(SomaUnityPlugin.this.toDP(120), SomaUnityPlugin.this.toDP(600));
                  SomaUnityPlugin.mBannerView.getAdSettings().setAdDimension(AdDimension.SKYSCRAPER);
                  break;
               default:
                  var1x = new LayoutParams(SomaUnityPlugin.this.toDP(320), SomaUnityPlugin.this.toDP(50));
                  SomaUnityPlugin.mBannerView.getAdSettings().setAdDimension(AdDimension.DEFAULT);
               }

               RelativeLayout var2x = new RelativeLayout(SomaUnityPlugin.this.getActivity());
               switch(var4) {
               case 0:
                  var1x.addRule(10);
                  break;
               case 1:
                  var1x.addRule(12);
                  break;
               default:
                  var1x.addRule(10);
               }

               var1x.addRule(13);
               var2x.addView(SomaUnityPlugin.mBannerView, var1x);
               var1x = new LayoutParams(-1, -1);
               SomaUnityPlugin.this.getActivity().addContentView(var2x, var1x);
            }
         }
      });
   }

   public final void initInterstitialAd(int var1, int var2) {
      final Interstitial var3 = new Interstitial(this.getActivity());
      var3.getAdSettings().setPublisherId(var1);
      var3.getAdSettings().setAdspaceId(var2);
      var3.setInterstitialAdListener(new InterstitialAdListener() {
         public void onFailedToLoadAd() {
            UnityPlayer.UnitySendMessage("SomaEventManager", "noAdAvailable", "");
         }

         public void onReadyToShow() {
            UnityPlayer.UnitySendMessage("SomaEventManager", "onReceiveBanner", "");
            var3.show();
         }

         public void onWillClose() {
            UnityPlayer.UnitySendMessage("SomaEventManager", "onWillCloseLandingPage", "");
         }

         public void onWillOpenLandingPage() {
            UnityPlayer.UnitySendMessage("SomaEventManager", "onWillOpenLandingPage", "");
         }

         public void onWillShow() {
         }
      });
      var3.asyncLoadNewBanner();
   }

   public void onReceiveAd(AdDownloaderInterface var1, ReceivedBannerInterface var2) {
      if(var2.getStatus() == BannerStatus.ERROR) {
         UnityPlayer.UnitySendMessage("SomaEventManager", "noAdAvailable", "");
      } else {
         UnityPlayer.UnitySendMessage("SomaEventManager", "onReceiveBanner", "");
      }
   }

   public void onWillCloseLandingPage(BaseView var1) {
      UnityPlayer.UnitySendMessage("SomaEventManager", "onWillCloseLandingPage", "");
      mBannerView.asyncLoadNewBanner();
   }

   public void onWillOpenLandingPage(BaseView var1) {
      UnityPlayer.UnitySendMessage("SomaEventManager", "onWillOpenLandingPage", "");
   }

   public final void setAdType(int var1) {
      switch(var1) {
      case 0:
         mBannerView.getAdSettings().setAdType(AdType.ALL);
         return;
      case 1:
         mBannerView.getAdSettings().setAdType(AdType.IMAGE);
         return;
      case 2:
         mBannerView.getAdSettings().setAdType(AdType.RICHMEDIA);
         return;
      case 3:
         mBannerView.getAdSettings().setAdType(AdType.TEXT);
         return;
      default:
         mBannerView.getAdSettings().setAdType(AdType.ALL);
      }
   }

   public final void setAge(int var1) {
      mBannerView.getUserSettings().setAge(var1);
   }

   public final void setAutoReloadEnabled(boolean var1) {
      mBannerView.setAutoReloadEnabled(var1);
   }

   public final void setAutoReloadFrequency(int var1) {
      mBannerView.setAutoReloadFrequency(var1);
   }

   public final void setCOPPA(Boolean var1) {
      mBannerView.getUserSettings().setCOPPA(var1.booleanValue());
   }

   public final void setCity(String var1) {
      mBannerView.getUserSettings().setCity(var1);
   }

   public final void setKeywordList(String var1) {
      mBannerView.getUserSettings().setKeywordList(var1);
   }

   public final void setLocationUpdateEnabled(boolean var1) {
      mBannerView.setLocationUpdateEnabled(var1);
   }

   public final void setRegion(String var1) {
      mBannerView.getUserSettings().setRegion(var1);
   }

   public final void setSearchQuery(String var1) {
      mBannerView.getUserSettings().setSearchQuery(var1);
   }

   public final void setUserGender(int var1) {
      switch(var1) {
      case 0:
         mBannerView.getUserSettings().setUserGender(UserSettings$Gender.MALE);
         return;
      case 1:
         mBannerView.getUserSettings().setUserGender(UserSettings$Gender.FEMALE);
         return;
      default:
         mBannerView.getUserSettings().setUserGender(UserSettings$Gender.UNSET);
      }
   }

   public final void showView() {
      if(mBannerView != null) {
         mBannerView.setVisibility(0);
      }
   }
}
