package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.content.Loader;

public final class Loader$ForceLoadContentObserver extends ContentObserver {
   // $FF: synthetic field
   final Loader this$0;

   public Loader$ForceLoadContentObserver(Loader var1) {
      super(new Handler());
      this.this$0 = var1;
   }

   public final boolean deliverSelfNotifications() {
      return true;
   }

   public final void onChange(boolean var1) {
      this.this$0.onContentChanged();
   }
}
