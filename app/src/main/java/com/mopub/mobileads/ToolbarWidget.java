package com.mopub.mobileads;

import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.ToolbarWidget$Builder;
import com.mopub.mobileads.resource.TextDrawable;

class ToolbarWidget extends RelativeLayout {
   private static final int IMAGE_PADDING_DIPS = 5;
   private static final int IMAGE_SIDE_LENGTH_DIPS = 37;
   private static final int TEXT_PADDING_DIPS = 5;
   private final int mImagePadding;
   private final int mImageSideLength;
   private ImageView mImageView;
   private final int mTextPadding;
   private TextView mTextView;

   private ToolbarWidget(ToolbarWidget$Builder var1) {
      super(ToolbarWidget$Builder.access$0(var1));
      LayoutParams var2 = new LayoutParams(0, -2, ToolbarWidget$Builder.access$1(var1));
      var2.gravity = ToolbarWidget$Builder.access$2(var1);
      this.setLayoutParams(var2);
      this.mTextPadding = Dips.dipsToIntPixels(5.0F, this.getContext());
      this.mImagePadding = Dips.dipsToIntPixels(5.0F, this.getContext());
      this.mImageSideLength = Dips.dipsToIntPixels(37.0F, this.getContext());
      this.setVisibility(ToolbarWidget$Builder.access$3(var1));
      android.widget.RelativeLayout.LayoutParams var3;
      if(ToolbarWidget$Builder.access$4(var1) && ToolbarWidget$Builder.access$5(var1) != null) {
         this.mImageView = new ImageView(this.getContext());
         this.mImageView.setId((int)Utils.generateUniqueId());
         var3 = new android.widget.RelativeLayout.LayoutParams(this.mImageSideLength, this.mImageSideLength);
         var3.addRule(15);
         var3.addRule(ToolbarWidget$Builder.access$6(var1));
         this.mImageView.setPadding(this.mImagePadding, this.mImagePadding, this.mImagePadding, this.mImagePadding);
         this.mImageView.setBackgroundColor(-16777216);
         this.mImageView.getBackground().setAlpha(0);
         this.mImageView.setImageDrawable(ToolbarWidget$Builder.access$5(var1));
         this.addView(this.mImageView, var3);
      }

      if(ToolbarWidget$Builder.access$7(var1)) {
         this.mTextView = new TextView(this.getContext());
         this.mTextView.setSingleLine();
         this.mTextView.setEllipsize(TruncateAt.END);
         this.mTextView.setText(ToolbarWidget$Builder.access$8(var1));
         var3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
         var3.addRule(15);
         if(this.mImageView != null) {
            var3.addRule(0, this.mImageView.getId());
         } else {
            var3.addRule(ToolbarWidget$Builder.access$9(var1));
         }

         this.mTextView.setPadding(this.mTextPadding, this.mTextPadding, this.mTextPadding, this.mTextPadding);
         this.addView(this.mTextView, var3);
      }

      if(ToolbarWidget$Builder.access$10(var1) != null) {
         this.setOnTouchListener(ToolbarWidget$Builder.access$10(var1));
      }

   }

   // $FF: synthetic method
   ToolbarWidget(ToolbarWidget$Builder var1, ToolbarWidget var2) {
      this(var1);
   }

   @Deprecated
   TextDrawable getImageViewDrawable() {
      return (TextDrawable)this.mImageView.getDrawable();
   }

   @Deprecated
   void setImageViewDrawable(TextDrawable var1) {
      this.mImageView.setImageDrawable((Drawable)var1);
   }

   void updateImageText(String var1) {
      try {
         ((TextDrawable)this.mImageView.getDrawable()).updateText(var1);
      } catch (Exception var2) {
         MoPubLog.d("Unable to update ToolbarWidget text.");
      }
   }

   void updateText(String var1) {
      if(this.mTextView != null) {
         this.mTextView.setText(var1);
      }

   }
}
