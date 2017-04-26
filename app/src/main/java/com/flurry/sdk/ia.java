package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.hu;
import com.flurry.sdk.ie;
import com.flurry.sdk.sa;
import com.flurry.sdk.sc;
import com.flurry.sdk.sj;
import com.flurry.sdk.sk;
import java.io.IOException;
import java.io.InputStream;

public final class ia extends hu {
   private static final int[] P = sk.b();
   private static final int[] Q = sk.a();
   protected hn I;
   protected final sa J;
   protected int[] K = new int[16];
   protected boolean L = false;
   protected InputStream M;
   protected byte[] N;
   protected boolean O;
   private int R;

   public ia(ie var1, int var2, InputStream var3, hn var4, sa var5, byte[] var6, int var7, int var8, boolean var9) {
      super(var1, var2);
      this.M = var3;
      this.I = var4;
      this.J = var5;
      this.N = var6;
      this.f = var7;
      this.g = var8;
      this.O = var9;
      if(!hj$a.j.a(var2)) {
         this.U();
      }

   }

   private final hm a(char[] var1, int var2, int var3, boolean var4, int var5) {
      byte var6 = 0;
      boolean var7 = false;
      boolean var9 = false;
      int var8;
      byte[] var12;
      int var14;
      boolean var15;
      int var17;
      char[] var19;
      if(var3 == 46) {
         var8 = var2 + 1;
         var1[var2] = (char)var3;
         var17 = var3;
         var2 = var8;
         var3 = var6;

         while(true) {
            if(this.f >= this.g && !this.E()) {
               var15 = true;
               break;
            }

            var12 = this.N;
            var14 = this.f;
            this.f = var14 + 1;
            var8 = var12[var14] & 255;
            var15 = var9;
            var17 = var8;
            if(var8 < 48) {
               break;
            }

            var15 = var9;
            var17 = var8;
            if(var8 > 57) {
               break;
            }

            ++var3;
            if(var2 >= var1.length) {
               var1 = this.p.m();
               var2 = 0;
            }

            var14 = var2 + 1;
            var1[var2] = (char)var8;
            var2 = var14;
            var17 = var8;
         }

         if(var3 == 0) {
            this.a(var17, "Decimal point not followed by a digit");
         }

         var8 = var3;
         var3 = var17;
         var19 = var1;
      } else {
         var8 = 0;
         var19 = var1;
         var15 = var7;
      }

      boolean var10;
      int var11;
      int var18;
      if(var3 != 101 && var3 != 69) {
         var18 = 0;
         var10 = var15;
         var11 = var2;
      } else {
         var17 = var2;
         var1 = var19;
         if(var2 >= var19.length) {
            var1 = this.p.m();
            var17 = 0;
         }

         var2 = var17 + 1;
         var1[var17] = (char)var3;
         if(this.f >= this.g) {
            this.D();
         }

         var12 = this.N;
         var3 = this.f;
         this.f = var3 + 1;
         var17 = var12[var3] & 255;
         if(var17 != 45 && var17 != 43) {
            var3 = 0;
         } else {
            if(var2 >= var1.length) {
               var1 = this.p.m();
               var2 = 0;
            }

            var1[var2] = (char)var17;
            if(this.f >= this.g) {
               this.D();
            }

            var12 = this.N;
            var3 = this.f;
            this.f = var3 + 1;
            var17 = var12[var3] & 255;
            ++var2;
            var3 = 0;
         }

         boolean var16;
         label80: {
            while(var17 <= 57 && var17 >= 48) {
               ++var3;
               var18 = var2;
               var19 = var1;
               if(var2 >= var1.length) {
                  var19 = this.p.m();
                  var18 = 0;
               }

               var2 = var18 + 1;
               var19[var18] = (char)var17;
               if(this.f >= this.g && !this.E()) {
                  var16 = true;
                  var14 = var2;
                  var2 = var3;
                  break label80;
               }

               byte[] var13 = this.N;
               var17 = this.f;
               this.f = var17 + 1;
               var17 = var13[var17] & 255;
               var1 = var19;
            }

            var18 = var2;
            var2 = var3;
            var16 = var15;
            var14 = var18;
         }

         var18 = var2;
         var10 = var16;
         var11 = var14;
         if(var2 == 0) {
            this.a(var17, "Exponent indicator not followed by a digit");
            var11 = var14;
            var10 = var16;
            var18 = var2;
         }
      }

      if(!var10) {
         --this.f;
      }

      this.p.a(var11);
      return this.b(var4, var5, var8, var18);
   }

   private final hm a(char[] var1, int var2, boolean var3, int var4) {
      while(this.f < this.g || this.E()) {
         byte[] var7 = this.N;
         int var5 = this.f;
         this.f = var5 + 1;
         int var6 = var7[var5] & 255;
         if(var6 > 57 || var6 < 48) {
            if(var6 != 46 && var6 != 101 && var6 != 69) {
               --this.f;
               this.p.a(var2);
               return this.a(var3, var4);
            }

            return this.a(var1, var2, var6, var3, var4);
         }

         if(var2 >= var1.length) {
            var1 = this.p.m();
            var2 = 0;
         }

         var5 = var2 + 1;
         var1[var2] = (char)var6;
         ++var4;
         var2 = var5;
      }

      this.p.a(var2);
      return this.a(var3, var4);
   }

   private final sc a(int var1, int var2, int var3) {
      return this.a(this.K, 0, var1, var2, var3);
   }

   private final sc a(int var1, int var2, int var3, int var4) {
      this.K[0] = var1;
      return this.a(this.K, 1, var2, var3, var4);
   }

