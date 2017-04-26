package com.flurry.sdk;

import com.flurry.sdk.ed;
import com.flurry.sdk.el;
import com.flurry.sdk.el$a;
import com.flurry.sdk.em;
import com.flurry.sdk.en$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.ew;
import com.flurry.sdk.ex;
import com.flurry.sdk.gw;
import com.flurry.sdk.w$a;
import java.util.List;

public class w {
   private static final String a = com.flurry.sdk.w.class.getSimpleName();

   int a(byte[] var1) {
      ed var2 = new ed();
      var2.update(var1);
      return var2.b();
   }

   public void a(Object var1, String var2, gw var3, Class var4, Class var5, w$a var6) {
      this.a(var1, var2, com.flurry.sdk.v.a(var3, var4), var5, var6);
   }

   public void a(Object var1, final String var2, byte[] var3, final Class var4, final w$a var5) {
      el var6 = new el();
      var6.a((String)var2);
      var6.a((en$a)en$a.c);
      var6.a("Content-Type", "avro/binary");
      var6.a("Accept", "avro/binary");
      var6.a("FM-Checksum", Integer.toString(this.a(var3)));
      var6.a((ex)(new ew()));
      var6.b((ex)(new ew()));
      var6.a((Object)var3);
      var6.a(new el$a() {
         public void a(el var1, byte[] var2x) {
            Object var4x = null;
            int var3 = var1.e();
            if(var1.c() && var2x != null && var2x.length > 0) {
               List var6 = var1.b((String)"FM-Checksum");
               if(var6 != null && var6.size() > 0 && Integer.toString(w.this.a(var2x)).equals(var6.get(0))) {
                  eo.a(4, com.flurry.sdk.w.a, "Request successful, decoding");

                  gw var7;
                  try {
                     var7 = com.flurry.sdk.v.a(var2x, var4);
                  } catch (Throwable var5x) {
                     eo.a(6, com.flurry.sdk.w.a, "Error decoding response", var5x);
                     var7 = (gw)var4x;
                  }

                  var5.a(var3, var7);
                  return;
               }

               eo.a(6, com.flurry.sdk.w.a, "Response was received, but checksum failed.");
            } else {
               eo.a(6, com.flurry.sdk.w.a, "Request to url = " + var2 + " failed.");
            }

            var5.a(var3, (gw)null);
         }
      });
      em.a().a(var1, var6);
   }
}
