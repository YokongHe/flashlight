package com.millennialmedia.a.a.b.a;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class m extends com.millennialmedia.a.a.s {
   public static final com.millennialmedia.a.a.t a = new com.millennialmedia.a.a.t() {
      public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
         return var2.a() == Date.class?new m():null;
      }
   };
   private final DateFormat b = new SimpleDateFormat("MMM d, yyyy");

   private void a(com.millennialmedia.a.a.d.c param1, Date param2) {
      // $FF: Couldn't be decompiled
   }

   private Date b(com.millennialmedia.a.a.d.a var1) {
      synchronized(this){}
      boolean var4 = false;

      Date var7;
      try {
         var4 = true;
         if(var1.f() != com.millennialmedia.a.a.d.b.i) {
            try {
               var7 = new Date(this.b.parse(var1.h()).getTime());
               var4 = false;
               return var7;
            } catch (ParseException var5) {
               throw new com.millennialmedia.a.a.q(var5);
            }
         }

         var1.j();
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      var7 = null;
      return var7;
   }

   // $FF: synthetic method
   public final Object a(com.millennialmedia.a.a.d.a var1) {
      return this.b(var1);
   }
}
