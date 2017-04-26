package com.amazon.device.ads;

import android.webkit.JavascriptInterface;
import com.amazon.device.ads.JavascriptInteractor;
import org.json.JSONObject;

public class JavascriptInteractor$Executor {
   private final JavascriptInteractor interactor;
   private boolean proguardKeeper = false;

   public JavascriptInteractor$Executor(JavascriptInteractor var1) {
      this.interactor = var1;
      if(this.proguardKeeper) {
         this.execute((String)null, (String)null);
      }

   }

   @JavascriptInterface
   public String execute(String var1, String var2) {
      JSONObject var3 = JavascriptInteractor.access$000(this.interactor, var1, var2);
      return var3 == null?null:var3.toString();
   }
}
