package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonAutoDetect$Visibility;
import com.flurry.sdk.iq;
import com.flurry.sdk.ir;
import com.flurry.sdk.iu;
import com.flurry.sdk.je;
import com.flurry.sdk.jk;
import com.flurry.sdk.jn;
import com.flurry.sdk.jn$a;
import com.flurry.sdk.jn$b;
import com.flurry.sdk.jn$c;
import com.flurry.sdk.jr;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.kg$a;
import com.flurry.sdk.mm;
import com.flurry.sdk.ne;
import com.flurry.sdk.ng;
import com.flurry.sdk.on;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.sh;
import java.util.HashMap;

public class ju extends jn$c {
   protected kg$a a;
   protected Class b;
   protected on c;

   public ju(iu var1, iq var2, ne var3, ng var4, jr var5, qs var6, je var7) {
      super(var1, var2, var3, var4, var5, var6, var7, d(ju$a.class));
      this.a = null;
      this.c = null;
   }

   protected ju(ju var1, jn$a var2) {
      super(var1, var2, var1.h);
      this.a = null;
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
   }

   protected ju(ju var1, HashMap var2, ng var3) {
      this(var1, var1.e);
      this.f = var2;
      this.h = var3;
   }

   public iq a() {
      return this.a(ju$a.a)?super.a():iq.a();
   }

   public ir a(sh var1) {
      return this.i().a((jn)this, var1, this);
   }

   public jk a(mm var1, Class var2) {
      je var3 = this.k();
      if(var3 != null) {
         jk var4 = var3.a(this, var1, var2);
         if(var4 != null) {
            return var4;
         }
      }

      return (jk)qy.b(var2, this.c());
   }

   public ju a(ng var1) {
      HashMap var2 = this.f;
      this.g = true;
      return new ju(this, var2, var1);
   }

   // $FF: synthetic method
   public void a(jn$b var1) {
      this.c((ju$a)var1);
   }

   @Deprecated
   public void a(ju$a var1, boolean var2) {
      super.a(var1, var2);
   }

   public boolean a(ju$a var1) {
      return (this.i & var1.b()) != 0;
   }

   public ir b(sh var1) {
      return this.i().a((ju)this, var1, this);
   }

   @Deprecated
   public void b(ju$a var1) {
      super.b(var1);
   }

   public boolean b() {
      return this.a(ju$a.a);
   }

   @Deprecated
   public void c(ju$a var1) {
      super.a(var1);
   }

   public boolean c() {
      return this.a(ju$a.e);
   }

   public boolean d() {
      return this.a(ju$a.l);
   }

   public ne e() {
      ne var2 = super.e();
      ne var1 = var2;
      if(!this.a(ju$a.b)) {
         var1 = var2.a(JsonAutoDetect$Visibility.NONE);
      }

      var2 = var1;
      if(!this.a(ju$a.c)) {
         var2 = var1.b(JsonAutoDetect$Visibility.NONE);
      }

      var1 = var2;
      if(!this.a(ju$a.d)) {
         var1 = var2.e(JsonAutoDetect$Visibility.NONE);
      }

      return var1;
   }

   public Class f() {
      return this.b;
   }

   public kg$a g() {
      return this.a != null?this.a:(this.a(ju$a.g)?kg$a.a:kg$a.b);
   }

   public on h() {
      return this.c;
   }

   public String toString() {
      return "[SerializationConfig: flags=0x" + Integer.toHexString(this.i) + "]";
   }
}
