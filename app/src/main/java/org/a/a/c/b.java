package org.a.a.c;

public class b extends org.a.a.c.c {
   private String a;
   private org.a.a.c.a b;
   private String c;
   private org.a.a.c.a d;
   private String e;

   protected b(String var1, org.a.a.c.a var2, String var3, org.a.a.c.a var4) {
      this(var1, var2, var3, var4, (String)null, (Throwable)null);
   }

   protected b(String var1, org.a.a.c.a var2, String var3, org.a.a.c.a var4, String var5) {
      this(var1, var2, var3, var4, var5, (Throwable)null);
   }

   protected b(String var1, org.a.a.c.a var2, String var3, org.a.a.c.a var4, String var5, Throwable var6) {
      super(var1 + "; " + var3, var6);
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   protected b(String var1, org.a.a.c.a var2, String var3, org.a.a.c.a var4, Throwable var5) {
      this(var1, var2, var3, var4, (String)null, var5);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      if(this.a != null) {
         var1.append(this.a);
         var1.append("\n");
      }

      if(this.b != null && (this.c == null || this.d == null || this.b.a().equals(this.d.a()) || this.b.b() != this.d.b() || this.b.c() != this.d.c())) {
         var1.append(this.b.toString());
         var1.append("\n");
      }

      if(this.c != null) {
         var1.append(this.c);
         var1.append("\n");
      }

      if(this.d != null) {
         var1.append(this.d.toString());
         var1.append("\n");
      }

      if(this.e != null) {
         var1.append(this.e);
         var1.append("\n");
      }

      return var1.toString();
   }
}
