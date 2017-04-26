package com.flurry.sdk;

import com.flurry.sdk.kt;
import com.flurry.sdk.lc;
import com.flurry.sdk.lc$b;
import com.flurry.sdk.sq;
import java.util.ArrayList;
import java.util.HashMap;

public class lc$a {
   private final ArrayList a = new ArrayList();
   private final HashMap b = new HashMap();

   public lc a() {
      return new lc((lc$b[])this.a.toArray(new lc$b[this.a.size()]), this.b, (String[])null, (sq[])null);
   }

   public void a(kt var1, String var2) {
      Integer var3 = Integer.valueOf(this.a.size());
      this.a.add(new lc$b(var1, var2));
      this.b.put(var1.c(), var3);
      this.b.put(var2, var3);
   }
}
