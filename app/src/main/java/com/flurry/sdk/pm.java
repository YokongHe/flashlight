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
public class pm extends pb {
   public pm(sh var1, boolean var2, jz var3, is var4) {
      super(Iterable.class, var1, var2, var3, var4, (jk)null);
   }

   public pf a(jz var1) {
      return new pm(this.b, this.a, var1, this.e);
   }

   public void a(Iterable var1, hf var2, jw var3) {
      Class var4 = null;
      Iterator var6 = var1.iterator();
      if(var6.hasNext()) {
         jz var7 = this.c;
         jk var9 = null;

         do {
            Object var8 = var6.next();
            if(var8 == null) {
               var3.a(var2);
            } else {
               Class var5 = var8.getClass();
               jk var10;
               if(var5 == var4) {
                  var10 = var9;
               } else {
                  var9 = var3.a(var5, this.e);
                  var4 = var5;
                  var10 = var9;
               }

               if(var7 == null) {
                  var10.a(var8, var2, var3);
               } else {
                  var10.a(var8, var2, var3, var7);
               }
            }
         } while(var6.hasNext());
      }

   }

   // $FF: synthetic method
   public void b(Object var1, hf var2, jw var3) {
      this.a((Iterable)var1, var2, var3);
   }
}
