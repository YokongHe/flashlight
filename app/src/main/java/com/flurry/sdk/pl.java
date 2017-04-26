package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pt;
import java.net.InetAddress;

public class pl extends pt {
   public static final pl a = new pl();

   public pl() {
      super(InetAddress.class);
   }

   public void a(InetAddress var1, hf var2, jw var3) {
      String var6 = var1.toString().trim();
      int var4 = var6.indexOf(47);
      String var5 = var6;
      if(var4 >= 0) {
         if(var4 == 0) {
            var5 = var6.substring(1);
         } else {
            var5 = var6.substring(0, var4);
         }
      }

      var2.b(var5);
   }

   public void a(InetAddress var1, hf var2, jw var3, jz var4) {
      var4.a(var1, var2, InetAddress.class);
      this.a(var1, var2, var3);
      var4.d(var1, var2);
   }
}
