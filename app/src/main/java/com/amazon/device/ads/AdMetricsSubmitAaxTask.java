package com.amazon.device.ads;

import android.os.AsyncTask;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;

class AdMetricsSubmitAaxTask extends AsyncTask {
   private static final String LOG_TAG = "AdMetricsSubmitTask";

   public Void doInBackground(WebRequest... var1) {
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         WebRequest var4 = var1[var2];

         try {
            var4.makeCall();
         } catch (WebRequest$WebRequestException var5) {
            switch(null.$SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[var5.getStatus().ordinal()]) {
            case 1:
               Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", new Object[]{var5.getMessage()});
               break;
            case 2:
               Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to Network Failure, msg: %s", new Object[]{var5.getMessage()});
               break;
            case 3:
               Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", new Object[]{var5.getMessage()});
            case 4:
               Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", new Object[]{var5.getMessage()});
            }
         }
      }

      return null;
   }
}
