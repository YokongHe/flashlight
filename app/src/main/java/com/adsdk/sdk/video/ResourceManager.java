package com.adsdk.sdk.video;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.ResourceManager$FetchImageTask;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import org.apache.http.client.methods.HttpGet;

public class ResourceManager {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   public static final String BACK_ICON = "browser_back.png";
   public static final String BOTTOMBAR_BG = "bar.png";
   public static final String CLOSE_BUTTON_NORMAL = "close_button_normal.png";
   public static final String CLOSE_BUTTON_PRESSED = "close_button_pressed.png";
   public static final int DEFAULT_BACK_IMAGE_RESOURCE_ID = -14;
   public static final int DEFAULT_BOTTOMBAR_BG_RESOURCE_ID = -2;
   public static final int DEFAULT_CLOSE_BUTTON_NORMAL_RESOURCE_ID = -29;
   public static final int DEFAULT_CLOSE_BUTTON_PRESSED_RESOURCE_ID = -30;
   public static final int DEFAULT_EXTERNAL_IMAGE_RESOURCE_ID = -17;
   public static final int DEFAULT_FORWARD_IMAGE_RESOURCE_ID = -15;
   public static final int DEFAULT_PAUSE_IMAGE_RESOURCE_ID = -12;
   public static final int DEFAULT_PLAY_IMAGE_RESOURCE_ID = -11;
   public static final int DEFAULT_RELOAD_IMAGE_RESOURCE_ID = -16;
   public static final int DEFAULT_REPLAY_IMAGE_RESOURCE_ID = -13;
   public static final int DEFAULT_SKIP_IMAGE_RESOURCE_ID = -18;
   public static final int DEFAULT_TOPBAR_BG_RESOURCE_ID = -1;
   public static final String EXTERNAL_ICON = "browser_external.png";
   public static final String FORWARD_ICON = "browser_forward.png";
   public static final String PAUSE_ICON = "video_pause.png";
   public static final String PLAY_ICON = "video_play.png";
   public static final String RELOAD_ICON = "video_replay.png";
   public static final String REPLAY_ICON = "video_replay.png";
   public static final int RESOURCE_LOADED_MSG = 100;
   public static final String SKIP_ICON = "skip.png";
   public static final String TOPBAR_BG = "bar.png";
   public static final int TYPE_FILE = 0;
   public static final int TYPE_UNKNOWN = -1;
   public static final int TYPE_ZIP = 1;
   public static final String VERSION = "version.txt";
   public static boolean sCancel;
   public static HttpGet sDownloadGet;
   public static boolean sDownloading;
   private static HashMap sResources;
   private Handler mHandler;
   private HashMap mResources = new HashMap();

   static {
      boolean var0;
      if(!ResourceManager.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
      sDownloading = false;
      sCancel = false;
      sResources = new HashMap();
   }

   public ResourceManager(Context var1, Handler var2) {
      this.mHandler = var2;
   }

   // $FF: synthetic method
   static Handler access$0(ResourceManager var0) {
      return var0.mHandler;
   }

   // $FF: synthetic method
   static HashMap access$1(ResourceManager var0) {
      return var0.mResources;
   }

   private static Drawable buildDrawable(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   public static void cancel() {
      sCancel = true;
      if(sDownloadGet != null) {
         sDownloadGet.abort();
         sDownloadGet = null;
      }

      sResources.clear();
   }

   public static Drawable getDefaultResource(int var0) {
      return (Drawable)sResources.get(Integer.valueOf(var0));
   }

   public static Drawable getDefaultSkipButton(Context var0) {
      return buildDrawable(var0, "skip.png");
   }

   public static long getInstalledVersion(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static Drawable getStaticResource(Context var0, int var1) {
      BitmapDrawable var3 = (BitmapDrawable)sResources.get(Integer.valueOf(var1));
      BitmapDrawable var2;
      if(var3 != null) {
         var2 = var3;
         if(!var3.getBitmap().isRecycled()) {
            return var2;
         }
      }

      initDefaultResource(var0, var1);
      var2 = (BitmapDrawable)sResources.get(Integer.valueOf(var1));
      return var2;
   }

   private static void initDefaultResource(Context var0, int var1) {
      switch(var1) {
      case -30:
         registerImageResource(var0, -30, "close_button_pressed.png");
         return;
      case -29:
         registerImageResource(var0, -29, "close_button_normal.png");
         return;
      case -18:
         registerImageResource(var0, -18, "skip.png");
         return;
      case -17:
         registerImageResource(var0, -17, "browser_external.png");
         return;
      case -16:
         registerImageResource(var0, -16, "video_replay.png");
         return;
      case -15:
         registerImageResource(var0, -15, "browser_forward.png");
         return;
      case -14:
         registerImageResource(var0, -14, "browser_back.png");
         return;
      case -13:
         registerImageResource(var0, -13, "video_replay.png");
         return;
      case -12:
         registerImageResource(var0, -12, "video_pause.png");
         return;
      case -11:
         registerImageResource(var0, -11, "video_play.png");
         return;
      case -2:
         registerImageResource(var0, -2, "bar.png");
         return;
      case -1:
         registerImageResource(var0, -1, "bar.png");
         return;
      default:
      }
   }

   public static boolean isDownloading() {
      return sDownloading;
   }

   private static void registerImageResource(Context var0, int var1, String var2) {
      Drawable var3 = buildDrawable(var0, var2);
      if(var3 != null) {
         sResources.put(Integer.valueOf(var1), var3);
      } else {
         Log.i("registerImageResource", "drawable was null " + var2);
      }
   }

   public static boolean resourcesInstalled(Context var0) {
      String[] var2 = var0.fileList();

      for(int var1 = 0; var1 < var2.length; ++var1) {
         if("version.txt".equals(var2[var1])) {
            Log.d("Resources already installed");
            return true;
         }
      }

      return false;
   }

   public static void saveInstalledVersion(Context param0, long param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean containsResource(int var1) {
      return this.mResources.get(Integer.valueOf(var1)) != null || this.mResources.get(Integer.valueOf(var1)) != null;
   }

   public void fetchResource(Context var1, String var2, int var3) {
      if(sResources.get(Integer.valueOf(var3)) == null) {
         (new ResourceManager$FetchImageTask(this, var1, var2, var3)).execute(new Void[0]);
      }

   }

   public Drawable getResource(Context var1, int var2) {
      BitmapDrawable var3 = (BitmapDrawable)this.mResources.get(Integer.valueOf(var2));
      return (Drawable)(var3 != null?var3:getStaticResource(var1, var2));
   }

   public void releaseInstance() {
      Iterator var1 = this.mResources.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         var1.remove();
         var2.getValue();
      }

      if(!$assertionsDisabled && this.mResources.size() != 0) {
         throw new AssertionError();
      } else {
         System.gc();
      }
   }
}
