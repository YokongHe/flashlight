package com.tapjoy;

import com.tapjoy.TapjoyCache;
import java.net.URL;
import java.util.concurrent.Callable;

public class TapjoyCache$CacheAssetThread implements Callable {
   // $FF: synthetic field
   final TapjoyCache a;
   private URL b;
   private String c;
   private long d;

   public TapjoyCache$CacheAssetThread(TapjoyCache var1, URL var2, String var3, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      if(this.d <= 0L) {
         this.d = 86400L;
      }

      TapjoyCache.b(var1).add(TapjoyCache.a(this.b.toString()));
   }

   public Boolean call() {
      // $FF: Couldn't be decompiled
   }
}
