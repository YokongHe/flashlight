package android.support.v4.content;

import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.ModernAsyncTask;
import java.util.concurrent.CountDownLatch;

final class AsyncTaskLoader$LoadTask extends ModernAsyncTask implements Runnable {
   private CountDownLatch done;
   Object result;
   // $FF: synthetic field
   final AsyncTaskLoader this$0;
   boolean waiting;

   AsyncTaskLoader$LoadTask(AsyncTaskLoader var1) {
      this.this$0 = var1;
      this.done = new CountDownLatch(1);
   }

   // $FF: synthetic method
   static CountDownLatch access$000(AsyncTaskLoader$LoadTask var0) {
      return var0.done;
   }

   protected final Object doInBackground(Void... var1) {
      this.result = this.this$0.onLoadInBackground();
      return this.result;
   }

   protected final void onCancelled() {
      try {
         this.this$0.dispatchOnCancelled(this, this.result);
      } finally {
         this.done.countDown();
      }

   }

   protected final void onPostExecute(Object var1) {
      try {
         this.this$0.dispatchOnLoadComplete(this, var1);
      } finally {
         this.done.countDown();
      }

   }

   public final void run() {
      this.waiting = false;
      this.this$0.executePendingTask();
   }
}
