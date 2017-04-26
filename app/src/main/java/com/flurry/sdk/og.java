package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.is;
import com.flurry.sdk.ix;
import com.flurry.sdk.ji;
import com.flurry.sdk.jj;
import com.flurry.sdk.jk;
import com.flurry.sdk.jk$a;
import com.flurry.sdk.jn;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jv;
import com.flurry.sdk.jx;
import com.flurry.sdk.jz;
import com.flurry.sdk.kg$b;
import com.flurry.sdk.ml;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mr;
import com.flurry.sdk.mw;
import com.flurry.sdk.ni;
import com.flurry.sdk.os$a;
import com.flurry.sdk.os$b;
import com.flurry.sdk.os$c;
import com.flurry.sdk.os$d;
import com.flurry.sdk.os$e;
import com.flurry.sdk.os$f;
import com.flurry.sdk.os$g;
import com.flurry.sdk.os$h;
import com.flurry.sdk.os$i;
import com.flurry.sdk.pd;
import com.flurry.sdk.pg;
import com.flurry.sdk.ph;
import com.flurry.sdk.pi;
import com.flurry.sdk.pk;
import com.flurry.sdk.pl;
import com.flurry.sdk.pn;
import com.flurry.sdk.po;
import com.flurry.sdk.pr;
import com.flurry.sdk.pu;
import com.flurry.sdk.pv;
import com.flurry.sdk.py$b;
import com.flurry.sdk.py$c;
import com.flurry.sdk.py$d;
import com.flurry.sdk.py$e;
import com.flurry.sdk.py$f;
import com.flurry.sdk.py$g;
import com.flurry.sdk.py$h;
import com.flurry.sdk.py$i;
import com.flurry.sdk.py$j;
import com.flurry.sdk.pz;
import com.flurry.sdk.qa;
import com.flurry.sdk.qd;
import com.flurry.sdk.qe;
import com.flurry.sdk.qf;
import com.flurry.sdk.qg;
import com.flurry.sdk.qh;
import com.flurry.sdk.qi;
import com.flurry.sdk.qk;
import com.flurry.sdk.ql;
import com.flurry.sdk.qn;
import com.flurry.sdk.qo;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.rb;
import com.flurry.sdk.sh;
import com.flurry.sdk.sq;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.TimeZone;
import java.util.Map.Entry;

public abstract class og extends jv {
   protected static final HashMap a = new HashMap();
   protected static final HashMap b = new HashMap();
   protected static final HashMap c;
   protected ml d;

   static {
      a.put(String.class.getName(), new qe());
      qg var0 = qg.a;
      a.put(StringBuffer.class.getName(), var0);
      a.put(StringBuilder.class.getName(), var0);
      a.put(Character.class.getName(), var0);
      a.put(Character.TYPE.getName(), var0);
      a.put(Boolean.TYPE.getName(), new os$a(true));
      a.put(Boolean.class.getName(), new os$a(false));
      os$e var3 = new os$e();
      a.put(Integer.class.getName(), var3);
      a.put(Integer.TYPE.getName(), var3);
      a.put(Long.class.getName(), os$f.a);
      a.put(Long.TYPE.getName(), os$f.a);
      a.put(Byte.class.getName(), os$d.a);
      a.put(Byte.TYPE.getName(), os$d.a);
      a.put(Short.class.getName(), os$d.a);
      a.put(Short.TYPE.getName(), os$d.a);
      a.put(Float.class.getName(), os$c.a);
      a.put(Float.TYPE.getName(), os$c.a);
      a.put(Double.class.getName(), os$b.a);
      a.put(Double.TYPE.getName(), os$b.a);
      os$g var4 = new os$g();
      a.put(BigInteger.class.getName(), var4);
      a.put(BigDecimal.class.getName(), var4);
      a.put(Calendar.class.getName(), pd.a);
      pg var5 = pg.a;
      a.put(Date.class.getName(), var5);
      a.put(Timestamp.class.getName(), var5);
      a.put(java.sql.Date.class.getName(), new os$h());
      a.put(Time.class.getName(), new os$i());
      Iterator var6 = (new qa()).a().iterator();

      while(var6.hasNext()) {
         Entry var1 = (Entry)var6.next();
         Object var2 = var1.getValue();
         if(var2 instanceof jk) {
            a.put(((Class)var1.getKey()).getName(), (jk)var2);
         } else {
            if(!(var2 instanceof Class)) {
               throw new IllegalStateException("Internal error: unrecognized value of type " + var1.getClass().getName());
            }

            Class var8 = (Class)var2;
            b.put(((Class)var1.getKey()).getName(), var8);
         }
      }

      b.put(sq.class.getName(), qh.class);
      HashMap var7 = new HashMap();
      c = var7;
      var7.put(boolean[].class.getName(), new py$b());
      c.put(byte[].class.getName(), new py$c());
      c.put(char[].class.getName(), new py$d());
      c.put(short[].class.getName(), new py$i());
      c.put(int[].class.getName(), new py$g());
      c.put(long[].class.getName(), new py$h());
      c.put(float[].class.getName(), new py$f());
      c.put(double[].class.getName(), new py$e());
   }

