package com.nuance.nmdp.speechkit.recognitionresult;

import com.nuance.nmdp.speechkit.recognitionresult.DetailedResult;
import com.nuance.nmdp.speechkit.recognitionresult.Token;
import java.util.ArrayList;
import java.util.List;

final class c implements DetailedResult {
   private .cp a;

   c(.cp var1) {
      this.a = var1;
   }

   public final List getAlternatives(int var1, int var2) {
      ArrayList var3 = new ArrayList();
      .cl var4 = this.a.a(var1, var2);

      for(var1 = 0; var1 < var4.a(); ++var1) {
         var3.add(new com.nuance.nmdp.speechkit.recognitionresult.a(var4.a(var1)));
      }

      return var3;
   }

   public final double getConfidenceScore() {
      return this.a.b();
   }

   public final Token getTokenAtCursorPosition(int var1) {
      return new com.nuance.nmdp.speechkit.recognitionresult.d(this.a.b(var1));
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
