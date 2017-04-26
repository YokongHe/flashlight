package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericRecognition;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Dictionary;
import com.nuance.nmdp.speechkit.util.pdx.PdxValue$Integer;

final class h$a implements GenericRecognition {
   private final boolean a;
   private final PdxValue$Dictionary b;
   private final PdxValue$Dictionary c;

   h$a(PdxValue$Dictionary var1) {
      boolean var2;
      label28: {
         super();
         this.b = var1;
         PdxValue var3 = var1.get("appserver_results");
         if(var3 != null && var3.getType() == 2) {
            this.c = (PdxValue$Dictionary)var3;
            PdxValue var4;
            if(var1 == null) {
               var4 = null;
            } else {
               var4 = this.c.get("final_response");
            }

            if(var4 != null && var4.getType() == 1 && ((PdxValue$Integer)var4).get() == 0) {
               var2 = false;
               break label28;
            }
         } else {
            this.c = null;
         }

         var2 = true;
      }

      this.a = var2;
   }

   public final PdxValue$Dictionary getAppserverResult() {
      return this.c;
   }

   public final PdxValue$Dictionary getFullResult() {
      return this.b;
   }

   public final boolean isFinalResult() {
      return this.a;
   }
}
