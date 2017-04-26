package org.a.a.e.b.a.a.a.a.a;

public final class b extends org.a.a.e.b.a.a.a.a.a.c {
   private static final char[] b = new char[]{'+'};
   private static final char[] c = "0123456789ABCDEF".toCharArray();
   private final boolean d;
   private final boolean[] e;

   public b(String var1, boolean var2) {
      if(var1.matches(".*[0-9A-Za-z].*")) {
         throw new IllegalArgumentException("Alphanumeric characters are always \'safe\' and should not be explicitly specified");
      } else if(var1.contains("%")) {
         throw new IllegalArgumentException("The \'%\' character cannot be specified as \'safe\'");
      } else {
         this.d = false;
         this.e = b(var1);
      }
   }

   private static boolean[] b(String var0) {
      byte var3 = 0;
      char[] var6 = var0.toCharArray();
      int var4 = var6.length;
      int var1 = 0;

      int var2;
      for(var2 = 122; var1 < var4; ++var1) {
         var2 = Math.max(var6[var1], var2);
      }

      boolean[] var5 = new boolean[var2 + 1];

      for(var1 = 48; var1 <= 57; ++var1) {
         var5[var1] = true;
      }

      for(var1 = 65; var1 <= 90; ++var1) {
         var5[var1] = true;
      }

      for(var1 = 97; var1 <= 122; ++var1) {
         var5[var1] = true;
      }

      var2 = var6.length;

      for(var1 = var3; var1 < var2; ++var1) {
         var5[var6[var1]] = true;
      }

      return var5;
   }

   protected final int a(CharSequence var1, int var2, int var3) {
      while(true) {
         if(var2 < var3) {
            char var4 = var1.charAt(var2);
            if(var4 < this.e.length && this.e[var4]) {
               ++var2;
               continue;
            }
         }

         return var2;
      }
   }

   public final String a(String var1) {
      int var3 = var1.length();
      int var2 = 0;

      String var5;
      while(true) {
         var5 = var1;
         if(var2 >= var3) {
            break;
         }

         char var4 = var1.charAt(var2);
         if(var4 >= this.e.length || !this.e[var4]) {
            var5 = this.a(var1, var2);
            break;
         }

         ++var2;
      }

      return var5;
   }

   protected final char[] a(int var1) {
      if(var1 < this.e.length && this.e[var1]) {
         return null;
      } else if(var1 == 32 && this.d) {
         return b;
      } else {
         char var2;
         if(var1 <= 127) {
            var2 = c[var1 & 15];
            return new char[]{'%', c[var1 >>> 4], var2};
         } else {
            char var3;
            char var4;
            if(var1 <= 2047) {
               var2 = c[var1 & 15];
               var1 >>>= 4;
               var3 = c[var1 & 3 | 8];
               var1 >>>= 2;
               var4 = c[var1 & 15];
               return new char[]{'%', c[var1 >>> 4 | 12], var4, '%', var3, var2};
            } else {
               char var5;
               if(var1 <= '\uffff') {
                  var2 = c[var1 & 15];
                  var1 >>>= 4;
                  var3 = c[var1 & 3 | 8];
                  var1 >>>= 2;
                  var4 = c[var1 & 15];
                  var1 >>>= 4;
                  var5 = c[var1 & 3 | 8];
                  return new char[]{'%', 'E', c[var1 >>> 2], '%', var5, var4, '%', var3, var2};
               } else if(var1 <= 1114111) {
                  var2 = c[var1 & 15];
                  var1 >>>= 4;
                  var3 = c[var1 & 3 | 8];
                  var1 >>>= 2;
                  var4 = c[var1 & 15];
                  var1 >>>= 4;
                  var5 = c[var1 & 3 | 8];
                  var1 >>>= 2;
                  char var6 = c[var1 & 15];
                  var1 >>>= 4;
                  char var7 = c[var1 & 3 | 8];
                  return new char[]{'%', 'F', c[var1 >>> 2 & 7], '%', var7, var6, '%', var5, var4, '%', var3, var2};
               } else {
                  throw new IllegalArgumentException("Invalid unicode character value " + var1);
               }
            }
         }
      }
   }
}
