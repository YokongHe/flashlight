package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$Id;
import com.flurry.sdk.is;
import com.flurry.sdk.iy;
import com.flurry.sdk.jn;
import com.flurry.sdk.ju;
import com.flurry.sdk.jy;
import com.flurry.sdk.jz;
import com.flurry.sdk.nh;
import com.flurry.sdk.ni;
import com.flurry.sdk.nj;
import com.flurry.sdk.nk;
import com.flurry.sdk.nl;
import com.flurry.sdk.nm;
import com.flurry.sdk.nn;
import com.flurry.sdk.no;
import com.flurry.sdk.np;
import com.flurry.sdk.nq;
import com.flurry.sdk.nr;
import com.flurry.sdk.ns;
import com.flurry.sdk.nx;
import com.flurry.sdk.sh;
import java.util.Collection;

public class nu implements ni {
   protected JsonTypeInfo$Id a;
   protected JsonTypeInfo$As b;
   protected String c;
   protected Class d;
   protected nh e;

   public static nu b() {
      return (new nu()).b(JsonTypeInfo$Id.NONE, (nh)null);
   }

   public jy a(iy var1, sh var2, Collection var3, is var4) {
      if(this.a == JsonTypeInfo$Id.NONE) {
         return null;
      } else {
         nh var5 = this.a(var1, var2, var3, false, true);
         switch(null.a[this.b.ordinal()]) {
         case 1:
            return new nj(var2, var5, var4, this.d);
         case 2:
            return new nn(var2, var5, var4, this.d, this.c);
         case 3:
            return new np(var2, var5, var4, this.d);
         case 4:
            return new nl(var2, var5, var4, this.d, this.c);
         default:
            throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
         }
      }
   }

   public jz a(ju var1, sh var2, Collection var3, is var4) {
      if(this.a == JsonTypeInfo$Id.NONE) {
         return null;
      } else {
         nh var5 = this.a(var1, var2, var3, true, false);
         switch(null.a[this.b.ordinal()]) {
         case 1:
            return new nk(var5, var4);
         case 2:
            return new no(var5, var4, this.c);
         case 3:
            return new nq(var5, var4);
         case 4:
            return new nm(var5, var4, this.c);
         default:
            throw new IllegalStateException("Do not know how to construct standard type serializer for inclusion type: " + this.b);
         }
      }
   }

   protected nh a(jn var1, sh var2, Collection var3, boolean var4, boolean var5) {
      if(this.e != null) {
         return this.e;
      } else if(this.a == null) {
         throw new IllegalStateException("Can not build, \'init()\' not yet called");
      } else {
         switch(null.b[this.a.ordinal()]) {
         case 1:
            return new nr(var2, var1.m());
         case 2:
            return new ns(var2, var1.m());
         case 3:
            return nx.a(var1, var2, var3, var4, var5);
         case 4:
            return null;
         default:
            throw new IllegalStateException("Do not know how to construct standard type id resolver for idType: " + this.a);
         }
      }
   }

   // $FF: synthetic method
   public ni a(JsonTypeInfo$As var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public ni a(JsonTypeInfo$Id var1, nh var2) {
      return this.b(var1, var2);
   }

   // $FF: synthetic method
   public ni a(Class var1) {
      return this.b(var1);
   }

   // $FF: synthetic method
   public ni a(String var1) {
      return this.b(var1);
   }

   public Class a() {
      return this.d;
   }

   public nu b(JsonTypeInfo$As var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("includeAs can not be null");
      } else {
         this.b = var1;
         return this;
      }
   }

   public nu b(JsonTypeInfo$Id var1, nh var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("idType can not be null");
      } else {
         this.a = var1;
         this.e = var2;
         this.c = var1.getDefaultPropertyName();
         return this;
      }
   }

   public nu b(Class var1) {
      this.d = var1;
      return this;
   }

   public nu b(String var1) {
      String var2;
      label11: {
         if(var1 != null) {
            var2 = var1;
            if(var1.length() != 0) {
               break label11;
            }
         }

         var2 = this.a.getDefaultPropertyName();
      }

      this.c = var2;
      return this;
   }
}
