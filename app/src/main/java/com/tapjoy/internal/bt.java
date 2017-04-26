package com.tapjoy.internal;

import com.tapjoy.internal.bt$a;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.client.utils.URIUtils;

public abstract class bt implements com.tapjoy.internal.bq, com.tapjoy.internal.bv {
   private HashMap a;

   public static com.tapjoy.internal.bt a(InputStream var0) {
      return bt$a.a().a(var0);
   }

   private void a(List var1) {
      this.g();

      while(this.k()) {
         var1.add(this.v());
      }

      this.h();
   }

   public static com.tapjoy.internal.bt b(String var0) {
      return bt$a.a().a(var0);
   }

   private static URI d(String var0) {
      try {
         URI var2 = new URI(var0);
         return var2;
      } catch (URISyntaxException var1) {
         throw new com.tapjoy.internal.cb(var1);
      }
   }

   private boolean u() {
      if(this.l() == com.tapjoy.internal.by.i) {
         this.p();
         return true;
      } else {
         return false;
      }
   }

   private Object v() {
      com.tapjoy.internal.by var1 = this.l();
      switch(null.a[var1.ordinal()]) {
      case 1:
         return this.d();
      case 2:
         return this.e();
      case 3:
         this.p();
         return null;
      case 4:
         return Boolean.valueOf(this.o());
      case 5:
         return new com.tapjoy.internal.co(this.n());
      case 6:
         return this.n();
      default:
         throw new IllegalStateException("Expected a value but was " + var1);
      }
   }

   public final Object a(com.tapjoy.internal.bo var1) {
      return var1.a(this);
   }

   public final Object a(String var1) {
      return this.a != null?this.a.get(var1):null;
   }

   public final void a(String var1, Object var2) {
      if(this.a == null) {
         this.a = new HashMap();
      }

      this.a.put(var1, var2);
   }

   public final void a(List var1, com.tapjoy.internal.bo var2) {
      this.g();

      while(this.k()) {
         var1.add(var2.a(this));
      }

      this.h();
   }

   public final void a(Map var1) {
      this.i();

      while(this.k()) {
         var1.put(this.m(), this.v());
      }

      this.j();
   }

   public final boolean a() {
      return this.l() == com.tapjoy.internal.by.c;
   }

   public final Object b(com.tapjoy.internal.bo var1) {
      return this.u()?null:var1.a(this);
   }

   public final boolean b() {
      return this.l() == com.tapjoy.internal.by.f;
   }

   public final String c() {
      return this.u()?null:this.n();
   }

   public final String c(String var1) {
      return this.u()?var1:this.n();
   }

   public final List d() {
      LinkedList var1 = new LinkedList();
      this.a((List)var1);
      return var1;
   }

   public final Map e() {
      LinkedHashMap var1 = new LinkedHashMap();
      this.a((Map)var1);
      return var1;
   }

   public final URL f() {
      URI var1 = (URI)this.a("BASE_URI");
      return var1 != null?URIUtils.resolve(var1, d(this.n())).toURL():new URL(this.n());
   }
}
