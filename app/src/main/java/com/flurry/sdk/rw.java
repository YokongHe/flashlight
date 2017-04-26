package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.rk;
import com.flurry.sdk.ro;
import com.flurry.sdk.ro$a;
import com.flurry.sdk.ro$b;
import com.flurry.sdk.rs;
import com.flurry.sdk.ry;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class rw extends ro {
   protected LinkedHashMap c = null;

   public rw(rs var1) {
      super(var1);
   }

   private final hh b(String var1, hh var2) {
      if(this.c == null) {
         this.c = new LinkedHashMap();
      }

      return (hh)this.c.put(var1, var2);
   }

   public hh a(String var1) {
      return this.c != null?(hh)this.c.get(var1):null;
   }

   public hh a(String var1, hh var2) {
      Object var3 = var2;
      if(var2 == null) {
         var3 = this.s();
      }

      return this.b(var1, (hh)var3);
   }

   public final void a(hf var1, jw var2) {
      var1.d();
      if(this.c != null) {
         Iterator var3 = this.c.entrySet().iterator();

         while(var3.hasNext()) {
            Entry var4 = (Entry)var3.next();
            var1.a((String)var4.getKey());
            ((rk)var4.getValue()).a(var1, var2);
         }
      }

      var1.e();
   }

   public void a(hf var1, jw var2, jz var3) {
      var3.b(this, var1);
      if(this.c != null) {
         Iterator var4 = this.c.entrySet().iterator();

         while(var4.hasNext()) {
            Entry var5 = (Entry)var4.next();
            var1.a((String)var5.getKey());
            ((rk)var5.getValue()).a(var1, var2);
         }
      }

      var3.e(this, var1);
   }

   public boolean c() {
      return true;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 == null) {
         return false;
      } else if(var1.getClass() != this.getClass()) {
         return false;
      } else {
         rw var5 = (rw)var1;
         if(var5.p() != this.p()) {
            return false;
         } else {
            if(this.c != null) {
               Iterator var2 = this.c.entrySet().iterator();

               while(var2.hasNext()) {
                  Entry var4 = (Entry)var2.next();
                  String var3 = (String)var4.getKey();
                  hh var7 = (hh)var4.getValue();
                  hh var6 = var5.a(var3);
                  if(var6 == null || !var6.equals(var7)) {
                     return false;
                  }
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      return this.c == null?-1:this.c.hashCode();
   }

   public int p() {
      return this.c == null?0:this.c.size();
   }

   public Iterator q() {
      return (Iterator)(this.c == null?ro$a.a():this.c.values().iterator());
   }

   public Iterator r() {
      return (Iterator)(this.c == null?ro$b.a():this.c.keySet().iterator());
   }

   public String toString() {
      StringBuilder var2 = new StringBuilder((this.p() << 4) + 32);
      var2.append("{");
      if(this.c != null) {
         Iterator var3 = this.c.entrySet().iterator();

         for(int var1 = 0; var3.hasNext(); ++var1) {
            Entry var4 = (Entry)var3.next();
            if(var1 > 0) {
               var2.append(",");
            }

            ry.a(var2, (String)var4.getKey());
            var2.append(':');
            var2.append(((hh)var4.getValue()).toString());
         }
      }

      var2.append("}");
      return var2.toString();
   }
}
