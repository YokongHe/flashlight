package com.flurry.sdk;

import com.flurry.sdk.jn;
import com.flurry.sdk.jr;
import com.flurry.sdk.mp;
import com.flurry.sdk.mr;
import com.flurry.sdk.mt;

public abstract class jr$b extends jr {
   public String a(jn var1, mp var2, String var3) {
      return this.a(var3);
   }

   public String a(jn var1, mr var2, String var3) {
      return this.a(var3);
   }

   public String a(jn var1, mt var2, String var3) {
      return this.a(var3);
   }

   public abstract String a(String var1);

   public String b(jn var1, mr var2, String var3) {
      return this.a(var3);
   }
}
