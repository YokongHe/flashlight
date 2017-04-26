package com.adsdk.sdk.video;

import android.os.AsyncTask;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.WebFrame;

class WebFrame$LoadUrlTask extends AsyncTask {
   // $FF: synthetic field
   final WebFrame this$0;
   String userAgent;

   public WebFrame$LoadUrlTask(WebFrame var1) {
      this.this$0 = var1;
      this.userAgent = WebFrame.access$0(var1);
   }

   protected String doInBackground(String... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(String var1) {
      String var2;
      label11: {
         if(var1 != null) {
            var2 = var1;
            if(!var1.equals("")) {
               break label11;
            }
         }

         var2 = "about:blank";
      }

      Log.d("Show URL: " + var2);
      WebFrame.access$1(this.this$0).setAllowedUrl(var2);
      WebFrame.access$2(this.this$0).loadUrl(var2);
      this.this$0.requestLayout();
   }
}
