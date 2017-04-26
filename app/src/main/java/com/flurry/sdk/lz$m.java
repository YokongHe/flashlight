package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.mc;
import java.sql.Date;

public class lz$m extends mc {
   public lz$m() {
      super(Date.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Date b(hj var1, iz var2) {
      java.util.Date var3 = this.B(var1, var2);
      return var3 == null?null:new Date(var3.getTime());
   }
}
