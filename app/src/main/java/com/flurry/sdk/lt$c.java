package com.flurry.sdk;

import com.flurry.sdk.iz;
import com.flurry.sdk.lt;
import java.net.InetAddress;

public class lt$c extends lt {
   public lt$c() {
      super(InetAddress.class);
   }

   // $FF: synthetic method
   protected Object a(String var1, iz var2) {
      return this.b(var1, var2);
   }

   protected InetAddress b(String var1, iz var2) {
      return InetAddress.getByName(var1);
   }
}
