package com.smaato.soma;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import com.smaato.soma.AdDimension;
import com.smaato.soma.AdType;
import com.smaato.soma.BannerView$BannerHandler;
import com.smaato.soma.BannerViewInterface;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.BannerViewXmlAttributeFailed;
import com.smaato.soma.exception.UnableToPauseAutoReload;
import com.smaato.soma.exception.UnableToResumeAutoReload;
import com.smaato.soma.internal.requests.RequestsBuilder;
import com.smaato.soma.internal.requests.settings.UserSettings$Gender;

public class BannerView extends BaseView implements BannerViewInterface {
   private boolean mAutoReloadEnabled = true;
   private int mAutoReloadFrequency = 60;
   private boolean publisherAutoReloadSetting = true;
   private Runnable updateTimer = new Runnable() {
      public void run() {
         (new CrashReportTemplate() {
            public Void process() {
               BannerView.this.getBannerAnimatorHandler().removeCallbacks(BannerView.this.updateTimer);
               BannerView.this.asyncLoadNewBanner();
               if(BannerView.this.isAutoReloadEnabled()) {
                  BannerView.this.postDelayed(BannerView.this.updateTimer, (long)(BannerView.this.mAutoReloadFrequency * 1000));
               }

               return null;
            }
         }).execute();
      }
   };

   public BannerView(Context var1) {
      super(var1);
      (new CrashReportTemplate() {
         public Void process() {
            BannerView.this.initBannerView();
            return null;
         }
      }).execute();
   }

   public BannerView(Context var1, final AttributeSet var2) {
      super(var1, var2);
      (new CrashReportTemplate() {
         public Void process() {
            BannerView.this.initBannerView();
            BannerView.this.loadAttributesFromLayout(var2, 0);
            return null;
         }
      }).execute();
   }

   public BannerView(Context var1, final AttributeSet var2, int var3) {
      super(var1, var2, var3);
      (new CrashReportTemplate() {
         public Void process() {
            BannerView.this.initBannerView();
            BannerView.this.loadAttributesFromLayout(var2, 0);
            return null;
         }
      }).execute();
   }

   private boolean isAutoReloadEnabled() {
      return this.mAutoReloadEnabled;
   }

