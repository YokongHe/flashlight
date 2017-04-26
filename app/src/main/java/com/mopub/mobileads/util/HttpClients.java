package com.mopub.mobileads.util;

import org.apache.http.client.HttpClient;

public class HttpClients {
   public static void safeShutdown(final HttpClient var0) {
      (new Thread(new Runnable() {
         public void run() {
            if(var0 != null && var0.getConnectionManager() != null) {
               var0.getConnectionManager().shutdown();
            }

         }
      })).start();
   }
}
