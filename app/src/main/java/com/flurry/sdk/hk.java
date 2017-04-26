package com.flurry.sdk;

import com.flurry.sdk.hg;
import java.io.IOException;

public class hk extends IOException {
   protected hg a;

   protected hk(String var1) {
      super(var1);
   }

   protected hk(String var1, hg var2) {
      this(var1, var2, (Throwable)null);
   }

   protected hk(String var1, hg var2, Throwable var3) {
      super(var1);
      if(var3 != null) {
         this.initCause(var3);
      }

      this.a = var2;
   }

   protected hk(String var1, Throwable var2) {
      this(var1, (hg)null, var2);
   }

   public hg a() {
      return this.a;
   }

   public String getMessage() {
      String var2 = super.getMessage();
      String var1 = var2;
      if(var2 == null) {
         var1 = "N/A";
      }

      hg var3 = this.a();
      var2 = var1;
      if(var3 != null) {
         StringBuilder var4 = new StringBuilder();
         var4.append(var1);
         var4.append('\n');
         var4.append(" at ");
         var4.append(var3.toString());
         var2 = var4.toString();
      }

      return var2;
   }

   public String toString() {
      return this.getClass().getName() + ": " + this.getMessage();
   }
}
