package com.tapjoy.mraid.controller;

import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Abstract$Dimensions;
import com.tapjoy.mraid.controller.Abstract$Properties;
import com.tapjoy.mraid.util.ConfigBroadcastReceiver;
import com.tapjoy.mraid.view.MraidView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class Display extends Abstract {
   private WindowManager c;
   private boolean d = false;
   private int e = -1;
   private int f = -1;
   private ConfigBroadcastReceiver g;
   private float h;
   private Context i;

   public Display(MraidView var1, Context var2) {
      super(var1, var2);
      this.i = var2;
      DisplayMetrics var3 = new DisplayMetrics();
      this.c = (WindowManager)var2.getSystemService("window");
      this.c.getDefaultDisplay().getMetrics(var3);
      this.h = var3.density;
   }

   private Abstract$Dimensions a(Abstract$Dimensions var1) {
      var1.width = (int)Math.ceil((double)(this.h * (float)var1.width));
      var1.height = (int)Math.ceil((double)(this.h * (float)var1.height));
      var1.x = (int)((float)var1.x * this.h);
      var1.y = (int)((float)var1.y * this.h);
      if(var1.height < 0) {
         var1.height = this.a.getHeight();
      }

      if(var1.width < 0) {
         var1.width = this.a.getWidth();
      }

      int[] var2 = new int[2];
      this.a.getLocationInWindow(var2);
      if(var1.x < 0) {
         var1.x = var2[0];
      }

      if(var1.y < 0) {
         var1.y = var2[1] + 0;
      }

      return var1;
   }

   @JavascriptInterface
   public void close() {
      TapjoyLog.d("MRAID Display", "close");
      this.a.close();
   }

   public String dimensions() {
      return "{ \"top\" :" + (int)((float)this.a.getTop() / this.h) + ",\"left\" :" + (int)((float)this.a.getLeft() / this.h) + ",\"bottom\" :" + (int)((float)this.a.getBottom() / this.h) + ",\"right\" :" + (int)((float)this.a.getRight() / this.h) + "}";
   }

   @JavascriptInterface
   public void expand(String var1, String var2) {
      TapjoyLog.d("MRAID Display", "expand: properties: " + var2 + " url: " + var1);

      try {
         JSONObject var3 = new JSONObject(var2);
         JSONObject var4 = new JSONObject();
         var4.put("width", var3.get("width"));
         var4.put("height", var3.get("height"));
         var4.put("x", 0);
         var4.put("y", 0);
         Abstract$Dimensions var10 = (Abstract$Dimensions)a(var4, Abstract$Dimensions.class);
         this.a.expand(this.a(var10), var1, (Abstract$Properties)a(new JSONObject(var2), Abstract$Properties.class));
      } catch (NumberFormatException var5) {
         var5.printStackTrace();
      } catch (NullPointerException var6) {
         var6.printStackTrace();
      } catch (IllegalAccessException var7) {
         var7.printStackTrace();
      } catch (InstantiationException var8) {
         var8.printStackTrace();
      } catch (JSONException var9) {
         var9.printStackTrace();
      }
   }

   public String getMaxSize() {
      return this.d?"{ width: " + this.e + ", height: " + this.f + "}":this.getScreenSize();
   }

   public int getOrientation() {
      int var2 = this.c.getDefaultDisplay().getOrientation();
      short var1 = -1;
      switch(var2) {
      case 0:
         var1 = 0;
         break;
      case 1:
         var1 = 90;
         break;
      case 2:
         var1 = 180;
         break;
      case 3:
         var1 = 270;
      }

      TapjoyLog.d("MRAID Display", "getOrientation: " + var1);
      return var1;
   }

   public String getScreenSize() {
      DisplayMetrics var1 = new DisplayMetrics();
      this.c.getDefaultDisplay().getMetrics(var1);
      return "{ width: " + (int)Math.ceil((double)((float)var1.widthPixels / var1.density)) + ", height: " + (int)Math.ceil((double)((float)var1.heightPixels / var1.density)) + "}";
   }

   public String getSize() {
      return this.a.getSize();
   }

   @JavascriptInterface
   public void hide() {
      TapjoyLog.d("MRAID Display", "hide");
      this.a.hide();
   }

   public boolean isVisible() {
      return this.a.getVisibility() == 0;
   }

   public void logHTML(String var1) {
      TapjoyLog.d("MRAID Display", var1);
   }

   public void onOrientationChanged(int var1) {
      String var2 = "window.mraidview.fireChangeEvent({ orientation: " + var1 + "});";
      TapjoyLog.d("MRAID Display", var2);
      this.a.injectMraidJavaScript(var2);
   }

   @JavascriptInterface
   public void open(String var1, boolean var2, boolean var3, boolean var4) {
      TapjoyLog.i("MRAID Display", "open: url: " + var1 + " back: " + var2 + " forward: " + var3 + " refresh: " + var4);
      if(!URLUtil.isValidUrl(var1)) {
         TapjoyLog.i("MRAID Display", "invalid URL");
         Intent var6 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         List var5 = this.i.getPackageManager().queryIntentActivities(var6, 0);
         if(var5.size() == 1) {
            this.i.startActivity(var6);
         } else if(var5.size() > 1) {
            var6 = Intent.createChooser(var6, "Select");
            ((Activity)this.i).startActivity(var6);
         } else {
            this.a.raiseError("Invalid url", "open");
         }
      } else {
         this.a.open(var1, var2, var3, var4);
      }
   }

   @JavascriptInterface
   public void openMap(String var1, boolean var2) {
      TapjoyLog.d("MRAID Display", "openMap: url: " + var1);
      this.a.openMap(var1, var2);
   }

   @JavascriptInterface
   public void playAudio(String var1, boolean var2, boolean var3, boolean var4, boolean var5, String var6, String var7) {
      TapjoyLog.d("MRAID Display", "playAudio: url: " + var1 + " autoPlay: " + var2 + " controls: " + var3 + " loop: " + var4 + " position: " + var5 + " startStyle: " + var6 + " stopStyle: " + var7);
      if(!URLUtil.isValidUrl(var1)) {
         this.a.raiseError("Invalid url", "playAudio");
      } else {
         this.a.playAudio(var1, var2, var3, var4, var5, var6, var7);
      }
   }

   @JavascriptInterface
   public void playVideo(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int[] var6, String var7, String var8) {
      TapjoyLog.d("MRAID Display", "playVideo: url: " + var1 + " audioMuted: " + var2 + " autoPlay: " + var3 + " controls: " + var4 + " loop: " + var5 + " x: " + var6[0] + " y: " + var6[1] + " width: " + var6[2] + " height: " + var6[3] + " startStyle: " + var7 + " stopStyle: " + var8);
      Abstract$Dimensions var12 = null;
      if(var6[0] != -1) {
         var12 = new Abstract$Dimensions();
         var12.x = var6[0];
         var12.y = var6[1];
         var12.width = var6[2];
         var12.height = var6[3];
         var12 = this.a(var12);
      }

      int var9 = 0;
      if(var1.contains("android.resource")) {
         var1 = var1.substring(var1.lastIndexOf("/") + 1, var1.lastIndexOf("."));

         label19: {
            int var10;
            try {
               var10 = raw.class.getField(var1).getInt((Object)null);
            } catch (Exception var11) {
               var11.printStackTrace();
               break label19;
            }

            var9 = var10;
         }

         var1 = this.b.getPackageName();
         var1 = "android.resource://" + var1 + "/" + var9;
      }

      this.a.playVideo(var1, false, true, true, false, var12, "fullscreen", "exit");
   }

   @JavascriptInterface
   public void resize(String param1) {
      // $FF: Couldn't be decompiled
   }

   public void setMaxSize(int var1, int var2) {
      TapjoyLog.i("MRAID Display", "setMaxSize: " + var1 + "x" + var2);
      this.d = true;
      this.e = var1;
      this.f = var2;
   }

   @JavascriptInterface
   public void setOrientationProperties(boolean var1, String var2) {
      TapjoyLog.d("MRAID Display", "setOrientationProperties: allowOrientationChange: " + Boolean.toString(var1) + " forceOrientation: " + var2);
      this.a.setOrientationProperties(var1, var2);
   }

   @JavascriptInterface
   public void show() {
      TapjoyLog.d("MRAID Display", "show");
      this.a.show();
   }

   public void startConfigurationListener() {
      try {
         if(this.g == null) {
            this.g = new ConfigBroadcastReceiver(this);
         }

         this.b.registerReceiver(this.g, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
      } catch (Exception var2) {
         ;
      }
   }

   public void stopAllListeners() {
      this.stopConfigurationListener();
      this.g = null;
   }

   public void stopConfigurationListener() {
      try {
         this.b.unregisterReceiver(this.g);
      } catch (Exception var2) {
         ;
      }
   }

   @JavascriptInterface
   public void useCustomClose(boolean var1) {
      if(var1) {
         this.a.removeCloseImageButton();
      } else if(!var1) {
         this.a.showCloseImageButton();
         return;
      }

   }
}
