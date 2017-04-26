package com.flurry.sdk;

import com.flurry.sdk.hb;
import com.flurry.sdk.hf;
import com.flurry.sdk.jw;
import com.flurry.sdk.rz;
import java.util.Arrays;

public final class rm extends rz {
   static final rm c = new rm(new byte[0]);
   final byte[] d;

   public rm(byte[] var1) {
      this.d = var1;
   }

   public static rm a(byte[] var0) {
      return var0 == null?null:(var0.length == 0?c:new rm(var0));
   }

   public final void a(hf var1, jw var2) {
      var1.a(this.d);
   }

   public final boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 == this) {
         var2 = true;
      } else {
         var2 = var3;
         if(var1 != null) {
            var2 = var3;
            if(var1.getClass() == this.getClass()) {
               return Arrays.equals(((rm)var1).d, this.d);
            }
         }
      }

      return var2;
   }

   public final int hashCode() {
      return this.d == null?-1:this.d.length;
   }

   public final String n() {
      return hb.a().a(this.d, false);
   }

   public final String toString() {
      return hb.a().a(this.d, true);
   }
}
