package com.google.android.gms.internal;

import java.util.Map;

public final class E implements com.google.android.gms.internal.I {
   private final com.google.android.gms.internal.F a;

   public E(com.google.android.gms.internal.F var1) {
      this.a = var1;
   }

   public final void a(com.google.android.gms.internal.bL var1, Map var2) {
      String var3 = (String)var2.get("name");
      if(var3 == null) {
         com.google.android.gms.internal.bJ.e("App event with no name parameter.");
      } else {
         this.a.a(var3, (String)var2.get("info"));
      }
   }
}
