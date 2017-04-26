package com.millennialmedia.android;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.millennialmedia.android.DTOResizeParameters;
import com.millennialmedia.android.MMJSObject;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.MMWebView;
import java.util.Map;

class BridgeMMBanner extends MMJSObject {
   static final String RESIZE = "resize";

   MMJSResponse executeCommand(String var1, Map var2) {
      MMJSResponse var3 = null;
      if("resize".equals(var1)) {
         var3 = this.resize(var2);
      }

      return var3;
   }

   int getScreenHeight(Context var1) {
      return Integer.parseInt(MMSDK.getDpiHeight(var1));
   }

   int getScreenWidth(Context var1) {
      return Integer.parseInt(MMSDK.getDpiWidth(var1));
   }

   public MMJSResponse resize(Map var1) {
      int var5 = 0;
      MMWebView var9 = (MMWebView)this.mmWebViewRef.get();
      if(var9 != null) {
         if(var9.isMraidResized()) {
            return MMJSResponse.responseWithError("State is currently resized");
         } else {
            String var10 = (String)var1.get("width");
            String var11 = (String)var1.get("height");
            int var2;
            if(!TextUtils.isEmpty(var10)) {
               var2 = (int)Float.parseFloat(var10);
            } else {
               var2 = 0;
            }

            int var3;
            if(!TextUtils.isEmpty(var11)) {
               var3 = (int)Float.parseFloat(var11);
            } else {
               var3 = 0;
            }

            var10 = (String)var1.get("customClosePosition");
            var11 = (String)var1.get("offsetX");
            String var12 = (String)var1.get("offsetY");
            int var4;
            if(!TextUtils.isEmpty(var12)) {
               var4 = (int)Float.parseFloat(var12);
            } else {
               var4 = 0;
            }

            if(!TextUtils.isEmpty(var11)) {
               var5 = (int)Float.parseFloat(var11);
            }

            boolean var8 = Boolean.parseBoolean((String)var1.get("allowOffscreen"));
            Context var13 = var9.getContext();
            DisplayMetrics var14 = var13.getResources().getDisplayMetrics();
            int var6 = this.getScreenWidth(var13);
            int var7 = this.getScreenHeight(var13);
            var9.setMraidResize(new DTOResizeParameters(var14.density, var2, var3, var10, var5, var4, var8, var6, var7));
            return MMJSResponse.responseWithSuccess();
         }
      } else {
         return null;
      }
   }
}
