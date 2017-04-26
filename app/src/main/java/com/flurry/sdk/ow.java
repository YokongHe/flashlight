package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.ou;
import com.flurry.sdk.ox$a;
import com.flurry.sdk.sh;
import java.util.HashMap;

public final class ow {
   protected final ou a;
   protected final ox$a b = new ox$a(this.getClass(), false);

   private ow(ou var1) {
      this.a = var1;
   }

   public static ow a(HashMap var0) {
      return new ow(new ou(var0));
   }

   public final jk a(sh var1) {
      this.b.a(var1);
      return this.a.a(this.b);
   }

   public final jk a(Class var1) {
      this.b.a(var1);
      return this.a.a(this.b);
   }

   public final ow a() {
      return new ow(this.a);
   }

   public final jk b(sh var1) {
      this.b.b(var1);
      return this.a.a(this.b);
   }

   public final jk b(Class var1) {
      this.b.b(var1);
      return this.a.a(this.b);
   }
}
