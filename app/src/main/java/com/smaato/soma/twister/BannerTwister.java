package com.smaato.soma.twister;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ViewFlipper;
import com.smaato.soma.AdSettings;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BannerView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.twister.BannerTwister$RequestBanner;
import com.smaato.soma.twister.enums.SomaAnimationType;
import com.smaato.soma.twister.exception.NotAbleToDetectBannerLoaded;
import com.smaato.soma.twister.exception.NotAbleToDetectBannerNotLoaded;
import com.smaato.soma.twister.interfaces.AdListener;
import com.smaato.soma.twister.interfaces.BannerTwisterInterface;
import com.smaato.soma.twister.utilities.AnimationFade;
import com.smaato.soma.twister.utilities.AnimationProvider;
import com.smaato.soma.twister.utilities.AnimationRotate;
import com.smaato.soma.twister.utilities.AnimationRotate3DXAxis;
import com.smaato.soma.twister.utilities.AnimationRotate3DYAxis;
import com.smaato.soma.twister.utilities.AnimationTranslate;
import java.util.Iterator;
import java.util.Vector;

public final class BannerTwister extends ViewFlipper implements BannerTwisterInterface {
   private AdListener adListener;
   private AnimationProvider animationProvider;
   private Vector banners = new Vector();
   private int presentBanners = 2;

   public BannerTwister(Context var1) {
      super(var1);
      this.initBanners();
   }

   public BannerTwister(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.initBanners();
   }

   protected final void bannerIsLoaded() {
      try {
         if(this.presentBanners < 2) {
            ++this.presentBanners;
         }

         if(this.presentBanners == 2) {
            this.startFlipping();
         }

         if(this.adListener != null) {
            this.adListener.onAdLoaded(this.presentBanners);
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new NotAbleToDetectBannerLoaded(var3);
      }
   }

   protected final void bannerIsNotLoaded() {
      try {
         if(this.presentBanners > 0) {
            --this.presentBanners;
         }

         if(this.presentBanners == 0) {
            this.stopFlipping();
            if(this.adListener != null) {
               this.adListener.onAdFailedToLoad(this.presentBanners);
            }
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new NotAbleToDetectBannerNotLoaded(var3);
      }
   }

   public final AdSettings getAdSettings() {
      return (AdSettings)(new CrashReportTemplate() {
         public AdSettings process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?((BannerView)var1.next()).getAdSettings():null;
         }
      }).execute();
   }

   public final int getAutoReloadFrequency() {
      return ((Integer)(new CrashReportTemplate() {
         public Integer process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?Integer.valueOf(((BannerView)var1.next()).getAutoReloadFrequency()):Integer.valueOf(-1);
         }
      }).execute()).intValue();
   }

