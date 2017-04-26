package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

final class N implements com.google.android.gms.tagmanager.d {
   private final Context a;

   public N(Context var1) {
      this.a = var1;
   }

   public final void a(Map var1) {
      Object var3;
      label22: {
         Object var2 = var1.get("gtm.url");
         if(var2 == null) {
            var3 = var1.get("gtm");
            if(var3 != null && var3 instanceof Map) {
               var3 = ((Map)var3).get("url");
               break label22;
            }
         }

         var3 = var2;
      }

      if(var3 != null && var3 instanceof String) {
         String var4 = Uri.parse((String)var3).getQueryParameter("referrer");
         if(var4 != null) {
            com.google.android.gms.tagmanager.m.b(this.a, var4);
            return;
         }
      }

   }
}
