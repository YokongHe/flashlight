package com.tapjoy.internal;

import com.tapjoy.internal.ha;
import com.tapjoy.internal.he;
import com.tapjoy.internal.hh;

public final class gz {
   final ha a;
   final hh b;
   private final String c;

   public gz(String var1, hh var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Name may not be null");
      } else if(var2 == null) {
         throw new IllegalArgumentException("Body may not be null");
      } else {
         this.c = var1;
         this.b = var2;
         this.a = new ha();
         StringBuilder var3 = new StringBuilder();
         var3.append("form-data; name=\"");
         var3.append(this.c);
         var3.append("\"");
         this.a("Content-Disposition", var3.toString());
         var3 = new StringBuilder();
         var3.append(var2.a());
         if(var2.b() != null) {
            var3.append("; charset=");
            var3.append(var2.b());
         }

         this.a("Content-Type", var3.toString());
         this.a("Content-Transfer-Encoding", var2.c());
      }
   }

   private void a(String var1, String var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("Field name may not be null");
      } else {
         this.a.a(new he(var1, var2));
      }
   }
}
