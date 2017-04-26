package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.GenericResult;

final class i implements GenericResult {
   private String a;

   final .J a() {
      return new .J() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.i a = i.this;

         public final boolean a() {
            return false;
         }

         // $FF: synthetic method
         public final boolean a(Object var1) {
            .bb var2 = (.bb)var1;
            this.a.a = var2.f("status");
            return this.a.a != null;
         }
      };
   }

   public final String getQueryResult() {
      return this.a;
   }
}
