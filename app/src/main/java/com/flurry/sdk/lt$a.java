package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.lt;
import java.nio.charset.Charset;

public class lt$a extends lt {
   public lt$a() {
      super(Charset.class);
   }

   // $FF: synthetic method
   protected Object a(String var1, iz var2) {
      return this.b(var1, var2);
   }

   protected Charset b(String var1, iz var2) {
      return Charset.forName(var1);
   }
}
