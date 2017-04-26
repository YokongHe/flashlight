package com.inneractive.api.ads.sdk;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.inneractive.api.ads.sdk.IAmraidWebViewController;

final class IAmraidWebViewController$a implements MediaScannerConnectionClient {
   private final String mFilename;
   private MediaScannerConnection mMediaScannerConnection;
   private final String mMimeType;
   // $FF: synthetic field
   final IAmraidWebViewController this$0;

   private IAmraidWebViewController$a(IAmraidWebViewController var1, String var2, String var3) {
      this.this$0 = var1;
      this.mFilename = var2;
      this.mMimeType = var3;
   }

   // $FF: synthetic method
   IAmraidWebViewController$a(IAmraidWebViewController var1, String var2, String var3, Object var4) {
      this(var1, var2, var3);
   }

   // $FF: synthetic method
   static void access$500(IAmraidWebViewController$a var0, MediaScannerConnection var1) {
      var0.mMediaScannerConnection = var1;
   }

   private void setMediaScannerConnection(MediaScannerConnection var1) {
      this.mMediaScannerConnection = var1;
   }

   public final void onMediaScannerConnected() {
      if(this.mMediaScannerConnection != null) {
         this.mMediaScannerConnection.scanFile(this.mFilename, this.mMimeType);
      }

   }

   public final void onScanCompleted(String var1, Uri var2) {
      if(this.mMediaScannerConnection != null) {
         this.mMediaScannerConnection.disconnect();
      }

   }
}
