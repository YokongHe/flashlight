package com.flurry.sdk;

import com.flurry.sdk.jv$a;
import com.flurry.sdk.jx;
import com.flurry.sdk.om;
import com.flurry.sdk.qw;

public class ol$a extends jv$a {
   protected static final jx[] a = new jx[0];
   protected static final om[] b = new om[0];
   protected final jx[] c;
   protected final jx[] d;
   protected final om[] e;

   public ol$a() {
      this((jx[])null, (jx[])null, (om[])null);
   }

   protected ol$a(jx[] var1, jx[] var2, om[] var3) {
      jx[] var4 = var1;
      if(var1 == null) {
         var4 = a;
      }

      this.c = var4;
      var1 = var2;
      if(var2 == null) {
         var1 = a;
      }

      this.d = var1;
      om[] var5 = var3;
      if(var3 == null) {
         var5 = b;
      }

      this.e = var5;
   }

   public jv$a a(jx var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null Serializers");
      } else {
         return new ol$a((jx[])qw.a(this.c, var1), this.d, this.e);
      }
   }

   public boolean a() {
      return this.d.length > 0;
   }

   public jv$a b(jx var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null Serializers");
      } else {
         jx[] var2 = (jx[])qw.a(this.d, var1);
         return new ol$a(this.c, var2, this.e);
      }
   }

   public boolean b() {
      return this.e.length > 0;
   }

   public Iterable c() {
      return qw.b(this.c);
   }

   public Iterable d() {
      return qw.b(this.d);
   }

   public Iterable e() {
      return qw.b(this.e);
   }
}
