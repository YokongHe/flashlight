package com.millennialmedia.android;

import com.millennialmedia.android.Base64;
import com.millennialmedia.android.MMLog;
import org.json.JSONException;
import org.json.JSONObject;

class MMJSResponse {
   static final int ERROR = 0;
   static final int SUCCESS = 1;
   private static final String TAG = "MMJSResponse";
   String className;
   byte[] dataResponse;
   String methodName;
   Object response;
   int result;

   static MMJSResponse responseWithError() {
      return responseWithError("An unknown error occured.");
   }

   static MMJSResponse responseWithError(String var0) {
      MMJSResponse var1 = new MMJSResponse();
      var1.result = 0;
      var1.response = var0;
      return var1;
   }

   static MMJSResponse responseWithSuccess() {
      return responseWithSuccess("Success.");
   }

   static MMJSResponse responseWithSuccess(String var0) {
      MMJSResponse var1 = new MMJSResponse();
      var1.result = 1;
      var1.response = var0;
      return var1;
   }

   String toJSONString() {
      JSONObject var1;
      try {
         var1 = new JSONObject();
         if(this.className != null) {
            var1.put("class", this.className);
         }

         if(this.methodName != null) {
            var1.put("call", this.methodName);
         }

         var1.put("result", this.result);
         if(this.response != null) {
            var1.put("response", this.response);
         } else {
            if(this.dataResponse == null) {
               return "";
            }

            var1.put("response", Base64.encodeToString(this.dataResponse, false));
         }
      } catch (JSONException var2) {
         MMLog.e("MMJSResponse", var2.getMessage());
         return "";
      }

      return var1.toString();
   }
}
