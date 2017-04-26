package com.millennialmedia.android;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import com.millennialmedia.android.BridgeMMDevice;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.Utils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class AdProperties {
   private static final String TAG = AdProperties.class.getName();
   WeakReference contextRef;

   AdProperties(Context var1) {
      this.contextRef = new WeakReference(var1);
   }

   private JSONObject getPermissions() {
      JSONObject var2 = new JSONObject();
      boolean var1;
      if(this.getContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.put("android.permission.ACCESS_FINE_LOCATION", var1);
      return var2;
   }

   private JSONObject getScreen() {
      JSONObject var1 = new JSONObject();
      var1.put("height", this.getScreenDpiIndependentHeight());
      var1.put("width", this.getScreenDpiIndependentWidth());
      return var1;
   }

   private JSONObject getSupports() {
      JSONObject var1 = new JSONObject();
      Context var2 = this.getContext();
      var1.put("sms", Boolean.parseBoolean(MMSDK.getSupportsSms(var2)));
      var1.put("tel", Boolean.parseBoolean(MMSDK.getSupportsTel(var2)));
      var1.put("calendar", MMSDK.getSupportsCalendar());
      var1.put("storePicture", false);
      var1.put("inlineVideo", true);
      return var1;
   }

   int getAdDpiIndependentHeight() {
      return this.getScreenDpiIndependentHeight();
   }

   int getAdDpiIndependentWidth() {
      return this.getScreenDpiIndependentWidth();
   }

   public JSONObject getAdProperties(View var1) {
      JSONObject var2 = new JSONObject();

      try {
         var2.put("screen", this.getScreen());
         var2.put("ad", Utils.getViewDimensions(var1));
         var2.put("do", MMSDK.getOrientation(this.getContext()));
         var2.put("supports", this.getSupports());
         var2.put("device", BridgeMMDevice.getDeviceInfo(this.getContext()));
         var2.put("permissions", this.getPermissions());
         var2.put("maxSize", this.getScreen());
         return var2;
      } catch (JSONException var3) {
         MMLog.e(TAG, "Error when building ad properties", var3);
         return var2;
      }
   }

   Context getContext() {
      return (Context)this.contextRef.get();
   }

   int getScreenDpiIndependentHeight() {
      DisplayMetrics var1 = this.getContext().getResources().getDisplayMetrics();
      return (int)((float)var1.heightPixels / var1.density);
   }

   int getScreenDpiIndependentWidth() {
      DisplayMetrics var1 = this.getContext().getResources().getDisplayMetrics();
      return (int)((float)var1.widthPixels / var1.density);
   }
}
