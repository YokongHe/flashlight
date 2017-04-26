package org.nexage.sourcekit.mraid.nativefeature;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.nexage.sourcekit.mraid.MRAIDBrowser;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;

public class MRAIDNativeFeatureProvider {
   private static final String TAG = "MRAIDNativeFeatureProvider";
   private final Context context;
   private final MRAIDNativeFeatureManager nativeFeatureManager;

   public MRAIDNativeFeatureProvider(Context var1, MRAIDNativeFeatureManager var2) {
      this.context = var1;
      this.nativeFeatureManager = var2;
   }

   private void copyStream(InputStream param1, OutputStream param2) {
      // $FF: Couldn't be decompiled
   }

   private File getAlbumDir() {
      File var1;
      if("mounted".equals(Environment.getExternalStorageState())) {
         File var2 = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "NexageAd");
         var1 = var2;
         if(!var2.mkdirs()) {
            var1 = var2;
            if(!var2.exists()) {
               MRAIDLog.i("MRAIDNativeFeatureProvider", "Failed to create camera directory");
               return null;
            }
         }
      } else {
         MRAIDLog.i("MRAIDNativeFeatureProvider", "External storage is not mounted READ/WRITE.");
         var1 = null;
      }

      return var1;
   }

   @SuppressLint({"SimpleDateFormat"})
   private void storePictureInGallery(String var1) {
      SimpleDateFormat var2 = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
      String var7 = this.getAlbumDir() + "/img" + var2.format(new Date()) + ".png";
      MRAIDLog.i("MRAIDNativeFeatureProvider", "Saving image into: " + var7);
      File var8 = new File(var7);

      try {
         this.copyStream((new URL(var1)).openStream(), new FileOutputStream(var8));
         Context var6 = this.context;
         var7 = var8.getAbsolutePath();
         OnScanCompletedListener var3 = new OnScanCompletedListener() {
            public void onScanCompleted(String var1, Uri var2) {
               MRAIDLog.d("File saves successfully to " + var1);
            }
         };
         MediaScannerConnection.scanFile(var6, new String[]{var7}, (String[])null, var3);
         MRAIDLog.i("MRAIDNativeFeatureProvider", "Saved image successfully");
      } catch (MalformedURLException var4) {
         MRAIDLog.e("MRAIDNativeFeatureProvider", "Not able to save image due to invalid URL: " + var4.getLocalizedMessage());
      } catch (IOException var5) {
         MRAIDLog.e("MRAIDNativeFeatureProvider", "Unable to save image: " + var5.getLocalizedMessage());
      }
   }

   public final void callTel(String var1) {
      if(this.nativeFeatureManager.isTelSupported()) {
         Intent var2 = new Intent("android.intent.action.DIAL", Uri.parse(var1));
         this.context.startActivity(var2);
      }

   }

   @SuppressLint({"SimpleDateFormat"})
   @TargetApi(14)
   public boolean createCalendarEvent(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void openBrowser(String var1) {
      Intent var2;
      Intent var3;
      if(!var1.startsWith("http:") && !var1.startsWith("https:")) {
         var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         var3 = var2;
         if(this.context.getPackageManager().resolveActivity(var2, 0) == null) {
            MRAIDLog.d("MRAIDNativeFeatureProvider", "Couldn\'t find intent for url");
            return;
         }
      } else {
         var2 = new Intent(this.context, MRAIDBrowser.class);
         var2.putExtra("extra_url", var1);
         var2.putExtra("extra_manager", this.nativeFeatureManager.getSupportedNativeFeatures());
         var2.addFlags(268435456);
         var3 = var2;
      }

      this.context.startActivity(var3);
   }

   public void playVideo(String var1) {
      Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
      this.context.startActivity(var2);
   }

   public void sendSms(String var1) {
      if(this.nativeFeatureManager.isSmsSupported()) {
         Intent var2 = new Intent("android.intent.action.SENDTO", Uri.parse(var1));
         this.context.startActivity(var2);
      }

   }

   public void storePicture(final String var1) {
      if(this.nativeFeatureManager.isStorePictureSupported()) {
         (new Thread(new Runnable() {
            public void run() {
               try {
                  MRAIDNativeFeatureProvider.this.storePictureInGallery(var1);
               } catch (Exception var2) {
                  MRAIDLog.e("MRAIDNativeFeatureProvider", var2.getLocalizedMessage());
               }
            }
         })).start();
      }

   }
}
