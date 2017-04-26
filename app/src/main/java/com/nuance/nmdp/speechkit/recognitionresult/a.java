package com.nuance.nmdp.speechkit.recognitionresult;

import com.nuance.nmdp.speechkit.recognitionresult.AlternativeChoice;
import java.util.ArrayList;
import java.util.List;

final class a implements AlternativeChoice {
   private .ck a;

   a(.ck var1) {
      this.a = var1;
   }

   public final List getTokens() {
      ArrayList var2 = new ArrayList();

      for(int var1 = 0; var1 < this.a.a(); ++var1) {
         var2.add(new com.nuance.nmdp.speechkit.recognitionresult.d(this.a.a(var1)));
      }

      return var2;
   }

   public final String toString() {
      return this.a.toString();
   }
}
