package com.smaato.soma.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.smaato.soma.AdDimension;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AdSettings;
import com.smaato.soma.BaseInterface;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.InterstitialInitializationFailed;
import com.smaato.soma.exception.UnableToFindInterstitialBannerView;
import com.smaato.soma.internal.requests.RequestsBuilder;
import com.smaato.soma.internal.requests.settings.DeviceDataCollector;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.interstitial.Interstitial$InterstitialOrientation;
import com.smaato.soma.interstitial.Interstitial$InterstitialStates;
import com.smaato.soma.interstitial.InterstitialActivity;
import com.smaato.soma.interstitial.InterstitialAdListener;
import com.smaato.soma.interstitial.InterstitialBannerView;

public class Interstitial implements AdListenerInterface, BaseInterface {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$smaato$soma$interstitial$Interstitial$InterstitialOrientation;
   static InterstitialAdListener interstitialAdListener;
   static InterstitialBannerView mInterstitialBannerView;
   String TAG = "Interstitial";
   private Interstitial$InterstitialOrientation interstitialOrientation;
   Activity mActivity;
   Interstitial$InterstitialStates states;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$smaato$soma$interstitial$Interstitial$InterstitialOrientation() {
      int[] var0 = $SWITCH_TABLE$com$smaato$soma$interstitial$Interstitial$InterstitialOrientation;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[Interstitial$InterstitialOrientation.values().length];

         try {
            var0[Interstitial$InterstitialOrientation.LANDSCAPE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[Interstitial$InterstitialOrientation.PORTRAIT.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$smaato$soma$interstitial$Interstitial$InterstitialOrientation = var0;
         return var0;
      }
   }

   public Interstitial(final Activity var1) {
      this.interstitialOrientation = Interstitial$InterstitialOrientation.PORTRAIT;
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.this.init(var1);
            return null;
         }
      }).execute();
   }

   protected static InterstitialBannerView getBanner() {
      try {
         if(mInterstitialBannerView.getParent() != null) {
            ((ViewGroup)mInterstitialBannerView.getParent()).removeView(mInterstitialBannerView);
         }

         InterstitialBannerView var0 = mInterstitialBannerView;
         return var0;
      } catch (RuntimeException var1) {
         throw var1;
      } catch (Exception var2) {
         throw new UnableToFindInterstitialBannerView(var2);
      }
   }

   private Interstitial$InterstitialOrientation getInterstitialOrientation() {
      return this.interstitialOrientation;
   }

   private void init(Activity var1) {
      try {
         this.mActivity = var1;
         InterstitialBannerView var4 = new InterstitialBannerView(this.mActivity);
         mInterstitialBannerView = var4;
         var4.setInterstitialParent(this);
         mInterstitialBannerView.addAdListener(this);
         mInterstitialBannerView.setScalingEnabled(false);
         this.setDimension();
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new InterstitialInitializationFailed(var3);
      }
   }

   private void setDimension() {
      switch($SWITCH_TABLE$com$smaato$soma$interstitial$Interstitial$InterstitialOrientation()[this.getInterstitialOrientation().ordinal()]) {
      case 2:
         mInterstitialBannerView.getAdSettings().setAdDimension(AdDimension.INTERSTITIAL_LANDSCAPE);
         RequestsBuilder.getInstance().setPortrait(false);
         return;
      default:
         mInterstitialBannerView.getAdSettings().setAdDimension(AdDimension.INTERSTITIAL_PORTRAIT);
      }
   }

   private void setInterstitialOrientation(Interstitial$InterstitialOrientation var1) {
      this.interstitialOrientation = var1;
      this.setDimension();
   }

   public void asyncLoadNewBanner() {
      (new CrashReportTemplate() {
         public Void process() {
            if(DeviceDataCollector.getInstance().isPortrait()) {
               Interstitial.this.setInterstitialOrientation(Interstitial$InterstitialOrientation.PORTRAIT);
            } else {
               Interstitial.this.setInterstitialOrientation(Interstitial$InterstitialOrientation.LANDSCAPE);
            }

            Interstitial.mInterstitialBannerView.asyncLoadNewBanner();
            return null;
         }
      }).execute();
   }

   public AdSettings getAdSettings() {
      return (AdSettings)(new CrashReportTemplate() {
         public AdSettings process() {
            return Interstitial.mInterstitialBannerView.getAdSettings();
         }
      }).execute();
   }

   public UserSettings getUserSettings() {
      return (UserSettings)(new CrashReportTemplate() {
         public UserSettings process() {
            return Interstitial.mInterstitialBannerView.getUserSettings();
         }
      }).execute();
   }

   public boolean isInterstitialReady() {
      return this.states == Interstitial$InterstitialStates.IS_READY;
   }

   public boolean isLocationUpdateEnabled() {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            return Boolean.valueOf(Interstitial.mInterstitialBannerView.isLocationUpdateEnabled());
         }
      }).execute()).booleanValue();
   }

   public void onReceiveAd(AdDownloaderInterface var1, final ReceivedBannerInterface var2) {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.interstitialAdListener == null) {
               return null;
            } else if(var2.getStatus() == BannerStatus.SUCCESS) {
               Interstitial.mInterstitialBannerView.setShouldNotifyIdle(true);
               return null;
            } else {
               Interstitial.mInterstitialBannerView.setShouldNotifyIdle(false);
               Interstitial.interstitialAdListener.onFailedToLoadAd();
               Interstitial.this.setStateToNotReady();
               return null;
            }
         }
      }).execute();
   }

   public void setAdSettings(final AdSettings var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.mInterstitialBannerView.setAdSettings(var1);
            return null;
         }
      }).execute();
   }

   public void setBackgroundColor(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.mInterstitialBannerView.setBackgroundColor(var1);
            return null;
         }
      }).execute();
   }

   public void setInterstitialAdListener(InterstitialAdListener var1) {
      interstitialAdListener = var1;
   }

   public void setLocationUpdateEnabled(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.mInterstitialBannerView.setLocationUpdateEnabled(var1);
            return null;
         }
      }).execute();
   }

   protected void setStateToNotReady() {
      this.states = Interstitial$InterstitialStates.IS_NOT_READY;
   }

   protected void setStateToReady() {
      this.states = Interstitial$InterstitialStates.IS_READY;
   }

   public void setUserSettings(final UserSettings var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.mInterstitialBannerView.setUserSettings(var1);
            return null;
         }
      }).execute();
   }

   public void show() {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.this.isInterstitialReady()) {
               (new Thread(new Runnable() {
                  public void run() {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(Interstitial.interstitialAdListener != null) {
                              Interstitial.interstitialAdListener.onWillShow();
                           }

                           Interstitial.this.setStateToNotReady();
                           Intent var1 = new Intent(Interstitial.this.mActivity, InterstitialActivity.class);
                           if(Interstitial.this.getInterstitialOrientation() == Interstitial$InterstitialOrientation.PORTRAIT) {
                              var1.putExtra("isPortrait", true);
                           } else {
                              var1.putExtra("isPortrait", false);
                           }

                           Interstitial.this.mActivity.startActivity(var1);
                           return null;
                        }
                     }).execute();
                  }
               })).start();
            } else {
               Debugger.showLog(new LogMessage(Interstitial.this.TAG, "Interstitial Banner not ready", 1, DebugCategory.DEBUG));
            }

            return null;
         }
      }).execute();
   }
}
