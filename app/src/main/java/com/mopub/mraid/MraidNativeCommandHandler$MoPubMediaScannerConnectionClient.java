package com.mopub.mraid;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;

class MraidNativeCommandHandler$MoPubMediaScannerConnectionClient implements MediaScannerConnectionClient {
   private final String mFilename;
   private MediaScannerConnection mMediaScannerConnection;
   private final String mMimeType;

   private MraidNativeCommandHandler$MoPubMediaScannerConnectionClient(String var1, String var2) {
      this.mFilename = var1;
      this.mMimeType = var2;
   }

   // $FF: synthetic method
   MraidNativeCommandHandler$MoPubMediaScannerConnectionClient(String var1, String var2, MraidNativeCommandHandler$MoPubMediaScannerConnectionClient var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static void access$1(MraidNativeCommandHandler$MoPubMediaScannerConnectionClient var0, MediaScannerConnection var1) {
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
