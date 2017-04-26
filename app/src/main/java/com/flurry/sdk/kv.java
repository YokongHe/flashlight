package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hh;
import com.flurry.sdk.im;
import com.flurry.sdk.ip;
import com.flurry.sdk.iq;
import com.flurry.sdk.is;
import com.flurry.sdk.iu$a;
import com.flurry.sdk.iv;
import com.flurry.sdk.iw;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.jb;
import com.flurry.sdk.jc;
import com.flurry.sdk.jd;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.jl;
import com.flurry.sdk.jm;
import com.flurry.sdk.js;
import com.flurry.sdk.jy;
import com.flurry.sdk.ko;
import com.flurry.sdk.kq;
import com.flurry.sdk.kv$a;
import com.flurry.sdk.ky;
import com.flurry.sdk.mn;
import com.flurry.sdk.qi;
import com.flurry.sdk.qk;
import com.flurry.sdk.ql;
import com.flurry.sdk.qn;
import com.flurry.sdk.qo;
import com.flurry.sdk.qy;
import com.flurry.sdk.rh;
import com.flurry.sdk.sh;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class kv extends jc {
   protected final ConcurrentHashMap a;
   protected final HashMap b;
   protected final rh c;
   protected jb d;

   public kv() {
      this(kq.h);
   }

   public kv(jb var1) {
      this.a = new ConcurrentHashMap(64, 0.75F, 2);
      this.b = new HashMap(8);
      this.d = var1;
      this.c = new rh();
   }

   public im a(iy var1, sh var2) {
      return this.c.a((sh)var2, var1);
   }

   public jc a(ip var1) {
      return this.a(this.d.a(var1));
   }

   public jc a(jd var1) {
      return this.a(this.d.a(var1));
   }

   public jc a(jm var1) {
      return this.a(this.d.a(var1));
   }

   public jc a(ky var1) {
      return this.a(this.d.a(var1));
   }

   public jg a(iy var1, sh var2, is var3) {
      jg var4 = this.a(var2);
      jg var6;
      if(var4 != null) {
         var6 = var4;
         if(var4 instanceof iv) {
            var6 = ((iv)var4).a(var1, var3);
         }
      } else {
         jg var5 = this.d(var1, var2, var3);
         var4 = var5;
         if(var5 == null) {
            var4 = this.b(var2);
         }

         var6 = var4;
         if(var4 instanceof iv) {
            return ((iv)var4).a(var1, var3);
         }
      }

      return var6;
   }

   protected jg a(sh var1) {
      if(var1 == null) {
         throw new IllegalArgumentException();
      } else {
         return (jg)this.a.get(var1);
      }
   }

   public kv a(jb var1) {
      if(this.getClass() != kv.class) {
         throw new IllegalStateException("DeserializerProvider of type " + this.getClass().getName() + " does not override \'withFactory()\' method");
      } else {
         return new kv(var1);
      }
   }

   protected void a(iy var1, js var2) {
      var2.a(var1, this);
   }

   public jg b(iy var1, sh var2, is var3) {
      jg var4 = this.a(var1, var2, var3);
      jy var5 = this.d.b(var1, var2, var3);
      return (jg)(var5 != null?new kv$a(var5, var4):var4);
   }

   protected jg b(sh var1) {
      if(!qy.d(var1.p())) {
         throw new jh("Can not find a Value deserializer for abstract type " + var1);
      } else {
         throw new jh("Can not find a Value deserializer for type " + var1);
      }
   }

   public jl c(iy var1, sh var2, is var3) {
      jl var5 = this.d.a(var1, var2, var3);
      jl var4 = var5;
      if(var5 instanceof iw) {
         var4 = ((iw)var5).a(var1, var3);
      }

      jl var6 = var4;
      if(var4 == null) {
         var6 = this.c(var2);
      }

      return var6;
   }

   protected jl c(sh var1) {
      throw new jh("Can not find a (Map) Key deserializer for type " + var1);
   }

   protected jg d(iy param1, sh param2, is param3) {
      // $FF: Couldn't be decompiled
   }

   protected jg e(iy var1, sh var2, is var3) {
      jg var10;
      try {
         var10 = this.f(var1, var2, var3);
      } catch (IllegalArgumentException var8) {
         throw new jh(var8.getMessage(), (hg)null, var8);
      }

      jg var9;
      if(var10 == null) {
         var9 = null;
      } else {
         boolean var6 = var10 instanceof js;
         boolean var4;
         if(var10.getClass() == ko.class) {
            var4 = true;
         } else {
            var4 = false;
         }

         boolean var5 = var4;
         if(!var4) {
            var5 = var4;
            if(var1.a(iy$a.a)) {
               iq var7 = var1.a();
               Boolean var11 = var7.a(mn.a((Class)var10.getClass(), (iq)var7, (iu$a)null));
               var5 = var4;
               if(var11 != null) {
                  var5 = var11.booleanValue();
               }
            }
         }

         if(var6) {
            this.b.put(var2, var10);
            this.a(var1, (js)var10);
            this.b.remove(var2);
         }

         var9 = var10;
         if(var5) {
            this.a.put(var2, var10);
            return var10;
         }
      }

      return var9;
   }

   protected jg f(iy var1, sh var2, is var3) {
      if(var2.r()) {
         return this.d.b(var1, this, var2, var3);
      } else {
         if(var2.f()) {
            if(var2.b()) {
               return this.d.a(var1, this, (qi)((qi)var2), var3);
            }

            if(var2.j()) {
               qn var5 = (qn)var2;
               if(var5.l()) {
                  return this.d.a(var1, this, (qo)((qo)var5), var3);
               }

               return this.d.a(var1, this, (qn)var5, var3);
            }

            if(var2.i()) {
               qk var4 = (qk)var2;
               if(var4.a_()) {
                  return this.d.a(var1, this, (ql)((ql)var4), var3);
               }

               return this.d.a(var1, this, (qk)var4, var3);
            }
         }

         return hh.class.isAssignableFrom(var2.p())?this.d.c(var1, this, var2, var3):this.d.a(var1, this, (sh)var2, var3);
      }
   }
}
