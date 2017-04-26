package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonCreator;
import com.flurry.org.codehaus.jackson.annotate.JsonProperty;
import java.io.Serializable;

public class hg implements Serializable {
   public static final hg a = new hg("N/A", -1L, -1L, -1, -1);
   final long b;
   final long c;
   final int d;
   final int e;
   final Object f;

   public hg(Object var1, long var2, int var4, int var5) {
      this(var1, -1L, var2, var4, var5);
   }

   @JsonCreator
   public hg(@JsonProperty("sourceRef") Object var1, @JsonProperty("byteOffset") long var2, @JsonProperty("charOffset") long var4, @JsonProperty("lineNr") int var6, @JsonProperty("columnNr") int var7) {
      this.f = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var7;
   }

   public long a() {
      return this.b;
   }

   public boolean equals(Object var1) {
      if(var1 != this) {
         if(var1 == null) {
            return false;
         }

         if(!(var1 instanceof hg)) {
            return false;
         }

         hg var2 = (hg)var1;
         if(this.f == null) {
            if(var2.f != null) {
               return false;
            }
         } else if(!this.f.equals(var2.f)) {
            return false;
         }

         if(this.d != var2.d || this.e != var2.e || this.c != var2.c || this.a() != var2.a()) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      int var1;
      if(this.f == null) {
         var1 = 1;
      } else {
         var1 = this.f.hashCode();
      }

      return ((var1 ^ this.d) + this.e ^ (int)this.c) + (int)this.b;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(80);
      var1.append("[Source: ");
      if(this.f == null) {
         var1.append("UNKNOWN");
      } else {
         var1.append(this.f.toString());
      }

      var1.append("; line: ");
      var1.append(this.d);
      var1.append(", column: ");
      var1.append(this.e);
      var1.append(']');
      return var1.toString();
   }
}
