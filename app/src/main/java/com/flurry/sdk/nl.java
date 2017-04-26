package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.sdk.is;
import com.flurry.sdk.nh;
import com.flurry.sdk.nj;
import com.flurry.sdk.sh;

public class nl extends nj {
   protected final String a;

   public nl(sh var1, nh var2, is var3, Class var4, String var5) {
      super(var1, var2, var3, var4);
      this.a = var5;
   }

   public JsonTypeInfo$As a() {
      return JsonTypeInfo$As.EXTERNAL_PROPERTY;
   }

   public String b() {
      return this.a;
   }
}
