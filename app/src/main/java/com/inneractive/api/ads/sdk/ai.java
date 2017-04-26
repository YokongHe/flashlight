package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAvastMediaFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ai extends com.inneractive.api.ads.sdk.ag implements com.inneractive.api.ads.sdk.ap {
   private String g;
   private List h = new ArrayList();
   private List i = new ArrayList();
   private List j = new ArrayList();

   public final List a(int var1) {
      Iterator var2 = this.h.iterator();
      ArrayList var3 = new ArrayList();

      while(var2.hasNext()) {
         com.inneractive.api.ads.sdk.aq var4 = (com.inneractive.api.ads.sdk.aq)var2.next();
         if(var4.a() == var1) {
            var3.add(var4.b());
         }
      }

      return var3;
   }

   final void a(IAvastMediaFile var1) {
      this.i.add(var1);
   }

   public final void a(com.inneractive.api.ads.sdk.ao var1) {
      this.j.add(var1);
   }

   public final void a(String var1, String var2) {
      this.h.add(new com.inneractive.api.ads.sdk.aq(var1, var2));
   }

   final IAvastMediaFile b(int var1) {
      return this.i.size() <= 0?null:(IAvastMediaFile)this.i.get(0);
   }

   final int c() {
      return this.i == null?0:this.i.size();
   }

   final void c(int var1) {
      if(this.i.size() > 0) {
         this.i.remove(0);
      }

   }

   final void c(String var1) {
      this.g = var1;
   }

   final List d() {
      return this.i;
   }

   final String e() {
      return this.g;
   }
}
