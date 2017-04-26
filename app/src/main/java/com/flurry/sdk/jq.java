package com.flurry.sdk;

import com.flurry.sdk.hc;
import com.flurry.sdk.hd;
import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.il;
import com.flurry.sdk.im;
import com.flurry.sdk.ip;
import com.flurry.sdk.iq;
import com.flurry.sdk.is;
import com.flurry.sdk.iu;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jd;
import com.flurry.sdk.je;
import com.flurry.sdk.jf;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.jm;
import com.flurry.sdk.jo;
import com.flurry.sdk.jp;
import com.flurry.sdk.jp$a;
import com.flurry.sdk.jr;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jv;
import com.flurry.sdk.jw;
import com.flurry.sdk.jx;
import com.flurry.sdk.ku;
import com.flurry.sdk.kv;
import com.flurry.sdk.ky;
import com.flurry.sdk.mx;
import com.flurry.sdk.my;
import com.flurry.sdk.ne;
import com.flurry.sdk.ne$a;
import com.flurry.sdk.ng;
import com.flurry.sdk.ol;
import com.flurry.sdk.or;
import com.flurry.sdk.qp;
import com.flurry.sdk.qs;
import com.flurry.sdk.rs;
import com.flurry.sdk.sh;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;

public class jq extends hn {
   protected static final iu a;
   protected static final iq b;
   protected static final ne c;
   private static final sh n = qp.d(hh.class);
   protected final hd d;
   protected ng e;
   protected qs f;
   protected jf g;
   protected ju h;
   protected jw i;
   protected jv j;
   protected iy k;
   protected jc l;
   protected final ConcurrentHashMap m;

   static {
      a = mx.i;
      b = new my();
      c = ne$a.a();
   }

   public jq() {
      this((hd)null, (jw)null, (jc)null);
   }

   public jq(hd var1) {
      this(var1, (jw)null, (jc)null);
   }

   public jq(hd var1, jw var2, jc var3) {
      this(var1, var2, var3, (ju)null, (iy)null);
   }

   public jq(hd var1, jw var2, jc var3, ju var4, iy var5) {
      this.m = new ConcurrentHashMap(64, 0.6F, 2);
      if(var1 == null) {
         this.d = new jo(this);
      } else {
         this.d = var1;
         if(var1.a() == null) {
            this.d.a((hn)this);
         }
      }

      this.f = qs.a();
      if(var4 == null) {
         var4 = new ju(a, b, c, (ng)null, (jr)null, this.f, (je)null);
      }

      this.h = var4;
      if(var5 == null) {
         var5 = new iy(a, b, c, (ng)null, (jr)null, this.f, (je)null);
      }

      this.k = var5;
      Object var6 = var2;
      if(var2 == null) {
         var6 = new or();
      }

      this.i = (jw)var6;
      var6 = var3;
      if(var3 == null) {
         var6 = new kv();
      }

      this.l = (jc)var6;
      this.j = ol.e;
   }

   private final void a(hf param1, Object param2, ju param3) {
      // $FF: Couldn't be decompiled
   }

   private final void b(hf var1, Object var2, ju var3) {
      Closeable var4 = (Closeable)var2;

      Closeable var14;
      label98: {
         try {
            this.i.a(var3, (hf)var1, var2, this.j);
            if(var3.a(ju$a.p)) {
               ((hf)var1).g();
            }
         } catch (Throwable var13) {
            var14 = var4;
            var1 = var13;
            break label98;
         }

         var14 = null;

         label90:
         try {
            var4.close();
            return;
         } finally {
            break label90;
         }
      }

      if(var14 != null) {
         try {
            var14.close();
         } catch (IOException var11) {
            ;
         }
      }

      throw var1;
   }

   public hh a(hj var1) {
      iy var2 = this.b();
      hh var3;
      if(var1.e() == null && var1.b() == null) {
         var3 = null;
      } else {
         hh var4 = (hh)this.a(var2, var1, n);
         var3 = var4;
         if(var4 == null) {
            return this.c().a();
         }
      }

      return var3;
   }

   protected iz a(hj var1, iy var2) {
      return new ku(var2, var1, this.l, this.g);
   }

   protected jg a(iy var1, sh var2) {
      jg var3 = (jg)this.m.get(var2);
      if(var3 != null) {
         return var3;
      } else {
         jg var4 = this.l.b(var1, var2, (is)null);
         if(var4 == null) {
            throw new jh("Can not find a deserializer for type " + var2);
         } else {
            this.m.put(var2, var4);
            return var4;
         }
      }
   }

