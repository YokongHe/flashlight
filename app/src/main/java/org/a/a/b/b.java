package org.a.a.b;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class b {
   protected final Map a = new EnumMap(org.a.a.g.e.class);
   protected final Map b = new HashMap();
   protected final Map c = new HashMap();
   protected org.a.a.g.i d = null;
   private org.a.a.a.a e;
   private final Map f = new HashMap();
   private final Set g = new HashSet();
   private final ArrayList h = new ArrayList();
   private final ArrayList i = new ArrayList();
   private org.a.a.f.e j;
   private boolean k = false;

   protected static List a(int var0) {
      return new ArrayList(var0);
   }

   protected static Object[] a(Class var0, int var1) {
      return (Object[])Array.newInstance(var0.getComponentType(), var1);
   }

   public final Object a(Class var1) {
      org.a.a.g.d var2 = this.e.a();
      if(var2 != null) {
         if(Object.class != var1) {
            var2.a(new org.a.a.g.i(var1));
         } else if(this.d != null) {
            var2.a(this.d);
         }

         Object var5 = this.a(var2);
         org.a.a.b.c var3;
         Iterator var6;
         if(!this.h.isEmpty()) {
            var6 = this.h.iterator();

            while(var6.hasNext()) {
               var3 = (org.a.a.b.c)var6.next();
               org.a.a.b.c var4 = (org.a.a.b.c)var3.a();
               ((Map)var3.b()).put(var4.b(), var4.a());
            }

            this.h.clear();
         }

         if(!this.i.isEmpty()) {
            var6 = this.i.iterator();

            while(var6.hasNext()) {
               var3 = (org.a.a.b.c)var6.next();
               ((Set)var3.b()).add(var3.a());
            }

            this.i.clear();
         }

         this.f.clear();
         this.g.clear();
         return var5;
      } else {
         return null;
      }
   }

   protected final Object a(org.a.a.g.d var1) {
      if(this.f.containsKey(var1)) {
         return this.f.get(var1);
      } else if(this.g.contains(var1)) {
         throw new org.a.a.b.j((String)null, (org.a.a.c.a)null, "found unconstructable recursive node", var1.f());
      } else {
         this.g.add(var1);
         org.a.a.b.d var2;
         if(var1.i()) {
            var2 = (org.a.a.b.d)this.a.get(var1.a());
         } else {
            org.a.a.b.d var3 = (org.a.a.b.d)this.b.get(var1.d());
            var2 = var3;
            if(var3 == null) {
               Iterator var4 = this.c.keySet().iterator();

               while(true) {
                  if(!var4.hasNext()) {
                     var2 = (org.a.a.b.d)this.b.get((Object)null);
                     break;
                  }

                  String var5 = (String)var4.next();
                  if(var1.d().a(var5)) {
                     var2 = (org.a.a.b.d)this.c.get(var5);
                     break;
                  }
               }
            }
         }

         Object var6 = var2.a(var1);
         this.f.put(var1, var6);
         this.g.remove(var1);
         if(var1.h()) {
            var2.a(var1, var6);
         }

         return var6;
      }
   }

   protected final Object a(org.a.a.g.h var1, Object var2) {
      Iterator var4 = var1.b().iterator();

      for(int var3 = 0; var4.hasNext(); ++var3) {
         Array.set(var2, var3, this.a((org.a.a.g.d)var4.next()));
      }

      return var2;
   }

   protected final List a(org.a.a.g.h var1) {
      List var2;
      if(List.class.isAssignableFrom(var1.g()) && !var1.g().isInterface()) {
         try {
            var2 = (List)var1.g().newInstance();
         } catch (Exception var3) {
            throw new org.a.a.c.c(var3);
         }
      } else {
         var2 = a(var1.b().size());
      }

      this.a((org.a.a.g.h)var1, (Collection)var2);
      return var2;
   }

   protected final Set a(org.a.a.g.c var1) {
      LinkedHashSet var2 = new LinkedHashSet();
      this.a((org.a.a.g.c)var1, (Set)var2);
      return var2;
   }

   public final org.a.a.f.e a() {
      if(this.j == null) {
         this.j = new org.a.a.f.e();
      }

      return this.j;
   }

   public final void a(org.a.a.a.a var1) {
      this.e = var1;
   }

   public final void a(org.a.a.f.e var1) {
      this.j = var1;
      this.k = true;
   }

   protected void a(org.a.a.g.c var1, Map var2) {
      Iterator var4 = var1.b().iterator();

      while(var4.hasNext()) {
         org.a.a.g.f var5 = (org.a.a.g.f)var4.next();
         org.a.a.g.d var6 = var5.a();
         org.a.a.g.d var7 = var5.b();
         Object var3 = this.a(var6);
         if(var3 != null) {
            try {
               var3.hashCode();
            } catch (Exception var8) {
               throw new org.a.a.b.j("while constructing a mapping", var1.f(), "found unacceptable key " + var3, var5.a().f(), var8);
            }
         }

         Object var9 = this.a(var7);
         if(var6.h()) {
            this.h.add(0, new org.a.a.b.c(var2, new org.a.a.b.c(var3, var9)));
         } else {
            var2.put(var3, var9);
         }
      }

   }

   protected void a(org.a.a.g.c var1, Set var2) {
      Iterator var5 = var1.b().iterator();

      while(var5.hasNext()) {
         org.a.a.g.f var3 = (org.a.a.g.f)var5.next();
         org.a.a.g.d var6 = var3.a();
         Object var4 = this.a(var6);
         if(var4 != null) {
            try {
               var4.hashCode();
            } catch (Exception var7) {
               throw new org.a.a.b.j("while constructing a Set", var1.f(), "found unacceptable key " + var4, var3.a().f(), var7);
            }
         }

         if(var6.h()) {
            this.i.add(0, new org.a.a.b.c(var2, var4));
         } else {
            var2.add(var4);
         }
      }

   }

   protected final void a(org.a.a.g.h var1, Collection var2) {
      Iterator var3 = var1.b().iterator();

      while(var3.hasNext()) {
         var2.add(this.a((org.a.a.g.d)var3.next()));
      }

   }

   protected final Map b(org.a.a.g.c var1) {
      LinkedHashMap var2 = new LinkedHashMap();
      this.a((org.a.a.g.c)var1, (Map)var2);
      return var2;
   }

   protected final Set b(org.a.a.g.h var1) {
      Object var2;
      if(!var1.g().isInterface()) {
         try {
            var2 = (Set)var1.g().newInstance();
         } catch (Exception var3) {
            throw new org.a.a.c.c(var3);
         }
      } else {
         var2 = new LinkedHashSet(var1.b().size());
      }

      this.a((org.a.a.g.h)var1, (Collection)var2);
      return (Set)var2;
   }

   public final boolean b() {
      return this.k;
   }

   protected final Object c(org.a.a.g.h var1) {
      return this.a((org.a.a.g.h)var1, (Object)a(var1.g(), var1.b().size()));
   }
}