   private final sc a(int[] var1, int var2, int var3) {
      int var11 = (var2 << 2) - 4 + var3;
      int var10;
      if(var3 < 4) {
         var10 = var1[var2 - 1];
         var1[var2 - 1] = var10 << (4 - var3 << 3);
      } else {
         var10 = 0;
      }

      char[] var12 = this.p.k();
      int var7 = 0;

      char[] var13;
      for(int var4 = 0; var4 < var11; var12 = var13) {
         int var5;
         int var6;
         label66: {
            var5 = var1[var4 >> 2] >> (3 - (var4 & 3) << 3) & 255;
            var6 = var4 + 1;
            int var9 = var5;
            int var8 = var6;
            if(var5 > 127) {
               byte var14;
               if((var5 & 224) == 192) {
                  var4 = var5 & 31;
                  var14 = 1;
               } else if((var5 & 240) == 224) {
                  var4 = var5 & 15;
                  var14 = 2;
               } else if((var5 & 248) == 240) {
                  var4 = var5 & 7;
                  var14 = 3;
               } else {
                  this.k(var5);
                  var4 = 1;
                  var14 = 1;
               }

               if(var6 + var14 > var11) {
                  this.c(" in field name");
               }

               var9 = var1[var6 >> 2] >> (3 - (var6 & 3) << 3);
               var8 = var6 + 1;
               if((var9 & 192) != 128) {
                  this.l(var9);
               }

               var9 = var4 << 6 | var9 & 63;
               var6 = var9;
               var4 = var8;
               if(var14 > 1) {
                  var4 = var1[var8 >> 2] >> (3 - (var8 & 3) << 3);
                  ++var8;
                  if((var4 & 192) != 128) {
                     this.l(var4);
                  }

                  var9 = var9 << 6 | var4 & 63;
                  var6 = var9;
                  var4 = var8;
                  if(var14 > 2) {
                     var6 = var1[var8 >> 2] >> (3 - (var8 & 3) << 3);
                     var4 = var8 + 1;
                     if((var6 & 192) != 128) {
                        this.l(var6 & 255);
                     }

                     var6 = var9 << 6 | var6 & 63;
                  }
               }

               var9 = var6;
               var8 = var4;
               if(var14 > 2) {
                  var5 = var6 - 65536;
                  var13 = var12;
                  if(var7 >= var12.length) {
                     var13 = this.p.n();
                  }

                  var13[var7] = (char)('\ud800' + (var5 >> 10));
                  var6 = var7 + 1;
                  var12 = var13;
                  var5 = var5 & 1023 | '\udc00';
                  break label66;
               }
            }

            var5 = var9;
            var4 = var8;
            var6 = var7;
         }

         var13 = var12;
         if(var6 >= var12.length) {
            var13 = this.p.n();
         }

         var7 = var6 + 1;
         var13[var6] = (char)var5;
      }

      String var15 = new String(var12, 0, var7);
      if(var3 < 4) {
         var1[var2 - 1] = var10;
      }

      return this.J.a(var15, var1, var2);
   }

   private final sc a(int[] var1, int var2, int var3, int var4) {
      int[] var6 = var1;
      if(var2 >= var1.length) {
         var6 = a(var1, var1.length);
         this.K = var6;
      }

      int var5 = var2 + 1;
      var6[var2] = var3;
      sc var7 = this.J.a(var6, var5);
      sc var8 = var7;
      if(var7 == null) {
         var8 = this.a(var6, var5, var4);
      }

      return var8;
   }

   private final void a(char[] var1, int var2) {
      int[] var7 = P;
      byte[] var8 = this.N;
      char[] var6 = var1;

      while(true) {
         label52:
         while(true) {
            int var3 = this.f;
            int var4 = var3;
            if(var3 >= this.g) {
               this.D();
               var4 = this.f;
            }

            var1 = var6;
            var3 = var2;
            if(var2 >= var6.length) {
               var1 = this.p.m();
               var3 = 0;
            }

            for(int var5 = Math.min(this.g, var1.length - var3 + var4); var4 < var5; ++var3) {
               var2 = var4 + 1;
               var4 = var8[var4] & 255;
               if(var7[var4] != 0) {
                  this.f = var2;
                  if(var4 == 34) {
                     this.p.a(var3);
                     return;
                  }

                  switch(var7[var4]) {
                  case 1:
                     var2 = this.Q();
                     break;
                  case 2:
                     var2 = this.n(var4);
                     break;
                  case 3:
                     if(this.g - this.f >= 2) {
                        var2 = this.p(var4);
                     } else {
                        var2 = this.o(var4);
                     }
                     break;
                  case 4:
                     var5 = this.q(var4);
                     var4 = var3 + 1;
                     var1[var3] = (char)('\ud800' | var5 >> 10);
                     var2 = var4;
                     var6 = var1;
                     if(var4 >= var1.length) {
                        var6 = this.p.m();
                        var2 = 0;
                     }

                     var3 = var2;
                     var2 = var5 & 1023 | '\udc00';
                     var1 = var6;
                     break;
                  default:
                     if(var4 < 32) {
                        this.c(var4, "string value");
                        var2 = var4;
                     } else {
                        this.j(var4);
                        var2 = var4;
                     }
                  }

                  if(var3 >= var1.length) {
                     var1 = this.p.m();
                     var3 = 0;
                  }

                  var4 = var3 + 1;
                  var1[var3] = (char)var2;
                  var6 = var1;
                  var2 = var4;
                  continue label52;
               }

               var1[var3] = (char)var4;
               var4 = var2;
            }

            this.f = var4;
            var6 = var1;
            var2 = var3;
         }
      }
   }

   public static int[] a(int[] var0, int var1) {
      if(var0 == null) {
         return new int[var1];
      } else {
         int var2 = var0.length;
         int[] var3 = new int[var2 + var1];
         System.arraycopy(var0, 0, var3, 0, var2);
         return var3;
      }
   }

   private final hm ac() {
      this.r = false;
      hm var1 = this.o;
      this.o = null;
      if(var1 == hm.d) {
         this.n = this.n.b(this.l, this.m);
      } else if(var1 == hm.b) {
         this.n = this.n.c(this.l, this.m);
      }

      this.b = var1;
      return var1;
   }

   private final int ad() {
      int var1;
      if(this.f >= this.g && !this.E()) {
         var1 = 48;
         return var1;
      } else {
         int var2 = this.N[this.f] & 255;
         if(var2 >= 48 && var2 <= 57) {
            if(!this.a((hj$a)hj$a.g)) {
               this.b("Leading zeroes not allowed");
            }

            ++this.f;
            var1 = var2;
            if(var2 != 48) {
               return var1;
            } else {
               var1 = var2;

               do {
                  if(this.f >= this.g && !this.E()) {
                     return var1;
                  }

                  var2 = this.N[this.f] & 255;
                  if(var2 < 48 || var2 > 57) {
                     return 48;
                  }

                  ++this.f;
                  var1 = var2;
               } while(var2 == 48);

               return var2;
            }
         } else {
            return 48;
         }
      }
   }

   private final int ae() {
      while(this.f < this.g || this.E()) {
         byte[] var2 = this.N;
         int var1 = this.f;
         this.f = var1 + 1;
         var1 = var2[var1] & 255;
         if(var1 > 32) {
            if(var1 != 47) {
               return var1;
            }

            this.ag();
         } else if(var1 != 32) {
            if(var1 == 10) {
               this.ab();
            } else if(var1 == 13) {
               this.aa();
            } else if(var1 != 9) {
               this.b(var1);
            }
         }
      }

      throw this.a((String)("Unexpected end-of-input within/between " + this.n.d() + " entries"));
   }

