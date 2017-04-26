package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class dt {
   private final List a = new LinkedList();

   public List a() {
      ArrayList var1 = new ArrayList(this.a.size());
      Iterator var2 = this.a.iterator();

      while(var2.hasNext()) {
         Object var3 = ((WeakReference)var2.next()).get();
         if(var3 == null) {
            var2.remove();
         } else {
            var1.add(var3);
         }
      }

      return var1;
   }

   public void a(Object var1) {
      if(var1 != null) {
         this.a.add(new WeakReference(var1));
      }
   }

   public int b() {
      return this.a.size();
   }

   public boolean b(Object var1) {
      if(var1 == null) {
         return false;
      } else {
         Iterator var2 = this.a.iterator();

         Object var3;
         label27:
         do {
            while(var2.hasNext()) {
               var3 = ((WeakReference)var2.next()).get();
               if(var3 != null) {
                  continue label27;
               }

               var2.remove();
            }

            return false;
         } while(var1 != var3 && !var1.equals(var3));

         var2.remove();
         return true;
      }
   }
}
