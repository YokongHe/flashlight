package com.mopub.mraid;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.AsyncTask;
import android.os.Environment;
import com.mopub.mraid.MraidNativeCommandHandler$DownloadImageAsyncTask$DownloadImageAsyncTaskListener;
import com.mopub.mraid.MraidNativeCommandHandler$MoPubMediaScannerConnectionClient;
import java.io.File;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

class MraidNativeCommandHandler$DownloadImageAsyncTask extends AsyncTask {
   private final Context mContext;
   private final MraidNativeCommandHandler$DownloadImageAsyncTask$DownloadImageAsyncTaskListener mListener;

   public MraidNativeCommandHandler$DownloadImageAsyncTask(Context var1, MraidNativeCommandHandler$DownloadImageAsyncTask$DownloadImageAsyncTaskListener var2) {
      this.mContext = var1.getApplicationContext();
      this.mListener = var2;
   }

   private String getFileNameForUriAndHttpResponse(URI var1, HttpResponse var2) {
      String var6 = var1.getPath();
      if(var6 == null) {
         var6 = null;
      } else {
         String var5 = (new File(var6)).getName();
         Header var7 = var2.getFirstHeader("Content-Type");
         var6 = var5;
         if(var7 != null) {
            String[] var8 = var7.getValue().split(";");
            int var4 = var8.length;
            int var3 = 0;

            while(true) {
               var6 = var5;
               if(var3 >= var4) {
                  break;
               }

               var6 = var8[var3];
               if(var6.contains("image/")) {
                  String var9 = "." + var6.split("/")[1];
                  var6 = var5;
                  if(!var5.endsWith(var9)) {
                     return var5 + var9;
                  }
                  break;
               }

               ++var3;
            }
         }
      }

      return var6;
   }

   private File getPictureStoragePath() {
      return new File(Environment.getExternalStorageDirectory(), "Pictures");
   }

   private void loadPictureIntoGalleryApp(String var1) {
      MraidNativeCommandHandler$MoPubMediaScannerConnectionClient var3 = new MraidNativeCommandHandler$MoPubMediaScannerConnectionClient(var1, (String)null, (MraidNativeCommandHandler$MoPubMediaScannerConnectionClient)null);
      MediaScannerConnection var2 = new MediaScannerConnection(this.mContext, var3);
      MraidNativeCommandHandler$MoPubMediaScannerConnectionClient.access$1(var3, var2);
      var2.connect();
   }

   protected Boolean doInBackground(String[] param1) {
      // $FF: Couldn't be decompiled
   }

   protected void onPostExecute(Boolean var1) {
      if(var1 != null && var1.booleanValue()) {
         this.mListener.onSuccess();
      } else {
         this.mListener.onFailure();
      }
   }
}
