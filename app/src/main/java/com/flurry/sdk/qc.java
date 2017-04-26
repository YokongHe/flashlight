package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.qb;
import com.flurry.sdk.qc$a;
import com.flurry.sdk.qc$b;
import com.flurry.sdk.qc$c;
import com.flurry.sdk.sh;
import java.util.Calendar;
import java.util.Date;

public class qc {
   protected static final jk a = new qb();
   protected static final jk b = new qc$c();

   public static jk a(sh var0) {
      if(var0 == null) {
         return a;
      } else {
         Class var1 = var0.p();
         return var1 == String.class?b:(var1 == Object.class?a:(Date.class.isAssignableFrom(var1)?qc$b.a:(Calendar.class.isAssignableFrom(var1)?qc$a.a:a)));
      }
   }
}
