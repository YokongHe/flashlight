package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public final class j implements com.millennialmedia.a.a.t {
   private final com.millennialmedia.a.a.b.f a;
   private final com.millennialmedia.a.a.d b;
   private final com.millennialmedia.a.a.b.g c;

   public j(com.millennialmedia.a.a.b.f var1, com.millennialmedia.a.a.d var2, com.millennialmedia.a.a.b.g var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   private Map a(final com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2, Class var3) {
      LinkedHashMap var9 = new LinkedHashMap();
      if(var3.isInterface()) {
         return var9;
      } else {
         for(Type var10 = var2.b(); var3 != Object.class; var3 = var2.a()) {
            Field[] var11 = var3.getDeclaredFields();
            int var5 = var11.length;

            for(int var4 = 0; var4 < var5; ++var4) {
               final Field var12 = var11[var4];
               final boolean var6 = this.a(var12, true);
               final boolean var7 = this.a(var12, false);
               if(var6 || var7) {
                  var12.setAccessible(true);
                  Type var13 = com.millennialmedia.a.a.b.b.a(var2.b(), var3, var12.getGenericType());
                  com.millennialmedia.a.a.a.b var8 = (com.millennialmedia.a.a.a.b)var12.getAnnotation(com.millennialmedia.a.a.a.b.class);
                  final String var14;
                  if(var8 == null) {
                     var14 = this.b.a(var12);
                  } else {
                     var14 = var8.a();
                  }

                  final com.millennialmedia.a.a.c.a var16 = com.millennialmedia.a.a.c.a.a(var13);
                  com.millennialmedia.a.a.b.a.l var15 = new com.millennialmedia.a.a.b.a.l(var14, var6, var7) {
                     final com.millennialmedia.a.a.s a;
                     // $FF: synthetic field
                     final boolean e;

                     {
                        this.e = var8;
                        this.a = var1.a(var16);
                     }

                     final void a(com.millennialmedia.a.a.d.a var1x, Object var2) {
                        Object var3 = this.a.a(var1x);
                        if(var3 != null || !this.e) {
                           var12.set(var2, var3);
                        }

                     }

                     final void a(com.millennialmedia.a.a.d.c var1x, Object var2) {
                        var2 = var12.get(var2);
                        (new com.millennialmedia.a.a.b.a.o(var1, this.a, var16.b())).a(var1x, var2);
                     }
                  };
                  var15 = (com.millennialmedia.a.a.b.a.l)var9.put(var15.g, var15);
                  if(var15 != null) {
                     throw new IllegalArgumentException(var10 + " declares multiple JSON fields named " + var15.g);
                  }
               }
            }

            var2 = com.millennialmedia.a.a.c.a.a(com.millennialmedia.a.a.b.b.a(var2.b(), var3, var3.getGenericSuperclass()));
         }

         return var9;
      }
   }

   private boolean a(Field var1, boolean var2) {
      return !this.c.a(var1.getType(), var2) && !this.c.a(var1, var2);
   }

   public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
      Class var3 = var2.a();
      return !Object.class.isAssignableFrom(var3)?null:new com.millennialmedia.a.a.b.a.k(this.a.a(var2), this.a(var1, var2, var3), (byte)0);
   }
}
