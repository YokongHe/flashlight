package com.flurry.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class be implements com.flurry.sdk.bf {
   private final List a;

   public be() {
      ArrayList var1 = new ArrayList();
      var1.add(new com.flurry.sdk.bd());
      var1.add(new com.flurry.sdk.bi());
      var1.add(new com.flurry.sdk.bb());
      var1.add(new com.flurry.sdk.bh());
      this.a = Collections.unmodifiableList(var1);
   }

   public final boolean a(Context var1, com.flurry.sdk.bj var2) {
      boolean var4;
      if(var1 != null && var2 != null) {
         Iterator var5 = this.a.iterator();
         boolean var3 = true;

         while(true) {
            var4 = var3;
            if(!var5.hasNext()) {
               break;
            }

            if(!((com.flurry.sdk.bf)var5.next()).a(var1, var2)) {
               var3 = false;
            }
         }
      } else {
         var4 = false;
      }

      return var4;
   }
}
