package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.rz;

public final class rn extends rz {
   public static final rn c = new rn();
   public static final rn d = new rn();

   public static rn s() {
      return c;
   }

   public static rn t() {
      return d;
   }

   public final double a(double var1) {
      return this == c?1.0D:0.0D;
   }

   public final void a(hf var1, jw var2) {
      boolean var3;
      if(this == c) {
         var3 = true;
      } else {
         var3 = false;
      }

      var1.a(var3);
   }

   public final boolean equals(Object var1) {
      return var1 == this;
   }

   public final boolean g() {
      return true;
   }

   public final boolean j() {
      return this == c;
   }

   public final String n() {
      return this == c?"true":"false";
   }
}
