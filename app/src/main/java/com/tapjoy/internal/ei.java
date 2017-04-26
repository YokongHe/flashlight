package com.tapjoy.internal;

import android.net.http.AndroidHttpClient;
import android.util.Log;
import com.tapjoy.internal.ej;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.ek$a;
import com.tapjoy.internal.ey;
import com.tapjoy.internal.fc;
import com.tapjoy.internal.fc$c;
import java.io.IOException;
import java.util.Map;

class ei extends ek {
   private static final String e = ei.class.getName();
   public ey a = null;

   public ei(AndroidHttpClient var1, String var2, ej var3, Map var4, fc var5) {
      super(var1, ek$a.a, var2, var3, var4, var5);
   }

   public final fc$c a() {
      return this.b.f() == fc$c.b?(this.a != null && this.a.a()?fc$c.b:fc$c.j):super.a();
   }

   public void run() {
      String var1 = e;
      (new StringBuilder("starting retrieval: ")).append(this.c).append("?").append(this.d.b());
      this.a = null;
      super.run();
      if(this.b() == 200) {
         this.a = new ey();

         try {
            this.a.a(super.b.d().getEntity().getContent());
         } catch (IOException var2) {
            Log.e(e, "IO Error", var2);
            return;
         }
      }

   }
}
