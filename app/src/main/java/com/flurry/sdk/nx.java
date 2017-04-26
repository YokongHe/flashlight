package com.flurry.sdk;

import com.flurry.sdk.jn;
import com.flurry.sdk.nf;
import com.flurry.sdk.nw;
import com.flurry.sdk.sh;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class nx extends nw {
   protected final jn a;
   protected final HashMap b;
   protected final HashMap e;

   protected nx(jn var1, sh var2, HashMap var3, HashMap var4) {
      super(var2, var1.m());
      this.a = var1;
      this.b = var3;
      this.e = var4;
   }

   public static nx a(jn var0, sh var1, Collection var2, boolean var3, boolean var4) {
      if(var3 == var4) {
         throw new IllegalArgumentException();
      } else {
         HashMap var5;
         if(var3) {
            var5 = new HashMap();
         } else {
            var5 = null;
         }

         HashMap var6;
         if(var4) {
            var6 = new HashMap();
         } else {
            var6 = null;
         }

         if(var2 != null) {
            Iterator var7 = var2.iterator();

            while(true) {
               Class var8;
               sh var9;
               String var11;
               do {
                  do {
                     if(!var7.hasNext()) {
                        return new nx(var0, var1, var5, var6);
                     }

                     nf var10 = (nf)var7.next();
                     var8 = var10.a();
                     if(var10.c()) {
                        var11 = var10.b();
                     } else {
                        var11 = a(var8);
                     }

                     if(var3) {
                        var5.put(var8.getName(), var11);
                     }
                  } while(!var4);

                  var9 = (sh)var6.get(var11);
               } while(var9 != null && var8.isAssignableFrom(var9.p()));

               var6.put(var11, var0.b(var8));
            }
         } else {
            return new nx(var0, var1, var5, var6);
         }
      }
   }

   protected static String a(Class var0) {
      String var2 = var0.getName();
      int var1 = var2.lastIndexOf(46);
      return var1 < 0?var2:var2.substring(var1 + 1);
   }

   public sh a(String var1) {
      return (sh)this.e.get(var1);
   }

   public String a(Object param1) {
      // $FF: Couldn't be decompiled
   }

   public String a(Object var1, Class var2) {
      return this.a(var1);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('[').append(this.getClass().getName());
      var1.append("; id-to-type=").append(this.e);
      var1.append(']');
      return var1.toString();
   }
}
