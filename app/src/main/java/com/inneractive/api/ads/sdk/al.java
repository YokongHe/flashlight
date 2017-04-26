package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class al {
   private static ThreadPoolExecutor b;
   private List a;

   private static URL b(String var0) {
      URL var4;
      try {
         var4 = new URL(var0);
      } catch (Exception var3) {
         return null;
      }

      try {
         URL var1 = (new URI(var4.getProtocol(), var4.getUserInfo(), var4.getHost(), var4.getPort(), var4.getPath(), var4.getQuery(), var4.getRef())).toURL();
         return var1;
      } catch (Exception var2) {
         return var4;
      }
   }

   protected final void a() {
      long var1 = System.currentTimeMillis();
      InneractiveAdView$Log.a(this + ": Start hitting " + this.a.size() + " urls");
      Iterator var3 = this.a.iterator();

      while(var3.hasNext()) {
         final String var4 = (String)var3.next();

         try {
            b.submit(new Runnable() {
               // $FF: synthetic field
               private String a = var4;
               // $FF: synthetic field
               private com.inneractive.api.ads.sdk.al b = al.this;

               public final void run() {
                  this.b.a(this.a);
               }
            });
         } catch (Exception var5) {
            var5.printStackTrace();
         }
      }

      InneractiveAdView$Log.a(this + ": End hitting " + this.a.size() + " urls took " + (System.currentTimeMillis() - var1) + " millis");
   }

   protected final void a(String param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(List var1) {
      if(var1 != null && var1.size() != 0) {
         this.a = var1;
         if(b == null) {
            b = new ThreadPoolExecutor(1, 8, 1000L, TimeUnit.SECONDS, new LinkedBlockingQueue(100));
         }

         try {
            b.submit(new Runnable() {
               // $FF: synthetic field
               private com.inneractive.api.ads.sdk.al a = al.this;

               public final void run() {
                  this.a.a();
               }
            });
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }
   }
}
