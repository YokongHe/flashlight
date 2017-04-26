package com.mopub.nativeads;

import android.os.AsyncTask;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Intents;
import com.mopub.nativeads.UrlResolutionTask$UrlResolutionListener;
import java.io.IOException;

class UrlResolutionTask extends AsyncTask {
   private static final int REDIRECT_LIMIT = 10;
   private final UrlResolutionTask$UrlResolutionListener mListener;

   UrlResolutionTask(UrlResolutionTask$UrlResolutionListener var1) {
      this.mListener = var1;
   }

   private String getRedirectLocation(String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void getResolvedUrl(String var0, UrlResolutionTask$UrlResolutionListener var1) {
      UrlResolutionTask var2 = new UrlResolutionTask(var1);

      try {
         AsyncTasks.safeExecuteOnExecutor(var2, new String[]{var0});
      } catch (Exception var3) {
         MoPubLog.d("Failed to resolve url", var3);
         var1.onFailure();
      }
   }

   protected String doInBackground(String... var1) {
      String var3;
      if(var1 != null && var1.length != 0) {
         String var6 = var1[0];
         int var2 = 0;

         String var4;
         for(var3 = null; var6 != null && var2 < 10; var6 = var4) {
            var3 = var6;

            try {
               if(!Intents.isHttpUrl(var6)) {
                  return var3;
               }

               var4 = this.getRedirectLocation(var6);
            } catch (IOException var5) {
               return null;
            }

            ++var2;
            var3 = var6;
         }

         return var3;
      } else {
         var3 = null;
         return var3;
      }
   }

   protected void onCancelled() {
      super.onCancelled();
      this.mListener.onFailure();
   }

   protected void onPostExecute(String var1) {
      super.onPostExecute(var1);
      if(!this.isCancelled() && var1 != null) {
         this.mListener.onSuccess(var1);
      } else {
         this.onCancelled();
      }
   }
}
