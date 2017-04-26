package com.flurry.sdk;

import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jl;
import com.flurry.sdk.ma;
import com.flurry.sdk.ma$a;
import com.flurry.sdk.ma$b;
import com.flurry.sdk.ma$c;
import com.flurry.sdk.ma$d;
import com.flurry.sdk.ma$e;
import com.flurry.sdk.ma$f;
import com.flurry.sdk.ma$g;
import com.flurry.sdk.ma$h;
import com.flurry.sdk.ma$i;
import com.flurry.sdk.ma$j;
import com.flurry.sdk.ma$k;
import com.flurry.sdk.ma$l;
import com.flurry.sdk.ma$m;
import com.flurry.sdk.ma$n;
import com.flurry.sdk.ma$o;
import com.flurry.sdk.mr;
import com.flurry.sdk.mw;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.ra;
import com.flurry.sdk.sh;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;

public class mb {
   protected final HashMap a = new HashMap();

   protected mb() {
      this.a((ma)(new ma$a()));
      this.a((ma)(new ma$b()));
      this.a((ma)(new ma$d()));
      this.a((ma)(new ma$k()));
      this.a((ma)(new ma$i()));
      this.a((ma)(new ma$j()));
      this.a((ma)(new ma$h()));
      this.a((ma)(new ma$f()));
      this.a((ma)(new ma$e()));
      this.a((ma)(new ma$c()));
      this.a((ma)(new ma$o()));
   }

   public static jl a(iy var0, sh var1) {
      return ma$n.a(var1.getClass());
   }

   public static jl a(ra var0) {
      return new ma$g(var0, (mr)null);
   }

   public static jl a(ra var0, mr var1) {
      return new ma$g(var0, var1);
   }

   public static HashMap a() {
      return (new mb()).a;
   }

   private void a(ma var1) {
      Class var2 = var1.a();
      this.a.put(qs.a().a(var2), var1);
   }

   public static jl b(iy var0, sh var1) {
      mw var3 = (mw)var0.b(var1);
      Constructor var2 = var3.a(new Class[]{String.class});
      if(var2 != null) {
         if(var0.a(iy$a.f)) {
            qy.a((Member)var2);
         }

         return new ma$l(var2);
      } else {
         Method var4 = var3.b(new Class[]{String.class});
         if(var4 != null) {
            if(var0.a(iy$a.f)) {
               qy.a((Member)var4);
            }

            return new ma$m(var4);
         } else {
            return null;
         }
      }
   }
}