   public final int getBackgroundColor() {
      return ((Integer)(new CrashReportTemplate() {
         public Integer process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?Integer.valueOf(((BannerView)var1.next()).getBackgroundColor()):Integer.valueOf(0);
         }
      }).execute()).intValue();
   }

   public final UserSettings getUserSettings() {
      return (UserSettings)(new CrashReportTemplate() {
         public UserSettings process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?((BannerView)var1.next()).getUserSettings():null;
         }
      }).execute();
   }

   protected final void initBanners() {
      (new CrashReportTemplate() {
         public Void process() {
            int var1 = 0;
            Debugger.setDebugMode(3);
            BannerTwister.this.setAnimateFirstView(false);

            while(var1 < 2) {
               BannerView var2 = new BannerView(BannerTwister.this.getContext());
               BannerTwister.this.banners.add(var2);
               BannerTwister.this.addView(var2);
               ++var1;
            }

            return null;
         }
      }).execute();
   }

   public final boolean isLocationUpdateEnabled() {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?Boolean.valueOf(((BannerView)var1.next()).isLocationUpdateEnabled()):Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }

   public final boolean isScalingEnabled() {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            Iterator var1 = BannerTwister.this.banners.iterator();
            return var1.hasNext()?Boolean.valueOf(((BannerView)var1.next()).isScalingEnabled()):Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }

   public final void loadBanners() {
      (new CrashReportTemplate() {
         public Void process() {
            ((Activity)BannerTwister.this.getContext()).runOnUiThread(new BannerTwister$RequestBanner(BannerTwister.this, (BannerTwister$RequestBanner)null));
            return null;
         }
      }).execute();
   }

   protected final void onAttachedToWindow() {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1 = BannerTwister.this.banners.iterator();

            while(var1.hasNext()) {
               ((BannerView)var1.next()).setAutoReloadEnabled(true);
            }

            BannerTwister.super.onAttachedToWindow();
            return null;
         }
      }).execute();
   }

   protected final void onDetachedFromWindow() {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1 = BannerTwister.this.banners.iterator();

            while(var1.hasNext()) {
               ((BannerView)var1.next()).setAutoReloadEnabled(false);
            }

            BannerTwister.super.onDetachedFromWindow();
            return null;
         }
      }).execute();
   }

   public final void onWindowFocusChanged(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            BannerTwister.super.onWindowFocusChanged(var1);
            Iterator var1x;
            if(var1) {
               var1x = BannerTwister.this.banners.iterator();

               while(var1x.hasNext()) {
                  ((BannerView)var1x.next()).setAutoReloadEnabled(true);
               }
            } else {
               var1x = BannerTwister.this.banners.iterator();

               while(var1x.hasNext()) {
                  ((BannerView)var1x.next()).setAutoReloadEnabled(false);
               }
            }

            return null;
         }
      }).execute();
   }

   public final void setAdListener(AdListener var1) {
      this.adListener = var1;
   }

   public final void setAdSettings(final AdSettings var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setAdSettings(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void setAnimation(final SomaAnimationType var1) {
      (new CrashReportTemplate() {
         // $FF: synthetic field
         private static int[] $SWITCH_TABLE$com$smaato$soma$twister$enums$SomaAnimationType;

         // $FF: synthetic method
         static int[] $SWITCH_TABLE$com$smaato$soma$twister$enums$SomaAnimationType() {
            int[] var0 = $SWITCH_TABLE$com$smaato$soma$twister$enums$SomaAnimationType;
            if(var0 != null) {
               return var0;
            } else {
               var0 = new int[SomaAnimationType.values().length];

               try {
                  var0[SomaAnimationType.FADE_ANIMATION.ordinal()] = 1;
               } catch (NoSuchFieldError var6) {
                  ;
               }

               try {
                  var0[SomaAnimationType.ROTATE_3D_X_AXIS_ANIMATION.ordinal()] = 5;
               } catch (NoSuchFieldError var5) {
                  ;
               }

               try {
                  var0[SomaAnimationType.ROTATE_3D_Y_AXIS_ANIMATION.ordinal()] = 4;
               } catch (NoSuchFieldError var4) {
                  ;
               }

               try {
                  var0[SomaAnimationType.ROTATE_ANIMATION.ordinal()] = 3;
               } catch (NoSuchFieldError var3) {
                  ;
               }

               try {
                  var0[SomaAnimationType.TRANSLATE_ANIMATION.ordinal()] = 2;
               } catch (NoSuchFieldError var2) {
                  ;
               }

               $SWITCH_TABLE$com$smaato$soma$twister$enums$SomaAnimationType = var0;
               return var0;
            }
         }

         public Void process() {
            switch($SWITCH_TABLE$com$smaato$soma$twister$enums$SomaAnimationType()[var1.ordinal()]) {
            case 1:
               BannerTwister.this.animationProvider = new AnimationFade(1000);
               BannerTwister.this.setInAnimation(BannerTwister.this.animationProvider.getInAnimation());
               BannerTwister.this.setOutAnimation(BannerTwister.this.animationProvider.getOutAnimation());
               break;
            case 2:
               BannerTwister.this.animationProvider = new AnimationTranslate(1000);
               BannerTwister.this.setInAnimation(BannerTwister.this.animationProvider.getInAnimation());
               BannerTwister.this.setOutAnimation(BannerTwister.this.animationProvider.getOutAnimation());
               break;
            case 3:
               BannerTwister.this.animationProvider = new AnimationRotate(1000);
               BannerTwister.this.setInAnimation(BannerTwister.this.animationProvider.getInAnimation());
               BannerTwister.this.setOutAnimation(BannerTwister.this.animationProvider.getOutAnimation());
               break;
            case 4:
               BannerTwister.this.animationProvider = new AnimationRotate3DYAxis(1000);
               BannerTwister.this.setInAnimation(BannerTwister.this.animationProvider.getInAnimation());
               BannerTwister.this.setOutAnimation(BannerTwister.this.animationProvider.getOutAnimation());
               break;
            case 5:
               BannerTwister.this.animationProvider = new AnimationRotate3DXAxis(1000);
               BannerTwister.this.setInAnimation(BannerTwister.this.animationProvider.getInAnimation());
               BannerTwister.this.setOutAnimation(BannerTwister.this.animationProvider.getOutAnimation());
            }

            return null;
         }
      }).execute();
   }

   public final void setAutoReloadFrequency(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setAutoReloadFrequency(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void setBannerStateListener(final BannerStateListener var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setBannerStateListener(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void setFlipInterval(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            if(var1 >= 5000) {
               BannerTwister.super.setFlipInterval(var1);
            } else {
               Debugger.showLog(new LogMessage("View", "Flip interval will be ignored, minimal interval is 5000 milliseconds ...", 1, DebugCategory.WARNING));
               BannerTwister.super.setFlipInterval(5000);
            }

            return null;
         }
      }).execute();
   }

   public final void setLocationUpdateEnabled(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setLocationUpdateEnabled(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void setScalingEnabled(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setScalingEnabled(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void setUserSettings(final UserSettings var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Iterator var1x = BannerTwister.this.banners.iterator();

            while(var1x.hasNext()) {
               ((BannerView)var1x.next()).setUserSettings(var1);
            }

            return null;
         }
      }).execute();
   }

   public final void startFlipping() {
      (new CrashReportTemplate() {
         public Void process() {
            if(BannerTwister.this.isFlipping()) {
               return null;
            } else {
               BannerTwister.super.startFlipping();
               return null;
            }
         }
      }).execute();
   }

   public final void stopFlipping() {
      (new CrashReportTemplate() {
         public Void process() {
            if(!BannerTwister.this.isFlipping()) {
               return null;
            } else {
               Log.i("Twist", "stopFlipping : BannerLoaded = " + BannerTwister.this.presentBanners);
               BannerTwister.super.stopFlipping();
               return null;
            }
         }
      }).execute();
   }
}
