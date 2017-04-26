package com.millennialmedia.android;

import android.content.Context;
import android.widget.RelativeLayout.LayoutParams;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMLayout;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMWebView;

class MMLayout$MMLayoutMMAdImpl extends MMAdImpl {
   // $FF: synthetic field
   final MMLayout this$0;

   public MMLayout$MMLayoutMMAdImpl(MMLayout var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   public void addView(MMWebView var1, LayoutParams var2) {
      MMLog.w("MMLayout", "MMLayout adding view (" + var1 + ") to " + this);
      this.this$0.addView(var1, var2);
   }

   MMLayout getCallingAd() {
      return this.this$0;
   }

   int getId() {
      return this.this$0.getId();
   }

   public void removeView(MMWebView var1) {
      this.this$0.removeView(var1);
   }

   public void setClickable(boolean var1) {
      this.this$0.setClickable(var1);
   }
}
