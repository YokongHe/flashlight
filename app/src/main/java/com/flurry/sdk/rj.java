package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.rk;
import com.flurry.sdk.ro;
import com.flurry.sdk.ro$a;
import com.flurry.sdk.rs;
import java.util.ArrayList;
import java.util.Iterator;

public final class rj extends ro {
   protected ArrayList c;

   public rj(rs var1) {
      super(var1);
   }

   private boolean a(ArrayList var1) {
      int var3 = var1.size();
      if(this.p() != var3) {
         return false;
      } else {
         for(int var2 = 0; var2 < var3; ++var2) {
            if(!((hh)this.c.get(var2)).equals(var1.get(var2))) {
               return false;
            }
         }

         return true;
      }
   }

   private void b(hh var1) {
      if(this.c == null) {
         this.c = new ArrayList();
      }

      this.c.add(var1);
   }

   public final hh a(String var1) {
      return null;
   }

   public final void a(hf var1, jw var2) {
      var1.b();
      if(this.c != null) {
         Iterator var3 = this.c.iterator();

         while(var3.hasNext()) {
            ((rk)((hh)var3.next())).a(var1, var2);
         }
      }

      var1.c();
   }

   public final void a(hf var1, jw var2, jz var3) {
      var3.c(this, var1);
      if(this.c != null) {
         Iterator var4 = this.c.iterator();

         while(var4.hasNext()) {
            ((rk)((hh)var4.next())).a(var1, var2);
         }
      }

      var3.f(this, var1);
   }

   public final void a(hh var1) {
      Object var2 = var1;
      if(var1 == null) {
         var2 = this.s();
      }

      this.b((hh)var2);
   }

   public final boolean b() {
      return true;
   }

   public final boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(var1.getClass() != this.getClass()) {
            return false;
         }

         rj var2 = (rj)var1;
         if(this.c != null && this.c.size() != 0) {
            return var2.a(this.c);
         }

         if(var2.p() != 0) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      int var2;
      if(this.c == null) {
         var2 = 1;
      } else {
         int var1 = this.c.size();
         Iterator var3 = this.c.iterator();

         while(true) {
            var2 = var1;
            if(!var3.hasNext()) {
               break;
            }

            hh var4 = (hh)var3.next();
            if(var4 != null) {
               var1 ^= var4.hashCode();
            }
         }
      }

      return var2;
   }

   public final int p() {
      return this.c == null?0:this.c.size();
   }

   public final Iterator q() {
      return (Iterator)(this.c == null?ro$a.a():this.c.iterator());
   }

   public final String toString() {
      StringBuilder var3 = new StringBuilder((this.p() << 4) + 16);
      var3.append('[');
      if(this.c != null) {
         int var2 = this.c.size();

         for(int var1 = 0; var1 < var2; ++var1) {
            if(var1 > 0) {
               var3.append(',');
            }

            var3.append(((hh)this.c.get(var1)).toString());
         }
      }

      var3.append(']');
      return var3.toString();
   }
}
