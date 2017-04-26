package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.dp$a;
import com.tapjoy.internal.du;
import com.tapjoy.internal.dw;
import java.io.OutputStream;
import java.util.Iterator;

class dp extends dh {
   protected final byte[] c;
   private int d = 0;

   dp(byte[] var1) {
      this.c = var1;
   }

   public int a() {
      return this.c.length;
   }

   protected final int a(int var1, int var2, int var3) {
      var2 += this.b();
      byte[] var8 = this.c;
      int var6 = var2 + var3;
      if(var1 != 0) {
         if(var2 >= var6) {
            return var1;
         } else {
            byte var7 = (byte)var1;
            if(var7 < -32) {
               if(var7 >= -62) {
                  var1 = var2 + 1;
                  if(var8[var2] <= -65) {
                     return dw.a(var8, var1, var6);
                  }
               }

               return -1;
            } else {
               byte var9;
               if(var7 < -16) {
                  byte var12 = (byte)(~(var1 >> 8));
                  var9 = var12;
                  var3 = var2;
                  if(var12 == 0) {
                     var3 = var2 + 1;
                     var9 = var8[var2];
                     if(var3 >= var6) {
                        return dw.a(var7, var9);
                     }
                  }

                  if(var9 <= -65 && (var7 != -32 || var9 >= -96) && (var7 != -19 || var9 < -96)) {
                     var1 = var3 + 1;
                     if(var8[var3] <= -65) {
                        return dw.a(var8, var1, var6);
                     }
                  }

                  return -1;
               } else {
                  byte var10 = (byte)(~(var1 >> 8));
                  byte var4 = 0;
                  if(var10 == 0) {
                     int var5 = var2 + 1;
                     var10 = var8[var2];
                     if(var5 >= var6) {
                        return dw.a(var7, var10);
                     }

                     var9 = var4;
                     var2 = var5;
                  } else {
                     var9 = (byte)(var1 >> 16);
                  }

                  if(var9 == 0) {
                     int var11 = var2 + 1;
                     byte var13 = var8[var2];
                     var9 = var13;
                     var2 = var11;
                     if(var11 >= var6) {
                        return dw.a(var7, var10, var13);
                     }
                  }

                  if(var10 <= -65 && (var7 << 28) + var10 + 112 >> 30 == 0 && var9 <= -65) {
                     var1 = var2 + 1;
                     if(var8[var2] <= -65) {
                        return dw.a(var8, var1, var6);
                     }
                  }

                  return -1;
               }
            }
         }
      } else {
         var1 = var2;
         return dw.a(var8, var1, var6);
      }
   }

   protected void a(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.c, var2, var1, var3, var4);
   }

   final boolean a(dp var1, int var2, int var3) {
      if(var3 > var1.a()) {
         var2 = this.a();
         throw new IllegalArgumentException((new StringBuilder(40)).append("Length too large: ").append(var3).append(var2).toString());
      } else {
         int var4;
         if(var2 + var3 > var1.a()) {
            var4 = var1.a();
            throw new IllegalArgumentException((new StringBuilder(59)).append("Ran off end of other: ").append(var2).append(", ").append(var3).append(", ").append(var4).toString());
         } else {
            byte[] var6 = this.c;
            byte[] var7 = var1.c;
            int var5 = this.b();
            var4 = this.b();

            for(var2 += var1.b(); var4 < var5 + var3; ++var2) {
               if(var6[var4] != var7[var2]) {
                  return false;
               }

               ++var4;
            }

            return true;
         }
      }
   }

   protected int b() {
      return 0;
   }

   protected final int b(int var1, int var2, int var3) {
      byte[] var5 = this.c;
      int var4 = this.b() + var2;

      for(var2 = var4; var2 < var4 + var3; ++var2) {
         var1 = var1 * 31 + var5[var2];
      }

      return var1;
   }

   public final String b(String var1) {
      return new String(this.c, this.b(), this.a(), var1);
   }

   final void b(OutputStream var1, int var2, int var3) {
      var1.write(this.c, this.b() + var2, var3);
   }

   public dh$a c() {
      return new dp$a(this, (byte)0);
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof dh)) {
         return false;
      } else if(this.a() != ((dh)var1).a()) {
         return false;
      } else if(this.a() == 0) {
         return true;
      } else if(var1 instanceof dp) {
         return this.a((dp)var1, 0, this.a());
      } else if(var1 instanceof du) {
         return var1.equals(this);
      } else {
         String var2 = String.valueOf(String.valueOf(var1.getClass()));
         throw new IllegalArgumentException((new StringBuilder(var2.length() + 49)).append("Has a new type of ByteString been created? Found ").append(var2).toString());
      }
   }

   public final boolean g() {
      int var1 = this.b();
      return dw.a(this.c, var1, this.a() + var1) == 0;
   }

   public int hashCode() {
      int var2 = this.d;
      int var1 = var2;
      if(var2 == 0) {
         var1 = this.a();
         var2 = this.b(var1, 0, var1);
         var1 = var2;
         if(var2 == 0) {
            var1 = 1;
         }

         this.d = var1;
      }

      return var1;
   }

   protected final int i() {
      return 0;
   }

   // $FF: synthetic method
   public Iterator iterator() {
      return this.c();
   }

   protected final boolean j() {
      return true;
   }

   protected final int k() {
      return this.d;
   }
}