   private final int af() {
      while(this.f < this.g || this.E()) {
         byte[] var2 = this.N;
         int var1 = this.f;
         this.f = var1 + 1;
         var1 = var2[var1] & 255;
         if(var1 > 32) {
            if(var1 != 47) {
               return var1;
            }

            this.ag();
         } else if(var1 != 32) {
            if(var1 == 10) {
               this.ab();
            } else if(var1 == 13) {
               this.aa();
            } else if(var1 != 9) {
               this.b(var1);
            }
         }
      }

      this.H();
      return -1;
   }

   private final void ag() {
      if(!this.a((hj$a)hj$a.b)) {
         this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature \'ALLOW_COMMENTS\' not enabled for parser)");
      }

      if(this.f >= this.g && !this.E()) {
         this.c(" in a comment");
      }

      byte[] var2 = this.N;
      int var1 = this.f;
      this.f = var1 + 1;
      var1 = var2[var1] & 255;
      if(var1 == 47) {
         this.ai();
      } else if(var1 == 42) {
         this.ah();
      } else {
         this.b(var1, "was expecting either \'*\' or \'/\' for a comment");
      }
   }

   private final void ah() {
      int[] var3 = sk.e();

      while(this.f < this.g || this.E()) {
         byte[] var4 = this.N;
         int var1 = this.f;
         this.f = var1 + 1;
         var1 = var4[var1] & 255;
         int var2 = var3[var1];
         if(var2 != 0) {
            switch(var2) {
            case 2:
               this.r(var1);
               break;
            case 3:
               this.s(var1);
               break;
            case 4:
               this.t(var1);
               break;
            case 10:
               this.ab();
               break;
            case 13:
               this.aa();
               break;
            case 42:
               if(this.N[this.f] == 47) {
                  ++this.f;
                  return;
               }
               break;
            default:
               this.j(var1);
            }
         }
      }

      this.c(" in a comment");
   }

   private final void ai() {
      int[] var3 = sk.e();

      while(this.f < this.g || this.E()) {
         byte[] var4 = this.N;
         int var1 = this.f;
         this.f = var1 + 1;
         var1 = var4[var1] & 255;
         int var2 = var3[var1];
         if(var2 != 0) {
            switch(var2) {
            case 2:
               this.r(var1);
               break;
            case 3:
               this.s(var1);
               break;
            case 4:
               this.t(var1);
               break;
            case 10:
               this.ab();
               return;
            case 13:
               this.aa();
               return;
            case 42:
               break;
            default:
               this.j(var1);
            }
         }
      }

   }

   private int aj() {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var2 = this.N;
      int var1 = this.f;
      this.f = var1 + 1;
      return var2[var1] & 255;
   }

   private final sc b(int var1, int var2) {
      sc var3 = this.J.a(var1);
      if(var3 != null) {
         return var3;
      } else {
         this.K[0] = var1;
         return this.a(this.K, 1, var2);
      }
   }

   private final sc b(int var1, int var2, int var3) {
      sc var4 = this.J.a(var1, var2);
      if(var4 != null) {
         return var4;
      } else {
         this.K[0] = var1;
         this.K[1] = var2;
         return this.a(this.K, 2, var3);
      }
   }

   private final hm m(int var1) {
      hm var2;
      if(var1 == 34) {
         this.L = true;
         var2 = hm.h;
         this.b = var2;
         return var2;
      } else {
         switch(var1) {
         case 45:
         case 48:
         case 49:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         case 56:
         case 57:
            var2 = this.d(var1);
            this.b = var2;
            return var2;
         case 91:
            this.n = this.n.b(this.l, this.m);
            var2 = hm.d;
            this.b = var2;
            return var2;
         case 93:
         case 125:
            this.b(var1, "expected a value");
         case 116:
            this.a((String)"true", 1);
            var2 = hm.k;
            this.b = var2;
            return var2;
         case 102:
            this.a((String)"false", 1);
            var2 = hm.l;
            this.b = var2;
            return var2;
         case 110:
            this.a((String)"null", 1);
            var2 = hm.m;
            this.b = var2;
            return var2;
         case 123:
            this.n = this.n.c(this.l, this.m);
            var2 = hm.b;
            this.b = var2;
            return var2;
         default:
            var2 = this.h(var1);
            this.b = var2;
            return var2;
         }
      }
   }

   private final int n(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var3 = this.N;
      int var2 = this.f;
      this.f = var2 + 1;
      byte var4 = var3[var2];
      if((var4 & 192) != 128) {
         this.a(var4 & 255, this.f);
      }

      return var4 & 63 | (var1 & 31) << 6;
   }

