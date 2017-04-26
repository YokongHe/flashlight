package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.SpeechError;

final class v implements SpeechError {
   private final int a;
   private final String b;
   private final String c;

   public v(int var1, String var2, String var3) {
      this.a = var1;
      this.c = var3;
      var3 = var2;
      if(var2 == null) {
         switch(var1) {
         case 1:
            var3 = "Failed to connect to speech server.";
            break;
         case 2:
            var3 = "Please retry your query.";
            break;
         case 3:
         case 4:
         default:
            var3 = "An error occurred.";
            break;
         case 5:
            var3 = "Query cancelled.";
         }
      }

      this.b = var3;
   }

   public final int getErrorCode() {
      return this.a;
   }

   public final String getErrorDetail() {
      return this.b;
   }

   public final String getSuggestion() {
      return this.c;
   }
}
