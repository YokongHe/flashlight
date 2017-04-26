package com.ihs.a.c.a;

import java.util.Iterator;
import java.util.List;

public final class q {
   private List a;
   private List b;
   private int c;
   private com.ihs.a.c.a.s d;

   private static boolean a(com.ihs.a.c.a.j var0, List var1) {
      Iterator var4 = var1.iterator();

      boolean var2;
      List var5;
      while(true) {
         if(var4.hasNext()) {
            List var3 = (List)var4.next();
            if(!var3.contains(var0)) {
               continue;
            }

            var3.remove(var0);
            var5 = var3;
            var2 = true;
            break;
         }

         var2 = false;
         var5 = null;
         break;
      }

      if(var2 && var5 != null && var5.isEmpty()) {
         var1.remove(var5);
      }

      return var2;
   }

   protected final void a() {
      label17:
      while(true) {
         if(this.b.size() < this.c && this.a.size() > 0) {
            List var1 = (List)this.a.get(0);
            this.a.remove(0);
            this.b.add(var1);
            Iterator var3 = var1.iterator();

            while(true) {
               if(!var3.hasNext()) {
                  continue label17;
               }

               com.ihs.a.c.a.j var2 = (com.ihs.a.c.a.j)var3.next();
               var2.d();
               (new StringBuilder("Start Connection:")).append(var2).toString();
            }
         }

         (new StringBuilder("Wait List:")).append(this.a.size()).append("Work List:").append(this.b.size()).toString();
         return;
      }
   }

   public final void a(com.ihs.a.c.a.j var1) {
      if(!a(var1, this.b)) {
         a(var1, this.a);
      }

      if(this.b.isEmpty()) {
         this.a.isEmpty();
      }

      if(this.d != null) {
         this.d.a();
         this.d = null;
      }

      this.d = com.ihs.a.c.a.s.a(new Runnable() {
         public final void run() {
            q.this.a();
         }
      });
   }
}
