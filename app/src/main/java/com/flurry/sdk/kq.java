package com.flurry.sdk;

import com.flurry.sdk.ip;
import com.flurry.sdk.iq;
import com.flurry.sdk.iq$a;
import com.flurry.sdk.is;
import com.flurry.sdk.is$a;
import com.flurry.sdk.it;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jb;
import com.flurry.sdk.jb$a;
import com.flurry.sdk.jc;
import com.flurry.sdk.jd;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.jl;
import com.flurry.sdk.jm;
import com.flurry.sdk.jy;
import com.flurry.sdk.km;
import com.flurry.sdk.kn;
import com.flurry.sdk.ko;
import com.flurry.sdk.kp;
import com.flurry.sdk.kq$a;
import com.flurry.sdk.kr;
import com.flurry.sdk.ks;
import com.flurry.sdk.kt;
import com.flurry.sdk.kt$a;
import com.flurry.sdk.kt$d;
import com.flurry.sdk.kt$f;
import com.flurry.sdk.kx;
import com.flurry.sdk.ky;
import com.flurry.sdk.la;
import com.flurry.sdk.lb;
import com.flurry.sdk.mb;
import com.flurry.sdk.mg;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mo;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mt;
import com.flurry.sdk.mu;
import com.flurry.sdk.mw;
import com.flurry.sdk.ne;
import com.flurry.sdk.qi;
import com.flurry.sdk.qk;
import com.flurry.sdk.ql;
import com.flurry.sdk.qn;
import com.flurry.sdk.qo;
import com.flurry.sdk.qw;
import com.flurry.sdk.qy;
import com.flurry.sdk.ra;
import com.flurry.sdk.sh;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class kq extends kn {
   public static final kq h = new kq((jb$a)null);
   private static final Class[] j = new Class[]{Throwable.class};
   protected final jb$a i;

   @Deprecated
   public kq() {
      this((jb$a)null);
   }

   public kq(jb$a var1) {
      Object var2 = var1;
      if(var1 == null) {
         var2 = new kq$a();
      }

      this.i = (jb$a)var2;
   }

   // $FF: synthetic method
   static jd[] b() {
      return a;
   }

   private jl c(iy var1, sh var2, is var3) {
      mw var4 = (mw)var1.b(var2);
      Class var6 = var2.p();
      ra var7 = this.a((Class)var6, (iy)var1);
      Iterator var8 = var4.o().iterator();

      mr var5;
      do {
         if(!var8.hasNext()) {
            return mb.a(var7);
         }

         var5 = (mr)var8.next();
      } while(!var1.a().k(var5));

      if(var5.f() == 1 && var5.d().isAssignableFrom(var6)) {
         if(var5.b(0) != String.class) {
            throw new IllegalArgumentException("Parameter #0 type for factory method (" + var5 + ") not suitable, must be java.lang.String");
         } else {
            if(var1.c()) {
               qy.a(var5.i());
            }

            return mb.a(var7, var5);
         }
      } else {
         throw new IllegalArgumentException("Unsuitable method (" + var5 + ") decorated with @JsonCreator (for Enum type " + var6.getName() + ")");
      }
   }

   public final jb$a a() {
      return this.i;
   }

   public jb a(jb$a var1) {
      if(this.i == var1) {
         return this;
      } else if(this.getClass() != kq.class) {
         throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + this.getClass().getName() + ") has not properly overridden method \'withAdditionalDeserializers\': can not instantiate subtype with additional deserializer definitions");
      } else {
         return new kq(var1);
      }
   }

   public jg a(iy var1, jc var2, sh var3, is var4) {
      sh var5 = var3;
      if(var3.c()) {
         var5 = this.a(var1, var3);
      }

      mw var6 = (mw)var1.b(var5);
      jg var9 = this.a((iy)var1, (mm)var6.c(), (is)var4);
      if(var9 == null) {
         var3 = this.a((iy)var1, (mm)var6.c(), (sh)var5, (String)null);
         if(var3.p() != var5.p()) {
            var6 = (mw)var1.b(var3);
            var5 = var3;
         }

         jg var7 = this.a(var5, var1, var2, var6, var4);
         var9 = var7;
         if(var7 == null) {
            if(var5.q()) {
               return this.b(var1, var5, var6, var4);
            }

            if(var5.c()) {
               var3 = this.b(var1, var6);
               if(var3 != null) {
                  return this.a(var1, var3, (mw)var1.b(var3), var4);
               }
            }

            jg var8 = this.d(var1, var2, var5, var4);
            var9 = var8;
            if(var8 == null) {
               if(!this.a(var5.p())) {
                  return null;
               }

               return this.a(var1, var5, var6, var4);
            }
         }
      }

      return var9;
   }

   public jg a(iy var1, sh var2, mw var3, is var4) {
      kx var5 = this.a(var1, var3);
      Object var9;
      if(var2.c() && !var5.b()) {
         var9 = new km(var2);
      } else {
         kp var7 = this.a(var3);
         var7.a(var5);
         this.a(var1, var3, var7);
         this.b(var1, var3, var7);
         this.c(var1, var3, var7);
         kp var10;
         if(this.i.g()) {
            Iterator var6 = this.i.c().iterator();

            while(true) {
               var10 = var7;
               if(!var6.hasNext()) {
                  break;
               }

               var7 = ((kr)var6.next()).a(var1, var3, var7);
            }
         } else {
            var10 = var7;
         }

         jg var8 = var10.a(var4);
         if(!this.i.g()) {
            return var8;
         }

         Iterator var11 = this.i.c().iterator();

         while(true) {
            var9 = var8;
            if(!var11.hasNext()) {
               break;
            }

            var8 = ((kr)var11.next()).a(var1, var3, var8);
         }
      }

      return (jg)var9;
   }

   protected jg a(qi var1, iy var2, jc var3, is var4, jy var5, jg var6) {
      Iterator var7 = this.i.a().iterator();

      jg var8;
      do {
         if(!var7.hasNext()) {
            return null;
         }

         var8 = ((jd)var7.next()).a(var1, var2, var3, var4, var5, var6);
      } while(var8 == null);

      return var8;
   }

   protected jg a(qk var1, iy var2, jc var3, mw var4, is var5, jy var6, jg var7) {
      Iterator var8 = this.i.a().iterator();

      jg var9;
      do {
         if(!var8.hasNext()) {
            return null;
         }

         var9 = ((jd)var8.next()).a((qk)var1, var2, var3, var4, var5, var6, var7);
      } while(var9 == null);

      return var9;
   }

   protected jg a(ql var1, iy var2, jc var3, mw var4, is var5, jy var6, jg var7) {
      Iterator var8 = this.i.a().iterator();

      jg var9;
      do {
         if(!var8.hasNext()) {
            return null;
         }

         var9 = ((jd)var8.next()).a((ql)var1, var2, var3, var4, var5, var6, var7);
      } while(var9 == null);

      return var9;
   }

   protected jg a(qn var1, iy var2, jc var3, mw var4, is var5, jl var6, jy var7, jg var8) {
      Iterator var9 = this.i.a().iterator();

      jg var10;
      do {
         if(!var9.hasNext()) {
            return null;
         }

         var10 = ((jd)var9.next()).a((qn)var1, var2, var3, var4, var5, var6, var7, var8);
      } while(var10 == null);

      return var10;
   }

   protected jg a(qo var1, iy var2, jc var3, mw var4, is var5, jl var6, jy var7, jg var8) {
      Iterator var9 = this.i.a().iterator();

      jg var10;
      do {
         if(!var9.hasNext()) {
            return null;
         }

         var10 = ((jd)var9.next()).a((qo)var1, var2, var3, var4, var5, var6, var7, var8);
      } while(var10 == null);

      return var10;
   }

   protected jg a(sh var1, iy var2, jc var3, mw var4, is var5) {
      Iterator var6 = this.i.a().iterator();

      jg var7;
      do {
         if(!var6.hasNext()) {
            return null;
         }

         var7 = ((jd)var6.next()).a(var1, var2, var3, var4, var5);
      } while(var7 == null);

      return var7;
   }

   protected jg a(Class var1, iy var2, is var3) {
      Iterator var4 = this.i.a().iterator();

      jg var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = ((jd)var4.next()).a(var1, var2, var3);
      } while(var5 == null);

      return var5;
   }

   protected jg a(Class var1, iy var2, mw var3, is var4) {
      Iterator var5 = this.i.a().iterator();

      jg var6;
      do {
         if(!var5.hasNext()) {
            return null;
         }

         var6 = ((jd)var5.next()).a(var1, var2, var3, var4);
      } while(var6 == null);

      return var6;
   }

   public jl a(iy var1, sh var2, is var3) {
      jl var4;
      if(this.i.f()) {
         mw var5 = (mw)var1.c((Class)var2.p());
         Iterator var6 = this.i.b().iterator();

         while(var6.hasNext()) {
            var4 = ((jm)var6.next()).a(var2, var1, var5, var3);
            if(var4 != null) {
               return var4;
            }
         }
      }

      Class var7 = var2.p();
      if(var7 == String.class || var7 == Object.class) {
         return mb.a(var1, var2);
      } else {
         jl var8 = (jl)c.get(var2);
         var4 = var8;
         if(var8 == null) {
            if(var2.r()) {
               return this.c(var1, var2, var3);
            } else {
               return mb.b(var1, var2);
            }
         } else {
            return var4;
         }
      }
   }

   protected kp a(mw var1) {
      return new kp(var1);
   }

   protected ks a(iy var1, mw var2, mr var3) {
      if(var1.a(iy$a.f)) {
         var3.k();
      }

      sh var5 = var2.j().a(var3.b(1));
      is$a var4 = new is$a(var3.b(), var5, var2.i(), var3);
      sh var7 = this.a((iy)var1, (mw)var2, (sh)var5, (mq)var3, (is)var4);
      jg var6 = this.a((iy)var1, (mm)var3, (is)var4);
      return var6 != null?new ks(var4, var3, var7, var6):new ks(var4, var3, this.a((iy)var1, (mm)var3, (sh)var7, (String)var4.c()), (jg)null);
   }

   protected kt a(iy var1, mw var2, String var3, mp var4) {
      if(var1.a(iy$a.f)) {
         var4.k();
      }

      sh var8 = var2.j().a(var4.c());
      is$a var6 = new is$a(var3, var8, var2.i(), var4);
      sh var7 = this.a((iy)var1, (mw)var2, (sh)var8, (mq)var4, (is)var6);
      is$a var5 = var6;
      if(var7 != var8) {
         var5 = var6.a(var7);
      }

      jg var12 = this.a((iy)var1, (mm)var4, (is)var5);
      sh var13 = this.a((iy)var1, (mm)var4, (sh)var7, (String)var3);
      kt$a var11 = new kt$a(var3, var13, (jy)var13.o(), var2.i(), var4);
      Object var10 = var11;
      if(var12 != null) {
         var10 = var11.a(var12);
      }

      iq$a var9 = var1.a().a((mq)var4);
      if(var9 != null && var9.b()) {
         ((kt)var10).a(var9.a());
      }

      return (kt)var10;
   }

   protected kt a(iy var1, mw var2, String var3, mr var4) {
      if(var1.a(iy$a.f)) {
         var4.k();
      }

      sh var8 = var2.j().a(var4.b(0));
      is$a var6 = new is$a(var3, var8, var2.i(), var4);
      sh var7 = this.a((iy)var1, (mw)var2, (sh)var8, (mq)var4, (is)var6);
      is$a var5 = var6;
      if(var7 != var8) {
         var5 = var6.a(var7);
      }

      jg var12 = this.a((iy)var1, (mm)var4, (is)var5);
      sh var13 = this.a((iy)var1, (mm)var4, (sh)var7, (String)var3);
      kt$d var11 = new kt$d(var3, var13, (jy)var13.o(), var2.i(), var4);
      Object var10 = var11;
      if(var12 != null) {
         var10 = var11.a(var12);
      }

      iq$a var9 = var1.a().a((mq)var4);
      if(var9 != null && var9.b()) {
         ((kt)var10).a(var9.a());
      }

      return (kt)var10;
   }

   public kx a(iy var1, mw var2) {
      mn var3 = var2.c();
      Object var4 = var1.a().j(var3);
      kx var7;
      if(var4 != null) {
         if(var4 instanceof kx) {
            var7 = (kx)var4;
         } else {
            if(!(var4 instanceof Class)) {
               throw new IllegalStateException("Invalid value instantiator returned for type " + var2 + ": neither a Class nor ValueInstantiator");
            }

            Class var8 = (Class)var4;
            if(!kx.class.isAssignableFrom(var8)) {
               throw new IllegalStateException("Invalid instantiator Class<?> returned for type " + var2 + ": " + var8.getName() + " not a ValueInstantiator");
            }

            var7 = var1.c(var3, var8);
         }
      } else {
         var7 = this.c(var1, var2);
      }

      kx var9;
      if(this.i.i()) {
         Iterator var5 = this.i.e().iterator();

         while(true) {
            var9 = var7;
            if(!var5.hasNext()) {
               break;
            }

            ky var6 = (ky)var5.next();
            var9 = var6.a(var1, var2, var7);
            var7 = var9;
            if(var9 == null) {
               throw new jh("Broken registered ValueInstantiators (of type " + var6.getClass().getName() + "): returned null ValueInstantiator");
            }
         }
      } else {
         var9 = var7;
      }

      return var9;
   }

   protected lb a(iy var1, mw var2, String var3, int var4, mt var5, Object var6) {
      sh var9 = var1.m().a(var5.e(), var2.j());
      is$a var8 = new is$a(var3, var9, var2.i(), var5);
      sh var10 = this.a((iy)var1, (mw)var2, (sh)var9, (mq)var5, (is)var8);
      is$a var7 = var8;
      if(var10 != var9) {
         var7 = var8.a(var10);
      }

      jg var15 = this.a((iy)var1, (mm)var5, (is)var7);
      var10 = this.a((iy)var1, (mm)var5, (sh)var10, (String)var3);
      jy var14 = (jy)var10.o();
      jy var11;
      if(var14 == null) {
         var11 = this.b(var1, var10, var7);
      } else {
         var11 = var14;
      }

      lb var12 = new lb(var3, var10, var11, var2.i(), var5, var4, var6);
      lb var13 = var12;
      if(var15 != null) {
         var13 = var12.b(var15);
      }

      return var13;
   }

   public sh a(iy var1, sh var2) {
      while(true) {
         sh var3 = this.b(var1, var2);
         if(var3 == null) {
            return var2;
         }

         Class var4 = var2.p();
         Class var5 = var3.p();
         if(var4 == var5 || !var4.isAssignableFrom(var5)) {
            throw new IllegalArgumentException("Invalid abstract type resolution from " + var2 + " to " + var3 + ": latter is not a subtype of former");
         }

         var2 = var3;
      }
   }

   protected void a(iy var1, mw var2, kp var3) {
      List var6 = var2.d();
      iq var4 = var1.a();
      Boolean var5 = var4.d(var2.c());
      if(var5 != null) {
         var3.a(var5.booleanValue());
      }

      HashSet var13 = qw.a(var4.c(var2.c()));
      Iterator var11 = var13.iterator();

      while(var11.hasNext()) {
         var3.a((String)var11.next());
      }

      mr var7 = var2.l();
      Set var12;
      if(var7 == null) {
         var12 = var2.f();
      } else {
         var12 = var2.g();
      }

      if(var12 != null) {
         var11 = var12.iterator();

         while(var11.hasNext()) {
            var3.a((String)var11.next());
         }
      }

      HashMap var14 = new HashMap();
      Iterator var8 = var6.iterator();

      while(var8.hasNext()) {
         it var10 = (it)var8.next();
         String var9 = var10.a();
         if(!var13.contains(var9)) {
            if(var10.e()) {
               var3.a(var10);
            } else {
               kt var18;
               if(var10.c()) {
                  mr var19 = var10.h();
                  if(this.a((iy)var1, (mw)var2, (Class)var19.a(0), (Map)var14)) {
                     var3.a(var9);
                  } else {
                     var18 = this.a(var1, var2, var9, var19);
                     if(var18 != null) {
                        var3.a(var18);
                     }
                  }
               } else if(var10.d()) {
                  mp var20 = var10.i();
                  if(this.a((iy)var1, (mw)var2, (Class)var20.d(), (Map)var14)) {
                     var3.a(var9);
                  } else {
                     var18 = this.a(var1, var2, var9, var20);
                     if(var18 != null) {
                        var3.a(var18);
                     }
                  }
               }
            }
         }
      }

      if(var7 != null) {
         var3.a(this.a(var1, var2, var7));
      }

      if(var1.a(iy$a.e)) {
         var11 = var6.iterator();

         while(true) {
            String var15;
            Class var17;
            do {
               it var16;
               do {
                  do {
                     do {
                        if(!var11.hasNext()) {
                           return;
                        }

                        var16 = (it)var11.next();
                     } while(!var16.b());

                     var15 = var16.a();
                  } while(var3.b(var15));
               } while(var13.contains(var15));

               var7 = var16.g();
               var17 = var7.d();
            } while(!Collection.class.isAssignableFrom(var17) && !Map.class.isAssignableFrom(var17));

            if(!var13.contains(var15) && !var3.b(var15)) {
               var3.a(this.b(var1, var2, var15, var7));
            }
         }
      }
   }

   protected void a(iy var1, mw var2, ne var3, iq var4, la var5) {
      Iterator var17 = var2.n().iterator();

      while(true) {
         while(true) {
            int var11;
            mo var18;
            do {
               if(!var17.hasNext()) {
                  return;
               }

               var18 = (mo)var17.next();
               var11 = var18.f();
            } while(var11 <= 0);

            boolean var12 = var4.k(var18);
            boolean var13 = var3.a((mq)var18);
            if(var11 == 1) {
               this.a(var1, var2, var3, var4, var5, var18, var12, var13);
            } else if(var12 || var13) {
               mt var14 = null;
               int var7 = 0;
               int var8 = 0;
               lb[] var19 = new lb[var11];

               int var10;
               for(int var6 = 0; var6 < var11; var7 = var10) {
                  mt var16 = var18.c(var6);
                  String var15;
                  if(var16 == null) {
                     var15 = null;
                  } else {
                     var15 = var4.a(var16);
                  }

                  Object var20 = var4.d((mq)var16);
                  int var9;
                  mt var21;
                  if(var15 != null && var15.length() > 0) {
                     var10 = var7 + 1;
                     var19[var6] = this.a(var1, var2, var15, var6, var16, var20);
                     var21 = var14;
                     var9 = var8;
                  } else if(var20 != null) {
                     var9 = var8 + 1;
                     var19[var6] = this.a(var1, var2, var15, var6, var16, var20);
                     var10 = var7;
                     var21 = var14;
                  } else {
                     var9 = var8;
                     var10 = var7;
                     var21 = var16;
                     if(var14 != null) {
                        var9 = var8;
                        var10 = var7;
                        var21 = var14;
                     }
                  }

                  ++var6;
                  var14 = var21;
                  var8 = var9;
               }

               if(var12 || var7 > 0 || var8 > 0) {
                  if(var7 + var8 != var11) {
                     if(var7 == 0 && var8 + 1 == var11) {
                        throw new IllegalArgumentException("Delegated constructor with Injectables not yet supported (see [JACKSON-712]) for " + var18);
                     }

                     throw new IllegalArgumentException("Argument #" + var14.g() + " of constructor " + var18 + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
                  }

                  var5.a(var18, var19);
               }
            }
         }
      }
   }

   protected boolean a(iy var1, mw var2, ne var3, iq var4, la var5, mo var6, boolean var7, boolean var8) {
      mt var11 = var6.c(0);
      String var9 = var4.a(var11);
      Object var12 = var4.d((mq)var11);
      if(var12 != null || var9 != null && var9.length() > 0) {
         var5.a(var6, new lb[]{this.a(var1, var2, var9, 0, var11, var12)});
         return true;
      } else {
         Class var10 = var6.a(0);
         if(var10 == String.class) {
            if(var7 || var8) {
               var5.a((mu)var6);
            }

            return true;
         } else if(var10 != Integer.TYPE && var10 != Integer.class) {
            if(var10 != Long.TYPE && var10 != Long.class) {
               if(var10 != Double.TYPE && var10 != Double.class) {
                  if(var7) {
                     var5.f(var6);
                     return true;
                  } else {
                     return false;
                  }
               } else {
                  if(var7 || var8) {
                     var5.d(var6);
                  }

                  return true;
               }
            } else {
               if(var7 || var8) {
                  var5.c(var6);
               }

               return true;
            }
         } else {
            if(var7 || var8) {
               var5.b(var6);
            }

            return true;
         }
      }
   }

   protected boolean a(iy var1, mw var2, ne var3, iq var4, la var5, mr var6, boolean var7) {
      Class var8 = var6.a(0);
      if(var8 == String.class) {
         if(var7 || var3.a((mq)var6)) {
            var5.a((mu)var6);
         }
      } else if(var8 != Integer.TYPE && var8 != Integer.class) {
         if(var8 != Long.TYPE && var8 != Long.class) {
            if(var8 != Double.TYPE && var8 != Double.class) {
               if(var8 != Boolean.TYPE && var8 != Boolean.class) {
                  if(var4.k(var6)) {
                     var5.f(var6);
                     return true;
                  }

                  return false;
               }

               if(var7 || var3.a((mq)var6)) {
                  var5.e(var6);
                  return true;
               }
            } else if(var7 || var3.a((mq)var6)) {
               var5.d(var6);
               return true;
            }
         } else if(var7 || var3.a((mq)var6)) {
            var5.c(var6);
            return true;
         }
      } else if(var7 || var3.a((mq)var6)) {
         var5.b(var6);
         return true;
      }

      return true;
   }

   protected boolean a(iy var1, mw var2, Class var3, Map var4) {
      Boolean var7 = (Boolean)var4.get(var3);
      Boolean var6 = var7;
      if(var7 == null) {
         var2 = (mw)var1.c((Class)var3);
         Boolean var5 = var1.a().e(var2.c());
         var6 = var5;
         if(var5 == null) {
            var6 = Boolean.FALSE;
         }
      }

      return var6.booleanValue();
   }

   protected boolean a(Class var1) {
      String var2 = qy.a(var1);
      if(var2 != null) {
         throw new IllegalArgumentException("Can not deserialize Class " + var1.getName() + " (of type " + var2 + ") as a Bean");
      } else if(qy.c(var1)) {
         throw new IllegalArgumentException("Can not deserialize Proxy class " + var1.getName() + " as a Bean");
      } else {
         var2 = qy.a(var1, true);
         if(var2 != null) {
            throw new IllegalArgumentException("Can not deserialize Class " + var1.getName() + " (of type " + var2 + ") as a Bean");
         } else {
            return true;
         }
      }
   }

   public jg b(iy var1, sh var2, mw var3, is var4) {
      kp var7 = this.a(var3);
      var7.a(this.a(var1, var3));
      this.a(var1, var3, var7);
      mr var5 = var3.a("initCause", j);
      if(var5 != null) {
         kt var11 = this.a(var1, var3, "cause", var5);
         if(var11 != null) {
            var7.a(var11, true);
         }
      }

      var7.a("localizedMessage");
      var7.a("message");
      kp var12;
      if(this.i.g()) {
         Iterator var6 = this.i.c().iterator();

         while(true) {
            var12 = var7;
            if(!var6.hasNext()) {
               break;
            }

            var7 = ((kr)var6.next()).a(var1, var3, var7);
         }
      } else {
         var12 = var7;
      }

      jg var9 = var12.a(var4);
      Object var8 = var9;
      if(var9 instanceof ko) {
         var8 = new mg((ko)var9);
      }

      Object var10;
      if(this.i.g()) {
         Iterator var13 = this.i.c().iterator();

         while(true) {
            var10 = var8;
            if(!var13.hasNext()) {
               break;
            }

            var8 = ((kr)var13.next()).a(var1, var3, (jg)var8);
         }
      } else {
         var10 = var8;
      }

      return (jg)var10;
   }

   protected kt b(iy var1, mw var2, String var3, mr var4) {
      if(var1.a(iy$a.f)) {
         var4.k();
      }

      sh var6 = var4.a(var2.j());
      jg var5 = this.a((iy)var1, (mm)var4, (is)(new is$a(var3, var6, var2.i(), var4)));
      sh var7 = this.a((iy)var1, (mm)var4, (sh)var6, (String)var3);
      kt$f var9 = new kt$f(var3, var7, (jy)var7.o(), var2.i(), var4);
      Object var8 = var9;
      if(var5 != null) {
         var8 = var9.a(var5);
      }

      return (kt)var8;
   }

   protected sh b(iy var1, mw var2) {
      sh var5 = var2.a();
      Iterator var3 = this.i.d().iterator();

      sh var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = ((ip)var3.next()).b(var1, var5);
      } while(var4 == null);

      return var4;
   }

   protected sh b(iy var1, sh var2) {
      Class var3 = var2.p();
      if(this.i.h()) {
         Iterator var4 = this.i.d().iterator();

         while(var4.hasNext()) {
            sh var5 = ((ip)var4.next()).a(var1, var2);
            if(var5 != null && var5.p() != var3) {
               return var5;
            }
         }
      }

      return null;
   }

   protected void b(iy var1, mw var2, kp var3) {
      Map var4 = var2.q();
      if(var4 != null) {
         Iterator var8 = var4.entrySet().iterator();

         while(var8.hasNext()) {
            Entry var6 = (Entry)var8.next();
            String var5 = (String)var6.getKey();
            mq var7 = (mq)var6.getValue();
            if(var7 instanceof mr) {
               var3.a(var5, this.a(var1, var2, var7.b(), (mr)var7));
            } else {
               var3.a(var5, this.a(var1, var2, var7.b(), (mp)var7));
            }
         }
      }

   }

   protected void b(iy var1, mw var2, ne var3, iq var4, la var5) {
      Iterator var9 = var2.o().iterator();

      while(true) {
         while(true) {
            int var7;
            mr var10;
            do {
               if(!var9.hasNext()) {
                  return;
               }

               var10 = (mr)var9.next();
               var7 = var10.f();
            } while(var7 <= 0);

            boolean var8 = var4.k(var10);
            if(var7 == 1) {
               mt var11 = var10.c(0);
               String var12 = var4.a(var11);
               if(var4.d((mq)var11) == null && (var12 == null || var12.length() == 0)) {
                  this.a(var1, var2, var3, var4, var5, var10, var8);
                  continue;
               }
            } else if(!var4.k(var10)) {
               continue;
            }

            lb[] var15 = new lb[var7];

            for(int var6 = 0; var6 < var7; ++var6) {
               mt var16 = var10.c(var6);
               String var13 = var4.a(var16);
               Object var14 = var4.d((mq)var16);
               if((var13 == null || var13.length() == 0) && var14 == null) {
                  throw new IllegalArgumentException("Argument #" + var6 + " of factory method " + var10 + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
               }

               var15[var6] = this.a(var1, var2, var13, var6, var16, var14);
            }

            var5.a(var10, var15);
         }
      }
   }

   protected kx c(iy var1, mw var2) {
      boolean var3 = var1.a(iy$a.f);
      la var4 = new la(var2, var3);
      iq var5 = var1.a();
      if(var2.a().d()) {
         mo var6 = var2.k();
         if(var6 != null) {
            if(var3) {
               qy.a((Member)var6.e());
            }

            var4.a(var6);
         }
      }

      ne var7 = var1.e();
      var7 = var1.a().a(var2.c(), var7);
      this.b(var1, var2, var7, var5, var4);
      this.a(var1, var2, var7, var5, var4);
      return var4.a(var1);
   }

   protected void c(iy var1, mw var2, kp var3) {
      Map var5 = var2.m();
      if(var5 != null) {
         boolean var4 = var1.a(iy$a.f);

         mq var6;
         Entry var7;
         for(Iterator var8 = var5.entrySet().iterator(); var8.hasNext(); var3.a(var6.b(), var2.a(var6.c()), var2.i(), var6, var7.getKey())) {
            var7 = (Entry)var8.next();
            var6 = (mq)var7.getValue();
            if(var4) {
               var6.k();
            }
         }
      }

   }
}
