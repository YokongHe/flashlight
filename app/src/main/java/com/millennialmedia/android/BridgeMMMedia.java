package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import com.millennialmedia.android.AdCache;
import com.millennialmedia.android.BridgeMMMedia$Audio;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.Utils$IntentUtils;
import java.io.File;
import java.util.Map;
import org.json.JSONArray;

class BridgeMMMedia extends MMJSObject {
   private static final String PATH = "path";
   private static final String TAG = "BridgeMMMedia";
   private static Object pickerActivityObject;
   private String AVAILABLE_SOURCE_TYPES = "availableSourceTypes";
   private String GET_DEVICE_VOLUME = "getDeviceVolume";
   private String GET_PICTURE = "getPicture";
   private String IS_SOURCE_TYPE_AVAILABLE = "isSourceTypeAvailable";
   private String PLAY_AUDIO = "playAudio";
   private String PLAY_SOUND = "playSound";
   private String PLAY_VIDEO = "playVideo";
   private String STOP_AUDIO = "stopAudio";
   private String WRITE_TO_PHOTO_LIBRARY = "writeToPhotoLibrary";
   MediaScannerConnection mediaScanner;

   // $FF: synthetic method
   static Object access$000() {
      return pickerActivityObject;
   }

   private static Bitmap centerOfImage(Bitmap var0, int var1, int var2) {
      float var3 = (float)((var0.getWidth() - var1) / 2);
      float var4 = (float)((var0.getHeight() - var2) / 2);
      return cropImage(var0, (int)var3, (int)var4, var1, var2);
   }

   private static Bitmap cropImage(Bitmap var0, int var1, int var2, int var3, int var4) {
      return Bitmap.createBitmap(var0, var1, var2, var3, var4);
   }

   private boolean isCameraAvailable() {
      Context var1 = (Context)this.contextRef.get();
      if(var1 != null && var1.getPackageManager().checkPermission("android.permission.CAMERA", var1.getPackageName()) == 0) {
         Intent var2 = new Intent("android.media.action.IMAGE_CAPTURE");
         return var1.getPackageManager().queryIntentActivities(var2, 65536).size() > 0;
      } else {
         return false;
      }
   }

   private boolean isPictureChooserAvailable() {
      Context var1 = (Context)this.contextRef.get();
      if(var1 != null) {
         Intent var2 = new Intent();
         var2.setType("image/*");
         var2.setAction("android.intent.action.GET_CONTENT");
         return var1.getPackageManager().queryIntentActivities(var2, 65536).size() > 0;
      } else {
         return false;
      }
   }

   private static Bitmap resizeImage(Bitmap var0, int var1, int var2, int var3) {
      return Bitmap.createScaledBitmap(var0, var1, var2, true);
   }

   static Bitmap resizeImage(Bitmap var0, String var1, int var2, int var3, int var4) {
      float var5 = (float)var2 / (float)var0.getWidth();
      float var6 = (float)var3 / (float)var0.getHeight();
      if(var1.equals("Center")) {
         return centerOfImage(var0, var2, var3);
      } else if(var1.equals("ScaleToAspectFit")) {
         var5 = Math.min(var5, var6);
         return resizeImage(var0, (int)((float)var0.getWidth() * var5), (int)(var5 * (float)var0.getHeight()), var4);
      } else if(var1.equals("ScaleToAspectFill")) {
         var5 = Math.max(var5, var6);
         return cropImage(resizeImage(var0, (int)((float)var0.getWidth() * var5), (int)(var5 * (float)var0.getHeight()), var4), 0, 0, var2, var3);
      } else {
         return resizeImage(var0, var2, var3, var4);
      }
   }

