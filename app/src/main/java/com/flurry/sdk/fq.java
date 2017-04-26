package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.ft;
import com.flurry.sdk.gb;
import com.flurry.sdk.gc;
import com.flurry.sdk.gg;
import com.flurry.sdk.gi;
import com.flurry.sdk.gj;
import com.flurry.sdk.go;
import com.flurry.sdk.hh;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public abstract class fq {
   private static final ConcurrentMap a = new ConcurrentHashMap();
   private static final fn$f[] b = new fn$f[0];
   private final fn c;
   private final fn$f[] d;
   private final boolean[] e;
   private final ft f;
   private gc g = null;
   private gb h = null;

   protected fq(fn var1, ft var2) {
      this.c = var1;
      this.f = var2;
      this.d = (fn$f[])var1.b().toArray(b);
      this.e = new boolean[this.d.length];
   }

   protected static boolean b(fn$f var0, Object var1) {
      if(var1 != null) {
         return true;
      } else {
         fn var2 = var0.c();
         fn$v var4 = var2.a();
         if(var4 == fn$v.n) {
            return true;
         } else {
            if(var4 == fn$v.e) {
               Iterator var3 = var2.k().iterator();

               while(var3.hasNext()) {
                  if(((fn)var3.next()).a() == fn$v.n) {
                     return true;
                  }
               }
            }

            return false;
         }
      }
   }

   protected Object a(fn$f var1) {
      hh var5 = var1.e();
      if(var5 == null) {
         throw new fk("Field " + var1 + " not set and has no default value");
      } else if(var5.h() && (var1.c().a() == fn$v.n || var1.c().a() == fn$v.e && ((fn)var1.c().k().get(0)).a() == fn$v.n)) {
         return null;
      } else {
         ConcurrentMap var3 = (ConcurrentMap)a.get(this.c.g());
         ConcurrentMap var2 = var3;
         if(var3 == null) {
            a.putIfAbsent(this.c.g(), new ConcurrentHashMap(this.d.length));
            var2 = (ConcurrentMap)a.get(this.c.g());
         }

         Object var4 = var2.get(Integer.valueOf(var1.b()));
         Object var6 = var4;
         if(var4 == null) {
            ByteArrayOutputStream var7 = new ByteArrayOutputStream();
            this.g = gj.a().a(var7, this.g);
            go.a((gi)this.g, var1.c(), (hh)var5);
            this.g.flush();
            this.h = gg.a().a(var7.toByteArray(), this.h);
            var6 = this.f.a(var1.c()).a((Object)null, this.h);
            var2.putIfAbsent(Integer.valueOf(var1.b()), var6);
         }

         return this.f.b(var1.c(), var6);
      }
   }

   protected void a(fn$f var1, Object var2) {
      if(!b(var1, var2) && var1.e() == null) {
         throw new fk("Field " + var1 + " does not accept null values");
      }
   }

   protected final fn$f[] b() {
      return this.d;
   }

   protected final boolean[] c() {
      return this.e;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(var1 == null) {
            return false;
         }

         if(this.getClass() != var1.getClass()) {
            return false;
         }

         fq var2 = (fq)var1;
         if(!Arrays.equals(this.e, var2.e)) {
            return false;
         }

         if(this.c == null) {
            if(var2.c != null) {
               return false;
            }
         } else if(!this.c.equals(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      int var2 = Arrays.hashCode(this.e);
      int var1;
      if(this.c == null) {
         var1 = 0;
      } else {
         var1 = this.c.hashCode();
      }

      return var1 + (var2 + 31) * 31;
   }
}
