package com.adsdk.sdk.video;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Message;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.ResourceManager;

class ResourceManager$FetchImageTask extends AsyncTask {
   Context mContext;
   int mResourceId;
   String mUrl;
   // $FF: synthetic field
   final ResourceManager this$0;

   public ResourceManager$FetchImageTask(ResourceManager var1, Context var2, String var3, int var4) {
      this.this$0 = var1;
      this.mContext = var2;
      this.mUrl = var3;
      this.mResourceId = var4;
      Log.i("Fetching: " + this.mUrl);
   }

   private Drawable fetchImage(String param1) {
      // $FF: Couldn't be decompiled
   }

   protected Boolean doInBackground(Void... var1) {
      Object var2 = null;
      Drawable var3 = (Drawable)var2;
      if(this.mUrl != null) {
         var3 = (Drawable)var2;
         if(this.mUrl.length() > 0) {
            var3 = this.fetchImage(this.mUrl);
         }
      }

      if(var3 != null) {
         ResourceManager.access$1(this.this$0).put(Integer.valueOf(this.mResourceId), var3);
         return Boolean.valueOf(true);
      } else {
         return Boolean.valueOf(false);
      }
   }

   protected void onPostExecute(Boolean var1) {
      super.onPostExecute(var1);
      Log.i("Fetched: " + this.mUrl);
      Message var2 = ResourceManager.access$0(this.this$0).obtainMessage(100, this.mResourceId, 0);
      ResourceManager.access$0(this.this$0).sendMessage(var2);
   }
}
