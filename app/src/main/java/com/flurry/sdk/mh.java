package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.mc;
import java.sql.Timestamp;

public class mh extends mc {
   public mh() {
      super(Timestamp.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Timestamp b(hj var1, iz var2) {
      return new Timestamp(this.B(var1, var2).getTime());
   }
}
