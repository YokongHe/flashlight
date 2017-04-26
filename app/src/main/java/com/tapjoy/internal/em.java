package com.tapjoy.internal;

public enum em {
   a("Not Yet", "Profile request has successfully started but is not completed"),
   b("Okay", "Completed, No errors"),
   c("Connection Error", "There has been a connection issue, profiling aborted"),
   d("Host Not Found", "Unable to resolve the host name"),
   e("Network Timeout", "Communications layer timed out"),
   f("Internal Error", "Internal Error, profiling incomplete or interrupted"),
   g("Host Verification Error", "Certificate verification failure! Potential MITM attack"),
   h("Interrupted", "Request was cancelled"),
   i("Invalid ORG ID", "Request contained an invalid org id"),
   j("Configuration Error", "Failed to retrieve configuration from server"),
   k("Partial Profile", "Connection error, only partial profile completed");

   private final String l;
   private final String m;

   private em(String var3, String var4) {
      this.l = var3;
      this.m = var4;
   }

   public final String a() {
      return this.m;
   }

   public final String toString() {
      return this.l;
   }
}
