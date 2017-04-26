package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.du$a;
import com.tapjoy.internal.du$b;
import com.tapjoy.internal.du$c;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

final class du extends dh {
   private static final int[] c;
   private final int d;
   private final dh e;
   private final dh f;
   private final int g;
   private final int h;
   private int i;

   static {
      int var0 = 1;
      ArrayList var3 = new ArrayList();
      int var1 = 1;

      while(true) {
         int var2 = var1;
         if(var0 <= 0) {
            var3.add(Integer.valueOf(Integer.MAX_VALUE));
            c = new int[var3.size()];

            for(var0 = 0; var0 < c.length; ++var0) {
               c[var0] = ((Integer)var3.get(var0)).intValue();
            }

            return;
         }

         var3.add(Integer.valueOf(var0));
         var1 = var0;
         var0 += var2;
      }
   }

   private du(dh var1, dh var2) {
      this.i = 0;
      this.e = var1;
      this.f = var2;
      this.g = var1.a();
      this.d = this.g + var2.a();
      this.h = Math.max(var1.i(), var2.i()) + 1;
   }

   // $FF: synthetic method
   du(dh var1, dh var2, byte var3) {
      this(var1, var2);
   }

   static dh a(dh var0, dh var1) {
      du var4;
      if(var0 instanceof du) {
         var4 = (du)var0;
      } else {
         var4 = null;
      }

      if(var1.a() == 0) {
         return var0;
      } else if(var0.a() == 0) {
         return var1;
      } else {
         int var2 = var0.a() + var1.a();
         if(var2 < 128) {
            return b(var0, var1);
         } else if(var4 != null && var4.f.a() + var1.a() < 128) {
            dp var7 = b(var4.f, var1);
            return new du(var4.e, var7);
         } else if(var4 != null && var4.e.i() > var4.f.i() && var4.h > var1.i()) {
            du var6 = new du(var4.f, var1);
            return new du(var4.e, var6);
         } else {
            int var3 = Math.max(var0.i(), var1.i());
            if(var2 >= c[var3 + 1]) {
               return new du(var0, var1);
            } else {
               du$a var8 = new du$a((byte)0);
               var8.a(var0);
               var8.a(var1);

               Object var5;
               for(var5 = (dh)var8.a.pop(); !var8.a.isEmpty(); var5 = new du((dh)var8.a.pop(), (dh)var5, (byte)0)) {
                  ;
               }

               return (dh)var5;
            }
         }
      }
   }

   // $FF: synthetic method
   static dh a(du var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static dh b(du var0) {
      return var0.f;
   }

   private static dp b(dh var0, dh var1) {
      int var2 = var0.a();
      int var3 = var1.a();
      byte[] var4 = new byte[var2 + var3];
      var0.b(var4, 0, 0, var2);
      var1.b(var4, 0, var2, var3);
      return new dp(var4);
   }

   // $FF: synthetic method
   static int[] b() {
      return c;
   }

   public final int a() {
      return this.d;
   }

   protected final int a(int var1, int var2, int var3) {
      if(var2 + var3 <= this.g) {
         return this.e.a(var1, var2, var3);
      } else if(var2 >= this.g) {
         return this.f.a(var1, var2 - this.g, var3);
      } else {
         int var4 = this.g - var2;
         var1 = this.e.a(var1, var2, var4);
         return this.f.a(var1, 0, var3 - var4);
      }
   }

   protected final void a(byte[] var1, int var2, int var3, int var4) {
      if(var2 + var4 <= this.g) {
         this.e.a(var1, var2, var3, var4);
      } else if(var2 >= this.g) {
         this.f.a(var1, var2 - this.g, var3, var4);
      } else {
         int var5 = this.g - var2;
         this.e.a(var1, var2, var3, var5);
         this.f.a(var1, 0, var3 + var5, var4 - var5);
      }
   }

   protected final int b(int var1, int var2, int var3) {
      if(var2 + var3 <= this.g) {
         return this.e.b(var1, var2, var3);
      } else if(var2 >= this.g) {
         return this.f.b(var1, var2 - this.g, var3);
      } else {
         int var4 = this.g - var2;
         var1 = this.e.b(var1, var2, var4);
         return this.f.b(var1, 0, var3 - var4);
      }
   }

   public final String b(String var1) {
      return new String(this.e(), var1);
   }

   final void b(OutputStream var1, int var2, int var3) {
      if(var2 + var3 <= this.g) {
         this.e.b(var1, var2, var3);
      } else if(var2 >= this.g) {
         this.f.b(var1, var2 - this.g, var3);
      } else {
         int var4 = this.g - var2;
         this.e.b(var1, var2, var4);
         this.f.b(var1, 0, var3 - var4);
      }
   }

   public final dh$a c() {
      return new du$c(this, (byte)0);
   }

   public final boolean equals(Object var1) {
      boolean var10 = false;
      boolean var8;
      if(var1 == this) {
         var8 = true;
      } else {
         var8 = var10;
         if(var1 instanceof dh) {
            dh var14 = (dh)var1;
            var8 = var10;
            if(this.d == var14.a()) {
               if(this.d == 0) {
                  return true;
               }

               int var2;
               if(this.i != 0) {
                  var2 = var14.k();
                  if(var2 != 0) {
                     var8 = var10;
                     if(this.i != var2) {
                        return var8;
                     }
                  }
               }

               du$b var12 = new du$b(this, (byte)0);
               dp var11 = (dp)var12.next();
               du$b var13 = new du$b(var14, (byte)0);
               dp var15 = (dp)var13.next();
               var2 = 0;
               int var3 = 0;
               int var4 = 0;

               while(true) {
                  int var7 = var11.a() - var3;
                  int var5 = var15.a() - var2;
                  int var6 = Math.min(var7, var5);
                  boolean var9;
                  if(var3 == 0) {
                     var9 = var11.a(var15, var2, var6);
                  } else {
                     var9 = var15.a(var11, var3, var6);
                  }

                  var8 = var10;
                  if(!var9) {
                     break;
                  }

                  var4 += var6;
                  if(var4 >= this.d) {
                     if(var4 == this.d) {
                        return true;
                     }

                     throw new IllegalStateException();
                  }

                  if(var6 == var7) {
                     var11 = (dp)var12.next();
                     var3 = 0;
                  } else {
                     var3 += var6;
                  }

                  if(var6 == var5) {
                     var15 = (dp)var13.next();
                     var2 = 0;
                  } else {
                     var2 += var6;
                  }
               }
            }
         }
      }

      return var8;
   }

   public final boolean g() {
      boolean var2 = false;
      int var1 = this.e.a(0, 0, this.g);
      if(this.f.a(var1, 0, this.f.a()) == 0) {
         var2 = true;
      }

      return var2;
   }

   public final int hashCode() {
      int var2 = this.i;
      int var1 = var2;
      if(var2 == 0) {
         var2 = this.b(this.d, 0, this.d);
         var1 = var2;
         if(var2 == 0) {
            var1 = 1;
         }

         this.i = var1;
      }

      return var1;
   }

   protected final int i() {
      return this.h;
   }

   // $FF: synthetic method
   public final Iterator iterator() {
      return this.c();
   }

   protected final boolean j() {
      return this.d >= c[this.h];
   }

   protected final int k() {
      return this.i;
   }
}
