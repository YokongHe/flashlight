package com.tapjoy.mraid.util;

import android.os.Bundle;

public class Utils {
   public static String byteToHex(byte var0) {
      char[] var1 = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
      return new String(new char[]{var1[var0 >> 4 & 15], var1[var0 & 15]});
   }

   public static String convert(String param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getData(String var0, Bundle var1) {
      return var1.getString(var0);
   }
}
