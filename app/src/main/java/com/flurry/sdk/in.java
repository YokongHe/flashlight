package com.flurry.sdk;

import com.flurry.sdk.ic;
import com.flurry.sdk.ie;
import java.io.CharConversionException;
import java.io.InputStream;

public final class in extends ic {
   final boolean g;
   char h = 0;
   int i = 0;
   int j = 0;

   public in(ie var1, InputStream var2, byte[] var3, int var4, int var5, boolean var6) {
      super(var1, var2, var3, var4, var5);
      this.g = var6;
   }

   private void a(int var1, int var2) {
      int var3 = this.j;
      int var4 = this.i;
      throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + var1 + ", needed " + var2 + ", at char #" + var4 + ", byte #" + (var3 + var1) + ")");
   }

   private void a(int var1, int var2, String var3) {
      int var4 = this.j;
      int var5 = this.d;
      int var6 = this.i;
      throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(var1) + var3 + " at char #" + (var6 + var2) + ", byte #" + (var4 + var5 - 1) + ")");
   }

   private boolean a(int var1) {
      this.j += this.e - var1;
      if(var1 > 0) {
         if(this.d > 0) {
            for(int var2 = 0; var2 < var1; ++var2) {
               this.c[var2] = this.c[this.d + var2];
            }

            this.d = 0;
         }

         this.e = var1;
      } else {
         this.d = 0;
         var1 = this.b.read(this.c);
         if(var1 <= 0) {
            this.e = 0;
            if(var1 < 0) {
               this.a();
               return false;
            }

            this.b();
         }

         this.e = var1;
      }

      for(; this.e < 4; this.e += var1) {
         var1 = this.b.read(this.c, this.e, this.c.length - this.e);
         if(var1 <= 0) {
            if(var1 < 0) {
               this.a();
               this.a(this.e, 4);
            }

            this.b();
         }
      }

      return true;
   }

   public final int read(char[] var1, int var2, int var3) {
      int var4;
      if(this.c == null) {
         var4 = -1;
      } else {
         var4 = var3;
         if(var3 > 0) {
            if(var2 < 0 || var2 + var3 > var1.length) {
               this.a(var1, var2, var3);
            }

            int var7 = var3 + var2;
            if(this.h != 0) {
               var3 = var2 + 1;
               var1[var2] = this.h;
               this.h = 0;
            } else {
               var3 = this.e - this.d;
               if(var3 < 4 && !this.a(var3)) {
                  return -1;
               }

               var3 = var2;
            }

            do {
               var4 = var3;
               if(var3 >= var7) {
                  break;
               }

               var4 = this.d;
               byte var5;
               byte var6;
               byte var8;
               if(this.g) {
                  var5 = this.c[var4];
                  var6 = this.c[var4 + 1];
                  var8 = this.c[var4 + 2];
                  var4 = this.c[var4 + 3] & 255 | var5 << 24 | (var6 & 255) << 16 | (var8 & 255) << 8;
               } else {
                  var5 = this.c[var4];
                  var6 = this.c[var4 + 1];
                  var8 = this.c[var4 + 2];
                  var4 = this.c[var4 + 3] << 24 | var5 & 255 | (var6 & 255) << 8 | (var8 & 255) << 16;
               }

               this.d += 4;
               int var9;
               if(var4 > '\uffff') {
                  if(var4 > 1114111) {
                     this.a(var4, var3 - var2, "(above " + Integer.toHexString(1114111) + ") ");
                  }

                  var9 = var4 - 65536;
                  var4 = var3 + 1;
                  var1[var3] = (char)('\ud800' + (var9 >> 10));
                  int var10 = var9 & 1023 | '\udc00';
                  var9 = var10;
                  var3 = var4;
                  if(var4 >= var7) {
                     this.h = (char)var10;
                     break;
                  }
               } else {
                  var9 = var4;
               }

               var4 = var3 + 1;
               var1[var3] = (char)var9;
               var3 = var4;
            } while(this.d < this.e);

            var2 = var4 - var2;
            this.i += var2;
            return var2;
         }
      }

      return var4;
   }
}
