package com.millennialmedia.a.a.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public final class f {
   private final Map a;

   public f(Map var1) {
      this.a = var1;
   }

   private com.millennialmedia.a.a.b.q a(Class var1) {
      try {
         final Constructor var3 = var1.getDeclaredConstructor(new Class[0]);
         if(!var3.isAccessible()) {
            var3.setAccessible(true);
         }

         com.millennialmedia.a.a.b.q var4 = new com.millennialmedia.a.a.b.q() {
            public final Object a() {
               try {
                  Object var1 = var3.newInstance((Object[])null);
                  return var1;
               } catch (InstantiationException var2) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var2);
               } catch (InvocationTargetException var3x) {
                  throw new RuntimeException("Failed to invoke " + var3 + " with no args", var3x.getTargetException());
               } catch (IllegalAccessException var4) {
                  throw new AssertionError(var4);
               }
            }
         };
         return var4;
      } catch (NoSuchMethodException var2) {
         return null;
      }
   }

   public final com.millennialmedia.a.a.b.q a(com.millennialmedia.a.a.c.a var1) {
      final Type var3 = var1.b();
      final Class var4 = var1.a();
      final com.millennialmedia.a.a.g var5 = (com.millennialmedia.a.a.g)this.a.get(var3);
      com.millennialmedia.a.a.b.q var2;
      if(var5 != null) {
         var2 = new com.millennialmedia.a.a.b.q() {
            public final Object a() {
               com.millennialmedia.a.a.g var1 = var5;
               Type var2 = var3;
               return var1.a();
            }
         };
      } else {
         var5 = (com.millennialmedia.a.a.g)this.a.get(var4);
         if(var5 != null) {
            return new com.millennialmedia.a.a.b.q() {
               public final Object a() {
                  com.millennialmedia.a.a.g var1 = var5;
                  Type var2 = var3;
                  return var1.a();
               }
            };
         }

         com.millennialmedia.a.a.b.q var6 = this.a(var4);
         var2 = var6;
         if(var6 == null) {
            if(Collection.class.isAssignableFrom(var4)) {
               if(SortedSet.class.isAssignableFrom(var4)) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new TreeSet();
                     }
                  };
               } else if(EnumSet.class.isAssignableFrom(var4)) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        if(var3 instanceof ParameterizedType) {
                           Type var1 = ((ParameterizedType)var3).getActualTypeArguments()[0];
                           if(var1 instanceof Class) {
                              return EnumSet.noneOf((Class)var1);
                           } else {
                              throw new com.millennialmedia.a.a.k("Invalid EnumSet type: " + var3.toString());
                           }
                        } else {
                           throw new com.millennialmedia.a.a.k("Invalid EnumSet type: " + var3.toString());
                        }
                     }
                  };
               } else if(Set.class.isAssignableFrom(var4)) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new LinkedHashSet();
                     }
                  };
               } else if(Queue.class.isAssignableFrom(var4)) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new LinkedList();
                     }
                  };
               } else {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new ArrayList();
                     }
                  };
               }
            } else if(Map.class.isAssignableFrom(var4)) {
               if(SortedMap.class.isAssignableFrom(var4)) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new TreeMap();
                     }
                  };
               } else if(var3 instanceof ParameterizedType && !String.class.isAssignableFrom(com.millennialmedia.a.a.c.a.a(((ParameterizedType)var3).getActualTypeArguments()[0]).a())) {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new LinkedHashMap();
                     }
                  };
               } else {
                  var6 = new com.millennialmedia.a.a.b.q() {
                     public final Object a() {
                        return new com.millennialmedia.a.a.b.j();
                     }
                  };
               }
            } else {
               var6 = null;
            }

            var2 = var6;
            if(var6 == null) {
               return new com.millennialmedia.a.a.b.q() {
                  private final com.millennialmedia.a.a.b.v d = com.millennialmedia.a.a.b.v.a();

                  public final Object a() {
                     try {
                        Object var1 = this.d.a(var4);
                        return var1;
                     } catch (Exception var2) {
                        throw new RuntimeException("Unable to invoke no-args constructor for " + var3 + ". Register an InstanceCreator with Gson for this type may fix this problem.", var2);
                     }
                  }
               };
            }
         }
      }

      return var2;
   }

   public final String toString() {
      return this.a.toString();
   }
}
