package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.kt;
import com.flurry.sdk.mq;
import com.flurry.sdk.qv;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class kt$c extends kt {
   protected final String i;
   protected final boolean j;
   protected final kt k;
   protected final kt l;

   protected kt$c(kt$c var1, jg var2) {
      super(var1, var2);
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
   }

   public kt$c(String var1, kt var2, kt var3, qv var4, boolean var5) {
      super(var2.c(), var2.a(), var2.e, var4);
      this.i = var1;
      this.k = var2;
      this.l = var3;
      this.j = var5;
   }

   // $FF: synthetic method
   public final kt a(jg var1) {
      return this.b(var1);
   }

   public final void a(hj var1, iz var2, Object var3) {
      this.a(var3, this.k.a(var1, var2));
   }

   public final void a(Object var1, Object var2) {
      this.k.a(var1, var2);
      if(var2 != null) {
         if(this.j) {
            Object var5;
            if(var2 instanceof Object[]) {
               Object[] var6 = (Object[])var2;
               int var4 = var6.length;

               for(int var3 = 0; var3 < var4; ++var3) {
                  var5 = var6[var3];
                  if(var5 != null) {
                     this.l.a(var5, var1);
                  }
               }
            } else {
               Iterator var7;
               if(var2 instanceof Collection) {
                  var7 = ((Collection)var2).iterator();

                  while(var7.hasNext()) {
                     var5 = var7.next();
                     if(var5 != null) {
                        this.l.a(var5, var1);
                     }
                  }
               } else {
                  if(!(var2 instanceof Map)) {
                     throw new IllegalStateException("Unsupported container type (" + var2.getClass().getName() + ") when resolving reference \'" + this.i + "\'");
                  }

                  var7 = ((Map)var2).values().iterator();

                  while(var7.hasNext()) {
                     var5 = var7.next();
                     if(var5 != null) {
                        this.l.a(var5, var1);
                     }
                  }
               }
            }
         } else {
            this.l.a(var2, var1);
         }
      }

   }

   public final kt$c b(jg var1) {
      return new kt$c(this, var1);
   }

   public final mq b() {
      return this.k.b();
   }
}
