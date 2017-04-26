package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.he;
import com.flurry.sdk.hf;
import com.flurry.sdk.hf$a;
import com.flurry.sdk.hn;
import com.flurry.sdk.hp;
import com.flurry.sdk.ht;
import com.flurry.sdk.hx;
import com.flurry.sdk.id;
import com.flurry.sdk.ie;
import com.flurry.sdk.ij;
import com.flurry.sdk.im;
import com.flurry.sdk.sk;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class hz extends ht {
   static final byte[] g = sk.h();
   protected static final int[] h = sk.f();
   private static final byte[] u = new byte[]{(byte)110, (byte)117, (byte)108, (byte)108};
   private static final byte[] v = new byte[]{(byte)116, (byte)114, (byte)117, (byte)101};
   private static final byte[] w = new byte[]{(byte)102, (byte)97, (byte)108, (byte)115, (byte)101};
   protected final ie i;
   protected final OutputStream j;
   protected int[] k;
   protected int l;
   protected id m;
   protected byte[] n;
   protected int o;
   protected final int p;
   protected final int q;
   protected char[] r;
   protected final int s;
   protected boolean t;

   public hz(ie var1, int var2, hn var3, OutputStream var4) {
      super(var2, var3);
      this.k = h;
      this.o = 0;
      this.i = var1;
      this.j = var4;
      this.t = true;
      this.n = var1.f();
      this.p = this.n.length;
      this.q = this.p >> 3;
      this.r = var1.h();
      this.s = this.r.length;
      if(this.a((hf$a)hf$a.g)) {
         this.a((int)127);
      }

   }

   private final int a(int var1, char[] var2, int var3, int var4) {
      if(var1 >= '\ud800' && var1 <= '\udfff') {
         if(var3 >= var4) {
            this.i("Split surrogate on writeRaw() input (last character)");
         }

         this.a(var1, var2[var3]);
         return var3 + 1;
      } else {
         byte[] var5 = this.n;
         var4 = this.o;
         this.o = var4 + 1;
         var5[var4] = (byte)(var1 >> 12 | 224);
         var4 = this.o;
         this.o = var4 + 1;
         var5[var4] = (byte)(var1 >> 6 & 63 | 128);
         var4 = this.o;
         this.o = var4 + 1;
         var5[var4] = (byte)(var1 & 63 | 128);
         return var3;
      }
   }

   private int a(byte[] var1, int var2, int var3, byte[] var4, int var5) {
      int var7 = var4.length;
      int var6;
      if(var2 + var7 > var3) {
         this.o = var2;
         this.o();
         var6 = this.o;
         if(var7 > var1.length) {
            this.j.write(var4, 0, var7);
            return var6;
         }

         System.arraycopy(var4, 0, var1, var6, var7);
         var2 = var6 + var7;
      }

      var6 = var2;
      if(var5 * 6 + var2 > var3) {
         this.o();
         return this.o;
      } else {
         return var6;
      }
   }

   private int a(byte[] var1, int var2, hp var3, int var4) {
      byte[] var6 = var3.c();
      int var5 = var6.length;
      if(var5 > 6) {
         return this.a(var1, var2, this.p, var6, var4);
      } else {
         System.arraycopy(var6, 0, var1, var2, var5);
         return var5 + var2;
      }
   }

   private final void b(long var1) {
      if(this.o + 23 >= this.p) {
         this.o();
      }

      byte[] var4 = this.n;
      int var3 = this.o;
      this.o = var3 + 1;
      var4[var3] = 34;
      this.o = ij.a(var1, this.n, this.o);
      var4 = this.n;
      var3 = this.o;
      this.o = var3 + 1;
      var4[var3] = 34;
   }

   private final void b(byte[] var1) {
      int var2 = var1.length;
      if(this.o + var2 > this.p) {
         this.o();
         if(var2 > 512) {
            this.j.write(var1, 0, var2);
            return;
         }
      }

      System.arraycopy(var1, 0, this.n, this.o, var2);
      this.o += var2;
   }

   private final int c(int var1, int var2) {
      byte[] var4 = this.n;
      int var3;
      if(var1 >= '\ud800' && var1 <= '\udfff') {
         var3 = var2 + 1;
         var4[var2] = 92;
         var2 = var3 + 1;
         var4[var3] = 117;
         var3 = var2 + 1;
         var4[var2] = g[var1 >> 12 & 15];
         var2 = var3 + 1;
         var4[var3] = g[var1 >> 8 & 15];
         var3 = var2 + 1;
         var4[var2] = g[var1 >> 4 & 15];
         var4[var3] = g[var1 & 15];
         return var3 + 1;
      } else {
         var3 = var2 + 1;
         var4[var2] = (byte)(var1 >> 12 | 224);
         var2 = var3 + 1;
         var4[var3] = (byte)(var1 >> 6 & 63 | 128);
         var4[var2] = (byte)(var1 & 63 | 128);
         return var2 + 1;
      }
   }

   private final void c(int var1) {
      if(this.o + 13 >= this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      int var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = 34;
      this.o = ij.a(var1, this.n, this.o);
      var3 = this.n;
      var1 = this.o;
      this.o = var1 + 1;
      var3[var1] = 34;
   }

   private final void c(Object var1) {
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      int var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = 34;
      this.c(var1.toString());
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var4 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var4[var2] = 34;
   }

   private final void c(char[] var1, int var2, int var3) {
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var4 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var4[var2] = 34;
      this.e(this.r, 0, var3);
      if(this.o >= this.p) {
         this.o();
      }

      var4 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var4[var2] = 34;
   }

   private int d(int var1, int var2) {
      byte[] var5 = this.n;
      int var3 = var2 + 1;
      var5[var2] = 92;
      var2 = var3 + 1;
      var5[var3] = 117;
      if(var1 > 255) {
         var3 = var1 >> 8 & 255;
         int var4 = var2 + 1;
         var5[var2] = g[var3 >> 4];
         var2 = var4 + 1;
         var5[var4] = g[var3 & 15];
         var1 &= 255;
      } else {
         var3 = var2 + 1;
         var5[var2] = 48;
         var2 = var3 + 1;
         var5[var3] = 48;
      }

      var3 = var2 + 1;
      var5[var2] = g[var1 >> 4];
      var5[var3] = g[var1 & 15];
      return var3 + 1;
   }

   private final void d(char[] var1, int var2, int var3) {
      int var5 = this.p;
      byte[] var7 = this.n;

      while(var2 < var3) {
         while(true) {
            char var4 = var1[var2];
            int var6;
            int var9;
            if(var4 >= 128) {
               if(this.o + 3 >= this.p) {
                  this.o();
               }

               var9 = var2 + 1;
               char var8 = var1[var2];
               if(var8 < 2048) {
                  var6 = this.o;
                  this.o = var6 + 1;
                  var7[var6] = (byte)(var8 >> 6 | 192);
                  var6 = this.o;
                  this.o = var6 + 1;
                  var7[var6] = (byte)(var8 & 63 | 128);
                  var2 = var9;
               } else {
                  this.a(var8, var1, var9, var3);
                  var2 = var9;
               }
            } else {
               if(this.o >= var5) {
                  this.o();
               }

               var6 = this.o;
               this.o = var6 + 1;
               var7[var6] = (byte)var4;
               var9 = var2 + 1;
               var2 = var9;
               if(var9 >= var3) {
                  return;
               }
            }
         }
      }

   }

   private final void e(char[] var1, int var2, int var3) {
      int var4;
      do {
         var4 = Math.min(this.q, var3);
         if(this.o + var4 > this.p) {
            this.o();
         }

         this.f(var1, var2, var4);
         var2 += var4;
         var4 = var3 - var4;
         var3 = var4;
      } while(var4 > 0);

   }

   private final void f(char[] var1, int var2, int var3) {
      int var5 = var3 + var2;
      int var4 = this.o;
      byte[] var6 = this.n;
      int[] var7 = this.k;
      var3 = var2;

      for(var2 = var4; var3 < var5; ++var2) {
         char var8 = var1[var3];
         if(var8 > 127 || var7[var8] != 0) {
            break;
         }

         var6[var2] = (byte)var8;
         ++var3;
      }

      this.o = var2;
      if(var3 < var5) {
         if(this.m == null) {
            if(this.l == 0) {
               this.g(var1, var3, var5);
               return;
            }

            this.h(var1, var3, var5);
            return;
         }

         this.i(var1, var3, var5);
      }

   }

   private final void g(char[] var1, int var2, int var3) {
      if(this.o + (var3 - var2) * 6 > this.p) {
         this.o();
      }

      int var5 = this.o;
      byte[] var7 = this.n;
      int[] var8 = this.k;
      int var4 = var2;
      var2 = var5;

      while(var4 < var3) {
         var5 = var4 + 1;
         char var9 = var1[var4];
         int var6;
         if(var9 <= 127) {
            if(var8[var9] == 0) {
               var7[var2] = (byte)var9;
               ++var2;
               var4 = var5;
            } else {
               var6 = var8[var9];
               if(var6 > 0) {
                  var4 = var2 + 1;
                  var7[var2] = 92;
                  var2 = var4 + 1;
                  var7[var4] = (byte)var6;
                  var4 = var5;
               } else {
                  var2 = this.d(var9, var2);
                  var4 = var5;
               }
            }
         } else if(var9 <= 2047) {
            var6 = var2 + 1;
            var7[var2] = (byte)(var9 >> 6 | 192);
            var2 = var6 + 1;
            var7[var6] = (byte)(var9 & 63 | 128);
            var4 = var5;
         } else {
            var2 = this.c(var9, var2);
            var4 = var5;
         }
      }

      this.o = var2;
   }

   private final void h(char[] var1, int var2, int var3) {
      if(this.o + (var3 - var2) * 6 > this.p) {
         this.o();
      }

      int var5 = this.o;
      byte[] var8 = this.n;
      int[] var9 = this.k;
      int var6 = this.l;
      int var4 = var2;
      var2 = var5;

      while(var4 < var3) {
         var5 = var4 + 1;
         char var10 = var1[var4];
         int var7;
         if(var10 <= 127) {
            if(var9[var10] == 0) {
               var8[var2] = (byte)var10;
               ++var2;
               var4 = var5;
            } else {
               var7 = var9[var10];
               if(var7 > 0) {
                  var4 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var4 + 1;
                  var8[var4] = (byte)var7;
                  var4 = var5;
               } else {
                  var2 = this.d(var10, var2);
                  var4 = var5;
               }
            }
         } else if(var10 > var6) {
            var2 = this.d(var10, var2);
            var4 = var5;
         } else if(var10 <= 2047) {
            var7 = var2 + 1;
            var8[var2] = (byte)(var10 >> 6 | 192);
            var2 = var7 + 1;
            var8[var7] = (byte)(var10 & 63 | 128);
            var4 = var5;
         } else {
            var2 = this.c(var10, var2);
            var4 = var5;
         }
      }

      this.o = var2;
   }

   private final void i(char[] var1, int var2, int var3) {
      if(this.o + (var3 - var2) * 6 > this.p) {
         this.o();
      }

      int var5 = this.o;
      byte[] var8 = this.n;
      int[] var9 = this.k;
      int var6;
      if(this.l <= 0) {
         var6 = '\uffff';
      } else {
         var6 = this.l;
      }

      id var10 = this.m;
      int var4 = var2;
      var2 = var5;

      while(var4 < var3) {
         var5 = var4 + 1;
         char var12 = var1[var4];
         int var7;
         hp var11;
         if(var12 <= 127) {
            if(var9[var12] == 0) {
               var8[var2] = (byte)var12;
               ++var2;
               var4 = var5;
            } else {
               var7 = var9[var12];
               if(var7 > 0) {
                  var4 = var2 + 1;
                  var8[var2] = 92;
                  var2 = var4 + 1;
                  var8[var4] = (byte)var7;
                  var4 = var5;
               } else if(var7 == -2) {
                  var11 = var10.a(var12);
                  if(var11 == null) {
                     throw new he("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(var12) + ", although was supposed to have one");
                  }

                  var2 = this.a(var8, var2, var11, var3 - var5);
                  var4 = var5;
               } else {
                  var2 = this.d(var12, var2);
                  var4 = var5;
               }
            }
         } else if(var12 > var6) {
            var2 = this.d(var12, var2);
            var4 = var5;
         } else {
            var11 = var10.a(var12);
            if(var11 != null) {
               var2 = this.a(var8, var2, var11, var3 - var5);
               var4 = var5;
            } else if(var12 <= 2047) {
               var7 = var2 + 1;
               var8[var2] = (byte)(var12 >> 6 | 192);
               var2 = var7 + 1;
               var8[var7] = (byte)(var12 & 63 | 128);
               var4 = var5;
            } else {
               var2 = this.c(var12, var2);
               var4 = var5;
            }
         }
      }

      this.o = var2;
   }

   private final void k(String var1) {
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      int var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = 34;
      this.l(var1);
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var4 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var4[var2] = 34;
   }

   private final void l(String var1) {
      int var2 = var1.length();
      char[] var5 = this.r;

      int var4;
      for(int var3 = 0; var2 > 0; var2 -= var4) {
         var4 = Math.min(this.q, var2);
         var1.getChars(var3, var3 + var4, var5, 0);
         if(this.o + var4 > this.p) {
            this.o();
         }

         this.f(var5, 0, var4);
         var3 += var4;
      }

   }

   private final void p() {
      if(this.o + 4 >= this.p) {
         this.o();
      }

      System.arraycopy(u, 0, this.n, this.o, 4);
      this.o += 4;
   }

   public hf a(int var1) {
      int var2 = var1;
      if(var1 < 0) {
         var2 = 0;
      }

      this.l = var2;
      return this;
   }

   public hf a(id var1) {
      this.m = var1;
      if(var1 == null) {
         this.k = h;
         return this;
      } else {
         this.k = var1.a();
         return this;
      }
   }

   public void a(char var1) {
      if(this.o + 3 >= this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      int var2;
      if(var1 <= 127) {
         var2 = this.o;
         this.o = var2 + 1;
         var3[var2] = (byte)var1;
      } else if(var1 < 2048) {
         var2 = this.o;
         this.o = var2 + 1;
         var3[var2] = (byte)(var1 >> 6 | 192);
         var2 = this.o;
         this.o = var2 + 1;
         var3[var2] = (byte)(var1 & 63 | 128);
      } else {
         this.a(var1, (char[])null, 0, 0);
      }
   }

   public void a(double var1) {
      if(!this.d && (!Double.isNaN(var1) && !Double.isInfinite(var1) || !this.a((hf$a)hf$a.d))) {
         this.h("write number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   public void a(float var1) {
      if(!this.d && (!Float.isNaN(var1) && !Float.isInfinite(var1) || !this.a((hf$a)hf$a.d))) {
         this.h("write number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   protected final void a(int var1, int var2) {
      var1 = this.b(var1, var2);
      if(this.o + 4 > this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = (byte)(var1 >> 18 | 240);
      var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = (byte)(var1 >> 12 & 63 | 128);
      var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = (byte)(var1 >> 6 & 63 | 128);
      var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = (byte)(var1 & 63 | 128);
   }

   public void a(long var1) {
      this.h("write number");
      if(this.d) {
         this.b(var1);
      } else {
         if(this.o + 21 >= this.p) {
            this.o();
         }

         this.o = ij.a(var1, this.n, this.o);
      }
   }

   public void a(ha var1, byte[] var2, int var3, int var4) {
      this.h("write binary value");
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var6 = this.n;
      int var5 = this.o;
      this.o = var5 + 1;
      var6[var5] = 34;
      this.b(var1, var2, var3, var3 + var4);
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var7 = this.n;
      var3 = this.o;
      this.o = var3 + 1;
      var7[var3] = 34;
   }

   public final void a(hp var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1.a());
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(this.a != null) {
         if(var2 != 1) {
            var3 = false;
         }

         this.a(var1, var3);
      } else {
         if(var2 == 1) {
            if(this.o >= this.p) {
               this.o();
            }

            byte[] var4 = this.n;
            var2 = this.o;
            this.o = var2 + 1;
            var4[var2] = 44;
         }

         this.c(var1);
      }
   }

   protected final void a(hp var1, boolean var2) {
      if(var2) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      var2 = this.a((hf$a)hf$a.c);
      int var3;
      if(var2) {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var4 = this.n;
         var3 = this.o;
         this.o = var3 + 1;
         var4[var3] = 34;
      }

      this.b(var1.d());
      if(var2) {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var5 = this.n;
         var3 = this.o;
         this.o = var3 + 1;
         var5[var3] = 34;
      }

   }

   public final void a(im var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1.a());
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(this.a != null) {
         if(var2 != 1) {
            var3 = false;
         }

         this.a(var1, var3);
      } else {
         if(var2 == 1) {
            if(this.o >= this.p) {
               this.o();
            }

            byte[] var4 = this.n;
            var2 = this.o;
            this.o = var2 + 1;
            var4[var2] = 44;
         }

         this.c((hp)var1);
      }
   }

   public final void a(String var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1);
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(this.a != null) {
         if(var2 != 1) {
            var3 = false;
         }

         this.b(var1, var3);
      } else {
         if(var2 == 1) {
            if(this.o >= this.p) {
               this.o();
            }

            byte[] var4 = this.n;
            var2 = this.o;
            this.o = var2 + 1;
            var4[var2] = 44;
         }

         this.j(var1);
      }
   }

   public final void a(String var1, String var2) {
      this.a(var1);
      this.b(var2);
   }

   public void a(BigDecimal var1) {
      this.h("write number");
      if(var1 == null) {
         this.p();
      } else if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1.toString());
      }
   }

   public void a(BigInteger var1) {
      this.h("write number");
      if(var1 == null) {
         this.p();
      } else if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1.toString());
      }
   }

   public void a(boolean var1) {
      this.h("write boolean value");
      if(this.o + 5 >= this.p) {
         this.o();
      }

      byte[] var3;
      if(var1) {
         var3 = v;
      } else {
         var3 = w;
      }

      int var2 = var3.length;
      System.arraycopy(var3, 0, this.n, this.o, var2);
      this.o += var2;
   }

   public void a(char[] var1, int var2, int var3) {
      this.h("write text value");
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var5 = this.n;
      int var4 = this.o;
      this.o = var4 + 1;
      var5[var4] = 34;
      if(var3 <= this.q) {
         if(this.o + var3 > this.p) {
            this.o();
         }

         this.f(var1, var2, var3);
      } else {
         this.e(var1, var2, var3);
      }

      if(this.o >= this.p) {
         this.o();
      }

      byte[] var6 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var6[var2] = 34;
   }

   protected final int b(int var1, int var2) {
      if(var2 < '\udc00' || var2 > '\udfff') {
         this.i("Incomplete surrogate pair: first char 0x" + Integer.toHexString(var1) + ", second 0x" + Integer.toHexString(var2));
      }

      return 65536 + (var1 - '\ud800' << 10) + (var2 - '\udc00');
   }

   public final void b() {
      this.h("start an array");
      this.e = this.e.h();
      if(this.a != null) {
         this.a.e(this);
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var2 = this.n;
         int var1 = this.o;
         this.o = var1 + 1;
         var2[var1] = 91;
      }
   }

   public void b(int var1) {
      this.h("write number");
      if(this.o + 11 >= this.p) {
         this.o();
      }

      if(this.d) {
         this.c(var1);
      } else {
         this.o = ij.a(var1, this.n, this.o);
      }
   }

   protected void b(ha var1, byte[] var2, int var3, int var4) {
      int var8 = this.p - 6;
      int var6 = var1.c() >> 2;
      int var5 = var3;
      var3 = var6;

      while(var5 <= var4 - 3) {
         if(this.o > var8) {
            this.o();
         }

         var6 = var5 + 1;
         byte var11 = var2[var5];
         int var7 = var6 + 1;
         byte var9 = var2[var6];
         var6 = var7 + 1;
         this.o = var1.a((var9 & 255 | var11 << 8) << 8 | var2[var7] & 255, this.n, this.o);
         var7 = var3 - 1;
         var3 = var7;
         var5 = var6;
         if(var7 <= 0) {
            byte[] var10 = this.n;
            var3 = this.o;
            this.o = var3 + 1;
            var10[var3] = 92;
            var10 = this.n;
            var3 = this.o;
            this.o = var3 + 1;
            var10[var3] = 110;
            var3 = var1.c() >> 2;
            var5 = var6;
         }
      }

      var6 = var4 - var5;
      if(var6 > 0) {
         if(this.o > var8) {
            this.o();
         }

         var4 = var2[var5] << 16;
         var3 = var4;
         if(var6 == 2) {
            var3 = var4 | (var2[var5 + 1] & 255) << 8;
         }

         this.o = var1.a(var3, var6, this.n, this.o);
      }

   }

   public final void b(hp var1) {
      this.h("write text value");
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var3 = this.n;
      int var2 = this.o;
      this.o = var2 + 1;
      var3[var2] = 34;
      this.b(var1.d());
      if(this.o >= this.p) {
         this.o();
      }

      byte[] var4 = this.n;
      var2 = this.o;
      this.o = var2 + 1;
      var4[var2] = 34;
   }

   public void b(String var1) {
      this.h("write text value");
      if(var1 == null) {
         this.p();
      } else {
         int var2 = var1.length();
         if(var2 > this.s) {
            this.k(var1);
         } else {
            var1.getChars(0, var2, this.r, 0);
            if(var2 > this.q) {
               this.c(this.r, 0, var2);
            } else {
               if(this.o + var2 >= this.p) {
                  this.o();
               }

               byte[] var4 = this.n;
               int var3 = this.o;
               this.o = var3 + 1;
               var4[var3] = 34;
               this.f(this.r, 0, var2);
               if(this.o >= this.p) {
                  this.o();
               }

               var4 = this.n;
               var2 = this.o;
               this.o = var2 + 1;
               var4[var2] = 34;
            }
         }
      }
   }

   protected final void b(String var1, int var2) {
      switch(var2) {
      case 0:
         if(this.e.a()) {
            this.a.g(this);
            return;
         }

         if(this.e.c()) {
            this.a.h(this);
            return;
         }
         break;
      case 1:
         this.a.f(this);
         return;
      case 2:
         this.a.d(this);
         return;
      case 3:
         this.a.a(this);
         return;
      default:
         this.m();
      }

   }

   protected final void b(String var1, boolean var2) {
      if(var2) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      if(this.a((hf$a)hf$a.c)) {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var4 = this.n;
         int var3 = this.o;
         this.o = var3 + 1;
         var4[var3] = 34;
         var3 = var1.length();
         if(var3 <= this.s) {
            var1.getChars(0, var3, this.r, 0);
            if(var3 <= this.q) {
               if(this.o + var3 > this.p) {
                  this.o();
               }

               this.f(this.r, 0, var3);
            } else {
               this.e(this.r, 0, var3);
            }
         } else {
            this.l(var1);
         }

         if(this.o >= this.p) {
            this.o();
         }

         byte[] var5 = this.n;
         var3 = this.o;
         this.o = var3 + 1;
         var5[var3] = 34;
      } else {
         this.l(var1);
      }
   }

   public final void b(char[] var1, int var2, int var3) {
      int var4 = var3 + var3 + var3;
      if(this.o + var4 > this.p) {
         if(this.p < var4) {
            this.d(var1, var2, var3);
            return;
         }

         this.o();
      }

      var4 = var3 + var2;

      label29:
      while(var2 < var4) {
         var3 = var2;

         do {
            char var7 = var1[var3];
            int var5;
            byte[] var6;
            if(var7 > 127) {
               var2 = var3 + 1;
               char var8 = var1[var3];
               if(var8 < 2048) {
                  var6 = this.n;
                  var5 = this.o;
                  this.o = var5 + 1;
                  var6[var5] = (byte)(var8 >> 6 | 192);
                  var6 = this.n;
                  var5 = this.o;
                  this.o = var5 + 1;
                  var6[var5] = (byte)(var8 & 63 | 128);
               } else {
                  this.a(var8, var1, var2, var4);
               }
               continue label29;
            }

            var6 = this.n;
            var5 = this.o;
            this.o = var5 + 1;
            var6[var5] = (byte)var7;
            ++var3;
         } while(var3 < var4);

         return;
      }

   }

   public final void c() {
      if(!this.e.a()) {
         this.i("Current context not an ARRAY but " + this.e.d());
      }

      if(this.a != null) {
         this.a.b(this, this.e.e());
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var2 = this.n;
         int var1 = this.o;
         this.o = var1 + 1;
         var2[var1] = 93;
      }

      this.e = this.e.j();
   }

   protected final void c(hp var1) {
      byte[] var4 = var1.d();
      if(!this.a((hf$a)hf$a.c)) {
         this.b(var4);
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var3 = this.n;
         int var2 = this.o;
         this.o = var2 + 1;
         var3[var2] = 34;
         var2 = var4.length;
         if(this.o + var2 + 1 < this.p) {
            System.arraycopy(var4, 0, this.n, this.o, var2);
            this.o += var2;
         } else {
            this.b(var4);
            if(this.o >= this.p) {
               this.o();
            }
         }

         var4 = this.n;
         var2 = this.o;
         this.o = var2 + 1;
         var4[var2] = 34;
      }
   }

   public void c(String var1) {
      int var2 = var1.length();

      int var4;
      for(int var3 = 0; var2 > 0; var2 -= var4) {
         char[] var6 = this.r;
         int var5 = var6.length;
         var4 = var5;
         if(var2 < var5) {
            var4 = var2;
         }

         var1.getChars(var3, var3 + var4, var6, 0);
         this.b(var6, 0, var4);
         var3 += var4;
      }

   }

   public void close() {
      super.close();
      if(this.n != null && this.a((hf$a)hf$a.b)) {
         label33:
         while(true) {
            while(true) {
               hx var1 = this.h();
               if(var1.a()) {
                  this.c();
               } else {
                  if(!var1.c()) {
                     break label33;
                  }

                  this.e();
               }
            }
         }
      }

      this.o();
      if(this.j != null) {
         if(!this.i.c() && !this.a((hf$a)hf$a.a)) {
            if(this.a((hf$a)hf$a.f)) {
               this.j.flush();
            }
         } else {
            this.j.close();
         }
      }

      this.n();
   }

   public final void d() {
      this.h("start an object");
      this.e = this.e.i();
      if(this.a != null) {
         this.a.b(this);
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var2 = this.n;
         int var1 = this.o;
         this.o = var1 + 1;
         var2[var1] = 123;
      }
   }

   public final void e() {
      if(!this.e.c()) {
         this.i("Current context not an object but " + this.e.d());
      }

      this.e = this.e.j();
      if(this.a != null) {
         this.a.a(this, this.e.e());
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var2 = this.n;
         int var1 = this.o;
         this.o = var1 + 1;
         var2[var1] = 125;
      }
   }

   public void e(String var1) {
      this.h("write number");
      if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1);
      }
   }

   public void f() {
      this.h("write null value");
      this.p();
   }

   public final void g() {
      this.o();
      if(this.j != null && this.a((hf$a)hf$a.f)) {
         this.j.flush();
      }

   }

   protected final void h(String var1) {
      int var3 = this.e.k();
      if(var3 == 5) {
         this.i("Can not " + var1 + ", expecting field name");
      }

      if(this.a == null) {
         byte var2;
         switch(var3) {
         case 1:
            var2 = 44;
            break;
         case 2:
            var2 = 58;
            break;
         case 3:
            var2 = 32;
            break;
         default:
            return;
         }

         if(this.o >= this.p) {
            this.o();
         }

         this.n[this.o] = var2;
         ++this.o;
      } else {
         this.b(var1, var3);
      }
   }

   protected final void j(String var1) {
      if(!this.a((hf$a)hf$a.c)) {
         this.l(var1);
      } else {
         if(this.o >= this.p) {
            this.o();
         }

         byte[] var3 = this.n;
         int var2 = this.o;
         this.o = var2 + 1;
         var3[var2] = 34;
         var2 = var1.length();
         if(var2 <= this.s) {
            var1.getChars(0, var2, this.r, 0);
            if(var2 <= this.q) {
               if(this.o + var2 > this.p) {
                  this.o();
               }

               this.f(this.r, 0, var2);
            } else {
               this.e(this.r, 0, var2);
            }
         } else {
            this.l(var1);
         }

         if(this.o >= this.p) {
            this.o();
         }

         byte[] var4 = this.n;
         var2 = this.o;
         this.o = var2 + 1;
         var4[var2] = 34;
      }
   }

   protected void n() {
      byte[] var1 = this.n;
      if(var1 != null && this.t) {
         this.n = null;
         this.i.b(var1);
      }

      char[] var2 = this.r;
      if(var2 != null) {
         this.r = null;
         this.i.b(var2);
      }

   }

   protected final void o() {
      int var1 = this.o;
      if(var1 > 0) {
         this.o = 0;
         this.j.write(this.n, 0, var1);
      }

   }
}
