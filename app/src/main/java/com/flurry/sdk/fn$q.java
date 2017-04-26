package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fo;
import com.flurry.sdk.hi;
import com.flurry.sdk.hj;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class fn$q {
   private fn$o a = new fn$o();
   private boolean b = true;

   private fn a(hj var1) {
      boolean var2 = ((Boolean)fn.q().get()).booleanValue();

      fn var7;
      try {
         fn.q().set(Boolean.valueOf(this.b));
         var7 = fn.a(fn.b.a(var1), this.a);
      } catch (hi var5) {
         throw new fo(var5);
      } finally {
         fn.q().set(Boolean.valueOf(var2));
      }

      return var7;
   }

   public fn a(String var1) {
      try {
         fn var3 = this.a(fn.a.a((Reader)(new StringReader(var1))));
         return var3;
      } catch (IOException var2) {
         throw new fo(var2);
      }
   }
}
