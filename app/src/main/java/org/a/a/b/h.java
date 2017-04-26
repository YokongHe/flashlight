package org.a.a.b;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class h implements d {
   // $FF: synthetic field
   final e a;

   protected h(e var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      byte var3 = 0;
      org.a.a.g.h var6 = (org.a.a.g.h)var1;
      if(Set.class.isAssignableFrom(var1.g())) {
         if(var1.h()) {
            throw new org.a.a.c.c("Set cannot be recursive.");
         } else {
            return this.a.b(var6);
         }
      } else if(Collection.class.isAssignableFrom(var1.g())) {
         if(var1.h()) {
            e var16 = this.a;
            return e.a(var6.b().size());
         } else {
            return this.a.a(var6);
         }
      } else if(var1.g().isArray()) {
         if(var1.h()) {
            e var24 = this.a;
            return e.a(var1.g(), var6.b().size());
         } else {
            return this.a.c(var6);
         }
      } else {
         ArrayList var5 = new ArrayList(var6.b().size());
         Constructor[] var7 = var1.g().getConstructors();
         int var4 = var7.length;

         int var2;
         for(var2 = 0; var2 < var4; ++var2) {
            Constructor var8 = var7[var2];
            if(var6.b().size() == var8.getParameterTypes().length) {
               var5.add(var8);
            }
         }

         if(!var5.isEmpty()) {
            Object var14;
            if(var5.size() == 1) {
               Object[] var15 = new Object[var6.b().size()];
               Constructor var23 = (Constructor)var5.get(0);
               Iterator var19 = var6.b().iterator();

               for(var2 = var3; var19.hasNext(); ++var2) {
                  org.a.a.g.d var21 = (org.a.a.g.d)var19.next();
                  var21.b(var23.getParameterTypes()[var2]);
                  var15[var2] = this.a.a(var21);
               }

               try {
                  var14 = var23.newInstance(var15);
                  return var14;
               } catch (Exception var12) {
                  throw new org.a.a.c.c(var12);
               }
            }

            List var20 = this.a.a(var6);
            Class[] var22 = new Class[var20.size()];
            Iterator var9 = var20.iterator();

            for(var2 = 0; var9.hasNext(); ++var2) {
               var22[var2] = var9.next().getClass();
            }

            var9 = var5.iterator();

            while(var9.hasNext()) {
               Constructor var10 = (Constructor)var9.next();
               Class[] var11 = var10.getParameterTypes();

               boolean var17;
               label112: {
                  for(var2 = 0; var2 < var11.length; ++var2) {
                     Class var18 = var11[var2];
                     if(var18.isPrimitive()) {
                        if(var18 == Integer.TYPE) {
                           var18 = Integer.class;
                        } else if(var18 == Float.TYPE) {
                           var18 = Float.class;
                        } else if(var18 == Double.TYPE) {
                           var18 = Double.class;
                        } else if(var18 == Boolean.TYPE) {
                           var18 = Boolean.class;
                        } else if(var18 == Long.TYPE) {
                           var18 = Long.class;
                        } else if(var18 == Character.TYPE) {
                           var18 = Character.class;
                        } else if(var18 == Short.TYPE) {
                           var18 = Short.class;
                        } else {
                           if(var18 != Byte.TYPE) {
                              throw new org.a.a.c.c("Unexpected primitive " + var18);
                           }

                           var18 = Byte.class;
                        }
                     }

                     if(!var18.isAssignableFrom(var22[var2])) {
                        var17 = false;
                        break label112;
                     }
                  }

                  var17 = true;
               }

               if(var17) {
                  try {
                     var14 = var10.newInstance(var20.toArray());
                     return var14;
                  } catch (Exception var13) {
                     throw new org.a.a.c.c(var13);
                  }
               }
            }
         }

         throw new org.a.a.c.c("No suitable constructor with " + String.valueOf(var6.b().size()) + " arguments found for " + var1.g());
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      org.a.a.g.h var3 = (org.a.a.g.h)var1;
      if(List.class.isAssignableFrom(var1.g())) {
         List var4 = (List)var2;
         this.a.a(var3, var4);
      } else if(var1.g().isArray()) {
         this.a.a(var3, var2);
      } else {
         throw new org.a.a.c.c("Immutable objects cannot be recursive.");
      }
   }
}
