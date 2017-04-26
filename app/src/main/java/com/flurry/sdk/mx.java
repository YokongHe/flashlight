package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.ir;
import com.flurry.sdk.iu;
import com.flurry.sdk.iu$a;
import com.flurry.sdk.iy;
import com.flurry.sdk.jn;
import com.flurry.sdk.ju;
import com.flurry.sdk.mn;
import com.flurry.sdk.mw;
import com.flurry.sdk.mx$a;
import com.flurry.sdk.mx$b;
import com.flurry.sdk.mx$c;
import com.flurry.sdk.mx$d;
import com.flurry.sdk.na;
import com.flurry.sdk.nc;
import com.flurry.sdk.qp;
import com.flurry.sdk.sh;

public class mx extends iu {
   protected static final mw a;
   protected static final mw b;
   protected static final mw c;
   protected static final mw d;
   @Deprecated
   public static final mx$a e;
   @Deprecated
   public static final mx$d f;
   @Deprecated
   public static final mx$c g;
   protected static final na h;
   public static final mx i;

   static {
      mn var0 = mn.b(String.class, (iq)null, (iu$a)null);
      a = mw.a((jn)null, qp.d(String.class), var0);
      var0 = mn.b(Boolean.TYPE, (iq)null, (iu$a)null);
      b = mw.a((jn)null, qp.d(Boolean.TYPE), var0);
      var0 = mn.b(Integer.TYPE, (iq)null, (iu$a)null);
      c = mw.a((jn)null, qp.d(Integer.TYPE), var0);
      var0 = mn.b(Long.TYPE, (iq)null, (iu$a)null);
      d = mw.a((jn)null, qp.d(Long.TYPE), var0);
      e = new mx$a(null);
      f = new mx$d();
      g = new mx$c();
      h = new mx$b(null);
      i = new mx();
   }

   // $FF: synthetic method
   public ir a(iy var1, sh var2, iu$a var3) {
      return this.c(var1, var2, var3);
   }

   // $FF: synthetic method
   public ir a(jn var1, sh var2, iu$a var3) {
      return this.b(var1, var2, var3);
   }

   // $FF: synthetic method
   public ir a(ju var1, sh var2, iu$a var3) {
      return this.b(var1, var2, var3);
   }

   protected mw a(sh var1) {
      Class var2 = var1.p();
      return var2 == String.class?a:(var2 == Boolean.TYPE?b:(var2 == Integer.TYPE?c:(var2 == Long.TYPE?d:null)));
   }

   protected nc a(jn var1, mn var2, sh var3, boolean var4) {
      return new nc(var1, var4, var3, var2);
   }

   public nc a(jn var1, sh var2, iu$a var3, boolean var4) {
      mn var5 = this.c(var1, var2, var3);
      var5.a(h);
      var5.n();
      return this.a(var1, var5, var2, var4).k();
   }

   // $FF: synthetic method
   public ir b(iy var1, sh var2, iu$a var3) {
      return this.d(var1, var2, var3);
   }

   public mw b(jn var1, sh var2, iu$a var3) {
      boolean var4 = var1.b();
      iq var5 = var1.a();
      Class var6 = var2.p();
      if(!var4) {
         var5 = null;
      }

      return mw.a(var1, var2, mn.a(var6, var5, var3));
   }

   public mw b(ju var1, sh var2, iu$a var3) {
      mw var5 = this.a(var2);
      mw var4 = var5;
      if(var5 == null) {
         var4 = mw.b(this.a(var1, (sh)var2, (iu$a)var3, true));
      }

      return var4;
   }

   public mn c(jn var1, sh var2, iu$a var3) {
      boolean var4 = var1.b();
      iq var5 = var1.a();
      Class var6 = var2.p();
      if(!var4) {
         var5 = null;
      }

      mn var7 = mn.a(var6, var5, var3);
      var7.a(h);
      var7.a(true);
      return var7;
   }

   public mw c(iy var1, sh var2, iu$a var3) {
      mw var5 = this.a(var2);
      mw var4 = var5;
      if(var5 == null) {
         var4 = mw.a(this.a(var1, (sh)var2, (iu$a)var3, false));
      }

      return var4;
   }

   public mw d(iy var1, sh var2, iu$a var3) {
      mw var5 = this.a(var2);
      mw var4 = var5;
      if(var5 == null) {
         var4 = mw.a(this.a(var1, (sh)var2, (iu$a)var3, false));
      }

      return var4;
   }
}
