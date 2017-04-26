package org.a.a.l;

import java.util.Arrays;

public final class a {
   public static final org.a.a.l.a a = new a("\n\u0085\u2028\u2029");
   public static final org.a.a.l.a b = new a("\r\n\u0085\u2028\u2029");
   public static final org.a.a.l.a c = new a("\u0000\r\n\u0085\u2028\u2029");
   public static final org.a.a.l.a d = new a(" \u0000\r\n\u0085\u2028\u2029");
   public static final org.a.a.l.a e = new a("\t \u0000\r\n\u0085\u2028\u2029");
   public static final org.a.a.l.a f = new a("\u0000 \t");
   public static final org.a.a.l.a g = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*\'()[]%");
   public static final org.a.a.l.a h = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
   boolean[] i;
   boolean j;
   private String k;

   private a(String var1) {
      int var3 = 0;
      super();
      this.i = new boolean[128];
      this.j = false;
      Arrays.fill(this.i, false);

      StringBuilder var4;
      for(var4 = new StringBuilder(); var3 < var1.length(); ++var3) {
         char var2 = var1.charAt(var3);
         if(var2 < 128) {
            this.i[var2] = true;
         } else {
            var4.append(var2);
         }
      }

      if(var4.length() > 0) {
         this.j = true;
         this.k = var4.toString();
      }

   }

   public final boolean a(char var1) {
      boolean var3 = false;
      boolean var2;
      if(var1 < 128) {
         var2 = this.i[var1];
      } else {
         var2 = var3;
         if(this.j) {
            var2 = var3;
            if(this.k.indexOf(var1, 0) != -1) {
               return true;
            }
         }
      }

      return var2;
   }

   public final boolean a(char var1, String var2) {
      boolean var3 = false;
      if(this.a(var1) || var2.indexOf(var1, 0) != -1) {
         var3 = true;
      }

      return var3;
   }

   public final boolean b(char var1) {
      return !this.a(var1);
   }

   public final boolean b(char var1, String var2) {
      return !this.a(var1, var2);
   }
}
