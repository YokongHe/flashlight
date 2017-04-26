package com.flurry.sdk;

import com.flurry.sdk.sa$a;
import com.flurry.sdk.sc;
import com.flurry.sdk.sd;
import com.flurry.sdk.se;
import com.flurry.sdk.sf;
import com.flurry.sdk.sg;
import com.flurry.sdk.sm;
import java.util.Arrays;

public final class sa {
   final sa a;
   final boolean b;
   private int c;
   private int d;
   private int[] e;
   private sc[] f;
   private sa$a[] g;
   private int h;
   private int i;
   private transient boolean j;
   private boolean k;
   private boolean l;
   private boolean m;

   private sa(int var1, boolean var2) {
      byte var4 = 16;
      super();
      this.a = null;
      this.b = var2;
      int var3;
      if(var1 < 16) {
         var3 = 16;
      } else {
         var3 = var1;
         if((var1 - 1 & var1) != 0) {
            for(var3 = var4; var3 < var1; var3 += var3) {
               ;
            }
         }
      }

      this.c(var3);
   }

   private sa(sa var1, boolean var2) {
      this.a = var1;
      this.b = var2;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = false;
      this.k = true;
      this.l = true;
      this.m = true;
   }

   public static sa a() {
      return new sa(64, true);
   }

   private static sc a(int var0, String var1, int[] var2, int var3) {
      if(var3 < 4) {
         switch(var3) {
         case 1:
            return new sd(var1, var0, var2[0]);
         case 2:
            return new se(var1, var0, var2[0], var2[1]);
         case 3:
            return new sf(var1, var0, var2[0], var2[1], var2[2]);
         }
      }

      int[] var5 = new int[var3];

      for(int var4 = 0; var4 < var3; ++var4) {
         var5[var4] = var2[var4];
      }

      return new sg(var1, var0, var5, var3);
   }

   private void a(int var1, sc var2) {
      if(this.k) {
         this.j();
      }

      if(this.j) {
         this.g();
      }

      ++this.c;
      int var4 = var1 & this.d;
      int var3;
      if(this.f[var4] == null) {
         this.e[var4] = var1 << 8;
         if(this.l) {
            this.l();
         }

         this.f[var4] = var2;
      } else {
         if(this.m) {
            this.k();
         }

         ++this.h;
         int var5 = this.e[var4];
         var1 = var5 & 255;
         if(var1 == 0) {
            if(this.i <= 254) {
               var3 = this.i++;
               var1 = var3;
               if(var3 >= this.g.length) {
                  this.m();
                  var1 = var3;
               }
            } else {
               var1 = this.i();
            }

            this.e[var4] = var5 & -256 | var1 + 1;
         } else {
            --var1;
         }

         this.g[var1] = new sa$a(var2, this.g[var1]);
      }

      var1 = this.e.length;
      if(this.c > var1 >> 1) {
         var3 = var1 >> 2;
         if(this.c > var1 - var3) {
            this.j = true;
         } else if(this.h >= var3) {
            this.j = true;
            return;
         }
      }

   }

   private void a(sa param1) {
      // $FF: Couldn't be decompiled
   }

   public static final int b(int var0) {
      var0 ^= var0 >>> 16;
      return var0 ^ var0 >>> 8;
   }

   public static final int b(int var0, int var1) {
      var0 = var0 * 31 + var1;
      var0 ^= var0 >>> 16;
      return var0 ^ var0 >>> 8;
   }

   public static final int b(int[] var0, int var1) {
      int var3 = var0[0];

      for(int var2 = 1; var2 < var1; ++var2) {
         var3 = var3 * 31 + var0[var2];
      }

      var1 = var3 >>> 16 ^ var3;
      return var1 ^ var1 >>> 8;
   }

   private void c(int var1) {
      this.c = 0;
      this.e = new int[var1];
      this.f = new sc[var1];
      this.k = false;
      this.l = false;
      this.d = var1 - 1;
      this.m = true;
      this.g = null;
      this.i = 0;
      this.j = false;
   }

   public static sc e() {
      return sd.b();
   }

   private void f() {
      this.k = true;
      this.l = true;
      this.m = true;
   }

   private void g() {
      byte var4 = 0;
      this.j = false;
      this.l = false;
      int var5 = this.e.length;
      int var1 = var5 + var5;
      if(var1 > 65536) {
         this.h();
      } else {
         this.e = new int[var1];
         this.d = var1 - 1;
         sc[] var8 = this.f;
         this.f = new sc[var1];
         int var2 = 0;

         int var3;
         int var6;
         for(var1 = 0; var2 < var5; var1 = var3) {
            sc var9 = var8[var2];
            var3 = var1;
            if(var9 != null) {
               var3 = var1 + 1;
               var1 = var9.hashCode();
               var6 = this.d & var1;
               this.f[var6] = var9;
               this.e[var6] = var1 << 8;
            }

            ++var2;
         }

         var5 = this.i;
         if(var5 != 0) {
            this.h = 0;
            this.i = 0;
            this.m = false;
            sa$a[] var13 = this.g;
            this.g = new sa$a[var13.length];

            for(var2 = var4; var2 < var5; ++var2) {
               for(sa$a var12 = var13[var2]; var12 != null; var1 = var3) {
                  var3 = var1 + 1;
                  sc var10 = var12.a;
                  var1 = var10.hashCode();
                  var6 = this.d & var1;
                  int var7 = this.e[var6];
                  if(this.f[var6] == null) {
                     this.e[var6] = var1 << 8;
                     this.f[var6] = var10;
                  } else {
                     ++this.h;
                     var1 = var7 & 255;
                     if(var1 == 0) {
                        if(this.i <= 254) {
                           int var11 = this.i++;
                           var1 = var11;
                           if(var11 >= this.g.length) {
                              this.m();
                              var1 = var11;
                           }
                        } else {
                           var1 = this.i();
                        }

                        this.e[var6] = var7 & -256 | var1 + 1;
                     } else {
                        --var1;
                     }

                     this.g[var1] = new sa$a(var10, this.g[var1]);
                  }

                  var12 = var12.b;
               }
            }

            if(var1 != this.c) {
               throw new RuntimeException("Internal error: count after rehash " + var1 + "; should be " + this.c);
            }
         }
      }

   }

