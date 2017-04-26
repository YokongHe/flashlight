package com.flurry.sdk;

import com.flurry.sdk.hq;
import com.flurry.sdk.ip;
import com.flurry.sdk.jd;
import com.flurry.sdk.jl;
import com.flurry.sdk.jm;
import com.flurry.sdk.jp;
import com.flurry.sdk.jp$a;
import com.flurry.sdk.jx;
import com.flurry.sdk.ky;
import com.flurry.sdk.nz;
import com.flurry.sdk.oa;
import com.flurry.sdk.ob;
import com.flurry.sdk.od;
import com.flurry.sdk.oe;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class oc extends jp {
   protected final String a;
   protected final hq b;
   protected od c = null;
   protected oa d = null;
   protected od e = null;
   protected ob f = null;
   protected nz g = null;
   protected oe h = null;
   protected HashMap i = null;

   public oc(String var1, hq var2) {
      this.a = var1;
      this.b = var2;
   }

   public oc a(Class var1, jl var2) {
      if(this.f == null) {
         this.f = new ob();
      }

      this.f.a(var1, var2);
      return this;
   }

   public String a() {
      return this.a;
   }

   public void a(jp$a var1) {
      if(this.c != null) {
         var1.a((jx)this.c);
      }

      if(this.d != null) {
         var1.a((jd)this.d);
      }

      if(this.e != null) {
         var1.b(this.e);
      }

      if(this.f != null) {
         var1.a((jm)this.f);
      }

      if(this.g != null) {
         var1.a((ip)this.g);
      }

      if(this.h != null) {
         var1.a((ky)this.h);
      }

      if(this.i != null) {
         Iterator var2 = this.i.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            var1.a((Class)var3.getKey(), (Class)var3.getValue());
         }
      }

   }

   public hq b() {
      return this.b;
   }
}
