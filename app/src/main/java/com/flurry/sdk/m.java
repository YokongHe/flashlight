package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public final class m {
   private static final String a = com.flurry.sdk.m.class.getSimpleName();
   private Map b = new HashMap();

   private void a(String var1, com.flurry.sdk.l var2) {
      Stack var4 = (Stack)this.b.get(var1);
      Stack var3 = var4;
      if(var4 == null) {
         var3 = new Stack();
         this.b.put(var1, var3);
      }

      var3.push(new WeakReference(var2));
   }

   public final com.flurry.sdk.l a(FlurryAdModule param1, Context param2, ViewGroup param3, String param4) {
      // $FF: Couldn't be decompiled
   }

   public final com.flurry.sdk.l a(String var1) {
      synchronized(this){}
      boolean var3 = false;

      com.flurry.sdk.l var6;
      label63: {
         try {
            var3 = true;
            if(this.b.containsKey(var1)) {
               Stack var5 = (Stack)this.b.get(var1);
               if(var5.size() > 0) {
                  var6 = (com.flurry.sdk.l)((WeakReference)var5.peek()).get();
                  var3 = false;
                  return var6;
               }

               var3 = false;
               break label63;
            }

            var3 = false;
         } finally {
            if(var3) {
               ;
            }
         }

         var6 = null;
         return var6;
      }

      var6 = null;
      return var6;
   }

   public final List a(Context param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(com.flurry.sdk.l param1) {
      // $FF: Couldn't be decompiled
   }
}
