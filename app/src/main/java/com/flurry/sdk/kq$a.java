package com.flurry.sdk;

import com.flurry.sdk.ip;
import com.flurry.sdk.jb$a;
import com.flurry.sdk.jd;
import com.flurry.sdk.jm;
import com.flurry.sdk.kq;
import com.flurry.sdk.kr;
import com.flurry.sdk.ky;
import com.flurry.sdk.qw;

public class kq$a extends jb$a {
   protected static final jm[] a = new jm[0];
   protected static final kr[] b = new kr[0];
   protected static final ip[] c = new ip[0];
   protected static final ky[] d = new ky[0];
   protected final jd[] e;
   protected final jm[] f;
   protected final kr[] g;
   protected final ip[] h;
   protected final ky[] i;

   public kq$a() {
      this((jd[])null, (jm[])null, (kr[])null, (ip[])null, (ky[])null);
   }

   protected kq$a(jd[] var1, jm[] var2, kr[] var3, ip[] var4, ky[] var5) {
      jd[] var6 = var1;
      if(var1 == null) {
         var6 = kq.b();
      }

      this.e = var6;
      jm[] var7 = var2;
      if(var2 == null) {
         var7 = a;
      }

      this.f = var7;
      kr[] var8 = var3;
      if(var3 == null) {
         var8 = b;
      }

      this.g = var8;
      ip[] var9 = var4;
      if(var4 == null) {
         var9 = c;
      }

      this.h = var9;
      ky[] var10 = var5;
      if(var5 == null) {
         var10 = d;
      }

      this.i = var10;
   }

   public jb$a a(ip var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null resolver");
      } else {
         ip[] var2 = (ip[])qw.a(this.h, var1);
         return new kq$a(this.e, this.f, this.g, var2, this.i);
      }
   }

   public jb$a a(jd var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null Deserializers");
      } else {
         return new kq$a((jd[])qw.a(this.e, var1), this.f, this.g, this.h, this.i);
      }
   }

   public jb$a a(jm var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null KeyDeserializers");
      } else {
         jm[] var2 = (jm[])qw.a(this.f, var1);
         return new kq$a(this.e, var2, this.g, this.h, this.i);
      }
   }

   public jb$a a(ky var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Can not pass null resolver");
      } else {
         ky[] var2 = (ky[])qw.a(this.i, var1);
         return new kq$a(this.e, this.f, this.g, this.h, var2);
      }
   }

   public Iterable a() {
      return qw.b(this.e);
   }

   public Iterable b() {
      return qw.b(this.f);
   }

   public Iterable c() {
      return qw.b(this.g);
   }

   public Iterable d() {
      return qw.b(this.h);
   }

   public Iterable e() {
      return qw.b(this.i);
   }

   public boolean f() {
      return this.f.length > 0;
   }

   public boolean g() {
      return this.g.length > 0;
   }

   public boolean h() {
      return this.h.length > 0;
   }

   public boolean i() {
      return this.i.length > 0;
   }
}
