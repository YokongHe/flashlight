package com.nuance.nmdp.speechkit;

import com.nuance.nmdp.speechkit.Recognition;
import com.nuance.nmdp.speechkit.Recognition$Result;
import com.nuance.nmdp.speechkit.o$a;
import java.util.List;

final class o implements Recognition {
   private String[] a = null;
   private int[] b = null;
   private String c = null;
   private List d;

   // $FF: synthetic method
   static String a(com.nuance.nmdp.speechkit.o var0, String var1) {
      var0.c = var1;
      return var1;
   }

   // $FF: synthetic method
   static List a(com.nuance.nmdp.speechkit.o var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static List a(com.nuance.nmdp.speechkit.o var0, List var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static int[] a(com.nuance.nmdp.speechkit.o var0, int[] var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static String[] a(com.nuance.nmdp.speechkit.o var0, String[] var1) {
      var0.a = var1;
      return var1;
   }

   final .J a() {
      return new .J() {
         // $FF: synthetic field
         private com.nuance.nmdp.speechkit.o a = o.this;

         private boolean a(.bb param1) {
            // $FF: Couldn't be decompiled
         }

         public final boolean a() {
            return false;
         }
      };
   }

   public final List getDetailedResults() {
      return this.d;
   }

   public final Recognition$Result getResult(int var1) {
      if(var1 >= 0 && var1 < this.b.length) {
         return new o$a(this.a[var1], this.b[var1]);
      } else {
         throw new IndexOutOfBoundsException("index must be >= 0 and < getResultCount().");
      }
   }

   public final int getResultCount() {
      return this.b.length;
   }

   public final String getSuggestion() {
      return this.c;
   }
}
