package com.flurry.sdk;

import com.flurry.sdk.is;
import com.flurry.sdk.mq;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;

public class is$a implements is {
   protected final String a;
   protected final sh b;
   protected final mq c;
   protected final qv d;

   public is$a(String var1, sh var2, qv var3, mq var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var3;
   }

   public is$a a(sh var1) {
      return new is$a(this.a, var1, this.d, this.c);
   }

   public sh a() {
      return this.b;
   }

   public mq b() {
      return this.c;
   }

   public String c() {
      return this.a;
   }
}
