package com.mopub.common.util;

import org.apache.http.conn.util.InetAddressUtils;

public enum DeviceUtils$IP {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP;
   IPv4,
   IPv6;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP() {
      int[] var0 = $SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[values().length];

         try {
            var0[IPv4.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[IPv6.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP = var0;
         return var0;
      }
   }

   // $FF: synthetic method
   static boolean access$3(DeviceUtils$IP var0, String var1) {
      return var0.matches(var1);
   }

   // $FF: synthetic method
   static String access$4(DeviceUtils$IP var0, String var1) {
      return var0.toString(var1);
   }

   private boolean matches(String var1) {
      switch($SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP()[this.ordinal()]) {
      case 1:
         return InetAddressUtils.isIPv4Address(var1);
      case 2:
         return InetAddressUtils.isIPv6Address(var1);
      default:
         return false;
      }
   }

   private String toString(String var1) {
      String var2 = var1;
      switch($SWITCH_TABLE$com$mopub$common$util$DeviceUtils$IP()[this.ordinal()]) {
      case 2:
         return var1.split("%")[0];
      default:
         var2 = null;
      case 1:
         return var2;
      }
   }
}
