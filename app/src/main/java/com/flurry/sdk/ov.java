package com.flurry.sdk;

import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.ov$b;
import com.flurry.sdk.ov$d;
import com.flurry.sdk.sh;

public abstract class ov {
   public static ov a() {
      return ov$b.a;
   }

   public abstract jk a(Class var1);

   public final ov$d a(sh var1, jw var2, is var3) {
      jk var4 = var2.a(var1, var3);
      return new ov$d(var4, this.a(var1.p(), var4));
   }

   public final ov$d a(Class var1, jw var2, is var3) {
      jk var4 = var2.a(var1, var3);
      return new ov$d(var4, this.a(var1, var4));
   }

   public abstract ov a(Class var1, jk var2);
}
