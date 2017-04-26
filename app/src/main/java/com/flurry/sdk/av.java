package com.flurry.sdk;

import com.flurry.sdk.ex;

public class av extends com.flurry.sdk.aw {
   private static final String a = com.flurry.sdk.aw.class.getSimpleName();
   private final ex b;

   public av(ex var1, String var2, long var3, boolean var5) {
      super(var2, var3, var5);
      if(var1 == null) {
         throw new IllegalArgumentException("Serializer cannot be null");
      } else {
         this.b = var1;
      }
   }
}
