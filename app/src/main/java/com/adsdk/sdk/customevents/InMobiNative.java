package com.adsdk.sdk.customevents;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.adsdk.sdk.customevents.CustomEventNative;
import com.adsdk.sdk.customevents.CustomEventNative$CustomEventNativeListener;
import com.inmobi.commons.InMobi;
import com.inmobi.monetization.IMErrorCode;
import com.inmobi.monetization.IMNative;
import com.inmobi.monetization.IMNativeListener;
import java.util.HashMap;

public class InMobiNative extends CustomEventNative {
   private static boolean isInitialized;
   private IMNative loadedNative;

   // $FF: synthetic method
   static void access$0(InMobiNative var0, IMNative var1) {
      var0.loadedNative = var1;
   }

   private IMNativeListener createListener() {
      return new IMNativeListener() {
         // $FF: synthetic method
         static InMobiNative access$0(Object var0) {
            return InMobiNative.this;
         }

         public void onNativeRequestFailed(IMErrorCode var1) {
            if(InMobiNative.this.listener != null) {
               InMobiNative.this.listener.onCustomEventNativeFailed();
            }

         }

         public void onNativeRequestSucceeded(final IMNative var1) {
            (new Thread(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            })).start();
         }
      };
   }

   public void createNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, String var3, String var4) {
      this.listener = var2;

      try {
         Class.forName("com.inmobi.commons.InMobi");
         Class.forName("com.inmobi.monetization.IMErrorCode");
         Class.forName("com.inmobi.monetization.IMNative");
         Class.forName("com.inmobi.monetization.IMNativeListener");
      } catch (ClassNotFoundException var5) {
         if(var2 == null) {
            return;
         }

         var2.onCustomEventNativeFailed();
         return;
      }

      this.addImpressionTracker(var4);
      if(!isInitialized) {
         InMobi.initialize(var1, var3);
         isInitialized = true;
      }

      (new IMNative(var3, this.createListener())).loadAd();
   }

   public void handleClick() {
      this.loadedNative.handleClick((HashMap)null);
   }

   public void prepareImpression(View var1) {
      if(var1 != null && var1 instanceof ViewGroup) {
         this.loadedNative.attachToView((ViewGroup)var1);
      } else if(var1 != null && var1.getParent() instanceof ViewGroup) {
         this.loadedNative.attachToView((ViewGroup)var1.getParent());
         return;
      }

   }
}
