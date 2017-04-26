package com.inmobi.commons.internal;

public class ActivityRecognitionSampler$ActivitySample {
   private long a;
   private int b;

   public ActivityRecognitionSampler$ActivitySample(int var1, long var2) {
      this.b = var1;
      this.a = var2;
   }

   public int getActivity() {
      return this.b;
   }

   public long getTimestamp() {
      return this.a;
   }
}
