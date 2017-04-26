package org.a.a.e.b.a.a.a.a.a;

public abstract class c implements org.a.a.e.b.a.a.a.a.a.a {
   // $FF: synthetic field
   static final boolean a;
   private static final ThreadLocal b;

   static {
      boolean var0;
      if(!c.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
      b = new ThreadLocal() {
      };
   }

   private static final char[] a(char[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      if(var1 > 0) {
         System.arraycopy(var0, 0, var3, 0, var1);
      }

      return var3;
   }

   private static int b(CharSequence var0, int var1, int var2) {
      if(var1 < var2) {
         int var5 = var1 + 1;
         char var3 = var0.charAt(var1);
         if(var3 >= '\ud800' && var3 <= '\udfff') {
            if(var3 <= '\udbff') {
               if(var5 == var2) {
                  return -var3;
               } else {
                  char var4 = var0.charAt(var5);
                  if(Character.isLowSurrogate(var4)) {
                     return Character.toCodePoint(var3, var4);
                  } else {
                     throw new IllegalArgumentException("Expected low surrogate but got char \'" + var4 + "\' with value " + var4 + " at index " + var5);
                  }
               }
            } else {
               throw new IllegalArgumentException("Unexpected low surrogate character \'" + var3 + "\' with value " + var3 + " at index " + (var5 - 1));
            }
         } else {
            return var3;
         }
      } else {
         throw new IndexOutOfBoundsException("Index exceeds specified range");
      }
   }

   protected int a(CharSequence var1, int var2, int var3) {
      while(true) {
         if(var2 < var3) {
            int var4 = b(var1, var2, var3);
            if(var4 >= 0 && this.a(var4) == null) {
               byte var5;
               if(Character.isSupplementaryCodePoint(var4)) {
                  var5 = 2;
               } else {
                  var5 = 1;
               }

               var2 += var5;
               continue;
            }
         }

         return var2;
      }
   }

   public String a(String var1) {
      int var2 = var1.length();
      int var3 = this.a((CharSequence)var1, 0, var2);
      return var3 == var2?var1:this.a(var1, var3);
   }

   protected final String a(String var1, int var2) {
      int var7 = var1.length();
      char[] var9 = (char[])b.get();
      int var6 = 0;
      byte var3 = 0;
      int var5 = var2;

      int var4;
      char[] var10;
      char[] var11;
      int var14;
      for(var2 = var3; var5 < var7; var9 = var11) {
         int var8 = b(var1, var5, var7);
         if(var8 < 0) {
            throw new IllegalArgumentException("Trailing high surrogate at end of input");
         }

         char[] var12 = this.a(var8);
         var14 = var2;
         var11 = var9;
         if(var12 != null) {
            var14 = var5 - var6;
            var4 = var2 + var14 + var12.length;
            var10 = var9;
            if(var9.length < var4) {
               var10 = a(var9, var2, var4 + (var7 - var5) + 32);
            }

            var4 = var2;
            if(var14 > 0) {
               var1.getChars(var6, var5, var10, var2);
               var4 = var2 + var14;
            }

            var14 = var4;
            var11 = var10;
            if(var12.length > 0) {
               System.arraycopy(var12, 0, var10, var4, var12.length);
               var14 = var4 + var12.length;
               var11 = var10;
            }
         }

         byte var13;
         if(Character.isSupplementaryCodePoint(var8)) {
            var13 = 2;
         } else {
            var13 = 1;
         }

         var6 = var13 + var5;
         var5 = this.a((CharSequence)var1, var6, var7);
         var2 = var14;
      }

      var4 = var7 - var6;
      var14 = var2;
      var10 = var9;
      if(var4 > 0) {
         var14 = var4 + var2;
         var10 = var9;
         if(var9.length < var14) {
            var10 = a(var9, var2, var14);
         }

         var1.getChars(var6, var7, var10, var2);
      }

      return new String(var10, 0, var14);
   }

   protected abstract char[] a(int var1);
}
