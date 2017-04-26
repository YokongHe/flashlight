package com.flurry.sdk;

import com.flurry.sdk.hc;
import com.flurry.sdk.hf;
import com.flurry.sdk.hf$a;
import com.flurry.sdk.hj;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hn;
import com.flurry.sdk.hr;
import com.flurry.sdk.hy;
import com.flurry.sdk.hz;
import com.flurry.sdk.ib;
import com.flurry.sdk.id;
import com.flurry.sdk.ie;
import com.flurry.sdk.if;
import com.flurry.sdk.ik;
import com.flurry.sdk.io;
import com.flurry.sdk.sa;
import com.flurry.sdk.sb;
import com.flurry.sdk.si;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.ref.SoftReference;

public class hd {
   static final int a = hj$a.a();
   static final int b = hf$a.a();
   protected static final ThreadLocal c = new ThreadLocal();
   protected sb d;
   protected sa e;
   protected hn f;
   protected int g;
   protected int h;
   protected id i;
   protected if j;
   protected ik k;

   public hd() {
      this((hn)null);
   }

   public hd(hn var1) {
      this.d = sb.a();
      this.e = sa.a();
      this.g = a;
      this.h = b;
      this.f = var1;
   }

   public hd a(hj$a var1) {
      this.g |= var1.c();
      return this;
   }

   public hd a(hn var1) {
      this.f = var1;
      return this;
   }

   public hf a(OutputStream var1, hc var2) {
      ie var3 = this.a(var1, false);
      var3.a(var2);
      if(var2 == hc.a) {
         OutputStream var6 = var1;
         if(this.k != null) {
            var6 = this.k.a(var3, var1);
         }

         return this.a(var6, var3);
      } else {
         Writer var5 = this.a(var1, var2, var3);
         Writer var4 = var5;
         if(this.k != null) {
            var4 = this.k.a(var3, var5);
         }

         return this.a(var4, var3);
      }
   }

   protected hf a(OutputStream var1, ie var2) {
      hz var3 = new hz(var2, this.h, this.f, var1);
      if(this.i != null) {
         var3.a(this.i);
      }

      return var3;
   }

   public hf a(Writer var1) {
      ie var3 = this.a(var1, false);
      Writer var2 = var1;
      if(this.k != null) {
         var2 = this.k.a(var3, var1);
      }

      return this.a(var2, var3);
   }

   protected hf a(Writer var1, ie var2) {
      ib var3 = new ib(var2, this.h, this.f, var1);
      if(this.i != null) {
         var3.a(this.i);
      }

      return var3;
   }

   public hj a(InputStream var1) {
      ie var3 = this.a(var1, false);
      InputStream var2 = var1;
      if(this.j != null) {
         var2 = this.j.a(var3, var1);
      }

      return this.a(var2, var3);
   }

   protected hj a(InputStream var1, ie var2) {
      return (new hr(var2, var1)).a(this.g, this.f, this.e, this.d);
   }

   public hj a(Reader var1) {
      ie var3 = this.a(var1, false);
      Reader var2 = var1;
      if(this.j != null) {
         var2 = this.j.a(var3, var1);
      }

      return this.a(var2, var3);
   }

   protected hj a(Reader var1, ie var2) {
      return new hy(var2, this.g, var1, this.f, this.d.a(this.b(hj$a.j), this.b(hj$a.i)));
   }

   public hn a() {
      return this.f;
   }

   protected ie a(Object var1, boolean var2) {
      return new ie(this.b(), var1, var2);
   }

   protected Writer a(OutputStream var1, hc var2, ie var3) {
      return (Writer)(var2 == hc.a?new io(var3, var1):new OutputStreamWriter(var1, var2.a()));
   }

   public si b() {
      SoftReference var1 = (SoftReference)c.get();
      si var3;
      if(var1 == null) {
         var3 = null;
      } else {
         var3 = (si)var1.get();
      }

      si var2 = var3;
      if(var3 == null) {
         var2 = new si();
         c.set(new SoftReference(var2));
      }

      return var2;
   }

   public final boolean b(hj$a var1) {
      return (this.g & var1.c()) != 0;
   }
}
