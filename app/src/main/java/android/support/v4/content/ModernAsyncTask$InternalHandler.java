package android.support.v4.content;

import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ModernAsyncTask;
import android.support.v4.content.ModernAsyncTask$AsyncTaskResult;

class ModernAsyncTask$InternalHandler extends Handler {
   private ModernAsyncTask$InternalHandler() {
   }

   // $FF: synthetic method
   ModernAsyncTask$InternalHandler(Object var1) {
      this();
   }

   public void handleMessage(Message var1) {
      ModernAsyncTask$AsyncTaskResult var2 = (ModernAsyncTask$AsyncTaskResult)var1.obj;
      switch(var1.what) {
      case 1:
         ModernAsyncTask.access$500(var2.mTask, var2.mData[0]);
         return;
      case 2:
         var2.mTask.onProgressUpdate(var2.mData);
         return;
      default:
      }
   }
}
