package com.smaato.soma.measurements;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.exception.DimensionCalculationFailed;
import com.smaato.soma.exception.GettingViewScreenLocationFailed;
import com.smaato.soma.exception.IntersectionCalculationFailed;
import com.smaato.soma.exception.RegisterClickFailed;
import com.smaato.soma.exception.RequestLimiterFailed;
import com.smaato.soma.exception.RequestTimeFrameCalculationFailed;
import com.smaato.soma.measurements.FraudesType;
import com.smaato.soma.measurements.Reporter;

public class BannerMeasurements {
   private static final int DELAY = 3000;
   private static final int MAX_REQUEST = 15;
   private static final int MIN_BANNER_HEIGHT = 50;
   private static final int MIN_BANNER_WIDTH = 320;
   private static final int ONE_MINUTE = 60000;
   private static final int THREE_SECONDS = 3000;
   private static long firstRequestTime = 0L;
   private static BannerMeasurements instance;
   private static long lastRequestTime = 0L;
   private static int requestCounter = 0;

   public static final BannerMeasurements getInstance() {
      if(instance == null) {
         instance = new BannerMeasurements();
      }

      return instance;
   }

   private boolean hasCorrectDimension(BaseView var1) {
      int var2;
      try {
         if(var1.getWidth() >= 320) {
            return true;
         }

         var2 = var1.getHeight();
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new DimensionCalculationFailed(var4);
      }

      if(var2 < 50) {
         return false;
      } else {
         return true;
      }
   }

   private boolean isOnScreen(BaseView var1) {
      boolean var2;
      try {
         var2 = var1.getGlobalVisibleRect(new Rect(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom()));
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new GettingViewScreenLocationFailed(var4);
      }

      return var2;
   }

   private boolean isOnTop(BaseView param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean isOverlap(BaseView var1, View var2) {
      try {
         boolean var3 = Rect.intersects(new Rect(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom()), new Rect(var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom()));
         return var3;
      } catch (RuntimeException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new IntersectionCalculationFailed(var5);
      }
   }

   private boolean stillInSameMinute() {
      long var1;
      long var3;
      try {
         var1 = System.currentTimeMillis();
         var3 = firstRequestTime;
      } catch (RuntimeException var6) {
         throw var6;
      } catch (Exception var7) {
         throw new RequestTimeFrameCalculationFailed(var7);
      }

      return var1 - var3 <= 60000L;
   }

   public final boolean canRequest() {
      try {
         if(firstRequestTime == 0L) {
            firstRequestTime = System.currentTimeMillis();
         }

         if(this.stillInSameMinute() && requestCounter < 15) {
            return true;
         } else if(!this.stillInSameMinute()) {
            firstRequestTime = System.currentTimeMillis();
            requestCounter = 0;
            return true;
         } else {
            Reporter.getInstance().report(FraudesType.UBER_FREQUENT_REQUEST);
            return false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new RequestLimiterFailed(var3);
      }
   }

   public final void didClick() {
      try {
         if(System.currentTimeMillis() - lastRequestTime <= 3000L) {
            Reporter.getInstance().report(FraudesType.AUTO_CLICK);
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new RegisterClickFailed(var3);
      }
   }

   public final void didRequest() {
      ++requestCounter;
   }

   public final void didView() {
      lastRequestTime = System.currentTimeMillis();
   }

   public final void verifyBannerDisplay(final BaseView var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Handler var1x = new Handler();
            if(!BannerMeasurements.this.isOnScreen(var1)) {
               var1x.postDelayed(new Runnable() {
                  public void run() {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(!BannerMeasurements.this.isOnScreen(var1)) {
                              Reporter.getInstance().report(FraudesType.BANNER_OFF_SCREEN);
                           }

                           return null;
                        }
                     }).execute();
                  }
               }, 3000L);
            }

            if(!BannerMeasurements.this.hasCorrectDimension(var1)) {
               var1x.postDelayed(new Runnable() {
                  public void run() {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(!BannerMeasurements.this.hasCorrectDimension(var1)) {
                              Reporter.getInstance().report(FraudesType.BANNER_DIMENSION);
                           }

                           return null;
                        }
                     }).execute();
                  }
               }, 3000L);
            }

            if(!BannerMeasurements.this.isOnTop(var1)) {
               var1x.postDelayed(new Runnable() {
                  public void run() {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(!BannerMeasurements.this.isOnTop(var1)) {
                              Reporter.getInstance().report(FraudesType.BANNER_OVERLAP);
                           }

                           return null;
                        }
                     }).execute();
                  }
               }, 3000L);
            }

            return null;
         }
      }).execute();
   }
}
