package com.mopub.network;

import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError {
   private final MoPubNetworkError$Reason mReason;

   public MoPubNetworkError(MoPubNetworkError$Reason var1) {
      this.mReason = var1;
   }

   public MoPubNetworkError(NetworkResponse var1, MoPubNetworkError$Reason var2) {
      super(var1);
      this.mReason = var2;
   }

   public MoPubNetworkError(String var1, MoPubNetworkError$Reason var2) {
      super(var1);
      this.mReason = var2;
   }

   public MoPubNetworkError(String var1, Throwable var2, MoPubNetworkError$Reason var3) {
      super(var1, var2);
      this.mReason = var3;
   }

   public MoPubNetworkError(Throwable var1, MoPubNetworkError$Reason var2) {
      super(var1);
      this.mReason = var2;
   }

   public MoPubNetworkError$Reason getReason() {
      return this.mReason;
   }
}
