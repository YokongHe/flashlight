package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.DataUploadResult;
import com.nuance.nmdp.speechkit.DataUploadResult$DataResult;
import com.nuance.nmdp.speechkit.g$a;

final class g implements DataUploadResult {
   private g$a[] a = null;
   private boolean b = false;

   // $FF: synthetic method
   static boolean a(com.nuance.nmdp.speechkit.g var0, boolean var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static g$a[] a(com.nuance.nmdp.speechkit.g var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static g$a[] a(com.nuance.nmdp.speechkit.g var0, g$a[] var1) {
      var0.a = var1;
      return var1;
   }

   final .J a() {
      return new .J() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.g a = g.this;

         private boolean a(.bb param1) {
            // $FF: Couldn't be decompiled
         }

         public final boolean a() {
            return false;
         }
      };
   }

   public final DataUploadResult$DataResult getDataResult(int var1) {
      return var1 >= 0 && var1 < this.a.length?this.a[var1]:null;
   }

   public final int getDataResultCount() {
      return this.a.length;
   }

   public final boolean isVocRegenerated() {
      return this.b;
   }
}
