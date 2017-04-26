package com.google.android.gms.common;

import android.app.PendingIntent;

public final class a {
   public static final com.google.android.gms.common.a a = new com.google.android.gms.common.a(0, (PendingIntent)null);
   private final PendingIntent b;
   private final int c;

   public a(int var1, PendingIntent var2) {
      this.c = var1;
      this.b = var2;
   }

   public final String toString() {
      com.google.android.gms.internal.cL var2 = com.google.android.gms.internal.cK.a(this);
      String var1;
      switch(this.c) {
      case 0:
         var1 = "SUCCESS";
         break;
      case 1:
         var1 = "SERVICE_MISSING";
         break;
      case 2:
         var1 = "SERVICE_VERSION_UPDATE_REQUIRED";
         break;
      case 3:
         var1 = "SERVICE_DISABLED";
         break;
      case 4:
         var1 = "SIGN_IN_REQUIRED";
         break;
      case 5:
         var1 = "INVALID_ACCOUNT";
         break;
      case 6:
         var1 = "RESOLUTION_REQUIRED";
         break;
      case 7:
         var1 = "NETWORK_ERROR";
         break;
      case 8:
         var1 = "INTERNAL_ERROR";
         break;
      case 9:
         var1 = "SERVICE_INVALID";
         break;
      case 10:
         var1 = "DEVELOPER_ERROR";
         break;
      case 11:
         var1 = "LICENSE_CHECK_FAILED";
         break;
      case 12:
      default:
         var1 = "unknown status code " + this.c;
         break;
      case 13:
         var1 = "CANCELED";
         break;
      case 14:
         var1 = "TIMEOUT";
         break;
      case 15:
         var1 = "INTERRUPTED";
      }

      return var2.a("statusCode", var1).a("resolution", this.b).toString();
   }
}
