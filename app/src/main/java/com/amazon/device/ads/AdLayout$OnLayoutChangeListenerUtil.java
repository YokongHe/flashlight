package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.amazon.device.ads.AdLayout;

class AdLayout$OnLayoutChangeListenerUtil {
   @TargetApi(11)
   protected static void setOnLayoutChangeListenerForRoot(final AdLayout var0) {
      OnLayoutChangeListener var1 = new OnLayoutChangeListener() {
         public final void onLayoutChange(View var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
            if(var0.getAndSetNeedsToLoadAdOnLayout(false)) {
               var0.setFloatingWindowDimensions();
               AdLayout.access$200(var0);
               AdLayout.access$300(var0).removeOnLayoutChangeListener(this);
            }

         }
      };
      AdLayout.access$300(var0).addOnLayoutChangeListener(var1);
   }
}