   private boolean loadAttributesFromLayout(AttributeSet param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private void readAttribute(String var1, String var2) {
      try {
         var2 = var2.trim();
         if(var1.equalsIgnoreCase("publisherId")) {
            this.getAdSettings().setPublisherId(Integer.parseInt(var2));
         } else if(var1.equalsIgnoreCase("adSpaceId")) {
            this.getAdSettings().setAdspaceId(Integer.parseInt(var2));
         } else if(var1.equalsIgnoreCase("autoReloadEnabled")) {
            this.setAutoReloadEnabled(Boolean.parseBoolean(var2));
         } else if(var1.equalsIgnoreCase("autoReloadFrequency")) {
            this.setAutoReloadFrequency(Integer.parseInt(var2));
         } else if(var1.equalsIgnoreCase("AdType")) {
            this.getAdSettings().setAdType(AdType.getValueForString(var2));
         } else if(var1.equalsIgnoreCase("backgroundColor")) {
            this.setBackgroundColor(Color.parseColor("#" + var2));
         } else if(var1.equalsIgnoreCase("locationUpdateEnabled")) {
            this.mAdDownloader.setLocationUpdateEnabled(Boolean.parseBoolean(var2));
         } else if(var1.equalsIgnoreCase("keywordList")) {
            this.getUserSettings().setKeywordList(var2);
         } else if(var1.equalsIgnoreCase("searchQuery")) {
            this.getUserSettings().setSearchQuery(var2);
         } else if(var1.equalsIgnoreCase("age")) {
            this.getUserSettings().setAge(Integer.parseInt(var2));
         } else if(var1.equalsIgnoreCase("gender")) {
            this.getUserSettings().setUserGender(UserSettings$Gender.getValueForString(var2));
         } else if(var1.equalsIgnoreCase("region")) {
            this.getUserSettings().setRegion(var2);
         } else if(var1.equalsIgnoreCase("city")) {
            this.getUserSettings().setCity(var2);
         } else if(var1.equalsIgnoreCase("latitude")) {
            this.getUserSettings().setLatitude(Double.parseDouble(var2));
         } else if(var1.equalsIgnoreCase("longitude")) {
            this.getUserSettings().setLongitude(Double.parseDouble(var2));
         } else if(var1.equalsIgnoreCase("userProfileEnabled")) {
            this.getUserSettings().setuserProfileEnabled(Boolean.parseBoolean(var2));
         } else if(var1.equalsIgnoreCase("adDimension")) {
            this.getAdSettings().setAdDimension(AdDimension.getValueForString(var2));
         } else if(var1.equalsIgnoreCase("bannerWidth")) {
            this.getAdSettings().setBannerWidth(Integer.parseInt(var2));
         } else if(var1.equalsIgnoreCase("bannerHeight")) {
            this.getAdSettings().setBannerHeight(Integer.parseInt(var2));
         } else {
            if(var1.equalsIgnoreCase("loadNewBanner") && Boolean.parseBoolean(var2)) {
               this.asyncLoadNewBanner();
            }

         }
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new BannerViewXmlAttributeFailed(var4);
      }
   }

   private void resumeAutoReload() {
      try {
         Debugger.methodStart(new Object() {
         });
         this.getBannerAnimatorHandler().removeCallbacksAndMessages((Object)null);
         this.getBannerAnimatorHandler().postDelayed(this.updateTimer, (long)(this.mAutoReloadFrequency * 1000));
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToResumeAutoReload(var3);
      }
   }

   public final int getAutoReloadFrequency() {
      return ((Integer)(new CrashReportTemplate() {
         public Integer process() {
            return Integer.valueOf(BannerView.this.mAutoReloadFrequency);
         }
      }).execute()).intValue();
   }

   public Handler getBannerAnimatorHandler() {
      if(this.handler == null) {
         this.setBannerAnimatorHandler(new BannerView$BannerHandler(this, this, (BannerView$BannerHandler)null));
      }

      return this.handler;
   }

   @Deprecated
   public void notifyOnPause() {
   }

   @Deprecated
   public void notifyOnResume() {
   }

   protected void onAttachedToWindow() {
      (new CrashReportTemplate() {
         public Void process() {
            if(BannerView.this.publisherAutoReloadSetting) {
               BannerView.this.resumeAutoReload();
            }

            return null;
         }
      }).execute();
      super.onAttachedToWindow();
   }

   protected final void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      (new CrashReportTemplate() {
         public Void process() {
            BannerView.this.pauseAutoReload();
            return null;
         }
      }).execute();
   }

   public final void onWindowFocusChanged(final boolean var1) {
      super.onWindowFocusChanged(var1);
      (new CrashReportTemplate() {
         public Void process() {
            if(var1 && BannerView.this.publisherAutoReloadSetting) {
               BannerView.this.resumeAutoReload();
            } else {
               BannerView.this.pauseAutoReload();
            }

            return null;
         }
      }).execute();
   }

   protected void pauseAutoReload() {
      try {
         Debugger.methodStart(new Object() {
         });
         this.mAutoReloadEnabled = false;
         this.getBannerAnimatorHandler().removeCallbacksAndMessages((Object)null);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToPauseAutoReload(var3);
      }
   }

   public void setAutoReloadEnabled(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.methodStart(new Object() {
            });
            BannerView.this.mAutoReloadEnabled = var1;
            if(BannerView.this.mAutoReloadEnabled) {
               BannerView.this.resumeAutoReload();
            } else {
               RequestsBuilder.getInstance().setAutoReloadFrequency(0);
               BannerView.this.pauseAutoReload();
            }

            BannerView.this.publisherAutoReloadSetting = BannerView.this.mAutoReloadEnabled;
            return null;
         }
      }).execute();
   }

   public final void setAutoReloadFrequency(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            if(var1 >= 10 && var1 <= 600) {
               BannerView.this.mAutoReloadFrequency = var1;
            } else {
               BannerView.this.mAutoReloadFrequency = 60;
            }

            RequestsBuilder.getInstance().setAutoReloadFrequency(BannerView.this.mAutoReloadFrequency);
            return null;
         }
      }).execute();
   }
}
