package com.tapjoy.internal;

import com.tapjoy.internal.fv;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gs$a;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class gd implements com.tapjoy.internal.cl {
   final fv a;
   Set b;
   private final Map c;
   private final Map d;

   public gd(fv var1) {
      this.a = var1;
      this.c = Collections.synchronizedMap(new HashMap());
      this.d = com.tapjoy.internal.cz.a();
      this.b = null;
   }

   private void a(com.tapjoy.internal.cg param1, gs$a param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(com.tapjoy.internal.cg var1) {
      this.a(var1, new gs$a(new gb(), (List)null));
   }
}