   protected og() {
      this.d = ml.a;
   }

   protected static jk b(ju var0, mm var1, is var2) {
      iq var5 = var0.a();
      Class var4 = var5.c(var1);
      Class var3;
      if(var4 != null) {
         var3 = var4;
         if(var4 != jk$a.class) {
            return var3 != null && var3 != jk$a.class?var0.a(var1, var3):null;
         }
      }

      var3 = var4;
      if(var2 != null) {
         var3 = var5.c((mm)var2.b());
      }

      return var3 != null && var3 != jk$a.class?var0.a(var1, var3):null;
   }

   protected static sh b(ju var0, mm var1, sh var2) {
      iq var4 = var0.a();
      sh var3 = var2;
      if(var2.f()) {
         Class var9 = var4.a(var1, var2.k());
         sh var7 = var2;
         if(var9 != null) {
            if(!(var2 instanceof qo)) {
               throw new IllegalArgumentException("Illegal key-type annotation: type " + var2 + " is not a Map type");
            }

            try {
               var7 = ((qo)var2).e(var9);
            } catch (IllegalArgumentException var6) {
               throw new IllegalArgumentException("Failed to narrow key type " + var2 + " with key-type annotation (" + var9.getName() + "): " + var6.getMessage());
            }
         }

         Class var8 = var4.b(var1, var7.g());
         var3 = var7;
         if(var8 != null) {
            try {
               var3 = var7.c(var8);
            } catch (IllegalArgumentException var5) {
               throw new IllegalArgumentException("Failed to narrow content type " + var7 + " with content-type annotation (" + var8.getName() + "): " + var5.getMessage());
            }
         }
      }

      return var3;
   }

   protected static jk c(ju var0, mm var1, is var2) {
      iq var5 = var0.a();
      Class var4 = var5.d(var1);
      Class var3;
      if(var4 != null) {
         var3 = var4;
         if(var4 != jk$a.class) {
            return var3 != null && var3 != jk$a.class?var0.a(var1, var3):null;
         }
      }

      var3 = var4;
      if(var2 != null) {
         var3 = var5.d((mm)var2.b());
      }

      return var3 != null && var3 != jk$a.class?var0.a(var1, var3):null;
   }

