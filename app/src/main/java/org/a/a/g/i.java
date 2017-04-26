package org.a.a.g;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class i implements Comparable {
   public static final org.a.a.g.i a = new i("tag:yaml.org,2002:yaml");
   public static final org.a.a.g.i b = new i("tag:yaml.org,2002:value");
   public static final org.a.a.g.i c = new i("tag:yaml.org,2002:merge");
   public static final org.a.a.g.i d = new i("tag:yaml.org,2002:set");
   public static final org.a.a.g.i e = new i("tag:yaml.org,2002:pairs");
   public static final org.a.a.g.i f = new i("tag:yaml.org,2002:omap");
   public static final org.a.a.g.i g = new i("tag:yaml.org,2002:binary");
   public static final org.a.a.g.i h = new i("tag:yaml.org,2002:int");
   public static final org.a.a.g.i i = new i("tag:yaml.org,2002:float");
   public static final org.a.a.g.i j = new i("tag:yaml.org,2002:timestamp");
   public static final org.a.a.g.i k = new i("tag:yaml.org,2002:bool");
   public static final org.a.a.g.i l = new i("tag:yaml.org,2002:null");
   public static final org.a.a.g.i m = new i("tag:yaml.org,2002:str");
   public static final org.a.a.g.i n = new i("tag:yaml.org,2002:seq");
   public static final org.a.a.g.i o = new i("tag:yaml.org,2002:map");
   public static final Map p = new HashMap();
   private final String q;

   static {
      HashSet var0 = new HashSet();
      var0.add(Double.class);
      var0.add(Float.class);
      var0.add(BigDecimal.class);
      p.put(i, var0);
      var0 = new HashSet();
      var0.add(Integer.class);
      var0.add(Long.class);
      var0.add(BigInteger.class);
      p.put(h, var0);
      var0 = new HashSet();
      var0.add(Date.class);
      var0.add(java.sql.Date.class);
      var0.add(Timestamp.class);
      p.put(j, var0);
   }

   public i(Class var1) {
      if(var1 == null) {
         throw new NullPointerException("Class for tag must be provided.");
      } else {
         this.q = "tag:yaml.org,2002:" + org.a.a.n.b.a(var1.getName());
      }
   }

   public i(String var1) {
      if(var1 == null) {
         throw new NullPointerException("Tag must be provided.");
      } else if(var1.length() == 0) {
         throw new IllegalArgumentException("Tag must not be empty.");
      } else if(var1.trim().length() != var1.length()) {
         throw new IllegalArgumentException("Tag must not contain leading or trailing spaces.");
      } else {
         this.q = org.a.a.n.b.a(var1);
      }
   }

   public final String a() {
      if(!this.q.startsWith("tag:yaml.org,2002:")) {
         throw new org.a.a.c.c("Invalid tag: " + this.q);
      } else {
         return org.a.a.n.b.b(this.q.substring(18));
      }
   }

   public final boolean a(Class var1) {
      Set var2 = (Set)p.get(this);
      return var2 != null?var2.contains(var1):false;
   }

   public final boolean a(String var1) {
      return this.q.startsWith(var1);
   }

   public final boolean equals(Object var1) {
      if(var1 instanceof org.a.a.g.i) {
         return this.q.equals(((org.a.a.g.i)var1).q);
      } else if(var1 instanceof String && this.q.equals(var1.toString())) {
         System.err.println("Comparing Tag and String is deprecated.");
         return true;
      } else {
         return false;
      }
   }

   public final int hashCode() {
      return this.q.hashCode();
   }

   public final String toString() {
      return this.q;
   }
}
