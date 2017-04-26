package com.flurry.sdk;

import java.lang.reflect.Array;

public class qz {
   public static Object a(final Object var0) {
      return new Object() {
         // $FF: synthetic field
         final int b;

         {
            this.b = var2;
         }

         public final boolean equals(Object var1) {
            boolean var4 = false;
            boolean var3;
            if(var1 == this) {
               var3 = true;
            } else {
               var3 = var4;
               if(var1 != null) {
                  var3 = var4;
                  if(var1.getClass() == var0.getClass()) {
                     var3 = var4;
                     if(Array.getLength(var1) == this.b) {
                        int var2 = 0;

                        while(true) {
                           if(var2 >= this.b) {
                              return true;
                           }

                           Object var5 = Array.get(var0, var2);
                           Object var6 = Array.get(var1, var2);
                           if(var5 != var6 && var5 != null) {
                              var3 = var4;
                              if(!var5.equals(var6)) {
                                 break;
                              }
                           }

                           ++var2;
                        }
                     }
                  }
               }
            }

            return var3;
         }
      };
   }
}
