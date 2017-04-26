package com.flurry.sdk;

import com.flurry.sdk.ha;
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
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class ib extends ht {
   protected static final char[] g = sk.g();
   protected static final int[] h = sk.f();
   protected final ie i;
   protected final Writer j;
   protected int[] k;
   protected int l;
   protected id m;
   protected hp n;
   protected char[] o;
   protected int p;
   protected int q;
   protected int r;
   protected char[] s;

   public ib(ie var1, int var2, hn var3, Writer var4) {
      super(var2, var3);
      this.k = h;
      this.p = 0;
      this.q = 0;
      this.i = var1;
      this.j = var4;
      this.o = var1.h();
      this.r = this.o.length;
      if(this.a((hf$a)hf$a.g)) {
         this.a((int)127);
      }

   }

   private final int a(char[] var1, int var2, int var3, char var4, int var5) {
      char[] var8;
      if(var5 >= 0) {
         if(var2 > 1 && var2 < var3) {
            var2 -= 2;
            var1[var2] = 92;
            var1[var2 + 1] = (char)var5;
            return var2;
         } else {
            var8 = this.s;
            var1 = var8;
            if(var8 == null) {
               var1 = this.q();
            }

            var1[1] = (char)var5;
            this.j.write(var1, 0, 2);
            return var2;
         }
      } else {
         int var7;
         if(var5 != -2) {
            if(var2 > 5 && var2 < var3) {
               var2 -= 6;
               var3 = var2 + 1;
               var1[var2] = 92;
               var2 = var3 + 1;
               var1[var3] = 117;
               if(var4 > 255) {
                  var3 = var4 >> 8 & 255;
                  var5 = var2 + 1;
                  var1[var2] = g[var3 >> 4];
                  var2 = var5 + 1;
                  var1[var5] = g[var3 & 15];
                  var4 = (char)(var4 & 255);
               } else {
                  var3 = var2 + 1;
                  var1[var2] = 48;
                  var2 = var3 + 1;
                  var1[var3] = 48;
               }

               var3 = var2 + 1;
               var1[var2] = g[var4 >> 4];
               var1[var3] = g[var4 & 15];
               return var3 - 5;
            } else {
               var8 = this.s;
               var1 = var8;
               if(var8 == null) {
                  var1 = this.q();
               }

               this.p = this.q;
               if(var4 > 255) {
                  var3 = var4 >> 8 & 255;
                  var7 = var4 & 255;
                  var1[10] = g[var3 >> 4];
                  var1[11] = g[var3 & 15];
                  var1[12] = g[var7 >> 4];
                  var1[13] = g[var7 & 15];
                  this.j.write(var1, 8, 6);
                  return var2;
               } else {
                  var1[6] = g[var4 >> 4];
                  var1[7] = g[var4 & 15];
                  this.j.write(var1, 2, 6);
                  return var2;
               }
            }
         } else {
            String var6;
            if(this.n == null) {
               var6 = this.m.a(var4).a();
            } else {
               var6 = this.n.a();
               this.n = null;
            }

            var7 = var6.length();
            if(var2 >= var7 && var2 < var3) {
               var2 -= var7;
               var6.getChars(0, var7, var1, var2);
               return var2;
            } else {
               this.j.write(var6);
               return var2;
            }
         }
      }
   }

   private final void a(char var1, int var2) {
      char[] var5;
      int var6;
      char[] var7;
      if(var2 >= 0) {
         if(this.q >= 2) {
            var6 = this.q - 2;
            this.p = var6;
            this.o[var6] = 92;
            this.o[var6 + 1] = (char)var2;
         } else {
            var5 = this.s;
            var7 = var5;
            if(var5 == null) {
               var7 = this.q();
            }

            this.p = this.q;
            var7[1] = (char)var2;
            this.j.write(var7, 0, 2);
         }
      } else if(var2 != -2) {
         if(this.q >= 6) {
            var7 = this.o;
            var2 = this.q - 6;
            this.p = var2;
            var7[var2] = 92;
            ++var2;
            var7[var2] = 117;
            if(var1 > 255) {
               int var3 = var1 >> 8 & 255;
               ++var2;
               var7[var2] = g[var3 >> 4];
               ++var2;
               var7[var2] = g[var3 & 15];
               var1 = (char)(var1 & 255);
            } else {
               ++var2;
               var7[var2] = 48;
               ++var2;
               var7[var2] = 48;
            }

            ++var2;
            var7[var2] = g[var1 >> 4];
            var7[var2 + 1] = g[var1 & 15];
         } else {
            var5 = this.s;
            var7 = var5;
            if(var5 == null) {
               var7 = this.q();
            }

            this.p = this.q;
            if(var1 > 255) {
               var2 = var1 >> 8 & 255;
               var6 = var1 & 255;
               var7[10] = g[var2 >> 4];
               var7[11] = g[var2 & 15];
               var7[12] = g[var6 >> 4];
               var7[13] = g[var6 & 15];
               this.j.write(var7, 8, 6);
            } else {
               var7[6] = g[var1 >> 4];
               var7[7] = g[var1 & 15];
               this.j.write(var7, 2, 6);
            }
         }
      } else {
         String var4;
         if(this.n == null) {
            var4 = this.m.a(var1).a();
         } else {
            var4 = this.n.a();
            this.n = null;
         }

         var6 = var4.length();
         if(this.q >= var6) {
            var2 = this.q - var6;
            this.p = var2;
            var4.getChars(0, var6, this.o, var2);
         } else {
            this.p = this.q;
            this.j.write(var4);
         }
      }
   }

   private void a(int var1, int var2) {
      int var4 = this.q + var1;
      int[] var7 = this.k;
      int var5 = Math.min(var7.length, this.l + 1);

      while(this.q < var4) {
         char var3;
         while(true) {
            var3 = this.o[this.q];
            if(var3 < var5) {
               var1 = var7[var3];
               if(var1 != 0) {
                  break;
               }
            } else if(var3 > var2) {
               var1 = -1;
               break;
            }

            var1 = this.q + 1;
            this.q = var1;
            if(var1 >= var4) {
               return;
            }
         }

         int var6 = this.q - this.p;
         if(var6 > 0) {
            this.j.write(this.o, this.p, var6);
         }

         ++this.q;
         this.a(var3, var1);
      }

   }

   private final void a(char[] var1, int var2, int var3, int var4) {
      int var9 = var3 + var2;
      int[] var11 = this.k;
      int var10 = Math.min(var11.length, var4 + 1);
      byte var6 = 0;
      var3 = var2;
      var2 = var6;

      while(var3 < var9) {
         int var12 = var3;
         int var8 = var2;

         char var5;
         int var7;
         while(true) {
            var5 = var1[var12];
            if(var5 < var10) {
               var7 = var11[var5];
               var2 = var7;
               if(var7 != 0) {
                  var2 = var7;
                  break;
               }
            } else {
               var2 = var8;
               if(var5 > var4) {
                  var2 = -1;
                  break;
               }
            }

            var7 = var12 + 1;
            var8 = var2;
            var12 = var7;
            if(var7 >= var9) {
               var12 = var7;
               break;
            }
         }

         var7 = var12 - var3;
         if(var7 < 32) {
            if(this.q + var7 > this.r) {
               this.o();
            }

            if(var7 > 0) {
               System.arraycopy(var1, var3, this.o, this.q, var7);
               this.q += var7;
            }
         } else {
            this.o();
            this.j.write(var1, var3, var7);
         }

         if(var12 >= var9) {
            break;
         }

         var3 = var12 + 1;
         this.b(var5, var2);
      }

   }

   private final void b(char var1, int var2) {
      int var6;
      char[] var7;
      if(var2 >= 0) {
         if(this.q + 2 > this.r) {
            this.o();
         }

         var7 = this.o;
         var6 = this.q;
         this.q = var6 + 1;
         var7[var6] = 92;
         var7 = this.o;
         var6 = this.q;
         this.q = var6 + 1;
         var7[var6] = (char)var2;
      } else if(var2 != -2) {
         if(this.q + 2 > this.r) {
            this.o();
         }

         var2 = this.q;
         var7 = this.o;
         int var3 = var2 + 1;
         var7[var2] = 92;
         var2 = var3 + 1;
         var7[var3] = 117;
         if(var1 > 255) {
            var3 = var1 >> 8 & 255;
            int var4 = var2 + 1;
            var7[var2] = g[var3 >> 4];
            var2 = var4 + 1;
            var7[var4] = g[var3 & 15];
            var1 = (char)(var1 & 255);
         } else {
            var3 = var2 + 1;
            var7[var2] = 48;
            var2 = var3 + 1;
            var7[var3] = 48;
         }

         var3 = var2 + 1;
         var7[var2] = g[var1 >> 4];
         var7[var3] = g[var1 & 15];
         this.q = var3;
      } else {
         String var5;
         if(this.n == null) {
            var5 = this.m.a(var1).a();
         } else {
            var5 = this.n.a();
            this.n = null;
         }

         var6 = var5.length();
         if(this.q + var6 > this.r) {
            this.o();
            if(var6 > this.r) {
               this.j.write(var5);
               return;
            }
         }

         var5.getChars(0, var6, this.o, this.q);
         this.q += var6;
      }
   }

   private final void b(int var1, int var2) {
      int var4 = 0;
      int[] var10 = this.k;
      int var9 = Math.min(var10.length, this.l + 1);
      int var6 = 0;

      char var3;
      for(int var5 = 0; var5 < var1; var6 = this.a(this.o, var5, var1, var3, var4)) {
         int var8 = var4;

         int var7;
         while(true) {
            var3 = this.o[var5];
            if(var3 < var9) {
               var4 = var10[var3];
               if(var4 != 0) {
                  break;
               }
            } else {
               var4 = var8;
               if(var3 > var2) {
                  var4 = -1;
                  break;
               }
            }

            var7 = var5 + 1;
            var8 = var4;
            var5 = var7;
            if(var7 >= var1) {
               var5 = var7;
               break;
            }
         }

         var7 = var5 - var6;
         if(var7 > 0) {
            this.j.write(this.o, var6, var7);
            if(var5 >= var1) {
               break;
            }
         }

         ++var5;
      }

   }

   private final void b(long var1) {
      if(this.q + 23 >= this.r) {
         this.o();
      }

      char[] var4 = this.o;
      int var3 = this.q;
      this.q = var3 + 1;
      var4[var3] = 34;
      this.q = ij.a(var1, this.o, this.q);
      var4 = this.o;
      var3 = this.q;
      this.q = var3 + 1;
      var4[var3] = 34;
   }

   private final void c(int var1) {
      if(this.q + 13 >= this.r) {
         this.o();
      }

      char[] var3 = this.o;
      int var2 = this.q;
      this.q = var2 + 1;
      var3[var2] = 34;
      this.q = ij.a(var1, this.o, this.q);
      var3 = this.o;
      var1 = this.q;
      this.q = var1 + 1;
      var3[var1] = 34;
   }

   private final void c(Object var1) {
      if(this.q >= this.r) {
         this.o();
      }

      char[] var3 = this.o;
      int var2 = this.q;
      this.q = var2 + 1;
      var3[var2] = 34;
      this.c(var1.toString());
      if(this.q >= this.r) {
         this.o();
      }

      char[] var4 = this.o;
      var2 = this.q;
      this.q = var2 + 1;
      var4[var2] = 34;
   }

   private final void c(char[] var1, int var2, int var3) {
      if(this.m != null) {
         this.d(var1, var2, var3);
      } else {
         if(this.l != 0) {
            this.a(var1, var2, var3, this.l);
            return;
         }

         int var6 = var3 + var2;
         int[] var9 = this.k;
         int var7 = var9.length;

         while(var2 < var6) {
            var3 = var2;

            int var5;
            do {
               char var8 = var1[var3];
               if(var8 < var7) {
                  var5 = var3;
                  if(var9[var8] != 0) {
                     break;
                  }
               }

               var5 = var3 + 1;
               var3 = var5;
            } while(var5 < var6);

            var3 = var5 - var2;
            if(var3 < 32) {
               if(this.q + var3 > this.r) {
                  this.o();
               }

               if(var3 > 0) {
                  System.arraycopy(var1, var2, this.o, this.q, var3);
                  this.q += var3;
               }
            } else {
               this.o();
               this.j.write(var1, var2, var3);
            }

            if(var5 >= var6) {
               break;
            }

            var2 = var5 + 1;
            char var4 = var1[var5];
            this.b(var4, var9[var4]);
         }
      }

   }

   private void d(int var1) {
      var1 += this.q;
      int[] var5 = this.k;
      int var3 = var5.length;

      while(this.q < var1) {
         while(true) {
            char var4 = this.o[this.q];
            int var7;
            if(var4 < var3 && var5[var4] != 0) {
               var7 = this.q - this.p;
               if(var7 > 0) {
                  this.j.write(this.o, this.p, var7);
               }

               char[] var6 = this.o;
               var7 = this.q;
               this.q = var7 + 1;
               char var2 = var6[var7];
               this.a(var2, var5[var2]);
            } else {
               var7 = this.q + 1;
               this.q = var7;
               if(var7 >= var1) {
                  return;
               }
            }
         }
      }

   }

   private final void d(char[] var1, int var2, int var3) {
      int var9 = var3 + var2;
      int[] var11 = this.k;
      int var6;
      if(this.l <= 0) {
         var6 = '\uffff';
      } else {
         var6 = this.l;
      }

      int var10 = Math.min(var11.length, var6 + 1);
      id var12 = this.m;
      byte var5 = 0;
      var3 = var2;
      var2 = var5;

      while(var3 < var9) {
         int var14 = var3;
         int var8 = var2;

         char var4;
         int var7;
         while(true) {
            var4 = var1[var14];
            if(var4 < var10) {
               var7 = var11[var4];
               var2 = var7;
               if(var7 != 0) {
                  var2 = var7;
                  break;
               }
            } else {
               if(var4 > var6) {
                  var2 = -1;
                  break;
               }

               hp var13 = var12.a(var4);
               this.n = var13;
               var2 = var8;
               if(var13 != null) {
                  var2 = -2;
                  break;
               }
            }

            var7 = var14 + 1;
            var8 = var2;
            var14 = var7;
            if(var7 >= var9) {
               var14 = var7;
               break;
            }
         }

         var7 = var14 - var3;
         if(var7 < 32) {
            if(this.q + var7 > this.r) {
               this.o();
            }

            if(var7 > 0) {
               System.arraycopy(var1, var3, this.o, this.q, var7);
               this.q += var7;
            }
         } else {
            this.o();
            this.j.write(var1, var3, var7);
         }

         if(var14 >= var9) {
            break;
         }

         var3 = var14 + 1;
         this.b(var4, var2);
      }

   }

   private final void e(int var1) {
      int var3 = 0;
      int[] var7 = this.k;
      int var6 = var7.length;

      char var2;
      for(int var4 = 0; var3 < var1; var4 = this.a(this.o, var3, var1, var2, var7[var2])) {
         int var5;
         do {
            var2 = this.o[var3];
            if(var2 < var6) {
               var5 = var3;
               if(var7[var2] != 0) {
                  break;
               }
            }

            var5 = var3 + 1;
            var3 = var5;
         } while(var5 < var1);

         var3 = var5 - var4;
         if(var3 > 0) {
            this.j.write(this.o, var4, var3);
            if(var5 >= var1) {
               break;
            }
         }

         var3 = var5 + 1;
      }

   }

   private void f(int var1) {
      int var4 = this.q + var1;
      int[] var7 = this.k;
      int var3;
      if(this.l <= 0) {
         var3 = '\uffff';
      } else {
         var3 = this.l;
      }

      int var5 = Math.min(var7.length, var3 + 1);
      id var8 = this.m;

      while(this.q < var4) {
         char var2;
         while(true) {
            var2 = this.o[this.q];
            if(var2 < var5) {
               var1 = var7[var2];
               if(var1 != 0) {
                  break;
               }
            } else {
               if(var2 > var3) {
                  var1 = -1;
                  break;
               }

               hp var9 = var8.a(var2);
               this.n = var9;
               if(var9 != null) {
                  var1 = -2;
                  break;
               }
            }

            var1 = this.q + 1;
            this.q = var1;
            if(var1 >= var4) {
               return;
            }
         }

         int var6 = this.q - this.p;
         if(var6 > 0) {
            this.j.write(this.o, this.p, var6);
         }

         ++this.q;
         this.a(var2, var1);
      }

   }

   private final void g(int var1) {
      int var4 = 0;
      int[] var10 = this.k;
      int var5;
      if(this.l <= 0) {
         var5 = '\uffff';
      } else {
         var5 = this.l;
      }

      int var9 = Math.min(var10.length, this.l + 1);
      id var11 = this.m;
      int var6 = 0;

      char var2;
      for(int var3 = 0; var4 < var1; var6 = this.a(this.o, var4, var1, var2, var3)) {
         int var8 = var3;

         int var7;
         while(true) {
            var2 = this.o[var4];
            if(var2 < var9) {
               var3 = var10[var2];
               if(var3 != 0) {
                  break;
               }
            } else {
               if(var2 > var5) {
                  var3 = -1;
                  break;
               }

               hp var12 = var11.a(var2);
               this.n = var12;
               var3 = var8;
               if(var12 != null) {
                  var3 = -2;
                  break;
               }
            }

            var7 = var4 + 1;
            var8 = var3;
            var4 = var7;
            if(var7 >= var1) {
               var4 = var7;
               break;
            }
         }

         var7 = var4 - var6;
         if(var7 > 0) {
            this.j.write(this.o, var6, var7);
            if(var4 >= var1) {
               break;
            }
         }

         ++var4;
      }

   }

   private void j(String var1) {
      int var3 = this.r - this.q;
      var1.getChars(0, var3, this.o, this.q);
      this.q += var3;
      this.o();

      int var2;
      int var4;
      for(var2 = var1.length() - var3; var2 > this.r; var2 -= var4) {
         var4 = this.r;
         var1.getChars(var3, var3 + var4, this.o, 0);
         this.p = 0;
         this.q = var4;
         this.o();
         var3 += var4;
      }

      var1.getChars(var3, var3 + var2, this.o, 0);
      this.p = 0;
      this.q = var2;
   }

   private void k(String var1) {
      int var2 = var1.length();
      if(var2 > this.r) {
         this.l(var1);
      } else {
         if(this.q + var2 > this.r) {
            this.o();
         }

         var1.getChars(0, var2, this.o, this.q);
         if(this.m != null) {
            this.f(var2);
         } else if(this.l != 0) {
            this.a(var2, this.l);
         } else {
            this.d(var2);
         }
      }
   }

   private void l(String var1) {
      this.o();
      int var5 = var1.length();
      int var2 = 0;

      int var3;
      do {
         int var4 = this.r;
         var3 = var4;
         if(var2 + var4 > var5) {
            var3 = var5 - var2;
         }

         var1.getChars(var2, var2 + var3, this.o, 0);
         if(this.m != null) {
            this.g(var3);
         } else if(this.l != 0) {
            this.b(var3, this.l);
         } else {
            this.e(var3);
         }

         var3 += var2;
         var2 = var3;
      } while(var3 < var5);

   }

   private final void p() {
      if(this.q + 4 >= this.r) {
         this.o();
      }

      int var1 = this.q;
      char[] var2 = this.o;
      var2[var1] = 110;
      ++var1;
      var2[var1] = 117;
      ++var1;
      var2[var1] = 108;
      ++var1;
      var2[var1] = 108;
      this.q = var1 + 1;
   }

   private char[] q() {
      char[] var1 = new char[14];
      var1[0] = 92;
      var1[2] = 92;
      var1[3] = 117;
      var1[4] = 48;
      var1[5] = 48;
      var1[8] = 92;
      var1[9] = 117;
      this.s = var1;
      return var1;
   }

   public final hf a(int var1) {
      int var2 = var1;
      if(var1 < 0) {
         var2 = 0;
      }

      this.l = var2;
      return this;
   }

   public final hf a(id var1) {
      this.m = var1;
      if(var1 == null) {
         this.k = h;
         return this;
      } else {
         this.k = var1.a();
         return this;
      }
   }

   public final void a(char var1) {
      if(this.q >= this.r) {
         this.o();
      }

      char[] var3 = this.o;
      int var2 = this.q;
      this.q = var2 + 1;
      var3[var2] = var1;
   }

   public final void a(double var1) {
      if(!this.d && (!Double.isNaN(var1) && !Double.isInfinite(var1) || !this.a((hf$a)hf$a.d))) {
         this.h("write number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   public final void a(float var1) {
      if(!this.d && (!Float.isNaN(var1) && !Float.isInfinite(var1) || !this.a((hf$a)hf$a.d))) {
         this.h("write number");
         this.c(String.valueOf(var1));
      } else {
         this.b(String.valueOf(var1));
      }
   }

   public final void a(long var1) {
      this.h("write number");
      if(this.d) {
         this.b(var1);
      } else {
         if(this.q + 21 >= this.r) {
            this.o();
         }

         this.q = ij.a(var1, this.o, this.q);
      }
   }

   public final void a(ha var1, byte[] var2, int var3, int var4) {
      this.h("write binary value");
      if(this.q >= this.r) {
         this.o();
      }

      char[] var6 = this.o;
      int var5 = this.q;
      this.q = var5 + 1;
      var6[var5] = 34;
      this.b(var1, var2, var3, var3 + var4);
      if(this.q >= this.r) {
         this.o();
      }

      char[] var7 = this.o;
      var3 = this.q;
      this.q = var3 + 1;
      var7[var3] = 34;
   }

   public final void a(hp var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1.a());
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(var2 != 1) {
         var3 = false;
      }

      this.a(var1, var3);
   }

   public final void a(hp var1, boolean var2) {
      if(this.a != null) {
         this.b(var1, var2);
      } else {
         if(this.q + 1 >= this.r) {
            this.o();
         }

         int var3;
         char[] var4;
         if(var2) {
            var4 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var4[var3] = 44;
         }

         char[] var5 = var1.b();
         if(!this.a((hf$a)hf$a.c)) {
            this.b(var5, 0, var5.length);
         } else {
            var4 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var4[var3] = 34;
            var3 = var5.length;
            if(this.q + var3 + 1 >= this.r) {
               this.b(var5, 0, var3);
               if(this.q >= this.r) {
                  this.o();
               }

               var5 = this.o;
               var3 = this.q;
               this.q = var3 + 1;
               var5[var3] = 34;
            } else {
               System.arraycopy(var5, 0, this.o, this.q, var3);
               this.q += var3;
               var5 = this.o;
               var3 = this.q;
               this.q = var3 + 1;
               var5[var3] = 34;
            }
         }
      }
   }

   public final void a(im var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1.a());
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(var2 != 1) {
         var3 = false;
      }

      this.a(var1, var3);
   }

   public final void a(String var1) {
      boolean var3 = true;
      int var2 = this.e.a(var1);
      if(var2 == 4) {
         this.i("Can not write a field name, expecting a value");
      }

      if(var2 != 1) {
         var3 = false;
      }

      this.b(var1, var3);
   }

   public final void a(String var1, String var2) {
      this.a(var1);
      this.b(var2);
   }

   public final void a(BigDecimal var1) {
      this.h("write number");
      if(var1 == null) {
         this.p();
      } else if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1.toString());
      }
   }

   public final void a(BigInteger var1) {
      this.h("write number");
      if(var1 == null) {
         this.p();
      } else if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1.toString());
      }
   }

   public final void a(boolean var1) {
      this.h("write boolean value");
      if(this.q + 5 >= this.r) {
         this.o();
      }

      int var2 = this.q;
      char[] var3 = this.o;
      if(var1) {
         var3[var2] = 116;
         ++var2;
         var3[var2] = 114;
         ++var2;
         var3[var2] = 117;
         ++var2;
         var3[var2] = 101;
      } else {
         var3[var2] = 102;
         ++var2;
         var3[var2] = 97;
         ++var2;
         var3[var2] = 108;
         ++var2;
         var3[var2] = 115;
         ++var2;
         var3[var2] = 101;
      }

      this.q = var2 + 1;
   }

   public final void a(char[] var1, int var2, int var3) {
      this.h("write text value");
      if(this.q >= this.r) {
         this.o();
      }

      char[] var5 = this.o;
      int var4 = this.q;
      this.q = var4 + 1;
      var5[var4] = 34;
      this.c(var1, var2, var3);
      if(this.q >= this.r) {
         this.o();
      }

      var1 = this.o;
      var2 = this.q;
      this.q = var2 + 1;
      var1[var2] = 34;
   }

   public final void b() {
      this.h("start an array");
      this.e = this.e.h();
      if(this.a != null) {
         this.a.e(this);
      } else {
         if(this.q >= this.r) {
            this.o();
         }

         char[] var2 = this.o;
         int var1 = this.q;
         this.q = var1 + 1;
         var2[var1] = 91;
      }
   }

   public final void b(int var1) {
      this.h("write number");
      if(this.d) {
         this.c(var1);
      } else {
         if(this.q + 11 >= this.r) {
            this.o();
         }

         this.q = ij.a(var1, this.o, this.q);
      }
   }

   protected final void b(ha var1, byte[] var2, int var3, int var4) {
      int var8 = this.r - 6;
      int var6 = var1.c() >> 2;
      int var5 = var3;
      var3 = var6;

      while(var5 <= var4 - 3) {
         if(this.q > var8) {
            this.o();
         }

         var6 = var5 + 1;
         byte var11 = var2[var5];
         int var7 = var6 + 1;
         byte var9 = var2[var6];
         var6 = var7 + 1;
         this.q = var1.a((var9 & 255 | var11 << 8) << 8 | var2[var7] & 255, this.o, this.q);
         var7 = var3 - 1;
         var3 = var7;
         var5 = var6;
         if(var7 <= 0) {
            char[] var10 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var10[var3] = 92;
            var10 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var10[var3] = 110;
            var3 = var1.c() >> 2;
            var5 = var6;
         }
      }

      var6 = var4 - var5;
      if(var6 > 0) {
         if(this.q > var8) {
            this.o();
         }

         var4 = var2[var5] << 16;
         var3 = var4;
         if(var6 == 2) {
            var3 = var4 | (var2[var5 + 1] & 255) << 8;
         }

         this.q = var1.a(var3, var6, this.o, this.q);
      }

   }

   public final void b(hp var1) {
      this.h("write text value");
      if(this.q >= this.r) {
         this.o();
      }

      char[] var3 = this.o;
      int var2 = this.q;
      this.q = var2 + 1;
      var3[var2] = 34;
      char[] var4 = var1.b();
      var2 = var4.length;
      if(var2 < 32) {
         if(var2 > this.r - this.q) {
            this.o();
         }

         System.arraycopy(var4, 0, this.o, this.q, var2);
         this.q += var2;
      } else {
         this.o();
         this.j.write(var4, 0, var2);
      }

      if(this.q >= this.r) {
         this.o();
      }

      var4 = this.o;
      var2 = this.q;
      this.q = var2 + 1;
      var4[var2] = 34;
   }

   protected final void b(hp var1, boolean var2) {
      if(var2) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      char[] var5 = var1.b();
      if(this.a((hf$a)hf$a.c)) {
         if(this.q >= this.r) {
            this.o();
         }

         char[] var4 = this.o;
         int var3 = this.q;
         this.q = var3 + 1;
         var4[var3] = 34;
         this.b(var5, 0, var5.length);
         if(this.q >= this.r) {
            this.o();
         }

         var5 = this.o;
         var3 = this.q;
         this.q = var3 + 1;
         var5[var3] = 34;
      } else {
         this.b(var5, 0, var5.length);
      }
   }

   public final void b(String var1) {
      this.h("write text value");
      if(var1 == null) {
         this.p();
      } else {
         if(this.q >= this.r) {
            this.o();
         }

         char[] var3 = this.o;
         int var2 = this.q;
         this.q = var2 + 1;
         var3[var2] = 34;
         this.k(var1);
         if(this.q >= this.r) {
            this.o();
         }

         char[] var4 = this.o;
         var2 = this.q;
         this.q = var2 + 1;
         var4[var2] = 34;
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
      if(this.a != null) {
         this.c(var1, var2);
      } else {
         if(this.q + 1 >= this.r) {
            this.o();
         }

         int var3;
         char[] var4;
         if(var2) {
            var4 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var4[var3] = 44;
         }

         if(!this.a((hf$a)hf$a.c)) {
            this.k(var1);
         } else {
            var4 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var4[var3] = 34;
            this.k(var1);
            if(this.q >= this.r) {
               this.o();
            }

            char[] var5 = this.o;
            var3 = this.q;
            this.q = var3 + 1;
            var5[var3] = 34;
         }
      }
   }

   public final void b(char[] var1, int var2, int var3) {
      if(var3 < 32) {
         if(var3 > this.r - this.q) {
            this.o();
         }

         System.arraycopy(var1, var2, this.o, this.q, var3);
         this.q += var3;
      } else {
         this.o();
         this.j.write(var1, var2, var3);
      }
   }

   public final void c() {
      if(!this.e.a()) {
         this.i("Current context not an ARRAY but " + this.e.d());
      }

      if(this.a != null) {
         this.a.b(this, this.e.e());
      } else {
         if(this.q >= this.r) {
            this.o();
         }

         char[] var2 = this.o;
         int var1 = this.q;
         this.q = var1 + 1;
         var2[var1] = 93;
      }

      this.e = this.e.j();
   }

   public final void c(String var1) {
      int var4 = var1.length();
      int var3 = this.r - this.q;
      int var2 = var3;
      if(var3 == 0) {
         this.o();
         var2 = this.r - this.q;
      }

      if(var2 >= var4) {
         var1.getChars(0, var4, this.o, this.q);
         this.q += var4;
      } else {
         this.j(var1);
      }
   }

   protected final void c(String var1, boolean var2) {
      if(var2) {
         this.a.c(this);
      } else {
         this.a.h(this);
      }

      if(this.a((hf$a)hf$a.c)) {
         if(this.q >= this.r) {
            this.o();
         }

         char[] var4 = this.o;
         int var3 = this.q;
         this.q = var3 + 1;
         var4[var3] = 34;
         this.k(var1);
         if(this.q >= this.r) {
            this.o();
         }

         char[] var5 = this.o;
         var3 = this.q;
         this.q = var3 + 1;
         var5[var3] = 34;
      } else {
         this.k(var1);
      }
   }

   public final void close() {
      super.close();
      if(this.o != null && this.a((hf$a)hf$a.b)) {
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
         if(this.q >= this.r) {
            this.o();
         }

         char[] var2 = this.o;
         int var1 = this.q;
         this.q = var1 + 1;
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
         if(this.q >= this.r) {
            this.o();
         }

         char[] var2 = this.o;
         int var1 = this.q;
         this.q = var1 + 1;
         var2[var1] = 125;
      }
   }

   public final void e(String var1) {
      this.h("write number");
      if(this.d) {
         this.c((Object)var1);
      } else {
         this.c(var1);
      }
   }

   public final void f() {
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

         if(this.q >= this.r) {
            this.o();
         }

         this.o[this.q] = (char)var2;
         ++this.q;
      } else {
         this.b(var1, var3);
      }
   }

   protected final void n() {
      char[] var1 = this.o;
      if(var1 != null) {
         this.o = null;
         this.i.b(var1);
      }

   }

   protected final void o() {
      int var1 = this.q - this.p;
      if(var1 > 0) {
         int var2 = this.p;
         this.p = 0;
         this.q = 0;
         this.j.write(this.o, var2, var1);
      }

   }
}
