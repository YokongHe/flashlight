package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.du;
import java.util.Arrays;
import java.util.Stack;

final class du$a {
   final Stack a;

   private du$a() {
      this.a = new Stack();
   }

   // $FF: synthetic method
   du$a(byte var1) {
      this();
   }

   private static int a(int var0) {
      int var1 = Arrays.binarySearch(du.b(), var0);
      var0 = var1;
      if(var1 < 0) {
         var0 = -(var1 + 1) - 1;
      }

      return var0;
   }

   final void a(dh var1) {
      while(true) {
         du var5;
         if(!var1.j()) {
            if(var1 instanceof du) {
               var5 = (du)var1;
               this.a(du.a(var5));
               var1 = du.b(var5);
               continue;
            }

            String var6 = String.valueOf(String.valueOf(var1.getClass()));
            throw new IllegalArgumentException((new StringBuilder(var6.length() + 49)).append("Has a new type of ByteString been created? Found ").append(var6).toString());
         }

         int var2 = a(var1.a());
         int var3 = du.b()[var2 + 1];
         if(!this.a.isEmpty() && ((dh)this.a.peek()).a() < var3) {
            var2 = du.b()[var2];

            Object var4;
            for(var4 = (dh)this.a.pop(); !this.a.isEmpty() && ((dh)this.a.peek()).a() < var2; var4 = new du((dh)this.a.pop(), (dh)var4, (byte)0)) {
               ;
            }

            for(var5 = new du((dh)var4, var1, (byte)0); !this.a.isEmpty(); var5 = new du((dh)this.a.pop(), var5, (byte)0)) {
               var2 = a(var5.a());
               var2 = du.b()[var2 + 1];
               if(((dh)this.a.peek()).a() >= var2) {
                  break;
               }
            }

            this.a.push(var5);
            return;
         }

         this.a.push(var1);
         return;
      }
   }
}
