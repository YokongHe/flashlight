package com.flurry.sdk;

import com.flurry.sdk.ci$a;
import com.flurry.sdk.cq$a;
import com.flurry.sdk.cs$a;
import com.flurry.sdk.ct$a;
import com.flurry.sdk.ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ci {
   private int a;
   private List b;
   private boolean c;
   private boolean d;

   private ci() {
   }

   // $FF: synthetic method
   ci(Object var1) {
      this();
   }

   // $FF: synthetic method
   static int a(com.flurry.sdk.ci var0, int var1) {
      var0.a = var1;
      return var1;
   }

   public static com.flurry.sdk.ci a(com.flurry.sdk.ci var0, com.flurry.sdk.ci var1) {
      if(var0 != null && var1 != null) {
         List var2 = var0.a();
         List var9 = var1.a();
         if(var2 != null && !var2.isEmpty() && var9 != null && !var9.isEmpty()) {
            com.flurry.sdk.cq var12 = (com.flurry.sdk.cq)var2.get(0);
            com.flurry.sdk.cq var10 = (com.flurry.sdk.cq)var9.get(0);
            com.flurry.sdk.cs var4 = var12.c();
            com.flurry.sdk.cs var11 = var10.c();
            if(var4 != null && var11 != null) {
               if(!com.flurry.sdk.cl.c.equals(var4.a()) || !com.flurry.sdk.cl.b.equals(var11.a()) && !com.flurry.sdk.cl.c.equals(var11.a())) {
                  return null;
               } else {
                  List var6 = var4.g();
                  List var5 = var11.g();
                  if(var5 != null && !var5.isEmpty()) {
                     ArrayList var3 = new ArrayList(1);
                     if(var6 != null && !var6.isEmpty()) {
                        com.flurry.sdk.ct var21 = (com.flurry.sdk.ct)var6.get(0);
                        com.flurry.sdk.ct var19 = (com.flurry.sdk.ct)var5.get(0);
                        com.flurry.sdk.cu var22 = var21.d();
                        com.flurry.sdk.cu var7 = var19.d();
                        if(var22 == null || var7 == null) {
                           return null;
                        }

                        var22 = com.flurry.sdk.cu.a(var22, var7);
                        if(var22 == null) {
                           return null;
                        }

                        ct$a var24 = new ct$a();
                        var24.a(var19.a());
                        var24.a(var19.b());
                        var24.a(var19.c());
                        var24.a(var22);
                        var3.add(var24.a());
                     } else {
                        var3.addAll(var5);
                     }

                     cs$a var20 = new cs$a();
                     var20.a(com.flurry.sdk.cl.c);
                     var20.a(var11.b());
                     var20.a(var4.c());
                     ArrayList var23 = new ArrayList();
                     List var25 = var4.d();
                     if(var25 != null) {
                        var23.addAll(var25);
                     }

                     var25 = var11.d();
                     if(var25 != null) {
                        Iterator var8 = var25.iterator();

                        while(var8.hasNext()) {
                           if(var23.contains((String)var8.next())) {
                              return null;
                           }
                        }

                        var23.addAll(var25);
                     }

                     var20.a((List)var23);
                     var23 = new ArrayList();
                     var25 = var4.e();
                     if(var25 != null) {
                        var23.addAll(var25);
                     }

                     var25 = var11.e();
                     if(var25 != null) {
                        var23.addAll(var25);
                     }

                     var20.b(var23);
                     var23 = new ArrayList();
                     List var17 = var4.f();
                     if(var17 != null) {
                        var23.addAll(var17);
                     }

                     var17 = var11.f();
                     if(var17 != null) {
                        var23.addAll(var17);
                     }

                     var20.c(var23);
                     var20.d(var3);
                     com.flurry.sdk.cs var14 = var20.a();
                     cq$a var18 = new cq$a();
                     var18.a(var12.a());
                     var18.a(var12.b());
                     var18.a(var14);
                     com.flurry.sdk.cq var15 = var18.a();
                     ArrayList var13 = new ArrayList(1);
                     var13.add(var15);
                     ci$a var16 = new ci$a();
                     var16.a(var13);
                     var16.a(var0.b());
                     var16.a(com.flurry.sdk.cl.b.equals(var11.a()));
                     return var16.b();
                  } else {
                     return null;
                  }
               }
            } else {
               return null;
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static List a(com.flurry.sdk.ci var0, List var1) {
      var0.b = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean a(com.flurry.sdk.ci var0, boolean var1) {
      var0.c = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean b(com.flurry.sdk.ci var0, boolean var1) {
      var0.d = var1;
      return var1;
   }

   public String a(com.flurry.sdk.cp var1) {
      List var2 = this.a();
      if(var2 != null && !var2.isEmpty()) {
         com.flurry.sdk.cs var3 = ((com.flurry.sdk.cq)var2.get(0)).c();
         if(var3 != null) {
            var2 = var3.g();
            if(var2 != null && !var2.isEmpty()) {
               com.flurry.sdk.cu var4 = ((com.flurry.sdk.ct)var2.get(0)).d();
               if(var4 != null) {
                  Map var5 = var4.d();
                  if(var5 != null) {
                     return (String)var5.get(var1);
                  }
               }
            }
         }
      }

      return null;
   }

   public List a() {
      return this.b;
   }

   public List a(com.flurry.sdk.co var1) {
      List var2 = this.a();
      if(var2 != null && !var2.isEmpty()) {
         com.flurry.sdk.cs var3 = ((com.flurry.sdk.cq)var2.get(0)).c();
         if(var3 != null) {
            var2 = var3.g();
            if(var2 != null && !var2.isEmpty()) {
               com.flurry.sdk.cu var4 = ((com.flurry.sdk.ct)var2.get(0)).d();
               if(var4 != null) {
                  ds var5 = var4.c();
                  if(var5 != null) {
                     return var5.a((Object)var1);
                  }
               }
            }
         }
      }

      return null;
   }

   public int b() {
      return this.a;
   }

   public boolean c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public String e() {
      List var1 = this.a();
      if(var1 != null && !var1.isEmpty()) {
         com.flurry.sdk.cs var2 = ((com.flurry.sdk.cq)var1.get(0)).c();
         if(var2 != null) {
            var1 = var2.d();
            if(var1 != null && !var1.isEmpty()) {
               return (String)var1.get(var1.size() - 1);
            }
         }
      }

      return null;
   }

   public String f() {
      List var1 = this.a();
      if(var1 != null && !var1.isEmpty()) {
         com.flurry.sdk.cs var2 = ((com.flurry.sdk.cq)var1.get(0)).c();
         if(var2 != null) {
            var1 = var2.g();
            if(var1 != null && !var1.isEmpty()) {
               com.flurry.sdk.cu var3 = ((com.flurry.sdk.ct)var1.get(0)).d();
               if(var3 != null) {
                  com.flurry.sdk.cv var4 = var3.e();
                  if(var4 != null && var4.a() != null) {
                     return var4.a();
                  }
               }
            }
         }
      }

      return null;
   }

   public List g() {
      List var1 = this.a();
      if(var1 != null && !var1.isEmpty()) {
         com.flurry.sdk.cs var2 = ((com.flurry.sdk.cq)var1.get(0)).c();
         if(var2 != null) {
            return var2.f();
         }
      }

      return null;
   }

   public List h() {
      List var1 = this.a();
      if(var1 != null && !var1.isEmpty()) {
         com.flurry.sdk.cs var2 = ((com.flurry.sdk.cq)var1.get(0)).c();
         if(var2 != null) {
            return var2.e();
         }
      }

      return null;
   }
}
