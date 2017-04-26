package com.flurry.sdk;

import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.nh;
import com.flurry.sdk.sh;
import java.util.HashMap;

public abstract class nv extends jy {
   protected final nh b;
   protected final sh c;
   protected final is d;
   protected final sh e;
   protected final HashMap f;
   protected jg g;

   protected nv(sh var1, nh var2, is var3, Class var4) {
      this.c = var1;
      this.b = var2;
      this.d = var3;
      this.f = new HashMap();
      if(var4 == null) {
         this.e = null;
      } else {
         this.e = var1.g(var4);
      }
   }

   protected final jg a(iz var1) {
      if(this.e == null) {
         return null;
      } else {
         sh var2 = this.e;
         synchronized(var2) {
            if(this.g == null) {
               this.g = var1.b().a(var1.a(), this.e, this.d);
            }

            jg var4 = this.g;
            return var4;
         }
      }
   }

   protected final jg a(iz param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public String b() {
      return null;
   }

   public String c() {
      return this.c.p().getName();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append('[').append(this.getClass().getName());
      var1.append("; base-type:").append(this.c);
      var1.append("; id-resolver: ").append(this.b);
      var1.append(']');
      return var1.toString();
   }
}