   private static final byte[] scaleBitmapToBytes(File param0, int param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   private void scanMedia(final String var1) {
      Context var2 = (Context)this.contextRef.get();
      if(var2 != null) {
         this.mediaScanner = new MediaScannerConnection(var2.getApplicationContext(), new MediaScannerConnectionClient() {
            public void onMediaScannerConnected() {
               if(BridgeMMMedia.this.mediaScanner != null) {
                  BridgeMMMedia.this.mediaScanner.scanFile(var1, (String)null);
               }

            }

            public void onScanCompleted(String var1x, Uri var2) {
               if(var2 == null) {
                  MMLog.d("BridgeMMMedia", "Failed to scan " + var1x);
               }

               BridgeMMMedia.this.mediaScanner.disconnect();
            }
         });
         if(this.mediaScanner != null) {
            this.mediaScanner.connect();
         }
      }

   }

   public MMJSResponse availableSourceTypes(Map var1) {
      JSONArray var3 = new JSONArray();
      if(this.isCameraAvailable()) {
         var3.put("Camera");
      }

      if(this.isPictureChooserAvailable()) {
         var3.put("Photo Library");
      }

      MMJSResponse var2 = new MMJSResponse();
      var2.result = 1;
      var2.response = var3;
      return var2;
   }

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if(this.IS_SOURCE_TYPE_AVAILABLE.equals(var1)) {
         var3 = this.isSourceTypeAvailable(var2);
      } else {
         if(this.AVAILABLE_SOURCE_TYPES.equals(var1)) {
            return this.availableSourceTypes(var2);
         }

         if(this.GET_PICTURE.equals(var1)) {
            return this.getPicture(var2);
         }

         if(this.WRITE_TO_PHOTO_LIBRARY.equals(var1)) {
            return this.writeToPhotoLibrary(var2);
         }

         if(this.PLAY_VIDEO.equals(var1)) {
            return this.playVideo(var2);
         }

         if(this.STOP_AUDIO.equals(var1)) {
            return this.stopAudio(var2);
         }

         if(this.GET_DEVICE_VOLUME.equals(var1)) {
            return this.getDeviceVolume(var2);
         }

         if(this.PLAY_AUDIO.equals(var1)) {
            return this.playAudio(var2);
         }

         if(this.PLAY_SOUND.equals(var1)) {
            return this.playSound(var2);
         }
      }

      return var3;
   }

   public MMJSResponse getDeviceVolume(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      if(var3 != null) {
         int var2 = MMSDK.getMediaVolume(var3);
         MMJSResponse var4 = MMJSResponse.responseWithSuccess();
         var4.response = Integer.valueOf(var2);
         return var4;
      } else {
         return MMJSResponse.responseWithError("no volume available");
      }
   }

   public MMJSResponse getPicture(Map param1) {
      // $FF: Couldn't be decompiled
   }

   public MMJSResponse isSourceTypeAvailable(Map var1) {
      String var2 = (String)var1.get("sourceType");
      if(var2 != null) {
         if(var2.equalsIgnoreCase("Camera") && this.isCameraAvailable()) {
            return MMJSResponse.responseWithSuccess("true");
         }

         if(var2.equalsIgnoreCase("Photo Library") && this.isPictureChooserAvailable()) {
            return MMJSResponse.responseWithSuccess("true");
         }
      }

      return MMJSResponse.responseWithError("false");
   }

   public MMJSResponse playAudio(Map var1) {
      Context var3 = (Context)this.contextRef.get();
      String var4 = (String)var1.get("path");
      if(var3 != null && var4 != null) {
         BridgeMMMedia$Audio var2 = BridgeMMMedia$Audio.sharedAudio(var3);
         if(var2 == null) {
            return null;
         }

         if(var2.isPlaying()) {
            return MMJSResponse.responseWithError("Audio already playing.");
         }

         if(var4.startsWith("http")) {
            return var2.playAudio(Uri.parse(var4), Boolean.parseBoolean((String)var1.get("repeat")));
         }

         File var5 = AdCache.getDownloadFile(var3, var4);
         if(var5.exists()) {
            return var2.playAudio(Uri.fromFile(var5), Boolean.parseBoolean((String)var1.get("repeat")));
         }
      }

      return null;
   }

   public MMJSResponse playSound(Map var1) {
      if(this.contextRef == null) {
         return null;
      } else {
         Context var2 = (Context)this.contextRef.get();
         String var3 = (String)var1.get("path");
         if(var2 != null && var3 != null) {
            File var4 = AdCache.getDownloadFile(var2, var3);
            if(var4.exists()) {
               BridgeMMMedia$Audio var5 = BridgeMMMedia$Audio.sharedAudio((Context)this.contextRef.get());
               if(var5 != null) {
                  return var5.playSound(var4);
               }
            }
         }

         return null;
      }
   }

   public MMJSResponse playVideo(Map var1) {
      Context var2 = (Context)this.contextRef.get();
      String var3 = (String)var1.get("path");
      if(var2 != null && var3 != null) {
         if(var3.startsWith("http")) {
            Utils$IntentUtils.startVideoPlayerActivityWithData(var2, var3);
            return MMJSResponse.responseWithSuccess(var3);
         }

         File var4 = AdCache.getDownloadFile(var2, var3);
         if(var4.exists()) {
            Utils$IntentUtils.startVideoPlayerActivityWithData(var2, var4);
            return MMJSResponse.responseWithSuccess(var4.getName());
         }
      }

      return null;
   }

   public MMJSResponse stopAudio(Map var1) {
      if(this.contextRef != null) {
         BridgeMMMedia$Audio var2 = BridgeMMMedia$Audio.sharedAudio((Context)this.contextRef.get());
         if(var2 != null) {
            return var2.stop();
         }
      }

      return null;
   }

   public MMJSResponse writeToPhotoLibrary(Map param1) {
      // $FF: Couldn't be decompiled
   }
}
