package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import com.millennialmedia.android.MMActivity;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMSDK$Event;
import java.lang.ref.WeakReference;

class MMActivity$InterstitialGestureListener extends SimpleOnGestureListener {
   WeakReference mmActivityRef;

   public MMActivity$InterstitialGestureListener(MMActivity var1) {
      this.mmActivityRef = new WeakReference(var1);
   }

   public boolean onSingleTapConfirmed(MotionEvent var1) {
      MMActivity var2 = (MMActivity)this.mmActivityRef.get();
      if(var2 != null) {
         MMSDK$Event.adSingleTap(MMAdImplController.getAdImplWithId(var2.creatorAdImplInternalId));
      }

      return false;
   }
}
