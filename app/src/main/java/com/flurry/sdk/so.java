package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.sn;
import java.util.ArrayList;
import java.util.List;

public class so extends sn {
   protected final hj[] e;
   protected int f;

   protected so(hj[] var1) {
      super(var1[0]);
      this.e = var1;
      this.f = 1;
   }

   public static so a(hj var0, hj var1) {
      if(!(var0 instanceof so) && !(var1 instanceof so)) {
         return new so(new hj[]{var0, var1});
      } else {
         ArrayList var2 = new ArrayList();
         if(var0 instanceof so) {
            ((so)var0).a(var2);
         } else {
            var2.add(var0);
         }

         if(var1 instanceof so) {
            ((so)var1).a(var2);
         } else {
            var2.add(var1);
         }

         return new so((hj[])var2.toArray(new hj[var2.size()]));
      }
   }

   protected boolean A() {
      if(this.f >= this.e.length) {
         return false;
      } else {
         hj[] var2 = this.e;
         int var1 = this.f;
         this.f = var1 + 1;
         this.d = var2[var1];
         return true;
      }
   }

   protected void a(List var1) {
      int var2 = this.f;
      int var3 = this.e.length;
      --var2;

      for(; var2 < var3; ++var2) {
         hj var4 = this.e[var2];
         if(var4 instanceof so) {
            ((so)var4).a(var1);
         } else {
            var1.add(var4);
         }
      }

   }

   public hm b() {
      hm var1 = this.d.b();
      if(var1 != null) {
         return var1;
      } else {
         do {
            if(!this.A()) {
               return null;
            }

            var1 = this.d.b();
         } while(var1 == null);

         return var1;
      }
   }

   public void close() {
      do {
         this.d.close();
      } while(this.A());

   }
}
