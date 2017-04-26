package com.mopub.nativeads;

import android.view.View;
import android.view.View.OnClickListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.NativeResponse;

@VisibleForTesting
class NativeResponse$NativeViewClickListener implements OnClickListener {
   // $FF: synthetic field
   final NativeResponse this$0;

   NativeResponse$NativeViewClickListener(NativeResponse var1) {
      this.this$0 = var1;
   }

   public void onClick(View var1) {
      this.this$0.handleClick(var1);
   }
}
