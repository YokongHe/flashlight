package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.ir;
import com.flurry.sdk.iu;
import com.flurry.sdk.iu$a;
import com.flurry.sdk.je;
import com.flurry.sdk.jn$a;
import com.flurry.sdk.jr;
import com.flurry.sdk.mm;
import com.flurry.sdk.ne;
import com.flurry.sdk.ng;
import com.flurry.sdk.nh;
import com.flurry.sdk.ni;
import com.flurry.sdk.nt;
import com.flurry.sdk.qj;
import com.flurry.sdk.qr;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.ri;
import com.flurry.sdk.sh;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.util.HashMap;

public abstract class jn implements iu$a {
   protected static final DateFormat d;
   protected jn$a e;
   protected HashMap f;
   protected boolean g;
   protected ng h;

   static {
      d = ri.f;
   }

   protected jn(iu var1, iq var2, ne var3, ng var4, jr var5, qs var6, je var7) {
      this.e = new jn$a(var1, var2, var3, var5, var6, (ni)null, d, var7);
      this.h = var4;
      this.g = true;
   }

   protected jn(jn var1, jn$a var2, ng var3) {
      this.e = var2;
      this.h = var3;
      this.g = true;
      this.f = var1.f;
   }

   public iq a() {
      return this.e.b();
   }

   public abstract ir a(sh var1);

   public sh a(sh var1, Class var2) {
      return this.m().a(var1, var2);
   }

   public final Class a(Class var1) {
      return this.f == null?null:(Class)this.f.get(new qj(var1));
   }

   public final void a(Class var1, Class var2) {
      if(this.f == null) {
         this.g = false;
         this.f = new HashMap();
      } else if(this.g) {
         this.g = false;
         this.f = new HashMap(this.f);
      }

      this.f.put(new qj(var1), var2);
   }

   public final sh b(Class var1) {
      return this.m().a((Type)var1, (qr)null);
   }

   public abstract boolean b();

   public ir c(Class var1) {
      return this.a(this.b(var1));
   }

   public abstract boolean c();

   public ni d(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         ni var4 = var3.a(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (ni)qy.b(var2, this.c());
   }

   public final ni d(sh var1) {
      return this.e.f();
   }

   public abstract boolean d();

   public ne e() {
      return this.e.c();
   }

   public nh e(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         nh var4 = var3.b(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (nh)qy.b(var2, this.c());
   }

   public iu i() {
      return this.e.a();
   }

   public final jr j() {
      return this.e.d();
   }

   public final je k() {
      return this.e.h();
   }

   public final ng l() {
      if(this.h == null) {
         this.h = new nt();
      }

      return this.h;
   }

   public final qs m() {
      return this.e.e();
   }

   public final DateFormat n() {
      return this.e.g();
   }
}
