package com.smaato.soma.internal.requests;

import android.os.AsyncTask;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.requests.HttpConnector;
import java.net.URL;

class HttpConnector$DownloadTask extends AsyncTask {
   // $FF: synthetic field
   final HttpConnector this$0;

   private HttpConnector$DownloadTask(HttpConnector var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   HttpConnector$DownloadTask(HttpConnector var1, HttpConnector$DownloadTask var2) {
      this(var1);
   }

   protected ReceivedBannerInterface doInBackground(final URL... var1) {
      return (ReceivedBannerInterface)(new CrashReportTemplate() {
         public ReceivedBannerInterface process() {
            return HttpConnector$DownloadTask.this.this$0.loadNewBanner(var1[0]);
         }
      }).execute();
   }

   protected void onPostExecute(final ReceivedBannerInterface var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage(HttpConnector.access$0(), "Load async finished!", 1, DebugCategory.DEBUG));
            if(HttpConnector.access$1(HttpConnector$DownloadTask.this.this$0) != null) {
               HttpConnector.access$1(HttpConnector$DownloadTask.this.this$0).bannerDownloadComplete(var1);
            }

            return null;
         }
      }).execute();
      super.onPostExecute(var1);
   }
}
