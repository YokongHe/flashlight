package com.mopub.common.util;

import com.mopub.common.util.Timer$State;
import java.util.concurrent.TimeUnit;

public class Timer {
   private long mStartTimeNanos;
   private Timer$State mState;
   private long mStopTimeNanos;

   public Timer() {
      this.mState = Timer$State.STOPPED;
   }

   public long getTime() {
      long var1;
      if(this.mState == Timer$State.STARTED) {
         var1 = System.nanoTime();
      } else {
         var1 = this.mStopTimeNanos;
      }

      return TimeUnit.MILLISECONDS.convert(var1 - this.mStartTimeNanos, TimeUnit.NANOSECONDS);
   }

   public void start() {
      this.mStartTimeNanos = System.nanoTime();
      this.mState = Timer$State.STARTED;
   }

   public void stop() {
      if(this.mState != Timer$State.STARTED) {
         throw new IllegalStateException("EventTimer was not started.");
      } else {
         this.mState = Timer$State.STOPPED;
         this.mStopTimeNanos = System.nanoTime();
      }
   }
}
