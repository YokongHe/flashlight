package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.pb;
import com.flurry.sdk.pf;
import com.flurry.sdk.sh;
import java.util.EnumSet;
import java.util.Iterator;

public class pj extends pb {
   public pj(sh var1, is var2) {
      super(EnumSet.class, var1, true, (jz)null, var2, (jk)null);
   }

   public pf a(jz var1) {
      return this;
   }

   public void a(EnumSet var1, hf var2, jw var3) {
      jk var4 = this.d;
      Iterator var5 = var1.iterator();

      for(jk var7 = var4; var5.hasNext(); var7 = var4) {
         Enum var6 = (Enum)var5.next();
         var4 = var7;
         if(var7 == null) {
            var4 = var3.a(var6.getDeclaringClass(), this.e);
         }

         var4.a(var6, var2, var3);
      }

   }

   // $FF: synthetic method
   public void b(Object var1, hf var2, jw var3) {
      this.a((EnumSet)var1, var2, var3);
   }
}
