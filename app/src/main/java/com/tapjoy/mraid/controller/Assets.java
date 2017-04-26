package com.tapjoy.mraid.controller;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.StatFs;
import android.webkit.JavascriptInterface;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.view.MraidView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Assets extends Abstract {
   private static final char[] d = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
   private int c = 0;

   public Assets(MraidView var1, Context var2) {
      super(var1, var2);
   }

   private String a() {
      return this.b.getFilesDir().getPath();
   }

   private static String a(String var0, String var1, String var2) {
      File var3 = new File(var1 + File.separator + var0);
      (new File(var1 + File.separator + "ad")).mkdir();
      File var4 = new File(var1 + File.separator + "ad" + File.separator + var2);
      var4.mkdir();
      var3.renameTo(new File(var4, var3.getName()));
      return var4.getPath() + File.separator;
   }

   private static String a(MessageDigest var0) {
      int var2 = 0;
      byte[] var5 = var0.digest();
      char[] var4 = new char[var5.length * 2];

      for(int var1 = 0; var1 < var5.length; ++var1) {
         int var3 = var2 + 1;
         var4[var2] = d[var5[var1] >>> 4 & 15];
         var2 = var3 + 1;
         var4[var3] = d[var5[var1] & 15];
      }

      return new String(var4);
   }

   private static HttpEntity a(String var0) {
      try {
         HttpEntity var2 = (new DefaultHttpClient()).execute(new HttpGet(var0)).getEntity();
         return var2;
      } catch (Exception var1) {
         var1.printStackTrace();
         return null;
      }
   }

   private static void a(StringBuffer var0, String var1, String var2) {
      int var3 = var0.indexOf(var1);
      TapjoyLog.d("replace ", var2);
      var0.replace(var3, var1.length() + var3, "file://" + var2);
   }

   private static boolean a(StringBuffer var0, String var1) {
      int var2;
      try {
         var2 = var0.indexOf(var1);
      } catch (Exception var3) {
         TapjoyLog.d("contains", "html file does not contain " + var1);
         return false;
      }

      if(var2 >= 0) {
         return true;
      } else {
         return false;
      }
   }

   private File b(String var1) {
      File var2 = this.b.getFilesDir();
      return new File(var2.getPath() + File.separator + var1);
   }

   private static String c(String var0) {
      int var1 = var0.lastIndexOf(File.separatorChar);
      String var2 = "/";
      if(var1 >= 0) {
         var2 = var0.substring(0, var0.lastIndexOf(File.separatorChar));
      }

      return var2;
   }

   private static String d(String var0) {
      String var1 = var0;
      if(var0.lastIndexOf(File.separatorChar) >= 0) {
         var1 = var0.substring(var0.lastIndexOf(File.separatorChar) + 1);
      }

      return var1;
   }

   public static boolean deleteDirectory(File var0) {
      if(var0.exists()) {
         File[] var2 = var0.listFiles();

         for(int var1 = 0; var1 < var2.length; ++var1) {
            if(var2[var1].isDirectory()) {
               deleteDirectory(var2[var1]);
            } else {
               var2[var1].delete();
            }
         }
      }

      return var0.delete();
   }

   public static boolean deleteDirectory(String var0) {
      return var0 != null?deleteDirectory(new File(var0)):false;
   }

   public void addAsset(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public int cacheRemaining() {
      StatFs var1 = new StatFs(this.b.getFilesDir().getPath());
      return var1.getFreeBlocks() * var1.getBlockSize();
   }

   public String copyTextFromJarIntoAssetDir(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public void deleteOldAds() {
      String var1 = this.a();
      deleteDirectory(new File(var1 + File.separator + "ad"));
   }

   public FileOutputStream getAssetOutputString(String var1) {
      File var2 = this.b(c(var1));
      var2.mkdirs();
      return new FileOutputStream(new File(var2, d(var1)));
   }

   public String getAssetPath() {
      return "file://" + this.b.getFilesDir() + "/";
   }

   public void removeAsset(String var1) {
      File var2 = this.b(c(var1));
      var2.mkdirs();
      (new File(var2, d(var1))).delete();
      var1 = "MraidAdController.assetRemoved(\'" + var1 + "\' )";
      this.a.injectMraidJavaScript(var1);
   }

   public void stopAllListeners() {
   }

   public void storePicture(String param1) {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public void storePictureInit(final String var1) {
      Builder var2 = new Builder(this.b);
      var2.setMessage("Are you sure you want to save file from " + var1 + " to your SD card?");
      var2.setCancelable(false);
      var2.setPositiveButton("Yes", new OnClickListener() {
         public final void onClick(DialogInterface var1x, int var2) {
            Assets.this.storePicture(var1);
         }
      });
      var2.setNegativeButton("No", (OnClickListener)null);
      var2.show();
   }

   public String writeToDisk(InputStream param1, String param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   public String writeToDiskWrap(InputStream param1, String param2, boolean param3, String param4, String param5) {
      // $FF: Couldn't be decompiled
   }
}
