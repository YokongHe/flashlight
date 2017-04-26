package com.smaato.soma.internal.utilities;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.smaato.soma.internal.utilities.ImageDownloader;
import java.io.File;

public class ImageDownloader$SingleMediaScanner implements MediaScannerConnectionClient {
   private File mFile;
   private MediaScannerConnection mMs;
   // $FF: synthetic field
   final ImageDownloader this$0;

   public ImageDownloader$SingleMediaScanner(ImageDownloader var1, Context var2, File var3) {
      this.this$0 = var1;
      this.mFile = var3;
      this.mMs = new MediaScannerConnection(var2, this);
      this.mMs.connect();
   }

   public void onMediaScannerConnected() {
      this.mMs.scanFile(this.mFile.getAbsolutePath(), (String)null);
   }

   public void onScanCompleted(String var1, Uri var2) {
      this.mMs.disconnect();
   }
}
