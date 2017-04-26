package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.lang.ref.WeakReference;

public abstract class aj {
   static final String a = com.flurry.sdk.aj.class.getSimpleName();
   private final WeakReference b;
   private final FlurryAdModule c;
   private final com.flurry.sdk.e d;
   private final AdUnit e;

   public aj(Context var1, FlurryAdModule var2, com.flurry.sdk.e var3, AdUnit var4) {
      this.b = new WeakReference(var1);
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   public abstract void a();

   public Context b() {
      return (Context)this.b.get();
   }

   public FlurryAdModule c() {
      return this.c;
   }

   public com.flurry.sdk.e d() {
      return this.d;
   }

   public AdUnit e() {
      return this.e;
   }
}
