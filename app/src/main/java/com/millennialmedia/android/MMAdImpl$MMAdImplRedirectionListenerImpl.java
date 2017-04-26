package com.millennialmedia.android;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.millennialmedia.android.HandShake;
import com.millennialmedia.android.HttpRedirection$RedirectionListenerImpl;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMSDK$Event;
import java.lang.ref.WeakReference;

class MMAdImpl$MMAdImplRedirectionListenerImpl extends HttpRedirection$RedirectionListenerImpl {
   WeakReference adImplRef;

   public MMAdImpl$MMAdImplRedirectionListenerImpl(MMAdImpl var1) {
      if(var1 != null) {
         this.adImplRef = new WeakReference(var1);
         this.creatorAdImplInternalId = var1.internalId;
      }

   }

   public boolean isActivityStartable(Uri var1) {
      MMAdImpl var2 = (MMAdImpl)this.adImplRef.get();
      if(var2 != null) {
         Context var3 = var2.getContext();
         if(var3 != null && var3 instanceof Activity && ((Activity)var3).isFinishing()) {
            return false;
         }
      }

      return true;
   }

   public void startingActivity(Uri var1) {
      super.startingActivity(var1);
      if(var1.getScheme().equalsIgnoreCase("http") || var1.getScheme().equalsIgnoreCase("https")) {
         MMAdImpl var2 = (MMAdImpl)this.adImplRef.get();
         if(var2 != null) {
            MMSDK$Event.overlayOpened(var2);
         }
      }

   }

   public void updateLastVideoViewedTime() {
      MMAdImpl var1 = (MMAdImpl)this.adImplRef.get();
      if(var1 != null && var1.adType != null) {
         HandShake.sharedHandShake(var1.getContext()).updateLastVideoViewedTime(var1.getContext(), var1.adType);
      }

   }
}
