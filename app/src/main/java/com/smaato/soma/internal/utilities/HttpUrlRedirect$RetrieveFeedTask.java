package com.smaato.soma.internal.utilities;

import android.os.AsyncTask;
import android.util.Log;
import java.net.HttpURLConnection;
import java.net.URL;

class HttpUrlRedirect$RetrieveFeedTask extends AsyncTask {
   protected String doInBackground(String... var1) {
      try {
         HttpURLConnection var4 = (HttpURLConnection)(new URL(var1[0])).openConnection();
         var4.setInstanceFollowRedirects(false);
         var4.connect();
         int var2 = var4.getResponseCode();
         Log.e("", "" + var2);
         String var5 = var4.getHeaderField("Location");
         Log.e("", var5);
         return var5;
      } catch (Exception var3) {
         var3.printStackTrace();
         return null;
      }
   }

   protected void onPostExecute(String var1) {
   }
}
