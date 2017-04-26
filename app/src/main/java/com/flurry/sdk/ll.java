package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;
import java.util.Calendar;
import java.util.Date;

@kb
public class ll extends mc {
   protected final Class a;

   public ll() {
      this((Class)null);
   }

   public ll(Class var1) {
      super(Calendar.class);
      this.a = var1;
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Calendar b(hj var1, iz var2) {
      Date var5 = this.B(var1, var2);
      if(var5 == null) {
         return null;
      } else if(this.a == null) {
         return var2.a(var5);
      } else {
         try {
            Calendar var3 = (Calendar)this.a.newInstance();
            var3.setTimeInMillis(var5.getTime());
            return var3;
         } catch (Exception var4) {
            throw var2.a((Class)this.a, (Throwable)var4);
         }
      }
   }
}
