package com.inmobi.commons.analytics.androidsdk;

import android.content.Context;
import com.inmobi.commons.internal.Log;

public final class IMAdTracker {
   private static IMAdTracker a;

   private boolean a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public static IMAdTracker getInstance() {
      synchronized(IMAdTracker.class){}

      IMAdTracker var0;
      try {
         if(a == null) {
            a = new IMAdTracker();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public final void init(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public final void reportAppDownloadGoal() {
      this.a("download");
   }

   public final void reportCustomGoal(String var1) {
      if("download".equals(var1)) {
         Log.debug("[InMobi]-[AdTracker]-4.5.2", "Download Goal should be reported using reportAppDownloadGoal()..");
      } else {
         this.a(var1);
      }
   }
}
