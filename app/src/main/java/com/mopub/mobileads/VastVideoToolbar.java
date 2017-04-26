package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.ToolbarWidget;
import com.mopub.mobileads.ToolbarWidget$Builder;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CountdownDrawable;
import com.mopub.mobileads.resource.LearnMoreDrawable;

class VastVideoToolbar extends LinearLayout {
   private static final int THRESHOLD_FOR_HIDING_VIDEO_DURATION = 200;
   private static final int TOOLBAR_HEIGHT_DIPS = 44;
   private final ToolbarWidget mCloseButtonWidget;
   private final ToolbarWidget mCountdownWidget;
   private final ToolbarWidget mDurationWidget;
   private final ToolbarWidget mLearnMoreWidget;

   public VastVideoToolbar(Context var1) {
      super(var1);
      this.setId((int)Utils.generateUniqueId());
      this.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            return true;
         }
      });
      this.setLayoutParams(new LayoutParams(-1, Dips.dipsToIntPixels(44.0F, this.getContext())));
      this.setBackgroundColor(-16777216);
      this.getBackground().setAlpha(180);
      this.mDurationWidget = this.createDurationWidget();
      this.mLearnMoreWidget = this.createLearnMoreWidget();
      this.mCountdownWidget = this.createCountdownWidget();
      this.mCloseButtonWidget = this.createCloseButtonWidget();
      this.addView(this.mDurationWidget);
      this.addView(this.mLearnMoreWidget);
      this.addView(this.mCountdownWidget);
      this.addView(this.mCloseButtonWidget);
   }

   private ToolbarWidget createCloseButtonWidget() {
      return (new ToolbarWidget$Builder(this.getContext())).weight(1.0F).widgetGravity(21).defaultText("Close").drawable(new CloseButtonDrawable()).visibility(8).build();
   }

   private ToolbarWidget createCountdownWidget() {
      CountdownDrawable var1 = new CountdownDrawable(this.getContext());
      return (new ToolbarWidget$Builder(this.getContext())).weight(1.0F).widgetGravity(21).defaultText("Skip in").drawable(var1).visibility(4).build();
   }

   private ToolbarWidget createDurationWidget() {
      return (new ToolbarWidget$Builder(this.getContext())).weight(2.0F).widgetGravity(19).hasText().textAlign(9).build();
   }

   private ToolbarWidget createLearnMoreWidget() {
      return (new ToolbarWidget$Builder(this.getContext())).weight(1.0F).widgetGravity(21).defaultText("Learn More").drawable(new LearnMoreDrawable()).visibility(4).build();
   }

   @Deprecated
   ToolbarWidget getCloseButtonWidget() {
      return this.mCloseButtonWidget;
   }

   @Deprecated
   ToolbarWidget getCountdownWidget() {
      return this.mCountdownWidget;
   }

   String getDisplaySeconds(long var1) {
      return String.valueOf(Math.round(Math.ceil((double)((float)var1 / 1000.0F))));
   }

   @Deprecated
   ToolbarWidget getDurationWidget() {
      return this.mDurationWidget;
   }

   @Deprecated
   ToolbarWidget getLearnMoreWidget() {
      return this.mLearnMoreWidget;
   }

   void makeInteractable() {
      this.mCountdownWidget.setVisibility(8);
      this.mLearnMoreWidget.setVisibility(0);
      this.mCloseButtonWidget.setVisibility(0);
   }

   void setCloseButtonOnTouchListener(OnTouchListener var1) {
      this.mCloseButtonWidget.setOnTouchListener(var1);
   }

   void setLearnMoreButtonOnTouchListener(OnTouchListener var1) {
      this.mLearnMoreWidget.setOnTouchListener(var1);
   }

   void updateCountdownWidget(int var1) {
      if(var1 >= 0 && this.mCountdownWidget.getVisibility() == 4) {
         this.mCloseButtonWidget.setVisibility(8);
         this.mCountdownWidget.setVisibility(0);
      }

      this.mCountdownWidget.updateImageText(this.getDisplaySeconds((long)var1));
   }

   void updateDurationWidget(int var1) {
      if(var1 >= 200) {
         this.mDurationWidget.updateText("Ends in " + this.getDisplaySeconds((long)var1) + " seconds");
      } else if(var1 >= 0) {
         this.mDurationWidget.updateText("Thanks for watching");
         return;
      }

   }
}
