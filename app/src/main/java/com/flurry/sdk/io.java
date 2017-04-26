package com.flurry.sdk;

import com.flurry.sdk.ie;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class io extends Writer {
   protected final ie a;
   OutputStream b;
   byte[] c;
   final int d;
   int e;
   int f = 0;

   public io(ie var1, OutputStream var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.f();
      this.d = this.c.length - 4;
      this.e = 0;
   }

   private int a(int var1) {
      int var2 = this.f;
      this.f = 0;
      if(var1 >= '\udc00' && var1 <= '\udfff') {
         return (var2 - '\ud800' << 10) + 65536 + (var1 - '\udc00');
      } else {
         throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(var2) + ", second 0x" + Integer.toHexString(var1) + "; illegal combination");
      }
   }

   private void b(int var1) {
      if(var1 > 1114111) {
         throw new IOException("Illegal character point (0x" + Integer.toHexString(var1) + ") to output; max is 0x10FFFF as per RFC 4627");
      } else if(var1 >= '\ud800') {
         if(var1 <= '\udbff') {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(var1) + ")");
         } else {
            throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(var1) + ")");
         }
      } else {
         throw new IOException("Illegal character point (0x" + Integer.toHexString(var1) + ") to output");
      }
   }

   public final Writer append(char var1) {
      this.write(var1);
      return this;
   }

   public final void close() {
      if(this.b != null) {
         if(this.e > 0) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
         }

         OutputStream var2 = this.b;
         this.b = null;
         byte[] var3 = this.c;
         if(var3 != null) {
            this.c = null;
            this.a.b(var3);
         }

         var2.close();
         int var1 = this.f;
         this.f = 0;
         if(var1 > 0) {
            this.b(var1);
         }
      }

   }

   public final void flush() {
      if(this.b != null) {
         if(this.e > 0) {
            this.b.write(this.c, 0, this.e);
            this.e = 0;
         }

         this.b.flush();
      }

   }

   public final void write(int var1) {
      int var2;
      if(this.f > 0) {
         var2 = this.a(var1);
      } else {
         var2 = var1;
         if(var1 >= '\ud800') {
            var2 = var1;
            if(var1 <= '\udfff') {
               if(var1 > '\udbff') {
                  this.b(var1);
               }

               this.f = var1;
               return;
            }
         }
      }

      if(this.e >= this.d) {
         this.b.write(this.c, 0, this.e);
         this.e = 0;
      }

      byte[] var5;
      if(var2 < 128) {
         var5 = this.c;
         var1 = this.e;
         this.e = var1 + 1;
         var5[var1] = (byte)var2;
      } else {
         var1 = this.e;
         int var3;
         if(var2 < 2048) {
            var5 = this.c;
            var3 = var1 + 1;
            var5[var1] = (byte)(var2 >> 6 | 192);
            var5 = this.c;
            var1 = var3 + 1;
            var5[var3] = (byte)(var2 & 63 | 128);
         } else if(var2 <= '\uffff') {
            var5 = this.c;
            var3 = var1 + 1;
            var5[var1] = (byte)(var2 >> 12 | 224);
            var5 = this.c;
            int var4 = var3 + 1;
            var5[var3] = (byte)(var2 >> 6 & 63 | 128);
            var5 = this.c;
            var1 = var4 + 1;
            var5[var4] = (byte)(var2 & 63 | 128);
         } else {
            if(var2 > 1114111) {
               this.b(var2);
            }

            var5 = this.c;
            var3 = var1 + 1;
            var5[var1] = (byte)(var2 >> 18 | 240);
            var5 = this.c;
            var1 = var3 + 1;
            var5[var3] = (byte)(var2 >> 12 & 63 | 128);
            var5 = this.c;
            var3 = var1 + 1;
            var5[var1] = (byte)(var2 >> 6 & 63 | 128);
            var5 = this.c;
            var1 = var3 + 1;
            var5[var3] = (byte)(var2 & 63 | 128);
         }

         this.e = var1;
      }
   }

   public final void write(String var1) {
      this.write((String)var1, 0, var1.length());
   }

   public final void write(String var1, int var2, int var3) {
      if(var3 < 2) {
         if(var3 == 1) {
            this.write(var1.charAt(var2));
         }

      } else {
         int var4 = var2;
         int var5 = var3;
         if(this.f > 0) {
            char var11 = var1.charAt(var2);
            var5 = var3 - 1;
            this.write(this.a(var11));
            var4 = var2 + 1;
         }

         var2 = this.e;
         byte[] var10 = this.c;
         int var8 = this.d;
         int var9 = var5 + var4;
         var3 = var4;

         label68:
         while(true) {
            var4 = var2;
            if(var3 >= var9) {
               break;
            }

            var4 = var2;
            if(var2 >= var8) {
               this.b.write(var10, 0, var2);
               var4 = 0;
            }

            var5 = var3 + 1;
            char var7 = var1.charAt(var3);
            var3 = var4;
            char var6 = var7;
            var2 = var5;
            int var12;
            if(var7 < 128) {
               var2 = var4 + 1;
               var10[var4] = (byte)var7;
               var4 = var9 - var5;
               var3 = var8 - var2;
               if(var4 > var3) {
                  var4 = var3;
               }

               var3 = var5;

               while(true) {
                  if(var3 >= var4 + var5) {
                     continue label68;
                  }

                  var12 = var3 + 1;
                  var7 = var1.charAt(var3);
                  if(var7 >= 128) {
                     var3 = var2;
                     var2 = var12;
                     var6 = var7;
                     break;
                  }

                  var10[var2] = (byte)var7;
                  ++var2;
                  var3 = var12;
               }
            }

            if(var6 < 2048) {
               var5 = var3 + 1;
               var10[var3] = (byte)(var6 >> 6 | 192);
               var4 = var5 + 1;
               var10[var5] = (byte)(var6 & 63 | 128);
               var3 = var2;
               var2 = var4;
            } else if(var6 >= '\ud800' && var6 <= '\udfff') {
               if(var6 > '\udbff') {
                  this.e = var3;
                  this.b(var6);
               }

               this.f = var6;
               var4 = var3;
               if(var2 >= var9) {
                  break;
               }

               var4 = var2 + 1;
               var5 = this.a(var1.charAt(var2));
               if(var5 > 1114111) {
                  this.e = var3;
                  this.b(var5);
               }

               var2 = var3 + 1;
               var10[var3] = (byte)(var5 >> 18 | 240);
               var3 = var2 + 1;
               var10[var2] = (byte)(var5 >> 12 & 63 | 128);
               var12 = var3 + 1;
               var10[var3] = (byte)(var5 >> 6 & 63 | 128);
               var2 = var12 + 1;
               var10[var12] = (byte)(var5 & 63 | 128);
               var3 = var4;
            } else {
               var4 = var3 + 1;
               var10[var3] = (byte)(var6 >> 12 | 224);
               var3 = var4 + 1;
               var10[var4] = (byte)(var6 >> 6 & 63 | 128);
               var4 = var3 + 1;
               var10[var3] = (byte)(var6 & 63 | 128);
               var3 = var2;
               var2 = var4;
            }
         }

         this.e = var4;
      }
   }

   public final void write(char[] var1) {
      this.write((char[])var1, 0, var1.length);
   }

   public final void write(char[] var1, int var2, int var3) {
      if(var3 < 2) {
         if(var3 == 1) {
            this.write(var1[var2]);
         }

      } else {
         int var4 = var2;
         int var5 = var3;
         if(this.f > 0) {
            char var11 = var1[var2];
            var5 = var3 - 1;
            this.write(this.a(var11));
            var4 = var2 + 1;
         }

         var2 = this.e;
         byte[] var10 = this.c;
         int var8 = this.d;
         int var9 = var5 + var4;
         var3 = var4;

         label68:
         while(true) {
            var4 = var2;
            if(var3 >= var9) {
               break;
            }

            var4 = var2;
            if(var2 >= var8) {
               this.b.write(var10, 0, var2);
               var4 = 0;
            }

            var5 = var3 + 1;
            char var7 = var1[var3];
            var3 = var4;
            char var6 = var7;
            var2 = var5;
            int var12;
            if(var7 < 128) {
               var2 = var4 + 1;
               var10[var4] = (byte)var7;
               var4 = var9 - var5;
               var3 = var8 - var2;
               if(var4 > var3) {
                  var4 = var3;
               }

               var3 = var5;

               while(true) {
                  if(var3 >= var4 + var5) {
                     continue label68;
                  }

                  var12 = var3 + 1;
                  var7 = var1[var3];
                  if(var7 >= 128) {
                     var3 = var2;
                     var2 = var12;
                     var6 = var7;
                     break;
                  }

                  var10[var2] = (byte)var7;
                  ++var2;
                  var3 = var12;
               }
            }

            if(var6 < 2048) {
               var5 = var3 + 1;
               var10[var3] = (byte)(var6 >> 6 | 192);
               var4 = var5 + 1;
               var10[var5] = (byte)(var6 & 63 | 128);
               var3 = var2;
               var2 = var4;
            } else if(var6 >= '\ud800' && var6 <= '\udfff') {
               if(var6 > '\udbff') {
                  this.e = var3;
                  this.b(var6);
               }

               this.f = var6;
               var4 = var3;
               if(var2 >= var9) {
                  break;
               }

               var4 = var2 + 1;
               var5 = this.a(var1[var2]);
               if(var5 > 1114111) {
                  this.e = var3;
                  this.b(var5);
               }

               var2 = var3 + 1;
               var10[var3] = (byte)(var5 >> 18 | 240);
               var3 = var2 + 1;
               var10[var2] = (byte)(var5 >> 12 & 63 | 128);
               var12 = var3 + 1;
               var10[var3] = (byte)(var5 >> 6 & 63 | 128);
               var2 = var12 + 1;
               var10[var12] = (byte)(var5 & 63 | 128);
               var3 = var4;
            } else {
               var4 = var3 + 1;
               var10[var3] = (byte)(var6 >> 12 | 224);
               var3 = var4 + 1;
               var10[var4] = (byte)(var6 >> 6 & 63 | 128);
               var4 = var3 + 1;
               var10[var3] = (byte)(var6 & 63 | 128);
               var3 = var2;
               var2 = var4;
            }
         }

         this.e = var4;
      }
   }
}
