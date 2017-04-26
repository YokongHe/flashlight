package com.flurry.sdk;

import com.flurry.sdk.ii;
import com.flurry.sdk.si;
import com.flurry.sdk.si$b;
import java.math.BigDecimal;
import java.util.ArrayList;

public final class sp {
   static final char[] a = new char[0];
   private final si b;
   private char[] c;
   private int d;
   private int e;
   private ArrayList f;
   private boolean g = false;
   private int h;
   private char[] i;
   private int j;
   private String k;
   private char[] l;

   public sp(si var1) {
      this.b = var1;
   }

   private final char[] b(int var1) {
      return this.b != null?this.b.a(si$b.c, var1):new char[Math.max(var1, 1000)];
   }

   private void c(int var1) {
      int var2 = this.e;
      this.e = 0;
      char[] var4 = this.c;
      this.c = null;
      int var3 = this.d;
      this.d = -1;
      var1 += var2;
      if(this.i == null || var1 > this.i.length) {
         this.i = this.b(var1);
      }

      if(var2 > 0) {
         System.arraycopy(var4, var3, this.i, 0, var2);
      }

      this.h = 0;
      this.j = var2;
   }

   private void d(int var1) {
      if(this.f == null) {
         this.f = new ArrayList();
      }

      char[] var4 = this.i;
      this.g = true;
      this.f.add(var4);
      this.h += var4.length;
      int var3 = var4.length;
      int var2 = var3 >> 1;
      if(var2 >= var1) {
         var1 = var2;
      }

      var4 = this.e(Math.min(262144, var3 + var1));
      this.j = 0;
      this.i = var4;
   }

   private final char[] e(int var1) {
      return new char[var1];
   }

   private final void o() {
      this.g = false;
      this.f.clear();
      this.h = 0;
      this.j = 0;
   }

   private char[] p() {
      if(this.k != null) {
         return this.k.toCharArray();
      } else {
         char[] var5;
         if(this.d >= 0) {
            if(this.e <= 0) {
               return a;
            } else {
               var5 = this.e(this.e);
               System.arraycopy(this.c, this.d, var5, 0, this.e);
               return var5;
            }
         } else {
            int var1 = this.c();
            if(var1 <= 0) {
               return a;
            } else {
               var5 = this.e(var1);
               if(this.f != null) {
                  int var3 = this.f.size();
                  int var2 = 0;

                  for(var1 = 0; var2 < var3; ++var2) {
                     char[] var6 = (char[])this.f.get(var2);
                     int var4 = var6.length;
                     System.arraycopy(var6, 0, var5, var1, var4);
                     var1 += var4;
                  }
               } else {
                  var1 = 0;
               }

               System.arraycopy(this.i, 0, var5, var1, this.j);
               return var5;
            }
         }
      }
   }

   public final void a() {
      if(this.b == null) {
         this.b();
      } else if(this.i != null) {
         this.b();
         char[] var1 = this.i;
         this.i = null;
         this.b.a(si$b.c, var1);
         return;
      }

   }

   public final void a(char var1) {
      if(this.d >= 0) {
         this.c(16);
      }

      this.k = null;
      this.l = null;
      char[] var4 = this.i;
      char[] var3 = var4;
      if(this.j >= var4.length) {
         this.d(1);
         var3 = this.i;
      }

      int var2 = this.j;
      this.j = var2 + 1;
      var3[var2] = var1;
   }

   public final void a(int var1) {
      this.j = var1;
   }

   public final void a(String var1) {
      this.c = null;
      this.d = -1;
      this.e = 0;
      this.k = var1;
      this.l = null;
      if(this.g) {
         this.o();
      }

      this.j = 0;
   }

   public final void a(String var1, int var2, int var3) {
      if(this.d >= 0) {
         this.c(var3);
      }

      this.k = null;
      this.l = null;
      char[] var7 = this.i;
      int var6 = var7.length - this.j;
      if(var6 >= var3) {
         var1.getChars(var2, var2 + var3, var7, this.j);
         this.j += var3;
      } else {
         int var5 = var2;
         int var4 = var3;
         if(var6 > 0) {
            var1.getChars(var2, var2 + var6, var7, this.j);
            var4 = var3 - var6;
            var5 = var2 + var6;
         }

         this.d(var4);
         var1.getChars(var5, var5 + var4, this.i, 0);
         this.j = var4;
      }
   }

   public final void a(char[] var1, int var2, int var3) {
      this.k = null;
      this.l = null;
      this.c = var1;
      this.d = var2;
      this.e = var3;
      if(this.g) {
         this.o();
      }

   }

   public final void b() {
      this.d = -1;
      this.j = 0;
      this.e = 0;
      this.c = null;
      this.k = null;
      this.l = null;
      if(this.g) {
         this.o();
      }

   }

