package com.millennialmedia.android;

import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.Utils$ThreadUtils;
import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

class Utils$HttpUtils {
   static void executeUrl(final String var0) {
      Utils$ThreadUtils.execute(new Runnable() {
         public final void run() {
            try {
               (new DefaultHttpClient()).execute(new HttpGet(var0));
               MMLog.d("Utils", "Executed Url :\"" + var0 + "\"");
            } catch (IOException var2) {
               MMLog.e("Utils", "Exception with HttpUtils: ", var2);
            }
         }
      });
   }
}
