package org.a.a.c;

public final class a {
   private String a;
   private int b;
   private int c;
   private int d;
   private String e;
   private int f;

   public a(String var1, int var2, int var3, int var4, String var5, int var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
   }

   public final String a() {
      return this.a;
   }

   public final int b() {
      return this.c;
   }

   public final int c() {
      return this.d;
   }

   public final String toString() {
      String var5;
      if(this.e == null) {
         var5 = null;
      } else {
         int var2 = this.f;
         String var6 = "";

         char var1;
         int var3;
         while(true) {
            var5 = var6;
            var3 = var2;
            if(var2 <= 0) {
               break;
            }

            var1 = this.e.charAt(var2 - 1);
            var5 = var6;
            var3 = var2;
            if(org.a.a.l.a.c.a(var1)) {
               break;
            }

            var3 = var2 - 1;
            var2 = var3;
            if((float)(this.f - var3) > 36.0F) {
               var5 = " ... ";
               var3 += 5;
               break;
            }
         }

         String var7 = "";
         var2 = this.f;

         int var4;
         while(true) {
            var4 = var2;
            var6 = var7;
            if(var2 >= this.e.length()) {
               break;
            }

            var1 = this.e.charAt(var2);
            var4 = var2;
            var6 = var7;
            if(org.a.a.l.a.c.a(var1)) {
               break;
            }

            var4 = var2 + 1;
            var2 = var4;
            if((float)(var4 - this.f) > 36.0F) {
               var6 = " ... ";
               var4 -= 5;
               break;
            }
         }

         var7 = this.e.substring(var3, var4);
         StringBuilder var8 = new StringBuilder();

         for(var2 = 0; var2 < 4; ++var2) {
            var8.append(" ");
         }

         var8.append(var5);
         var8.append(var7);
         var8.append(var6);
         var8.append("\n");

         for(var2 = 0; var2 < this.f + 4 - var3 + var5.length(); ++var2) {
            var8.append(" ");
         }

         var8.append("^");
         var5 = var8.toString();
      }

      StringBuilder var9 = new StringBuilder(" in \"");
      var9.append(this.a);
      var9.append("\", line ");
      var9.append(this.c + 1);
      var9.append(", column ");
      var9.append(this.d + 1);
      if(var5 != null) {
         var9.append(":\n");
         var9.append(var5);
      }

      return var9.toString();
   }
}
