package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.lang.ref.WeakReference;
import java.util.Map;

public class q {
   public final String a;
   public final Map b;
   public final AdUnit c;
   public final com.flurry.sdk.e d;
   public final int e;
   private final WeakReference f;

   public q(String var1, Map var2, Context var3, AdUnit var4, com.flurry.sdk.e var5, int var6) {
      this.a = var1;
      this.b = var2;
      this.f = new WeakReference(var3);
      this.c = var4;
      this.d = var5;
      this.e = var6;
   }

   public Context a() {
      return (Context)this.f.get();
   }

   public AdFrame b() {
      return (AdFrame)this.c.d().get(this.e);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("event=").append(this.a);
      var1.append(",params=").append(this.b);
      var1.append(",adspace=").append(this.c.b());
      return var1.toString();
   }
}
