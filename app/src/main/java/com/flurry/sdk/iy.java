package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import com.flurry.sdk.ha;
import com.flurry.sdk.hb;
import com.flurry.sdk.iq;
import com.flurry.sdk.ir;
import com.flurry.sdk.iu;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.je;
import com.flurry.sdk.jg;
import com.flurry.sdk.jl;
import com.flurry.sdk.jn;
import com.flurry.sdk.jn$a;
import com.flurry.sdk.jn$b;
import com.flurry.sdk.jn$c;
import com.flurry.sdk.jr;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.kx;
import com.flurry.sdk.mm;
import com.flurry.sdk.nb;
import com.flurry.sdk.ne;
import com.flurry.sdk.ng;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.rd;
import com.flurry.sdk.rs;
import com.flurry.sdk.sh;
import java.util.HashMap;

public class iy extends jn$c {
   protected rd a;
   protected final rs b;
   protected boolean c;

   public iy(iu var1, iq var2, ne var3, ng var4, jr var5, qs var6, je var7) {
      super(var1, var2, var3, var4, var5, var6, var7, d(iy$a.class));
      this.b = rs.a;
   }

   protected iy(iy var1, jn$a var2) {
      super(var1, var2, var1.h);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
   }

   private iy(iy var1, HashMap var2, ng var3) {
      this(var1, var1.e);
      this.f = var2;
      this.h = var3;
   }

   public iq a() {
      return (iq)(this.a(iy$a.a)?super.a():nb.a);
   }

   public ir a(sh var1) {
      return this.i().a((jn)this, var1, this);
   }

   protected iy a(int var1) {
      boolean var2;
      if((ju$a.l.b() & var1) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.c = var2;
      return this;
   }

   public iy a(ng var1) {
      HashMap var2 = this.f;
      this.g = true;
      return new iy(this, var2, var1);
   }

   public jg a(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         jg var4 = var3.a(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (jg)qy.b(var2, this.c());
   }

   @Deprecated
   public void a(iy$a var1, boolean var2) {
      super.a(var1, var2);
   }

   // $FF: synthetic method
   public void a(jn$b var1) {
      this.c((iy$a)var1);
   }

   public boolean a(iy$a var1) {
      return (this.i & var1.b()) != 0;
   }

   public ir b(sh var1) {
      return this.i().a((iy)this, var1, this);
   }

   public jl b(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         jl var4 = var3.b(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (jl)qy.b(var2, this.c());
   }

   @Deprecated
   public void b(iy$a var1) {
      super.b(var1);
   }

   public boolean b() {
      return this.a(iy$a.a);
   }

   public ir c(sh var1) {
      return this.i().b(this, var1, this);
   }

   public kx c(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         kx var4 = var3.c(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (kx)qy.b(var2, this.c());
   }

   @Deprecated
   public void c(iy$a var1) {
      super.a(var1);
   }

   public boolean c() {
      return this.a(iy$a.f);
   }

   public boolean d() {
      return this.c;
   }

   public ne e() {
      ne var2 = super.e();
      ne var1 = var2;
      if(!this.a(iy$a.b)) {
         var1 = var2.c(JsonAutoDetect$Visibility.NONE);
      }

      var2 = var1;
      if(!this.a(iy$a.c)) {
         var2 = var1.d(JsonAutoDetect$Visibility.NONE);
      }

      var1 = var2;
      if(!this.a(iy$a.d)) {
         var1 = var2.e(JsonAutoDetect$Visibility.NONE);
      }

      return var1;
   }

   public rd f() {
      return this.a;
   }

   public ha g() {
      return hb.a();
   }

   public final rs h() {
      return this.b;
   }
}
