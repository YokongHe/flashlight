package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.tapjoy.internal.ej;
import com.tapjoy.internal.ek$a;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.fc$c;
import com.tapjoy.internal.ff;
import java.util.Map;

class ek implements Runnable {
   private static final String f = ek.class.getName();
   private final ek$a a;
   final ff b;
   final String c;
   final ej d;
   private final fc e;

   public ek(AndroidHttpClient var1, ek$a var2, String var3, ej var4, Map var5, fc var6) {
      this.b = new ff(var1);
      this.b.a(var5);
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.e = var6;
   }

   public fc$c a() {
      return this.b.f();
   }

   public final int b() {
      return this.b.d() != null?this.b.d().getStatusLine().getStatusCode():0;
   }

   public final void c() {
      this.b.c();
   }

   public void run() {
      String var3 = f;
      (new StringBuilder("starting retrieval: ")).append(this.c);
      long var1 = -1L;
      if(this.a != ek$a.a && this.a != ek$a.b) {
         if(this.a == ek$a.c || this.a == ek$a.d) {
            var1 = this.b.a(this.c, this.d.c());
         }
      } else {
         var1 = this.b.a(this.c + "?" + this.d.b());
      }

      if(var1 < 0L) {
         Log.w(f, "failed to retrieve from " + this.b.b());
         if(this.e != null) {
            this.e.a(this.b.f());
         }
      } else {
         var3 = f;
         (new StringBuilder("retrieved: ")).append(this.b.a());
         if(var1 != 200L) {
            Log.w(f, "error (" + var1 + ") status on request to " + this.b.b());
            return;
         }

         if(this.a == ek$a.b || this.a == ek$a.d) {
            var3 = f;
            this.b.e();
            return;
         }
      }

   }
}
