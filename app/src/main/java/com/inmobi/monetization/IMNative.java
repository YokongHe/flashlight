package com.inmobi.monetization;

import android.view.ViewGroup;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNativeListener;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.NativeAd;
import com.inmobi.monetization.internal.NativeAdObject;
import java.util.HashMap;
import java.util.Map;

public class IMNative {
   NativeAd a;
   private String b = null;
   private String c = null;
   private String d = null;
   private IMNativeListener e = null;
   private String f;
   private IMAdListener g = new IMAdListener() {
      public void onAdInteraction(Map var1) {
      }

      public void onAdRequestFailed(final AdErrorCode var1) {
         try {
            IMNative.this.a.getHandler().post(new Runnable() {
               public void run() {
                  if(IMNative.this.e != null) {
                     IMNative.this.e.onNativeRequestFailed(IMErrorCode.a(var1));
                  }

               }
            });
         } catch (Exception var2) {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
         }
      }

      public void onAdRequestSucceeded() {
         try {
            NativeAdObject var1 = IMNative.this.a.getNativeAdObject();
            IMNative.this.b = var1.getPubContent();
            IMNative.this.c = var1.getContextCode();
            IMNative.this.d = var1.getNameSpace();
            IMNative.this.a.getHandler().post(new Runnable() {
               public void run() {
                  try {
                     if(IMNative.this.e != null) {
                        IMNative.this.e.onNativeRequestSucceeded(IMNative.this);
                     }

                  } catch (Exception var2) {
                     var2.printStackTrace();
                     Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
                  }
               }
            });
         } catch (Exception var2) {
            Log.debug("[InMobi]-[Monetization]", "Failed to give callback");
         }
      }

      public void onDismissAdScreen() {
      }

      public void onIncentCompleted(Map var1) {
      }

      public void onLeaveApplication() {
      }

      public void onShowAdScreen() {
      }
   };

   public IMNative(IMNativeListener var1) {
      this.f = InMobi.getAppId();
      this.a(var1);
   }

   public IMNative(String var1, IMNativeListener var2) {
      this.f = var1;
      this.a(var2);
   }

   protected IMNative(String var1, String var2, String var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   private void a(IMNativeListener var1) {
      new NativeAdObject((String)null, (String)null, (String)null);
      this.e = var1;
      this.a = new NativeAd(this.f);
      this.a.setAdListener(this.g);
   }

   public void attachToView(ViewGroup var1) {
      if(this.a != null) {
         this.a.attachToView(var1, this.c, this.d);
      }

   }

   public void detachFromView() {
      if(this.a != null) {
         this.a.detachFromView();
      }

   }

   public String getContent() {
      return this.b;
   }

   public void handleClick(HashMap var1) {
      if(this.a != null) {
         this.a.handleClick(var1);
      }

   }

   public void loadAd() {
      if(this.a != null) {
         this.a.loadAd();
      }

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
}
