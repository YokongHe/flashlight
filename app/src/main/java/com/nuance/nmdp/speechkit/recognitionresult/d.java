package com.nuance.nmdp.speechkit.recognitionresult;

import com.nuance.nmdp.speechkit.recognitionresult.Token;

final class d implements Token {
   private .cq a;

   d(.cq var1) {
      this.a = var1;
   }

   public final double getConfidenceScore() {
      return this.a.a();
   }

   public final String toString() {
      return this.a.toString();
   }
}
