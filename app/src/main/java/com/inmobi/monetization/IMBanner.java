package com.inmobi.monetization;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.AnimationType;
import com.inmobi.commons.analytics.net.AnalyticsCommon$HttpRequestCallback;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.monetization.IMBannerListener;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.BannerAd;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.RequestResponseManager;
import java.util.HashMap;
import java.util.Map;

public final class IMBanner extends RelativeLayout {
   public static final int INMOBI_AD_UNIT_120X600 = 13;
   public static final int INMOBI_AD_UNIT_300X250 = 10;
   public static final int INMOBI_AD_UNIT_320X48 = 9;
   public static final int INMOBI_AD_UNIT_320X50 = 15;
   public static final int INMOBI_AD_UNIT_468X60 = 12;
   public static final int INMOBI_AD_UNIT_728X90 = 11;
   public static final int REFRESH_INTERVAL_MINIMUM = 0;
   public static final int REFRESH_INTERVAL_OFF = -1;
   IMAdListener a = new IMAdListener() {
      public void onAdInteraction(Map var1) {
         IMBanner.this.a(105, (AdErrorCode)null, var1);
      }

      public void onAdRequestFailed(AdErrorCode var1) {
         IMBanner.this.a(101, var1, (Map)null);
      }

      public void onAdRequestSucceeded() {
         IMBanner.this.a(100, (AdErrorCode)null, (Map)null);
      }

      public void onDismissAdScreen() {
         IMBanner.this.a(103, (AdErrorCode)null, (Map)null);
      }

      public void onIncentCompleted(Map var1) {
      }

      public void onLeaveApplication() {
         IMBanner.this.a(104, (AdErrorCode)null, (Map)null);
      }

      public void onShowAdScreen() {
         IMBanner.this.a(102, (AdErrorCode)null, (Map)null);
      }
   };
   private BannerAd b;
   private IMBannerListener c;
   private boolean d = true;
   private Activity e;
   private String f = null;
   private long g = -1L;
   private int h = 15;

   public IMBanner(Activity var1, long var2) {
      super(var1);
      this.e = var1;
      this.g = var2;
      this.a();
   }

   public IMBanner(Activity var1, String var2, int var3) {
      super(var1);
      this.f = var2;
      this.h = var3;
      this.e = var1;
      this.a();
   }

   public IMBanner(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.e = (Activity)var1;

      try {
         this.g = Long.parseLong(var2.getAttributeValue((String)null, "slotId"));
         this.a();
      } catch (Exception var5) {
         try {
            this.h = Integer.parseInt(var2.getAttributeValue((String)null, "adSize"));
         } catch (Exception var4) {
            ;
         }

         try {
            this.f = var2.getAttributeValue((String)null, "appId");
         } catch (Exception var3) {
            ;
         }

         this.a();
      }
   }

   // $FF: synthetic method
   static IMBannerListener a(IMBanner var0) {
      return var0.c;
   }

   private void a() {
      if(this.g > 0L) {
         this.b = new BannerAd(this.e, this, this.g, 15);
      } else {
         this.b = new BannerAd(this.e, this, this.f, this.h);
      }

      this.b.setAdListener(this.a);
      this.setRefreshInterval(Initializer.getConfigParams().getDefaultRefreshRate());
      LayoutParams var1 = new LayoutParams(-1, -1);
      this.addView(this.b.getView(), var1);
   }

   private void a(final int var1, final AdErrorCode var2, final Map var3) {
      if(!this.d) {
         Log.debug("[InMobi]-[Monetization]", "Banner not sending callback because the view is not added to any window.");
      } else if(this.c != null) {
         this.e.runOnUiThread(new Runnable() {
            public void run() {
               // $FF: Couldn't be decompiled
            }
         });
         return;
      }

   }

   private void b() {
      int var3 = 320;
      float var1 = this.e.getResources().getDisplayMetrics().density;
      int var2;
      switch(this.h) {
      case 9:
         var2 = 48;
         break;
      case 10:
         var3 = 300;
         var2 = 250;
         break;
      case 11:
         var3 = 729;
         var2 = 90;
         break;
      case 12:
         var3 = 468;
         var2 = 60;
         break;
      case 13:
         var3 = 120;
         var2 = 600;
         break;
      case 14:
      default:
         var3 = this.getLayoutParams().width;
         var2 = this.getLayoutParams().height;
         break;
      case 15:
         var2 = 50;
      }

      var3 = (int)((float)var3 * var1);
      var2 = (int)((float)var2 * var1);
      this.getLayoutParams().height = var2;
      this.getLayoutParams().width = var3;
      this.setLayoutParams(this.getLayoutParams());
   }

   @Deprecated
   public final void destroy() {
   }

   public final void disableHardwareAcceleration() {
      if(this.b != null) {
         this.b.disableHardwareAcceleration();
      }

   }

   public final void loadBanner() {
      if(this.b != null) {
         this.b.loadAd();
      } else {
         IMErrorCode var1 = IMErrorCode.INVALID_REQUEST;
         var1.setMessage("Banner Ad instance not created with valid paramters");
         this.c.onBannerRequestFailed(this, var1);
         Log.verbose("[InMobi]-[Monetization]", "Banner Ad instance not created with valid paramters");
      }
   }

   protected final void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.b();
      Log.debug("[InMobi]-[Monetization]", "onAttachedToWindow");
      this.d = true;
   }

   protected final void onDetachedFromWindow() {
      this.d = false;
      super.onDetachedFromWindow();
   }

   protected final void onWindowVisibilityChanged(int var1) {
      if(var1 == 0) {
         try {
            ThinICE.start(this.e);
         } catch (Exception var3) {
            Log.internal("[InMobi]-[Monetization]", "Cannot start ice. Activity is null");
         }

         if(this.b != null) {
            this.b.refreshAd();
         }
      } else if(this.b != null) {
         this.b.stopRefresh();
      }

      RequestResponseManager var2 = new RequestResponseManager();
      var2.init();
      var2.processClick(this.e.getApplicationContext(), (AnalyticsCommon$HttpRequestCallback)null);
   }

   public final void setAdSize(int var1) {
      if(this.b != null) {
         this.b.setAdSize(var1);
         this.h = var1;
      }

   }

   public final void setAnimationType(AnimationType var1) {
      if(this.b != null) {
         this.b.setAnimation(var1);
      }

   }

   public final void setAppId(String var1) {
      if(this.b != null) {
         this.b.setAppId(var1);
      }

   }

   public final void setIMBannerListener(IMBannerListener var1) {
      this.c = var1;
   }

   public final void setKeywords(String var1) {
      if(var1 != null && !"".equals(var1.trim())) {
         if(this.b != null) {
            this.b.setKeywords(var1);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
      }

   }

   @Deprecated
   public final void setRefTagParam(String var1, String var2) {
      if(var1 != null && var2 != null) {
         if(var1.trim().equals("") || var2.trim().equals("")) {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
            return;
         }

         HashMap var3 = new HashMap();
         var3.put(var1, var2);
         if(this.b != null) {
            this.b.setRequestParams(var3);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
      }

   }

   public final void setRefreshInterval(int var1) {
      if(this.b != null) {
         this.b.setRefreshInterval(var1);
      }

   }

   public final void setRequestParams(Map var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(this.b != null) {
            this.b.setRequestParams(var1);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
      }

   }

   public final void setSlotId(long var1) {
      if(this.b != null) {
         this.b.setSlotId(var1);
      }

   }

   public final void stopLoading() {
      if(this.b != null) {
         this.b.stopLoading();
      }

   }
}
