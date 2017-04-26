package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition$Result;

final class o$a implements Recognition$Result {
   private final String a;
   private final int b;

   o$a(String var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public final int getScore() {
      return this.b;
   }

   public final String getText() {
      return this.a;
   }
}
