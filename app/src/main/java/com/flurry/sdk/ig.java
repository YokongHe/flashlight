package com.flurry.sdk;

import com.flurry.sdk.si;
import com.flurry.sdk.sj;
import com.flurry.sdk.sk;
import com.flurry.sdk.sp;
import java.lang.ref.SoftReference;

public final class ig {
   protected static final ThreadLocal a = new ThreadLocal();
   private static final char[] e = sk.g();
   private static final byte[] f = sk.h();
   protected sp b;
   protected sj c;
   protected final char[] d = new char[6];

   public ig() {
      this.d[0] = 92;
      this.d[2] = 48;
      this.d[3] = 48;
   }

   private int a(int var1, int var2) {
      if(var2 >= '\udc00' && var2 <= '\udfff') {
         return 65536 + (var1 - '\ud800' << 10) + (var2 - '\udc00');
      } else {
         throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(var1) + ", second 0x" + Integer.toHexString(var2) + "; illegal combination");
      }
   }

   private int a(int var1, int var2, sj var3, int var4) {
      var3.e(var4);
      var3.a(92);
      if(var2 < 0) {
         var3.a(117);
         if(var1 > 255) {
            var2 = var1 >> 8;
            var3.a(f[var2 >> 4]);
            var3.a(f[var2 & 15]);
            var1 &= 255;
         } else {
            var3.a(48);
            var3.a(48);
         }

         var3.a(f[var1 >> 4]);
         var3.a(f[var1 & 15]);
      } else {
         var3.a((byte)var2);
      }

      return var3.f();
   }

   private int a(int var1, char[] var2) {
      if(var1 < 0) {
         var1 = -(var1 + 1);
         var2[1] = 117;
         var2[4] = e[var1 >> 4];
         var2[5] = e[var1 & 15];
         return 6;
      } else {
         var2[1] = (char)var1;
         return 2;
      }
   }

   public static ig a() {
      SoftReference var0 = (SoftReference)a.get();
      ig var2;
      if(var0 == null) {
         var2 = null;
      } else {
         var2 = (ig)var0.get();
      }

      ig var1 = var2;
      if(var2 == null) {
         var1 = new ig();
         a.set(new SoftReference(var1));
      }

      return var1;
   }

   private void a(int var1) {
      if(var1 > 1114111) {
         throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(var1) + ") to output; max is 0x10FFFF as per RFC 4627");
      } else if(var1 >= '\ud800') {
         if(var1 <= '\udbff') {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(var1) + ")");
         } else {
            throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(var1) + ")");
         }
      } else {
         throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(var1) + ") to output");
      }
   }

   public final char[] a(String var1) {
      sp var9 = this.b;
      sp var10 = var9;
      if(var9 == null) {
         var10 = new sp((si)null);
         this.b = var10;
      }

      char[] var12 = var10.k();
      int[] var11 = sk.f();
      int var7 = var11.length;
      int var8 = var1.length();
      int var3 = 0;
      int var4 = 0;

      int var5;
      label36:
      while(true) {
         var5 = var3;
         if(var4 >= var8) {
            break;
         }

         while(true) {
            char var2 = var1.charAt(var4);
            int var6;
            if(var2 < var7 && var11[var2] != 0) {
               var5 = var4 + 1;
               var6 = this.a(var11[var1.charAt(var4)], this.d);
               if(var3 + var6 > var12.length) {
                  var4 = var12.length - var3;
                  if(var4 > 0) {
                     System.arraycopy(this.d, 0, var12, var3, var4);
                  }

                  var12 = var10.m();
                  var6 -= var4;
                  System.arraycopy(this.d, var4, var12, var3, var6);
                  var3 += var6;
                  var4 = var5;
               } else {
                  System.arraycopy(this.d, 0, var12, var3, var6);
                  var3 += var6;
                  var4 = var5;
               }
               break;
            }

            if(var3 >= var12.length) {
               var12 = var10.m();
               var3 = 0;
            }

            var5 = var3 + 1;
            var12[var3] = var2;
            var6 = var4 + 1;
            var3 = var5;
            var4 = var6;
            if(var6 >= var8) {
               break label36;
            }
         }
      }

      var10.a(var5);
      return var10.g();
   }

   public final byte[] b(String var1) {
      sj var8 = this.c;
      sj var10 = var8;
      if(var8 == null) {
         var10 = new sj((si)null);
         this.c = var10;
      }

      int var6 = var1.length();
      byte[] var14 = var10.c();
      int var2 = 0;
      int var3 = 0;

      label81:
      while(true) {
         int var4 = var2;
         if(var3 >= var6) {
            return this.c.d(var4);
         }

         int[] var11 = sk.f();
         byte[] var9 = var14;

         int var13;
         do {
            char var5 = var1.charAt(var3);
            if(var5 > 127 || var11[var5] != 0) {
               var14 = var9;
               var13 = var2;
               if(var2 >= var9.length) {
                  var14 = var10.d();
                  var13 = 0;
               }

               var4 = var3 + 1;
               char var12 = var1.charAt(var3);
               if(var12 <= 127) {
                  var2 = this.a(var12, var11[var12], var10, var13);
                  var14 = var10.e();
                  var3 = var4;
               } else {
                  if(var12 <= 2047) {
                     var2 = var13 + 1;
                     var14[var13] = (byte)(var12 >> 6 | 192);
                     var3 = var12 & 63 | 128;
                  } else if(var12 >= '\ud800' && var12 <= '\udfff') {
                     if(var12 > '\udbff') {
                        this.a(var12);
                     }

                     if(var4 >= var6) {
                        this.a(var12);
                     }

                     int var7 = this.a(var12, var1.charAt(var4));
                     if(var7 > 1114111) {
                        this.a(var7);
                     }

                     var2 = var13 + 1;
                     var14[var13] = (byte)(var7 >> 18 | 240);
                     if(var2 >= var14.length) {
                        var14 = var10.d();
                        var2 = 0;
                     }

                     var3 = var2 + 1;
                     var14[var2] = (byte)(var7 >> 12 & 63 | 128);
                     if(var3 >= var14.length) {
                        var14 = var10.d();
                        var2 = 0;
                     } else {
                        var2 = var3;
                     }

                     var13 = var2 + 1;
                     var14[var2] = (byte)(var7 >> 6 & 63 | 128);
                     ++var4;
                     var3 = var7 & 63 | 128;
                     var2 = var13;
                  } else {
                     var2 = var13 + 1;
                     var14[var13] = (byte)(var12 >> 12 | 224);
                     if(var2 >= var14.length) {
                        var14 = var10.d();
                        var2 = 0;
                     }

                     var13 = var2 + 1;
                     var14[var2] = (byte)(var12 >> 6 & 63 | 128);
                     var3 = var12 & 63 | 128;
                     var2 = var13;
                  }

                  var9 = var14;
                  var13 = var2;
                  if(var2 >= var14.length) {
                     var9 = var10.d();
                     var13 = 0;
                  }

                  var9[var13] = (byte)var3;
                  var14 = var9;
                  var3 = var4;
                  var2 = var13 + 1;
               }
               continue label81;
            }

            if(var2 >= var9.length) {
               var9 = var10.d();
               var2 = 0;
            }

            var4 = var2 + 1;
            var9[var2] = (byte)var5;
            var13 = var3 + 1;
            var2 = var4;
            var3 = var13;
         } while(var13 < var6);

         return this.c.d(var4);
      }
   }

   public final byte[] c(String var1) {
      sj var9 = this.c;
      sj var10 = var9;
      if(var9 == null) {
         var10 = new sj((si)null);
         this.c = var10;
      }

      int var8 = var1.length();
      byte[] var14 = var10.c();
      int var4 = var14.length;
      int var2 = 0;

      int var12;
      for(int var3 = 0; var3 < var8; var2 = var12 + 1) {
         int var6 = var3 + 1;
         char var7 = var1.charAt(var3);
         int var5 = var4;
         var3 = var6;

         char var11;
         for(var11 = var7; var11 <= 127; var5 = var6) {
            var6 = var5;
            var12 = var2;
            if(var2 >= var5) {
               var14 = var10.d();
               var6 = var14.length;
               var12 = 0;
            }

            var2 = var12 + 1;
            var14[var12] = (byte)var11;
            if(var3 >= var8) {
               return this.c.d(var2);
            }

            var11 = var1.charAt(var3);
            ++var3;
         }

         if(var2 >= var5) {
            var14 = var10.d();
            var2 = var14.length;
            var5 = 0;
         } else {
            var6 = var2;
            var2 = var5;
            var5 = var6;
         }

         if(var11 < 2048) {
            var6 = var5 + 1;
            var14[var5] = (byte)(var11 >> 6 | 192);
            var5 = var11;
            var4 = var6;
         } else if(var11 >= '\ud800' && var11 <= '\udfff') {
            if(var11 > '\udbff') {
               this.a(var11);
            }

            if(var3 >= var8) {
               this.a(var11);
            }

            var6 = this.a(var11, var1.charAt(var3));
            if(var6 > 1114111) {
               this.a(var6);
            }

            var12 = var5 + 1;
            var14[var5] = (byte)(var6 >> 18 | 240);
            var4 = var2;
            var5 = var12;
            if(var12 >= var2) {
               var14 = var10.d();
               var4 = var14.length;
               var5 = 0;
            }

            var2 = var5 + 1;
            var14[var5] = (byte)(var6 >> 12 & 63 | 128);
            if(var2 >= var4) {
               var14 = var10.d();
               var2 = var14.length;
               var4 = 0;
            } else {
               var5 = var2;
               var2 = var4;
               var4 = var5;
            }

            var14[var4] = (byte)(var6 >> 6 & 63 | 128);
            ++var4;
            var5 = var6;
            ++var3;
         } else {
            var12 = var5 + 1;
            var14[var5] = (byte)(var11 >> 12 | 224);
            var5 = var2;
            var6 = var12;
            if(var12 >= var2) {
               var14 = var10.d();
               var5 = var14.length;
               var6 = 0;
            }

            var14[var6] = (byte)(var11 >> 6 & 63 | 128);
            var12 = var6 + 1;
            var2 = var5;
            var4 = var12;
            var5 = var11;
         }

         var6 = var2;
         var12 = var4;
         if(var4 >= var2) {
            var14 = var10.d();
            var6 = var14.length;
            var12 = 0;
         }

         var14[var12] = (byte)(var5 & 63 | 128);
         var4 = var6;
      }

      return this.c.d(var2);
   }
}
