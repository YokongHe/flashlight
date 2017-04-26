package com.inmobi.monetization;

import android.app.Activity;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMIncentivisedListener;
import com.inmobi.monetization.IMInterstitial$State;
import com.inmobi.monetization.IMInterstitialListener;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.InterstitialAd;
import java.util.HashMap;
import java.util.Map;

public class IMInterstitial {
   InterstitialAd a;
   boolean b;
   IMAdListener c;
   private IMInterstitialListener d;
   private IMIncentivisedListener e;
   private long f = -1L;
   private Activity g;
   private IMInterstitial$State h;
   private String i;

   public IMInterstitial(Activity var1, long var2) {
      this.h = IMInterstitial$State.INIT;
      this.i = null;
      this.b = false;
      this.c = new IMAdListener() {
         public void onAdInteraction(Map var1) {
            IMInterstitial.this.a(105, (AdErrorCode)null, var1);
         }

         public void onAdRequestFailed(AdErrorCode var1) {
            IMInterstitial.this.h = IMInterstitial$State.INIT;
            IMInterstitial.this.a(101, var1, (Map)null);
         }

         public void onAdRequestSucceeded() {
            IMInterstitial.this.h = IMInterstitial$State.READY;
            IMInterstitial.this.a(100, (AdErrorCode)null, (Map)null);
         }

         public void onDismissAdScreen() {
            IMInterstitial.this.h = IMInterstitial$State.INIT;
            IMInterstitial.this.a(103, (AdErrorCode)null, (Map)null);
         }

         public void onIncentCompleted(Map var1) {
            IMInterstitial.this.a(106, (AdErrorCode)null, var1);
         }

         public void onLeaveApplication() {
            IMInterstitial.this.a(104, (AdErrorCode)null, (Map)null);
         }

         public void onShowAdScreen() {
            IMInterstitial.this.h = IMInterstitial$State.ACTIVE;
            IMInterstitial.this.a(102, (AdErrorCode)null, (Map)null);
         }
      };
      this.g = var1;
      this.f = var2;
      this.a();
   }

   public IMInterstitial(Activity var1, String var2) {
      this.h = IMInterstitial$State.INIT;
      this.i = null;
      this.b = false;
      this.c = new IMAdListener() {
         public void onAdInteraction(Map var1) {
            IMInterstitial.this.a(105, (AdErrorCode)null, var1);
         }

         public void onAdRequestFailed(AdErrorCode var1) {
            IMInterstitial.this.h = IMInterstitial$State.INIT;
            IMInterstitial.this.a(101, var1, (Map)null);
         }

         public void onAdRequestSucceeded() {
            IMInterstitial.this.h = IMInterstitial$State.READY;
            IMInterstitial.this.a(100, (AdErrorCode)null, (Map)null);
         }

         public void onDismissAdScreen() {
            IMInterstitial.this.h = IMInterstitial$State.INIT;
            IMInterstitial.this.a(103, (AdErrorCode)null, (Map)null);
         }

         public void onIncentCompleted(Map var1) {
            IMInterstitial.this.a(106, (AdErrorCode)null, var1);
         }

         public void onLeaveApplication() {
            IMInterstitial.this.a(104, (AdErrorCode)null, (Map)null);
         }

         public void onShowAdScreen() {
            IMInterstitial.this.h = IMInterstitial$State.ACTIVE;
            IMInterstitial.this.a(102, (AdErrorCode)null, (Map)null);
         }
      };
      this.g = var1;
      this.i = var2;
      this.a();
   }

   private void a() {
      if(this.f > 0L) {
         this.a = new InterstitialAd(this.g, this.f);
      } else {
         this.a = new InterstitialAd(this.g, this.i);
      }

      this.a.setAdListener(this.c);
   }

