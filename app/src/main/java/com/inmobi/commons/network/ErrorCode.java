package com.inmobi.commons.network;

public enum ErrorCode {
   CONNECTION_ERROR("Socket timeout exception"),
   INTERNAL_ERROR("An internal error occurred while fetching"),
   INVALID_REQUEST("Invalid request"),
   NETWORK_ERROR("Network failure. Check your connection");

   private String a;

   private ErrorCode(String var3) {
      this.a = var3;
   }

   public final void setMessage(String var1) {
      this.a = var1;
   }

   public final String toString() {
      return this.a;
   }
}
