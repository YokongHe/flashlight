package com.tapjoy.mraid.view;

import android.os.AsyncTask;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.mraid.view.MraidView;

final class MraidView$a extends AsyncTask {
   TapjoyHttpURLResponse a;
   TapjoyURLConnection b;
   String c;
   // $FF: synthetic field
   final MraidView d;

   private MraidView$a(MraidView var1) {
      this.d = var1;
   }

   // $FF: synthetic method
   MraidView$a(MraidView var1, byte var2) {
      this(var1);
   }

   private Void a(String... var1) {
      this.c = var1[0];

      try {
         this.b = new TapjoyURLConnection();
         this.a = this.b.getResponseFromURL(this.c);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return null;
   }

   // $FF: synthetic method
   protected final Object doInBackground(Object[] var1) {
      return this.a((String[])var1);
   }

   // $FF: synthetic method
   protected final void onPostExecute(Object var1) {
      try {
         if(this.a.statusCode != 0 && this.a.response != null) {
            if(this.a.statusCode == 302 && this.a.redirectURL != null && this.a.redirectURL.length() > 0) {
               TapjoyLog.i("MRAIDView", "302 redirectURL detected: " + this.a.redirectURL);
               this.d.loadUrlStandard(this.a.redirectURL);
               return;
            }

            this.d.loadDataWithBaseURL(this.c, this.a.response, "text/html", "utf-8", this.c);
         } else {
            TapjoyLog.e("MRAIDView", "Connection not properly established");
            if(MraidView.a(this.d) != null) {
               MraidView.a(this.d).onReceivedError(this.d, 0, "Connection not properly established", this.c);
               return;
            }
         }

      } catch (Exception var2) {
         TapjoyLog.w("MRAIDView", "error in loadURL " + var2);
         var2.printStackTrace();
      }
   }
}
