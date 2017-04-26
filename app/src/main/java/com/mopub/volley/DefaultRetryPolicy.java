package com.mopub.volley;

import com.mopub.volley.RetryPolicy;
import com.mopub.volley.VolleyError;

public class DefaultRetryPolicy implements RetryPolicy {
   public static final float DEFAULT_BACKOFF_MULT = 1.0F;
   public static final int DEFAULT_MAX_RETRIES = 1;
   public static final int DEFAULT_TIMEOUT_MS = 2500;
   private final float mBackoffMultiplier;
   private int mCurrentRetryCount;
   private int mCurrentTimeoutMs;
   private final int mMaxNumRetries;

   public DefaultRetryPolicy() {
      this(2500, 1, 1.0F);
   }

   public DefaultRetryPolicy(int var1, int var2, float var3) {
      this.mCurrentTimeoutMs = var1;
      this.mMaxNumRetries = var2;
      this.mBackoffMultiplier = var3;
   }

   public int getCurrentRetryCount() {
      return this.mCurrentRetryCount;
   }

   public int getCurrentTimeout() {
      return this.mCurrentTimeoutMs;
   }

   protected boolean hasAttemptRemaining() {
      return this.mCurrentRetryCount <= this.mMaxNumRetries;
   }

   public void retry(VolleyError var1) {
      ++this.mCurrentRetryCount;
      this.mCurrentTimeoutMs = (int)((float)this.mCurrentTimeoutMs + (float)this.mCurrentTimeoutMs * this.mBackoffMultiplier);
      if(!this.hasAttemptRemaining()) {
         throw var1;
      }
   }
}
