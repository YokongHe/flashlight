package com.millennialmedia.android;

import android.view.View;
import android.view.View.OnClickListener;
import com.millennialmedia.android.InlineVideoView;
import java.lang.ref.WeakReference;

final class InlineVideoView$MediaController$MediaClickListener implements OnClickListener {
   private WeakReference inlineVideoRef;

   public InlineVideoView$MediaController$MediaClickListener(InlineVideoView var1) {
      this.inlineVideoRef = new WeakReference(var1);
   }

   public final void onClick(View var1) {
      InlineVideoView var2 = (InlineVideoView)this.inlineVideoRef.get();
      if(var2 != null) {
         var2.onMediaControllerClick(var1);
      }

   }
}
