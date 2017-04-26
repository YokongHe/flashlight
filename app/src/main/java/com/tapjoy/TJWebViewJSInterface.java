package com.tapjoy;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tapjoy.TJWebViewJSInterfaceListener;
import com.tapjoy.TapjoyLog;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJWebViewJSInterface {
   WebView a;
   TJWebViewJSInterfaceListener b;

   public TJWebViewJSInterface(WebView var1, TJWebViewJSInterfaceListener var2) {
      this.a = var1;
      this.b = var2;
   }

   public void callback(ArrayList var1, String var2, String var3) {
      try {
         this.callbackToJavaScript(new JSONArray(var1), var2, var3);
      } catch (Exception var4) {
         var4.printStackTrace();
      }
   }

   public void callback(Map var1, String var2, String var3) {
      try {
         JSONArray var4 = new JSONArray();
         var4.put(new JSONObject(var1));
         this.callbackToJavaScript(var4, var2, var3);
      } catch (Exception var5) {
         TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + var5.toString());
         var5.printStackTrace();
      }
   }

   public void callbackToJavaScript(Object param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public void dispatchMethod(String var1) {
      TapjoyLog.i("TJWebViewJSInterface", "dispatchMethod params: " + var1);

      try {
         JSONObject var4 = new JSONObject(var1);
         String var2 = var4.getJSONObject("data").getString("method");
         TapjoyLog.i("TJWebViewJSInterface", "method: " + var2);
         if(this.b != null) {
            this.b.onDispatchMethod(var2, var4);
         }

      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }
}
