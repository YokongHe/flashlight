package com.millennialmedia.a.a.b.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class d extends com.millennialmedia.a.a.s {
   public static final com.millennialmedia.a.a.t a = new com.millennialmedia.a.a.t() {
      public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
         return var2.a() == Date.class?new d():null;
      }
   };
   private final DateFormat b;
   private final DateFormat c;
   private final DateFormat d;

   public d() {
      this.b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
      this.c = DateFormat.getDateTimeInstance(2, 2);
      SimpleDateFormat var1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss\'Z\'", Locale.US);
      var1.setTimeZone(TimeZone.getTimeZone("UTC"));
      this.d = var1;
   }

   private Date a(String var1) {
      synchronized(this){}
      boolean var7 = false;

      Date var2;
      Date var12;
      label84: {
         label85: {
            try {
               try {
                  var7 = true;
                  var2 = this.c.parse(var1);
                  var7 = false;
                  break label84;
               } catch (ParseException var9) {
                  ;
               }

               try {
                  var2 = this.b.parse(var1);
                  var7 = false;
                  break label85;
               } catch (ParseException var10) {
                  try {
                     var2 = this.d.parse(var1);
                     var7 = false;
                  } catch (ParseException var8) {
                     throw new com.millennialmedia.a.a.q(var1, var8);
                  }
               }
            } finally {
               if(var7) {
                  ;
               }
            }

            var12 = var2;
            return var12;
         }

         var12 = var2;
         return var12;
      }

      var12 = var2;
      return var12;
   }

   private void a(com.millennialmedia.a.a.d.c param1, Date param2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public final Object a(com.millennialmedia.a.a.d.a var1) {
      if(var1.f() == com.millennialmedia.a.a.d.b.i) {
         var1.j();
         return null;
      } else {
         return this.a(var1.h());
      }
   }
}
