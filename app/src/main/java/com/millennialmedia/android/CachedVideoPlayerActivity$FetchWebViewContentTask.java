package com.millennialmedia.android;

import android.content.Context;
import android.os.AsyncTask;
import com.millennialmedia.android.CachedVideoPlayerActivity;

class CachedVideoPlayerActivity$FetchWebViewContentTask extends AsyncTask {
   private String baseUrl;
   private boolean cancelVideo;
   // $FF: synthetic field
   final CachedVideoPlayerActivity this$0;

   public CachedVideoPlayerActivity$FetchWebViewContentTask(CachedVideoPlayerActivity var1, String var2) {
      this.this$0 = var1;
      this.baseUrl = var2;
   }

   protected String doInBackground(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(String var1) {
      if(this.cancelVideo) {
         this.this$0.dismiss();
      }

      if(var1 != null && CachedVideoPlayerActivity.access$100(this.this$0) != null) {
         CachedVideoPlayerActivity.access$100(this.this$0).setWebViewContent(var1, this.baseUrl, (Context)this.this$0.activity);
         this.this$0.hasLoadedCompletionUrl = true;
      }

   }
}
