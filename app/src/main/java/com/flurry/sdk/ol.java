package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.iq$a;
import com.flurry.sdk.is;
import com.flurry.sdk.is$a;
import com.flurry.sdk.it;
import com.flurry.sdk.jk;
import com.flurry.sdk.jn;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jv;
import com.flurry.sdk.jv$a;
import com.flurry.sdk.jx;
import com.flurry.sdk.jz;
import com.flurry.sdk.mm;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mw;
import com.flurry.sdk.ni;
import com.flurry.sdk.of;
import com.flurry.sdk.og;
import com.flurry.sdk.oi;
import com.flurry.sdk.ok;
import com.flurry.sdk.ol$a;
import com.flurry.sdk.om;
import com.flurry.sdk.oo;
import com.flurry.sdk.op;
import com.flurry.sdk.po;
import com.flurry.sdk.qr;
import com.flurry.sdk.qw;
import com.flurry.sdk.qy;
import com.flurry.sdk.sh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ol extends og {
   public static final ol e = new ol((jv$a)null);
   protected final jv$a f;

   protected ol(jv$a var1) {
      Object var2 = var1;
      if(var1 == null) {
         var2 = new ol$a();
      }

      this.f = (jv$a)var2;
   }

   protected jk a(ju var1, mw var2, is var3) {
      if(var2.b() == Object.class) {
         throw new IllegalArgumentException("Can not create bean serializer for Object.class");
      } else {
         ok var5 = this.a(var2);
         List var6 = this.c(var1, var2);
         Object var4 = var6;
         if(var6 == null) {
            var4 = new ArrayList();
         }

         Iterator var7;
         Object var12;
         if(this.f.b()) {
            var7 = this.f.e().iterator();

            while(true) {
               var12 = var4;
               if(!var7.hasNext()) {
                  break;
               }

               var4 = ((om)var7.next()).a(var1, var2, (List)var4);
            }
         } else {
            var12 = var4;
         }

         List var11 = this.b(var1, var2, this.a(var1, (mw)var2, (List)var12));
         if(this.f.b()) {
            var7 = this.f.e().iterator();

            while(true) {
               var6 = var11;
               if(!var7.hasNext()) {
                  break;
               }

               var11 = ((om)var7.next()).b(var1, var2, var11);
            }
         } else {
            var6 = var11;
         }

         var5.a(var6);
         var5.a(this.b(var1, var2));
         mr var13 = var2.p();
         if(var13 != null) {
            if(var1.a(ju$a.e)) {
               var13.k();
            }

            sh var15 = var13.a(var2.j());
            var5.a(new of(var13, po.a((String[])null, var15, var1.a(ju$a.h), this.b(var1, var15.g(), var3), var3, (jk)null, (jk)null)));
         }

         this.a(var1, var5);
         ok var14;
         if(this.f.b()) {
            Iterator var16 = this.f.e().iterator();
            ok var9 = var5;

            while(true) {
               var14 = var9;
               if(!var16.hasNext()) {
                  break;
               }

               var9 = ((om)var16.next()).a(var1, var2, var9);
            }
         } else {
            var14 = var5;
         }

         jk var10 = var14.b();
         Object var8 = var10;
         if(var10 == null) {
            var8 = var10;
            if(var2.h()) {
               var8 = var14.c();
            }
         }

         return (jk)var8;
      }
   }

   public jk a(ju var1, sh var2, is var3) {
      mw var6 = (mw)var1.b(var2);
      jk var5 = this.a(var1, (mm)var6.c(), (is)var3);
      jk var8;
      if(var5 != null) {
         var8 = var5;
      } else {
         sh var7 = this.a(var1, (mm)var6.c(), (sh)var2);
         boolean var4;
         if(var7 != var2) {
            var4 = true;
         } else {
            var4 = false;
         }

         if(var2.f()) {
            return this.b(var1, var7, var6, var3, var4);
         }

         Iterator var9 = this.f.c().iterator();

         while(var9.hasNext()) {
            var5 = ((jx)var9.next()).a(var1, var7, var6, var3);
            if(var5 != null) {
               return var5;
            }
         }

         var5 = this.a(var7, var1, var6, var3, var4);
         var8 = var5;
         if(var5 == null) {
            var5 = this.b(var7, var1, var6, var3, var4);
            var8 = var5;
            if(var5 == null) {
               var5 = this.a(var1, var7, var6, var3);
               var8 = var5;
               if(var5 == null) {
                  return this.a(var1, var7, var6, var3, var4);
               }
            }
         }
      }

      return var8;
   }

   public jk a(ju var1, sh var2, mw var3, is var4) {
      jk var7;
      if(!this.b(var2.p())) {
         var7 = null;
      } else {
         jk var6 = this.a(var1, var3, var4);
         if(!this.f.b()) {
            return var6;
         }

         Iterator var5 = this.f.e().iterator();

         while(true) {
            var7 = var6;
            if(!var5.hasNext()) {
               break;
            }

            var6 = ((om)var5.next()).a(var1, var3, var6);
         }
      }

      return var7;
   }

   public jv$a a() {
      return this.f;
   }

   public jv a(jv$a var1) {
      if(this.f == var1) {
         return this;
      } else if(this.getClass() != ol.class) {
         throw new IllegalStateException("Subtype of BeanSerializerFactory (" + this.getClass().getName() + ") has not properly overridden method \'withAdditionalSerializers\': can not instantiate subtype with additional serializer definitions");
      } else {
         return new ol(var1);
      }
   }

   public jz a(sh var1, ju var2, mq var3, is var4) {
      iq var5 = var2.a();
      ni var6 = var5.a((jn)var2, (mq)var3, (sh)var1);
      return var6 == null?this.b(var2, var1, var4):var6.a(var2, var1, var2.l().a((mq)var3, var2, var5), var4);
   }

   protected oi a(ju var1, qr var2, op var3, boolean var4, String var5, mq var6) {
      if(var1.a(ju$a.e)) {
         var6.k();
      }

      sh var7 = var6.a(var2);
      is$a var8 = new is$a(var5, var7, var3.a(), var6);
      jk var9 = this.a(var1, (mm)var6, (is)var8);
      jz var10 = null;
      if(qy.e(var7.p())) {
         var10 = this.b(var7, var1, var6, var8);
      }

      oi var11 = var3.a(var5, var7, var9, this.a((sh)var7, (ju)var1, (mq)var6, var8), var10, var6, var4);
      var11.a(var1.a().g((mm)var6));
      return var11;
   }

   protected oi a(oi var1, Class[] var2) {
      return oo.a(var1, var2);
   }

   protected ok a(mw var1) {
      return new ok(var1);
   }

   protected op a(ju var1, mw var2) {
      return new op(var1, var2);
   }

   protected List a(ju var1, mw var2, List var3) {
      String[] var4 = var1.a().c(var2.c());
      if(var4 != null && var4.length > 0) {
         HashSet var5 = qw.a(var4);
         Iterator var6 = var3.iterator();

         while(var6.hasNext()) {
            if(var5.contains(((oi)var6.next()).d())) {
               var6.remove();
            }
         }
      }

      return var3;
   }

   protected void a(ju var1, ok var2) {
      List var8 = var2.a();
      boolean var7 = var1.a(ju$a.i);
      int var6 = var8.size();
      oi[] var11 = new oi[var6];
      int var5 = 0;

      int var3;
      for(var3 = 0; var5 < var6; ++var5) {
         oi var9 = (oi)var8.get(var5);
         Class[] var10 = var9.h();
         int var4;
         if(var10 == null) {
            var4 = var3;
            if(var7) {
               var11[var5] = var9;
               continue;
            }
         } else {
            var4 = var3 + 1;
            var11[var5] = this.a(var9, var10);
         }

         var3 = var4;
      }

      if(!var7 || var3 != 0) {
         var2.a(var11);
      }
   }

   public jz b(sh var1, ju var2, mq var3, is var4) {
      sh var5 = var1.g();
      iq var6 = var2.a();
      ni var7 = var6.b((jn)var2, (mq)var3, (sh)var1);
      return var7 == null?this.b(var2, var5, var4):var7.a(var2, var5, var2.l().a((mq)var3, var2, var6), var4);
   }

   protected Iterable b() {
      return this.f.c();
   }

   protected Object b(ju var1, mw var2) {
      return var1.a().f(var2.c());
   }

   @Deprecated
   protected List b(ju var1, mw var2, List var3) {
      return var3;
   }

   protected boolean b(Class var1) {
      return qy.a(var1) == null && !qy.c(var1);
   }

   public jk c(ju var1, sh var2, is var3) {
      jk var4 = null;
      jk var5 = null;
      if(!this.f.a()) {
         var4 = var5;
      } else {
         mw var6 = (mw)var1.c(var2.p());

         for(Iterator var7 = this.f.d().iterator(); var7.hasNext(); var4 = var5) {
            var5 = ((jx)var7.next()).a(var1, var2, var6, var3);
            var4 = var5;
            if(var5 != null) {
               break;
            }
         }
      }

      return var4;
   }

   protected List c(ju var1, mw var2) {
      List var7 = var2.d();
      iq var4 = var1.a();
      this.c(var1, var2, var7);
      if(var1.a(ju$a.f)) {
         this.d(var1, var2, var7);
      }

      if(var7.isEmpty()) {
         return null;
      } else {
         boolean var3 = this.a((ju)var1, (mw)var2, (jz)null, (is)null);
         op var5 = this.a(var1, var2);
         ArrayList var6 = new ArrayList(var7.size());
         qr var11 = var2.j();
         Iterator var12 = var7.iterator();

         while(true) {
            mq var8;
            it var9;
            iq$a var10;
            do {
               if(!var12.hasNext()) {
                  return var6;
               }

               var9 = (it)var12.next();
               var8 = var9.j();
               var10 = var4.a(var8);
            } while(var10 != null && var10.c());

            String var13 = var9.a();
            if(var8 instanceof mr) {
               var6.add(this.a(var1, var11, var5, var3, var13, (mr)var8));
            } else {
               var6.add(this.a(var1, var11, var5, var3, var13, (mp)var8));
            }
         }
      }
   }

   protected void c(ju var1, mw var2, List var3) {
      iq var4 = var1.a();
      HashMap var5 = new HashMap();
      Iterator var6 = var3.iterator();

      while(var6.hasNext()) {
         mq var8 = ((it)var6.next()).j();
         if(var8 == null) {
            var6.remove();
         } else {
            Class var7 = var8.d();
            Boolean var10 = (Boolean)var5.get(var7);
            Boolean var9 = var10;
            if(var10 == null) {
               var10 = var4.e(((mw)var1.c(var7)).c());
               var9 = var10;
               if(var10 == null) {
                  var9 = Boolean.FALSE;
               }

               var5.put(var7, var9);
            }

            if(var9.booleanValue()) {
               var6.remove();
            }
         }
      }

   }

   protected void d(ju var1, mw var2, List var3) {
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         if(!((it)var4.next()).f()) {
            var4.remove();
         }
      }

   }
}
