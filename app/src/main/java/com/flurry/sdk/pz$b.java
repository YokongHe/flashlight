package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.kb;
import com.flurry.sdk.pb;
import com.flurry.sdk.pf;
import com.flurry.sdk.sh;
import java.util.Iterator;

@kb
public class pz$b extends pb {
   public pz$b(sh var1, boolean var2, jz var3, is var4) {
      super(Iterator.class, var1, var2, var3, var4, (jk)null);
   }

   public pf a(jz var1) {
      return new pz$b(this.b, this.a, var1, this.e);
   }

   public void a(Iterator var1, hf var2, jw var3) {
      Class var5 = null;
      if(var1.hasNext()) {
         jz var7 = this.c;
         jk var4 = null;

         do {
            Object var8 = var1.next();
            if(var8 == null) {
               var3.a(var2);
            } else {
               Class var6 = var8.getClass();
               jk var9;
               if(var6 == var5) {
                  var9 = var4;
               } else {
                  var4 = var3.a(var6, this.e);
                  var5 = var6;
                  var9 = var4;
               }

               if(var7 == null) {
                  var9.a(var8, var2, var3);
               } else {
                  var9.a(var8, var2, var3, var7);
               }
            }
         } while(var1.hasNext());
      }

   }

   // $FF: synthetic method
   public void b(Object var1, hf var2, jw var3) {
      this.a((Iterator)var1, var2, var3);
   }
}
