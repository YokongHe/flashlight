package com.flurry.sdk;

public enum hm {
   a((String)null),
   b("{"),
   c("}"),
   d("["),
   e("]"),
   f((String)null),
   g((String)null),
   h((String)null),
   i((String)null),
   j((String)null),
   k("true"),
   l("false"),
   m("null");

   final String n;
   final char[] o;
   final byte[] p;

   private hm(String var3) {
      if(var3 == null) {
         this.n = null;
         this.o = null;
         this.p = null;
      } else {
         this.n = var3;
         this.o = var3.toCharArray();
         int var4 = this.o.length;
         this.p = new byte[var4];

         for(var2 = 0; var2 < var4; ++var2) {
            this.p[var2] = (byte)this.o[var2];
         }
      }

   }

   public final String a() {
      return this.n;
   }

   public final char[] b() {
      return this.o;
   }

   public final boolean c() {
      return this == i || this == j;
   }

   public final boolean d() {
      return this.ordinal() >= g.ordinal();
   }
}