   public final void b(char[] var1, int var2, int var3) {
      this.c = null;
      this.d = -1;
      this.e = 0;
      this.k = null;
      this.l = null;
      if(this.g) {
         this.o();
      } else if(this.i == null) {
         this.i = this.b(var3);
      }

      this.h = 0;
      this.j = 0;
      this.c(var1, var2, var3);
   }

   public final int c() {
      return this.d >= 0?this.e:(this.l != null?this.l.length:(this.k != null?this.k.length():this.h + this.j));
   }

   public final void c(char[] var1, int var2, int var3) {
      if(this.d >= 0) {
         this.c(var3);
      }

      this.k = null;
      this.l = null;
      char[] var7 = this.i;
      int var6 = var7.length - this.j;
      if(var6 >= var3) {
         System.arraycopy(var1, var2, var7, this.j, var3);
         this.j += var3;
      } else {
         int var5 = var2;
         int var4 = var3;
         if(var6 > 0) {
            System.arraycopy(var1, var2, var7, this.j, var6);
            var5 = var2 + var6;
            var4 = var3 - var6;
         }

         this.d(var4);
         System.arraycopy(var1, var5, this.i, 0, var4);
         this.j = var4;
      }
   }

   public final int d() {
      return this.d >= 0?this.d:0;
   }

   public final char[] e() {
      if(this.d >= 0) {
         return this.c;
      } else if(this.l != null) {
         return this.l;
      } else if(this.k != null) {
         char[] var1 = this.k.toCharArray();
         this.l = var1;
         return var1;
      } else {
         return !this.g?this.i:this.g();
      }
   }

   public final String f() {
      if(this.k == null) {
         if(this.l != null) {
            this.k = new String(this.l);
         } else if(this.d >= 0) {
            if(this.e <= 0) {
               this.k = "";
               return "";
            }

            this.k = new String(this.c, this.d, this.e);
         } else {
            int var1 = this.h;
            int var2 = this.j;
            if(var1 == 0) {
               String var3;
               if(var2 == 0) {
                  var3 = "";
               } else {
                  var3 = new String(this.i, 0, var2);
               }

               this.k = var3;
            } else {
               StringBuilder var5 = new StringBuilder(var1 + var2);
               if(this.f != null) {
                  var2 = this.f.size();

                  for(var1 = 0; var1 < var2; ++var1) {
                     char[] var4 = (char[])this.f.get(var1);
                     var5.append(var4, 0, var4.length);
                  }
               }

               var5.append(this.i, 0, this.j);
               this.k = var5.toString();
            }
         }
      }

      return this.k;
   }

   public final char[] g() {
      char[] var2 = this.l;
      char[] var1 = var2;
      if(var2 == null) {
         var1 = this.p();
         this.l = var1;
      }

      return var1;
   }

   public final BigDecimal h() {
      return this.l != null?new BigDecimal(this.l):(this.d >= 0?new BigDecimal(this.c, this.d, this.e):(this.h == 0?new BigDecimal(this.i, 0, this.j):new BigDecimal(this.g())));
   }

   public final double i() {
      return ii.c(this.f());
   }

   public final char[] j() {
      if(this.d >= 0) {
         this.c(1);
      } else {
         char[] var1 = this.i;
         if(var1 == null) {
            this.i = this.b(0);
         } else if(this.j >= var1.length) {
            this.d(1);
         }
      }

      return this.i;
   }

   public final char[] k() {
      this.d = -1;
      this.j = 0;
      this.e = 0;
      this.c = null;
      this.k = null;
      this.l = null;
      if(this.g) {
         this.o();
      }

      char[] var2 = this.i;
      char[] var1 = var2;
      if(var2 == null) {
         var1 = this.b(0);
         this.i = var1;
      }

      return var1;
   }

   public final int l() {
      return this.j;
   }

   public final char[] m() {
      if(this.f == null) {
         this.f = new ArrayList();
      }

      this.g = true;
      this.f.add(this.i);
      int var1 = this.i.length;
      this.h += var1;
      char[] var2 = this.e(Math.min(var1 + (var1 >> 1), 262144));
      this.j = 0;
      this.i = var2;
      return var2;
   }

   public final char[] n() {
      char[] var3 = this.i;
      int var2 = var3.length;
      int var1;
      if(var2 == 262144) {
         var1 = 262145;
      } else {
         var1 = Math.min(262144, (var2 >> 1) + var2);
      }

      this.i = this.e(var1);
      System.arraycopy(var3, 0, this.i, 0, var2);
      return this.i;
   }

   public final String toString() {
      return this.f();
   }
}