   private final int o(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var4 = this.N;
      int var2 = this.f;
      this.f = var2 + 1;
      byte var5 = var4[var2];
      if((var5 & 192) != 128) {
         this.a(var5 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var4 = this.N;
      int var3 = this.f;
      this.f = var3 + 1;
      byte var6 = var4[var3];
      if((var6 & 192) != 128) {
         this.a(var6 & 255, this.f);
      }

      return ((var1 & 15) << 6 | var5 & 63) << 6 | var6 & 63;
   }

   private final int p(int var1) {
      byte[] var4 = this.N;
      int var2 = this.f;
      this.f = var2 + 1;
      byte var5 = var4[var2];
      if((var5 & 192) != 128) {
         this.a(var5 & 255, this.f);
      }

      var4 = this.N;
      int var3 = this.f;
      this.f = var3 + 1;
      byte var6 = var4[var3];
      if((var6 & 192) != 128) {
         this.a(var6 & 255, this.f);
      }

      return ((var1 & 15) << 6 | var5 & 63) << 6 | var6 & 63;
   }

   private final int q(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var5 = this.N;
      int var2 = this.f;
      this.f = var2 + 1;
      byte var6 = var5[var2];
      if((var6 & 192) != 128) {
         this.a(var6 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var5 = this.N;
      int var3 = this.f;
      this.f = var3 + 1;
      byte var7 = var5[var3];
      if((var7 & 192) != 128) {
         this.a(var7 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var5 = this.N;
      int var4 = this.f;
      this.f = var4 + 1;
      byte var8 = var5[var4];
      if((var8 & 192) != 128) {
         this.a(var8 & 255, this.f);
      }

      return (((var6 & 63 | (var1 & 7) << 6) << 6 | var7 & 63) << 6 | var8 & 63) - 65536;
   }

   private final void r(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      byte var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

   }

   private final void s(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      byte var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

   }

   private final void t(int var1) {
      if(this.f >= this.g) {
         this.D();
      }

      byte[] var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      byte var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

      if(this.f >= this.g) {
         this.D();
      }

      var2 = this.N;
      var1 = this.f;
      this.f = var1 + 1;
      var3 = var2[var1];
      if((var3 & 192) != 128) {
         this.a(var3 & 255, this.f);
      }

   }

   protected final boolean E() {
      boolean var3 = false;
      this.h += (long)this.g;
      this.j -= this.g;
      boolean var2 = var3;
      if(this.M != null) {
         int var1 = this.M.read(this.N, 0, this.N.length);
         if(var1 > 0) {
            this.f = 0;
            this.g = var1;
            var2 = true;
         } else {
            this.F();
            var2 = var3;
            if(var1 == 0) {
               throw new IOException("InputStream.read() returned 0 characters when trying to read " + this.N.length + " bytes");
            }
         }
      }

      return var2;
   }

   protected final void F() {
      if(this.M != null) {
         if(this.d.c() || this.a((hj$a)hj$a.a)) {
            this.M.close();
         }

         this.M = null;
      }

   }

   protected final void G() {
      super.G();
      if(this.O) {
         byte[] var1 = this.N;
         if(var1 != null) {
            this.N = null;
            this.d.a(var1);
         }
      }

   }

   protected final char Q() {
      int var1 = 0;
      if(this.f >= this.g && !this.E()) {
         this.c(" in character escape sequence");
      }

      byte[] var5 = this.N;
      int var2 = this.f;
      this.f = var2 + 1;
      byte var6 = var5[var2];
      switch(var6) {
      case 34:
      case 47:
      case 92:
         return (char)var6;
      case 98:
         return '\b';
      case 102:
         return '\f';
      case 110:
         return '\n';
      case 114:
         return '\r';
      case 116:
         return '\t';
      case 117:
         for(var2 = 0; var1 < 4; ++var1) {
            if(this.f >= this.g && !this.E()) {
               this.c(" in character escape sequence");
            }

            var5 = this.N;
            int var3 = this.f;
            this.f = var3 + 1;
            byte var7 = var5[var3];
            int var4 = sk.a(var7);
            if(var4 < 0) {
               this.b(var7, "expected a hex-digit for character escape sequence");
            }

            var2 = var2 << 4 | var4;
         }

         return (char)var2;
      default:
         return this.a((char)this.i(var6));
      }
   }

   protected final sc V() {
      if(this.f >= this.g && !this.E()) {
         this.c(": was expecting closing \'\"\' for name");
      }

      byte[] var2 = this.N;
      int var1 = this.f;
      this.f = var1 + 1;
      var1 = var2[var1] & 255;
      return var1 == 34?sa.e():this.a(this.K, 0, 0, var1, 0);
   }

   protected final sc W() {
      if(this.f >= this.g && !this.E()) {
         this.c(": was expecting closing \'\'\' for name");
      }

      byte[] var6 = this.N;
      int var1 = this.f;
      this.f = var1 + 1;
      int var4 = var6[var1] & 255;
      if(var4 == 39) {
         return sa.e();
      } else {
         int[] var9 = this.K;
         int[] var8 = Q;
         int var2 = 0;
         int var3 = 0;

         int var5;
         int[] var7;
         for(var1 = 0; var4 != 39; var4 = var5) {
            label84: {
               var5 = var4;
               if(var4 != 34) {
                  var5 = var4;
                  if(var8[var4] != 0) {
                     if(var4 != 92) {
                        this.c(var4, "name");
                     } else {
                        var4 = this.Q();
                     }

                     var5 = var4;
                     if(var4 > 127) {
                        if(var2 >= 4) {
                           var7 = var9;
                           if(var1 >= var9.length) {
                              var7 = a(var9, var9.length);
                              this.K = var7;
                           }

                           var7[var1] = var3;
                           var2 = 0;
                           ++var1;
                           var3 = 0;
                           var9 = var7;
                        }

                        if(var4 < 2048) {
                           var3 = var3 << 8 | var4 >> 6 | 192;
                           ++var2;
                        } else {
                           var3 = var3 << 8 | var4 >> 12 | 224;
                           ++var2;
                           if(var2 >= 4) {
                              var7 = var9;
                              if(var1 >= var9.length) {
                                 var7 = a(var9, var9.length);
                                 this.K = var7;
                              }

                              var7[var1] = var3;
                              ++var1;
                              var9 = var7;
                              var2 = 0;
                              var3 = 0;
                           }

                           var3 = var3 << 8 | var4 >> 6 & 63 | 128;
                           ++var2;
                        }

                        var5 = var3;
                        var3 = var2;
                        var2 = var4 & 63 | 128;
                        var4 = var3;
                        break label84;
                     }
                  }
               }

               var4 = var2;
               var2 = var5;
               var5 = var3;
            }

            if(var4 < 4) {
               var3 = var2 | var5 << 8;
               ++var4;
               var2 = var1;
               var1 = var4;
            } else {
               var7 = var9;
               if(var1 >= var9.length) {
                  var7 = a(var9, var9.length);
                  this.K = var7;
               }

               var7[var1] = var5;
               var9 = var7;
               byte var10 = 1;
               var4 = var1 + 1;
               var1 = var10;
               var3 = var2;
               var2 = var4;
            }

            if(this.f >= this.g && !this.E()) {
               this.c(" in field name");
            }

            byte[] var11 = this.N;
            var4 = this.f;
            this.f = var4 + 1;
            var5 = var11[var4] & 255;
            var4 = var1;
            var1 = var2;
            var2 = var4;
         }

         if(var2 > 0) {
            var7 = var9;
            if(var1 >= var9.length) {
               var7 = a(var9, var9.length);
               this.K = var7;
            }

            var7[var1] = var3;
            var9 = var7;
            ++var1;
         }

         sc var12 = this.J.a(var9, var1);
         if(var12 == null) {
            return this.a(var9, var1, var2);
         } else {
            return var12;
         }
      }
   }

   protected final void X() {
      int var2 = this.f;
      int var1 = var2;
      if(var2 >= this.g) {
         this.D();
         var1 = this.f;
      }

      char[] var5 = this.p.k();
      int[] var6 = P;
      int var3 = Math.min(this.g, var5.length + var1);
      byte[] var7 = this.N;

      for(var2 = 0; var1 < var3; ++var1) {
         int var4 = var7[var1] & 255;
         if(var6[var4] != 0) {
            if(var4 == 34) {
               this.f = var1 + 1;
               this.p.a(var2);
               return;
            }
            break;
         }

         var5[var2] = (char)var4;
         ++var2;
      }

      this.f = var1;
      this.a(var5, var2);
   }

   protected final void Y() {
      this.L = false;
      int[] var5 = P;
      byte[] var6 = this.N;

      while(true) {
         label33:
         while(true) {
            int var3 = this.f;
            int var4 = this.g;
            int var2 = var4;
            int var1 = var3;
            if(var3 >= var4) {
               this.D();
               var1 = this.f;
               var2 = this.g;
            }

            while(var1 < var2) {
               var3 = var1 + 1;
               var1 = var6[var1] & 255;
               if(var5[var1] != 0) {
                  this.f = var3;
                  if(var1 == 34) {
                     return;
                  }

                  switch(var5[var1]) {
                  case 1:
                     this.Q();
                     continue label33;
                  case 2:
                     this.r(var1);
                     continue label33;
                  case 3:
                     this.s(var1);
                     continue label33;
                  case 4:
                     this.t(var1);
                     continue label33;
                  default:
                     if(var1 < 32) {
                        this.c(var1, "string value");
                     } else {
                        this.j(var1);
                     }
                     continue label33;
                  }
               }

               var1 = var3;
            }

            this.f = var1;
         }
      }
   }

   protected final hm Z() {
      char[] var5 = this.p.k();
      int[] var6 = P;
      byte[] var7 = this.N;
      int var1 = 0;

      while(true) {
         while(true) {
            if(this.f >= this.g) {
               this.D();
            }

            char[] var4 = var5;
            int var2 = var1;
            if(var1 >= var5.length) {
               var4 = this.p.m();
               var2 = 0;
            }

            int var3 = this.g;
            var1 = this.f + (var4.length - var2);
            if(var1 < var3) {
               var3 = var1;
            }

            while(true) {
               var5 = var4;
               var1 = var2;
               if(this.f >= var3) {
                  break;
               }

               var1 = this.f;
               this.f = var1 + 1;
               var1 = var7[var1] & 255;
               if(var1 == 39 || var6[var1] != 0) {
                  if(var1 == 39) {
                     this.p.a(var2);
                     return hm.h;
                  }

                  switch(var6[var1]) {
                  case 1:
                     if(var1 != 34) {
                        var1 = this.Q();
                     }
                     break;
                  case 2:
                     var1 = this.n(var1);
                     break;
                  case 3:
                     if(this.g - this.f >= 2) {
                        var1 = this.p(var1);
                     } else {
                        var1 = this.o(var1);
                     }
                     break;
                  case 4:
                     var3 = this.q(var1);
                     var1 = var2 + 1;
                     var4[var2] = (char)('\ud800' | var3 >> 10);
                     if(var1 >= var4.length) {
                        var4 = this.p.m();
                        var2 = 0;
                     } else {
                        var2 = var1;
                     }

                     var1 = '\udc00' | var3 & 1023;
                     break;
                  default:
                     if(var1 < 32) {
                        this.c(var1, "string value");
                     }

                     this.j(var1);
                  }

                  if(var2 >= var4.length) {
                     var4 = this.p.m();
                     var2 = 0;
                  }

                  var3 = var2 + 1;
                  var4[var2] = (char)var1;
                  var5 = var4;
                  var1 = var3;
                  break;
               }

               var4[var2] = (char)var1;
               ++var2;
            }
         }
      }
   }

   protected final hm a(int var1, boolean var2) {
      double var3 = Double.NEGATIVE_INFINITY;
      int var5 = var1;
      if(var1 == 73) {
         if(this.f >= this.g && !this.E()) {
            this.T();
         }

         byte[] var6 = this.N;
         var1 = this.f;
         this.f = var1 + 1;
         byte var7 = var6[var1];
         String var8;
         if(var7 == 78) {
            if(var2) {
               var8 = "-INF";
            } else {
               var8 = "+INF";
            }

            this.a((String)var8, 3);
            if(this.a((hj$a)hj$a.h)) {
               if(!var2) {
                  var3 = Double.POSITIVE_INFINITY;
               }

               return this.a(var8, var3);
            }

            this.d("Non-standard token \'" + var8 + "\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
            var5 = var7;
         } else {
            var5 = var7;
            if(var7 == 110) {
               if(var2) {
                  var8 = "-Infinity";
               } else {
                  var8 = "+Infinity";
               }

               this.a((String)var8, 3);
               if(this.a((hj$a)hj$a.h)) {
                  if(!var2) {
                     var3 = Double.POSITIVE_INFINITY;
                  }

                  return this.a(var8, var3);
               }

               this.d("Non-standard token \'" + var8 + "\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
               var5 = var7;
            }
         }
      }

      this.a(var5, "expected digit (0-9) to follow minus sign, for valid numeric value");
      return null;
   }

   public final hn a() {
      return this.I;
   }

   protected final sc a(int var1, int[] var2) {
      byte[] var4 = this.N;
      int var3 = this.f;
      this.f = var3 + 1;
      var3 = var4[var3] & 255;
      if(var2[var3] != 0) {
         return var3 == 34?this.b(this.R, var1, 1):this.a(this.R, var1, var3, 1);
      } else {
         var1 = var3 | var1 << 8;
         var4 = this.N;
         var3 = this.f;
         this.f = var3 + 1;
         var3 = var4[var3] & 255;
         if(var2[var3] != 0) {
            return var3 == 34?this.b(this.R, var1, 2):this.a(this.R, var1, var3, 2);
         } else {
            var1 = var1 << 8 | var3;
            var4 = this.N;
            var3 = this.f;
            this.f = var3 + 1;
            var3 = var4[var3] & 255;
            if(var2[var3] != 0) {
               return var3 == 34?this.b(this.R, var1, 3):this.a(this.R, var1, var3, 3);
            } else {
               var1 = var1 << 8 | var3;
               var4 = this.N;
               var3 = this.f;
               this.f = var3 + 1;
               var3 = var4[var3] & 255;
               if(var2[var3] != 0) {
                  return var3 == 34?this.b(this.R, var1, 4):this.a(this.R, var1, var3, 4);
               } else {
                  this.K[0] = this.R;
                  this.K[1] = var1;
                  return this.f(var3);
               }
            }
         }
      }
   }

   protected final sc a(int[] var1, int var2, int var3, int var4, int var5) {
      int[] var9 = Q;

      while(true) {
         int var6;
         int[] var8;
         label72: {
            var6 = var4;
            if(var9[var4] != 0) {
               if(var4 == 34) {
                  var8 = var1;
                  var4 = var2;
                  if(var5 > 0) {
                     var8 = var1;
                     if(var2 >= var1.length) {
                        var8 = a(var1, var1.length);
                        this.K = var8;
                     }

                     var8[var2] = var3;
                     var4 = var2 + 1;
                  }

                  sc var11 = this.J.a(var8, var4);
                  sc var10 = var11;
                  if(var11 == null) {
                     var10 = this.a(var8, var4, var5);
                  }

                  return var10;
               }

               if(var4 != 92) {
                  this.c(var4, "name");
               } else {
                  var4 = this.Q();
               }

               var6 = var4;
               if(var4 > 127) {
                  if(var5 >= 4) {
                     var8 = var1;
                     if(var2 >= var1.length) {
                        var8 = a(var1, var1.length);
                        this.K = var8;
                     }

                     var6 = var2 + 1;
                     var8[var2] = var3;
                     var5 = 0;
                     var3 = 0;
                     var1 = var8;
                     var2 = var6;
                  }

                  if(var4 < 2048) {
                     var6 = var4 >> 6 | 192 | var3 << 8;
                     ++var5;
                     var3 = var2;
                     var2 = var6;
                  } else {
                     var6 = var4 >> 12 | 224 | var3 << 8;
                     var3 = var5 + 1;
                     if(var3 >= 4) {
                        var8 = var1;
                        if(var2 >= var1.length) {
                           var8 = a(var1, var1.length);
                           this.K = var8;
                        }

                        var8[var2] = var6;
                        ++var2;
                        var1 = var8;
                        var3 = 0;
                        var5 = 0;
                     } else {
                        var5 = var6;
                     }

                     var6 = var5 << 8 | var4 >> 6 & 63 | 128;
                     var5 = var3 + 1;
                     var3 = var2;
                     var2 = var6;
                  }

                  int var7 = var4 & 63 | 128;
                  var6 = var5;
                  var4 = var3;
                  var5 = var2;
                  var3 = var7;
                  var2 = var4;
                  var4 = var5;
                  break label72;
               }
            }

            var4 = var3;
            var3 = var6;
            var6 = var5;
         }

         if(var6 < 4) {
            var5 = var6 + 1;
            var3 |= var4 << 8;
         } else {
            var8 = var1;
            if(var2 >= var1.length) {
               var8 = a(var1, var1.length);
               this.K = var8;
            }

            var8[var2] = var4;
            var5 = 1;
            ++var2;
            var1 = var8;
         }

         if(this.f >= this.g && !this.E()) {
            this.c(" in field name");
         }

         byte[] var12 = this.N;
         var4 = this.f;
         this.f = var4 + 1;
         var4 = var12[var4] & 255;
      }
   }

   protected final String a(hm var1) {
      if(var1 == null) {
         return null;
      } else {
         switch(null.a[var1.ordinal()]) {
         case 1:
            return this.n.h();
         case 2:
         case 3:
         case 4:
            return this.p.f();
         default:
            return var1.a();
         }
      }
   }

   protected final void a(int var1, int var2) {
      this.f = var2;
      this.l(var1);
   }

   protected final void a(String var1, int var2) {
      int var4 = var1.length();

      int var3;
      do {
         if(this.f >= this.g && !this.E()) {
            this.c(" in a value");
         }

         if(this.N[this.f] != var1.charAt(var2)) {
            this.a(var1.substring(0, var2), "\'null\', \'true\', \'false\' or NaN");
         }

         ++this.f;
         var3 = var2 + 1;
         var2 = var3;
      } while(var3 < var4);

      if(this.f < this.g || this.E()) {
         var2 = this.N[this.f] & 255;
         if(var2 >= 48 && var2 != 93 && var2 != 125 && Character.isJavaIdentifierPart((char)this.i(var2))) {
            ++this.f;
            this.a(var1.substring(0, var3), "\'null\', \'true\', \'false\' or NaN");
            return;
         }
      }

   }

   protected final void a(String var1, String var2) {
      StringBuilder var6 = new StringBuilder(var1);

      while(this.f < this.g || this.E()) {
         byte[] var5 = this.N;
         int var4 = this.f;
         this.f = var4 + 1;
         char var3 = (char)this.i(var5[var4]);
         if(!Character.isJavaIdentifierPart(var3)) {
            break;
         }

         ++this.f;
         var6.append(var3);
      }

      this.d("Unrecognized token \'" + var6.toString() + "\': was expecting " + var2);
   }

   public final byte[] a(ha var1) {
      if(this.b != hm.h && (this.b != hm.g || this.t == null)) {
         this.d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
      }

      if(this.L) {
         try {
            this.t = this.b(var1);
         } catch (IllegalArgumentException var3) {
            throw this.a((String)("Failed to decode VALUE_STRING as base64 (" + var1 + "): " + var3.getMessage()));
         }

         this.L = false;
      } else if(this.t == null) {
         sj var2 = this.I();
         this.a(this.k(), var2, var1);
         this.t = var2.b();
      }

      return this.t;
   }

   protected final void aa() {
      if((this.f < this.g || this.E()) && this.N[this.f] == 10) {
         ++this.f;
      }

      ++this.i;
      this.j = this.f;
   }

   protected final void ab() {
      ++this.i;
      this.j = this.f;
   }

   public final hm b() {
      this.y = 0;
      if(this.b == hm.f) {
         return this.ac();
      } else {
         if(this.L) {
            this.Y();
         }

         int var2 = this.af();
         if(var2 < 0) {
            this.close();
            this.b = null;
            return null;
         } else {
            this.k = this.h + (long)this.f - 1L;
            this.l = this.i;
            this.m = this.f - this.j - 1;
            this.t = null;
            hm var4;
            if(var2 == 93) {
               if(!this.n.a()) {
                  this.a(var2, '}');
               }

               this.n = this.n.i();
               var4 = hm.e;
               this.b = var4;
               return var4;
            } else if(var2 == 125) {
               if(!this.n.c()) {
                  this.a(var2, ']');
               }

               this.n = this.n.i();
               var4 = hm.c;
               this.b = var4;
               return var4;
            } else {
               int var1 = var2;
               if(this.n.j()) {
                  if(var2 != 44) {
                     this.b(var2, "was expecting comma to separate " + this.n.d() + " entries");
                  }

                  var1 = this.ae();
               }

               if(!this.n.c()) {
                  return this.m(var1);
               } else {
                  sc var3 = this.e(var1);
                  this.n.a(var3.a());
                  this.b = hm.f;
                  var1 = this.ae();
                  if(var1 != 58) {
                     this.b(var1, "was expecting a colon to separate field name and value");
                  }

                  var1 = this.ae();
                  if(var1 == 34) {
                     this.L = true;
                     this.o = hm.h;
                     return this.b;
                  } else {
                     switch(var1) {
                     case 45:
                     case 48:
                     case 49:
                     case 50:
                     case 51:
                     case 52:
                     case 53:
                     case 54:
                     case 55:
                     case 56:
                     case 57:
                        var4 = this.d(var1);
                        break;
                     case 91:
                        var4 = hm.d;
                        break;
                     case 93:
                     case 125:
                        this.b(var1, "expected a value");
                     case 116:
                        this.a((String)"true", 1);
                        var4 = hm.k;
                        break;
                     case 102:
                        this.a((String)"false", 1);
                        var4 = hm.l;
                        break;
                     case 110:
                        this.a((String)"null", 1);
                        var4 = hm.m;
                        break;
                     case 123:
                        var4 = hm.b;
                        break;
                     default:
                        var4 = this.h(var1);
                     }

                     this.o = var4;
                     return this.b;
                  }
               }
            }
         }
      }
   }

   protected final byte[] b(ha var1) {
      sj var7 = this.I();

      while(true) {
         while(true) {
            int var2;
            int var3;
            int var4;
            byte[] var8;
            do {
               do {
                  if(this.f >= this.g) {
                     this.D();
                  }

                  var8 = this.N;
                  var2 = this.f;
                  this.f = var2 + 1;
                  var4 = var8[var2] & 255;
               } while(var4 <= 32);

               var3 = var1.b(var4);
               var2 = var3;
               if(var3 >= 0) {
                  break;
               }

               if(var4 == 34) {
                  return var7.b();
               }

               var2 = this.a(var1, var4, 0);
            } while(var2 < 0);

            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.N;
            var3 = this.f;
            this.f = var3 + 1;
            int var5 = var8[var3] & 255;
            var4 = var1.b(var5);
            var3 = var4;
            if(var4 < 0) {
               var3 = this.a(var1, var5, 1);
            }

            var5 = var3 | var2 << 6;
            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.N;
            var2 = this.f;
            this.f = var2 + 1;
            int var6 = var8[var2] & 255;
            var3 = var1.b(var6);
            var4 = var3;
            if(var3 < 0) {
               var2 = var3;
               if(var3 != -2) {
                  if(var6 == 34 && !var1.a()) {
                     var7.a(var5 >> 4);
                     return var7.b();
                  }

                  var2 = this.a(var1, var6, 2);
               }

               var4 = var2;
               if(var2 == -2) {
                  if(this.f >= this.g) {
                     this.D();
                  }

                  var8 = this.N;
                  var2 = this.f;
                  this.f = var2 + 1;
                  var2 = var8[var2] & 255;
                  if(!var1.a(var2)) {
                     throw this.a(var1, var2, 3, "expected padding character \'" + var1.b() + "\'");
                  }

                  var7.a(var5 >> 4);
                  continue;
               }
            }

            var5 = var5 << 6 | var4;
            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.N;
            var2 = this.f;
            this.f = var2 + 1;
            var6 = var8[var2] & 255;
            var3 = var1.b(var6);
            var4 = var3;
            if(var3 < 0) {
               var2 = var3;
               if(var3 != -2) {
                  if(var6 == 34 && !var1.a()) {
                     var7.b(var5 >> 2);
                     return var7.b();
                  }

                  var2 = this.a(var1, var6, 3);
               }

               var4 = var2;
               if(var2 == -2) {
                  var7.b(var5 >> 2);
                  continue;
               }
            }

            var7.c(var4 | var5 << 6);
         }
      }
   }

   public final void close() {
      super.close();
      this.J.b();
   }

   protected final hm d(int var1) {
      byte var4 = 1;
      char[] var8 = this.p.k();
      boolean var7;
      if(var1 == 45) {
         var7 = true;
      } else {
         var7 = false;
      }

      byte var2;
      byte[] var9;
      if(var7) {
         var8[0] = 45;
         if(this.f >= this.g) {
            this.D();
         }

         var9 = this.N;
         var1 = this.f;
         this.f = var1 + 1;
         var1 = var9[var1] & 255;
         if(var1 < 48 || var1 > 57) {
            return this.a(var1, true);
         }

         var2 = 1;
      } else {
         var2 = 0;
      }

      int var3 = var1;
      if(var1 == 48) {
         var3 = this.ad();
      }

      int var5 = var2 + 1;
      var8[var2] = (char)var3;
      int var6 = this.f + var8.length;
      var1 = var6;
      int var10 = var5;
      var3 = var4;
      if(var6 > this.g) {
         var1 = this.g;
         var3 = var4;
         var10 = var5;
      }

      while(this.f < var1) {
         var9 = this.N;
         int var11 = this.f;
         this.f = var11 + 1;
         var11 = var9[var11] & 255;
         if(var11 < 48 || var11 > 57) {
            if(var11 != 46 && var11 != 101 && var11 != 69) {
               --this.f;
               this.p.a(var10);
               return this.a(var7, var3);
            }

            return this.a(var8, var10, var11, var7, var3);
         }

         ++var3;
         var8[var10] = (char)var11;
         ++var10;
      }

      return this.a(var8, var10, var7, var3);
   }

   protected final sc e(int var1) {
      if(var1 != 34) {
         return this.g(var1);
      } else if(this.f + 9 > this.g) {
         return this.V();
      } else {
         byte[] var3 = this.N;
         int[] var4 = Q;
         var1 = this.f;
         this.f = var1 + 1;
         var1 = var3[var1] & 255;
         if(var4[var1] == 0) {
            int var2 = this.f;
            this.f = var2 + 1;
            var2 = var3[var2] & 255;
            if(var4[var2] == 0) {
               var1 = var1 << 8 | var2;
               var2 = this.f;
               this.f = var2 + 1;
               var2 = var3[var2] & 255;
               if(var4[var2] == 0) {
                  var1 = var1 << 8 | var2;
                  var2 = this.f;
                  this.f = var2 + 1;
                  var2 = var3[var2] & 255;
                  if(var4[var2] == 0) {
                     var1 = var1 << 8 | var2;
                     var2 = this.f;
                     this.f = var2 + 1;
                     var2 = var3[var2] & 255;
                     if(var4[var2] == 0) {
                        this.R = var1;
                        return this.a(var2, var4);
                     } else {
                        return var2 == 34?this.b(var1, 4):this.a(var1, var2, 4);
                     }
                  } else {
                     return var2 == 34?this.b(var1, 3):this.a(var1, var2, 3);
                  }
               } else {
                  return var2 == 34?this.b(var1, 2):this.a(var1, var2, 2);
               }
            } else {
               return var2 == 34?this.b(var1, 1):this.a(var1, var2, 1);
            }
         } else {
            return var1 == 34?sa.e():this.a(0, var1, 0);
         }
      }
   }

   protected final sc f(int var1) {
      int[] var4 = Q;
      byte var3 = 2;
      int var2 = var1;

      for(var1 = var3; this.g - this.f >= 4; ++var1) {
         byte[] var5 = this.N;
         int var6 = this.f;
         this.f = var6 + 1;
         var6 = var5[var6] & 255;
         if(var4[var6] != 0) {
            if(var6 == 34) {
               return this.a(this.K, var1, var2, 1);
            }

            return this.a(this.K, var1, var2, var6, 1);
         }

         var2 = var2 << 8 | var6;
         var5 = this.N;
         var6 = this.f;
         this.f = var6 + 1;
         var6 = var5[var6] & 255;
         if(var4[var6] != 0) {
            if(var6 == 34) {
               return this.a(this.K, var1, var2, 2);
            }

            return this.a(this.K, var1, var2, var6, 2);
         }

         var2 = var2 << 8 | var6;
         var5 = this.N;
         var6 = this.f;
         this.f = var6 + 1;
         var6 = var5[var6] & 255;
         if(var4[var6] != 0) {
            if(var6 == 34) {
               return this.a(this.K, var1, var2, 3);
            }

            return this.a(this.K, var1, var2, var6, 3);
         }

         var6 |= var2 << 8;
         var5 = this.N;
         var2 = this.f;
         this.f = var2 + 1;
         var2 = var5[var2] & 255;
         if(var4[var2] != 0) {
            if(var2 == 34) {
               return this.a(this.K, var1, var6, 4);
            }

            return this.a(this.K, var1, var6, var2, 4);
         }

         if(var1 >= this.K.length) {
            this.K = a(this.K, var1);
         }

         this.K[var1] = var6;
      }

      return this.a(this.K, var1, 0, var2, 0);
   }

   protected final sc g(int var1) {
      if(var1 == 39 && this.a((hj$a)hj$a.d)) {
         return this.W();
      } else {
         if(!this.a((hj$a)hj$a.c)) {
            this.b(var1, "was expecting double-quote to start field name");
         }

         int[] var8 = sk.d();
         if(var8[var1] != 0) {
            this.b(var1, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
         }

         int[] var6 = this.K;
         int var4 = 0;
         int var3 = 0;
         int var2 = var1;
         var1 = 0;

         while(true) {
            int[] var7;
            if(var4 < 4) {
               var3 = var2 | var3 << 8;
               var2 = var4 + 1;
            } else {
               var7 = var6;
               if(var1 >= var6.length) {
                  var7 = a(var6, var6.length);
                  this.K = var7;
               }

               var7[var1] = var3;
               var6 = var7;
               byte var9 = 1;
               var3 = var2;
               ++var1;
               var2 = var9;
            }

            if(this.f >= this.g && !this.E()) {
               this.c(" in field name");
            }

            int var5 = this.N[this.f] & 255;
            if(var8[var5] != 0) {
               var4 = var1;
               var7 = var6;
               if(var2 > 0) {
                  var7 = var6;
                  if(var1 >= var6.length) {
                     var7 = a(var6, var6.length);
                     this.K = var7;
                  }

                  var7[var1] = var3;
                  var4 = var1 + 1;
               }

               sc var10 = this.J.a(var7, var4);
               if(var10 == null) {
                  return this.a(var7, var4, var2);
               }

               return var10;
            }

            ++this.f;
            var4 = var2;
            var2 = var5;
         }
      }
   }

   protected final hm h(int var1) {
      switch(var1) {
      case 39:
         if(this.a((hj$a)hj$a.d)) {
            return this.Z();
         }
         break;
      case 43:
         if(this.f >= this.g && !this.E()) {
            this.T();
         }

         byte[] var2 = this.N;
         var1 = this.f;
         this.f = var1 + 1;
         return this.a(var2[var1] & 255, false);
      case 78:
         this.a((String)"NaN", 1);
         if(this.a((hj$a)hj$a.h)) {
            return this.a("NaN", Double.NaN);
         }

         this.d("Non-standard token \'NaN\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }

      this.b(var1, "expected a valid value (number, String, array, object, \'true\', \'false\' or \'null\')");
      return null;
   }

   protected final int i(int var1) {
      int var3 = var1;
      if(var1 < 0) {
         byte var2;
         if((var1 & 224) == 192) {
            var1 &= 31;
            var2 = 1;
         } else if((var1 & 240) == 224) {
            var1 &= 15;
            var2 = 2;
         } else if((var1 & 248) == 240) {
            var1 &= 7;
            var2 = 3;
         } else {
            this.k(var1 & 255);
            var2 = 1;
         }

         var3 = this.aj();
         if((var3 & 192) != 128) {
            this.l(var3 & 255);
         }

         var1 = var1 << 6 | var3 & 63;
         var3 = var1;
         if(var2 > 1) {
            var3 = this.aj();
            if((var3 & 192) != 128) {
               this.l(var3 & 255);
            }

            var1 = var1 << 6 | var3 & 63;
            var3 = var1;
            if(var2 > 2) {
               int var4 = this.aj();
               if((var4 & 192) != 128) {
                  this.l(var4 & 255);
               }

               var3 = var1 << 6 | var4 & 63;
            }
         }
      }

      return var3;
   }

   protected final void j(int var1) {
      if(var1 < 32) {
         this.b(var1);
      }

      this.k(var1);
   }

   public final String k() {
      hm var1 = this.b;
      if(var1 == hm.h) {
         if(this.L) {
            this.L = false;
            this.X();
         }

         return this.p.f();
      } else {
         return this.a(var1);
      }
   }

   protected final void k(int var1) {
      this.d("Invalid UTF-8 start byte 0x" + Integer.toHexString(var1));
   }

   protected final void l(int var1) {
      this.d("Invalid UTF-8 middle byte 0x" + Integer.toHexString(var1));
   }

   public final char[] l() {
      if(this.b != null) {
         switch(null.a[this.b.ordinal()]) {
         case 1:
            if(!this.r) {
               String var2 = this.n.h();
               int var1 = var2.length();
               if(this.q == null) {
                  this.q = this.d.a(var1);
               } else if(this.q.length < var1) {
                  this.q = new char[var1];
               }

               var2.getChars(0, var1, this.q, 0);
               this.r = true;
            }

            return this.q;
         case 2:
            if(this.L) {
               this.L = false;
               this.X();
            }
         case 3:
         case 4:
            return this.p.e();
         default:
            return this.b.b();
         }
      } else {
         return null;
      }
   }

   public final int m() {
      int var1 = 0;
      if(this.b != null) {
         switch(null.a[this.b.ordinal()]) {
         case 1:
            return this.n.h().length();
         case 2:
            if(this.L) {
               this.L = false;
               this.X();
            }
         case 3:
         case 4:
            return this.p.c();
         default:
            var1 = this.b.b().length;
         }
      }

      return var1;
   }

   public final int n() {
      if(this.b != null) {
         switch(null.a[this.b.ordinal()]) {
         case 1:
         default:
            break;
         case 2:
            if(this.L) {
               this.L = false;
               this.X();
            }
         case 3:
         case 4:
            return this.p.d();
         }
      }

      return 0;
   }
}
