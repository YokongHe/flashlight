package com.millennialmedia.android;

import android.util.DisplayMetrics;
import android.view.View;
import com.millennialmedia.android.MMLog;
import org.json.JSONException;
import org.json.JSONObject;

class Utils {
   private static final String TAG = "Utils";

   static JSONObject getViewDimensions(View var0) {
      JSONObject var1 = new JSONObject();
      if(var0 == null) {
         MMLog.e("Utils", "Unable to calculate view dimensions for null view");
      } else {
         DisplayMetrics var2 = var0.getContext().getResources().getDisplayMetrics();
         if(var2 != null) {
            int[] var3 = new int[2];
            var0.getLocationInWindow(var3);

            try {
               var1.put("x", (int)((float)var3[0] / var2.density));
               var1.put("y", (int)((float)var3[1] / var2.density));
               var1.put("width", (int)((float)var0.getWidth() / var2.density));
               var1.put("height", (int)((float)var0.getHeight() / var2.density));
               return var1;
            } catch (JSONException var4) {
               MMLog.e("Utils", "Unable to build view dimensions", var4);
               return var1;
            }
         }
      }

      return var1;
   }
}
