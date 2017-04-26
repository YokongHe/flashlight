package com.flurry.sdk;

import com.flurry.sdk.fl;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.gc;
import com.flurry.sdk.gi;
import com.flurry.sdk.gj;
import com.flurry.sdk.go$a;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$b;
import com.flurry.sdk.gq$c;
import com.flurry.sdk.gq$e;
import com.flurry.sdk.gq$h;
import com.flurry.sdk.gq$n;
import com.flurry.sdk.gq$p;
import com.flurry.sdk.gq$q;
import com.flurry.sdk.gr;
import com.flurry.sdk.hh;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class go extends gr {
   private static gj a = (new gj()).a(32);

   private static gq a(List var0, List var1) {
      Object[] var5 = new Object[var0.size()];

      for(int var2 = 0; var2 < var5.length; ++var2) {
         int var3 = var1.indexOf(var0.get(var2));
         Object var4;
         if(var3 == -1) {
            var4 = "No match for " + (String)var0.get(var2);
         } else {
            var4 = new Integer(var3);
         }

         var5[var2] = var4;
      }

      return new gq$c(var1.size(), var5);
   }

   public static void a(gi var0, fn var1, hh var2) {
      hh var4;
      switch(null.a[var1.a().ordinal()]) {
      case 1:
         if(!var2.h()) {
            throw new fl("Non-null default value for null type: " + var2);
         }

         var0.a();
         return;
      case 2:
         if(!var2.g()) {
            throw new fl("Non-boolean default for boolean: " + var2);
         }

         var0.a(var2.j());
         return;
      case 3:
         if(!var2.d()) {
            throw new fl("Non-numeric default value for int: " + var2);
         }

         var0.c(var2.k());
         return;
      case 4:
         if(!var2.d()) {
            throw new fl("Non-numeric default value for long: " + var2);
         }

         var0.b(var2.l());
         return;
      case 5:
         if(!var2.d()) {
            throw new fl("Non-numeric default value for float: " + var2);
         }

         var0.a((float)var2.m());
         return;
      case 6:
         if(!var2.d()) {
            throw new fl("Non-numeric default value for double: " + var2);
         }

         var0.a(var2.m());
         return;
      case 7:
         if(!var2.f()) {
            throw new fl("Non-string default value for string: " + var2);
         }

         var0.a(var2.i());
         return;
      case 8:
         if(!var2.f()) {
            throw new fl("Non-string default value for bytes: " + var2);
         }

         var0.a(var2.i().getBytes("ISO-8859-1"));
         return;
      case 9:
         if(!var2.f()) {
            throw new fl("Non-string default value for fixed: " + var2);
         }

         byte[] var10 = var2.i().getBytes("ISO-8859-1");
         byte[] var11;
         if(var10.length != var1.l()) {
            byte[] var13 = new byte[var1.l()];
            int var3;
            if(var1.l() > var10.length) {
               var3 = var10.length;
            } else {
               var3 = var1.l();
            }

            System.arraycopy(var10, 0, var13, 0, var3);
            var11 = var13;
         } else {
            var11 = var10;
         }

         var0.b(var11);
         return;
      case 10:
         var0.a(var1.c(var2.i()));
         return;
      case 11:
         var0.b();
         var0.a((long)var2.p());
         var1 = var1.i();
         Iterator var9 = var2.iterator();

         while(var9.hasNext()) {
            var4 = (hh)var9.next();
            var0.c();
            a(var0, var1, var4);
         }

         var0.d();
         return;
      case 12:
         var0.e();
         var0.a((long)var2.p());
         var1 = var1.j();
         Iterator var12 = var2.r();

         while(var12.hasNext()) {
            var0.c();
            String var14 = (String)var12.next();
            var0.a(var14);
            a(var0, var1, var2.a(var14));
         }

         var0.f();
         return;
      case 13:
         Iterator var5 = var1.b().iterator();

         while(var5.hasNext()) {
            fn$f var6 = (fn$f)var5.next();
            String var7 = var6.a();
            var4 = var2.a(var7);
            hh var8 = var4;
            if(var4 == null) {
               var8 = var6.e();
            }

            if(var8 == null) {
               throw new fl("No default value for: " + var7);
            }

            a(var0, var6.c(), var8);
         }
      default:
         return;
      case 14:
         var0.b(0);
         a(var0, (fn)var1.k().get(0), var2);
      }
   }

   private static byte[] a(fn var0, hh var1) {
      ByteArrayOutputStream var2 = new ByteArrayOutputStream();
      gc var3 = a.a(var2, (gc)null);
      a((gi)var3, var0, (hh)var1);
      var3.flush();
      return var2.toByteArray();
   }

   private static int b(fn var0, fn var1) {
      byte var3 = 0;
      fn$v var4 = var1.a();
      Iterator var5 = var0.k().iterator();
      int var2 = 0;

      while(true) {
         if(!var5.hasNext()) {
            Iterator var8 = var0.k().iterator();

            for(var2 = var3; var8.hasNext(); ++var2) {
               var1 = (fn)var8.next();
               switch(null.a[var4.ordinal()]) {
               case 3:
                  switch(null.a[var1.a().ordinal()]) {
                  case 4:
                  case 6:
                     return var2;
                  case 5:
                  default:
                     continue;
                  }
               case 4:
               case 5:
                  switch(null.a[var1.a().ordinal()]) {
                  case 6:
                     return var2;
                  }
               }
            }

            return -1;
         }

         fn var7 = (fn)var5.next();
         if(var4 == var7.a()) {
            if(var4 != fn$v.a && var4 != fn$v.b && var4 != fn$v.f) {
               break;
            }

            String var6 = var1.g();
            String var9 = var7.g();
            if(var6 != null && var6.equals(var9) || var6 == var9 && var4 == fn$v.a) {
               break;
            }
         }

         ++var2;
      }

      return var2;
   }

   private gq b(fn var1, fn var2, Map var3) {
      List var6 = var1.k();
      int var4 = var6.size();
      gq[] var8 = new gq[var4];
      String[] var5 = new String[var4];
      Iterator var9 = var6.iterator();

      for(var4 = 0; var9.hasNext(); ++var4) {
         fn var7 = (fn)var9.next();
         var8[var4] = this.a(var7, var2, var3);
         var5[var4] = var7.g();
      }

      return gq.b(new gq[]{gq.a(var8, var5), new gq$q()});
   }

   private gq c(fn var1, fn var2, Map var3) {
      go$a var9 = new go$a(var1, var2);
      gq var8 = (gq)var3.get(var9);
      gq var7 = var8;
      if(var8 == null) {
         List var11 = var1.b();
         List var14 = var2.b();
         fn$f[] var10 = new fn$f[var14.size()];
         int var6 = var11.size();
         Iterator var15 = var11.iterator();
         int var4 = 0;

         int var5;
         fn$f var12;
         while(var15.hasNext()) {
            var12 = var2.b(((fn$f)var15.next()).a());
            if(var12 != null) {
               var5 = var4 + 1;
               var10[var4] = var12;
               var4 = var5;
            }
         }

         var15 = var14.iterator();
         var5 = var6 + 1;

         while(true) {
            if(!var15.hasNext()) {
               gq[] var17 = new gq[var5];
               var4 = var5 - 1;
               var17[var4] = new gq$e(var10);
               gq var20 = gq.b(var17);
               var3.put(var9, var20);
               Iterator var18 = var11.iterator();

               while(var18.hasNext()) {
                  fn$f var21 = (fn$f)var18.next();
                  var12 = var2.b(var21.a());
                  if(var12 == null) {
                     --var4;
                     var17[var4] = new gq$n(this.a(var21.c(), var21.c(), var3));
                  } else {
                     --var4;
                     var17[var4] = this.a(var21.c(), var12.c(), var3);
                  }
               }

               Iterator var13 = var14.iterator();

               while(var13.hasNext()) {
                  fn$f var16 = (fn$f)var13.next();
                  if(var1.b(var16.a()) == null) {
                     byte[] var19 = a(var16.c(), var16.e());
                     --var4;
                     var17[var4] = new gq$b(var19);
                     --var4;
                     var17[var4] = this.a(var16.c(), var16.c(), var3);
                     --var4;
                     var17[var4] = gq.x;
                  }
               }

               return var20;
            }

            var12 = (fn$f)var15.next();
            if(var1.b(var12.a()) == null) {
               if(var12.e() == null) {
                  var7 = gq.a("Found " + var1.a(true) + ", expecting " + var2.a(true));
                  var3.put(var9, var7);
                  break;
               }

               var10[var4] = var12;
               var6 = var5 + 3;
               var5 = var4 + 1;
               var4 = var6;
            } else {
               var6 = var4;
               var4 = var5;
               var5 = var6;
            }

            var6 = var5;
            var5 = var4;
            var4 = var6;
         }
      }

      return var7;
   }

   public final gq a(fn var1, fn var2) {
      return gq.a(new gq[]{this.a((fn)var1, var2, (Map)(new HashMap()))});
   }

   public gq a(fn var1, fn var2, Map var3) {
      fn$v var5 = var1.a();
      fn$v var6 = var2.a();
      if(var5 == var6) {
         switch(null.a[var5.ordinal()]) {
         case 1:
            return gq.c;
         case 2:
            return gq.d;
         case 3:
            return gq.e;
         case 4:
            return gq.f;
         case 5:
            return gq.g;
         case 6:
            return gq.h;
         case 7:
            return gq.i;
         case 8:
            return gq.j;
         case 9:
            if(var1.g().equals(var2.g()) && var1.l() == var2.l()) {
               return gq.b(new gq[]{new gq$h(var1.l()), gq.k});
            }
            break;
         case 10:
            if(var1.g() == null || var1.g().equals(var2.g())) {
               return gq.b(new gq[]{a(var1.c(), var2.c()), gq.l});
            }
            break;
         case 11:
            return gq.b(new gq[]{gq.a(gq.o, new gq[]{this.a(var1.i(), var2.i(), var3)}), gq.n});
         case 12:
            return gq.b(new gq[]{gq.a(gq.q, new gq[]{this.a(var1.j(), var2.j(), var3), gq.i}), gq.p});
         case 13:
            return this.c(var1, var2, var3);
         case 14:
            return this.b(var1, var2, var3);
         default:
            throw new fl("Unkown type for schema: " + var5);
         }
      } else {
         if(var5 == fn$v.e) {
            return this.b(var1, var2, var3);
         }

         switch(null.a[var6.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 7:
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
            break;
         case 4:
            switch(null.a[var5.ordinal()]) {
            case 3:
               return gq.a(super.a(var1, var3), gq.f);
            default:
               return gq.a("Found " + var1.a(true) + ", expecting " + var2.a(true));
            }
         case 5:
            switch(null.a[var5.ordinal()]) {
            case 3:
            case 4:
               return gq.a(super.a(var1, var3), gq.g);
            default:
               return gq.a("Found " + var1.a(true) + ", expecting " + var2.a(true));
            }
         case 6:
            switch(null.a[var5.ordinal()]) {
            case 3:
            case 4:
            case 5:
               return gq.a(super.a(var1, var3), gq.h);
            default:
               return gq.a("Found " + var1.a(true) + ", expecting " + var2.a(true));
            }
         case 9:
         default:
            throw new RuntimeException("Unexpected schema type: " + var6);
         case 14:
            int var4 = b(var2, var1);
            if(var4 >= 0) {
               return gq.b(new gq[]{new gq$p(var4, this.a(var1, (fn)var2.k().get(var4), var3)), gq.m});
            }
         }
      }

      return gq.a("Found " + var1.a(true) + ", expecting " + var2.a(true));
   }
}
