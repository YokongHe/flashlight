package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fm;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$r;
import com.flurry.sdk.hf;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class fm$a {
   // $FF: synthetic field
   final fm a;
   private String b;
   private String c;
   private fn d;
   private final fn$r e;

   private fm$a(fm var1, String var2, String var3, Map var4, fn var5) {
      this.a = var1;
      this.e = new fn$r(fm.a());
      this.b = var2;
      this.c = var3;
      this.d = var5;
      if(var4 != null) {
         Iterator var6 = var4.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var7 = (Entry)var6.next();
            this.a((String)var7.getKey(), (String)var7.getValue());
         }
      }

   }

   // $FF: synthetic method
   fm$a(fm var1, String var2, String var3, Map var4, fn var5, Object var6) {
      this(var1, var2, var3, var4, var5);
   }

   void a(hf var1) {
      var1.d();
      if(this.c != null) {
         var1.a("doc", this.c);
      }

      this.e.a(var1);
      var1.a("request");
      this.d.b(fm.a(this.a), var1);
      this.b(var1);
      var1.e();
   }

   public void a(String var1, String var2) {
      synchronized(this){}

      try {
         this.e.a(var1, var2);
      } finally {
         ;
      }

   }

   void b(hf var1) {
      var1.a("response", "null");
      var1.a("one-way", true);
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(!(var1 instanceof fm$a)) {
            return false;
         }

         fm$a var2 = (fm$a)var1;
         if(!this.b.equals(var2.b) || !this.d.equals(var2.d) || !this.e.equals(var2.e)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.b.hashCode() + this.d.hashCode() + this.e.hashCode();
   }

   public String toString() {
      try {
         StringWriter var1 = new StringWriter();
         hf var2 = fn.a.a((Writer)var1);
         this.a(var2);
         var2.g();
         String var4 = var1.toString();
         return var4;
      } catch (IOException var3) {
         throw new fk(var3);
      }
   }
}
