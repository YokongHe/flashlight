package com.flurry.sdk;

import com.flurry.sdk.gc;
import com.flurry.sdk.gd;
import com.flurry.sdk.gh;
import com.flurry.sdk.gj$a;
import java.io.OutputStream;

public class gj {
   private static final gj c = new gj$a(null);
   protected int a = 2048;
   protected int b = 65536;

   public static gj a() {
      return c;
   }

   public gc a(OutputStream var1, gc var2) {
      return var2 != null && var2.getClass().equals(gd.class)?((gd)var2).a(var1, this.a):new gd(var1, this.a);
   }

   public gj a(int var1) {
      int var2 = 16777216;
      byte var3 = 32;
      if(var1 < 32) {
         var1 = var3;
      }

      if(var1 > 16777216) {
         var1 = var2;
      }

      this.a = var1;
      return this;
   }

   public gc b(OutputStream var1, gc var2) {
      return var2 != null && var2.getClass().equals(gh.class)?((gh)var2).a(var1):new gh(var1);
   }
}
