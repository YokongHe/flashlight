package com.millennialmedia.a.a;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e {
   final com.millennialmedia.a.a.i a;
   final com.millennialmedia.a.a.p b;
   private final ThreadLocal c;
   private final Map d;
   private final List e;
   private final com.millennialmedia.a.a.b.f f;
   private final boolean g;
   private final boolean h;
   private final boolean i;
   private final boolean j;

   public e() {
      this(com.millennialmedia.a.a.b.g.a, com.millennialmedia.a.a.c.a, Collections.emptyMap(), false, false, false, true, false, false, com.millennialmedia.a.a.r.a, Collections.emptyList());
   }

   private e(com.millennialmedia.a.a.b.g var1, com.millennialmedia.a.a.d var2, Map var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9, com.millennialmedia.a.a.r var10, List var11) {
      this.c = new ThreadLocal();
      this.d = Collections.synchronizedMap(new HashMap());
      this.a = new com.millennialmedia.a.a.i() {
      };
      this.b = new com.millennialmedia.a.a.p() {
      };
      this.f = new b.f(var3);
      this.g = false;
      this.i = false;
      this.h = true;
      this.j = false;
      ArrayList var12 = new ArrayList();
      var12.add(com.millennialmedia.a.a.b.a.p.Q);
      var12.add(com.millennialmedia.a.a.b.a.i.a);
      var12.add(var1);
      var12.addAll(var11);
      var12.add(com.millennialmedia.a.a.b.a.p.x);
      var12.add(com.millennialmedia.a.a.b.a.p.m);
      var12.add(com.millennialmedia.a.a.b.a.p.g);
      var12.add(com.millennialmedia.a.a.b.a.p.i);
      var12.add(com.millennialmedia.a.a.b.a.p.k);
      Class var13 = Long.TYPE;
      com.millennialmedia.a.a.s var14;
      if(var10 == com.millennialmedia.a.a.r.a) {
         var14 = com.millennialmedia.a.a.b.a.p.n;
      } else {
         var14 = new com.millennialmedia.a.a.s() {
            // $FF: synthetic method
            public final Object a(com.millennialmedia.a.a.d.a var1) {
               if(var1.f() == com.millennialmedia.a.a.d.b.i) {
                  var1.j();
                  return null;
               } else {
                  return Long.valueOf(var1.l());
               }
            }

            // $FF: synthetic method
            public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
               Number var3 = (Number)var2;
               if(var3 == null) {
                  var1.f();
               } else {
                  var1.b(var3.toString());
               }
            }
         };
      }

      var12.add(com.millennialmedia.a.a.b.a.p.a(var13, Long.class, var14));
      var12.add(com.millennialmedia.a.a.b.a.p.a(Double.TYPE, Double.class, new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return Double.valueOf(var1.k());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Number var5 = (Number)var2;
            if(var5 == null) {
               var1.f();
            } else {
               double var3 = var5.doubleValue();
               com.millennialmedia.a.a.e.a(e.this, var3);
               var1.a(var5);
            }
         }
      }));
      var12.add(com.millennialmedia.a.a.b.a.p.a(Float.TYPE, Float.class, new com.millennialmedia.a.a.s() {
         // $FF: synthetic method
         public final Object a(com.millennialmedia.a.a.d.a var1) {
            if(var1.f() == com.millennialmedia.a.a.d.b.i) {
               var1.j();
               return null;
            } else {
               return Float.valueOf((float)var1.k());
            }
         }

         // $FF: synthetic method
         public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
            Number var4 = (Number)var2;
            if(var4 == null) {
               var1.f();
            } else {
               float var3 = var4.floatValue();
               com.millennialmedia.a.a.e.a(e.this, (double)var3);
               var1.a(var4);
            }
         }
      }));
      var12.add(com.millennialmedia.a.a.b.a.p.r);
      var12.add(com.millennialmedia.a.a.b.a.p.t);
      var12.add(com.millennialmedia.a.a.b.a.p.z);
      var12.add(com.millennialmedia.a.a.b.a.p.B);
      var12.add(com.millennialmedia.a.a.b.a.p.a(BigDecimal.class, com.millennialmedia.a.a.b.a.p.v));
      var12.add(com.millennialmedia.a.a.b.a.p.a(BigInteger.class, com.millennialmedia.a.a.b.a.p.w));
      var12.add(com.millennialmedia.a.a.b.a.p.D);
      var12.add(com.millennialmedia.a.a.b.a.p.F);
      var12.add(com.millennialmedia.a.a.b.a.p.J);
      var12.add(com.millennialmedia.a.a.b.a.p.O);
      var12.add(com.millennialmedia.a.a.b.a.p.H);
      var12.add(com.millennialmedia.a.a.b.a.p.d);
      var12.add(com.millennialmedia.a.a.b.a.d.a);
      var12.add(com.millennialmedia.a.a.b.a.p.M);
      var12.add(com.millennialmedia.a.a.b.a.n.a);
      var12.add(com.millennialmedia.a.a.b.a.m.a);
      var12.add(com.millennialmedia.a.a.b.a.p.K);
      var12.add(com.millennialmedia.a.a.b.a.a.a);
      var12.add(com.millennialmedia.a.a.b.a.p.R);
      var12.add(com.millennialmedia.a.a.b.a.p.b);
      var12.add(new com.millennialmedia.a.a.b.a.b(this.f));
      var12.add(new com.millennialmedia.a.a.b.a.g(this.f, false));
      var12.add(new com.millennialmedia.a.a.b.a.j(this.f, var2, var1));
      this.e = Collections.unmodifiableList(var12);
   }

   private com.millennialmedia.a.a.d.c a(Writer var1) {
      if(this.i) {
         var1.write(")]}\'\n");
      }

      com.millennialmedia.a.a.d.c var2 = new d.c(var1);
      if(this.j) {
         var2.c("  ");
      }

      var2.d(this.g);
      return var2;
   }

   private Object a(com.millennialmedia.a.a.d.a param1, Type param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void a(com.millennialmedia.a.a.e var0, double var1) {
      if(Double.isNaN(var1) || Double.isInfinite(var1)) {
         throw new IllegalArgumentException(var1 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
      }
   }

   private void a(com.millennialmedia.a.a.j param1, Appendable param2) {
      // $FF: Couldn't be decompiled
   }

   private static void a(Object var0, com.millennialmedia.a.a.d.a var1) {
      if(var0 != null) {
         try {
            if(var1.f() != com.millennialmedia.a.a.d.b.j) {
               throw new com.millennialmedia.a.a.k("JSON document was not fully consumed.");
            }
         } catch (com.millennialmedia.a.a.d.d var2) {
            throw new com.millennialmedia.a.a.q(var2);
         } catch (IOException var3) {
            throw new com.millennialmedia.a.a.k(var3);
         }
      }

   }

   private void a(Object param1, Type param2, Appendable param3) {
      // $FF: Couldn't be decompiled
   }

   public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.c.a param1) {
      // $FF: Couldn't be decompiled
   }

   public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.t var1, com.millennialmedia.a.a.c.a var2) {
      Iterator var4 = this.e.iterator();
      boolean var3 = false;

      while(var4.hasNext()) {
         com.millennialmedia.a.a.t var5 = (com.millennialmedia.a.a.t)var4.next();
         if(!var3) {
            if(var5 == var1) {
               var3 = true;
            }
         } else {
            com.millennialmedia.a.a.s var6 = var5.a(this, var2);
            if(var6 != null) {
               return var6;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + var2);
   }

   public final com.millennialmedia.a.a.s a(Class var1) {
      return this.a(com.millennialmedia.a.a.c.a.a(var1));
   }

   public final Object a(String var1, Class var2) {
      Object var4;
      if(var1 == null) {
         var4 = null;
      } else {
         com.millennialmedia.a.a.d.a var3 = new d.a(new StringReader(var1));
         var4 = this.a((com.millennialmedia.a.a.d.a)var3, (Type)var2);
         a(var4, var3);
      }

      return com.millennialmedia.a.a.b.r.a(var2).cast(var4);
   }

   public final String a(Object var1) {
      if(var1 == null) {
         com.millennialmedia.a.a.l var4 = com.millennialmedia.a.a.l.a;
         StringWriter var5 = new StringWriter();
         this.a((com.millennialmedia.a.a.j)var4, (Appendable)var5);
         return var5.toString();
      } else {
         Class var2 = var1.getClass();
         StringWriter var3 = new StringWriter();
         this.a(var1, var2, var3);
         return var3.toString();
      }
   }

   public final String toString() {
      return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
   }
}
