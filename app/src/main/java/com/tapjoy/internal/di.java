package com.tapjoy.internal;

import com.tapjoy.internal.dg;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.di$a;
import com.tapjoy.internal.dj;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dm;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.dq;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dx;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public final class di {
   private final byte[] a;
   private final boolean b;
   private int c;
   private int d;
   private int e;
   private final InputStream f;
   private int g;
   private boolean h = false;
   private int i;
   private int j = Integer.MAX_VALUE;
   private int k;
   private int l = 64;
   private int m = 67108864;
   private di$a n = null;

   di(InputStream var1) {
      this.a = new byte[4096];
      this.c = 0;
      this.e = 0;
      this.i = 0;
      this.f = var1;
      this.b = false;
   }

   private di(byte[] var1, int var2) {
      this.a = var1;
      this.c = var2 + 0;
      this.e = 0;
      this.i = 0;
      this.f = null;
      this.b = false;
   }

   public static di a(byte[] var0, int var1) {
      di var3 = new di(var0, var1);

      try {
         var3.b(var1);
         return var3;
      } catch (dn var2) {
         throw new IllegalArgumentException(var2);
      }
   }

   private int b(int var1) {
      if(var1 < 0) {
         throw dn.b();
      } else {
         var1 += this.i + this.e;
         int var2 = this.j;
         if(var1 > var2) {
            throw dn.a();
         } else {
            this.j = var1;
            this.h();
            return var2;
         }
      }
   }

   private void c(int var1) {
      if(!this.d(var1)) {
         throw dn.a();
      }
   }

   private boolean d(int var1) {
      while(this.e + var1 > this.c) {
         if(this.i + this.e + var1 <= this.j) {
            if(this.n != null) {
               di$a var3 = this.n;
            }

            if(this.f != null) {
               int var2 = this.e;
               if(var2 > 0) {
                  if(this.c > var2) {
                     System.arraycopy(this.a, var2, this.a, 0, this.c - var2);
                  }

                  this.i += var2;
                  this.c -= var2;
                  this.e = 0;
               }

               var2 = this.f.read(this.a, this.c, this.a.length - this.c);
               if(var2 == 0 || var2 < -1 || var2 > this.a.length) {
                  throw new IllegalStateException((new StringBuilder(102)).append("InputStream#read(byte[]) returned invalid result: ").append(var2).append("\nThe InputStream implementation is buggy.").toString());
               }

               if(var2 > 0) {
                  this.c += var2;
                  if(this.i + var1 - this.m > 0) {
                     throw dn.h();
                  }

                  this.h();
                  if(this.c < var1) {
                     continue;
                  }

                  return true;
               }
            }
         }

         return false;
      }

      throw new IllegalStateException((new StringBuilder(77)).append("refillBuffer() called when ").append(var1).append(" bytes were already available in buffer").toString());
   }

   private byte[] e(int var1) {
      if(var1 <= 0) {
         if(var1 == 0) {
            return dm.a;
         } else {
            throw dn.b();
         }
      } else if(this.i + this.e + var1 > this.j) {
         this.f(this.j - this.i - this.e);
         throw dn.a();
      } else {
         int var2;
         byte[] var7;
         if(var1 < 4096) {
            var7 = new byte[var1];
            var2 = this.c - this.e;
            System.arraycopy(this.a, this.e, var7, 0, var2);
            this.e = this.c;
            var1 -= var2;
            if(this.c - this.e < var1) {
               this.c(var1);
            }

            System.arraycopy(this.a, 0, var7, var2, var1);
            this.e = var1;
            return var7;
         } else {
            int var5 = this.e;
            int var6 = this.c;
            this.i += this.c;
            this.e = 0;
            this.c = 0;
            ArrayList var8 = new ArrayList();

            int var3;
            for(var2 = var1 - (var6 - var5); var2 > 0; var2 -= var3) {
               var7 = new byte[Math.min(var2, 4096)];

               int var4;
               for(var3 = 0; var3 < var7.length; var3 += var4) {
                  if(this.f == null) {
                     var4 = -1;
                  } else {
                     var4 = this.f.read(var7, var3, var7.length - var3);
                  }

                  if(var4 == -1) {
                     throw dn.a();
                  }

                  this.i += var4;
               }

               var3 = var7.length;
               var8.add(var7);
            }

            var7 = new byte[var1];
            var1 = var6 - var5;
            System.arraycopy(this.a, var5, var7, 0, var1);

            byte[] var9;
            for(Iterator var10 = var8.iterator(); var10.hasNext(); var1 += var9.length) {
               var9 = (byte[])var10.next();
               System.arraycopy(var9, 0, var7, var1, var9.length);
            }

            return var7;
         }
      }
   }

   private void f(int var1) {
      if(var1 <= this.c - this.e && var1 >= 0) {
         this.e += var1;
      } else if(var1 < 0) {
         throw dn.b();
      } else if(this.i + this.e + var1 > this.j) {
         this.f(this.j - this.i - this.e);
         throw dn.a();
      } else {
         int var2 = this.c - this.e;
         this.e = this.c;
         this.c(1);

         while(var1 - var2 > this.c) {
            var2 += this.c;
            this.e = this.c;
            this.c(1);
         }

         this.e = var1 - var2;
      }
   }

   private long g() {
      long var3 = 0L;

      for(int var1 = 0; var1 < 64; var1 += 7) {
         if(this.e == this.c) {
            this.c(1);
         }

         byte[] var5 = this.a;
         int var2 = this.e;
         this.e = var2 + 1;
         byte var6 = var5[var2];
         var3 |= (long)(var6 & 127) << var1;
         if((var6 & 128) == 0) {
            return var3;
         }
      }

      throw dn.c();
   }

   private void h() {
      this.c += this.d;
      int var1 = this.i + this.c;
      if(var1 > this.j) {
         this.d = var1 - this.j;
         this.c -= this.d;
      } else {
         this.d = 0;
      }
   }

   public final int a() {
      boolean var1 = true;
      if(this.e != this.c || this.d(1)) {
         var1 = false;
      }

      if(var1) {
         this.g = 0;
         return 0;
      } else {
         this.g = this.d();
         if(dx.b(this.g) == 0) {
            throw dn.d();
         } else {
            return this.g;
         }
      }
   }

   public final dq a(ds var1, dk var2) {
      int var3 = this.d();
      if(this.k >= this.l) {
         throw dn.g();
      } else {
         var3 = this.b(var3);
         ++this.k;
         dq var4 = (dq)var1.a(this, var2);
         this.a(0);
         --this.k;
         this.j = var3;
         this.h();
         return var4;
      }
   }

   public final void a(int var1) {
      if(this.g != var1) {
         throw dn.e();
      }
   }

   public final boolean a(int var1, dj var2) {
      int var3;
      long var7;
      switch(dx.a(var1)) {
      case 0:
         var7 = this.e();
         var2.e(var1);
         var2.a(var7);
         return true;
      case 1:
         var7 = this.f();
         var2.e(var1);
         var2.b(var7);
         return true;
      case 2:
         dh var11 = this.c();
         var2.e(var1);
         var2.a(var11);
         return true;
      case 3:
         var2.e(var1);

         do {
            var3 = this.a();
         } while(var3 != 0 && this.a(var3, var2));

         var1 = dx.a(dx.b(var1), 4);
         this.a(var1);
         var2.e(var1);
         return true;
      case 4:
         return false;
      case 5:
         int var4 = this.e;
         var3 = var4;
         if(this.c - var4 < 4) {
            this.c(4);
            var3 = this.e;
         }

         byte[] var9 = this.a;
         this.e = var3 + 4;
         byte var10 = var9[var3];
         byte var5 = var9[var3 + 1];
         byte var6 = var9[var3 + 2];
         var3 = (var9[var3 + 3] & 255) << 24 | var10 & 255 | (var5 & 255) << 8 | (var6 & 255) << 16;
         var2.e(var1);
         var2.c(var3 & 255);
         var2.c(var3 >> 8 & 255);
         var2.c(var3 >> 16 & 255);
         var2.c(var3 >> 24 & 255);
         return true;
      default:
         throw dn.f();
      }
   }

   public final long b() {
      return this.e();
   }

   public final dh c() {
      int var1 = this.d();
      if(var1 <= this.c - this.e && var1 > 0) {
         Object var2;
         if(this.b && this.h) {
            var2 = new dg(this.a, this.e, var1);
         } else {
            var2 = dh.a(this.a, this.e, var1);
         }

         this.e += var1;
         return (dh)var2;
      } else {
         return (dh)(var1 == 0?dh.a:new dp(this.e(var1)));
      }
   }

   public final int d() {
      int var1 = this.e;
      if(this.c != var1) {
         byte[] var6 = this.a;
         int var2 = var1 + 1;
         byte var3 = var6[var1];
         if(var3 >= 0) {
            this.e = var2;
            return var3;
         }

         if(this.c - var2 >= 9) {
            var1 = var2 + 1;
            int var8 = var3 ^ var6[var2] << 7;
            if((long)var8 < 0L) {
               var2 = (int)((long)var8 ^ -128L);
            } else {
               var2 = var1 + 1;
               var8 ^= var6[var1] << 14;
               if((long)var8 >= 0L) {
                  var8 = (int)((long)var8 ^ 16256L);
                  var1 = var2;
                  var2 = var8;
               } else {
                  var1 = var2 + 1;
                  var8 ^= var6[var2] << 21;
                  if((long)var8 < 0L) {
                     var2 = (int)((long)var8 ^ -2080896L);
                  } else {
                     label54: {
                        int var4 = var1 + 1;
                        byte var7 = var6[var1];
                        var8 = (int)((long)(var8 ^ var7 << 28) ^ 266354560L);
                        var1 = var4;
                        if(var7 < 0) {
                           int var5 = var4 + 1;
                           var2 = var8;
                           var1 = var5;
                           if(var6[var4] >= 0) {
                              break label54;
                           }

                           var4 = var5 + 1;
                           var1 = var4;
                           if(var6[var5] < 0) {
                              var5 = var4 + 1;
                              var2 = var8;
                              var1 = var5;
                              if(var6[var4] >= 0) {
                                 break label54;
                              }

                              var4 = var5 + 1;
                              var1 = var4;
                              if(var6[var5] < 0) {
                                 var1 = var4 + 1;
                                 var2 = var8;
                                 if(var6[var4] < 0) {
                                    return (int)this.g();
                                 }
                                 break label54;
                              }
                           }
                        }

                        var2 = var8;
                     }
                  }
               }
            }

            this.e = var1;
            return var2;
         }
      }

      return (int)this.g();
   }

   public final long e() {
      int var1 = this.e;
      if(this.c != var1) {
         byte[] var6 = this.a;
         int var2 = var1 + 1;
         byte var3 = var6[var1];
         if(var3 >= 0) {
            this.e = var2;
            return (long)var3;
         }

         if(this.c - var2 >= 9) {
            var1 = var2 + 1;
            long var4 = (long)(var3 ^ var6[var2] << 7);
            if(var4 < 0L) {
               var4 ^= -128L;
            } else {
               var2 = var1 + 1;
               var4 ^= (long)(var6[var1] << 14);
               if(var4 >= 0L) {
                  var4 ^= 16256L;
                  var1 = var2;
               } else {
                  var1 = var2 + 1;
                  var4 ^= (long)(var6[var2] << 21);
                  if(var4 < 0L) {
                     var4 ^= -2080896L;
                  } else {
                     var2 = var1 + 1;
                     var4 ^= (long)var6[var1] << 28;
                     if(var4 >= 0L) {
                        var4 ^= 266354560L;
                        var1 = var2;
                     } else {
                        var1 = var2 + 1;
                        var4 ^= (long)var6[var2] << 35;
                        if(var4 < 0L) {
                           var4 ^= -34093383808L;
                        } else {
                           var2 = var1 + 1;
                           var4 ^= (long)var6[var1] << 42;
                           if(var4 >= 0L) {
                              var4 ^= 4363953127296L;
                              var1 = var2;
                           } else {
                              var1 = var2 + 1;
                              var4 ^= (long)var6[var2] << 49;
                              if(var4 < 0L) {
                                 var4 ^= -558586000294016L;
                              } else {
                                 var2 = var1 + 1;
                                 var4 = var4 ^ (long)var6[var1] << 56 ^ 71499008037633920L;
                                 if(var4 < 0L) {
                                    var1 = var2 + 1;
                                    if((long)var6[var2] < 0L) {
                                       return this.g();
                                    }
                                 } else {
                                    var1 = var2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            this.e = var1;
            return var4;
         }
      }

      return this.g();
   }

   public final long f() {
      int var2 = this.e;
      int var1 = var2;
      if(this.c - var2 < 8) {
         this.c(8);
         var1 = this.e;
      }

      byte[] var17 = this.a;
      this.e = var1 + 8;
      long var3 = (long)var17[var1];
      long var5 = (long)var17[var1 + 1];
      long var7 = (long)var17[var1 + 2];
      long var9 = (long)var17[var1 + 3];
      long var11 = (long)var17[var1 + 4];
      long var13 = (long)var17[var1 + 5];
      long var15 = (long)var17[var1 + 6];
      return ((long)var17[var1 + 7] & 255L) << 56 | var3 & 255L | (var5 & 255L) << 8 | (var7 & 255L) << 16 | (var9 & 255L) << 24 | (var11 & 255L) << 32 | (var13 & 255L) << 40 | (var15 & 255L) << 48;
   }
}
