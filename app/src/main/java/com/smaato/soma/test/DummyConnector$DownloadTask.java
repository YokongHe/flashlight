package com.smaato.soma.test;

import android.os.AsyncTask;
import android.util.Log;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.exception.UnableToNotifyAdListener;
import com.smaato.soma.test.DummyConnector;
import java.net.URL;

class DummyConnector$DownloadTask extends AsyncTask {
   // $FF: synthetic field
   final DummyConnector this$0;

   private DummyConnector$DownloadTask(DummyConnector var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   DummyConnector$DownloadTask(DummyConnector var1, DummyConnector$DownloadTask var2) {
      this(var1);
   }

   protected ReceivedBannerInterface doInBackground(String... var1) {
      Log.d(DummyConnector.TAG, "Download task created");

      try {
         ReceivedBannerInterface var3 = this.this$0.loadNewBanner(new URL(var1[0]));
         return var3;
      } catch (Exception var2) {
         Log.e(DummyConnector.TAG, "");
         return DummyConnector.access$0(this.this$0);
      }
   }

   protected void onPostExecute(ReceivedBannerInterface var1) {
      Log.d(DummyConnector.TAG, "Load async finished!");
      if(DummyConnector.access$1(this.this$0) != null) {
         try {
            DummyConnector.access$1(this.this$0).bannerDownloadComplete(var1);
         } catch (UnableToNotifyAdListener var3) {
            Log.w(DummyConnector.TAG, "Unable to download Banner");
         }
      }

      super.onPostExecute(var1);
   }
}
