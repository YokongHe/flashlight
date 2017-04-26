package com.adsdk.sdk.mraid;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.adsdk.sdk.mraid.MraidDisplayController;

class MraidDisplayController$MoPubMediaScannerConnectionClient implements MediaScannerConnectionClient {
   private final String mFilename;
   private MediaScannerConnection mMediaScannerConnection;
   private final String mMimeType;
   // $FF: synthetic field
   final MraidDisplayController this$0;

   private MraidDisplayController$MoPubMediaScannerConnectionClient(MraidDisplayController var1, String var2, String var3) {
      this.this$0 = var1;
      this.mFilename = var2;
      this.mMimeType = var3;
   }

   // $FF: synthetic method
   MraidDisplayController$MoPubMediaScannerConnectionClient(MraidDisplayController var1, String var2, String var3, MraidDisplayController$MoPubMediaScannerConnectionClient var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   static void access$1(MraidDisplayController$MoPubMediaScannerConnectionClient var0, MediaScannerConnection var1) {
      var0.mMediaScannerConnection = var1;
   }

   private void setMediaScannerConnection(MediaScannerConnection var1) {
      this.mMediaScannerConnection = var1;
   }

   public void onMediaScannerConnected() {
      if(this.mMediaScannerConnection != null) {
         this.mMediaScannerConnection.scanFile(this.mFilename, this.mMimeType);
      }

   }

   public void onScanCompleted(String var1, Uri var2) {
      if(this.mMediaScannerConnection != null) {
         this.mMediaScannerConnection.disconnect();
      }

   }
}
