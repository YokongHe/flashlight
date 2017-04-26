package android.support.v4.widget;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SlidingPaneLayout$LayoutParams;
import android.support.v4.widget.ViewDragHelper$Callback;
import android.view.View;

class SlidingPaneLayout$DragHelperCallback extends ViewDragHelper$Callback {
   // $FF: synthetic field
   final SlidingPaneLayout this$0;

   private SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout var1, Object var2) {
      this(var1);
   }

   public int clampViewPositionHorizontal(View var1, int var2, int var3) {
      SlidingPaneLayout$LayoutParams var5 = (SlidingPaneLayout$LayoutParams)SlidingPaneLayout.access$400(this.this$0).getLayoutParams();
      var3 = this.this$0.getPaddingLeft();
      var3 += var5.leftMargin;
      int var4 = SlidingPaneLayout.access$700(this.this$0);
      return Math.min(Math.max(var2, var3), var4 + var3);
   }

   public int getViewHorizontalDragRange(View var1) {
      return SlidingPaneLayout.access$700(this.this$0);
   }

   public void onEdgeDragStarted(int var1, int var2) {
      SlidingPaneLayout.access$200(this.this$0).captureChildView(SlidingPaneLayout.access$400(this.this$0), var2);
   }

   public void onViewCaptured(View var1, int var2) {
      this.this$0.setAllChildrenVisible();
   }

   public void onViewDragStateChanged(int var1) {
      if(SlidingPaneLayout.access$200(this.this$0).getViewDragState() == 0) {
         if(SlidingPaneLayout.access$300(this.this$0) != 0.0F) {
            this.this$0.dispatchOnPanelOpened(SlidingPaneLayout.access$400(this.this$0));
            SlidingPaneLayout.access$502(this.this$0, true);
            return;
         }

         this.this$0.updateObscuredViewsVisibility(SlidingPaneLayout.access$400(this.this$0));
         this.this$0.dispatchOnPanelClosed(SlidingPaneLayout.access$400(this.this$0));
         SlidingPaneLayout.access$502(this.this$0, false);
      }

   }

   public void onViewPositionChanged(View var1, int var2, int var3, int var4, int var5) {
      SlidingPaneLayout.access$600(this.this$0, var2);
      this.this$0.invalidate();
   }

   public void onViewReleased(View var1, float var2, float var3) {
      int var4;
      label14: {
         SlidingPaneLayout$LayoutParams var6 = (SlidingPaneLayout$LayoutParams)var1.getLayoutParams();
         var4 = this.this$0.getPaddingLeft();
         int var5 = var6.leftMargin + var4;
         if(var2 <= 0.0F) {
            var4 = var5;
            if(var2 != 0.0F) {
               break label14;
            }

            var4 = var5;
            if(SlidingPaneLayout.access$300(this.this$0) <= 0.5F) {
               break label14;
            }
         }

         var4 = var5 + SlidingPaneLayout.access$700(this.this$0);
      }

      SlidingPaneLayout.access$200(this.this$0).settleCapturedViewAt(var4, var1.getTop());
      this.this$0.invalidate();
   }

   public boolean tryCaptureView(View var1, int var2) {
      return SlidingPaneLayout.access$100(this.this$0)?false:((SlidingPaneLayout$LayoutParams)var1.getLayoutParams()).slideable;
   }
}