   public jq a(ju$a var1, boolean var2) {
      this.h.a(var1, var2);
      return this;
   }

   public ju a() {
      return this.h.a(this.e);
   }

   protected Object a(hj param1, sh param2) {
      // $FF: Couldn't be decompiled
   }

   protected Object a(hj var1, sh var2, iz var3, jg var4) {
      im var5 = this.l.a(var3.a(), var2);
      if(var1.e() != hm.b) {
         throw jh.a(var1, "Current token not START_OBJECT (needed to unwrap root name \'" + var5 + "\'), but " + var1.e());
      } else if(var1.b() != hm.f) {
         throw jh.a(var1, "Current token not FIELD_NAME (to contain expected root name \'" + var5 + "\'), but " + var1.e());
      } else {
         String var6 = var1.g();
         if(!var5.a().equals(var6)) {
            throw jh.a(var1, "Root name \'" + var6 + "\' does not match expected (\'" + var5 + "\') for type " + var2);
         } else {
            var1.b();
            Object var7 = var4.a(var1, var3);
            if(var1.b() != hm.c) {
               throw jh.a(var1, "Current token not END_OBJECT (to match wrapper object with root name \'" + var5 + "\'), but " + var1.e());
            } else {
               return var7;
            }
         }
      }
   }

   protected Object a(iy var1, hj var2, sh var3) {
      hm var4 = this.b(var2);
      Object var6;
      if(var4 == hm.m) {
         var6 = this.a(var1, var3).b();
      } else if(var4 != hm.e && var4 != hm.c) {
         iz var7 = this.a(var2, var1);
         jg var5 = this.a(var1, var3);
         if(var1.a(iy$a.p)) {
            var6 = this.a(var2, var3, var7, var5);
         } else {
            var6 = var5.a(var2, var7);
         }
      } else {
         var6 = null;
      }

      var2.f();
      return var6;
   }

   public Object a(InputStream var1, Class var2) {
      return this.a(this.d.a(var1), this.f.a((Type)var2));
   }

   public String a(Object var1) {
      il var2 = new il(this.d.b());
      this.b(this.d.a((Writer)var2), var1);
      return var2.a();
   }

   public void a(hf var1, hh var2) {
      ju var3 = this.a();
      this.i.a(var3, var1, var2, this.j);
      if(var3.a(ju$a.p)) {
         var1.g();
      }

   }

   public void a(hf var1, Object var2) {
      ju var3 = this.a();
      if(var3.a(ju$a.o) && var2 instanceof Closeable) {
         this.b(var1, var2, var3);
      } else {
         this.i.a(var3, var1, var2, this.j);
         if(var3.a(ju$a.p)) {
            var1.g();
            return;
         }
      }

   }

   public void a(jp var1) {
      if(var1.a() == null) {
         throw new IllegalArgumentException("Module without defined name");
      } else if(var1.b() == null) {
         throw new IllegalArgumentException("Module without defined version");
      } else {
         var1.a(new jp$a() {
            public void a(ip var1) {
               jq.this.l = jq.this.l.a(var1);
            }

            public void a(jd var1) {
               jq.this.l = jq.this.l.a(var1);
            }

            public void a(jm var1) {
               jq.this.l = jq.this.l.a(var1);
            }

            public void a(jx var1) {
               jq.this.j = jq.this.j.a(var1);
            }

            public void a(ky var1) {
               jq.this.l = jq.this.l.a(var1);
            }

            public void a(Class var1, Class var2) {
               jq.this.k.a(var1, var2);
               jq.this.h.a(var1, var2);
            }

            public void b(jx var1) {
               jq.this.j = jq.this.j.b(var1);
            }
         });
      }
   }

   public void a(OutputStream var1, Object var2) {
      this.b(this.d.a(var1, hc.a), var2);
   }

   protected hm b(hj var1) {
      hm var3 = var1.e();
      hm var2 = var3;
      if(var3 == null) {
         hm var4 = var1.b();
         var2 = var4;
         if(var4 == null) {
            throw new EOFException("No content to map to Object due to end of input");
         }
      }

      return var2;
   }

   public iy b() {
      return this.k.a(this.e).a(this.h.i);
   }

   protected final void b(hf param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public rs c() {
      return this.k.h();
   }
}
