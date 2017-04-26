package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.hu;
import com.flurry.sdk.ie;
import com.flurry.sdk.sb;
import com.flurry.sdk.sj;
import com.flurry.sdk.sk;
import com.flurry.sdk.sp;
import java.io.IOException;
import java.io.Reader;

public final class hy extends hu {
   protected Reader I;
   protected char[] J;
   protected hn K;
   protected final sb L;
   protected boolean M = false;

   public hy(ie var1, int var2, Reader var3, hn var4, sb var5) {
      super(var1, var2);
      this.I = var3;
      this.J = var1.g();
      this.K = var4;
      this.L = var5;
   }

   private final hm a(boolean var1) {
      int var11 = 0;
      char[] var15 = this.p.k();
      int var4;
      if(var1) {
         var15[0] = 45;
         var4 = 1;
      } else {
         var4 = 0;
      }

      char var2;
      int var5;
      char[] var14;
      if(this.f < this.g) {
         var14 = this.J;
         var5 = this.f;
         this.f = var5 + 1;
         var2 = var14[var5];
      } else {
         var2 = this.e("No digit following minus sign");
      }

      char var3 = var2;
      if(var2 == 48) {
         var3 = this.ad();
      }

      var5 = 0;
      var2 = var3;

      int var6;
      boolean var8;
      boolean var16;
      while(true) {
         if(var2 < 48 || var2 > 57) {
            var8 = false;
            var14 = var15;
            var6 = var4;
            var16 = var8;
            var4 = var5;
            break;
         }

         ++var5;
         var6 = var4;
         var14 = var15;
         if(var4 >= var15.length) {
            var14 = this.p.m();
            var6 = 0;
         }

         var4 = var6 + 1;
         var14[var6] = var2;
         if(this.f >= this.g && !this.E()) {
            boolean var7 = true;
            var2 = 0;
            var6 = var4;
            var4 = var5;
            var16 = var7;
            break;
         }

         var15 = this.J;
         var6 = this.f;
         this.f = var6 + 1;
         var2 = var15[var6];
         var15 = var14;
      }

      if(var4 == 0) {
         this.b("Missing integer part (next char " + c(var2) + ")");
      }

      int var17;
      int var18;
      boolean var19;
      if(var2 == 46) {
         var14[var6] = var2;
         ++var6;
         var17 = 0;

         while(true) {
            if(this.f >= this.g && !this.E()) {
               var8 = true;
               break;
            }

            var15 = this.J;
            var18 = this.f;
            this.f = var18 + 1;
            var2 = var15[var18];
            if(var2 < 48 || var2 > 57) {
               var8 = var16;
               break;
            }

            ++var17;
            if(var6 >= var14.length) {
               var14 = this.p.m();
               var6 = 0;
            }

            var18 = var6 + 1;
            var14[var6] = var2;
            var6 = var18;
         }

         if(var17 == 0) {
            this.a(var2, "Decimal point not followed by a digit");
         }

         var5 = var17;
         var17 = var6;
         var19 = var8;
         var15 = var14;
      } else {
         byte var20 = 0;
         var17 = var6;
         var15 = var14;
         var19 = var16;
         var5 = var20;
      }

      int var10;
      int var12;
      int var13;
      boolean var21;
      if(var2 != 101 && var2 != 69) {
         var21 = var19;
         var10 = var17;
         var12 = var5;
         var13 = var4;
      } else {
         var18 = var17;
         var14 = var15;
         if(var17 >= var15.length) {
            var14 = this.p.m();
            var18 = 0;
         }

         var17 = var18 + 1;
         var14[var18] = var2;
         if(this.f < this.g) {
            var15 = this.J;
            var18 = this.f;
            this.f = var18 + 1;
            var2 = var15[var18];
         } else {
            var2 = this.e("expected a digit for number exponent");
         }

         int var9;
         if(var2 != 45 && var2 != 43) {
            var18 = 0;
            var15 = var14;
         } else {
            if(var17 >= var14.length) {
               var14 = this.p.m();
               var17 = 0;
            }

            var18 = var17 + 1;
            var14[var17] = var2;
            byte var22;
            if(this.f < this.g) {
               var15 = this.J;
               var17 = this.f;
               this.f = var17 + 1;
               var2 = var15[var17];
               var22 = 0;
            } else {
               var2 = this.e("expected a digit for number exponent");
               var22 = 0;
            }

            var9 = var18;
            var15 = var14;
            var18 = var22;
            var17 = var9;
         }

         while(var2 <= 57 && var2 >= 48) {
            var9 = var18 + 1;
            var10 = var17;
            var14 = var15;
            if(var17 >= var15.length) {
               var14 = this.p.m();
               var10 = 0;
            }

            var18 = var10 + 1;
            var14[var10] = var2;
            if(this.f >= this.g && !this.E()) {
               var19 = true;
               var17 = var18;
               var18 = var9;
               break;
            }

            var15 = this.J;
            var17 = this.f;
            this.f = var17 + 1;
            var2 = var15[var17];
            var17 = var9;
            var9 = var18;
            var15 = var14;
            var18 = var17;
            var17 = var9;
         }

         var21 = var19;
         var10 = var17;
         var11 = var18;
         var12 = var5;
         var13 = var4;
         if(var18 == 0) {
            this.a(var2, "Exponent indicator not followed by a digit");
            var13 = var4;
            var12 = var5;
            var11 = var18;
            var10 = var17;
            var21 = var19;
         }
      }

      if(!var21) {
         --this.f;
      }

      this.p.a(var10);
      return this.a(var1, var13, var12, var11);
   }

