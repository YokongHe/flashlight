package org.a.a.f;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public final class e {
   private final Map a = new HashMap();
   private final Map b = new HashMap();
   private org.a.a.f.a c;
   private boolean d;

   public e() {
      this.c = org.a.a.f.a.a;
      this.d = false;
   }

   public final org.a.a.f.d a(Class var1, String var2) {
      org.a.a.f.a var6 = this.c;
      Object var10;
      if(this.a.containsKey(var1)) {
         var10 = (Map)this.a.get(var1);
      } else {
         LinkedHashMap var7 = new LinkedHashMap();

         for(Class var11 = var1; var11 != null; var11 = var11.getSuperclass()) {
            Field[] var8 = var11.getDeclaredFields();
            int var4 = var8.length;

            for(int var3 = 0; var3 < var4; ++var3) {
               Field var9 = var8[var3];
               int var5 = var9.getModifiers();
               if(!Modifier.isStatic(var5) && !Modifier.isTransient(var5) && !var7.containsKey(var9.getName())) {
                  var7.put(var9.getName(), new b(var9));
               }
            }
         }

         this.a.put(var1, var7);
         var10 = var7;
      }

      org.a.a.f.d var12 = (org.a.a.f.d)((Map)var10).get(var2);
      if(var12 != null) {
         org.a.a.f.d.c();
         return var12;
      } else {
         throw new org.a.a.c.c("Unable to find property \'" + var2 + "\' on class: " + var1.getName());
      }
   }

   public final void a(boolean var1) {
      if(this.d != var1) {
         this.d = var1;
         this.b.clear();
      }

   }
}
