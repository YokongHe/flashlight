package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.jn;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mq;
import com.flurry.sdk.nf;
import com.flurry.sdk.ng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class nt extends ng {
   protected LinkedHashSet a;

   public Collection a(mn var1, jn var2, iq var3) {
      HashMap var4 = new HashMap();
      if(this.a != null) {
         Class var5 = var1.d();
         Iterator var6 = this.a.iterator();

         while(var6.hasNext()) {
            nf var7 = (nf)var6.next();
            if(var5.isAssignableFrom(var7.a())) {
               this.a(mn.b(var7.a(), var3, var2), var7, var2, var3, var4);
            }
         }
      }

      this.a(var1, new nf(var1.d(), (String)null), var2, var3, var4);
      return new ArrayList(var4.values());
   }

   public Collection a(mq var1, jn var2, iq var3) {
      HashMap var4 = new HashMap();
      if(this.a != null) {
         Class var5 = var1.d();
         Iterator var6 = this.a.iterator();

         while(var6.hasNext()) {
            nf var7 = (nf)var6.next();
            if(var5.isAssignableFrom(var7.a())) {
               this.a(mn.b(var7.a(), var3, var2), var7, var2, var3, var4);
            }
         }
      }

      List var8 = var3.a((mm)var1);
      if(var8 != null) {
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            nf var11 = (nf)var9.next();
            this.a(mn.b(var11.a(), var3, var2), var11, var2, var3, var4);
         }
      }

      nf var10 = new nf(var1.d(), (String)null);
      this.a(mn.b(var1.d(), var3, var2), var10, var2, var3, var4);
      return new ArrayList(var4.values());
   }

   protected void a(mn var1, nf var2, jn var3, iq var4, HashMap var5) {
      nf var6 = var2;
      if(!var2.c()) {
         String var7 = var4.g(var1);
         var6 = var2;
         if(var7 != null) {
            var6 = new nf(var2.a(), var7);
         }
      }

      if(var5.containsKey(var6)) {
         if(var6.c() && !((nf)var5.get(var6)).c()) {
            var5.put(var6, var6);
         }
      } else {
         var5.put(var6, var6);
         List var8 = var4.a((mm)var1);
         nf var9;
         mn var11;
         if(var8 != null && !var8.isEmpty()) {
            for(Iterator var10 = var8.iterator(); var10.hasNext(); this.a(var11, var9, var3, var4, var5)) {
               var9 = (nf)var10.next();
               var11 = mn.b(var9.a(), var4, var3);
               if(!var9.c()) {
                  var9 = new nf(var9.a(), var4.g(var11));
               }
            }
         }
      }

   }
}
