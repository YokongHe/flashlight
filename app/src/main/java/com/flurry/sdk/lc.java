package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.kt;
import com.flurry.sdk.lc$b;
import com.flurry.sdk.sq;
import java.util.HashMap;

public class lc {
   private final lc$b[] a;
   private final HashMap b;
   private final String[] c;
   private final sq[] d;

   protected lc(lc var1) {
      this.a = var1.a;
      this.b = var1.b;
      int var2 = this.a.length;
      this.c = new String[var2];
      this.d = new sq[var2];
   }

   protected lc(lc$b[] var1, HashMap var2, String[] var3, sq[] var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public lc a() {
      return new lc(this);
   }

   public Object a(hj var1, iz var2, Object var3) {
      int var4 = 0;

      for(int var5 = this.a.length; var4 < var5; ++var4) {
         if(this.c[var4] == null) {
            if(this.d[var4] != null) {
               throw var2.b("Missing external type id property \'" + this.a[var4].a());
            }
         } else {
            if(this.d[var4] == null) {
               kt var6 = this.a[var4].b();
               throw var2.b("Missing property \'" + var6.c() + "\' for external type id \'" + this.a[var4].a());
            }

            this.a(var1, var2, var3, var4);
         }
      }

      return var3;
   }

   protected final void a(hj var1, iz var2, Object var3, int var4) {
      sq var5 = new sq(var1.a());
      var5.b();
      var5.b(this.c[var4]);
      hj var6 = this.d[var4].a(var1);
      var6.b();
      var5.c(var6);
      var5.c();
      var1 = var5.a(var1);
      var1.b();
      this.a[var4].b().a(var1, var2, var3);
   }

   public boolean a(hj var1, iz var2, String var3, Object var4) {
      boolean var6 = false;
      Integer var8 = (Integer)this.b.get(var3);
      if(var8 == null) {
         return false;
      } else {
         int var7 = var8.intValue();
         boolean var5;
         if(this.a[var7].a(var3)) {
            this.c[var7] = var1.k();
            var1.d();
            if(var4 != null && this.d[var7] != null) {
               var5 = true;
            } else {
               var5 = false;
            }
         } else {
            sq var9 = new sq(var1.a());
            var9.c(var1);
            this.d[var7] = var9;
            var5 = var6;
            if(var4 != null) {
               var5 = var6;
               if(this.c[var7] != null) {
                  var5 = true;
               }
            }
         }

         if(var5) {
            this.a(var1, var2, var4, var7);
            this.c[var7] = null;
            this.d[var7] = null;
         }

         return true;
      }
   }
}
