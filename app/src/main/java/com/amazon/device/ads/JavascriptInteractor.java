package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.JavascriptInteractor$Executor;
import com.amazon.device.ads.JavascriptInteractor$JavascriptMethodExecutor;
import com.amazon.device.ads.Log;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class JavascriptInteractor {
   private static final String LOG_TAG = JavascriptInteractor.class.getSimpleName();
   private static String executorMethodName;
   private final JavascriptInteractor$Executor executor = new JavascriptInteractor$Executor(this);
   private final Map methodMap = new ConcurrentHashMap();

   // $FF: synthetic method
   static JSONObject access$000(JavascriptInteractor var0, String var1, String var2) {
      return var0.execute(var1, var2);
   }

   private JSONObject execute(String var1, String var2) {
      JSONObject var3;
      if(var2 != null && var2.length() > 2) {
         JSONObject var4 = JSONUtils.getJSONObjectFromString(var2);
         var3 = var4;
         if(var4 == null) {
            Log.w(LOG_TAG, "The javascript object \"%s\" could not be parsed for method \"%s\".", new Object[]{var2, var1});
            return null;
         }
      } else {
         var3 = null;
      }

      return this.execute(var1, var3);
   }

   private JSONObject execute(String var1, JSONObject var2) {
      if(this.methodMap.containsKey(var1)) {
         return ((JavascriptInteractor$JavascriptMethodExecutor)this.methodMap.get(var1)).execute(var2);
      } else {
         Log.w(LOG_TAG, "The method %s was not recongized by this javascript interface.", new Object[]{var1});
         return null;
      }
   }

   public static String getExecutorMethodName() {
      if(executorMethodName == null) {
         Method[] var0 = JavascriptInteractor$Executor.class.getDeclaredMethods();
         if(var0 != null && var0.length == 1) {
            executorMethodName = var0[0].getName();
         } else {
            Log.e(LOG_TAG, "Could not obtain the method name for javascript interfacing.");
         }
      }

      return executorMethodName;
   }

   public void addMethodExecutor(JavascriptInteractor$JavascriptMethodExecutor var1) {
      if(this.methodMap.containsKey(var1.getMethodName())) {
         throw new IllegalArgumentException("There is another executor with that method name already added.");
      } else {
         this.methodMap.put(var1.getMethodName(), var1);
      }
   }

   public JavascriptInteractor$Executor getExecutor() {
      return this.executor;
   }
}
