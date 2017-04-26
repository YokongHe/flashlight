package com.amazon.device.ads;

import android.content.Context;

public class PermissionChecker$PermissionCheckerExecutor {
   public boolean hasPermission(Context var1, String var2) {
      return var1.checkCallingOrSelfPermission(var2) == 0;
   }
}
