package com.millennialmedia.android;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMLog;

class MMAdView$ResizeView extends View {
   // $FF: synthetic field
   final MMAdView this$0;

   public MMAdView$ResizeView(MMAdView var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   void attachToContext(View var1) {
      synchronized(this){}

      try {
         MMAdView.access$100(this.this$0, var1);
         if(this.getParent() != null && this.getParent() instanceof ViewGroup) {
            ((ViewGroup)this.getParent()).addView(var1);
         }
      } finally {
         ;
      }

   }

   protected void onRestoreInstanceState(Parcelable var1) {
      MMLog.d("MMAdView", "onRestoreInstanceState");
      MMAdView.access$000(this.this$0, this.this$0);
      super.onRestoreInstanceState(var1);
   }

   protected Parcelable onSaveInstanceState() {
      MMLog.d("MMAdView", "onSaveInstanceState");
      this.attachToContext(this.this$0);
      return super.onSaveInstanceState();
   }
}
