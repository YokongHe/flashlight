package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.iq;
import com.flurry.sdk.is;
import com.flurry.sdk.iv;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jb;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jg$a;
import com.flurry.sdk.jh;
import com.flurry.sdk.jl;
import com.flurry.sdk.jl$a;
import com.flurry.sdk.jn;
import com.flurry.sdk.jy;
import com.flurry.sdk.kw;
import com.flurry.sdk.kx;
import com.flurry.sdk.lj;
import com.flurry.sdk.ln;
import com.flurry.sdk.lq;
import com.flurry.sdk.lr;
import com.flurry.sdk.ls;
import com.flurry.sdk.lv;
import com.flurry.sdk.lw;
import com.flurry.sdk.lx;
import com.flurry.sdk.ly;
import com.flurry.sdk.mb;
import com.flurry.sdk.me;
import com.flurry.sdk.ml;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mw;
import com.flurry.sdk.ni;
import com.flurry.sdk.qi;
import com.flurry.sdk.qj;
import com.flurry.sdk.qk;
import com.flurry.sdk.ql;
import com.flurry.sdk.qn;
import com.flurry.sdk.qo;
import com.flurry.sdk.qs;
import com.flurry.sdk.ra;
import com.flurry.sdk.sh;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class kn extends jb {
   static final HashMap b = kw.a();
   static final HashMap c = mb.a();
   static final HashMap d;
   static final HashMap e;
   protected static final HashMap f;
   protected ml g;

   static {
      HashMap var0 = new HashMap();
      d = var0;
      var0.put(Map.class.getName(), LinkedHashMap.class);
      d.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
      d.put(SortedMap.class.getName(), TreeMap.class);
      d.put("java.util.NavigableMap", TreeMap.class);

      try {
         Class var3 = Class.forName("java.util.ConcurrentNavigableMap");
         Class var1 = Class.forName("java.util.ConcurrentSkipListMap");
         d.put(var3.getName(), var1);
      } catch (ClassNotFoundException var2) {
         ;
      }

      var0 = new HashMap();
      e = var0;
      var0.put(Collection.class.getName(), ArrayList.class);
      e.put(List.class.getName(), ArrayList.class);
      e.put(Set.class.getName(), HashSet.class);
      e.put(SortedSet.class.getName(), TreeSet.class);
      e.put(Queue.class.getName(), LinkedList.class);
      e.put("java.util.Deque", LinkedList.class);
      e.put("java.util.NavigableSet", TreeSet.class);
      f = ly.a();
   }

   protected kn() {
      this.g = ml.a;
   }

   public jg a(iy var1, jc var2, qi var3, is var4) {
      sh var9 = var3.g();
      jg var7 = (jg)var9.n();
      jg var5;
      if(var7 == null) {
         var5 = (jg)f.get(var9);
         if(var5 != null) {
            jg var10 = this.a(var3, var1, var2, var4, (jy)null, (jg)null);
            if(var10 != null) {
               var5 = var10;
            }

            return var5;
         }

         if(var9.t()) {
            throw new IllegalArgumentException("Internal error: primitive type (" + var3 + ") passed, no array deserializer found");
         }
      }

      jy var6 = (jy)var9.o();
      if(var6 == null) {
         var6 = this.b(var1, var9, var4);
      }

      jg var8 = this.a(var3, var1, var2, var4, var6, var7);
      var5 = var8;
      if(var8 == null) {
         var5 = var7;
         if(var7 == null) {
            var5 = var2.a(var1, var9, var4);
         }

         return new lx(var3, var5, var6);
      } else {
         return var5;
      }
   }

   public jg a(iy var1, jc var2, qk var3, is var4) {
      var3 = (qk)this.a((iy)var1, (sh)var3);
      mw var5 = (mw)var1.c((Class)var3.p());
      jg var6 = this.a((iy)var1, (mm)var5.c(), var4);
      if(var6 != null) {
         return var6;
      } else {
         qk var9 = (qk)this.a((iy)var1, (mm)var5.c(), (sh)var3, (String)null);
         sh var8 = var9.g();
         jg var7 = (jg)var8.n();
         jy var10 = (jy)var8.o();
         if(var10 == null) {
            var10 = this.b(var1, var8, var4);
         }

         return this.a(var9, var1, var2, var5, var4, var10, var7);
      }
   }

   public jg a(iy var1, jc var2, ql var3, is var4) {
      var3 = (ql)this.a((iy)var1, (sh)var3);
      Class var11 = var3.p();
      mw var6 = (mw)var1.c((sh)var3);
      jg var5 = this.a((iy)var1, (mm)var6.c(), var4);
      if(var5 == null) {
         ql var7 = (ql)this.a((iy)var1, (mm)var6.c(), (sh)var3, (String)null);
         sh var10 = var7.g();
         jg var8 = (jg)var10.n();
         jy var15 = (jy)var10.o();
         if(var15 == null) {
            var15 = this.b(var1, var10, var4);
         }

         jg var9 = this.a(var7, var1, var2, var6, var4, var15, var8);
         var5 = var9;
         if(var9 == null) {
            var5 = var8;
            if(var8 == null) {
               if(EnumSet.class.isAssignableFrom(var11)) {
                  return new ls(var10.p(), this.b(var1, var2, var10, var4));
               }

               var5 = var2.a(var1, var10, var4);
            }

            ql var13;
            mw var16;
            label40: {
               if(!var7.s()) {
                  var13 = var7;
                  var16 = var6;
                  if(!var7.c()) {
                     break label40;
                  }
               }

               Class var14 = (Class)e.get(var11.getName());
               if(var14 == null) {
                  throw new IllegalArgumentException("Can not find a deserializer for non-concrete Collection type " + var7);
               }

               var13 = (ql)var1.a(var7, var14);
               var16 = (mw)var1.c((sh)var13);
            }

            kx var12 = this.a(var1, var16);
            if(var10.p() == String.class) {
               return new me(var13, var5, var12);
            }

            return new ln(var13, var5, var15, var12);
         }
      }

      return var5;
   }

   public jg a(iy var1, jc var2, qn var3, is var4) {
      var3 = (qn)this.a((iy)var1, (sh)var3);
      mw var6 = (mw)var1.c((sh)var3);
      jg var5 = this.a((iy)var1, (mm)var6.c(), var4);
      if(var5 != null) {
         return var5;
      } else {
         qn var7 = (qn)this.a((iy)var1, (mm)var6.c(), (sh)var3, (String)null);
         sh var11 = var7.k();
         sh var9 = var7.g();
         jg var8 = (jg)var9.n();
         jl var10 = (jl)var11.n();
         if(var10 == null) {
            var10 = var2.c(var1, var11, var4);
         }

         jy var12 = (jy)var9.o();
         if(var12 == null) {
            var12 = this.b(var1, var9, var4);
         }

         return this.a(var7, var1, var2, var6, var4, var10, var12, var8);
      }
   }

   public jg a(iy var1, jc var2, qo var3, is var4) {
      var3 = (qo)this.a((iy)var1, (sh)var3);
      mw var7 = (mw)var1.c((sh)var3);
      jg var6 = this.a((iy)var1, (mm)var7.c(), var4);
      if(var6 == null) {
         qo var8 = (qo)this.a((iy)var1, (mm)var7.c(), (sh)var3, (String)null);
         sh var11 = var8.k();
         sh var12 = var8.g();
         jg var9 = (jg)var12.n();
         jl var15 = (jl)var11.n();
         if(var15 == null) {
            var15 = var2.c(var1, var11, var4);
         }

         jy var5 = (jy)var12.o();
         if(var5 == null) {
            var5 = this.b(var1, var12, var4);
         }

         jg var10 = this.a(var8, var1, var2, var7, var4, var15, var5, var9);
         var6 = var10;
         if(var10 == null) {
            var6 = var9;
            if(var9 == null) {
               var6 = var2.a(var1, var12, var4);
            }

            Class var19 = var8.p();
            if(EnumMap.class.isAssignableFrom(var19)) {
               Class var18 = var11.p();
               if(var18 != null && var18.isEnum()) {
                  return new lr(var11.p(), this.b(var1, var2, var11, var4), var6);
               }

               throw new IllegalArgumentException("Can not construct EnumMap; generic (key) type not available");
            }

            mw var14;
            qo var16;
            if(!var8.s() && !var8.c()) {
               var14 = var7;
               var16 = var8;
            } else {
               Class var13 = (Class)d.get(var19.getName());
               if(var13 == null) {
                  throw new IllegalArgumentException("Can not find a deserializer for non-concrete Map type " + var8);
               }

               var16 = (qo)var1.a(var8, var13);
               var14 = (mw)var1.c((sh)var16);
            }

            lw var17 = new lw(var16, this.a(var1, var14), var15, var6, var5);
            var17.a(var1.a().c(var14.c()));
            return var17;
         }
      }

      return var6;
   }

   protected jg a(iy var1, mm var2, is var3) {
      Object var4 = var1.a().h(var2);
      return var4 != null?this.a(var1, var2, var3, var4):null;
   }

   jg a(iy var1, mm var2, is var3, Object var4) {
      jg var5;
      jg var7;
      if(var4 instanceof jg) {
         var7 = (jg)var4;
         var5 = var7;
         if(var7 instanceof iv) {
            var5 = ((iv)var7).a(var1, var3);
         }

         return var5;
      } else if(!(var4 instanceof Class)) {
         throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + var4.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
      } else {
         Class var6 = (Class)var4;
         if(!jg.class.isAssignableFrom(var6)) {
            throw new IllegalStateException("AnnotationIntrospector returned Class " + var6.getName() + "; expected Class<JsonDeserializer>");
         } else {
            var7 = var1.a(var2, var6);
            var5 = var7;
            if(var7 instanceof iv) {
               var5 = ((iv)var7).a(var1, var3);
            }

            return var5;
         }
      }
   }

   protected abstract jg a(qi var1, iy var2, jc var3, is var4, jy var5, jg var6);

   protected abstract jg a(qk var1, iy var2, jc var3, mw var4, is var5, jy var6, jg var7);

   protected abstract jg a(ql var1, iy var2, jc var3, mw var4, is var5, jy var6, jg var7);

   protected abstract jg a(qn var1, iy var2, jc var3, mw var4, is var5, jl var6, jy var7, jg var8);

   protected abstract jg a(qo var1, iy var2, jc var3, mw var4, is var5, jl var6, jy var7, jg var8);

   protected abstract jg a(Class var1, iy var2, is var3);

   protected abstract jg a(Class var1, iy var2, mw var3, is var4);

   public jy a(iy var1, sh var2, mq var3, is var4) {
      iq var5 = var1.a();
      ni var6 = var5.a((jn)var1, (mq)var3, (sh)var2);
      return var6 == null?this.b(var1, var2, var4):var6.a(var1, var2, var1.l().a((mq)var3, var1, var5), var4);
   }

   public abstract kx a(iy var1, mw var2);

   protected ra a(Class var1, iy var2) {
      return var2.a(iy$a.j)?ra.b(var1):ra.b(var1, var2.a());
   }

   protected sh a(iy var1, mm var2, sh var3, String var4) {
      iq var6 = var1.a();
      Class var7 = var6.a(var2, var3, var4);
      sh var5;
      if(var7 != null) {
         try {
            var5 = var3.f(var7);
         } catch (IllegalArgumentException var10) {
            throw new jh("Failed to narrow type " + var3 + " with concrete-type annotation (value " + var7.getName() + "), method \'" + var2.b() + "\': " + var10.getMessage(), (hg)null, var10);
         }

         var3 = var5;
      }

      var5 = var3;
      if(var3.f()) {
         var7 = var6.b(var2, var3.k(), var4);
         var5 = var3;
         if(var7 != null) {
            if(!(var3 instanceof qn)) {
               throw new jh("Illegal key-type annotation: type " + var3 + " is not a Map(-like) type");
            }

            try {
               var5 = ((qn)var3).d(var7);
            } catch (IllegalArgumentException var9) {
               throw new jh("Failed to narrow key type " + var3 + " with key-type annotation (" + var7.getName() + "): " + var9.getMessage(), (hg)null, var9);
            }
         }

         var3 = var5.k();
         if(var3 != null && var3.n() == null) {
            var7 = var6.i(var2);
            if(var7 != null && var7 != jl$a.class) {
               var3.j(var1.b(var2, var7));
            }
         }

         Class var12 = var6.c(var2, var5.g(), var4);
         var3 = var5;
         if(var12 != null) {
            try {
               var3 = var5.b(var12);
            } catch (IllegalArgumentException var8) {
               throw new jh("Failed to narrow content type " + var5 + " with content-type annotation (" + var12.getName() + "): " + var8.getMessage(), (hg)null, var8);
            }
         }

         var5 = var3;
         if(var3.g().n() == null) {
            var12 = var6.j(var2);
            var5 = var3;
            if(var12 != null) {
               var5 = var3;
               if(var12 != jg$a.class) {
                  jg var11 = var1.a(var2, var12);
                  var3.g().j(var11);
                  var5 = var3;
               }
            }
         }
      }

      return var5;
   }

   protected sh a(iy var1, mw var2, sh var3, mq var4, is var5) {
      sh var9 = var3;
      if(var3.f()) {
         iq var10 = var1.a();
         sh var6 = var3.k();
         if(var6 != null) {
            Class var7 = var10.i((mm)var4);
            if(var7 != null && var7 != jl$a.class) {
               var6.j(var1.b(var4, var7));
            }
         }

         Class var11 = var10.j((mm)var4);
         if(var11 != null && var11 != jg$a.class) {
            jg var12 = var1.a(var4, var11);
            var3.g().j(var12);
         }

         var9 = var3;
         if(var4 instanceof mq) {
            jy var13 = this.b(var1, var3, var4, var5);
            var9 = var3;
            if(var13 != null) {
               var9 = var3.e(var13);
            }
         }
      }

      jy var8;
      if(var4 instanceof mq) {
         var8 = this.a(var1, var9, var4, var5);
      } else {
         var8 = this.b(var1, var9, (is)null);
      }

      var3 = var9;
      if(var8 != null) {
         var3 = var9.f((Object)var8);
      }

      return var3;
   }

   public abstract sh a(iy var1, sh var2);

   public jg b(iy var1, jc var2, sh var3, is var4) {
      mw var6 = (mw)var1.c(var3);
      jg var5 = this.a((iy)var1, (mm)var6.c(), var4);
      if(var5 != null) {
         return var5;
      } else {
         Class var8 = var3.p();
         jg var9 = this.a(var8, var1, var6, var4);
         if(var9 != null) {
            return var9;
         } else {
            Iterator var7 = var6.o().iterator();

            mr var10;
            do {
               if(!var7.hasNext()) {
                  return new lq(this.a(var8, var1));
               }

               var10 = (mr)var7.next();
            } while(!var1.a().k(var10));

            if(var10.f() == 1 && var10.d().isAssignableFrom(var8)) {
               return lq.a(var1, var8, var10);
            } else {
               throw new IllegalArgumentException("Unsuitable method (" + var10 + ") decorated with @JsonCreator (for Enum type " + var8.getName() + ")");
            }
         }
      }
   }

   public jy b(iy var1, sh var2, is var3) {
      mn var5 = ((mw)var1.c((Class)var2.p())).c();
      iq var6 = var1.a();
      ni var4 = var6.a((jn)var1, (mn)var5, (sh)var2);
      Collection var8;
      if(var4 == null) {
         var4 = var1.d(var2);
         if(var4 == null) {
            return null;
         }

         var8 = null;
      } else {
         var8 = var1.l().a((mn)var5, var1, var6);
      }

      ni var9 = var4;
      if(var4.a() == null) {
         var9 = var4;
         if(var2.c()) {
            sh var7 = this.a(var1, var2);
            var9 = var4;
            if(var7 != null) {
               var9 = var4;
               if(var7.p() != var2.p()) {
                  var9 = var4.a(var7.p());
               }
            }
         }
      }

      return var9.a(var1, var2, var8, var3);
   }

   public jy b(iy var1, sh var2, mq var3, is var4) {
      iq var5 = var1.a();
      ni var6 = var5.b((jn)var1, (mq)var3, (sh)var2);
      var2 = var2.g();
      return var6 == null?this.b(var1, var2, var4):var6.a(var1, var2, var1.l().a((mq)var3, var1, var5), var4);
   }

   public jg c(iy var1, jc var2, sh var3, is var4) {
      Class var6 = var3.p();
      jg var5 = this.a(var6, var1, var4);
      return var5 != null?var5:lv.a(var6);
   }

   protected jg d(iy var1, jc var2, sh var3, is var4) {
      Class var6 = var3.p();
      jg var5 = (jg)b.get(new qj(var6));
      jg var7;
      if(var5 != null) {
         var7 = var5;
      } else {
         if(AtomicReference.class.isAssignableFrom(var6)) {
            sh[] var8 = var1.m().b(var3, AtomicReference.class);
            sh var10;
            if(var8 != null && var8.length > 0) {
               var10 = var8[0];
            } else {
               var10 = qs.b();
            }

            return new lj(var10, var4);
         }

         jg var9 = this.g.a(var3, var1, var2);
         var7 = var9;
         if(var9 == null) {
            return null;
         }
      }

      return var7;
   }
}
