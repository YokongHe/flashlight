package android.support.v4.widget;

import android.database.DataSetObserver;
import android.support.v4.widget.CursorAdapter;

class CursorAdapter$MyDataSetObserver extends DataSetObserver {
   // $FF: synthetic field
   final CursorAdapter this$0;

   private CursorAdapter$MyDataSetObserver(CursorAdapter var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   CursorAdapter$MyDataSetObserver(CursorAdapter var1, Object var2) {
      this(var1);
   }

   public void onChanged() {
      this.this$0.mDataValid = true;
      this.this$0.notifyDataSetChanged();
   }

   public void onInvalidated() {
      this.this$0.mDataValid = false;
      this.this$0.notifyDataSetInvalidated();
   }
}
