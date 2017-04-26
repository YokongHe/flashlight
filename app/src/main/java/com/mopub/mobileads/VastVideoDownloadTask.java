package com.mopub.mobileads;

import android.os.AsyncTask;
import com.mopub.mobileads.VastVideoDownloadTask$VastVideoDownloadTaskListener;

public class VastVideoDownloadTask extends AsyncTask {
   private static final int MAX_VIDEO_SIZE = 26214400;
   private final VastVideoDownloadTask$VastVideoDownloadTaskListener mVastVideoDownloadTaskListener;

   public VastVideoDownloadTask(VastVideoDownloadTask$VastVideoDownloadTaskListener var1) {
      this.mVastVideoDownloadTaskListener = var1;
   }

   protected Boolean doInBackground(String... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onCancelled() {
      this.onPostExecute(Boolean.valueOf(false));
   }

   protected void onPostExecute(Boolean var1) {
      if(this.mVastVideoDownloadTaskListener != null) {
         this.mVastVideoDownloadTaskListener.onComplete(var1.booleanValue());
      }

   }
}
