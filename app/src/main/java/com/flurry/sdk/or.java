package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.hg;
import com.flurry.sdk.is;
import com.flurry.sdk.ix;
import com.flurry.sdk.jh;
import com.flurry.sdk.jk;
import com.flurry.sdk.jt;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jv;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.or$a;
import com.flurry.sdk.ot;
import com.flurry.sdk.ow;
import com.flurry.sdk.ox;
import com.flurry.sdk.oy;
import com.flurry.sdk.pq;
import com.flurry.sdk.qb;
import com.flurry.sdk.qc;
import com.flurry.sdk.rh;
import com.flurry.sdk.sh;
import java.text.DateFormat;
import java.util.Date;

public class or extends jw {
   public static final jk d = new ot("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
   @Deprecated
   public static final jk e = new qb();
   public static final jk f = new oy();
   protected final jv g;
   protected final ox h;
   protected final rh i;
   protected jk j;
   protected jk k;
   protected jk l;
   protected jk m;
   protected final ow n;
   protected DateFormat o;

   public or() {
      super((ju)null);
      this.j = f;
      this.l = pq.a;
      this.m = d;
      this.g = null;
      this.h = new ox();
      this.n = null;
      this.i = new rh();
   }

   protected or(ju var1, or var2, jv var3) {
      super(var1);
      this.j = f;
      this.l = pq.a;
      this.m = d;
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.g = var3;
         this.h = var2.h;
         this.j = var2.j;
         this.k = var2.k;
         this.l = var2.l;
         this.m = var2.m;
         this.i = var2.i;
         this.n = this.h.a();
      }
   }

   protected jk a(jk var1, is var2) {
      if(!(var1 instanceof ix)) {
         return var1;
      } else {
         jk var3 = ((ix)var1).a(this.b, var2);
         if(var3 != var1) {
            var1 = var3;
            if(var3 instanceof jt) {
               ((jt)var3).a(this);
               var1 = var3;
            }
         }

         return var1;
      }
   }

   public jk a(sh var1, is var2) {
      jk var4 = this.n.b(var1);
      jk var3 = var4;
      if(var4 == null) {
         var4 = this.h.a(var1);
         var3 = var4;
         if(var4 == null) {
            var4 = this.c(var1, var2);
            var3 = var4;
            if(var4 == null) {
               return this.a(var1.p());
            }
         }
      }

      return this.a(var3, var2);
   }

   public jk a(sh var1, boolean var2, is var3) {
      Object var4 = this.n.a(var1);
      if(var4 == null) {
         jk var5 = this.h.b(var1);
         var4 = var5;
         if(var5 == null) {
            jk var8 = this.a(var1, var3);
            jz var6 = this.g.b(this.b, var1, var3);
            Object var7;
            if(var6 != null) {
               var7 = new or$a(var6, var8);
            } else {
               var7 = var8;
            }

            var4 = var7;
            if(var2) {
               this.h.a((sh)var1, (jk)var7);
               return (jk)var7;
            }
         }
      }

      return (jk)var4;
   }

   public jk a(Class var1) {
      return this.j;
   }

   public jk a(Class var1, is var2) {
      jk var4 = this.n.b(var1);
      jk var3 = var4;
      if(var4 == null) {
         var4 = this.h.a(var1);
         var3 = var4;
         if(var4 == null) {
            var4 = this.h.a(this.b.b((Class)var1));
            var3 = var4;
            if(var4 == null) {
               var4 = this.b(var1, var2);
               var3 = var4;
               if(var4 == null) {
                  return this.a(var1);
               }
            }
         }
      }

      return this.a(var3, var2);
   }

   public jk a(Class var1, boolean var2, is var3) {
      Object var4 = this.n.a(var1);
      if(var4 == null) {
         jk var5 = this.h.b(var1);
         var4 = var5;
         if(var5 == null) {
            jk var8 = this.a(var1, var3);
            jz var6 = this.g.b(this.b, this.b.b((Class)var1), var3);
            Object var7;
            if(var6 != null) {
               var7 = new or$a(var6, var8);
            } else {
               var7 = var8;
            }

            var4 = var7;
            if(var2) {
               this.h.a((Class)var1, (jk)var7);
               return (jk)var7;
            }
         }
      }

      return (jk)var4;
   }

   protected or a(ju var1, jv var2) {
      return new or(var1, this, var2);
   }

   public final void a(long var1, hf var3) {
      if(this.a(ju$a.q)) {
         var3.a(var1);
      } else {
         if(this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
         }

         var3.b(this.o.format(new Date(var1)));
      }
   }

   protected void a(hf param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(ju var1, hf var2, Object var3, jv var4) {
      if(var4 == null) {
         throw new IllegalArgumentException("Can not pass null serializerFactory");
      } else {
         or var5 = this.a(var1, var4);
         if(var5.getClass() != this.getClass()) {
            throw new IllegalStateException("Broken serializer provider: createInstance returned instance of type " + var5.getClass() + "; blueprint of type " + this.getClass());
         } else {
            var5.a(var2, var3);
         }
      }
   }

   public final void a(Date var1, hf var2) {
      if(this.a(ju$a.q)) {
         var2.a(var1.getTime());
      } else {
         if(this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
         }

         var2.b(this.o.format(var1));
      }
   }

   public jk b(sh var1, is var2) {
      jk var4 = this.g.c(this.b, var1, var2);
      jk var3 = var4;
      if(var4 == null) {
         if(this.k == null) {
            var3 = qc.a(var1);
         } else {
            var3 = this.k;
         }
      }

      jk var5 = var3;
      if(var3 instanceof ix) {
         var5 = ((ix)var3).a(this.b, var2);
      }

      return var5;
   }

   protected jk b(Class var1, is var2) {
      jk var4;
      try {
         var4 = this.d(this.b.b((Class)var1), var2);
      } catch (IllegalArgumentException var3) {
         throw new jh(var3.getMessage(), (hg)null, var3);
      }

      if(var4 != null) {
         this.h.a((Class)var1, var4, this);
      }

      return var4;
   }

   public void b(long var1, hf var3) {
      if(this.a(ju$a.r)) {
         var3.a(String.valueOf(var1));
      } else {
         if(this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
         }

         var3.a(this.o.format(new Date(var1)));
      }
   }

   public void b(Date var1, hf var2) {
      if(this.a(ju$a.r)) {
         var2.a(String.valueOf(var1.getTime()));
      } else {
         if(this.o == null) {
            this.o = (DateFormat)this.b.n().clone();
         }

         var2.a(this.o.format(var1));
      }
   }

   public jk c() {
      return this.m;
   }

   protected jk c(sh var1, is var2) {
      jk var4;
      try {
         var4 = this.d(var1, var2);
      } catch (IllegalArgumentException var3) {
         throw new jh(var3.getMessage(), (hg)null, var3);
      }

      if(var4 != null) {
         this.h.a((sh)var1, var4, this);
      }

      return var4;
   }

   public jk d() {
      return this.l;
   }

   protected jk d(sh var1, is var2) {
      return this.g.a(this.b, var1, var2);
   }
}
