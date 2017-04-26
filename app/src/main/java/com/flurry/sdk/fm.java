package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fm$a;
import com.flurry.sdk.fm$b;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.fn$o;
import com.flurry.sdk.fn$r;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.fo;
import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.hj;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class fm {
   public static final fn a;
   public static final fn b;
   private static final Set d;
   private static final Set j;
   fn$r c;
   private String e;
   private String f;
   private String g;
   private fn$o h = new fn$o();
   private Map i = new LinkedHashMap();

   static {
      HashSet var0 = new HashSet();
      d = var0;
      Collections.addAll(var0, new String[]{"doc", "response", "request", "errors", "one-way"});
      a = fn.a(fn$v.g);
      ArrayList var1 = new ArrayList();
      var1.add(a);
      b = fn.b((List)var1);
      var0 = new HashSet();
      j = var0;
      Collections.addAll(var0, new String[]{"namespace", "protocol", "doc", "messages", "types", "errors"});
   }

   private fm() {
      this.c = new fn$r(j);
   }

   private fm$a a(String var1, hh var2) {
      String var4 = this.d(var2);
      LinkedHashMap var5 = new LinkedHashMap();
      Iterator var6 = var2.r();

      hh var8;
      while(var6.hasNext()) {
         String var7 = (String)var6.next();
         if(!d.contains(var7)) {
            var8 = var2.a(var7);
            if(var8.a() && var8.f()) {
               var5.put(var7, var8.i());
            }
         }
      }

      hh var14 = var2.a("request");
      if(var14 != null && var14.b()) {
         ArrayList var12 = new ArrayList();
         Iterator var15 = var14.iterator();

         hh var9;
         while(var15.hasNext()) {
            var8 = (hh)var15.next();
            var9 = var8.a("name");
            if(var9 == null) {
               throw new fo("No param name: " + var8);
            }

            hh var10 = var8.a("type");
            if(var10 == null) {
               throw new fo("No param type: " + var8);
            }

            var12.add(new fn$f(var9.i(), fn.a(var10, this.h), (String)null, var8.a("default")));
         }

         fn var13 = fn.a((List)var12);
         boolean var3 = false;
         var14 = var2.a("one-way");
         if(var14 != null) {
            if(!var14.g()) {
               throw new fo("one-way must be boolean: " + var2);
            }

            var3 = var14.j();
         }

         var14 = var2.a("response");
         if(!var3 && var14 == null) {
            throw new fo("No response specified: " + var2);
         } else {
            var9 = var2.a("errors");
            if(var3) {
               if(var9 != null) {
                  throw new fo("one-way can\'t have errors: " + var2);
               } else if(var14 != null && fn.a(var14, this.h).a() != fn$v.n) {
                  throw new fo("One way response must be null: " + var2);
               } else {
                  return new fm$a(this, var1, var4, var5, var13, null);
               }
            } else {
               fn var16 = fn.a(var14, this.h);
               ArrayList var17 = new ArrayList();
               var17.add(a);
               if(var9 != null) {
                  if(!var9.b()) {
                     throw new fo("Errors not an array: " + var2);
                  }

                  Iterator var11 = var9.iterator();

                  while(var11.hasNext()) {
                     String var18 = ((hh)var11.next()).i();
                     fn var19 = this.h.a((Object)var18);
                     if(var19 == null) {
                        throw new fo("Undefined error: " + var18);
                     }

                     if(!var19.h()) {
                        throw new fo("Not an error: " + var18);
                     }

                     var17.add(var19);
                  }
               }

               return new fm$b(this, var1, var4, var5, var13, var16, fn.b((List)var17), null);
            }
         }
      } else {
         throw new fo("No request specified: " + var2);
      }
   }

   private static fm a(hj var0) {
      try {
         fm var1 = new fm();
         var1.a(fn.b.a(var0));
         return var1;
      } catch (IOException var2) {
         throw new fo(var2);
      }
   }

   public static fm a(String var0) {
      try {
         fm var2 = a(fn.a.a((InputStream)(new ByteArrayInputStream(var0.getBytes("UTF-8")))));
         return var2;
      } catch (IOException var1) {
         throw new fk(var1);
      }
   }

   // $FF: synthetic method
   static fn$o a(fm var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static Set a() {
      return d;
   }

   private void a(hh var1) {
      this.b(var1);
      this.e(var1);
      this.f(var1);
      this.h(var1);
      this.c(var1);
      this.g(var1);
   }

   private void b(hh var1) {
      var1 = var1.a("namespace");
      if(var1 != null) {
         this.f = var1.i();
         this.h.a(this.f);
      }
   }

   private void c(hh var1) {
      this.g = this.d(var1);
   }

   private String d(hh var1) {
      var1 = var1.a("doc");
      return var1 == null?null:var1.i();
   }

   private void e(hh var1) {
      hh var2 = var1.a("protocol");
      if(var2 == null) {
         throw new fo("No protocol name specified: " + var1);
      } else {
         this.e = var2.i();
      }
   }

   private void f(hh var1) {
      var1 = var1.a("types");
      if(var1 != null) {
         if(!var1.b()) {
            throw new fo("Types not an array: " + var1);
         }

         Iterator var3 = var1.iterator();

         while(var3.hasNext()) {
            hh var2 = (hh)var3.next();
            if(!var2.c()) {
               throw new fo("Type not an object: " + var2);
            }

            fn.a(var2, this.h);
         }
      }

   }

   private void g(hh var1) {
      Iterator var2 = var1.r();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(!j.contains(var3)) {
            hh var4 = var1.a(var3);
            if(var4.a() && var4.f()) {
               this.a(var3, var4.i());
            }
         }
      }

   }

   private void h(hh var1) {
      var1 = var1.a("messages");
      if(var1 != null) {
         Iterator var2 = var1.r();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            this.i.put(var3, this.a(var3, var1.a(var3)));
         }
      }

   }

   public String a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   void a(hf var1) {
      this.h.a(this.f);
      var1.d();
      var1.a("protocol", this.e);
      var1.a("namespace", this.f);
      if(this.g != null) {
         var1.a("doc", this.g);
      }

      this.c.a(var1);
      var1.f("types");
      fn$o var2 = new fn$o(this.f);
      Iterator var3 = this.h.values().iterator();

      while(var3.hasNext()) {
         fn var4 = (fn)var3.next();
         if(!var2.a(var4)) {
            var4.a(var2, var1);
         }
      }

      var1.c();
      var1.g("messages");
      Iterator var5 = this.i.entrySet().iterator();

      while(var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         var1.a((String)var6.getKey());
         ((fm$a)var6.getValue()).a(var1);
      }

      var1.e();
      var1.e();
   }

   public void a(String var1, String var2) {
      synchronized(this){}

      try {
         this.c.a(var1, var2);
      } finally {
         ;
      }

   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fm)) {
            return false;
         }

         fm var2 = (fm)var1;
         if(!this.e.equals(var2.e) || !this.f.equals(var2.f) || !this.h.equals(var2.h) || !this.i.equals(var2.i) || !this.c.equals(this.c)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.e.hashCode() + this.f.hashCode() + this.h.hashCode() + this.i.hashCode() + this.c.hashCode();
   }

   public String toString() {
      return this.a(false);
   }
}
