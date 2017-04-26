package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.ft;
import com.flurry.sdk.fx;
import com.flurry.sdk.gi;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class fv {
   private final ft a;
   private fn b;

   protected fv(fn var1, ft var2) {
      this(var2);
      this.a(var1);
   }

   protected fv(ft var1) {
      this.a = var1;
   }

   private void b(fn var1, Object var2) {
      throw new fl("Not a " + var1 + ": " + var2);
   }

   protected int a(fn var1, Object var2) {
      return this.a.a(var1, var2);
   }

   protected long a(Object var1) {
      return (long)((Collection)var1).size();
   }

   protected NullPointerException a(NullPointerException var1, String var2) {
      NullPointerException var3 = new NullPointerException(((NullPointerException)var1).getMessage() + var2);
      if(((NullPointerException)var1).getCause() != null) {
         var1 = ((NullPointerException)var1).getCause();
      }

      var3.initCause((Throwable)var1);
      return var3;
   }

   public void a(fn var1) {
      this.b = var1;
   }

   protected void a(fn param1, Object param2, gi param3) {
      // $FF: Couldn't be decompiled
   }

   public void a(Object var1, gi var2) {
      this.a(this.b, var1, var2);
   }

   protected Iterator b(Object var1) {
      return ((Collection)var1).iterator();
   }

   protected void b(fn var1, Object var2, gi var3) {
      Object var4 = this.a.a(var2, var1);
      Iterator var5 = var1.b().iterator();

      while(var5.hasNext()) {
         fn$f var8 = (fn$f)var5.next();
         Object var6 = this.a.b(var2, var8.a(), var8.b(), var4);

         try {
            this.a(var8.c(), var6, var3);
         } catch (NullPointerException var7) {
            throw this.a(var7, " in field " + var8.a());
         }
      }

   }

   protected void b(Object var1, gi var2) {
      var2.a((CharSequence)var1);
   }

   protected int c(Object var1) {
      return ((Map)var1).size();
   }

   protected void c(fn var1, Object var2, gi var3) {
      var3.a(var1.c(var2.toString()));
   }

   protected void c(Object var1, gi var2) {
      var2.a((ByteBuffer)var1);
   }

   protected Iterable d(Object var1) {
      return ((Map)var1).entrySet();
   }

   protected void d(fn var1, Object var2, gi var3) {
      var1 = var1.i();
      long var4 = this.a(var2);
      var3.b();
      var3.a(var4);
      Iterator var6 = this.b(var2);

      while(var6.hasNext()) {
         var3.c();
         this.a(var1, var6.next(), var3);
      }

      var3.d();
   }

   protected void e(fn var1, Object var2, gi var3) {
      var1 = var1.j();
      int var4 = this.c(var2);
      var3.e();
      var3.a((long)var4);
      Iterator var6 = this.d(var2).iterator();

      while(var6.hasNext()) {
         Entry var5 = (Entry)var6.next();
         var3.c();
         this.b(var5.getKey(), var3);
         this.a(var1, var5.getValue(), var3);
      }

      var3.f();
   }

   protected void f(fn var1, Object var2, gi var3) {
      this.b(var2, var3);
   }

   protected void g(fn var1, Object var2, gi var3) {
      var3.b(((fx)var2).b(), 0, var1.l());
   }
}
