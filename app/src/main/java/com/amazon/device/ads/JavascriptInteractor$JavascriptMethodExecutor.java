package com.amazon.device.ads;

import org.json.JSONObject;

public abstract class JavascriptInteractor$JavascriptMethodExecutor {
   private final String methodName;

   protected JavascriptInteractor$JavascriptMethodExecutor(String var1) {
      this.methodName = var1;
   }

   protected abstract JSONObject execute(JSONObject var1);

   public String getMethodName() {
      return this.methodName;
   }
}