   private String a(int var1, int var2, int var3) {
      this.p.a(this.J, var1, this.f - var1);
      char[] var7 = this.p.j();
      var1 = this.p.l();

      while(true) {
         if(this.f >= this.g && !this.E()) {
            this.c(": was expecting closing \'" + (char)var3 + "\' for name");
         }

         char var4;
         char var5;
         int var6;
         label31: {
            char[] var8 = this.J;
            var6 = this.f;
            this.f = var6 + 1;
            var5 = var8[var6];
            if(var5 <= 92) {
               if(var5 == 92) {
                  var4 = this.Q();
                  break label31;
               }

               if(var5 <= var3) {
                  if(var5 == var3) {
                     this.p.a(var1);
                     sp var9 = this.p;
                     var8 = var9.e();
                     var1 = var9.d();
                     var3 = var9.c();
                     return this.L.a(var8, var1, var3, var2);
                  }

                  if(var5 < 32) {
                     this.c(var5, "name");
                  }
               }
            }

            var4 = var5;
         }

         var2 = var2 * 31 + var5;
         var6 = var1 + 1;
         var7[var1] = var4;
         if(var6 >= var7.length) {
            var7 = this.p.m();
            var1 = 0;
         } else {
            var1 = var6;
         }
      }
   }

   private String a(int var1, int var2, int[] var3) {
      this.p.a(this.J, var1, this.f - var1);
      char[] var7 = this.p.j();
      var1 = this.p.l();
      int var6 = var3.length;

      int var5;
      while(this.f < this.g || this.E()) {
         char var4 = this.J[this.f];
         if(var4 <= var6) {
            if(var3[var4] != 0) {
               break;
            }
         } else if(!Character.isJavaIdentifierPart(var4)) {
            break;
         }

         ++this.f;
         var2 = var2 * 31 + var4;
         var5 = var1 + 1;
         var7[var1] = var4;
         if(var5 >= var7.length) {
            var7 = this.p.m();
            var1 = 0;
         } else {
            var1 = var5;
         }
      }

      this.p.a(var1);
      sp var8 = this.p;
      var7 = var8.e();
      var1 = var8.d();
      var5 = var8.c();
      return this.L.a(var7, var1, var5, var2);
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

   private final char ad() {
      char var1;
      if(this.f >= this.g && !this.E()) {
         var1 = 48;
         return var1;
      } else {
         char var2 = this.J[this.f];
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

                  var2 = this.J[this.f];
                  if(var2 < 48 || var2 > 57) {
                     return '0';
                  }

                  ++this.f;
                  var1 = var2;
               } while(var2 == 48);

               return var2;
            }
         } else {
            return '0';
         }
      }
   }

   private final int ae() {
      while(this.f < this.g || this.E()) {
         char[] var2 = this.J;
         int var1 = this.f;
         this.f = var1 + 1;
         char var3 = var2[var1];
         if(var3 > 32) {
            if(var3 != 47) {
               return var3;
            }

            this.ag();
         } else if(var3 != 32) {
            if(var3 == 10) {
               this.ab();
            } else if(var3 == 13) {
               this.aa();
            } else if(var3 != 9) {
               this.b(var3);
            }
         }
      }

      throw this.a((String)("Unexpected end-of-input within/between " + this.n.d() + " entries"));
   }

   private final int af() {
      int var1;
      while(true) {
         if(this.f >= this.g && !this.E()) {
            this.H();
            var1 = -1;
            break;
         }

         char[] var3 = this.J;
         var1 = this.f;
         this.f = var1 + 1;
         char var2 = var3[var1];
         if(var2 <= 32) {
            if(var2 != 32) {
               if(var2 == 10) {
                  this.ab();
               } else if(var2 == 13) {
                  this.aa();
               } else if(var2 != 9) {
                  this.b(var2);
               }
            }
         } else {
            var1 = var2;
            if(var2 == 47) {
               this.ag();
               continue;
            }
            break;
         }
      }

      return var1;
   }

   private final void ag() {
      if(!this.a((hj$a)hj$a.b)) {
         this.b(47, "maybe a (non-standard) comment? (not recognized as one since Feature \'ALLOW_COMMENTS\' not enabled for parser)");
      }

      if(this.f >= this.g && !this.E()) {
         this.c(" in a comment");
      }

      char[] var2 = this.J;
      int var1 = this.f;
      this.f = var1 + 1;
      char var3 = var2[var1];
      if(var3 == 47) {
         this.ai();
      } else if(var3 == 42) {
         this.ah();
      } else {
         this.b(var3, "was expecting either \'*\' or \'/\' for a comment");
      }
   }

   private final void ah() {
      while(this.f < this.g || this.E()) {
         char[] var2 = this.J;
         int var1 = this.f;
         this.f = var1 + 1;
         char var3 = var2[var1];
         if(var3 <= 42) {
            if(var3 != 42) {
               if(var3 < 32) {
                  if(var3 == 10) {
                     this.ab();
                  } else if(var3 == 13) {
                     this.aa();
                  } else if(var3 != 9) {
                     this.b(var3);
                  }
               }
            } else {
               if(this.f >= this.g && !this.E()) {
                  break;
               }

               if(this.J[this.f] == 47) {
                  ++this.f;
                  return;
               }
            }
         }
      }

      this.c(" in a comment");
   }

   private final void ai() {
      while(this.f < this.g || this.E()) {
         char[] var2 = this.J;
         int var1 = this.f;
         this.f = var1 + 1;
         char var3 = var2[var1];
         if(var3 < 32) {
            if(var3 == 10) {
               this.ab();
               break;
            }

            if(var3 == 13) {
               this.aa();
               return;
            }

            if(var3 != 9) {
               this.b(var3);
            }
         }
      }

   }

   protected final boolean E() {
      boolean var3 = false;
      this.h += (long)this.g;
      this.j -= this.g;
      boolean var2 = var3;
      if(this.I != null) {
         int var1 = this.I.read(this.J, 0, this.J.length);
         if(var1 > 0) {
            this.f = 0;
            this.g = var1;
            var2 = true;
         } else {
            this.F();
            var2 = var3;
            if(var1 == 0) {
               throw new IOException("Reader returned 0 characters when trying to read " + this.g);
            }
         }
      }

      return var2;
   }

   protected final void F() {
      if(this.I != null) {
         if(this.d.c() || this.a((hj$a)hj$a.a)) {
            this.I.close();
         }

         this.I = null;
      }

   }

   protected final void G() {
      super.G();
      char[] var1 = this.J;
      if(var1 != null) {
         this.J = null;
         this.d.a(var1);
      }

   }

   protected final char Q() {
      int var4 = 0;
      if(this.f >= this.g && !this.E()) {
         this.c(" in character escape sequence");
      }

      char[] var7 = this.J;
      int var3 = this.f;
      this.f = var3 + 1;
      char var2 = var7[var3];
      char var1 = var2;
      switch(var2) {
      case 'b':
         return '\b';
      case 'f':
         return '\f';
      case 'n':
         return '\n';
      case 'r':
         return '\r';
      case 't':
         return '\t';
      case 'u':
         for(var3 = 0; var3 < 4; ++var3) {
            if(this.f >= this.g && !this.E()) {
               this.c(" in character escape sequence");
            }

            var7 = this.J;
            int var5 = this.f;
            this.f = var5 + 1;
            char var8 = var7[var5];
            int var6 = sk.a(var8);
            if(var6 < 0) {
               this.b(var8, "expected a hex-digit for character escape sequence");
            }

            var4 = var4 << 4 | var6;
         }

         return (char)var4;
      default:
         var1 = this.a(var2);
      case '\"':
      case '/':
      case '\\':
         return var1;
      }
   }

   protected final String V() {
      int var1 = this.f;
      int var4 = 0;
      int var3 = 0;
      int var5 = this.g;
      int var2 = var1;
      if(var1 < var5) {
         int[] var8 = sk.a();
         int var6 = var8.length;

         do {
            char var7 = this.J[var1];
            if(var7 == 39) {
               var2 = this.f;
               this.f = var1 + 1;
               return this.L.a(this.J, var2, var1 - var2, var3);
            }

            if(var7 < var6) {
               var4 = var3;
               var2 = var1;
               if(var8[var7] != 0) {
                  break;
               }
            }

            var4 = var3 * 31 + var7;
            var2 = var1 + 1;
            var3 = var4;
            var1 = var2;
         } while(var2 < var5);
      }

      var1 = this.f;
      this.f = var2;
      return this.a(var1, var4, 39);
   }

   protected final hm W() {
      char[] var5 = this.p.k();
      int var3 = this.p.l();

      while(true) {
         if(this.f >= this.g && !this.E()) {
            this.c(": was expecting closing quote for a string value");
         }

         char[] var6 = this.J;
         int var4 = this.f;
         this.f = var4 + 1;
         char var2 = var6[var4];
         char var1 = var2;
         if(var2 <= 92) {
            if(var2 == 92) {
               var1 = this.Q();
            } else {
               var1 = var2;
               if(var2 <= 39) {
                  if(var2 == 39) {
                     this.p.a(var3);
                     return hm.h;
                  }

                  var1 = var2;
                  if(var2 < 32) {
                     this.c(var2, "string value");
                     var1 = var2;
                  }
               }
            }
         }

         if(var3 >= var5.length) {
            var5 = this.p.m();
            var3 = 0;
         }

         var4 = var3 + 1;
         var5[var3] = var1;
         var3 = var4;
      }
   }

   protected final void X() {
      int var1 = this.f;
      int var3 = this.g;
      int var2 = var1;
      if(var1 < var3) {
         int[] var6 = sk.a();
         int var4 = var6.length;

         do {
            char var5 = this.J[var1];
            if(var5 < var4 && var6[var5] != 0) {
               var2 = var1;
               if(var5 == 34) {
                  this.p.a(this.J, this.f, var1 - this.f);
                  this.f = var1 + 1;
                  return;
               }
               break;
            }

            var2 = var1 + 1;
            var1 = var2;
         } while(var2 < var3);
      }

      this.p.b(this.J, this.f, var2 - this.f);
      this.f = var2;
      this.Y();
   }

   protected final void Y() {
      char[] var5 = this.p.j();
      int var3 = this.p.l();

      while(true) {
         if(this.f >= this.g && !this.E()) {
            this.c(": was expecting closing quote for a string value");
         }

         char[] var6 = this.J;
         int var4 = this.f;
         this.f = var4 + 1;
         char var2 = var6[var4];
         char var1 = var2;
         if(var2 <= 92) {
            if(var2 == 92) {
               var1 = this.Q();
            } else {
               var1 = var2;
               if(var2 <= 34) {
                  if(var2 == 34) {
                     this.p.a(var3);
                     return;
                  }

                  var1 = var2;
                  if(var2 < 32) {
                     this.c(var2, "string value");
                     var1 = var2;
                  }
               }
            }
         }

         if(var3 >= var5.length) {
            var5 = this.p.m();
            var3 = 0;
         }

         var4 = var3 + 1;
         var5[var3] = var1;
         var3 = var4;
      }
   }

   protected final void Z() {
      this.M = false;
      int var1 = this.f;
      int var2 = this.g;
      char[] var5 = this.J;

      while(true) {
         while(true) {
            int var3 = var2;
            int var4 = var1;
            if(var1 >= var2) {
               this.f = var1;
               if(!this.E()) {
                  this.c(": was expecting closing quote for a string value");
               }

               var4 = this.f;
               var3 = this.g;
            }

            var1 = var4 + 1;
            char var6 = var5[var4];
            if(var6 <= 92) {
               if(var6 == 92) {
                  this.f = var1;
                  this.Q();
                  var1 = this.f;
                  var2 = this.g;
                  continue;
               }

               if(var6 <= 34) {
                  if(var6 == 34) {
                     this.f = var1;
                     return;
                  }

                  if(var6 < 32) {
                     this.f = var1;
                     this.c(var6, "string value");
                  }
               }
            }

            var2 = var3;
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

         char[] var6 = this.J;
         var1 = this.f;
         this.f = var1 + 1;
         char var7 = var6[var1];
         String var8;
         if(var7 == 78) {
            if(var2) {
               var8 = "-INF";
            } else {
               var8 = "+INF";
            }

            this.a(var8, 3);
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

               this.a(var8, 3);
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
      return this.K;
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

   protected final void a(String var1, int var2) {
      int var5 = var1.length();

      int var4;
      do {
         if(this.f >= this.g && !this.E()) {
            this.T();
         }

         if(this.J[this.f] != var1.charAt(var2)) {
            this.a(var1.substring(0, var2), "\'null\', \'true\', \'false\' or NaN");
         }

         ++this.f;
         var4 = var2 + 1;
         var2 = var4;
      } while(var4 < var5);

      if(this.f < this.g || this.E()) {
         char var3 = this.J[this.f];
         if(var3 >= 48 && var3 != 93 && var3 != 125 && Character.isJavaIdentifierPart(var3)) {
            ++this.f;
            this.a(var1.substring(0, var4), "\'null\', \'true\', \'false\' or NaN");
            return;
         }
      }

   }

   protected final void a(String var1, String var2) {
      StringBuilder var4 = new StringBuilder(var1);

      while(this.f < this.g || this.E()) {
         char var3 = this.J[this.f];
         if(!Character.isJavaIdentifierPart(var3)) {
            break;
         }

         ++this.f;
         var4.append(var3);
      }

      this.d("Unrecognized token \'" + var4.toString() + "\': was expecting ");
   }

   public final byte[] a(ha var1) {
      if(this.b != hm.h && (this.b != hm.g || this.t == null)) {
         this.d("Current token (" + this.b + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
      }

      if(this.M) {
         try {
            this.t = this.b(var1);
         } catch (IllegalArgumentException var3) {
            throw this.a((String)("Failed to decode VALUE_STRING as base64 (" + var1 + "): " + var3.getMessage()));
         }

         this.M = false;
      } else if(this.t == null) {
         sj var2 = this.I();
         this.a(this.k(), var2, var1);
         this.t = var2.b();
      }

      return this.t;
   }

   protected final void aa() {
      if((this.f < this.g || this.E()) && this.J[this.f] == 10) {
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
         if(this.M) {
            this.Z();
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
            hm var5;
            if(var2 == 93) {
               if(!this.n.a()) {
                  this.a(var2, '}');
               }

               this.n = this.n.i();
               var5 = hm.e;
               this.b = var5;
               return var5;
            } else if(var2 == 125) {
               if(!this.n.c()) {
                  this.a(var2, ']');
               }

               this.n = this.n.i();
               var5 = hm.c;
               this.b = var5;
               return var5;
            } else {
               int var1 = var2;
               if(this.n.j()) {
                  if(var2 != 44) {
                     this.b(var2, "was expecting comma to separate " + this.n.d() + " entries");
                  }

                  var1 = this.ae();
               }

               boolean var3 = this.n.c();
               var2 = var1;
               if(var3) {
                  String var4 = this.e(var1);
                  this.n.a(var4);
                  this.b = hm.f;
                  var1 = this.ae();
                  if(var1 != 58) {
                     this.b(var1, "was expecting a colon to separate field name and value");
                  }

                  var2 = this.ae();
               }

               switch(var2) {
               case 34:
                  this.M = true;
                  var5 = hm.h;
                  break;
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
                  var5 = this.d(var2);
                  break;
               case 91:
                  if(!var3) {
                     this.n = this.n.b(this.l, this.m);
                  }

                  var5 = hm.d;
                  break;
               case 93:
               case 125:
                  this.b(var2, "expected a value");
               case 116:
                  this.a("true", 1);
                  var5 = hm.k;
                  break;
               case 102:
                  this.a("false", 1);
                  var5 = hm.l;
                  break;
               case 110:
                  this.a("null", 1);
                  var5 = hm.m;
                  break;
               case 123:
                  if(!var3) {
                     this.n = this.n.c(this.l, this.m);
                  }

                  var5 = hm.b;
                  break;
               default:
                  var5 = this.g(var2);
               }

               if(var3) {
                  this.o = var5;
                  return this.b;
               } else {
                  this.b = var5;
                  return var5;
               }
            }
         }
      }
   }

   protected final byte[] b(ha var1) {
      sj var7 = this.I();

      while(true) {
         while(true) {
            char var2;
            int var3;
            int var4;
            char[] var8;
            do {
               do {
                  if(this.f >= this.g) {
                     this.D();
                  }

                  var8 = this.J;
                  var3 = this.f;
                  this.f = var3 + 1;
                  var2 = var8[var3];
               } while(var2 <= 32);

               var4 = var1.b(var2);
               var3 = var4;
               if(var4 >= 0) {
                  break;
               }

               if(var2 == 34) {
                  return var7.b();
               }

               var3 = this.a(var1, var2, 0);
            } while(var3 < 0);

            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.J;
            var4 = this.f;
            this.f = var4 + 1;
            var2 = var8[var4];
            int var5 = var1.b(var2);
            var4 = var5;
            if(var5 < 0) {
               var4 = this.a(var1, var2, 1);
            }

            int var6 = var4 | var3 << 6;
            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.J;
            var3 = this.f;
            this.f = var3 + 1;
            var2 = var8[var3];
            var4 = var1.b(var2);
            var5 = var4;
            if(var4 < 0) {
               var3 = var4;
               if(var4 != -2) {
                  if(var2 == 34 && !var1.a()) {
                     var7.a(var6 >> 4);
                     return var7.b();
                  }

                  var3 = this.a(var1, var2, 2);
               }

               var5 = var3;
               if(var3 == -2) {
                  if(this.f >= this.g) {
                     this.D();
                  }

                  var8 = this.J;
                  var3 = this.f;
                  this.f = var3 + 1;
                  var2 = var8[var3];
                  if(!var1.a(var2)) {
                     throw this.a(var1, var2, 3, "expected padding character \'" + var1.b() + "\'");
                  }

                  var7.a(var6 >> 4);
                  continue;
               }
            }

            var6 = var6 << 6 | var5;
            if(this.f >= this.g) {
               this.D();
            }

            var8 = this.J;
            var3 = this.f;
            this.f = var3 + 1;
            var2 = var8[var3];
            var4 = var1.b(var2);
            var5 = var4;
            if(var4 < 0) {
               var3 = var4;
               if(var4 != -2) {
                  if(var2 == 34 && !var1.a()) {
                     var7.b(var6 >> 2);
                     return var7.b();
                  }

                  var3 = this.a(var1, var2, 3);
               }

               var5 = var3;
               if(var3 == -2) {
                  var7.b(var6 >> 2);
                  continue;
               }
            }

            var7.c(var5 | var6 << 6);
         }
      }
   }

   public final void close() {
      super.close();
      this.L.b();
   }

   protected final hm d(int var1) {
      int var4 = 1;
      int var6 = 0;
      byte var9 = 0;
      boolean var11;
      if(var1 == 45) {
         var11 = true;
      } else {
         var11 = false;
      }

      int var8;
      label111: {
         int var3;
         char var5;
         label115: {
            int var2 = this.f;
            var8 = var2 - 1;
            int var10 = this.g;
            char[] var12;
            if(var11) {
               if(var2 >= this.g) {
                  break label111;
               }

               var12 = this.J;
               var3 = var2 + 1;
               var5 = var12[var2];
               if(var5 > 57) {
                  break label115;
               }

               var1 = var3;
               var2 = var5;
               if(var5 < 48) {
                  break label115;
               }
            } else {
               var3 = var2;
               var2 = var1;
               var1 = var3;
            }

            if(var2 == 48) {
               break label111;
            }

            var2 = var1;

            while(true) {
               if(var2 >= this.g) {
                  break label111;
               }

               var12 = this.J;
               var1 = var2 + 1;
               char var13 = var12[var2];
               if(var13 < 48 || var13 > 57) {
                  int var15;
                  if(var13 == 46) {
                     byte var14 = 0;
                     var3 = var1;
                     var1 = var14;

                     while(true) {
                        if(var3 >= var10) {
                           break label111;
                        }

                        var12 = this.J;
                        var2 = var3 + 1;
                        var13 = var12[var3];
                        if(var13 < 48 || var13 > 57) {
                           if(var1 == 0) {
                              this.a(var13, "Decimal point not followed by a digit");
                           }

                           var15 = var1;
                           var1 = var2;
                           break;
                        }

                        ++var1;
                        var3 = var2;
                     }
                  } else {
                     var15 = 0;
                  }

                  int var7;
                  label124: {
                     if(var13 != 101) {
                        var7 = var1;
                        if(var13 != 69) {
                           break label124;
                        }
                     }

                     if(var1 >= var10) {
                        break label111;
                     }

                     var12 = this.J;
                     var2 = var1 + 1;
                     var13 = var12[var1];
                     if(var13 != 45 && var13 != 43) {
                        var1 = var2;
                        var2 = var9;
                     } else {
                        if(var2 >= var10) {
                           break label111;
                        }

                        var12 = this.J;
                        var1 = var2 + 1;
                        var13 = var12[var2];
                        var2 = var9;
                     }

                     while(var13 <= 57 && var13 >= 48) {
                        ++var2;
                        if(var1 >= var10) {
                           break label111;
                        }

                        var13 = this.J[var1];
                        ++var1;
                     }

                     var6 = var2;
                     var7 = var1;
                     if(var2 == 0) {
                        this.a(var13, "Exponent indicator not followed by a digit");
                        var7 = var1;
                        var6 = var2;
                     }
                  }

                  var1 = var7 - 1;
                  this.f = var1;
                  this.p.a(this.J, var8, var1 - var8);
                  return this.a(var11, var4, var15, var6);
               }

               ++var4;
               var2 = var1;
            }
         }

         this.f = var3;
         return this.a(var5, true);
      }

      if(var11) {
         var1 = var8 + 1;
      } else {
         var1 = var8;
      }

      this.f = var1;
      return this.a(var11);
   }

   protected final char e(String var1) {
      if(this.f >= this.g && !this.E()) {
         this.c(var1);
      }

      char[] var3 = this.J;
      int var2 = this.f;
      this.f = var2 + 1;
      return var3[var2];
   }

   protected final String e(int var1) {
      if(var1 != 34) {
         return this.f(var1);
      } else {
         var1 = this.f;
         int var4 = 0;
         int var2 = 0;
         int var5 = this.g;
         int var3 = var1;
         if(var1 < var5) {
            int[] var8 = sk.a();
            int var6 = var8.length;

            do {
               char var7 = this.J[var1];
               if(var7 < var6 && var8[var7] != 0) {
                  var4 = var2;
                  var3 = var1;
                  if(var7 == 34) {
                     var3 = this.f;
                     this.f = var1 + 1;
                     return this.L.a(this.J, var3, var1 - var3, var2);
                  }
                  break;
               }

               var4 = var2 * 31 + var7;
               var3 = var1 + 1;
               var2 = var4;
               var1 = var3;
            } while(var3 < var5);
         }

         var1 = this.f;
         this.f = var3;
         return this.a(var1, var4, 34);
      }
   }

   protected final String f(int var1) {
      int var3 = 0;
      byte var4 = 0;
      if(var1 == 39 && this.a((hj$a)hj$a.d)) {
         return this.V();
      } else {
         if(!this.a((hj$a)hj$a.c)) {
            this.b(var1, "was expecting double-quote to start field name");
         }

         int[] var8 = sk.c();
         int var5 = var8.length;
         boolean var7;
         if(var1 < var5) {
            if(var8[var1] == 0 && (var1 < 48 || var1 > 57)) {
               var7 = true;
            } else {
               var7 = false;
            }
         } else {
            var7 = Character.isJavaIdentifierPart((char)var1);
         }

         if(!var7) {
            this.b(var1, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
         }

         int var2 = this.f;
         int var6 = this.g;
         var1 = var2;
         if(var2 < var6) {
            var1 = var4;

            int var10;
            do {
               char var9 = this.J[var2];
               if(var9 < var5) {
                  if(var8[var9] != 0) {
                     var3 = this.f - 1;
                     this.f = var2;
                     return this.L.a(this.J, var3, var2 - var3, var1);
                  }
               } else if(!Character.isJavaIdentifierPart((char)var9)) {
                  var3 = this.f - 1;
                  this.f = var2;
                  return this.L.a(this.J, var3, var2 - var3, var1);
               }

               var3 = var1 * 31 + var9;
               var10 = var2 + 1;
               var2 = var10;
               var1 = var3;
            } while(var10 < var6);

            var1 = var10;
         }

         var2 = this.f;
         this.f = var1;
         return this.a(var2 - 1, var3, var8);
      }
   }

   protected final hm g(int var1) {
      switch(var1) {
      case 39:
         if(this.a((hj$a)hj$a.d)) {
            return this.W();
         }
         break;
      case 43:
         if(this.f >= this.g && !this.E()) {
            this.T();
         }

         char[] var2 = this.J;
         var1 = this.f;
         this.f = var1 + 1;
         return this.a(var2[var1], false);
      case 78:
         this.a("NaN", 1);
         if(this.a((hj$a)hj$a.h)) {
            return this.a("NaN", Double.NaN);
         }

         this.d("Non-standard token \'NaN\': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      }

      this.b(var1, "expected a valid value (number, String, array, object, \'true\', \'false\' or \'null\')");
      return null;
   }

   public final String k() {
      hm var1 = this.b;
      if(var1 == hm.h) {
         if(this.M) {
            this.M = false;
            this.X();
         }

         return this.p.f();
      } else {
         return this.a(var1);
      }
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
            if(this.M) {
               this.M = false;
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
            if(this.M) {
               this.M = false;
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
            if(this.M) {
               this.M = false;
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
