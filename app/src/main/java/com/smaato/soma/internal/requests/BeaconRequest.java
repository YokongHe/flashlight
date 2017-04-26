package com.smaato.soma.internal.requests;

import android.os.AsyncTask;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.LoadingBeaconFailed;
import com.smaato.soma.internal.requests.RequestsBuilder;
import java.net.HttpURLConnection;
import java.net.URL;

public class BeaconRequest extends AsyncTask {
   protected final Void doInBackground(final String... var1) {
      return (Void)(new CrashReportTemplate() {
         public Void process() {
            String[] var3 = var1;
            int var2 = var3.length;

            for(int var1x = 0; var1x < var2; ++var1x) {
               String var4 = var3[var1x];
               BeaconRequest.this.loadBeacon(var4);
            }

            return null;
         }
      }).execute();
   }

   protected final void loadBeacon(String var1) {
      try {
         Debugger.methodStart(new Object() {
         });
         HttpURLConnection var4 = (HttpURLConnection)(new URL(var1)).openConnection();
         var4.setRequestMethod("GET");
         var4.setConnectTimeout(5000);
         var4.setRequestProperty("User-Agent", RequestsBuilder.getInstance().getUserAgent());
         var4.connect();
         var4.getInputStream();
         var4.disconnect();
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new LoadingBeaconFailed(var3);
      }
   }
}