   private void a(final int var1, final AdErrorCode var2, final Map var3) {
      if(this.d != null) {
         this.g.runOnUiThread(new Runnable() {
            public void run() {
               switch(var1) {
               case 100:
                  IMInterstitial.this.d.onInterstitialLoaded(IMInterstitial.this);
                  return;
               case 101:
                  IMInterstitial.this.d.onInterstitialFailed(IMInterstitial.this, IMErrorCode.a(var2));
                  return;
               case 102:
                  IMInterstitial.this.d.onShowInterstitialScreen(IMInterstitial.this);
                  return;
               case 103:
                  IMInterstitial.this.d.onDismissInterstitialScreen(IMInterstitial.this);
                  return;
               case 104:
                  IMInterstitial.this.d.onLeaveApplication(IMInterstitial.this);
                  return;
               case 105:
                  IMInterstitial.this.d.onInterstitialInteraction(IMInterstitial.this, var3);
                  return;
               case 106:
                  if(IMInterstitial.this.e != null) {
                     IMInterstitial.this.e.onIncentCompleted(IMInterstitial.this, var3);
                     return;
                  }
                  break;
               default:
                  Log.debug("[InMobi]-[Monetization]", var2.toString());
               }

            }
         });
      }
   }

   @Deprecated
   public void destroy() {
   }

   public void disableHardwareAcceleration() {
      this.b = true;
   }

   public IMInterstitial$State getState() {
      return this.h;
   }

   public void loadInterstitial() {
      IMErrorCode var1;
      if(this.a != null) {
         if(this.h == IMInterstitial$State.LOADING) {
            var1 = IMErrorCode.INVALID_REQUEST;
            var1.setMessage("Ad download in progress. Your request cannot be processed at this time. Try again later.");
            Log.debug("[InMobi]-[Monetization]", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
            this.d.onInterstitialFailed(this, var1);
         } else if(this.h == IMInterstitial$State.ACTIVE) {
            var1 = IMErrorCode.INVALID_REQUEST;
            var1.setMessage("Interstitial ad is in ACTIVE state. Try again after sometime.");
            Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
            this.d.onInterstitialFailed(this, var1);
         } else {
            this.h = IMInterstitial$State.LOADING;
            this.a.loadAd();
         }
      } else {
         var1 = IMErrorCode.INVALID_REQUEST;
         Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
         this.d.onInterstitialFailed(this, var1);
      }
   }

   public void setAppId(String var1) {
      if(this.a != null) {
         this.a.setAppId(var1);
      }

   }

   public void setIMIncentivisedListener(IMIncentivisedListener var1) {
      this.e = var1;
   }

   public void setIMInterstitialListener(IMInterstitialListener var1) {
      this.d = var1;
   }

   public void setKeywords(String var1) {
      if(var1 != null && !"".equals(var1.trim())) {
         if(this.a != null) {
            this.a.setKeywords(var1);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
      }

   }

   @Deprecated
   public void setRefTagParam(String var1, String var2) {
      if(var1 != null && var2 != null) {
         if(var1.trim().equals("") || var2.trim().equals("")) {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
            return;
         }

         HashMap var3 = new HashMap();
         var3.put(var1, var2);
         if(this.a != null) {
            this.a.setRequestParams(var3);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
      }

   }

   public void setRequestParams(Map var1) {
      if(var1 != null && !var1.isEmpty()) {
         if(this.a != null) {
            this.a.setRequestParams(var1);
            return;
         }
      } else {
         Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
      }

   }

   public void setSlotId(long var1) {
      if(this.a != null) {
         this.a.setSlotId(var1);
      }

   }

   public void show() {
      if(this.a != null && this.h == IMInterstitial$State.READY) {
         this.a.show();
      } else {
         Log.debug("[InMobi]-[Monetization]", "Interstitial ad is not in the \'READY\' state. Current state: " + this.h);
      }
   }

   @Deprecated
   public void show(long var1) {
      if(this.a != null) {
         this.a.show(var1);
      }

   }

   public void stopLoading() {
      if(this.a != null) {
         this.a.stopLoading();
      }

   }
}
