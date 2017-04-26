package com.millennialmedia.android;

class NVASpeechKit$AudioLevelTracker {
   private static final double MAX = 80.0D;
   private static final double MIN = 40.0D;
   private static final double NORMALIZE_FACTOR = 4.004004004004004D;
   private static final double SCALE = 9.99D;
   double audioLevel;
   int audioLevelCount;
   double averageLevel;
   boolean isTrackingAudioSample;

   public NVASpeechKit$AudioLevelTracker() {
      this.reset();
   }

   // $FF: synthetic method
   static double access$100(double var0) {
      return normalize(var0);
   }

   private static double normalize(double var0) {
      return Math.min(9.99D, Math.max(Math.floor(var0 - 40.0D) / 4.004004004004004D, 0.0D));
   }

   public boolean isTrackingAudioSample() {
      return this.isTrackingAudioSample;
   }

   public void reset() {
      this.averageLevel = 0.0D;
      this.audioLevelCount = 0;
      this.isTrackingAudioSample = false;
   }

   public void startTrackingAudioSample() {
      this.reset();
      this.isTrackingAudioSample = true;
   }

   public boolean update(double var1) {
      double var3 = this.averageLevel;
      double var5 = this.audioLevel;
      this.audioLevel = var1;
      ++this.audioLevelCount;
      this.averageLevel = (var3 * (double)(this.audioLevelCount - 1) + var1) / (double)this.audioLevelCount;
      return !this.isTrackingAudioSample && this.audioLevel != var5;
   }
}
