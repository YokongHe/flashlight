package com.millennialmedia.android;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

class InlineVideoView$VideoTouchListener implements OnTouchListener {
   private WeakReference inlineVideoRef;

   public InlineVideoView$VideoTouchListener(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      InlineVideoView var3 = (InlineVideoView)this.inlineVideoRef.get();
      return var3 != null?var3.onTouch(var1, var2):true;
   }
}
