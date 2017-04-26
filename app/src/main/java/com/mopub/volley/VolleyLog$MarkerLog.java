package com.mopub.volley;

import android.os.SystemClock;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.VolleyLog$MarkerLog$Marker;
import java.util.ArrayList;
import java.util.List;

class VolleyLog$MarkerLog {
   public static final boolean ENABLED;
   private static final long MIN_DURATION_FOR_LOGGING_MS = 0L;
   private boolean mFinished = false;
   private final List mMarkers = new ArrayList();

   static {
      ENABLED = VolleyLog.DEBUG;
   }

   private long getTotalDuration() {
      if(this.mMarkers.size() == 0) {
         return 0L;
      } else {
         long var1 = ((VolleyLog$MarkerLog$Marker)this.mMarkers.get(0)).time;
         return ((VolleyLog$MarkerLog$Marker)this.mMarkers.get(this.mMarkers.size() - 1)).time - var1;
      }
   }

   public void add(String var1, long var2) {
      synchronized(this){}

      try {
         if(this.mFinished) {
            throw new IllegalStateException("Marker added to finished log");
         }

         this.mMarkers.add(new VolleyLog$MarkerLog$Marker(var1, var2, SystemClock.elapsedRealtime()));
      } finally {
         ;
      }

   }

   protected void finalize() {
      if(!this.mFinished) {
         this.finish("Request on the loose");
         VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }

   }

   public void finish(String param1) {
      // $FF: Couldn't be decompiled
   }
}
