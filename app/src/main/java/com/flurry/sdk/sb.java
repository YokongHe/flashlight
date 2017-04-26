package com.flurry.sdk;

import com.flurry.sdk.sb$a;
import com.flurry.sdk.sm;
import java.util.Arrays;

public final class sb {
   static final sb a = new sb();
   protected sb b;
   protected final boolean c;
   protected final boolean d;
   protected String[] e;
   protected sb$a[] f;
   protected int g;
   protected int h;
   protected int i;
   protected boolean j;

   private sb() {
      this.d = true;
      this.c = true;
      this.j = true;
      this.a(64);
   }

   private sb(sb var1, boolean var2, boolean var3, String[] var4, sb$a[] var5, int var6) {
      this.b = var1;
      this.d = var2;
      this.c = var3;
      this.e = var4;
      this.f = var5;
      this.g = var6;
      var6 = var4.length;
      this.h = var6 - (var6 >> 2);
      this.i = var6 - 1;
      this.j = false;
   }

   public static int a(String var0) {
      int var2 = var0.charAt(0);
      int var1 = 1;

      for(int var3 = var0.length(); var1 < var3; ++var1) {
         var2 = var2 * 31 + var0.charAt(var1);
      }

      return var2;
   }

   public static int a(char[] var0, int var1, int var2) {
      int var3 = var0[0];

      for(var1 = 1; var1 < var2; ++var1) {
         var3 = var3 * 31 + var0[var1];
      }

      return var3;
   }

   public static sb a() {
      return a.e();
   }

   private void a(int var1) {
      this.e = new String[var1];
      this.f = new sb$a[var1 >> 1];
      this.i = var1 - 1;
      this.g = 0;
      this.h = var1 - (var1 >> 2);
   }

   private void a(sb param1) {
      // $FF: Couldn't be decompiled
   }

   private sb e() {
      return new sb((sb)null, true, true, this.e, this.f, this.g);
   }

   private void f() {
      String[] var2 = this.e;
      int var1 = var2.length;
      this.e = new String[var1];
      System.arraycopy(var2, 0, this.e, 0, var1);
      sb$a[] var3 = this.f;
      var1 = var3.length;
      this.f = new sb$a[var1];
      System.arraycopy(var3, 0, this.f, 0, var1);
   }

   private void g() {
      int var4 = this.e.length;
      int var1 = var4 + var4;
      if(var1 > 65536) {
         this.g = 0;
         Arrays.fill(this.e, (Object)null);
         Arrays.fill(this.f, (Object)null);
         this.j = true;
      } else {
         String[] var5 = this.e;
         sb$a[] var6 = this.f;
         this.e = new String[var1];
         this.f = new sb$a[var1 >> 1];
         this.i = var1 - 1;
         this.h += this.h;
         int var2 = 0;

         int var3;
         String var7;
         for(var1 = 0; var2 < var4; var1 = var3) {
            var7 = var5[var2];
            var3 = var1;
            if(var7 != null) {
               var3 = var1 + 1;
               var1 = a(var7) & this.i;
               if(this.e[var1] == null) {
                  this.e[var1] = var7;
               } else {
                  var1 >>= 1;
                  this.f[var1] = new sb$a(var7, this.f[var1]);
               }
            }

            ++var2;
         }

         byte var8 = 0;
         var2 = var1;

         for(var1 = var8; var1 < var4 >> 1; ++var1) {
            for(sb$a var9 = var6[var1]; var9 != null; ++var2) {
               var7 = var9.a();
               var3 = a(var7) & this.i;
               if(this.e[var3] == null) {
                  this.e[var3] = var7;
               } else {
                  var3 >>= 1;
                  this.f[var3] = new sb$a(var7, this.f[var3]);
               }

               var9 = var9.b();
            }
         }

         if(var2 != this.g) {
            throw new Error("Internal error on SymbolTable.rehash(): had " + this.g + " entries; now have " + var2 + ".");
         }
      }

   }

   public final sb a(boolean var1, boolean var2) {
      synchronized(this){}

      sb var3;
      try {
         var3 = new sb(this, var1, var2, this.e, this.f, this.g);
      } finally {
         ;
      }

      return var3;
   }

   public final String a(char[] var1, int var2, int var3, int var4) {
      if(var3 <= 0) {
         return "";
      } else if(!this.d) {
         return new String(var1, var2, var3);
      } else {
         int var5 = var4 & this.i;
         String var7 = this.e[var5];
         if(var7 != null) {
            if(var7.length() == var3) {
               var4 = 0;

               int var6;
               do {
                  var6 = var4;
                  if(var7.charAt(var4) != var1[var2 + var4]) {
                     break;
                  }

                  var6 = var4 + 1;
                  var4 = var6;
               } while(var6 < var3);

               if(var6 == var3) {
                  return var7;
               }
            }

            sb$a var9 = this.f[var5 >> 1];
            if(var9 != null) {
               var7 = var9.a(var1, var2, var3);
               if(var7 != null) {
                  return var7;
               }
            }
         }

         if(!this.j) {
            this.f();
            this.j = true;
            var4 = var5;
         } else if(this.g >= this.h) {
            this.g();
            var4 = a(var1, var2, var3) & this.i;
         } else {
            var4 = var5;
         }

         ++this.g;
         var7 = new String(var1, var2, var3);
         String var8 = var7;
         if(this.c) {
            var8 = sm.a.a(var7);
         }

         if(this.e[var4] == null) {
            this.e[var4] = var8;
            return var8;
         } else {
            var2 = var4 >> 1;
            this.f[var2] = new sb$a(var8, this.f[var2]);
            return var8;
         }
      }
   }

   public final void b() {
      if(this.d() && this.b != null) {
         this.b.a(this);
         this.j = false;
      }
   }

   public final int c() {
      return this.g;
   }

   public final boolean d() {
      return this.j;
   }
}
