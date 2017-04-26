package com.mopub.common.util;

import com.mopub.common.util.Utils;

class ManifestUtils$FlagCheckUtil {
   public boolean hasFlag(Class var1, int var2, int var3) {
      return Utils.bitMaskContainsFlag(var2, var3);
   }
}
