package org.a.a.b;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class f implements d {
   // $FF: synthetic field
   final e a;

   protected f(e var1) {
      this.a = var1;
   }

   private static Object a(org.a.a.g.c var0) {
      try {
         Constructor var2 = var0.g().getDeclaredConstructor(new Class[0]);
         var2.setAccessible(true);
         Object var3 = var2.newInstance(new Object[0]);
         return var3;
      } catch (Exception var1) {
         throw new org.a.a.c.c(var1);
      }
   }

   private Object a(org.a.a.g.c param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final Object a(org.a.a.g.d var1) {
      org.a.a.g.c var2 = (org.a.a.g.c)var1;
      if(Properties.class.isAssignableFrom(var1.g())) {
         Properties var6 = new Properties();
         if(!var1.h()) {
            this.a.a(var2, var6);
            return var6;
         } else {
            throw new org.a.a.c.c("Properties must not be recursive.");
         }
      } else if(SortedMap.class.isAssignableFrom(var1.g())) {
         TreeMap var3 = new TreeMap();
         if(!var1.h()) {
            this.a.a(var2, var3);
         }

         return var3;
      } else {
         e var4;
         if(Map.class.isAssignableFrom(var1.g())) {
            if(var1.h()) {
               var4 = this.a;
               return new LinkedHashMap();
            } else {
               return this.a.b(var2);
            }
         } else if(SortedSet.class.isAssignableFrom(var1.g())) {
            TreeSet var5 = new TreeSet();
            this.a.a(var2, var5);
            return var5;
         } else if(Collection.class.isAssignableFrom(var1.g())) {
            if(var1.h()) {
               var4 = this.a;
               return new LinkedHashSet();
            } else {
               return this.a.a(var2);
            }
         } else {
            return var1.h()?a(var2):this.a(var2, a(var2));
         }
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      if(Map.class.isAssignableFrom(var1.g())) {
         this.a.a((org.a.a.g.c)var1, (Map)var2);
      } else if(Set.class.isAssignableFrom(var1.g())) {
         this.a.a((org.a.a.g.c)var1, (Set)var2);
      } else {
         this.a((org.a.a.g.c)var1, var2);
      }
   }
}
