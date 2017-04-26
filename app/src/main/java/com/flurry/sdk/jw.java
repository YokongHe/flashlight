package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jv;
import com.flurry.sdk.on;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;
import java.lang.reflect.Type;
import java.util.Date;

public abstract class jw {
   protected static final sh a = qs.a().a(Object.class);
   protected final ju b;
   protected final Class c;

   protected jw(ju var1) {
      this.b = var1;
      Class var2;
      if(var1 == null) {
         var2 = null;
      } else {
         var2 = this.b.f();
      }

      this.c = var2;
   }

   public abstract jk a(sh var1, is var2);

   public abstract jk a(sh var1, boolean var2, is var3);

   public abstract jk a(Class var1, is var2);

   public abstract jk a(Class var1, boolean var2, is var3);

   public sh a(sh var1, Class var2) {
      return this.b.a(var1, var2);
   }

   public sh a(Type var1) {
      return this.b.m().a(var1);
   }

   public final Class a() {
      return this.c;
   }

   public abstract void a(long var1, hf var3);

   public final void a(hf var1) {
      this.d().a((Object)null, var1, this);
   }

   public abstract void a(ju var1, hf var2, Object var3, jv var4);

   public final void a(Object var1, hf var2) {
      if(var1 == null) {
         this.d().a((Object)null, var2, this);
      } else {
         this.a((Class)var1.getClass(), true, (is)null).a(var1, var2, this);
      }
   }

   public abstract void a(Date var1, hf var2);

   public final boolean a(ju$a var1) {
      return this.b.a(var1);
   }

   public abstract jk b(sh var1, is var2);

   public final on b() {
      return this.b.h();
   }

   public abstract void b(long var1, hf var3);

   public abstract void b(Date var1, hf var2);

   public abstract jk c();

   public abstract jk d();
}
