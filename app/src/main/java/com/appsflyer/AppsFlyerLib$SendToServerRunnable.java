package com.appsflyer;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.Map;

class AppsFlyerLib$SendToServerRunnable implements Runnable {
   private WeakReference ctxReference;
   Map params;
   private String urlString;

   private AppsFlyerLib$SendToServerRunnable(String var1, Map var2, Context var3) {
      this.ctxReference = null;
      this.urlString = var1;
      this.params = var2;
      this.ctxReference = new WeakReference(var3);
   }

   // $FF: synthetic method
   AppsFlyerLib$SendToServerRunnable(String var1, Map var2, Context var3, Object var4) {
      this(var1, var2, var3);
   }

   private void callServer(URL param1, String param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public void run() {
      // $FF: Couldn't be decompiled
   }
}
