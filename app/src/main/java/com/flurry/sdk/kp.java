package com.flurry.sdk;

import com.flurry.sdk.is;
import com.flurry.sdk.it;
import com.flurry.sdk.jg;
import com.flurry.sdk.ko;
import com.flurry.sdk.ks;
import com.flurry.sdk.kt;
import com.flurry.sdk.kx;
import com.flurry.sdk.kz;
import com.flurry.sdk.lh;
import com.flurry.sdk.mq;
import com.flurry.sdk.mw;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class kp {
   protected final mw a;
   protected final HashMap b = new LinkedHashMap();
   protected List c;
   protected HashMap d;
   protected HashSet e;
   protected kx f;
   protected ks g;
   protected boolean h;

   public kp(mw var1) {
      this.a = var1;
   }

   public jg a(is var1) {
      kz var2 = new kz(this.b.values());
      var2.a();
      return new ko(this.a, var1, this.f, var2, this.d, this.e, this.h, this.g, this.c);
   }

   public void a(it var1) {
   }

   public void a(ks var1) {
      if(this.g != null && var1 != null) {
         throw new IllegalStateException("_anySetter already set to non-null");
      } else {
         this.g = var1;
      }
   }

   public void a(kt var1) {
      kt var2 = (kt)this.b.put(var1.c(), var1);
      if(var2 != null && var2 != var1) {
         throw new IllegalArgumentException("Duplicate property \'" + var1.c() + "\' for " + this.a.a());
      }
   }

   public void a(kt var1, boolean var2) {
      this.b.put(var1.c(), var1);
   }

   public void a(kx var1) {
      this.f = var1;
   }

   public void a(String var1) {
      if(this.e == null) {
         this.e = new HashSet();
      }

      this.e.add(var1);
   }

   public void a(String var1, kt var2) {
      if(this.d == null) {
         this.d = new HashMap(4);
      }

      this.d.put(var1, var2);
      if(this.b != null) {
         this.b.remove(var2.c());
      }

   }

   public void a(String var1, sh var2, qv var3, mq var4, Object var5) {
      if(this.c == null) {
         this.c = new ArrayList();
      }

      this.c.add(new lh(var1, var2, var3, var4, var5));
   }

   public void a(boolean var1) {
      this.h = var1;
   }

   public boolean b(String var1) {
      return this.b.containsKey(var1);
   }
}
