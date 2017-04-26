package com.smaato.soma.toaster;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.toaster.CloseButtonImage;
import java.net.URL;

class CloseButtonImage$GetBitMap extends AsyncTask {
   // $FF: synthetic field
   final CloseButtonImage this$0;

   CloseButtonImage$GetBitMap(CloseButtonImage var1) {
      this.this$0 = var1;
   }

   protected Bitmap doInBackground(final String... var1) {
      return (Bitmap)(new CrashReportTemplate() {
         public Bitmap process() {
            return BitmapFactory.decodeStream((new URL(var1[0])).openConnection().getInputStream());
         }
      }).execute();
   }
}
