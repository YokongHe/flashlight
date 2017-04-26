package android.support.v4.view;

import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;

class ViewPager$PagerObserver extends DataSetObserver {
   // $FF: synthetic field
   final ViewPager this$0;

   private ViewPager$PagerObserver(ViewPager var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   ViewPager$PagerObserver(ViewPager var1, Object var2) {
      this(var1);
   }

   public void onChanged() {
      this.this$0.dataSetChanged();
   }

   public void onInvalidated() {
      this.this$0.dataSetChanged();
   }
}
