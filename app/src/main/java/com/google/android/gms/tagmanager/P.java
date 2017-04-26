package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

final class P {
   private static final Object a = null;
   private static Long b = new Long(0L);
   private static Double c = new Double(0.0D);
   private static com.google.android.gms.tagmanager.O d = com.google.android.gms.tagmanager.O.a(0L);
   private static String e = new String("");
   private static Boolean f = new Boolean(false);
   private static List g = new ArrayList(0);
   private static Map h = new HashMap();
   private static com.google.android.gms.internal.bj i;

   static {
      i = a((Object)e);
   }

   public static com.google.android.gms.internal.bj a() {
      return i;
   }

   public static com.google.android.gms.internal.bj a(Object var0) {
      boolean var2 = true;
      boolean var3 = false;
      com.google.android.gms.internal.bj var6 = new com.google.android.gms.internal.bj();
      if(var0 instanceof com.google.android.gms.internal.bj) {
         return (com.google.android.gms.internal.bj)var0;
      } else {
         if(var0 instanceof String) {
            var6.a = 1;
            var6.b = (String)var0;
         } else {
            ArrayList var11;
            if(var0 instanceof List) {
               var6.a = 2;
               List var14 = (List)var0;
               var11 = new ArrayList(var14.size());
               Iterator var15 = var14.iterator();

               com.google.android.gms.internal.bj var17;
               for(var3 = false; var15.hasNext(); var11.add(var17)) {
                  var17 = a(var15.next());
                  if(var17 == i) {
                     return i;
                  }

                  if(!var3 && !var17.l) {
                     var3 = false;
                  } else {
                     var3 = true;
                  }
               }

               var6.c = (com.google.android.gms.internal.bj[])var11.toArray(new com.google.android.gms.internal.bj[0]);
            } else if(!(var0 instanceof Map)) {
               boolean var1;
               if(!(var0 instanceof Double) && !(var0 instanceof Float) && (!(var0 instanceof com.google.android.gms.tagmanager.O) || !((com.google.android.gms.tagmanager.O)var0).a())) {
                  var1 = false;
               } else {
                  var1 = true;
               }

               if(var1) {
                  var6.a = 1;
                  var6.b = var0.toString();
               } else {
                  var1 = var2;
                  if(!(var0 instanceof Byte)) {
                     var1 = var2;
                     if(!(var0 instanceof Short)) {
                        var1 = var2;
                        if(!(var0 instanceof Integer)) {
                           var1 = var2;
                           if(!(var0 instanceof Long)) {
                              if(var0 instanceof com.google.android.gms.tagmanager.O && ((com.google.android.gms.tagmanager.O)var0).b()) {
                                 var1 = var2;
                              } else {
                                 var1 = false;
                              }
                           }
                        }
                     }
                  }

                  if(var1) {
                     var6.a = 6;
                     long var4;
                     if(var0 instanceof Number) {
                        var4 = ((Number)var0).longValue();
                     } else {
                        com.google.android.gms.tagmanager.n.a("getInt64 received non-Number");
                        var4 = 0L;
                     }

                     var6.h = var4;
                  } else {
                     if(!(var0 instanceof Boolean)) {
                        StringBuilder var13 = new StringBuilder("Converting to Value from unknown object type: ");
                        String var12;
                        if(var0 == null) {
                           var12 = "null";
                        } else {
                           var12 = var0.getClass().toString();
                        }

                        com.google.android.gms.tagmanager.n.a(var13.append(var12).toString());
                        return i;
                     }

                     var6.a = 8;
                     var6.i = ((Boolean)var0).booleanValue();
                  }
               }
            } else {
               var6.a = 3;
               Set var8 = ((Map)var0).entrySet();
               var11 = new ArrayList(var8.size());
               ArrayList var7 = new ArrayList(var8.size());
               Iterator var16 = var8.iterator();
               var3 = false;

               while(true) {
                  if(!var16.hasNext()) {
                     var6.d = (com.google.android.gms.internal.bj[])var11.toArray(new com.google.android.gms.internal.bj[0]);
                     var6.e = (com.google.android.gms.internal.bj[])var7.toArray(new com.google.android.gms.internal.bj[0]);
                     break;
                  }

                  Entry var10 = (Entry)var16.next();
                  com.google.android.gms.internal.bj var9 = a(var10.getKey());
                  com.google.android.gms.internal.bj var18 = a(var10.getValue());
                  if(var9 == i || var18 == i) {
                     return i;
                  }

                  if(!var3 && !var9.l && !var18.l) {
                     var3 = false;
                  } else {
                     var3 = true;
                  }

                  var11.add(var9);
                  var7.add(var18);
               }
            }
         }

         var6.l = var3;
         return var6;
      }
   }

   public static String a(com.google.android.gms.internal.bj var0) {
      return b(c(var0));
   }

   public static Boolean b(com.google.android.gms.internal.bj var0) {
      Object var1 = c(var0);
      if(var1 instanceof Boolean) {
         return (Boolean)var1;
      } else {
         String var2 = b(var1);
         return "true".equalsIgnoreCase(var2)?Boolean.TRUE:("false".equalsIgnoreCase(var2)?Boolean.FALSE:f);
      }
   }

   private static String b(Object var0) {
      return var0 == null?e:var0.toString();
   }

   public static Object c(com.google.android.gms.internal.bj var0) {
      byte var3 = 0;
      byte var2 = 0;
      int var1 = 0;
      if(var0 == null) {
         return a;
      } else {
         com.google.android.gms.internal.bj[] var7;
         Object var12;
         switch(var0.a) {
         case 1:
            return var0.b;
         case 2:
            ArrayList var11 = new ArrayList(var0.c.length);
            var7 = var0.c;

            for(int var8 = var7.length; var1 < var8; ++var1) {
               var12 = c(var7[var1]);
               if(var12 == a) {
                  return a;
               }

               var11.add(var12);
            }

            return var11;
         case 3:
            if(var0.d.length != var0.e.length) {
               com.google.android.gms.tagmanager.n.a("Converting an invalid value to object: " + var0.toString());
               return a;
            } else {
               HashMap var10 = new HashMap(var0.e.length);

               for(var1 = var3; var1 < var0.d.length; ++var1) {
                  var12 = c(var0.d[var1]);
                  Object var6 = c(var0.e[var1]);
                  if(var12 == a || var6 == a) {
                     return a;
                  }

                  var10.put(var12, var6);
               }

               return var10;
            }
         case 4:
            com.google.android.gms.tagmanager.n.a("Trying to convert a macro reference to object");
            return a;
         case 5:
            com.google.android.gms.tagmanager.n.a("Trying to convert a function id to object");
            return a;
         case 6:
            return Long.valueOf(var0.h);
         case 7:
            StringBuffer var4 = new StringBuffer();
            var7 = var0.j;
            int var9 = var7.length;

            for(var1 = var2; var1 < var9; ++var1) {
               String var5 = a(var7[var1]);
               if(var5 == e) {
                  return a;
               }

               var4.append(var5);
            }

            return var4.toString();
         case 8:
            return Boolean.valueOf(var0.i);
         default:
            com.google.android.gms.tagmanager.n.a("Failed to convert a value of type: " + var0.a);
            return a;
         }
      }
   }
}
