package com.adsdk.sdk.nativeads;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.adsdk.sdk.Util;
import com.adsdk.sdk.nativeads.NativeAdView;

class NativeAdView$LoadUrlTask extends AsyncTask {
   // $FF: synthetic field
   final NativeAdView this$0;
   String userAgent;

   public NativeAdView$LoadUrlTask(NativeAdView var1) {
      this.this$0 = var1;
      this.userAgent = Util.getDefaultUserAgentString(NativeAdView.access$0(var1));
   }

   protected String doInBackground(String... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(String var1) {
      if(var1 != null && !var1.equals("")) {
         Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         var2.addFlags(268435456);
         NativeAdView.access$0(this.this$0).startActivity(var2);
      }
   }
}
