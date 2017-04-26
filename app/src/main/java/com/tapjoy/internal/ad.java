package com.tapjoy.internal;

import android.util.Log;
import com.tapjoy.internal.hk;
import com.tapjoy.internal.hl;
import java.util.HashMap;

public final class ad {
   public static void a(int var0, String var1, String var2, Throwable var3) {
      if(var2 != null) {
         Log.println(var0, var1, var2);
      }

      if(var3 != null) {
         Log.println(var0, var1, Log.getStackTraceString(var3));
      }

   }

   public static void a(int var0, String var1, String var2, Object... var3) {
      Throwable var8;
      if(var3 != null && var3.length != 0) {
         Object var11 = var3[var3.length - 1];
         if(var11 instanceof Throwable) {
            var8 = (Throwable)var11;
         } else {
            var8 = null;
         }
      } else {
         var8 = null;
      }

      hk var10;
      if(var2 == null) {
         var10 = new hk((String)null, var3, var8);
      } else if(var3 == null) {
         var10 = new hk(var2);
      } else {
         StringBuffer var9 = new StringBuffer(var2.length() + 50);
         int var5 = 0;
         int var4 = 0;

         while(true) {
            if(var5 >= var3.length) {
               var9.append(var2.substring(var4, var2.length()));
               if(var5 < var3.length - 1) {
                  var10 = new hk(var9.toString(), var3, var8);
               } else {
                  var10 = new hk(var9.toString(), var3, (Throwable)null);
               }
               break;
            }

            int var7 = var2.indexOf("{}", var4);
            if(var7 == -1) {
               if(var4 == 0) {
                  var10 = new hk(var2, var3, var8);
               } else {
                  var9.append(var2.substring(var4, var2.length()));
                  var10 = new hk(var9.toString(), var3, var8);
               }
               break;
            }

            boolean var6;
            if(var7 != 0 && var2.charAt(var7 - 1) == 92) {
               var6 = true;
            } else {
               var6 = false;
            }

            if(!var6) {
               var9.append(var2.substring(var4, var7));
               hl.a(var9, (Object)var3[var5], new HashMap());
               var4 = var7 + 2;
            } else {
               if(var7 >= 2 && var2.charAt(var7 - 2) == 92) {
                  var6 = true;
               } else {
                  var6 = false;
               }

               if(!var6) {
                  --var5;
                  var9.append(var2.substring(var4, var7 - 1));
                  var9.append('{');
                  var4 = var7 + 1;
               } else {
                  var9.append(var2.substring(var4, var7 - 1));
                  hl.a(var9, (Object)var3[var5], new HashMap());
                  var4 = var7 + 2;
               }
            }

            ++var5;
         }
      }

      a(var0, var1, var10.a(), var10.b());
   }

   public static void a(String var0, String var1, Object... var2) {
      a(6, var0, var1, (Object[])var2);
   }
}
