package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import java.lang.ref.WeakReference;

class MMLayout$LayoutGestureListener extends SimpleOnGestureListener {
   WeakReference layoutRef;

   public MMLayout$LayoutGestureListener(MMLayout var1) {
      this.layoutRef = new WeakReference(var1);
   }

   public boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
      if(var1 != null && var2 != null && Math.abs((int)(var2.getX() - var1.getX())) > 200 && Math.abs(var3) > Math.abs(var4)) {
         if(var3 > 0.0F) {
            if(MMSDK.logLevel == 0) {
               MMLog.i("MMLayout", "Enabling debug and verbose logging.");
               MMSDK.logLevel = 3;
            } else {
               MMLog.i("MMLayout", "Disabling debug and verbose logging.");
               MMSDK.logLevel = 0;
            }
         } else {
            MMLayout var5 = (MMLayout)this.layoutRef.get();
            if(var5 != null) {
               MMSDK.printDiagnostics(var5.adImpl);
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
