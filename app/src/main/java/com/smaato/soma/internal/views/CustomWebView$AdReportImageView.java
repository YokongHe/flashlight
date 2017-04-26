package com.smaato.soma.internal.views;

import android.content.Context;
import android.widget.ImageView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.views.CustomWebView;
import com.smaato.soma.toaster.CloseButtonImage;

public class CustomWebView$AdReportImageView extends ImageView {
   // $FF: synthetic field
   final CustomWebView this$0;

   public CustomWebView$AdReportImageView(CustomWebView var1, Context var2) {
      super(var2);
      this.this$0 = var1;
      (new CrashReportTemplate() {
         public Void process() {
            CustomWebView$AdReportImageView.this.setImageBitmap(CloseButtonImage.getInstance().getAdReportBitmap(CustomWebView$AdReportImageView.this.getResources(), CustomWebView$AdReportImageView.this.getContext()).getBitmap());
            return null;
         }
      }).execute();
   }
}
