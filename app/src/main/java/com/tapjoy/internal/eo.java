package com.tapjoy.internal;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

class eo implements ValueCallback {
   CountDownLatch a = null;
   public String b;
   public final ArrayList c = new ArrayList();
   private final String d = eo.class.getName();

   eo(CountDownLatch var1) {
      this.a(var1);
   }

   private void a(String param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   public final void a(CountDownLatch var1) {
      String var2;
      if(this.a != null) {
         var2 = this.d;
         (new StringBuilder("existing latch: ")).append(this.a.hashCode()).append(" with count: ").append(this.a.getCount());
         var2 = this.d;
      }

      this.a = var1;
      if(this.a != null) {
         var2 = this.d;
         (new StringBuilder("new latch: ")).append(var1.hashCode()).append(" with count: ").append(var1.getCount());
      }

   }

   @JavascriptInterface
   public final void getString(String var1) {
      this.a(var1, "getString");
   }

   // $FF: synthetic method
   public void onReceiveValue(Object var1) {
      String var2 = (String)var1;
      String var3 = var2;
      if(var2 != null) {
         if(var2.length() == 2 && var2.equals("\"\"")) {
            var3 = "";
         } else {
            var3 = var2;
            if(var2.length() > 1) {
               var3 = var2.substring(1, var2.length() - 1);
            }
         }
      }

      this.a(var3, "onReceiveValue");
   }
}