   private void h() {
      this.c = 0;
      Arrays.fill(this.e, 0);
      Arrays.fill(this.f, (Object)null);
      Arrays.fill(this.g, (Object)null);
      this.h = 0;
      this.i = 0;
   }

   private int i() {
      sa$a[] var6 = this.g;
      int var2 = Integer.MAX_VALUE;
      int var3 = -1;
      int var1 = 0;

      for(int var5 = this.i; var1 < var5; ++var1) {
         int var4 = var6[var1].a();
         if(var4 < var2) {
            if(var4 == 1) {
               return var1;
            }

            var3 = var1;
            var2 = var4;
         }
      }

      return var3;
   }

   private void j() {
      int[] var2 = this.e;
      int var1 = this.e.length;
      this.e = new int[var1];
      System.arraycopy(var2, 0, this.e, 0, var1);
      this.k = false;
   }

   private void k() {
      sa$a[] var2 = this.g;
      if(var2 == null) {
         this.g = new sa$a[32];
      } else {
         int var1 = var2.length;
         this.g = new sa$a[var1];
         System.arraycopy(var2, 0, this.g, 0, var1);
      }

      this.m = false;
   }

   private void l() {
      sc[] var2 = this.f;
      int var1 = var2.length;
      this.f = new sc[var1];
      System.arraycopy(var2, 0, this.f, 0, var1);
      this.l = false;
   }

   private void m() {
      sa$a[] var2 = this.g;
      int var1 = var2.length;
      this.g = new sa$a[var1 + var1];
      System.arraycopy(var2, 0, this.g, 0, var1);
   }

   public final sa a(boolean var1, boolean var2) {
      synchronized(this){}

      sa var3;
      try {
         var3 = new sa(this, var2);
      } finally {
         ;
      }

      return var3;
   }

   public final sc a(int var1) {
      int var2 = b(var1);
      int var3 = this.d & var2;
      int var4 = this.e[var3];
      if((var4 >> 8 ^ var2) << 8 == 0) {
         sc var5 = this.f[var3];
         if(var5 == null) {
            return null;
         }

         if(var5.a(var1)) {
            return var5;
         }
      } else if(var4 == 0) {
         return null;
      }

      var3 = var4 & 255;
      if(var3 > 0) {
         sa$a var6 = this.g[var3 - 1];
         if(var6 != null) {
            return var6.a(var2, var1, 0);
         }
      }

      return null;
   }

   public final sc a(int var1, int var2) {
      int var3 = b(var1, var2);
      int var4 = this.d & var3;
      int var5 = this.e[var4];
      if((var5 >> 8 ^ var3) << 8 == 0) {
         sc var6 = this.f[var4];
         if(var6 == null) {
            return null;
         }

         if(var6.a(var1, var2)) {
            return var6;
         }
      } else if(var5 == 0) {
         return null;
      }

      var4 = var5 & 255;
      if(var4 > 0) {
         sa$a var7 = this.g[var4 - 1];
         if(var7 != null) {
            return var7.a(var3, var1, var2);
         }
      }

      return null;
   }

   public final sc a(String var1, int[] var2, int var3) {
      String var5 = var1;
      if(this.b) {
         var5 = sm.a.a(var1);
      }

      int var4 = b(var2, var3);
      sc var6 = a(var4, var5, var2, var3);
      this.a(var4, var6);
      return var6;
   }

   public final sc a(int[] var1, int var2) {
      int var3 = b(var1, var2);
      int var4 = this.d & var3;
      int var5 = this.e[var4];
      if((var5 >> 8 ^ var3) << 8 == 0) {
         sc var6 = this.f[var4];
         if(var6 == null || var6.a(var1, var2)) {
            return var6;
         }
      } else if(var5 == 0) {
         return null;
      }

      var4 = var5 & 255;
      if(var4 > 0) {
         sa$a var7 = this.g[var4 - 1];
         if(var7 != null) {
            return var7.a(var3, var1, var2);
         }
      }

      return null;
   }

   public final void b() {
      if(this.d() && this.a != null) {
         this.a.a(this);
         this.f();
      }

   }

   public final int c() {
      return this.c;
   }

   public final boolean d() {
      return !this.k;
   }
}
