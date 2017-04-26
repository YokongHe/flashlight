package com.mopub.common;

import android.os.AsyncTask;
import com.mopub.common.DownloadResponse;
import com.mopub.common.DownloadTask$DownloadTaskListener;
import com.mopub.common.event.MoPubEvents$Type;
import com.mopub.common.logging.MoPubLog;
import org.apache.http.client.methods.HttpUriRequest;

public class DownloadTask extends AsyncTask {
   private final DownloadTask$DownloadTaskListener mDownloadTaskListener;
   private final MoPubEvents$Type mEventType;
   private String mUrl;

   public DownloadTask(DownloadTask$DownloadTaskListener var1) {
      this(var1, (MoPubEvents$Type)null);
   }

   public DownloadTask(DownloadTask$DownloadTaskListener var1, MoPubEvents$Type var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("DownloadTaskListener must not be null.");
      } else {
         this.mDownloadTaskListener = var1;
         this.mEventType = var2;
      }
   }

   protected DownloadResponse doInBackground(HttpUriRequest... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onCancelled() {
      MoPubLog.d("DownloadTask was cancelled.");
   }

   protected void onPostExecute(DownloadResponse var1) {
      if(this.isCancelled()) {
         this.onCancelled();
      } else {
         this.mDownloadTaskListener.onComplete(this.mUrl, var1);
      }
   }
}