   protected jk a(ju var1, mm var2, is var3) {
      Object var4 = var1.a().b(var2);
      jk var5;
      if(var4 == null) {
         var5 = null;
      } else {
         jk var6;
         if(var4 instanceof jk) {
            var6 = (jk)var4;
            var5 = var6;
            if(var6 instanceof ix) {
               return ((ix)var6).a(var1, var3);
            }
         } else {
            if(!(var4 instanceof Class)) {
               throw new IllegalStateException("AnnotationIntrospector returned value of type " + var4.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
            }

            Class var7 = (Class)var4;
            if(!jk.class.isAssignableFrom(var7)) {
               throw new IllegalStateException("AnnotationIntrospector returned Class " + var7.getName() + "; expected Class<JsonSerializer>");
            }

            var6 = var1.a(var2, var7);
            var5 = var6;
            if(var6 instanceof ix) {
               return ((ix)var6).a(var1, var3);
            }
         }
      }

      return var5;
   }

   protected jk a(ju var1, qi var2, mw var3, is var4, boolean var5, jz var6, jk var7) {
      Class var8 = var2.p();
      Object var9;
      if(String[].class == var8) {
         var9 = new py$j(var4);
      } else {
         jk var10 = (jk)c.get(var8.getName());
         var9 = var10;
         if(var10 == null) {
            return new pr(var2.g(), var5, var6, var4, var7);
         }
      }

      return (jk)var9;
   }

   protected jk a(ju var1, qk var2, mw var3, is var4, boolean var5, jz var6, jk var7) {
      Iterator var8 = this.b().iterator();

      jk var9;
      do {
         if(!var8.hasNext()) {
            return null;
         }

         var9 = ((jx)var8.next()).a(var1, (qk)var2, var3, var4, var6, var7);
      } while(var9 == null);

      return var9;
   }

   protected jk a(ju var1, ql var2, mw var3, is var4, boolean var5, jz var6, jk var7) {
      Iterator var8 = this.b().iterator();

      jk var9;
      do {
         if(!var8.hasNext()) {
            Class var11 = var2.p();
            if(EnumSet.class.isAssignableFrom(var11)) {
               return this.a(var1, (sh)var2, var3, var4, var5, var6, var7);
            }

            Class var10 = var2.g().p();
            if(this.a(var11)) {
               if(var10 == String.class) {
                  return new pk(var4);
               }

               return pz.a(var2.g(), var5, var6, var4, var7);
            }

            if(var10 == String.class) {
               return new qd(var4);
            }

            return pz.b(var2.g(), var5, var6, var4, var7);
         }

         var9 = ((jx)var8.next()).a(var1, (ql)var2, var3, var4, var6, var7);
      } while(var9 == null);

      return var9;
   }

   protected jk a(ju var1, qn var2, mw var3, is var4, boolean var5, jk var6, jz var7, jk var8) {
      Iterator var9 = this.b().iterator();

      jk var10;
      do {
         if(!var9.hasNext()) {
            return null;
         }

         var10 = ((jx)var9.next()).a(var1, (qn)var2, var3, var4, var6, var7, var8);
      } while(var10 == null);

      return var10;
   }

   protected jk a(ju var1, qo var2, mw var3, is var4, boolean var5, jk var6, jz var7, jk var8) {
      Iterator var9 = this.b().iterator();

      jk var10;
      do {
         if(!var9.hasNext()) {
            if(EnumMap.class.isAssignableFrom(var2.p())) {
               return this.b(var1, var2, var3, var4, var5, var7, var8);
            }

            return po.a(var1.a().c(var3.c()), var2, var5, var7, var4, var6, var8);
         }

         var10 = ((jx)var9.next()).a(var1, (qo)var2, var3, var4, var6, var7, var8);
      } while(var10 == null);

      return var10;
   }

   public final jk a(ju var1, sh var2, mw var3, is var4, boolean var5) {
      Class var6 = var2.p();
      return (jk)(Iterator.class.isAssignableFrom(var6)?this.c(var1, var2, var3, var4, var5):(Iterable.class.isAssignableFrom(var6)?this.d(var1, var2, var3, var4, var5):(CharSequence.class.isAssignableFrom(var6)?qg.a:null)));
   }

   protected jk a(ju var1, sh var2, mw var3, is var4, boolean var5, jz var6, jk var7) {
      var2 = var2.g();
      sh var8 = var2;
      if(!var2.r()) {
         var8 = null;
      }

      return pz.a(var8, var4);
   }

   public final jk a(sh var1, ju var2, mw var3, is var4, boolean var5) {
      String var7 = var1.p().getName();
      jk var9 = (jk)a.get(var7);
      if(var9 != null) {
         return var9;
      } else {
         Class var8 = (Class)b.get(var7);
         if(var8 != null) {
            try {
               var9 = (jk)var8.newInstance();
               return var9;
            } catch (Exception var6) {
               throw new IllegalStateException("Failed to instantiate standard serializer (of type " + var8.getName() + "): " + var6.getMessage(), var6);
            }
         } else {
            return null;
         }
      }
   }

   protected sh a(ju var1, mm var2, sh var3) {
      Class var5 = var1.a().e(var2);
      sh var4 = var3;
      if(var5 != null) {
         try {
            var4 = var3.h(var5);
         } catch (IllegalArgumentException var6) {
            throw new IllegalArgumentException("Failed to widen type " + var3 + " with concrete-type annotation (value " + var5.getName() + "), method \'" + var2.b() + "\': " + var6.getMessage());
         }
      }

      return b(var1, var2, var4);
   }

   protected boolean a(ju var1, mw var2, jz var3, is var4) {
      if(var3 == null) {
         iq var7 = var1.a();
         kg$b var6 = var7.f((mm)var2.c());
         if(var6 != null) {
            if(var6 == kg$b.b) {
               return true;
            }
         } else if(var1.a(ju$a.h)) {
            return true;
         }

         if(var4 != null) {
            sh var5 = var4.a();
            if(var5.f()) {
               if(var7.b(var4.b(), var4.a()) != null) {
                  return true;
               }

               if(var5 instanceof qo && var7.a((mm)var4.b(), (sh)var4.a()) != null) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   protected boolean a(Class var1) {
      return RandomAccess.class.isAssignableFrom(var1);
   }

   public jk b(ju var1, sh var2, mw var3, is var4, boolean var5) {
      jz var6 = this.b(var1, var2.g(), var4);
      if(var6 != null) {
         var5 = false;
      } else if(!var5) {
         var5 = this.a(var1, var3, var6, var4);
      }

      jk var7 = c(var1, var3.c(), var4);
      if(var2.j()) {
         qn var10 = (qn)var2;
         jk var8 = b(var1, (mm)var3.c(), (is)var4);
         return var10.l()?this.a(var1, (qo)var10, var3, var4, var5, var8, var6, var7):this.a(var1, var10, var3, var4, var5, var8, var6, var7);
      } else if(var2.i()) {
         qk var9 = (qk)var2;
         return var9.a_()?this.a(var1, (ql)var9, var3, var4, var5, var6, var7):this.a(var1, var9, var3, var4, var5, var6, var7);
      } else {
         return var2.b()?this.a(var1, (qi)var2, var3, var4, var5, var6, var7):null;
      }
   }

   protected jk b(ju var1, sh var2, mw var3, is var4, boolean var5, jz var6, jk var7) {
      sh var8 = var2.k();
      rb var9 = null;
      if(var8.r()) {
         var9 = rb.a(var8.p(), var1.a());
      }

      return new ph(var2.g(), var5, var9, var6, var4, var7);
   }

   public final jk b(sh var1, ju var2, mw var3, is var4, boolean var5) {
      Class var6 = var1.p();
      Object var8;
      if(ji.class.isAssignableFrom(var6)) {
         if(!jj.class.isAssignableFrom(var6)) {
            return pu.a;
         }

         var8 = pv.a;
      } else {
         mr var7 = var3.e();
         if(var7 != null) {
            Method var9 = var7.e();
            if(var2.a(ju$a.e)) {
               qy.a((Member)var9);
            }

            return new pn(var9, this.a(var2, var7, (is)var4), var4);
         }

         if(InetAddress.class.isAssignableFrom(var6)) {
            return pl.a;
         }

         if(TimeZone.class.isAssignableFrom(var6)) {
            return qf.a;
         }

         if(Charset.class.isAssignableFrom(var6)) {
            return qg.a;
         }

         jk var10 = this.d.a(var2, var1);
         var8 = var10;
         if(var10 == null) {
            if(Number.class.isAssignableFrom(var6)) {
               return os$g.a;
            }

            if(Enum.class.isAssignableFrom(var6)) {
               return pi.a(var6, var2, var3);
            }

            if(Calendar.class.isAssignableFrom(var6)) {
               return pd.a;
            }

            if(Date.class.isAssignableFrom(var6)) {
               return pg.a;
            }

            return null;
         }
      }

      return (jk)var8;
   }

   public jz b(ju var1, sh var2, is var3) {
      mn var4 = ((mw)var1.c(var2.p())).c();
      iq var6 = var1.a();
      ni var5 = var6.a((jn)var1, (mn)var4, (sh)var2);
      Collection var7;
      if(var5 == null) {
         var5 = var1.d(var2);
         var7 = null;
      } else {
         var7 = var1.l().a((mn)var4, var1, var6);
      }

      return var5 == null?null:var5.a(var1, var2, var7, var3);
   }

   protected abstract Iterable b();

   protected jk c(ju var1, sh var2, mw var3, is var4, boolean var5) {
      sh var6 = var2.b(0);
      var2 = var6;
      if(var6 == null) {
         var2 = qs.b();
      }

      jz var7 = this.b(var1, var2, var4);
      return pz.a(var2, this.a(var1, var3, var7, var4), var7, var4);
   }

   protected jk d(ju var1, sh var2, mw var3, is var4, boolean var5) {
      sh var6 = var2.b(0);
      var2 = var6;
      if(var6 == null) {
         var2 = qs.b();
      }

      jz var7 = this.b(var1, var2, var4);
      return pz.b(var2, this.a(var1, var3, var7, var4), var7, var4);
   }
}
