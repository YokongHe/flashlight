package com.ihs.a.e;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import java.util.Map;

public final class e {
   private final Bundle a = new Bundle();
   private final Map b = new ArrayMap();

   public final void a(String var1, Object var2) {
      this.b.put(var1, var2);
   }

   public final void a(String var1, String var2) {
      this.a.putString(var1, var2);
   }
}
